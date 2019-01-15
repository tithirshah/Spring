<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Admin</title>
<script type="text/javascript">
function goBack() {
    window.history.back()
}
</script>
</head>
<body>

<h3>Add Admin</h3>

<form:form action="saveAdmin" modelAttribute="admin" method="post">

<table>
<tbody>
<tr>
<td><label>Admin Id</label>
<td><form:input path="aid"/>
</tr>
<tr>
<td><label>Admin Name</label>
<td><form:input path="aname"/>
</tr>

<tr>
<td><label></label></td>
<td><input type="Submit" value="Save"></td>
</tr>
<tr>
<td><label></label></td>

</tr>


</tbody>

</table>
</form:form>
<button onclick="goBack()">Back</button>
</body>
</html>