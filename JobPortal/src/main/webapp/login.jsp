<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
<%@include file="allComponent/allCSS.jsp"%>
</head>
<body style="background-color: #e4f5f3">
	<%@include file="allComponent/navbar.jsp"%>
	<div class="container">
		<div class="row p-5">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<div class="text-center">
							<i class="fa fa-user-plus fa-2x" aria-hidden="true"></i>
							<h5>Login page</h5>
							
							
							<!-- if user is invalid or logged out show msg defined in loginservlet -->
							<c:if test="${ not empty userNotExist}">
							<p class="alert alert-success" role="alert">${userNotExist}</p>
							<c:remove var="userNotExist" />
						   </c:if>
						   
	
						   
 
						</div>
						<!-- login form -->
						<form action="login" method="post">
							<div class="form-group">
								<label class="fw-bold"> Enter Email</label> <input type="email"
									name="email" class="form-control">
							</div>
                             <br>
							<div class="form-group">
								<label class="fw-bold">Password</label> <input
									type="password" name="password" class="form-control">
							</div>
                            <br>
                            <div class="text-center">
                               <button class="btn btn-info" type="submit">Login</button>
                            </div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>