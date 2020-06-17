<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String id = request.getParameter("id");
%>
<sql:query var="rs" dataSource="jdbc/oracle">
	select*from usertable where id='${param.id }'
</sql:query>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl수정Form</title>
</head>
<body>
	<h3>회원정보 수정</h3>
	<form name="jstlModifyForm" method="post" action="jstlModify.jsp">
<%-- 	<c:forEach var="row" items="${rs.rowsByIndex }"> --%>
	<c:forEach var="row" items="${rs.rows}"> <!-- 이렇게하면 map의 형식으로 가져온다, 앞에는 key값 -->
		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<!--1행-->
				<td width="70" align="center">이 름</td>
<%-- 				<td><input type="text" name="name" value="${row[0] }" ></td> --%>
				<td><input type="text" name="name" value="${row.name }" ></td>
			</tr>									<!-- map의 형식인경우 키값을 붙인다 -->
			<tr>
				<!--2행-->
				<td width="70" align="center">아이디</td>
<%-- 				<td><input type="text" name="id" value="${row[1] }" size="30" readonly> --%>
				<td><input type="text" name="id" value="${row.id }" size="30" readonly>
				</td>
			</tr>
			<tr>
				<!--3행-->
				<td width="70" align="center">비밀번호</td>
				<td><input type="password" name="pwd"  size="30"></td>
			</tr>
				<!--4행-->
				<td colspan="2" align="center">
				<input type="submit" value="수정" > &emsp;
			    <input type="reset" value="취소"> &emsp;
			    <input type="button" value="목록" onclick="location.href='jstlList.jsp'">
				</td>	
			</tr>
		</table>
		</c:forEach>
	</form>
</table>
</form>
</body>

</html>