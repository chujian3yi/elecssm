<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
 
   <title>
   <c:set var="viewflag"><c:out value="${user.viewflag }"></c:out></c:set>
   	<c:choose>
   		
   		<c:when test="${viewflag==1 }">
   			查看用户明细
   		</c:when>
   		<c:otherwise >
   			编辑用户
   		</c:otherwise>
   	</c:choose>
   </title>
   <LINK href="${pageContext.request.contextPath }/css/Style.css" type="text/css" rel="stylesheet">
   <script language="javascript" src="${pageContext.request.contextPath }/script/function.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath }/script/validate.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/script/My97DatePicker/WdatePicker.js"></script>
   <script language="javascript" src="${pageContext.request.contextPath }/script/showText.js"></script>
   <script language="javascript" src="${pageContext.request.contextPath }/script/limitedTextarea.js"></script>
   <script language="javascript" src="${pageContext.request.contextPath }/script/jquery-1.4.2.js"></script>
   <Script language="javascript">
    
	function check_null(){
	
		var theForm=document.Form1;
	    
	  
	    if(Trim(theForm.userName.value)=="")
		{
			alert("用户姓名不能为空");
			theForm.userName.focus();
			return false;
		}
		if(theForm.sexId.value=="")
		{
			alert("请选择性别");
			theForm.sexId.focus();
			return false;
		}
	    if(theForm.jctId.value=="")
		{
			alert("请选择所属单位");
			theForm.jctId.focus();
			return false;
		}
	    if(Trim(theForm.ondutyDate.value)=="")
		{
			alert("入职时间不能为空");
			theForm.ondutyDate.focus();
			return false;
		}
	    if(theForm.postId.value=="")
		{
			alert("请选择职位");
			theForm.postId.focus();
			return false;
		}
        if(theForm.logonPwd.value!=theForm.passwordconfirm.value){
		
		  alert("两次输入密码不一致，请重新输入");
		  return;
		}
		if(checkNull(theForm.contactTel)){
         if(!checkPhone(theForm.contactTel.value))
		  {
			alert("请输入正确的电话号码");
			theForm.contactTel.focus();
			return false;
		  }
		}
		
	    if(checkNull(theForm.mobile)){
         if(!checkMobilPhone(theForm.mobile.value))
		  {
			alert("请输入正确的手机号码");
			theForm.mobile.focus();
			return false;
		  }
		}
		
	   if(checkNull(theForm.email))	{
         if(!checkEmail(theForm.email.value))
		 {
			alert("请输入正确的EMail");
			theForm.email.focus();
			return false;
		 }
	   }
		
	   if(theForm.remark.value.length>250){
     
        	alert("备注字符长度不能超过250");
			theForm.remark.focus();
			return false; 
       }
	   //如果是否在职选择是，则入职时间必须要填写，如果是否在职选择否，则离职日期必须要填写
	   var isDutySelect = document.getElementById("isDuty");
	   //选择[是]
	   if(isDutySelect.options[0].selected){
		   if(theForm.ondutyDate.value==""){
			   alert("该用户属于在职人员，请填写入职时间");
			   theForm.ondutyDate.focus();
			   return false; 
		   }
	   }
	   //选择[否]
	   else{
		   if(theForm.offdutyDate.value==""){
			   alert("该用户属于离职人员，请填写离职时间");
			   theForm.offdutyDate.focus();
			   return false; 
		   }
	   }
	   document.Form1.action="${pageContext.request.contextPath }/elecUserController/saveUser";
	   document.Form1.submit();
	  	
	}
	function checkTextAreaLen(){
  		var remark = new Bs_LimitedTextarea('remark', 250); 
  		remark.infolineCssStyle = "font-family:arial; font-size:11px; color:gray;";
  		remark.draw();	
    }
    window.onload=function(){
		checkTextAreaLen();
    }
    
    /**如果选择离职时间，则【是否在职】默认选择"否"，如果没有选择离职时间，则【是否在职】默认选择"是"*/
    function checkIsDuty(o){   
 	   var offdutyDate = o.value;
 	   var isDutySelect = document.getElementById("isDuty");
 	   if(offdutyDate!=""){
 		   isDutySelect.options[1].selected = true; //否
 	   }
 	   else{
 		   isDutySelect.options[0].selected = true; //是
 	   }
    }
    
    //ajax的二级联动，使用选择的所属单位，查询该所属单位下对应的单位名称列表
   /*  function findJctUnit(o){
    	//货物所属单位的文本内容
    	var jct = $(o).find("option:selected").text();
    	$.post("elecUserAction_findJctUnit.do",{"jctID":jct},function(data,textStatus){
	   	    //先删除单位名称的下拉菜单，但是请选择要留下
	   	    $("#jctUnitID option").remove();
	        if(data!=null && data.length>0){
	            for(var i=0;i<data.length;i++){
	   		       	var ddlCode = data[i].ddlCode;
	   		       	var ddlName = data[i].ddlName;
	   		       	//添加到单位名称的下拉菜单中
	   		       	var $option = $("<option></option>");
	   		       	$option.attr("value",ddlCode);
	   		       	$option.text(ddlName);
	   		       	$("#jctUnitID").append($option);
	   	        }
	        }
        });
    	
    } */
    
    function getJctUnit(object) {
		//1、jctId
		var jctId = document.getElementById("jctId").value;
		console.log("===jctid ",jctId);
		$.ajax({
			url:'${pageContext.request.contextPath }/elecUserController/getJctUnitc',
			type:'post',
			async:true,
			data:{
				jctId:jctId
			},
			success:function(data){
				console.log(data);
				
				$("#jctUnitId option").remove();
				if(data!=null && data.length>0){
					for(var i=0;i<data.length;i++){
						
					var ddlcode = data[i].ddlcode;
					var ddlname = data[i].ddlname;
					
					var $option = $("<option></option>");
					$option.attr("value",ddlcode);
					$option.text(ddlname);
					$("#jctUnitId").append($option);
					}
				}
			}
		});
	}
	
</script>
</head>

  
 <body>
    <form name="Form1" method="post">	
    <br>
    
    <table cellSpacing="1" cellPadding="5" width="680" align="center" bgColor="#eeeeee" style="border:1px solid #8ba7e3" border="0">

	 <tr>
		<td class="ta_01" align="center" colSpan="4" background="${pageContext.request.contextPath }/images/b-info.gif">
		 <font face="宋体" size="2"><strong>
		 <c:set var="viewflag"><c:out value="${user.viewflag }"></c:out></c:set>
		  	<c:choose>
   			<c:when test="${viewflag==1 }">
   			查看用户明细
   			</c:when>
   			<c:otherwise >
   			编辑用户
   			</c:otherwise>
   			</c:choose>
		 </strong></font>
		</td>
    </tr>
       <input name="userId"  type="hidden" value='<c:out value="${user.userId }"></c:out>'>
       <input name="password" type="hidden" value='<c:out value="${user.logonPwd }"></c:out>'">
       <input name="roleflag" type="hidden">
       <input name="state" type="hidden">
     <tr>
         <td align="center" bgColor="#f5fafe" class="ta_01">登&nbsp;&nbsp;录&nbsp;&nbsp;名：
         <td class="ta_01" bgColor="#ffffff">
         
         	<input name="logonName" type="text" maxlength="25" id="logonName"  value='<c:out value="${user.logonName }"></c:out>'  size=20 readonly="true">
         <font color="#FF0000">*</font></td>
         <td width="18%" align="center" bgColor="#f5fafe" class="ta_01">用户姓名：
		 <td class="ta_01" bgColor="#ffffff">
		 	<input name="userName" type="text"  value='<c:out value="${user.userName}"></c:out>' maxlength="25" id="userName"  size=20>
		 	
         <font color="#FF0000">*</font></td>
    </tr>
	<tr>
		<td align="center" bgColor="#f5fafe" class="ta_01">性别：</td>
		<td class="ta_01" bgColor="#ffffff">
		
		
			<select name="sexId" id="sexId" style="width:155px">
			<option value=""></option>
			<c:forEach items="${sexList}" var="sexList">
				<option value='<c:out value="${sexList.ddlcode }"></c:out> ' >${sexList.ddlname }</option>
			</c:forEach>
			</select>
			
			<font color="#FF0000">*</font>
		</td>
		<td align="center" bgColor="#f5fafe" class="ta_01">职位：</td>
		<td class="ta_01" bgColor="#ffffff">
			<select name="postId" id="postId" style="width:155px">
	    		<option value=""></option>
	    		<c:forEach items="${postList}" var="postList">
				<option value='<c:out value="${postList.ddlcode }"></c:out> ' >${postList.ddlname }</option>
				</c:forEach>
			</select>
			<font color="#FF0000">*</font>
		</td>
	</tr>
	<tr>
		<td align="center" bgColor="#f5fafe" class="ta_01">所属单位：</td>
		<td class="ta_01" bgColor="#ffffff">
			<select name="jctId" id="jctId" style="width:155px" onchange="getJctUnit(this)">
			<option value=""></option>
			<c:forEach items="${jctUnitList}" var="jctUnitList">
				<option value='<c:out value="${jctUnitList.ddlcode }"></c:out> ' >${jctUnitList.ddlname }</option>
			</c:forEach>
			</select> 
			<font color="#FF0000">*</font>
		</td>
		<td align="center" bgColor="#f5fafe" class="ta_01">单位名称：</td>
		<td class="ta_01" bgColor="#ffffff">
			<select id="jctUnitId" name="jctUnitId" style="width:155px">
			
			</select>
			<font color="#FF0000">*</font>
		</td>
	</tr>
	<tr>
		<td align="center" bgColor="#f5fafe" class="ta_01">密码：</td>
		<td class="ta_01" bgColor="#ffffff">
			<input name="logonPwd" id="logonPwd" type="password" value='<c:out value="${user.logonPwd }"></c:out>' maxlength="25"  size="22">
		</td>
		<td align="center" bgColor="#f5fafe" class="ta_01">确认密码：</td>
		<td class="ta_01" bgColor="#ffffff">
			<input name="passwordconfirm" type="password" value='<c:out value="${user.logonPwd }"></c:out>' maxlength="25" size="22">
		</td>
	</tr>

	<tr>
		<td align="center" bgColor="#f5fafe" class="ta_01">出生日期：</td>
		<td class="ta_01" bgColor="#ffffff">
			<input name="birthday" id="birthday" type="text" maxlength="50"  size=20 value="" onClick="WdatePicker()">
		</td>
		<td align="center" bgColor="#f5fafe" class="ta_01">联系地址：</td>
		<td class="ta_01" bgColor="#ffffff">
			<input name="address" type="text" maxlength="50"  size=20 value='<c:out value="${user.address }"></c:out>'>
		</td>
	</tr>

	<tr>
		<td align="center" bgColor="#f5fafe" class="ta_01">联系电话：</td>
		<td class="ta_01" bgColor="#ffffff">
			<input name="contactTel" type="text" maxlength="25" size=20 value='<c:out value="${user.contactTel }"></c:out>'>
		</td>
		<td align="center" bgColor="#f5fafe" class="ta_01">手机：</td>
		<td class="ta_01" bgColor="#ffffff">
			<input name="mobile" type="text" maxlength="25"  size=20 value='<c:out value="${user.mobile }"></c:out>'>
		</td>
	</tr>

	<tr>
		<td align="center" bgColor="#f5fafe" class="ta_01">电子邮箱：</td>
		<td class="ta_01" bgColor="#ffffff">
			<input name="email" type="text" maxlength="50"  size=20 value='<c:out value="${user.email }"></c:out>'>
		</td>
		<td align="center" bgColor="#f5fafe" class="ta_01">是否在职：</td>
		<td class="ta_01" bgColor="#ffffff">
			<select name="isDuty" id="isDuty"  style="width:155px">
			<c:forEach items="${isDutyList}" var="isDutyList">
				<option value='<c:out value="${isDutyList.ddlcode }"></c:out> ' >${isDutyList.ddlname }</option>
			</c:forEach>
			</select>
		</td>
	</tr>
	
	
	
	<tr>
		<td align="center" bgColor="#f5fafe" class="ta_01">入职日期：</td>
		<td class="ta_01" bgColor="#ffffff">
			<input name="ondutyDate" id="ondutyDate" type="text" maxlength="50" size=20 value='<c:out value="${user.ondutyDate }"></c:out>' onClick="WdatePicker()">
			<font color="#FF0000">*</font>
		</td>
		<td align="center" bgColor="#f5fafe" class="ta_01">离职日期：</td>
		<td class="ta_01" bgColor="#ffffff">
			<input name="offdutyDate" id="offdutyDate" type="text" maxlength="50" size=20 value='<c:out value="${user.offdutyDate }"></c:out>' onClick="WdatePicker()" onblur="checkIsDuty(this)">
		</td>
	</tr>
	<TR>
		<TD class="ta_01" align="center" bgColor="#f5fafe">备注：</TD>
		<TD class="ta_01" bgColor="#ffffff" colSpan="3">
			<textarea name="remark"  style="WIDTH:92%;"  rows="4" cols="52"><c:out value="${user.remark }"/></textarea>
		</TD>
		</TR>
		<TR>
		<td  align="center"  colSpan="4"  class="sep1"></td>
	
	</TR>
	<tr>
		<td class="ta_01" style="WIDTH: 100%" align="center" bgColor="#f5fafe" colSpan="4">
		 <c:set var="viewflag"><c:out value="${user.viewflag }"></c:out></c:set>
		<c:choose>
			<c:when test="${viewflag=='' }">
				<input type="button" id="BT_Submit" name="BT_Submit" value="保存"  style="font-size:12px; color:black; height=22;width=55"  onClick="check_null()">
				 <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
			</c:when>
   			<c:when test="${viewflag==1 }">
   			<input style="font-size:12px; color:black; height=22;width=55" type="button" value="关闭"  name="Reset1"  onClick="window.close()">	
		    	<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
   			</c:when>
		</c:choose>

		    
	    </td>
	</tr>
</table>　
</form>

</body>
</html>
