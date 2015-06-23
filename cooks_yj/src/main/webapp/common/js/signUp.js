$(document).ready(function () {
	$('#btnSignUp').click(function () {
		
		$.ajax({
			type: "POST",
			url: "/cooks/signUp.app",
			async: true,
			dataType: "json",
			data: {
				id:$("#signUp_email").val(),
				password:$("#signUp_pwd").val(),
				name:$("#signUp_uname").val(),
				address:$("#signUp_uaddress").val(),
				phone:$("#signUp_phone").val()
			},
			
			success : function(data) {
				if(data.status == 'success') {
					alert("회원가입이 완료되었습니다. ^^");
					location.href = '/cooks/cooksMain.app'
				} else {
					alert("등록실패");
				}
		
			},
			error : function(xhr) {
				console.log("error", xhr);
				alert("error html = " + xhr.statusText);
			} // error
			
		}); // ajax
		
	}); // click(function)
	
}); //document.ready



