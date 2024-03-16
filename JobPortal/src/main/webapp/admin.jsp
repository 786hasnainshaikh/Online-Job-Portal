<%@page import="com.entity.user"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin page</title>
<%@include file="allComponent/allCSS.jsp"%>
</head>
<body style="background-color: #e4f5f3">


	<!-- if user is not admin then provide no access to home.jsp redirect user to login page -->
	<c:if test="${user.role ne 'admin'}">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>

	<%@include file="allComponent/navbar.jsp"%>


</body>
</html>