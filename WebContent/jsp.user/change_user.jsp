<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="test" uri="/WEB-INF/tld/tables.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="en-EN" scope="session"/>
<fmt:setBundle basename="Message" var="rb"></fmt:setBundle>
<html>
<head>
<title><fmt:message key="user.page.change.title.user" bundle="${rb }"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form action="../controller" method="POST">
		<input type="hidden" name="command" value="user_change_semself" />
			<b><fmt:message key="user.page.change.user.body" bundle="${rb }"/></b>
			<test:user_change_semself/>
			<INPUT type="submit" value="Save changes">
	</form>
</body>
</html>