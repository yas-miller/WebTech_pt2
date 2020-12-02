<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="test" uri="/WEB-INF/tld/tables.tld"%>
<html>
<head>
<title>Admin</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<hr />

	<FORM action="controller" method="POST">
		<input type="hidden" name="command" value="admin_add_user" />
		<H3>
			Користувачі: <test:tenant_table />
		</H3>
	</FORM>

	<FORM action="controller" method="POST">
		<input type="hidden" name="command" value="admin_add_employee" />
		<H3>
			Працівники: <test:employee_table />
		</H3>
	</FORM>

	<H3> Заяви:<test:petition_table /> </H3>

	<H3> Роботи які потрібно виконати: <test:work_table /> </H3>

	<H3> Бригади: <test:brigade_table /> </H3>

	<form action="LogoutServlet" method="post">
		<INPUT type="submit" value="Exit"><BR>
	</form>
</body>
</html>