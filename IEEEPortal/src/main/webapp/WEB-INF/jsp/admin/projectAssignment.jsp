<%@page import="java.util.Enumeration"%>
<%@page import="com.ieeeportal.entity.PaperEntity"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>IPMS</title>
	
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources_ui/css/style1.css" />
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources_ui/css/reset.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Assignment</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources_ui/js/jquery-1.11.0.js"></script>

<script type="text/javascript">
	function getPapers() {
		var domainID = $('#pdomain').val();

		$.ajax({
			type : "POST",
			url : "./AdminProjectAssignment?action=showPaper",
			dataType : 'json',
			data : {
				domainData : JSON.stringify({
					"domainID" : domainID
				})
			},
			success : function(response) {
				/* alert("from getPapers: "+response); */
				alert(response);
				$('#paperlist').find('option').remove().end();
				$('#paperlist').attr('enabled', 'true');
				$('#paperlist').append(
						$("<option value='0'></option>").text("--Select--"));

				jQuery.each(response, function(index, item) {
					$('#paperlist').append(
							$("<option></option>").text(this.prjtitle).val(
									this.prjid));
				});

			},
		});
	}
</script>
<script type="text/javascript">
	var arra = "";
	var data = new Array();
	/* var counter=0; */
	function getformData() {
		alert('data submitted');
		var domainID = $('#pdomain').val();
		var paperID = $('#paperlist').val();
		var employeeID = $('#emplist').val();
		alert(domainID);
		alert(paperID);
		alert(employeeID);

		$
				.ajax({

					type : 'POST',
					url : './AdminProjectAssignment?action=submit',
					datatype : 'json',
					data : {

						projectAssignmentData : JSON.stringify({
							"domainID" : domainID,
							"paperID" : paperID,
							"employeeID" : employeeID
						})
					},

					success : function(response) {
						alert(response)
						var json = JSON.parse(response);

						for ( var event in json) {
							var dataCopy = json[event];
							for (json in dataCopy) {
								var mainData = dataCopy[json];
								for (key in mainData) {
									if (key
											.match(/prjdom|prjtitle|empName|dateOfAssign/)) {
										//console.log(key + ' ' + mainData[key]);
										alert('key : ' + key + ' :: value : '
												+ mainData[key])

										data.push(mainData[key]);

									}

								}

							}
						}

						//alert(response.empName)

						var size = data.length;
						alert(size);
						alert("newdata:" + data)

						
						$("#ProjectAssignment").each(function() {
							this.reset();
						});
						var newRow = jQuery('<tr><td>' + data[3] + '</td><td>'
								+ data[2] + '</td><td>' + data[0] + '</td><td>'
								+ data[1] + '</td></tr>');
						jQuery('#assignTable').append(newRow);
						/* counter++; */
						data.splice(0, data.length);

						

					},
					error : function() {
						alert('Project Assignment fail..')
					}

				})

	}
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
				<h1 style="color:#000;font-size: 1.9em;">IEEE Project Management System(IPMS)</h1>
			</div>
			<ul class="navigation">
			     <li class="hvr-sweep-to-top"  >
					<a href="#">Home</a>
				</li>
			    <li class="hvr-sweep-to-top" >
					<a href="StudentEnquiryController?action=showenquired">Enquired</a>
				</li>
				<li class="hvr-sweep-to-top">
					<a href="DomainSelection?action=selectdomain">Domains</a>
				</li>
				<li class="hvr-sweep-to-top" id="active">
					<a href="#">Project Assignment</a>
				</li>
                <li class="hvr-sweep-to-top">
					<a href="./SerachStudent">Project Requirement</a>
				</li>
                <li class="hvr-sweep-to-top">
					<a href="#">Payment</a>
				</li>
                <li class="hvr-sweep-to-top">
					<a href="#">Reports</a>
				</li>				
 				
			</ul>
		</div>
	</div>
	<input id='lc' type='hidden' value='${sessionScope.currentusername}' />
	<br><br>
		<form id="ProjectAssignment">
			<label>Domain :</label> <select id="pdomain" onchange="getPapers();">
				<option value=" ">Select Domain :</option>
				<c:forEach var="DomainName" items="${sessionScope.DomainNames}">
					<option value="${DomainName.domainId}" class="SeclectedDomain">${DomainName.domainName}</option>
				</c:forEach>
			</select> <label>Paper :</label> <select id="paperlist">
				<option value=" ">Select Papers :</option>
				<c:forEach var="data" items="${papernamelist}">
					<option value="${data.prjid}">${data.prjtitle}</option>
				</c:forEach>
			</select> <label>Employee :</label> <select id="emplist">
				<option value=" ">Select Employee :</option>
				<c:forEach var="empData" items="${EmpNameList}">
					<option value="${empData.empID}">${empData.empName}</option>
				</c:forEach>
			</select>
			<button type="button" value="Assigned" onclick="getformData()"
				style="width: 80px; height: 25px; background-color: aqua;">Assigned</button>
		</form>
	
    <br><br>
	<div class="CSSTableGenerator">
		<table id="assignTable">
			<tr>
				<th>Domain Name</th>
				<th>Paper Name</th>
				<th>Employee Name</th>
				<th>Assign Date</th>
			</tr>
		</table>


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