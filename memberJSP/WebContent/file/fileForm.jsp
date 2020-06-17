<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post"  enctype="multipart/form-data" action="fileUpload.jsp">
<table border="1" cellspacing="0" cellpadding="5">
<td>*제목</td>
<td colspan="2"><input type="text" name="subject" placeholder="제목 입력"></td>
</tr>
<tr>
<td >*내용</td>
<td ><textarea name="content" id="content" cols="40" rows="20" style="resize:none;" placeholder="내용 입력"></textarea></td>
</tr>
<tr>
<td colspan="2"><input type="file" name="upload1" size="50">  
</td>
</tr>
<tr>
<td colspan="2"><input type="file" name="upload2" size="50">  
</td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="파일업로드">  
</td>
</tr>
</table>
</form>
</body>
</html>