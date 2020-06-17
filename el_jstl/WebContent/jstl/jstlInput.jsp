<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstlInput</title>
</head>
<body>
<form method="post" action="jstlResult.jsp">
<table border="1">
	  <tr>
	   <td width="70" align="center">
	   <font color="red">*</font>
	  	이름</td>
	   <td><input type ="text" name="name" size="20"></td>
	  </tr>		
	  <tr>
	   <td width="70" align="center">
	   <font color="red">*</font>
	   나이</td>
	   <td><input type ="text" name="age" size="20"></td>
	  </tr>		
	  
	  <tr><!--2행-->
	   <td align="center">성별</td>
	   <td><label/><input type='radio' name='gender' value='0'/>남성
	   <label/><input type='radio' name='gender' value='1' checked/>여성</td>
	  </tr>										
		<tr><!--3행-->
	   <td align="center">취미</td>
	   <td><label/><input type="checkbox" name="hobby" value="독서"/>독서&emsp; <!-- &emsp; 띄어쓰기-->
	   <label/><input type="checkbox" name="hobby" value="음악"/>음악&emsp;
	   <label/><input type="checkbox" name="hobby" value="게임"/>게임&emsp;
	   <label/><input type="checkbox" name="hobby" value="운동"/>운동&emsp;
	   <label/><input type="checkbox" name="hobby" value="영화"/>영화&emsp;
	   </td>
	  </tr>
	  <tr><!--4행-->
	   <td align="center">색깔</td>
	   <td><select name="color" style="width:100px"> <!--기본상태는 콤보><!-- size를 만들면 list 형태가 된다-->
		<option value="red">빨강</option>
 		<option value="green">초록</option>
		<option value="blue">파랑</option>
		<option value="violet">보라</option>
		<option value="cyan">하늘</option>
			</select>	
		</td>
	  </tr>

	  <tr><!--6행-->
	  <td colspan="2" align="center">		
	  <input type="submit" value="SEND" > &emsp;
	  <input type="reset" value="CANCEL"></td>
	  </tr>

</table>
</form>
</body>
</html>