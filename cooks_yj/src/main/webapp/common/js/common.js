$(function() {
	$('#sign_Modal').load('common/LoginModal.html');
});


//로그인 창 닫기 (로그인 창 -> 비밀번호찾기 창)
function close_signIn() {	  	
	$('#signIn').modal('hide');
}	 

//비밀번호 찾기 창 닫기(비밀번호 찾기 -> 비밀번호 변경 창)
function close_findPassword() {
	$('#findPassword').modal('hide');
}


