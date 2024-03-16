<%@page import="com.entity.jobDetails"%>
<%@page import="com.serviceLayer.jobServiceLayer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View more About Job</title>
<%@ include file="allComponent/allCSS.jsp"%>
</head>
<body style="background-color: #e4f5f3">

 <!-- if user is not login or object is empty then provide NO access to viewmore.jsp redirct to login -->
<c:if test="${empty user }">
    <c:redirect url="login.jsp">
    </c:redirect>
</c:if>


	<%@ include file="allComponent/navbar.jsp"%>



	<div class="container mt-5">
		<div class="row">
			<div class="col-md-12">
				<%
				// fetch id from view more button in home.jsp
				int id = Integer.parseInt(request.getParameter("id"));
				jobDetails details = jobServiceLayer.getJobbyId(id);
				%>
				<div class="card-mt-5 bg-white">
					<div class="card-body">
					    <div class="text-center text-info">
					        <i class="far fa-clipboard fa-2x"></i>
					    </div>
					    
					    <h6> <%=details.getTitle() %> </h6>
					    <p> <%=details.getDescription() %> </p>
					    
					    <div class="row mb-3">
							<div class="col">
								<input type="text" class="form-control form-control-sm"
									value="location: <%=details.getLocation()%>" readonly >
							</div>
							<div class="col">
								<input type="text" class="form-control form-control-sm"
									value="Category: <%=details.getCategory()%>" readonly>

							</div>
							<div class="col">
								<input type="text" class="form-control form-control-sm"
									value="Status: <%=details.getStatus()%>" readonly>
							</div>
						</div>
						<h6>
							Publish Date: <%=details.getPublishDate()%>
						</h6>
					  
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>