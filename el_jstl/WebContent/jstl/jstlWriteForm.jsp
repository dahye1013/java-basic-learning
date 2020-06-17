<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl회원가입</title>
</head>
<body>
	<h3>회원가입</h3>
	<form name="jstlWriteForm" method="post" action="jstlWrite.jsp">
		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<!--1행-->
				<td width="70" align="center">이 름</td>
				<td><input type="text" name="name" id="name" placeholder="이름 입력" ></td>
			</tr>
			<tr>
				<!--2행-->
				<td width="70" align="center">아이디</td>
				<td><input type="text" name="id" placeholder="아이디 입력" size="30">
				</td>
			</tr>
			<tr>
				<!--3행-->
				<td width="70" align="center">비밀번호</td>
				<td><input type="password" name="pwd" placeholder="비밀번호 입력"  size="30"></td>
			</tr>
				<!--4행-->
				<td colspan="2" align="center">
				<input type="submit" value="저장"> &emsp;
			    <input type="reset" value="취소"> &emsp;
			    <input type="button" value="목록" onclick="location.href='jstlList.jsp'">
				</td>	
			</tr>
		</table>
	</form>
</table>
</form>
</body>
</html>