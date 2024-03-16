
<%@page import="com.mysql.cj.exceptions.DeadlockTimeoutRollbackMarker"%>
<%@page import="com.entity.jobDetails"%>
<%@page import="com.daoLayer.jobDAO"%>
<%@page import="com.serviceLayer.jobServiceLayer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Job</title>
<!-- adding css -->
<%@include file="allComponent/allCSS.jsp"%>

</head>
<body style="background-color: #e4f5f3">

	<!-- if user is not admin then provide no access to editjob.jsp redirect user to login page -->
	<c:if test="${user.role ne 'admin'}">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<!-- adding navbar -->
	<%@include file="allComponent/navbar.jsp"%>


	<!-- add job form -->

	<div class="container mt-5">
		<div class="col-md-10 offset-md-1">
			<div class="card">
				<div class="card-body">
					<div class="text-center text-info">
						<i class="fa fa-user-friends fa-3x"></i>
						<h5>Edit Job</h5>

						<%
						//fetch id from url which set in edit button in editJob.jsp
						int id = Integer.parseInt(request.getParameter("id"));
						// fetch particular object from datbase
						jobDetails details = jobServiceLayer.getJobbyId(id);
						%>
					</div>
					<!-- got updatejob servlet -->
					<form action="updateJob" method="post">


						<!-- this is hiiden id which we will get in updatejobservlet to update particular job to up -->
						<input type="hidden" name="id" value=" <%=details.getJobId()%> ">

						<div>
							<label class="fw-bold"> Enter Title</label> <input type="text"
								name="jobTitle" class="form-control"
								value="<%=details.getTitle()%>">
						</div>

						<br>
						<div class="row mb-3">
							<div class="col">
								<label class="fw-bold">Location</label> <select
									class="form-select" aria-label="Dropdown 1" name="location">
									<option value="<%=details.getLocation()%>">
										<%=details.getLocation()%>
									</option>
									<option value="Karachi">Karachi</option>
									<option value="Lahore">Lahore</option>
									<option value="Islamabad">Islamabad</option>
								</select>
							</div>
							<div class="col">
								<label class="fw-bold">Category</label> <select
									class="form-select" aria-label="Dropdown 2" name="category">
									<option value="<%=details.getCategory()%>">
										<%=details.getCategory()%>
									</option>
									<option value="Developer">Developer</option>
									<option value="Engineer">Engineer</option>
									<option value="Doctor">Doctor</option>
									<option value="Bnaking">Bnaking</option>
								</select>
							</div>
							<div class="col">
								<label class="fw-bold">Status</label> <select
									class="form-select" aria-label="Dropdown 3" name="status">
									<option value="<%=details.getStatus()%>"><%=details.getStatus()%></option>
									<option value="Active">Active</option>
									<option value="Pending">Pending</option>

								</select>
							</div>
						</div>

						<div class="form-group">
							<label class="fw-bold">Enter Description</label>
							<textarea class="form-control" name="description" rows="6"> <%=details.getDescription()%> </textarea>
						</div>
						<br>

						<div class="text-center">
							<button class="btn btn-info" type="submit">Update</button>
						</div>


					</form>
				</div>
			</div>
		</div>
	</div>


</body>
</html>