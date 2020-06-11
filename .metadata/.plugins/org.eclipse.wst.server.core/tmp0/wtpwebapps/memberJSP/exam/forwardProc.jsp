<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
request.setAttribute("apple","사과");
//페이지 이동	 - 포워딩보다 이걸 더 많이 쓴다.
RequestDispatcher dispatcher = request.getRequestDispatcher("forwardResult.jsp"); //상대번지 , 절대번지X
dispatcher.forward(request, response);//제어권 넘기기
%>

<%-- <jsp:forward page="forwardResult.jsp"/> 
		 요즘은 잘 안쓴다
--%> 

