<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="test" uri="/WEB-INF/tld/tables.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fmt:setLocale value="en-EN" scope="session"/>
<fmt:setBundle basename="Message" var="rb"></fmt:setBundle>
<html>
<head>
<title><fmt:message key="user.page.change.petition.title" bundle="${rb }"/></title>
</head>
<body>
<form action="../controller" method="POST">
		<input type="hidden" name="command" value="user_change_petition" />
			<b><fmt:message key="user.page.change.petition" bundle="${rb }"/></b>
			<test:user_change_petition/>
			<INPUT type="submit" value="Зберегти зміни">
	</form>
</body>
</html>