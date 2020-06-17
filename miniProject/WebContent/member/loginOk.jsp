<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src="../image/ff.gif" width="100" onclick="javascrpit:location.href='../main/index.jsp'" 
style="cursor: pointer;">

<br>
	<%-- ${sessionScope.memName } --%>${memName } 님<br>
로그인 성공<br><br>
<!-- 	<input type="reset" value="로그아웃" onclick="location.href='logout.do'">
	<input type="submit" value="회원정보수정" onclick="location.href='modifyForm.jsp'">
	<input type="button" value="메인화면" onclick="location.href='../main/index.jsp'"> -->
</body>
</html>