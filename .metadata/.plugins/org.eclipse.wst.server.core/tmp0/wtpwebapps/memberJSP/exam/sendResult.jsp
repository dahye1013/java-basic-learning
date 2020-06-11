<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
String apple = (String)request.getAttribute("apple"); //sendProc에서 보낸걸 get해온다, 기본값이 object라  String으로 캐스팅해야함
%>

<br>
결과=<%= apple %>
