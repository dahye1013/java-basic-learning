<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
String name = request.getParameter("name");
String id = request.getParameter("id");
%> 


<br>
���̵� <%= id %>�� �α��� ����<br>
	<input type="button" value="�α���" onclick=javascrpit:location.href='loginForm.jsp'> 
	<input type="button" value="ȸ������" onclick=javascrpit:location.href='writeForm.jsp'> 
	

    