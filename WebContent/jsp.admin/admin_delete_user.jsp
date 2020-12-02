<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="test" uri="/WEB-INF/tld/tables.tld"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Deleted user</title>
</head>
<body>
	<form action="../controller" method="post">
			<input type="hidden" name="command" value="adminForm" />
		<H3>
			<test:delete_user/>
		</H3>	
	</form>
</body>
</html>