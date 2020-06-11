<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="board.dao.BoardDAO.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
//데이터 받아오기
		request.setCharacterEncoding("UTF-8");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

//DB //세션값
	
	String name = (String)session.getAttribute("memName");
	String id = (String)session.getAttribute("memId");
	String email = (String)session.getAttribute("memEmail");

	Map<String,String> map = new HashMap<String, String>();
	map.put("id", id);
	map.put("name", name);
	map.put("email", email);
	map.put("subject", subject);
	map.put("content", content);
	

	BoardDAO boardDAO = BoardDAO.getInstance();
//	int su = boardDAO.writeBoard(subject, content);
	boardDAO.boardWrite(map);
	
	
//응답

//request.setAttribute("id",id); 
//이렇게는 아무리해도 값을 모른다.


%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= subject%> 제목의 글이 저장되었습니다.
</body>
<script>
window.onload=function(){
	alert("작성하실 글을 저장하였습니다.");
	location.href="../main/index.jsp"
}
</script>

</html>