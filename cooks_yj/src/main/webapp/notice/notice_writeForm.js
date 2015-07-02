$(function () {
	
	$('#noticeWriteBtn').click(function() {
		
		if($("#no_Title").val() == "" || $("#no_Content").val() == "") {
			alert("제목 또는 내용을 입력하세요.");
		} else {
			writeNotice();
		}
			
	}); // click()
	
}); // $function()

function writeNotice(){
	
	$.ajax({
		type: "POST",
		url: "/cooks/NoticeWrite.app",
		async: true,
		dataType: "json",
		data: {
			no_Title:$("#no_Title").val(),
			no_Content:$("#no_Content").val(),
			pageNum: $("#pageNum").val()
		},
		
		success : function(data) {
			if(data.status == 'success') {
				location.href = "/cooks/NoticeList.app?pageNum="+1
			} 
	
		},
		error : function(xhr) {
			console.log("error", xhr);
			alert("error html = " + xhr.statusText);
		} // error
		
	}); // ajax
}
