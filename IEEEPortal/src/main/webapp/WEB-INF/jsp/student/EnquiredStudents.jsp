<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="UTF-8">
<title>IPMS</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources_ui/css/style1.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources_ui/css/reset.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources_ui/js/jquery-1.11.0.js"></script>
<script>
	$(document).ready(function() {

		$('#city').change(function() {
			$('#street option').hide();
			$('#street option[value="' + $(this).val() + '"]').show();
		});
	});
</script>
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
				<h1 style="color: #000; font-size: 1.9em;">IEEE Project
					Management System(IPMS)</h1>
			</div>
			<ul class="navigation">
				<li class="hvr-sweep-to-top"><a href="adminhome">Home</a></li>
				<li class="hvr-sweep-to-top" id="active"><a href="#">Enquired</a>
				</li>
				<li class="hvr-sweep-to-top"><a
					href="DomainSelection?action=selectdomain">Domains</a></li>
				<li class="hvr-sweep-to-top"><a
					href="AdminProjectAssignment?action=showData">Project
						Assignment</a></li>
				<li class="hvr-sweep-to-top"><a href="SerachStudent">Project
						Requirement</a></li>
				<li class="hvr-sweep-to-top"><a href="StudentPayment">Payment</a>
				</li>
				<li class="hvr-sweep-to-top"><a href="#">Reports</a></li>

			</ul>
		</div>
	</div>
	<input id='lc' type='hidden' value='${sessionScope.currentusername}' />
	<form action="./StudentEnquiryController?action=showspenquired"
		method="post">
		<br> Enter the name / enquiry id <br> <input type="text"
			align="middle" name="name"> <input type="submit"
			value="Search">
	</form>
	<br>
	<div
		style="float: right; margin-bottom: 5px; margin-right: 5px; font-size: 1em">
		<a href="">send SMS</a>&nbsp;|&nbsp;<a href="">send EMAIL</a>
	</div>
	<div class="CSSTableGenerator">
		<h2 align="center">Enquired Student List</h2>
		<br>
		<table>

			<tr bgcolor="#FFE0AF">
				<th>SMS/Mail</th>
				<th>Enquiry ID</th>
				<th>Enquiry Date</th>
				<th>Student Names</th>
				<th>Phone No.</th>
				<th>Email ID</th>
				<th>College Name</th>
				<th>Action</th>

			</tr>
			<c:choose>

				<c:when test="${ empty sessionScope.enquiredstudentlist}">
					<tr>
						<td colspan="8"><font style="text-align: center" size="3em">There
								are no results to display!!</font></td>
					</tr>
				</c:when>
				<c:otherwise>

					<c:forEach items="${sessionScope.enquiredstudentlist}" var="data">

						<tr>
							<td><input type="checkbox" value="smsmailcheck"></td>
							<td><c:out value="${data.enqid}" /></td>
							<td><c:out value="${data.enqdate }" /></td>
							<td><c:out value="${data.stdname }" /></td>
							<td><c:out value="${data.phoneno }" /></td>
							<td><c:out value="${data.emailid }" /></td>
							<td><c:out value="${data.clgname }" /></td>
							<td><a
								href="./StudentRegistrationController?action=register&enqid=${data.enqid}">Register</a></td>
						</tr>

					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
	<br>
	<br>
	<a href="./StudentEnquiryController?action=showallenquired">Get All
		List</a>
	<div style="margin-top: 50px;" id="footer">

		<div id="footnote">

			<p class="col-lg-6 col-md-6 col-sm-12 col-xs-12 templatemo-copyright">Designed
				& Developed &copy; 2015 Softinfology pvt.ltd</p>
			<p class="col-lg-6 col-md-6 col-sm-12 col-xs-12 templatemo-social">
				<a href="#"><i class="fa fa-facebook fa-medium"></i></a> <a href="#"><i
					class="fa fa-twitter fa-medium"></i></a> <a href="#"><i
					class="fa fa-google-plus fa-medium"></i></a> <a href="#"><i
					class="fa fa-youtube fa-medium"></i></a> <a href="#"><i
					class="fa fa-linkedin fa-medium"></i></a>
			</p>

		</div>
	</div>

</body>
</html>