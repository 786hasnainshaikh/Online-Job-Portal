<%@page import="java.sql.Connection"%>
<%@page import="com.DBconnection.connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="allComponent/allCSS.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index page</title>
<style type="text/css">
.back-img{
 background: url("images/job.jpg");
 width:100%;
 background-repeat: no-repeat;
 background-size: cover;
 height: 89%;
}

</style>
</head>
<body>
 

    <!-- Adding navbar -->
    <%@include file="allComponent/navbar.jsp" %>
    
    <!-- Adding BackGround image -->
    <div class="container-fluid back-img">
       <div class="text-center">
           <h1 class="text-black p-4">
           <i class="fa fa-book" aria-hidden="true" > Online Job Portal</i>
           </h1>
       </div>
    </div>
    
    
</body>
</html>