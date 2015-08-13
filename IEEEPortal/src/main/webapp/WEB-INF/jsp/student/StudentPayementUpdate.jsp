<%@page errorPage="error"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
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
<script type="text/javascript">

function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 ||charCode > 57)) 
    {
        return false;
    }
    return true;
}
function isValidamt() {
   // alert("hi");
    var var1 = document.getElementById("paidamt").value;
    var var2 = document.getElementById("unpaid").value;
    var var3=parseInt(var2, 10)
    var paid=document.getElementById('paidamt');
//alert("paidamt var1: "+var1);
//alert("unpaid var3: "+var3);

    if (var1>var3) 
    {
    	alert("Enter valid amount");
    	paid.value="";
        return false;
    }
    return true;
}


function confirmComplete() {
	//alert("confirmComplete");
	    var var1 = document.getElementById("paidamt").value;

	var answer=confirm("Amount to be paid is: "+var1);
	if (answer==true)
	  {
	    return true;
	  }
	else
	  {
	    return false;
	  }
	}
</script>

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
					<a href="./SerachStudent">Enquired</a>
				</li>
				<li class="hvr-sweep-to-top">
					<a href="#">Domains</a>
				</li>
				<li class="hvr-sweep-to-top">
					<a href="#">Project Assignment</a>
				</li>
                <li class="hvr-sweep-to-top">
					<a href="#">Project Requirement</a>
				</li>
                <li class="hvr-sweep-to-top" id="active">
					<a href="./StudentPayment">Payment</a>
				</li>
                <li class="hvr-sweep-to-top">
					<a href="#">Reports</a>
				</li>				
 				
			</ul>
		</div>
	</div>
	<input id='lc' type='hidden' value='${sessionScope.currentusername}' />
	<h1>Payement Details</h1>
	<form action="./UpdatePayementServlet" method="post">
	<c:forEach items="${sessionScope.srchstud}" var="data">
        
              <c:set var="grpid" value="${data.grpid}"/> 

		</c:forEach>
		<br> Group id: <c:out value="${grpid}" />
		<br><br>
		 Name of students:
		
		<c:forEach items="${sessionScope.srchstud}" var="data">
        
              <c:set var="grpid" value="${data.grpid}"/> 
			&nbsp;
			<c:out value="${data.stdname }" />
              <c:set var="prjname" value="${data.projname }"/> 

			<c:set var="tot" value="${data.tfee }"/>
			<c:set var="paid" value="${data.paidtamt }"/>
			<c:set var="unp" value="${data.unpaidamt }"/>
    
		</c:forEach>
				
		
		<br><br>
            Project :<c:out value="${prjname }" />
			<br>			<br>
			
            Total fees :<c:out value="${tot }" />
			<br>			<br>
			
            Paid fees :<c:out value="${paid }" />
			<br> 			<br>
			
            Unpaid fees:<c:out  value="${unp }" />
			<br>			<br>
			<input type="hidden" id="unpaid" value="${unp }" >
        Group Id :<input type="text" readonly="readonly" name="grpid" value="${grpid}"> 
        <br>			<br>
        
		Amount to be pay :&nbsp;<input type="text" id="paidamt" name="paidamt" required="required" onblur="return isValidamt()" > <br>
					<br>
		Enter Receiver Employee Id :&nbsp;<input type="text" name="empid" required="required"> <br>
					<br>
		<input type="submit" value="Submit" onclick="return confirmComplete()">

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