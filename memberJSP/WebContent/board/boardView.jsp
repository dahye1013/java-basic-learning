<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    int pg = Integer.parseInt(request.getParameter("pg"));
    int seq = Integer.parseInt(request.getParameter("seq"));
    
    BoardDAO boardDAO = new BoardDAO();
    BoardDTO dto=boardDAO.getSingleBoard(seq);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선택  글</title>
</head>
<body>

<table  border="1" width=580px cellspacing=0 cellpadding=3 style=table-layout:fixed
			frame="hsides" rules="rows">
<tr>제목: <%= dto.getSubject()%>
</tr>
<tr>
<td width="150" align="center">글번호: <%= dto.getSeq()%>
</td>
<td width="150" align="center">작성자: <%= dto.getName()%>
</td>
<td width="150" align="center">조회수:<%= dto.getHit()%>
</td>
</tr>
<tr >
<td colspan="3" height=150><pre>
<%= dto.getContent()%></pre>
<br>
<br>
</td>

</tr>


</table>
<br><br>
<input type = button value="목록" onclick="location.href='boardList.jsp?pg=<%=pg%>'">
<br><br>
<% if(session.getAttribute("memId").equals(dto.getId())){%>
<input type="button" value="글수정" onclick="location.href='boardModifyForm.jsp?seq=<%= seq%>&pg=<%= pg%>'">
<input type="button" value="글삭제" onclick="location.href=''">
<%}%>

</body>

</html>



