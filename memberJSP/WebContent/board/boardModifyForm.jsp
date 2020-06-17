<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
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
<title>글 수정</title>
</head>
<body>
<img src="../image/tt.gif" width=150><br>
<h1>글수정</h1>
<form name = "boardModifyForm" method="post" action="boardModify.jsp?seq=<%=seq%>&pg=<%=pg%>">

<table border="1" cellspacing="0" cellpadding="5">
<td>*제목</td>
<td><input type="text" name="subject" value="<%= dto.getSubject()%>" placeholder="제목 입력"></td>
</tr>
<tr>
<td >*내용</td>
<td ><textarea name="content" id="content" cols="40" rows="20" style="resize:none;" placeholder="내용 입력"><%= dto.getContent()%></textarea></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="button" value="수정완료" onclick="checkBoardWriteForm()">
&nbsp;<input type="reset" value="다시작성">
<!-- <input type="button" value="글목록" onclick=location.href=''> --></td>
</tr>

</table>

</form>
</body>
<script type="text/javascript" > 

function checkBoardWriteForm() {
	if(document.boardModifyForm.subject.value == ""){ 
		alert("제목을 입력하세요");
		document.boardModifyForm.subject.focus();
	}else if (document.boardModifyForm.content.value == ""){
		alert("내용을 입력하세요");
		document.boardModifyForm.content.focus();
	}else{
		document.boardModifyForm.submit();
	}
}

</script>

</html>