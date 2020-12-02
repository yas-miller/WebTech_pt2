<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="test" uri="/WEB-INF/tld/tables.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="en-EN" scope="session"/>
<fmt:setBundle basename="Message" var="rb"></fmt:setBundle>
<html>
<head>
<title><fmt:message key="user.page.title" bundle="${rb }"/></title>
</head>
<body>
	<b><fmt:message key="user.page.description" bundle="${rb }"/></b>
	<FORM action="../controller" method="POST">
			<input type="hidden" name="command" value="userForm" />
		<H3>
			<fmt:message key="user.page.familyWork" bundle="${rb }"/>
			<TABLE BORDER=1>
				<TR>
					<TD><fmt:message key="user.page.familyWork.repairPlumbing" bundle="${rb }"/></TD>
					<TD><INPUT type="radio" name="working"
						value="fix plumbing" checked></TD>
				</TR>
				<TR>
					<TD><fmt:message key="user.page.familyWork.repairWiring" bundle="${rb }"/></TD>
					<TD><INPUT type="radio" name="working"
						value="electric wiring"></TD>
				</TR>
				<TR>
					<TD><fmt:message key="user.page.familyWork.workingWithWood" bundle="${rb }"/></TD>
					<TD><INPUT type="radio" name="working"
						value="wood work"></TD>
				</TR>
			</TABLE>
			<br><fmt:message key="user.page.scale" bundle="${rb }"/>
			<TABLE BORDER=1>
				<TR>
					<TD><fmt:message key="user.page.scale.partOfTheRoom" bundle="${rb }"/></TD>
					<TD><INPUT type="radio" name="scale" value="part of the room"
						checked></TD>
				</TR>
				<TR>
					<TD><fmt:message key="user.page.scale.room" bundle="${rb }"/></TD>
					<TD><INPUT type="radio" name="scale" value="room"></TD>
				</TR>
				<TR>
					<TD><fmt:message key="user.page.scale.flat" bundle="${rb }"/></TD>
					<TD><INPUT type="radio" name="scale" value="flat"></TD>
				</TR>
			</TABLE>
			<br> <fmt:message key="user.page.timeOfWorking" bundle="${rb }"/><br />
			<br /> month <select name="month">
				<c:forEach begin="1" end="12" step="1" var="status">
					<option>${status}</option>
				</c:forEach>
			</select> day <select name="day">
				<c:forEach begin="1" end="31" step="1" var="status">
					<option>${status}</option>
				</c:forEach>
			</select> <br />
			<br /> hour <select name="hour">
				<c:forEach begin="8" end="18" step="1" var="status">
					<option>${status}</option>
				</c:forEach>
			</select> minute <select name="minute">
				<c:forEach begin="0" end="59" step="1" var="status">
					<option>${status}</option>
				</c:forEach>
			</select>

		</H3>
		
		<INPUT type="submit" value=<fmt:message key="user.page.button" bundle="${rb }"/>><BR>
	</FORM>
</body>
</html>