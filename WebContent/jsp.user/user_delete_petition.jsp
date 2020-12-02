<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="test" uri="/WEB-INF/tld/tables.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="en-EN" scope="session"/>
<fmt:setBundle basename="Message" var="rb"></fmt:setBundle>
<html>
<head>
<title><fmt:message key="user.page.delete.petition" bundle="${rb }"/></title>
</head>
<body>
	<form action="../controller" method="post">
			<input type="hidden" name="command" value="userStartPage" />
		<H3>
			<test:user_delete_petition/>
		</H3>	
	</form>
</body>
</html>