<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accounts</title>
<script type="text/javascript">
function goBack() {
    window.history.back()
}
</script>
</head>
<body>
<h2>Display Admins</h2>

<table width="50%">
	<tr>
		<th> Entry No. </th>
		<th>Admin Id</th>
		<th>Admin Name</th>
		
		
	</tr>
	<c:forEach items="${admins}" var="admin" varStatus="status">
		<tr>
			<td align="center">${status.count}</td>
			<td align="center">${admin.aid}</td>
			<td align="center">${admin.aname}</td>
			
			
		</tr>
	</c:forEach>
	
	
	</table>
	<br>
	<input type="button" value="Add Customer" onclick="window.location.href='addCustomer'; return false;">
	<input type="button" value="Add Admin" onclick="window.location.href='addAdmin'; return false;">
	<button onclick="goBack()">Back</button>
	
<br/>

</body>
</html>