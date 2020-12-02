<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="test" uri="/WEB-INF/tld/tables.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="en-EN" scope="session" />
<fmt:setBundle basename="Message" var="rb"></fmt:setBundle>
<html>
<head>
<title><fmt:message key="err.title" bundle="${rb }"/></title>
</head>
<body>
	<h3><fmt:message key="err.title" bundle="${rb }"/></h3>
	<hr />
	<jsp:expression>(request.getAttribute("errorMessage") != null) ? (String) request
					.getAttribute("errorMessage") : "unknown error"</jsp:expression>
	<hr />
	<a href="controller"><fmt:message key="err.link" bundle="${rb }"/></a>
</body>
</html>
