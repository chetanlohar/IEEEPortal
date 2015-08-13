<%@page errorPage="error"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="UTF-8">
<title>IPMS</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources_ui/css/style1.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources_ui/css/reset.css" />
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
			    <li class="hvr-sweep-to-top"  >
					<a href="#">Home</a>
				</li>
				<li class="hvr-sweep-to-top">
					<a href="StudentEnquiryController?action=showdata">Enquiry</a>
				</li>
				<li class="hvr-sweep-to-top" id="active">
					<a href="DomainSelection?action=selectdomain">Domains</a>
				</li>
				<li class="hvr-sweep-to-top">
					<a href="login">Login</a>
				</li>
				</ul>
		</div>
	</div>
	<input id='lc' type='hidden' value='${sessionScope.currentusername}' />
	<br>
	<br>
	<form action="DomainSelection?action=domainpapers" method="post">
		<label>Domain : </label> <select id="enqDomain" name="dom">
			<option value="0" selected>Select Domain</option>
			<c:forEach var="domain" items="${sessionScope.domainList}">
				<option value="${domain.domainId}">${domain.domainName}</option>
				<c:set var="domainname" value="${domain.domainName}"
					scope="application" />
			</c:forEach>
		</select> <input type="submit" value="submit">
	</form>

	<div class="CSSTableGenerator">
		<h2 align="center">${dName}Paper List</h2>
		<br>
		<table>
			<tr>
				<th>ID</th>
				<th>Year</th>
				<th>Name</th>
				<th>Action</th>
			</tr>
			<c:choose>

				<c:when test="${ empty prjlist}">
					<tr>
						<td colspan="5"><font style="text-align: center" size="3em">There
								are no results to display!!</font></td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${sessionScope.prjlist}" var="data">
						<tr>
							<td><c:out value="${data.prjid}" /></td>
							<td><c:out value="${data.prjyear }" /></td>
							<td><c:out value="${data.prjtitle }" /></td>
							<td><a href="OpenFile?action=abstract&path=${data.prjpath}">Abstract</a>/<a
								href="OpenFile?action=basepaper&path=${data.prjpath}">BasePaper</a></td>
						</tr>
					</c:forEach>



				</c:otherwise>
			</c:choose>
		</table>
	</div>

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