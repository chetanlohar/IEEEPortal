<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EmployeeRegistration</title>
</head>
<body>
<center>

<!--Employee Registration form--->
<form action="EmployeeRegistrationController" method="post"><!-- After Submitting goes to Employee Registration Controller-->

<label>EmployeeID</label>
<input type="text" name="empID"><br><br>

<label>Employee Name:</label>
<input type="text" name="empName"><br><br>

<label>EmailID</label>
<input type="text" name="empEmailID"><br><br>

<label>Password</label>
<input type="password" name="empPassword"><br><br>

<label>Date OF Joinnig</label>
<input type="text" name="empDOJ"><br><br>

<label>Designation</label>
<select value="" name="empDesignation">
<option value="jr.JavaDeveloper">jr.JavaDeveloper</option>
<option value="Sr.JavaDeveloper">Sr.JavaDeveloper</option>
<option value="Tester">Tester</option>
<option value="BA">BA</option>
<option value="WebDesigner">WebDesigner</option>
<option value="TLA">TLA</option>
<option value="Manager">Manager</option>
<option value="MD">MD</option>
</select><br><br>


<label>ContactNo</label>
<input type="text" name="empContactNo"><br><br>

<label>Gender</label>
<select option=" " name="empGender">
<option value="Male">Male</option>
<option value="FeMale">FeMale</option>
</select><br><br>

<label>Apatr/Street</label>
<input type="text" height="70px" weidth="25px" name="empStreet"><br><br>

<label>City</label>
<select value="" name="empCity">
<option value="jr.JavaDeveloper">jr.JavaDeveloper</option>
<option value="Sr.JavaDeveloper">Sr.JavaDeveloper</option>
<option value="Tester">Tester</option>
<option value="BA">BA</option>
<option value="WebDesigner">WebDesigner</option>
<option value="TLA">TLA</option>
<option value="Manager">Manager</option>
<option value="MD">MD</option>
</select><br><br><br>

<input type="submit" name="EmpRegistration" value="Register">
<input type="reset" value="Clear">
</form></center>
<!-- End OF Form -->


</body>
</html>