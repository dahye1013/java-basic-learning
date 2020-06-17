<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<fmt:requestEncoding value="UTF-8"/>
<title>jstl Result</title>
<style type="text/css">
#form{
	color: ${param.color};
	font-weight: bold;
}
</style></head>
<body>


<ul id="form">
<li>이름: ${param.name }</li>
<li>나이: ${param.age }살
<c:if test="${param.age >= 19}">(성인)</c:if>
<c:if test="${param.age < 19}">(청소년)</c:if> 
</li>
<li>색깔:
<c:choose>
<c:when test="${param.color=='red' }">빨강</c:when>
<c:when test="${param.color=='green' }">초록</c:when>
<c:when test="${param.color=='blue' }">파랑</c:when>
<c:when test="${param.color=='magenta' }">보라</c:when>
<c:otherwise>하늘</c:otherwise>
</c:choose>
</li>
<li>취미:
	${paramValues['hobby'][0]}
	${paramValues['hobby'][1]}
	${paramValues['hobby'][2]}
	${paramValues['hobby'][3]}
	${paramValues['hobby'][4]}
</li> 
<li>취미:
<c:forEach var="data" items="${ paramValues.hobby}">
	${data}
</c:forEach>
</ul>
</body>
</html>





