<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h3>로그인</h3>
	<form name="loginForm" method="post" action="login.jsp">
		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<td width="70" align="center">아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td width="70" align="center">비밀번호</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="로그인"
					onclick="checkLoginForm()"> 
					<input type="button" value="회원가입" onclick="javascrpit:location.href='writeForm.jsp'">
				</td>
			</tr>

		</table>
	</form>


</body>

<script type="text/javascript" src="../js/member.js"> 
</script>
</html>