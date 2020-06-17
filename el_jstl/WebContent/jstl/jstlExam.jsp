<%@page import="com.jstl.PersonDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//자바 파일 대신으로 
List<String> list = new ArrayList<String>();
list.add("호랑이");
list.add("사자");
list.add("기린");
list.add("코끼리");
list.add("타조");
list.add("코알라");
list.add("여우");

PersonDTO aa = new PersonDTO("홍길동",25);
PersonDTO bb = new PersonDTO("프로도",23);
PersonDTO cc = new PersonDTO("이또치",30);

List<PersonDTO> list2 = new ArrayList<PersonDTO>();
list2.add(aa);
list2.add(bb);
list2.add(cc);

request.setAttribute("list", list);
request.setAttribute("list2", list2);

//페이지 이동
//response.sendRedirect("jstlTest.jsp");
RequestDispatcher dispatcher = request.getRequestDispatcher("jstlTest.jsp"); //상대번지 , 절대번지X
dispatcher.forward(request, response);
%>
<%-- <jsp:forward page="jstlTest.jsp"/> --%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



</body>
</html>