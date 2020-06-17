function checkWriteForm() {
	if(document.getElementById("name").value == ""){ 
		alert("이름을 입력하세요");
		document.writeForm.name.focus();
	}else if (document.writeForm.id.value == ""){
		alert("아이디를 입력하세요");
		document.writeForm.id.focus();
	}else if (document.writeForm.pwd.value == ""){
		alert("비밀번호를 입력하세요");
		document.writeForm.pwd.focus();
	}else if (document.writeForm.repwd.value == ""){
		alert("비밀번호 재입력하세요");
		document.writeForm.repwd.focus();
	}else if (document.writeForm.pwd.value != document.writeForm.repwd.value){
		alert("비밀번호가 일치하지 않습니다.");
	}else if(document.writeForm.idDuplication.value == "idUncheck"){
		alert("중복체크하십시오.");
	}else{
		document.writeForm.submit();
	}
}





function checkLoginForm() {
	if (document.loginForm.id.value == ""){
		alert("아이디를 입력하세요");
		document.loginForm.id.focus();
	}else if (document.loginForm.pwd.value == ""){
		alert("비밀번호를 입력하세요");
		document.loginForm.pwd.focus();
	}else
		document.loginForm.submit();
}

function checkId(){
	let id = document.writeForm.id.value;
	if(id == ""){
		alert("아이디를 입력하세요");
	}else{
		window.open("/miniProject/member/checkId.do?id="+id,"","width=300 height=100 location=yes")
	}
}

function checkIdClose(id) {
		opener.writeForm.id.value = id;
		// 열려있는 창들 중에 WirteForm에서 id.value 값을 쥐어준다.
		opener.writeForm.idDuplication.value = "idCheck";
		window.close();
		opener.wrtieForm.pwd.focus();
	}		




function inputIdChk(){
	//alert("idUnCheck로 변환");
	document.writeForm.idDuplication.value = "idUncheck";
}

function IdChk(){
	opener.writeForm.idDuplication.value = "idCheck";
}

function checkPost(){
	window.open("checkPost.do","","width=500 height=500 scrollbars=yes");
}

function checkPostClose(zipcode, address){
	   
	   opener.document.forms[0].zipcode.value=zipcode;
	   opener.document.forms[0].addr1.value = address;
	   //opener.writeForm.idDuplication.value = id;      
	   //opener는 열려있는 창
	   window.close();
	   opener.document.forms[0].addr2.focus();
	   
	   
	   /*
	   opener.document.getElementById("zipcode").value = zipcode;
	   opener.document.getElementById("addr1").value = addr1;
	   window.close();
	   opener.document.getElementById("addr2").focus();
	   */
	}




function writeInfo(id){
	document.writeForm.id.value = id;
	document.writeForm.pwd.value = pwd;
	document.writeForm.name.value = name;
	
}

function checkModifyForm() {
	if(document.getElementById("name").value == ""){ 
		alert("이름을 입력하세요");
		document.modifyForm.name.focus();
	}else if (document.modifyForm.id.value == ""){
		alert("아이디를 입력하세요");
		document.modifyForm.id.focus();
	}else if (document.modifyForm.pwd.value == ""){
		alert("비밀번호를 입력하세요");
		document.modifyForm.pwd.focus();
	}else
		document.modifyForm.submit();
	
}













