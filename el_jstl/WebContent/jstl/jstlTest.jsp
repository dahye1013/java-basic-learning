<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstlTest</title>
</head>
<body>

<c:set var="name" value="홍길동"/>
<c:set var="age">25</c:set>

나의 이름은 <c:out value="${name }"/><br>
내 나이는 ${age }살 입니다<br>

<h3>***변수삭제***</h3>
<c:remove var="name"/>
나의 이름은 <c:out value="${name}"/>입니다<br>
내 나이는 ${age }살 입니다<br>
<h3>***for Each***</h3>
<% for(int i=1 ; i<=10 ; i++) %>
<c:forEach var="i" begin="1" end="10" step="1">
	${i } &nbsp;
</c:forEach>
<br>

<c:forEach var="i" begin="1" end="10" step="1">
	${11- i } &nbsp;
</c:forEach>
<br>
<c:forEach var="i" begin="1" end="10" step="1">
<c:set var="sum" value="${sum+i }"/>
</c:forEach>
<br>
1~10 합 = ${sum } &nbsp;
<br><br>

<h3>***문자열 분리***</h3>
<!--1. StringTokenizer
	2. String split -->
<c:forTokens var="car" items="소나타,아우디,링컨,페라리,벤츠" delims=",">
	${car }<br>
</c:forTokens>
	
<h3>***jstlExam.jsp에서 넘어온 데이터 출력***</h3>
<%-- <% request.getAttribute("list"); %> redirect는 각각의 페이지를 가지므로, 이렇게 넘기면 값을 모른다 --%>
${ requestScope.list }<br> <!-- 위와 같은 방식이다. 값이 넘어오지않음. -->
${ list }<br>

결과 = ${list[2] }<br><br>

<c:forEach var="data" items="${requestScope.list }">
	${data }<br>
</c:forEach>

<h3>***list2의 모든 데이터 출력***</h3>
<c:forEach var="data" items="${requestScope.list2 }" varStatus="i" >
	index= ${i.index } &emsp; count= ${i.count }
이름 = ${data.getName() }  &nbsp;&nbsp;	나이 = ${data.getAge() } <br>	
</c:forEach>

<c:forEach var="data" items="${requestScope.list2 }">
이름 = ${data.name }  &nbsp;&nbsp;	나이 = ${data.age } <br>	
</c:forEach>


</body>
</html>



  


















