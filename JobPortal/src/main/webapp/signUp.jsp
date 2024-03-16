<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up page</title>
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
							<h5>Sign Up page</h5>
							
							
							<!-- show msg which set in signUpServlet (signup successfull or not)-->
							<c:if test="${ not empty msg}">
							<p class="alert alert-success" role="alert">${msg}</p>
							<c:remove var="msg" />
						   </c:if>

						</div>
						<!-- login form -->
						<form action="signUp" method="post">
						
						
						    <div class="form-group">
								<label class="fw-bold"> Enter Full Name</label> <input type="text"
									name="fullName" class="form-control">
							</div>
							<br>
							<div class="form-group">
								<label class="fw-bold"> Enter Qualification</label> <input type="text"
									name="qualification" class="form-control">
							</div>
						     <br>
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
                               <button class="btn btn-info" type="submit">Sign Up</button>
                            </div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>