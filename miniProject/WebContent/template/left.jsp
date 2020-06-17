<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
HttpSession session1 = request.getSession();//세션생성
String id = (String)session1.getAttribute("memName");

if(id!=null){%>
<a href="">회원정보수정</a><br>
<a href="">글쓰기</a><br>
<a href="">목록</a><br>
<a href="../member/logout.do">로그아웃</a><br>
<%}else{%>
<a href="../member/writeForm.do">회원가입</a><br>
<a href="../member/loginForm.do">로그인</a><br>
	<%}%>
	



