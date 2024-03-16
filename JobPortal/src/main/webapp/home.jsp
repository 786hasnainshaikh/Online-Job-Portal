<%@page import="com.entity.jobDetails"%>
<%@page import="com.daoLayer.jobDAO"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<%@ include file="allComponent/allCSS.jsp"%>
</head>
<body style="background-color: #e4f5f3">

	<!-- if user is empty or null defined in loginservlet then provide no access to home.jsp  redirct to login -->
	<c:if test="${empty user }">
		<c:redirect url="login.jsp">
		</c:redirect>
	</c:if>



	<!-- adding navbar -->

	<%@ include file="allComponent/navbar.jsp"%>

	<div class="container mt-4">
		<div class="row">
			<div class="col-md-12">
				<h5 class="text-center text-info ">ALL JOBS</h5>

				<c:if test="${not empty succmsg }">
					<h4 class="text-center text-danger">${succmsg}</h4>
					<c:remove var="succmsg" />
				</c:if>

				<br>


				<%
				// fetch all jobs whose status is active
				List<jobDetails> activeJobs = jobDAO.getActiveJobs();
				for (jobDetails jobs : activeJobs) {
				%>

				<div class="card-mt 2" style="background-color: white">
					<div class="card-body">
						<div class="text-center text-info">
							<i class="far fa-clipboard fa-2x"></i>
						</div>

						<h6>
							<%=jobs.getTitle()%>
						</h6>

						<%
						if (jobs.getDescription().length() > 0 && jobs.getDescription().length() < 120) {
						%>
						<p>
							<%=jobs.getDescription()%>
						</p>
						<%
						} else {
						%>
						<p>
							<%=jobs.getDescription().substring(1, 120)%>....
						</p>

						<%
						}
						%>



						<br>
						<div class="row mb-3">
							<div class="col">
								<input type="text" class="form-control form-control-sm"
									value="location: <%=jobs.getLocation()%>" readonly>
							</div>
							<div class="col">
								<input type="text" class="form-control form-control-sm"
									value="Category: <%=jobs.getCategory()%> " readonly>

							</div>
							<div class="col">
								<input type="text" class="form-control form-control-sm"
									value="Status: <%=jobs.getStatus()%> " readonly>
							</div>
						</div>
						<h6>
							Publish Date:
							<%=jobs.getPublishDate()%>
						</h6>


						<div class="text-center">
						<!-- go to viewmore.jsp with particular id -->
							<a href="viewMore.jsp?id=<%=jobs.getJobId()%>"
								class="btn btn-sm bg-success text-white">View More </a>


						</div>

					</div>
				</div>

				<br>
				<%
				}
				%>

			</div>
		</div>

	</div>
</body>
</html>