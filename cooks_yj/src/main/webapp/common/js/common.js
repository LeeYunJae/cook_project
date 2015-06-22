
$(document).ready(function () {
	
	$('#btnLogin').click(function () {
		$.ajax({
			type: "POST",
			url: "/cooks/login.app",
			async: true,
			dataType: "json",
			data: {
				email:$("#login_email").val(),
				password:$("#login_password").val()
			},
			
			success : function(data) {
				if(data.status == 'success') {
					location.href = '/cooks/cooksMain.app'
				} else {
					alert("아이디 또는 암호가 맞지 않습니다");
				}
		
			},
			error : function(xhr) {
				console.log("error", xhr);
				alert("error html = " + xhr.statusText);
			} // error
			
		}); // ajax
		
	}); // click(function)

	
	// modal 창 닫을 때  modal 폼 reset 해주는 함수들.
	$('#loginCloseBtn').click(function(event) {
		$('#login_email').val('');
		$('#login_password').val('');

	});
	
	$('#signUpCloseBtn').click(function(event) {
		$('#signUp_email').val('');
		$('#signUp_pwd').val('');
		$('#signUp_uname').val('');
		$('#signUp_uaddress').val('');
		$('#signUp_phone').val('');

	});
	
	$('#findPwdClose').click(function(event) {
		$('#input_email').val('');

	});
	
	$('#changePwdClose').click(function(event) {
		$('#pinNumber').val('');
		$('#new_pwd').val('');
		$('#check_pwd').val('');

	});
	
}); //document.ready


//로그인 창 닫기 (로그인 창 -> 회원가입 창 && 로그인 창 -> 비밀번호찾기 창)
function close_signIn() {
	$('#login_email').val('');
	$('#login_password').val('');
	$('#signIn').modal('hide');
	
}	 

//비밀번호 찾기 창 닫기(비밀번호 찾기 -> 비밀번호 변경 창)
function close_findPassword() {
	$('#input_email').val('');
	$('#findPassword').modal('hide');
}

