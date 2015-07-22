<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EmployeeRegistration</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/resources_ui/css/style1.css" />
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources_ui/css/reset.css" />
	<script type="text/javascript" src="js/loginformvalidation.js"></script>
	

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="./resources_ui/js/jquery-1.10.2.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$('#getEmpData').click(function() {

			alert("Hello from Emp Data")

			$.ajax({

				url : 'EmployeeRegistration?action=registerdata',
				type : 'post',
				datatype : 'json',
				data : {

					empdata : JSON.stringify({
						"empName" : $('#empName').val(),
						"empEmailID" : $('#empEmailID').val(),
						"empPassword" : $('#empPassword').val(),
						"empDOJ" : $('#empDOJ').val(),
						"empDesignation" : $('#empDesignation').val(),
						"empContactNo" : $('#empContactNo').val(),
						"empGender" : $('#empGender').val(),
						"empRole" : $('#empRole').val(),
						"empDOJ" : $('#empDOJ').val(),
						"empAddress" : $('#empAddress').val(),
						"reportingManager" : $('#reportingManager').val()
					})

				},

				success : function() {

					alert($('#empDOJ').val());
					alert("Sucessfully rendered to controller")
				},

				error : function() {
					alert("error comes while submitting data to controller")
				}

			});

		});

	});
</script>


</head>
<body>
	<div id="header">
		<div class="clearfix">
			<div class="logo">
				<h1 style="color: #000; font-size: 1.9em;">IEEE Project
					Management System(IPMS)</h1>
			</div>
			<ul class="navigation">
				<li class="hvr-sweep-to-top"><a href="./">Home</a></li>
				<li class="hvr-sweep-to-top" id="active"><a href="#">Registration</a></li>
				<li class="hvr-sweep-to-top"><a href="login">Login</a></li>


			</ul>
		</div>
	</div>

	<div class="containts">
		<!--Employee Registration form--->
		<form style="height:560px;">
			<!-- After Submitting goes to Employee Registration Controller-->
			<br>
			<h1>Employee Registration Form</h1>
			<br>
			<div>
				<label>Employee Name:</label> <input type="text" id="empName" />
			</div>

			<div>
				<label>EmailID:</label> <input type="text" id="empEmailID">
			</div>

			<div>
				<label>Password:</label><input type="password" id="empPassword">
			</div>

			<div>

				<label>Date OF Joining:</label><input type="text" id="empDOJ">

			</div>


			<div>
				<label>Designation:</label> <select value=" " id="empDesignation">
					<option value="JavaDeveloper">jr.JavaDeveloper</option>
					<option value="Tester">Tester</option>
					<option value="BA">BA</option>
					<option value="WebDesigner">WebDesigner</option>
					<option value="TLA">TLA</option>
					<option value="Manager">Manager</option>
					<option value="MD">MD</option>
				</select>


			</div>

			<div>
				<label>Role:</label> <select value=" " id="empRole">
					<option value="Admin">Admin</option>
					<option value="Employee">Employee</option>
				</select>


			</div>
		<div>
				<label>Reporting Manager:</label>
				<select id="reportingManager">
					<option value=" ">Select Reporting Manager</option>
					<c:forEach var="EmpName" items="${sessionScope.EmpNameList}">
						<option value="${EmpName.empName}">${EmpName.empName}</option>
					</c:forEach>
				</select>


			</div>



			<div>

				<label>ContactNo:</label> <input type="text" id="empContactNo">


			</div>
		<div>
				<label>Gender:</label> <select option=" " id="empGender">
					<option value="Male">Male</option>
					<option value="FeMale">FeMale</option>
				</select>

			</div>



			<div>
				<label>Address:</label> <input type="text" height="70px"
					width="25px" id="empAddress"><br>
				<br><br><input type="button" id="getEmpData" value="Register" style="margin-left: 205px">
				<input type="reset" value="Clear">
			</div>

		</form>
		<!-- End OF Form -->
		<br>
	</div>
	<div style="margin-top: 10px;" id="footer">

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

