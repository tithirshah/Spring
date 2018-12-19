<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alien Form</title>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
    <script type="text/javascript" src="../js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="../js/jquery.validate.min.js"></script>

    <script type="text/javascript">
    
 // var index=1;
 // function insertRow(){
//      var table=document.getElementById("myTable");
    
//      var row=table.insertRow(table.rows.length);
    
//      var cell1=row.insertCell(0);
//      var t1=document.createElement("sform:input");
//          t1.id = "txtaid"+index;
//          cell1.appendChild(t1);
//      var cell2=row.insertCell(1);
//      var t2=document.createElement("sform:input");
//          t2.id = "txtaname"+index;
//          cell2.appendChild(t2);
//      var cell3=row.insertCell(2);
//      var t3=document.createElement("sform:input");
//          t3.id = "txtage"+index;
//          cell3.appendChild(t3);
    
 // index++;
//        $(document).ready(function() {

// $("#btnAdd").click(function() {

//           $('#dataTable tbody>tr:last').clone(true).insertAfter('#dataTable tbody>tr:last');     
//           return false;

// });
// });
</script>



</head>
<body>
<h2>Alien Form</h2>

<sform:form   modelAttribute="alienList" method="post" action="save">
	<table id="dataTable">
	<tr>
		<th> Entry No</th>
		<th>AlienId</th>
		<th>AlienName</th>
		<th>AlienAge</th>
		
	</tr>
<%-- 	<c:forEach items="${alienList.aliens}" var="alien" varStatus="status"> --%>
<!-- 		<tr> -->
<%-- 			<td align="center">${status.count}</td> --%>
<%-- 			<td><input name="aliens[${status.index}].aid" value="${alien.aid}"/></td> --%>
<%-- 			<td><input name="aliens[${status.index}].aname" value="${alien.aname}"/></td> --%>
<%-- 			<td><input name="aliens[${status.index}].age" value="${alien.age}"/></td> --%>
<!-- 		</tr> -->
<%-- 	</c:forEach> --%>
<tr>
 <c:forEach items="${alienList.aliens}" var="alien" varStatus="status">
    <tr>
    <td align="center">${status.count}</td>
    <td>  <sform:input id="txtaid" type="text" path="aliens[${status.index}].aid" /></td>
   <td>   <sform:input id="txtaname" type="text" path="aliens[${status.index}].aname" /></td>
  <td>    <sform:input id="txtage" type="text" path="aliens[${status.index}].age" /></td>
    </tr>
   </c:forEach>
   </tr>
   <tr>
   
   </tr>
</table>	
<br/>
<table>
<tr>
<!-- <td><button id="btnAdd" type="button" onclick="insertRow();">Add Row</button></td>-->

<td><input type="submit"  Value="Save"/></td>
</tr>
</table>
</sform:form>
</body>
</html>