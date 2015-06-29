var signUpCheckName = true;
var signUpCheckPwd = false;
var signUpCheckName2 = false;
var regExp6 = /^[0-9a-zA-Z가-힣]([-_\.]?[0-9a-zA-Z가-힣])*$/i; //닉네임 (특수문자)

// $(document).ready(function() { });
$(function() {
	
	if($('#userName').val()){
		document.getElementById('check_userName').style.color = "green";
		document.getElementById('check_userName').innerHTML = "닉네임이 변경되지 않았습니다.(사용가능)";
        signUpCheckName2 = true;
      }
	
	$("#userName").keyup(function() { //닉네임 유효성검사
        checkName();
      });

	$('#userUpdateBtn').click(function () {
		updateUser() ;
	});
	
}); // $(function)

/* 닉네임 유효성검사 */
function checkName() { 
	var nickName = $('#userName').val();
	if (nickName == "" || nickName.length == 0) {
		document.getElementById('check_userName').style.color = "red";
		document.getElementById('check_userName').innerHTML = "닉네임을 입력해주세요.";
		return false;
	} else if(!regExp6.test($('#userName').val())){
		document.getElementById('check_userName').style.color = "red";
		document.getElementById('check_userName').innerHTML = "닉네임을 잘못 입력하였습니다.(특수문자 입력불가!)";
		return false;
	}else{
		return true;
	}
}

/* 닉네임 중복체크 */
function signUpCheck(data){
	if (data.result == "사용 가능한 닉네임 입니다.") {
		$('#check_userName').css("color", "blue");
		signUpCheckName = true;
		return true;
	}else if(loginUser.name == $('#userName').val() & data.result == "중복된 닉네임이 존재합니다."){
		$('#check_userName').css("color", "green");
		data.result = "닉네임이 변경되지 않았습니다.(사용가능)";
		signUpCheckName = true;
		return true;
	}else if (data.result == "중복된 닉네임이 존재합니다.") {
		$('#check_userName').css("color", "red");
		signUpCheckName = false;
		return false;
	}
}

function updateUser() {
	$.ajax({
		type: "POST",
		url: "/cooks/userUpdate.app",
		async: true,
		dataType: "json",
		data: {
			id:$("#userId").val(),
			password:$("#changePwd").val(),
			name:$("#userName").val(),
			address:$("#userAddress").val(),
			phone:$("#userPhone").val()
		},
		
		success : function(data) {
			if(data.status == 'success') {
				alert("변경성공 !");
				location.href = '/cooks/cooksMain.app'
			} else {
				alert("변경에 실패했습니다 .. ");
			}
	
		},
		error : function(xhr) {
			console.log("error", xhr);
			alert("error html = " + xhr.statusText);
		} // error
		
	}); // ajax
}