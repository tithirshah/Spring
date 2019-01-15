<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table width="50%">
	<tr>
		
		<th>Account Number</th>
		<th>Customer Name</th>
		
		
	</tr>
	<c:forEach items="${customerList.customerList}" var="customer" varStatus="status">
		<tr>
			
			<td align="center">${customer.accno}</td>
			<td align="center">${customer.cname}</td>
			
			
		</tr>
	</c:forEach>
	</table>


	<form action="sendMoney" method="get">
<table>
<tr>
<td>From Account Number:<input type="text" name="accfrom"></td>
</tr>
<tr>
<td>To Account Number:<input type="text" name="accto"></td>
</tr>
<tr>
<td>Amount:<input type="text" name="amount"></td>
</tr>

<tr>
<td><input type="submit"/> </td>
</tr>
</table>
</form>
	

</body>
</html>