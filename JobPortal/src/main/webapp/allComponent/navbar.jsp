<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-custom">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Online Job Portal</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="index.jsp">Home</a></li>


				<!-- if user is admin  post and view jobs option shows -->

				<c:if test="${user.role eq 'admin' }">
					<li class="nav-item"><a class="nav-link" href="add_Job.jsp"><i
							class="fa-solid fa-circle-plus"></i> Post Jobs</a></li>

					<li class="nav-item"><a class="nav-link" href="viewJobs.jsp">
							<i class="fa-solid fa-eye"></i> View Jobs
					</a></li>
				</c:if>


			</ul>
			<form class="d-flex">

				<div class="mt-2"></div>
				
				
				
				<!-- if  admin logins show admin and logout button-->
				<c:if test="${user.role eq 'admin' }">
					<a href="#" class="btn btn-light btn-success"> <i
						class="fa-solid fa-user"></i> Admin
					</a>
					
					&nbsp &nbsp
				     <!-- when user click logout destroy the object defined in  logOutServlet-->
					 <a href="logOutServlet" class="btn btn-light btn-success"> <i
						class="fa fa-sign-in-alt"></i> Log out
			     	</a> 
					
				</c:if>
			<!-- if user login  show user name in login button and logout button-->
			     <c:if test="${user.role eq 'user' }">
					<a href="#" class="btn btn-light btn-success"> <i
						class="fa-solid fa-user"></i> ${user.name}
					</a>
					&nbsp &nbsp
					<!-- when user click logout destroy the object defined in  logOutServlet -->
					 <a href="logOutServlet" class="btn btn-light btn-success"> <i
						class="fa fa-sign-in-alt"></i> Log out
			     	</a>  
					  
				</c:if> 
			   
				
				

				<!-- if user is  null means admin not login then show sign in and sign up button-->
				<c:if test="${ empty user }">
					<a href="login.jsp" class="btn btn-light btn-success"> <i
						class="fa-solid fa-user"></i> Login
					</a>
				 &nbsp &nbsp <a href="signUp.jsp" class="btn btn-light btn-success"> <i
						class="fa-solid fa-user-plus"></i> Sign Up
					</a>
				</c:if>


			</form>
		</div>
	</div>
</nav>