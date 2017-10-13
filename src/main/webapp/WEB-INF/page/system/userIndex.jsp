<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <script language="javascript"> 
   function deleteAll(){
	 var selectuser = document.getElementsByName("userId");
	 console.log("===jctid ",jctId);
	 var flag = false;
     for(var i=0;i<selectuser.length;i++){
     	if(selectuser[i].checked){
     		
     		flag = true;
     	} 
     }
     if(!flag){
     	alert("没有选择执行操作的用户！不能执行该操作");
     	return false;
     }
     else{
     	var confirmflag = window.confirm("你确定执行批量删除吗？");
     	if(!confirmflag){
     		return false;
     	}
     	else{
     		document.Form2.action = "${pageContext.request.contextPath}/elecUserController/delete";
     		document.Form2.submit();
     		return true;
     	}
     }
   }
  //用户:全部选中/全部不选中
   function checkAllUser(user){
	  var selectuser = document.getElementsByName("userId");
      for(var i=0;i<selectuser.length;i++){
     	 selectuser[i].checked = user.checked;
      }
   }
  </script>

<HTML>
	<HEAD>
		<title>用户管理</title>		
		<LINK href="${pageContext.request.contextPath }/css/Style.css" type="text/css" rel="stylesheet">
		<script type="text/javascript" src="${pageContext.request.contextPath}/script/My97DatePicker/WdatePicker.js"></script>
		<script language="javascript" src="${pageContext.request.contextPath }/script/function.js"></script>
	</HEAD>
		
	<body >
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath }/elecUserController/userIndex" method="post" style="margin:0px;"> 
			<table cellspacing="1" cellpadding="0" width="90%" align="center" bgcolor="#f5fafe" border="0">
				<TR height=10><td></td></TR>
				<tr>
					<td class="ta_01" colspan="4" align="center" background="../images/b-info.gif">
						<font face="宋体" size="2"><strong>用户信息管理</strong></font>
					</td>
					
				</tr>
				<tr>
					<td class="ta_01" align="center" bgcolor="#f5fafe" height="22">
					姓名：</td>
					<td class="ta_01" >
						<input type="text" name="userName" size="21" value="" id="userName"/>
					</td>
					<td class="ta_01" align="center" bgcolor="#f5fafe" height="22">
					所属单位：</td>
					<td class="ta_01" >
						<select name="jctId" id="jctId" style="width:155px">
							<option value="">请选择</option>
							<c:forEach items="${jctUnitList}" var="jctUnitList">
								<option value=${jctUnitList.ddlcode}>${jctUnitList.ddlname }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgcolor="#f5fafe" height="22">
					入职时间：</td>
					<td class="ta_01" colspan="3">
						<input type="text" name="onDutyDateBegin" id="onDutyDateBegin" maxlength="50" size="20" onclick="WdatePicker()"/>
						~
						<input type="text" name="onDutyDateEnd" id="onDutyDateEnd" maxlength="50" size="20" onclick="WdatePicker()"/>
					</td>
				</tr>

		    </table>	
		</form>




		<form id="Form2" name="Form2" action="${pageContext.request.contextPath }/elecUserController/userIndex" method="post">
		<table cellSpacing="1" cellPadding="0" width="90%" align="center" bgColor="#f5fafe" border="0">
			<TBODY>
				<TR height=10><td></td></TR>			
				<tr>
				  	<td>
		                <TABLE style="WIDTH: 105px; HEIGHT: 20px" border="0">
										<TR>
											<TD align="center" background="${pageContext.request.contextPath }/images/cotNavGround.gif"><img src="${pageContext.request.contextPath }/images/yin.gif" width="15"></TD>
											<TD class="DropShadow" background="${pageContext.request.contextPath }/images/cotNavGround.gif">用户列表</TD>
										</TR>
			             </TABLE>
                   </td>
					<td class="ta_01" align="right">
					    <input style="font-size:12px; color:black; height=20;width=80" id="BT_Add" type="button" value="查询" name="BT_find" 
						 onclick="document.forms[0].submit()">&nbsp;&nbsp;
						<input style="font-size:12px; color:black; height=20;width=80" id="BT_Add" type="button" value="添加用户" name="BT_Add" 
						 onclick="openWindow('${pageContext.request.contextPath }/elecUserController/userAdd','700','400')">&nbsp;&nbsp;
						<input style="font-size:12px; color:black; height=20;width=80" id="BT_Delete" type="button" value="批量删除" name="BT_Delete" 
						 onclick="return deleteAll()">&nbsp;&nbsp;
					</td>
				</tr>
					
			<tr>
				<td class="ta_01" align="center" bgColor="#f5fafe" colspan="2">			
					
									
						<table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT:gray 1px solid; BORDER-TOP:gray 1px solid; BORDER-LEFT:gray 1px solid; WIDTH:100%; WORD-BREAK:break-all; BORDER-BOTTOM:gray 1px solid; BORDER-COLLAPSE:collapse; BACKGROUND-COLOR:#f5fafe; WORD-WRAP:break-word">
							
							<tr style="FONT-WEIGHT:bold;FONT-SIZE:12pt;HEIGHT:25px;BACKGROUND-COLOR:#afd1f3">
							
								<td align="center" width="5%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">
									<input type="checkbox" name="selectUserAll" onclick="checkAllUser(this)">
								</td>
								
								<td align="center" width="15%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">登录名</td>
								<td align="center" width="15%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">用户姓名</td>
								<td align="center" width="7%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">性别</td>
								<td align="center" width="15%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">联系电话</td>
								<td align="center" width="15%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">入职时间</td>
								<td align="center" width="8%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">职位</td>
								<td width="10%" align="center" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">编辑</td>
								<td width="10%" align="center" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">查看</td>
								
							</tr>
									<c:forEach items="${userList}" var="user">
									<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
										<td style="HEIGHT:22px" align="center" width="5%">
											<input type="checkbox" name="userId" id="userId" value="<c:out value="${user.userId }"/>">
										</td>
										<td style="HEIGHT:22px" align="center" width="15%">
											<c:out value="${user.logonName}"></c:out>
										</td>
										<td style="HEIGHT:22px" align="center" width="15%">
											<c:out value="${user.userName}"></c:out>
										</td>
										<td style="HEIGHT:22px" align="center" width="7%">
											<c:out value="${user.sexId}"></c:out>
										</td>
										<td style="HEIGHT:22px" align="center" width="15%">
											<c:out value="${user.contactTel}"></c:out>
										</td>	
										<td style="HEIGHT:22px" align="center" width="15%">
											<c:out value="${user.ondutyDate}"></c:out>
										</td>								
										<td style="HEIGHT:22px" align="center" width="8%">
											<c:out value="${user.postId}"></c:out>
										</td>
										
										<td align="center" style="HEIGHT: 22px" align="center" width="10%">																	
										   <a href="#" onclick="openWindow('${pageContext.request.contextPath }/elecUserController/userEdit?userId=<c:out value="${user.userId }"/>','700','400');">
										   <img src="${pageContext.request.contextPath }/images/edit.gif" border="0" style="CURSOR:hand"></a>													
										</td>
										
										<td align="center" style="HEIGHT: 22px" align="center" width="10%">
											<a href="#" onclick="openWindow('${pageContext.request.contextPath }/elecUserController/userEdit?userId=<c:out value="${user.userId }"/>&viewflag=1','700','400');">
											<img src="${pageContext.request.contextPath }/images/button_view.gif" width="20" height="18" border="0" style="CURSOR:hand"></a>												
										</td>
									</tr>
									</c:forEach>
									
								
						</table>					
						
					</td>
				</tr>        
			</TBODY>
		</table>
		</form>




	</body>
</HTML>
