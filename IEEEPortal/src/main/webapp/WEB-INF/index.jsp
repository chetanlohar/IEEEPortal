
<!DOCTYPE HTML>
<!-- Website template by freewebsitetemplates.com -->
<html>
<head>
	<meta charset="UTF-8">
	<title>IPMS</title>
	
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources_ui/css/style1.css" />
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources_ui/css/reset.css" />
</head>
<body>
	<div id="header">
		<div class="clearfix">
			<div class="logo">
				<h1 style="color:#000;font-size: 1.9em;">IEEE Project Management System(IPMS)</h1>
			</div>
			<ul class="navigation">
			    <li class="hvr-sweep-to-top"  id="active">
					<a href="#">Home</a>
				</li>
				<li class="hvr-sweep-to-top">
					<a href="StudentEnquiryController?action=showdata">Enquiry</a>
				</li>
				<li class="hvr-sweep-to-top">
					<a href="login">Login</a>
					 
				</li>
				
				
			</ul>
		</div>
	</div>
	<div id="contents">
		<div id="adbox">
			<div class="clearfix">
				<img src="<%= request.getContextPath()%>/resources_ui/images/softinfology.jpg" alt="Img" height="382" width="960">
				
			</div>
		</div>
	
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