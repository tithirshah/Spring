<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer</title>
<script type="text/javascript">
function goBack() {
    window.history.back()
}
</script>
</head>
<body>

<h3>Add Customer</h3>
<%-- <form action="addCustomer" method="post"> --%>
<!-- <input type="text" name="aid"> -->
<!-- <br> -->
<!-- <input type="text" name="aname"> -->
<!-- <br> -->
<!-- <input type="submit"/>  -->
<%-- </form> --%>



<form:form action="saveCustomer" modelAttribute="customer" method="post">

<table>
<tbody>
<tr>
<td><label>Account No</label>
<td><form:input path="accno"/>
</tr>
<tr>
<td><label>Customer Name</label>
<td><form:input path="cname"/>
</tr>
<tr>
<td><label>Balance</label>
<td><form:input path="balance"/>
</tr>
<tr>
<td><label></label></td>
<td><input type="Submit" value="Save"></td>


</tr>


</tbody>

</table>
</form:form>
<button onclick="goBack()">Back</button>
</body>
</html>