<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sql:query var="rs" dataSource="jdbc/oracle">
	select*from usertable
</sql:query>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl List</title>
</head>
<body>
<table border="1"> 
<!-- 컬럼명 -->
<tr>
	<c:forEach var="colName" items="${ rs.columnNames }">
	<th>${colName }</th>
	</c:forEach>
	<th width="150">비고</th>
</tr>
<!-- var은 변수명. 마음대로 지정가능 -->
<c:forEach var="row" items="${rs.rowsByIndex }"><!-- 행 -->
 <tr>
 	<c:forEach var="coL" items="${row }"><!-- 열 -->
 		<td width="100" align="center">${coL }</td>
	</c:forEach> 	
 	<td align="center">
	 	<input type="button" value="수정" onclick="location.href='jstlModifyForm.jsp?id=${row[1] }'">
	 	<input type="button" value="삭제" onclick="location.href='jstlDelete.jsp?id=${row[1] }'"> 
 	</td>

 </tr>
</c:forEach>
</table>
</body>
</html>