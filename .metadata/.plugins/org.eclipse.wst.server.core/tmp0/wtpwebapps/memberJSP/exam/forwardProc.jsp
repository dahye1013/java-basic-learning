<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
request.setAttribute("apple","���");
//������ �̵�	 - ���������� �̰� �� ���� ����.
RequestDispatcher dispatcher = request.getRequestDispatcher("forwardResult.jsp"); //������ , �������X
dispatcher.forward(request, response);//����� �ѱ��
%>

<%-- <jsp:forward page="forwardResult.jsp"/> 
		 ������ �� �Ⱦ���
--%> 

