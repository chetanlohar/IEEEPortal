<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
	<title>IPMS</title>
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources_ui/css/style1.css" />
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources_ui/css/reset.css" />
	
	<script type="text/javascript" src="js/loginformvalidation.js"></script>
	
	</head>
<body>

	<div id="header">
	 <div class="clearfix">
			<div class="logo">
				<h1 style="color:#000;font-size: 1.9em;">IEEE Project Management System(IPMS)</h1>
			</div>
			<ul class="navigation">
				<li class="hvr-sweep-to-top">
					<a href="./">Home</a>
				</li>
				<li class="hvr-sweep-to-top">
					<a href="StudentEnquiry">Enquiry</a>
				</li>
				<li  class="hvr-sweep-to-top" id="active">
					<a href="#">Login</a>
				</li>
				
				
			</ul>
		 </div> 
	</div>
	<div class="main" style=""><br><br>
	
	
				<h1>Login</h1>
				<c:if test="${sessionScope.loginfailuremsg !=null}">
				<font color="red"><c:out value="${sessionScope.loginfailuremsg }"/></font>
				<% session.setAttribute("loginfailuremsg", null); %>
				</c:if>
				<form method="post" action="EmployeeLogin" class="message" name="loginform" onsubmit="return loginFormValidation();">
					<label>Username </label>
					<input type="text" name="loginuser" placeholder="Username">
				    <label>Password</label>
					<input type="password" name="loginpass" placeholder="Password"><br><br>
					<input type="radio" name="r1" value="Admin">Admin
					<input type="radio" name="r1" value="Employee">Employee
					<br><br>
					<input class="css_button" type="submit" value="Login" name="Submit"><br><br>
					<label>New User?</label> <a href="EmployeeRegistration?action=showdata">Register here</a>
				</form><br><br>
				
				
				
	</div>
	<div  class="image">
	
	</div>
	<div id="footer" style="margin-top: 547px;">
		
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