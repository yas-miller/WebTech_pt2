<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="test" uri="/WEB-INF/tld/tables.tld"%>
<html>
<head>
<title>Change user</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form action="../controller" method="POST">
		<input type="hidden" name="command" value="change_admin_user" />
			<b>Внесіть зміни до користувача: </b>
			<test:admin_change_tenant/>
			<INPUT type="submit" value="Зберегти зміни">
	</form>
</body>
</html>