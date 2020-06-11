<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
//데이터 받아오기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
//DB
 		MemberDAO memberDAO = new MemberDAO();
 		String name = memberDAO.loginMember(id, pwd);

boolean exist = memberDAO.isExistedId(id);

%>
<html>
<head>
<meta charset="UTF-8">
<title>중복확인</title>
</head>
<body>
<form method="post" action="checkId.jsp"> 

<%if(exist==true){%>
<%=id%>는 사용할수 없습니다.
<br><br>
아이디<input type="text" name="id" size="10">
<input type="submit" value="검색" onclick="">
<%}else{%>
<%=id%>는 사용할 수 있습니다.
<br><br>
<input type="button" value="사용하기" onclick="checkIdClose('<%=id%>')">
<%}%>



</form>
</body>
<script type="text/javascript" src="../js/member.js">
</script>

</html>