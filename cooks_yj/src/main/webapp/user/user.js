var regExp6 = /^[0-9a-zA-Z가-힣]([-_\.]?[0-9a-zA-Z가-힣])*$/i; //닉네임 (특수문자)

// $(document).ready(function() { });
$(function() {
	
		$('#userUpdateBtn').click(function () {
			
			if( $("#userName").val()=="" || $("#userAddress").val()=="" || $("#userPhone").val()=="" ) {
				alert("정확하게 입력해주세요");
				
			} else 
				updateUser() ;
			
		});
	
	
}); // $(function)


function updateUser() {
	$.ajax({
		type: "POST",
		url: "/cooks/userUpdate.app",
		async: true,
		dataType: "json",
		data: {
			id:$("#userId").val(),
			name:$("#userName").val(),
			address:$("#userAddress").val(),
			phone:$("#userPhone").val(),
			pwd:$("#userPwd").val()
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