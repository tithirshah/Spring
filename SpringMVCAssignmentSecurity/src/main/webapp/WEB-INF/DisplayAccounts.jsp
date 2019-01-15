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
<h2>Display Accounts</h2>
${customerList.customerList}
<table width="50%">
	<tr>
		<th> Entry No. </th>
		<th>Account Number</th>
		<th>Customer Name</th>
		<th>Balance</th>
		
	</tr>
	<c:forEach items="${customers}" var="customer" varStatus="status">
		<tr>
			<td align="center">${status.count}</td>
			<td align="center">${customer.accno}</td>
			<td align="center">${customer.cname}</td>
			<td align="center">${customer.balance}</td>
			
		</tr>
	</c:forEach>
	</table>
	<br>
	<input type="button" value="Transfer Money" onclick="window.location.href='sendMoneyForm'; return false;">
	<button onclick="goBack()">Back</button>
	
	
<br/>

</body>
</html>