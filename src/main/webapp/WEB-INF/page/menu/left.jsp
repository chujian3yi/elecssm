<%@page language="java" pageEncoding="utf-8" %>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <script language="JavaScript" src="${pageContext.request.contextPath}/script/jquery-1.4.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.ztree.all.js"></script>
    
	<script language="JavaScript" src="${pageContext.request.contextPath}/script/menuTree3.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/menu.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/zTreeStyle/zTreeStyle.css" />
  </head>

  <body style="margin: 0">
	<table border="0" width="20">
	<input type="hidden" name="jsondata" value='${sessionScope.jsondata}'>

		<tr>
			<td width="340px" align="center" valign="top">
				<div class="zTreeDemoBackground">
					<ul id="menuTree3" class="tree"></ul>
				</div>
			</td>
		</tr>
	</table>
  </body>
</html>