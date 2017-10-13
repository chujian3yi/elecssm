

<%@ page language="java" pageEncoding="UTF-8"%>

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
													
						     	</table> 
				            
				        
				 </td>
			  </tr>						
				 <input type="hidden" name="roleID" >						
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
				 <tr onmouseover="this.style.backgroundColor = 'white'"
					onmouseout="this.style.backgroundColor = '#F5FAFE';">
					<td style="HEIGHT: 22px" class="ta_01" align="center" width="20%">
						<input type="checkbox" name="selectuser" value="123456789" checked>
					</td>
					<td style="HEIGHT: 22px" class="ta_01" align="center" width="40%">
						zhangsan
					</td>
					<td style="HEIGHT: 22px" class="ta_01" align="center" width="40%">
						张三
					</td>
				</tr>
				<tr onmouseover="this.style.backgroundColor = 'white'"
					onmouseout="this.style.backgroundColor = '#F5FAFE';">
					<td style="HEIGHT: 22px" class="ta_01" align="center" width="20%">
						<input type="checkbox" name="selectuser" value="123456789">
					</td>
					<td style="HEIGHT: 22px" class="ta_01" align="center" width="40%">
						lisi
					</td>
					<td style="HEIGHT: 22px" class="ta_01" align="center" width="40%">
						李四
					</td>
				</tr>
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
