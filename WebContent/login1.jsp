<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.*"%>
<fmt:setLocale value="en-EN" scope="session"/>
<fmt:setBundle basename="Message" var="rb"></fmt:setBundle>
<%
	String lang = request.getParameter("lang");
	Locale locale = Locale.US;
	ResourceBundle bundle = ResourceBundle.getBundle("Message", locale);
	
	for (Enumeration<String> e = bundle.getKeys();e.hasMoreElements();) {
		String key = (String)e.nextElement();
		String s = (String)bundle.getString(key);
		session.putValue(key,s);
		}
%>
<html>
<head>
<title><%=session.getValue("login.title")%></title>
</head>
<body>
	<h3>
		<%=session.getValue("login.welcome.phrase1")%> <br /> <%=session.getValue("login.welcome.phrase2")%>
		services:<br />
	</h3>
	<hr />
	<form name="loginForm" method="POST" action="controller">
		English <input type="radio" name="lang" value="English" checked>
		Українська <input type="radio" name="lang" value="Ukraine">
		Русский <input type="radio" name="lang" value="Russia">
		<hr />
		<input type="hidden" name="command" value="login" /> <%=session.getValue("login.login")%>:<br /> <input
			type="text" name="login" value=""><br /> <%=session.getValue("login.password")%>:<br /> <input
			type="password" name="password" value=""> <br /> <input
			type="submit" value="Enter">
	</form>
	<hr />
</body>
</html>
<%
		if (lang.equals("Ukraine")) {
			locale = Locale.UK;
		} else if (lang.equals("Russia")) {
			locale = new Locale("ru", "RU");
		} else {
			locale = Locale.US;
		}
		session.putValue("myLocale", locale);
		bundle = ResourceBundle.getBundle("Message",
				locale);

		for (Enumeration e = bundle.getKeys(); e.hasMoreElements();) {
			String key = (String) e.nextElement();
			String s = bundle.getString(key);
			session.putValue(key, s);
		}
%>