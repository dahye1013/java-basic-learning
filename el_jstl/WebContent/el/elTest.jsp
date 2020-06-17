<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 연습</title>
</head>
<body>
<table border="1" width="50%"> <!-- width를 퍼센트로 잡으면 화면의 크기에 따라 유동성있게 같이 움직이게함 -->
<tr>
<th width="50%">표현식</th>
<th width="50%">값</th>
</tr>

<tr>
<td align="center"> \${25+3} </td> 
<td align="center"><%-- <%= 25+3 %> --%> ${25+3}</td>
</tr>

<tr>
<td align="center"> \${25/3} </td> 
<td align="center">${25/3}</td>
</tr>

<tr>
<td align="center"> \${25 div 3} </td> 
<td align="center">${25 div 3}</td>
</tr>

<tr>
<td align="center"> \${ 25%3 } </td> 
<td align="center">${ 25%3 }</td>
</tr>

<tr>
<td align="center"> \${25 mod 3} </td> 
<td align="center">${25 mod 3}</td>
</tr>

<tr>
<td align="center">\${25<3}</td>
<td align="center">${25<3}</td>
</tr>

<!-- 	>gt, <lt, >=ge, <=le, ==eq, !=ne  -->
<tr>
<td align="center">\${25 ne 2 }</td>
<td align="center">${25 ne 2 }</td>
</tr>

<tr>
<td align="center">\${header['host'] }</td>
<td align="center">${header['host'] }</td> <!-- 누가 서버인지 물어보는것 -->
</tr>

<tr>
<td align="center">\${header.host}</td>
<td align="center">${header.host}</td> <!-- 누가 서버인지 물어보는것 -->
</tr>

</table>
</body>
</html>













