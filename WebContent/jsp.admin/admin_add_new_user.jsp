<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="test" uri="/WEB-INF/tld/tables.tld"%>
<html>
<head>
<title>Add new user</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form action="controller" method="POST">
		<input type="hidden" name="command" value="admin_save_user" />
			<b>Введіть дані нового користувача: </b>
			<test:add_user/>
			<INPUT type="submit" value="Зберегти зміни">
	</form>
</body>
</html>