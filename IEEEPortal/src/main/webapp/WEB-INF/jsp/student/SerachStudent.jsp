<%@page errorPage="error"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>IPMS</title>
	
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources_ui/css/style1.css" />
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources_ui/css/reset.css" />
</head>
<body>
<div class="currentuser">

		<span id="cuser"> ${sessionScope.currentusername}&nbsp; |
			&nbsp;<a href='EmployeeLogout?action=signout'><span>log-out</span></a>
		</span>
	</div>
	<div id="header">
		<div class="clearfix">
			<div class="logo">
				<h1 style="color:#000;font-size: 1.9em;">IEEE Project Management System(IPMS)</h1>
			</div>
			<ul class="navigation">
			    <li class="hvr-sweep-to-top">
					<a href="adminhome">Home</a>
				</li>
			    <li class="hvr-sweep-to-top"  >
					<a href="StudentEnquiryController?action=showenquired">Enquired</a>
				</li>
				<li class="hvr-sweep-to-top" >
					<a href="StudentRegistrationController?action=showCollegeName">Registered</a>
				</li>
				<li class="hvr-sweep-to-top">
					<a href="AdminProjectAssignment?action=showData">Project Assignment</a>
				</li>
                <li class="hvr-sweep-to-top" id="active">
					<a href="SerachStudent">Project Requirement</a>
				</li>
                <li class="hvr-sweep-to-top">
					<a href="StudentPayment">Payment</a>
				</li>
                <li class="hvr-sweep-to-top">
					<a href="#">Reports</a>
				</li>				
 				
			</ul>
		</div>
	</div>
	<input id='lc' type='hidden' value='${sessionScope.currentusername}' />
	<form action="./StudentDeatilsServelt" method="post">
		<br> Enter the name <br> <input type="text" align="middle"
			name="name"> <input type="submit">
	</form>
	<div class="container">
		<h1 align="center">Student Details</h1>
		<br> <br>
		<!--  <h2>Give your feedback after a file download in Interaction tab</h2>  -->
		<div class="CSSTableGenerator">
			<h2 align="center">Student List</h2>
			<table>

				<tr>
					<th>Group ID</th>
					<th>Name</th>
					<th>Project Title</th>
					<th>Technology</th>
					<th>Team Size</th>
					<th>College</th>
					<th>Requirements</th>
				</tr>
				<c:choose>

					<c:when test="${ empty srchstud}">
						<tr>
							<td colspan="9"><font style="text-align: center" size="3em">There
									are no results to display!!</font></td>
						</tr>
					</c:when>
					<c:otherwise>

						<c:forEach items="${sessionScope.srchstud}" var="data">

							<tr>
								<td ><c:out value="${data.grpid}" /></td>
								<td ><c:out value="${data.stdname }" /></td>
								<td ><c:out value="${data.projname }" /></td>
								<td ><c:out value="${data.tech }" /></td>
								<td ><c:out value="${data.teamsize }" /></td>

							<%-- 	<td ><c:out value="${data.tfee }" /></td>
								<td ><c:out value="${data.paidtamt }" /></td>
								<td ><c:out value="${data.unpaidamt }" /></td> --%>
								<td ><c:out value="${data.clgname }" /></td>
							
							<td><a href="./ProjectRequirements?groupID=${data.grpid}">ADD</a></td>
							
							</tr>

						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
			</div>
	</div><br><br>
	<a href="./GetAllStudentDetailsServlet">Get All List</a>
	<!-- <a href="./">Home</a> -->
	<div style="margin-top: 50px;" id="footer">
		
		<div id="footnote">
			
					<p class="col-lg-6 col-md-6 col-sm-12 col-xs-12 templatemo-copyright">Designed & Developed &copy; 2015 Softinfology pvt.ltd </p>
					<p class="col-lg-6 col-md-6 col-sm-12 col-xs-12 templatemo-social">
						<a href="#"><i class="fa fa-facebook fa-medium"></i></a>
						<a href="#"><i class="fa fa-twitter fa-medium"></i></a>
						<a href="#"><i class="fa fa-google-plus fa-medium"></i></a>
						<a href="#"><i class="fa fa-youtube fa-medium"></i></a>
						<a href="#"><i class="fa fa-linkedin fa-medium"></i></a>
					</p>
				
		</div>
	</div>

</body>
</html>