<%@page import="com.ieeeportal.entity.CityEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enquiry form</title>
<!-- <link rel="stylesheet" href="resources_ui/css/style.css"> -->
<link rel="stylesheet" href="<%= request.getContextPath()%>/resources_ui/css/style1.css" />
<link rel="stylesheet" href="<%= request.getContextPath()%>/resources_ui/css/reset.css">

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {

						var i = 0;
						$('.add')
								.live(
										'click',
										function() {

											var td = $(this).closest('td');
											if (td.find('input:text').length < 7) {
												i++;

												td
														.append('<tr><td style="border:none;"><input style="margin:3px 3px 0px -3px;" type="text" id="enqEmail'+i+'" required="required"/><input type="button" id="rmvbtn" value="-" /> </td></tr>');
											}
										});
						$('#rmvbtn').live('click', function() {
							{
								$(this).closest('td').remove();
								i--;
							}

						});
					})

	$(document)
			.ready(
					function() {
						var i = 0;
						$('#add1')
								.live(
										'click',
										function() {

											var td = $(this).closest('td');
											if (td.find('input:text').length < 5) {
												i++;

												td
														.append('<tr><td style="border:none;"><input style="margin:3px 3px 0px -3px;" type="text" id="enqCont'+i+'" value="" /><input type="button" id="rmvbtn1" value="-" /> </td></tr>');
											}
										});
						$('#rmvbtn1').live('click', function() {
							{
								$(this).closest('td').remove();
								i--;
							}
						});
					})
</script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var i = 0;
						var j = 2;
						$("#addCF")
								.live(
										'click',
										function() {
											i++;
											{
												$("#mytable")
														.append(
																'<tr valign="top"><td><input type="text" style="width:50px;" value="'+j +'" class="code" id="srNo" name="sr" readonly="readonly"/></td><td><input type="text" class="code" id="sname'+i+'" name="sname"/><td><input style="margin:3px 3px 0px 0px;" type="text" class="code" id="enqEmail'+i+'"/><td><input style="margin:3px 3px 0px 0px;" type="text" class="code" id="enqCont'+i+'"/><td><select id="enqGender'+i+'"><option>M</option><option>F</option></select></td><td><a href="javascript:void(0);" id="remCF">Remove</a></td></tr>');
											}
											j++;
										})
						$("#remCF").live('click', function() {
							$(this).closest('tr').remove();
							i--;
						})
					});
</script>
<script type=text/javascript>
	$(function() {

		$('#getdata').click(function() {

			alert("hiii")
			alert($('#enqDate').val())

			var name = [];
			var email = [];
			var contact = [];
			var gender = [];

			//if($('#enqName').val())
			//{

			//}

			name.push($('#sname').val());
			alert($('#sname').val())
			for (i = 0; i < 4; i++) {
				if ($('#sname' + i).val()) {

					name.push($('#sname' + i).val());
					alert($('#sname' + i).val())
				}//email if end 
			}//for end	

			gender.push($('#enqGender').val());
			alert($('#enqGender').val())
			for (i = 0; i < 4; i++) {
				if ($('#enqGender' + i).val()) {

					gender.push($('#enqGender' + i).val());
					alert($('#enqGender' + i).val())
				}//email if end 
			}//for end	

			email.push($('#enqEmail').val());
			alert($('#enqEmail').val())
			for (i = 0; i < 4; i++) {
				if ($('#enqEmail' + i).val()) {

					email.push($('#enqEmail' + i).val());
					alert($('#enqEmail' + i).val())
				}//email if end 
			}//for end	

			contact.push($('#enqCont').val());
			alert($('#enqCont').val())
			for (i = 0; i < 4; i++) {
				if ($('#enqCont' + i).val()) {

					contact.push($('#enqCont' + i).val());
					alert($('#enqCont' + i).val())
				}//email if end 
			}//for end	

			$.ajax({

				url : 'StudentEnquiryController?action=submitenquiry',
				type : 'post',
				datatype : 'json',
				data : {

					enquirydata : JSON.stringify({
						"enDate" : $('#enqDate').val(),
						"enCity" : $('#enqCity').val(),
						"enClg" : $('#enqColg').val(),
						"enDept" : $('#enqDept').val(),
						"enDomain" : $('#enqDomain').val(),
						"enTech" : $('#enqTech').val(),
						"enTeamsz" : $('#enqTeamSz').val(),
						"enRef" : $('#enqRef').val(),
						"enqGender" : gender,
						"enName" : name,
						"enEmail" : email,
						"enCont" : contact
					})
				},

				success : function() {
					alert('Thanks for enquiry!!!')
					$("#EnquiryForm").each(function(){
						this.reset();
					});
					
					
				},

				error : function() {

					alert('error')
				}

			});

		});
	});
</script>

<script>
					
	function validation() {

		if($("#enqCity").val()=="" ||$("#enqCity").val()==0){
			alert("Please Select City");
			$("#enqCity").focus();
		}
		
		if($("#enqColg").val()==""|| $("#enqColg").val() == 0){
			alert("Please  Select College Name");		
			$("#enqColg").focus();
		}
		
		if($("#enqDept").val()==""|| $("#enqDept").val() == 0){
			alert("Please  Select Department");		
			$("#enqDept").focus();
		}
		
		if($("#enqDomain").val()==""|| $("#enqDomain").val() == 0){
			alert("Please  Select Domain");		
			$("#enqDomain").focus();
		}
		
		if($("#enqTech").val()==""|| $("#enqTech").val() == 0){
			alert("Please  Select Technology");		
			$("#enqTech").focus();
		}
		
		if($("#enqTeamSz").val()==""|| $("#enqTeamSz").val() == 0){
			alert("Please  Select Team Size");		
			$("#enqTeamSz").focus();
		}
		
		if($("#enqRef").val()==""|| $("#enqRef").val() == 0){
			alert("Please  Select Reference");		
			$("#enqRef").focus();
		}
		
				
	}
					
</script>


</head>
<body>
	<div id="header">
		<div class="clearfix">
			<div class="logo">
				<h1 style="color:#000;font-size: 1.9em;">IEEE Project Management System(IPMS)</h1>
			</div>
			<ul class="navigation">
			    <li class="hvr-sweep-to-top"  >
					<a href="./">Home</a>
				</li>
				<li class="hvr-sweep-to-top" id="active">
					<a href="#">Enquiry</a>
				</li>
				<li class="hvr-sweep-to-top">
					<a href="login">Login</a>
					 
				</li>
				
				
			</ul>
		</div>
	</div>
	<c:set var="now" value="<%=new java.util.Date()%>" />
	<div class="containts">
		<form id="EnquiryForm" name = "form">
            <br>
			<h1>Enquiry Form</h1>
            <br>  
			<div>
				<label>Enquiry Date :</label> <input type="text" id="enqDate"
					 readonly="readonly"  value="<fmt:formatDate type="both" value="${now}" />" >
			</div>
			
			
			<script>
				function myFunction() {
					document.getElementById('enqDate').value = Date();
				}
			</script>
			<div>
				<label> City :</label> 
				<select id="enqCity" name="select">
					<option value="0" selected>select city</option>
					<c:forEach var="city" items="${sessionScope.cityList}">
						<option value="${city.cityId}">${city.cityName}</option>
					</c:forEach>
				</select>
			</div>

			<div>
				<label> College :</label> 
				<select id="enqColg">
					<option value="0" selected>select college</option>
					<c:forEach var="college" items="${sessionScope.collegeList}">
						<option value="${college.collegeId}">${college.collegeName}</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<label> Department :</label> <select id="enqDept">
					<option value="0" selected>select Department</option>
					<option>Computer</option>
					<option>Information Technology</option>

				</select>
			</div>
			<div>
				<label>Domain :</label> <select id="enqDomain" name="domain">
					<option value="0" selected>select Domain</option>
					<c:forEach var="domain" items="${sessionScope.domainList}">
						<option value="${domain.domainId}">${domain.domainName}</option>
					</c:forEach>
					</select>
			</div>
			<div>
				<label>Technology :</label> <select id="enqTech">
					<option value="0" selected>select Technology</option>
					<option value="JAVA">JAVA</option>
					<option >.NET</option>
					<option >ANDROID</option>
					<option >CPP</option>
				</select>
			</div>
			<div>
				<label>Team Size :</label> <select id="enqTeamSz">
					<option value="0" selected>select Your TeamSize</option>
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
				</select>
			</div>
			<br> <br>


			<div>
				<label>Reference from :</label> <select id="enqRef">
					<option value="0" selected>select Reference</option>
					<c:forEach var="reference" items="${sessionScope.referenceList}">
						<option value="${reference.referenceId}">${reference.referenceName}</option>
					</c:forEach>

				</select>
			</div>
			<br> <br>


			<h1>Personal Details</h1>


			<table id="mytable" class="form-table">
				<tr>
					<th>Sr.no</th>
					<th>Name</th>
					<th>Email Id</th>
					<th>Contact No</th>
					<th>Gender</th>
					<th style="border-left: none;"></th>
				</tr>
				<tr valign="top">
					<td><input type="text" class="sr" name="sr" id="srNo"
						value="1" readonly="readonly"></td>
					<td><input type="text" name="sname" id="sname"></td>
					<td><input type="text" class="code" id="enqEmail"
						required="required" /> <!--  <input type="button" class="code add"  value="+" /> -->
					</td>
					<td><input type="text" class="code" id="enqCont" value="" />
						<!-- <input type="button" class="code" id="add1" value="+" /> -->
					</td>

					<td><select id="enqGender">
							<option>M</option>
							<option>F</option>
					</select></td>

					<td><a href="javascript:void(0);" id="addCF">Add</a></td>
				</tr>

			</table>


			<input type="button"    onclick="validation();"     id="getdata" value="Submit">

		</form>
		<br>
	</div>
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