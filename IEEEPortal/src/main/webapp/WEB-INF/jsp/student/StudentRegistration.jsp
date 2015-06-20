<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="../Student" method="post">
		<c:forEach items="${enquirydata}" var="enqdata">
			<label>Enquiry Id : </label>
			<c:out value="${enqdata.enquiryid}" />
			<label>Registration Date : </label>
			<input type="text" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${now}" />" name ="regdate" readonly="readonly">
			<label>City : </label>
			<input type="text" value="<c:out value="${enqdata.city }" />" name="city" readonly="readonly">
			<label>College Name : </label>
			<input type="text" value="<c:out value="${enqdata.college }" />" name="clg" readonly="readonly">
			<label>Department : </label>
			<input type="text" value="<c:out value="${enqdata.dept }" />" name="dept" readonly="readonly">
			<label>Domain : </label>
			<input type="text" value="<c:out value="${enqdata.domain }" />" name="dom" readonly="readonly">
			<label>Technology : </label>
			<input type="text" value="<c:out value="${enqdata.tech }" />" name="tch" readonly="readonly">
			<label>Team Size : </label>
			<input type="text" value="<c:out value="${enqdata.tmsz }" />" name="teamsz" readonly="readonly">
			<label>Project Title : </label>
			<input type="text" value="<c:out value="${enqdata.projtle }" />" name="ptitle" readonly="readonly">
		</c:forEach>
		<c:forEach items="${personaldata }" var="perdata">
			<label>Name : </label>
			<input type="text" value="<c:out value="${perdata.name }" />" name="name" readonly="readonly">
			<label>Email Id : </label>
			<input type="text" value="<c:out value="${perdata.emailid }" />" name="emailid" readonly="readonly">
			<label>Contact No:</label>
			<input type="text" value="<c:out value="${perdata.cntno }" />" name="cntno" readonly="readonly"> 
		</c:forEach>
		<label>Total Fees : </label><input type="text" name="totfees">
		<label>Discount Amount : </label><input type="text" name="dscamt">
		<input type="submit" value="register"> <input type="reset"
			value="cancel">
	</form>
</body>
</html>