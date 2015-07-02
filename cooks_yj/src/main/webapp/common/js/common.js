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


}); //document.ready


//로그인 창 닫기 (로그인 창 -> 회원가입 창 && 로그인 창 -> 비밀번호찾기 창)
function close_signIn() {
	$('#loginCloseBtn').click();
	
}	 

//비밀번호 찾기 창 닫기(비밀번호 찾기 -> 비밀번호 변경 창)
function close_findPassword() {
	$('#findPwdClose').click();
}

