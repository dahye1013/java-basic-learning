<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.bean.MemberDTO"%>
<%@ page import="member.dao.MemberDAO"%>

<%
//데이터
//String id = request.getParameter("id");
String id = (String)session.getAttribute("memId");

//DB
MemberDAO memberDAO = MemberDAO.getInstance();
MemberDTO memberDTO = memberDAO.getMember(id);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
</head>
<body>
<h3>회원정보수정</h3>
<form name="modifyForm" method="post" action="modify.jsp">
<table border="1" cellspacing="0" cellpadding="3">
 <tr>
  <td width="70" align="center">이름</td>
  <td><input type="text" name="name" id="name" value="<%=memberDTO.getName() %>" placeholder="이름 입력"></td>
 </tr>

 <tr>
  <td width="70" align="center">아이디</td>
  <td>
   <input type="text" name="id" value="<%=id %>" size="30" readonly>
  </td>
 </tr> 
 
 <tr>
  <td width="70" align="center">비밀번호</td>
  <td><input type="password" name="pwd" size="35"></td>
 </tr>
 
 <tr>
  <td width="70" align="center">재확인</td>
  <td><input type="password" name="repwd" size="35"></td>
 </tr>
 
 <tr>
  <td width="70" align="center">성별</td>
  <td>
   <input type="radio" name="gender" value="0">남 &emsp;
   <input type="radio" name="gender" value="1">여
  </td>
 </tr>
 
 <tr>
  <td align="center">이메일</td>
  <td>
   <input type="text" name="email1" value="<%=memberDTO.getEmail1() %>" size="15" >
   @
   <input type="email" name="email2" id="email2" list="defaultEmails" placeholder="직접입력">
   <datalist id="defaultEmails">
    <option value="naver.com">
	<option value="hanmail.net">
	<option value="gmail.com">
   </datalist>
  </td>	
 </tr>
 
 <tr>
  <td align="center">핸드폰</td>
  <td>
   <select name="tel1" id="tel1" style="width: 60px;">
    <option value="010">010</option>
	<option value="02">02</option>
   </select>
   -
   <input type="text" name="tel2" value="<%=memberDTO.getTel2() %>" size="5">
   -
   <input type="text" name="tel3" value="<%=memberDTO.getTel3() %>" size="5">
  </td>
 </tr>
 
 <tr>
  <td align="center">주소</td>
  <td>
   <input type="text" name="zipcode" id="zipcode" value="<%=memberDTO.getZipcode() %>" size="7" readonly>
   <input type="button" value="우편번호검색" onclick="checkPost()"><br>
   
   <input type="text" name="addr1" id="addr1" value="<%=memberDTO.getAddr1() %>" placeholder="주소" size="50" readonly><br>
   
   
   
   <input type="text" name="addr2" id="addr2" value="<%=memberDTO.getAddr2() %>" placeholder="상세 주소" size="50">
  </td>
 </tr>
 
 <tr>
  <td colspan="2" align="center">
   <input type="button" value="회원정보수정" onclick="checkModifyForm()">
   <input type="reset" value="다시작성">
  </td>
 </tr>
</table>
</form>
</body>
<script type="text/javascript" src="../js/member.js"></script>
<script type="text/javascript">
window.onload=function(){
	document.modifyForm.gender['<%=memberDTO.getGender()%>'].checked = true;
	
	document.modifyForm.email2.value = '<%=memberDTO.getEmail2()%>';
	//document.getElementById('email2').value = '<%=memberDTO.getEmail2()%>';
	
	document.modifyForm.tel1.value = '<%=memberDTO.getTel1()%>';
	//document.getElementById('tel1').value = '<%=memberDTO.getTel1()%>';
}
</script>
</html>



























