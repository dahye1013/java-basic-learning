<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--     <%
    int x = Integer.parseInt(request.getParameter("x"));
    int y = Integer.parseInt(request.getParameter("y"));
    
    %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산출력</title>
</head>
<body>

<%-- <%= x %>+<%= y %>	= <%= x+y %> --%>

${param['x'] } +${param['y'] } = ${ param['x'] + param['y']} <br>
<!-- post방식일때 param으로 데이터가 submit되는 것을 활용한다 -->
${param['x'] } - ${param['y'] } = ${param['x'] - param['y']}<br>
${param.x }*${param.y } = ${param.x * param.y } <br>
${param.x }/${param.y } = ${param.x/param.y }<br>
</body>
</html>