<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Alien</title>
<script type="text/javascript">
function goBack() {
    window.history.back()
}
</script>
</head>
<body>


<h2>Display Aliens</h2>
<table width="50%">
	<tr>
		<th> Entry No. </th>
		<th>AliedId</th>
		<th>AlienName</th>
		<th>AlienAge</th>
		
	</tr>
	<c:forEach items="${alienList.aliens}" var="alien" varStatus="status">
		<tr>
			<td align="center">${status.count}</td>
			<td align="center">${alien.aid}</td>
			<td align="center">${alien.aname}</td>
			<td align="center">${alien.age}</td>
			
		</tr>
	</c:forEach>
	<tr>
	<td><button onclick="goBack()">Back</button>
	</tr>
</table>	
<br/>
</body>
</html>