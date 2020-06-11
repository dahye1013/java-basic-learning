<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="dataDTO" class="exam.bean.DataDTO" scope="session"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:getProperty property="x" name="dataDTO"/>*<jsp:getProperty property="y" name="dataDTO"/>=
<%= dataDTO.getX() * dataDTO.getY() %> <br><br>
</body>
</html>