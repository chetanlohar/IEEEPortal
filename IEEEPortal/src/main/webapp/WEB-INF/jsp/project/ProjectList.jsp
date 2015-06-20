<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<title>PMS</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<script src="js/loginchecker.js"></script>
</head>
<body>
	
	<div class="container">
		<h1 align="center">Project List</h1>
		<br> <br>
		<!--  <h2>Give your feedback after a file download in Interaction tab</h2>  -->
		<div class="CSSTableGenerator">
		<h2 align="center">${sessionScope.domain }</h2>
		
		
		
		
		
			<table width="700" border="2" align="center" bgcolor="#82CAFA">

				<tr bgcolor="#FAB282">
					<th >ID</th>
					<th>Name</th>
					<th>Path</th>
					<th>Year</th>
					
				</tr>
                 <c:choose>
     
			   <c:when test="${ empty prjlist}">
			   <tr><td colspan="5"><font style="text-align: center" size="3em">There are no results to display!!</font></td></tr>  
			   </c:when>
			   <c:otherwise>     

				<c:forEach items="${sessionScope.prjlist}" var="data">
                     <c:set var="dom" value="${data.prjdom }"/>
                     <c:set var="sdom" value="${sessionScope.domain }"/>    
					 <c:if test="${dom eq sdom }">
					<tr>
						<td bgcolor="#CCFFFF"><c:out value="${data.prjid}" /></td>
						<td bgcolor="#FFCCFF"><c:out value="${data.prjtitle }" /></td>
						<td bgcolor="#CCFFFF"><a href="./OpenFileServlet?path=${data.prjpath}"><c:out value="${data.prjpath }"/></a></td>
						<td bgcolor="#FFCCFF"><c:out value="${data.prjyear }" /></td>
						</tr>
					</c:if>
				</c:forEach>
				</c:otherwise>
				</c:choose>
			</table> 
			<a href="./">Home</a>
			<!--  <form action="Recommendation?action=evaluaterecommendation">
 			       <input type="submit" value="evaluate recommendation">
 			</form>-->
		</div>
	</div>

	<div id="footnote">

		<p class="col-lg-6 col-md-6 col-sm-12 col-xs-12 templatemo-copyright">
			Copyright &copy; 2015 Softinfology pvt ltd-Harshal
			<!-- Credit: www.templatemo.com -->
		</p>
		<p class="col-lg-6 col-md-6 col-sm-12 col-xs-12 templatemo-social">
			<a href="#"><i class="fa fa-facebook fa-medium"></i></a> <a href="#"><i
				class="fa fa-twitter fa-medium"></i></a> <a href="#"><i
				class="fa fa-google-plus fa-medium"></i></a> <a href="#"><i
				class="fa fa-youtube fa-medium"></i></a> <a href="#"><i
				class="fa fa-linkedin fa-medium"></i></a>
		</p>

	</div>


</body>
</html>