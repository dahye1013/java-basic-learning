<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.ZipcodeDTO"%>
<%@page import="java.util.List"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>우편번호</title>
<link rel="stylesheet" href="../css/member.css">
</head>
<body>
<form name="newzipcode" method="post" action="checkPost.do">
		<table border="1" width = "100%" cellspacing="0" cellpadding="3">
			<tr>
				<!--1행-->
				<th width="70" align="center">시도</th>
				<td><select name="sido" style="width: 100px">
						<option value="시도선택">시도선택</option>
						<option value="서울">서울</option>
						<option value="인천">인천</option>
						<option value="대전">대전</option>
						<option value="대구">대구</option>
						<option value="울산">울산</option>
						<option value="세종">세종</option>
						<option value="광주">광주</option>
						<option value="경기">경기</option>
						<option value="강원">강원</option>
						<option value="전남">전남</option>
						<option value="광주">전북</option>
						<option value="경남">경남</option>
						<option value="경북">경북</option>					
				</select>
				<th width="70" align="center">시,군,구</th>
				<td><input type="text" name="sigungu" size="30" value="${sido }"></td>
			</tr>
			<tr>
				<!--2행-->
				<th  align="center">도로명</th>
				<td colspan="3"><input type="text" name="roadname" size="30">
				<input type="submit" value="검색"  >
				</td>
			</tr>
			 <tr>
				<!--2행-->
				<th  align="center">우편번호</th>
				<th align="center" colspan="4">주소</th>
				
			</tr>
			
			<c:if test="${list!=null}">
			<c:forEach var="zipcodeDTO" items="${list}">
			<c:set var="address">
			${zipcodeDTO.getBuildingname()
			} ${zipcodeDTO.getSido()
			} ${zipcodeDTO.getSigungu()
			} ${zipcodeDTO.getYubmyungdong()
			} ${zipcodeDTO.getRi()
			} ${zipcodeDTO.getRoadname()
			} ${zipcodeDTO.getBuildingname()
			}
			</c:set>
			<tr>
			<td>${zipcodeDTO.getZipcode()}</td>
			<td colspan="3">
			<a id="addressA" href="#" onclick="checkPostClose('${zipcodeDTO.getZipcode()}', '${address}')">${address}</a></td>
			</tr>			
			 </c:forEach></c:if>
			

			
</table>
</form>
</body>
<script type="text/javascript" src="../js/member.js"></script>
</html>