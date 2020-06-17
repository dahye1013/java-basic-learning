<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
//데이터 받아오기
		request.setCharacterEncoding("UTF-8");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));

//DB //세션값


    BoardDAO boardDAO = new BoardDAO();
    BoardDTO dto= new BoardDTO();

%>

<html>
<head>
<meta charset="UTF-8">
<title>수정완료</title>
</head>
<body>
<%= seq %>번 글을 업데이트 했습니다.
<br>
    
<%
boardDAO.updateBoard(seq, subject, content);
%> 

</body>
<script type="text/javascript">
window.onload=function(){
	alert("목록으로 이동");
	location.href="boardList.jsp?pg=<%= pg %>";
}
</script>
</html>