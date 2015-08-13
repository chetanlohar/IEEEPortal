<%@page errorPage="error"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML>
<html lang = "en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
	<meta charset="UTF-8">
	<title>IPMS</title>
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources_ui/css/style1.css" />
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources_ui/css/reset.css" />
</head>
</head>
<body onkeypress="return isNumber(event)" onkeydown="return isNumber(event)">

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
			    <li class="hvr-sweep-to-top" >
					<a href="adminhome">Home</a>
				</li>
			    <li class="hvr-sweep-to-top" >
					<a href="StudentEnquiryController?action=showenquired">Enquired</a>
				</li>
				<li class="hvr-sweep-to-top" >
					<a href="StudentRegistrationController?action=showCollegeName">Registered</a>
				</li>
				<li class="hvr-sweep-to-top">
					<a href="AdminProjectAssignment?action=showData">Project Assignment</a>
				</li>
                <li class="hvr-sweep-to-top">
					<a href="SerachStudent" id="active">Project Requirement</a>
				</li>
                <li class="hvr-sweep-to-top" >
					<a href="StudentPayment">Payment</a>
				</li>
                <li class="hvr-sweep-to-top">
					<a href="#">Reports</a>
				</li>				
 				
			</ul>
		</div>
	</div>
	<input id='lc' type='hidden' value='${sessionScope.currentusername}' />
	
	<h1>Payement Details</h1>
     <c:set var="grdata" value="${sessionScope.srchstud}" scope="application"/>
     
	<form action="./UpdateProjectRequirements" method="post">
       	
		
		<c:forEach items="${sessionScope.srchstud}" var="data">
        
               <c:set var="grpid" value="${data.grpid}"/>
             
             <c:set var="prjname" value="${data.projname }"/>
	
		<br><br> 	
		Name of students:	&nbsp;&nbsp; <c:out value="${data.stdname }" />
              <c:set var="stdname" value="${data.projname }"/> 

		</c:forEach>
	 	<br><br>
	 Group Id : &nbsp;&nbsp;&nbsp;<input type="text" readonly="readonly" name="grpid" value="${ grpid}" required="required">  <br><br>	
	 		
		<br>
	  	
		<label>Date :</label> <input type="text" name="date"
					 readonly="readonly"  value="<fmt:formatDate type="both" value="<%= new java.util.Date()%>" />" >	
		
		<br>
            Project :&nbsp;&nbsp;<c:out value="${prjname}" />
			<br>			<br>
		Requirements are :
		<br>
		 <textarea name="requirement" cols="30" rows="15" required="required"></textarea>	<br><br>		
		<input type="submit" value="Submit">
		 
	</form>
	<c:set var="msg" value="${sessionScope.msg}"/> 
			<c:out value="${msg}"></c:out>
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