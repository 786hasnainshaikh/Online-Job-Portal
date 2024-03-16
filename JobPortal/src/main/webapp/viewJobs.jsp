<%@page import="com.entity.jobDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.serviceLayer.jobServiceLayer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Veiw Jons</title>
<!-- add css -->
<%@include file="allComponent/allCSS.jsp"%>
</head>
<body style="background-color: #e4f5f3">

<!-- if user is not admin then provide NO access to viewjobs.jsp redirect user to login page -->

  <c:if test="${user.role ne 'admin'}">
    <c:redirect url="login.jsp"></c:redirect>
</c:if>
 


	<!-- adding navbar -->
	<%@include file="allComponent/navbar.jsp"%>



	<div class="container mt-4">
		<div class="row">
			<div class="col-md-12">
				<h4 class="text-center text-info">All Jobs</h4>

                 <!-- get session value which we set in update ob servlet -->
						<!-- if job updated into database successfully or not show message then after refresh remove message-->
						<c:if test="${ not empty msg}">
							<p class="alert alert-success text-center" role="alert">${msg}</p>
							<c:remove var="msg" />
						</c:if>

				<%
				// fetch all job objects from database
				List<jobDetails> allJobs = jobServiceLayer.getJobDetails();
                // display all jobs on viewjobs.jsp using for loop
				for (jobDetails jobs : allJobs) {
				%>
				
				
				<div >
				
				
				</div>
             
				<div class="card-mt 2" style="background-color: white" >
					<div class="card-body" >
						<div class="text-center text-info" >
							<i class="far fa-clipboard fa-2x"></i>
						</div>

						<h6>
							<%=jobs.getTitle()%>
						</h6>
						
						<!-- if description is > 120 show only < 120 length -->
						<%
						  if (jobs.getDescription().length() >0 && jobs.getDescription().length() <120 ){ %>
						  <p>  <%=jobs.getDescription() %> </p>	  
					   <% }
						  else{
					   %>		  
							<p>  <%=jobs.getDescription().substring(1,120)%>.... </p>	
							   
						<%}
						%>
						<br>
						<div class="row mb-3">
							<div class="col">
								<input type="text" class="form-control form-control-sm"
									value="location: <%=jobs.getLocation()%>" readonly >
							</div>
							<div class="col">
								<input type="text" class="form-control form-control-sm"
									value="Category: <%=jobs.getCategory()%>" readonly>

							</div>
							<div class="col">
								<input type="text" class="form-control form-control-sm"
									value="Status: <%=jobs.getStatus()%>" readonly>
							</div>
						</div>
						<h6>
							Publish Date: <%=jobs.getPublishDate()%>
						</h6>
						
						<!-- we create edit.jsp but in case of delete we create delete servlet -->
						<!-- by default in <a> tage we to override doget method -->
						<div class="text-center">
						<!-- got to edit.jsp with particilar id in url -->
							<a href="editJob.jsp?id=<%=jobs.getJobId() %>" class="btn btn-sm bg-success text-white">Edit </a> 
							<!-- got to deleteServlet with particular id with particilar id in url -->
						<a	href="deleteServlet?id=<%=jobs.getJobId() %>" class="btn btn-sm bg-danger text-white">Delete </a>
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