<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table cellSpacing="1" cellPadding="0" width="90%" align="center" bgColor="#f5fafe" border="0">
 <tr>
  <td>
   <fieldset style="width:100%; border : 1px solid #73C8F9;text-align:left;COLOR:#023726;FONT-SIZE: 12px;"><a href="#" onclick="displaypermission()"><div class="divcss5-left" id="permissionflag">权限分配&nbsp;&nbsp;关闭</div></a>
 
     <table cellSpacing="0" cellPadding="0" width="90%" align="center" bgColor="#f5fafe" border="0" id="dataPopedom">			 
			  <tr>
				 <td class="ta_01" colspan=2 align="left" width="100%" > 
				 	全选/全不选<input type="checkbox" name="selectOperAll" onclick="checkAllOper(this)">
				 	<br>
				         
				         <table cellspacing="0" align="center" width="100%" cellpadding="1" rules="all" bordercolor="gray" border="1" 
									style="BORDER-RIGHT:gray 1px solid; BORDER-TOP:gray 1px solid; BORDER-LEFT:gray 1px solid; WORD-BREAK:break-all; BORDER-BOTTOM:gray 1px solid; BORDER-COLLAPSE:collapse; BACKGROUND-COLOR:#f5fafe; WORD-WRAP:break-word">
								
								<c:if test="${popedomList!=null && popedomList.size()>0 }">
													<c:set value="1" var="flag" scope="request"></c:set>
														<c:forEach items="${popedomList}" var="popedom">
															<c:choose>
																<c:when test="${popedom.isParent}">
																<c:if test="${flag==2 }">
																	</td>
																	</tr>
																</c:if>
																	<c:set value="1" var="flag" scope="request"></c:set>
																	<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
																	<td class="ta_01"  align="left" width="18%" height="22" background="../images/tablehead.jpg" >
																	<c:choose>
																		<c:when test="${popedom.flag =='1'}">
																		<input type="checkbox"  name="selectoper" id='<c:out value="${popedom.mid }"/>_<c:out value="${popedom.mid }"/>' value='<c:out value="${popedom.mid }"/>_<c:out value="${popedom.pid }"/>'  onClick='goSelect(this.id)' checked="checked" >
																		</c:when>
																		
																		<c:when test="${popedom.flag=='2' }">
																		<input type="checkbox"  name="selectoper" id='<c:out value="${popedom.mid }"/>_<c:out value="${popedom.mid }"/>' value='<c:out value="${popedom.mid }"/>_<c:out value="${popedom.pid }"/>'  onClick='goSelect(this.id)' >
																		</c:when>
																	</c:choose>
																	
																		${popedom.popedomName }：
																		</td>
																</c:when>
																<c:otherwise>
																	<c:if test="${flag ==1}">
																		<td class="ta_01"  align="left" width="82%" height="22">
																	</c:if>
																	<c:set value="2" var="flag" scope="request"></c:set>
																	
																	
																	<div>
																	
																	<c:choose>
																		<c:when test="${popedom.flag =='1'}">
																			<input type="checkbox"  name="selectoper" id='<c:out value="${popedom.pid }"/>_<c:out value="${popedom.mid }"/>'  value='<c:out value="${popedom.pid }"/>_<c:out value="${popedom.mid }"/>'  onClick='goSelect(this.id)' checked="checked" >
																		</c:when>
																		
																		<c:when test="${popedom.flag=='2' }">
																			<input type="checkbox"  name="selectoper" id='<c:out value="${popedom.pid }"/>_<c:out value="${popedom.mid }"/>'  value='<c:out value="${popedom.pid }"/>_<c:out value="${popedom.mid }"/>'  onClick='goSelect(this.id)' >
																		</c:when>
																	</c:choose>
																	${popedom.popedomName }
																	</div>
																
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</c:if>
								
													
						     	</table> 
				        
				 </td>
			  </tr>						
				 <input type="hidden" name="roleId" >						
		 </table>	
        </fieldset>
	  </td>
	</tr>

	
	<tr>
		<td height=10></td>
	</tr>
	
  <tr>
	<td>
	
   <fieldset style="width:100%; border : 1px solid #73C8F9;text-align:left;COLOR:#023726;FONT-SIZE: 12px;"><a href="#" onclick="displayuser()"><div id="userflag">用户分配&nbsp;&nbsp;关闭</div></a>
 
	<table cellspacing="0" align="center" width="100%" cellpadding="1" rules="all" bordercolor="gray" border="1" id="dataUser"
							style="BORDER-RIGHT:gray 1px solid; BORDER-TOP:gray 1px solid; BORDER-LEFT:gray 1px solid; WORD-BREAK:break-all; BORDER-BOTTOM:gray 1px solid; BORDER-COLLAPSE:collapse; BACKGROUND-COLOR:#f5fafe; WORD-WRAP:break-word">
			    
				<tr style="FONT-WEIGHT:bold;FONT-SIZE:12pt;HEIGHT:25px;BACKGROUND-COLOR:#afd1f3">
				   <td class="ta_01"  align="center" width="20%" height=22 background="../images/tablehead.jpg">选中<input type="checkbox" name="selectUserAll" onclick="checkAllUser(this)"></td>
				   <td class="ta_01"  align="center" width="40%" height=22 background="../images/tablehead.jpg">登录名</td>
				   <td class="ta_01"  align="center" width="40%" height=22 background="../images/tablehead.jpg">用户姓名</td>
				</tr>
				
				
			<c:forEach items="${userList }" var="users">
				<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
					<c:choose>
					<c:when test="${ users.flag == '1'}">
						 
							<td style="HEIGHT: 22px" class="ta_01" align="center" width="20%">
								<input type="checkbox" name="selectuser" value='<c:out value="${users.userId }"></c:out>' checked>
							</td>
					</c:when>
					<c:when test="${users.flag =='2' }">
							<td style="HEIGHT: 22px" class="ta_01" align="center" width="20%">
								<input type="checkbox" name="selectuser" value='<c:out value="${users.userId }"></c:out>' >
							</td>
					</c:when>
					</c:choose>
					<td style="HEIGHT: 22px" class="ta_01" align="center" width="40%">
						<c:out value="${users.logonName }"></c:out>
					</td>
					<td style="HEIGHT: 22px" class="ta_01" align="center" width="40%">
						<c:out value="${users.userName }"></c:out>
					</td>
				</tr>
			</c:forEach>	
			
		</table>
    </fieldset>
	 </td>
	 </tr>
			<tr>
		   <td class="ta_01" align="center" colspan=3 width="100%"  height=20>
		   <input type="button" name="saverole" onclick="saveRole()" style="font-size:12px; color:black; height=20;width=50" value="保存">
		   </td>
		</tr>
   </table>
