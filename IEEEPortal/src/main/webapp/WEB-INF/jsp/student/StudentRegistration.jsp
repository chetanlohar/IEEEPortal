<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="UTF-8">
<title>IPMS</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources_ui/css/style1.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources_ui/css/reset.css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var i = 0;
						$("#addCF")
								.live(
										'click',
										function() {
											i++;
											{
												$("#mytable")
														.append(
																'<tr valign="top"><td><input type="text" class="code" id="sname'+i+'" name="sname"/><td><input style="margin:3px 3px 0px 0px;" type="text" class="code" id="enqEmail'+i+'"/><td><input style="margin:3px 3px 0px 0px;" type="text" class="code" id="enqCont'+i+'"/><td><select id="enqGender'+i+'"><option>M</option><option>F</option></select></td><td><a href="javascript:void(0);" id="remCF">Remove</a></td></tr>');
											}
											j++;
										})
						$("#remCF").live('click', function() {
							$(this).closest('tr').remove();
							i--;
						})
					});
</script>
<script type="text/javascript">
	function getPapers() {
		var domainId = $('#pdomain').val();

		$.ajax({
			type : "POST",
			url : "StudentRegistrationController?action=showPaper",
			dataType : 'json',
			data : {
				domainData : JSON.stringify({
					"domainId" : domainId
				})
			},
			success : function(response) {
				alert("from getPapers: " + response);
				alert(response);
				$('#paperlist').find('option').remove().end();
				$('#paperlist').attr('enabled', 'true');
				$('#paperlist').append(
						$("<option value='0'></option>").text("--Select--"));

				jQuery.each(response, function(index, item) {
					$('#paperlist').append(
							$("<option></option>").text(this.prjtitle).val(
									this.prjtitle));
				});

			},
		});
	}
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

			//	name.push($('#sname').val());
			//		alert($('#sname').val())
			for (i = 1; i <= 4; i++) {
				if ($('#sname' + i).val()) {

					name.push($('#sname' + i).val());
					alert($('#sname' + i).val())
				}//email if end 
			}//for end	

			//	gender.push($('#enqGender').val());
			//	alert($('#enqGender').val())
			for (i = 1; i <= 4; i++) {
				if ($('#enqGender' + i).val()) {

					gender.push($('#enqGender' + i).val());
					alert($('#enqGender' + i).val())
				}//email if end 
			}//for end	

			//	email.push($('#enqEmail').val());
			//	alert($('#enqEmail').val())
			for (i = 1; i <= 4; i++) {
				if ($('#enqEmail' + i).val()) {

					email.push($('#enqEmail' + i).val());
					alert($('#enqEmail' + i).val())
				}//email if end 
			}//for end	

			//		contact.push($('#enqCont').val());
			//		alert($('#enqCont').val())
			for (i = 1; i <= 4; i++) {
				if ($('#enqCont' + i).val()) {

					contact.push($('#enqCont' + i).val());
					alert($('#enqCont' + i).val())
				}//email if end 
			}//for end	

			$.ajax({

				url : 'StudentRegistrationController?action=registerstudent',
				type : 'post',
				datatype : 'json',
				data : {

					registerdata : JSON.stringify({
						"enDate" : $('#enqDate').val(),
						"enCity" : $('#enqCity').val(),
						"enClg" : $('#enqColg').val(),
						"enDept" : $('#enqDept').val(),
						"enDomain" : $('#pdomain').val(),
						"enTech" : $('#enqTech').val(),
						"enTeamsz" : $('#enqTeamSz').val(),
						"enRef" : $('#enqRef').val(),
						"paperlist" : $('#paperlist').val(),
						"totalfees" : $('#totalfees').val(),
						"discount" : $('#discount').val(),
						"enqGender" : gender,
						"enName" : name,
						"enEmail" : email,
						"enCont" : contact
					})
				},

				success : function() {
					alert('Registration Successful !!!')
					$("#RegistrationForm").each(function() {
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
	<c:set var="now" value="<%=new java.util.Date()%>" />
	<div class="containts">
		<form name="RegistrationForm">

			<c:set var="flag" value="0" scope="page" />
			<c:forEach items="${sessionScope.studenttoreg}" var="enqdata">
				<c:if test="${flag eq 0}">
					<h1>Student Registration Form</h1>
					<br>
					<div>
						<label>Registration Date : </label> <input type="text"
							value="<fmt:formatDate type="both" value="${now}" />"
							name="regdate" id="enqDate" readonly="readonly">
					</div>
					<div>
						<label>City : </label>
						<%-- <input type="text"
							value="<c:out value="${enqdata.city }" />" name="city"
							readonly="readonly"> --%>
						<select id="enqCity" name="select">
							<option value="${enqdata.cityid }" selected>${enqdata.city }</option>
							<c:forEach var="city" items="${sessionScope.cityList}">
								<option value="${city.cityId}">${city.cityName}</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<label>College Name : </label>
						<%-- <input type="text"
							value="<c:out value="${enqdata.clgname }" />" name="clg"
							readonly="readonly"> --%>
						<select id="enqColg">
							<option value="${enqdata.clgid }" selected>${enqdata.clgname }</option>
							<c:forEach var="college" items="${sessionScope.collegeList}">
								<option value="${college.collegeId}">${college.collegeName}</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<label>Department : </label> <input type="text"
							value="<c:out value="${enqdata.dept }" />" name="dept"
							id="enqDept" readonly="readonly">
					</div>
					<div>
						<label>Domain : </label>
						<%-- <input type="text"
							value="<c:out value="${enqdata.domain }" />" name="dom"
							readonly="readonly"> --%>
						<select id="pdomain" onchange="getPapers()">
							<option value="${enqdata.domainid }" selected>${enqdata.domain }</option>
							<c:forEach var="domain" items="${sessionScope.domainList}">
								<option value="${domain.domainId}">${domain.domainName}</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<label>Technology : </label>
						<%-- <input type="text"
							value="<c:out value="${enqdata.tech }" />" name="tch"
							readonly="readonly"> --%>
						<select id="enqTech">
							<option value="${enqdata.tech }" selected>${enqdata.tech }</option>
							<option value="JAVA">JAVA</option>
							<option value=".NET">.NET</option>
							<option value="ANDROID">ANDROID</option>
							<option value="CPP">CPP</option>
						</select>
					</div>
					<div>
						<label>Team Size : </label>
						<%-- <input type="text"
							value="<c:out value="${enqdata.teamsize }" />" name="teamsz"
							readonly="readonly"> --%>
						<select id="enqTeamSz">
							<option value="${enqdata.teamsize }" selected>${enqdata.teamsize }</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</div>
					<div>
						<label>Project Title :</label> <select id="paperlist">
							<option value="0">Select Paper :</option>
							<c:forEach var="data" items="${papernamelist}">
								<option value="${data.prjtitle}">${data.prjtitle}</option>
							</c:forEach>
						</select>
						<%-- <input type="text"
							value="<c:out value="${enqdata.projname }" />" name="ptitle"
							readonly="readonly"> --%>



					</div>
					<div>
						<label>Reference From : </label>
						<%-- <input type="text"
							value="<c:out value="${enqdata.reference }" />" name="ptitle"
							readonly="readonly"> --%>
						<select id="enqRef">
							<option value="${enqdata.refid }" selected>${enqdata.reference }</option>
							<c:forEach var="reference" items="${sessionScope.referenceList}">
								<option value="${reference.referenceId}">${reference.referenceName}</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<label>Total Fees : </label><input type="text" id="totalfees"
							name="totfees">
					</div>
					<div>
						<label>Discount Amount(If Any) : </label><input type="text"
							id="discount" name="dscamt">
					</div>
					<c:set var="flag" value="1" scope="page" />
				</c:if>
			</c:forEach>
			<h1>Personal Details</h1>
			<table style="margin-left: 110px;" id="mytable" class="form-table">
				<tr>
					<!-- <th>Sr.no</th> -->
					<th>Name</th>
					<th>Email Id</th>
					<th>Contact No</th>
					<th>Gender</th>
					<th style="border-left: none;"></th>
				</tr>
				<%-- <c:set var="srno" value="1" scope="page" /> --%>
				<c:set var="id" value="1" scope="page" />
				<c:forEach items="${sessionScope.studpersonaldet }" var="perdata">
					<tr valign="top">
						<%-- <td><input type="text" class="sr" name="sr" id="srNo"
							value="${srno }" readonly="readonly"></td> --%>
						<td><input type="text" name="sname" id="sname${id }"
							value="${perdata.stdname }"></td>
						<td><input type="text" class="code" id="enqEmail${id }"
							value="${perdata.phoneno }" /> <!--  <input type="button" class="code add"  value="+" /> -->
						</td>
						<td><input type="text" class="code" id="enqCont${id }"
							value="${perdata.emailid }" /> <!-- <input type="button" class="code" id="add1" value="+" /> -->
						</td>

						<td><select id="enqGender${id }">
								<option>${perdata.gender }</option>
								<!-- <option>F</option> -->
						</select></td>


						<c:set var="id" value="${id+1 }" />
						<%--  <c:set var="srno" value="${srno+1 }" />  --%>
				</c:forEach>

				<td><a href="javascript:void(0);" id="addCF">Add</a></td>
				</tr>
			</table>
			<div class="submit-btn">


				<input style="margin-left: 120px;" type="button" id="getdata"
					value="Register"> <input type="reset" value="Cancel">
			</div>
		</form>
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