<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer Money</title>
</head>
<body>
<h2>CRM</h2>
<h3>Transfer Money</h3>

<form action="sendMoney" method="get">
<table>
<tr>
<td><label>From Account Number</label></td>
<td><input type="text" name="accfrom"></td>
</tr>
<tr>
<td><label>To Account Number</label></td>
<td><input type="text" name="accto"></td>
</tr>
<tr>
<td><label>Amount</label></td>
<td><input type="text" name="amount"></td>
</tr>

<tr>
<td><label></label></td>
<td><input type="submit" value="Transfer"/> </td>
</tr>
</table>
</form>
</body>
</html>