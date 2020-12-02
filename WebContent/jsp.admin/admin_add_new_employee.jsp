<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="test" uri="/WEB-INF/tld/tables.tld"%>
<html>
<head>
<title>Add new Employee</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form action="controller" method="POST">
		<input type="hidden" name="command" value="admin_save_employee" />
			<b>Введіть дані нового співробітника: </b>
			<test:add_employee/>
			<INPUT type="submit" value="Зберегти зміни">
	</form>
</body>
</html>