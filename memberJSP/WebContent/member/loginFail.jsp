<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
String name = request.getParameter("name");
String id = request.getParameter("id");
%> 


<br>
아이디 <%= id %>님 로그인 실패<br>
	<input type="button" value="로그인" onclick=javascrpit:location.href='loginForm.jsp'> 
	<input type="button" value="회원가입" onclick=javascrpit:location.href='writeForm.jsp'> 
	

    