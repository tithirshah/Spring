<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function goBack() {
    window.history.back()
}
</script>
</head>
<body>
<h3>Something went wrong....</h3>
<h5>Details are:${exception}</h5>

<button onclick="goBack()">Back</button>

</body>

</html>