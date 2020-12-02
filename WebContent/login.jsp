<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="en-EN" scope="session"/>
<fmt:setBundle basename="Message" var="rb"></fmt:setBundle>
<html>
<head>
<title><fmt:message key="login.title" bundle="${rb }"/></title>
</head>
<body>
	<h3>
		<fmt:message key="login.welcome.phrase1" bundle="${rb }"/><br /> 
		<fmt:message key="login.welcome.phrase2" bundle="${rb }"/>
	</h3>
	<hr />
	<form name="loginForm" method="POST" action="controller">
		<input type="radio" name="lang" value="English" checked>English<br />
		<input type="radio" name="lang" value="Ukraine">Українська <br />
		<input type="radio" name="lang" value="Russia">Русский <br />
		<hr />
		<input type="hidden" name="command" value="login" /> 
		
		<fmt:message key="login.login" bundle="${rb }"/><br /> 
		<input type="text" name="login" value=""><br /> 
		<fmt:message key="login.password" bundle="${rb }"/><br />
		<input type="password" name="password" value=""> <br /> 
		<input type="submit" value=<fmt:message key="login.button" bundle="${rb }"/>>
	</form>
	<hr />
</body>
</html>
