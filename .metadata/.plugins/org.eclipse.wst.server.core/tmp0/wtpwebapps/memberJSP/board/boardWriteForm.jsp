<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>글쓰기</title>
</head>
<h1>글쓰기</h1>
<form name = "boardWriteForm" method="post" action="boardWrite.jsp">

<table border="1" cellspacing="0" cellpadding="5">
<td>*제목</td>
<td><input type="text" name="subject" placeholder="제목 입력"></td>
</tr>
<tr>
<td >*내용</td>
<td ><textarea name="content" id="content" cols="40" rows="20" style="resize:none;" placeholder="내용 입력"></textarea></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="button" value="글작성" onclick="checkBoardWriteForm()">
&nbsp;<input type="reset" value="다시작성">
<!-- <input type="button" value="글목록" onclick=location.href=''> --></td>
</tr>

</table>

</form>

</body>
<script type="text/javascript" > 

function checkBoardWriteForm() {
	if(document.boardWriteForm.subject.value == ""){ 
		alert("제목을 입력하세요");
		document.boardWriteForm.subject.focus();
	}else if (document.boardWriteForm.content.value == ""){
		alert("내용을 입력하세요");
		document.boardWriteForm.content.focus();
	}else{
		document.boardWriteForm.submit(); //submit은 name 속성을 가진 애들만 옮긴다.
	}
}

</script>

</html>