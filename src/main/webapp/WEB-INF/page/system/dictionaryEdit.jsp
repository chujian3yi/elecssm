<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

   <table cellSpacing="1" cellPadding="0" width="90%" align="center" bgColor="#f5fafe" border="0" >
    <tr>
     <td >
	   <table cellspacing="0"   cellpadding="1" rules="all" bordercolor="gray" border="1" id="dictTbl"
		    style="BORDER-RIGHT:gray 1px solid; BORDER-TOP:gray 1px solid; BORDER-LEFT:gray 1px solid; WIDTH:100%; WORD-BREAK:break-all; BORDER-BOTTOM:gray 1px solid; BORDER-COLLAPSE:collapse; BACKGROUND-COLOR:#f5fafe; WORD-WRAP:break-word">
					
				<tr style="FONT-WEIGHT:bold;FONT-SIZE:12pt;HEIGHT:25px;BACKGROUND-COLOR:#afd1f3">
					<td class="ta_01" align="center"  width="20%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">编号</td>
					<td class="ta_01" align="center"  width="60%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">名称</td>
					<td class="ta_01" align="center"  width="20%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">删除</td>					
				</tr>
			  
			  <c:if test="${systemDDLlist!=null && systemDDLlist.size()>0}">
			  	<c:forEach var="systemDDLlist" items="${systemDDLlist}">
			  	 <tr>
				   <td class="ta_01" align="center"  width="20%">
				   			<c:out value="${systemDDLlist.ddlcode}"></c:out>
				   </td>
				   <td class="ta_01" align="center"  width="60%">
				  			<input id="<c:out value="${systemDDLlist.ddlcode}"></c:out>" name="itemname" type="text" value="<c:out value="${systemDDLlist.ddlname}"></c:out>"  size="45" maxlength="25">
				   </td>
				   <td class="ta_01" align="center"  width="20%">
				   			<a href="#" onclick="delTableRow('<c:out value="${systemDDLlist.ddlcode}"></c:out>')">
							<img src="${pageContext.request.contextPath }/images/delete.gif" width="16" height="16" border="0" style="CURSOR:hand">
							</a>
				  </td>
				</tr>
			  	</c:forEach>
			  </c:if>
			  
			  
			  <c:if test="${systemDDLlist=null}">
			 	<td class="ta_01" align="center"  width="20%">
			 				1
			 	</td>
				<td class="ta_01" align="center"  width="60%">
							<input id="itemname" name="itemname" type="text" size="45" maxlength="25">
				</td>
				<td class="ta_01" align="center"  width="20%"></td>
			  </c:if>
			    
			    
			    
	     </table>
	   </td>
	 </tr>
  <tr>
     <td >   
	 </td>
 </tr>
 <TR height=10><td colspan=3></td></TR>
  <tr>
     <td align="center" colspan=3>
       <input type="button" name="saveitem" value="保存" style="font-size:12px; color:black; height=20;width=50" onClick="saveDict()">
	 </td>
 </tr>
 
       <input type="hidden" name="keywordname" >
       <input type="hidden" name="typeflag" >
	 
  </table>
