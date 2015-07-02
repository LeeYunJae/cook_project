$(document).ready( function() {
	var userId = $('#userId').val() ;
	var pageNum = parseInt($('#pageNum').val());
	
	//alert("아이디 => " + userId );
})


function freeWriteCancel() {	
	var pageNum = parseInt($('#pageNum').val());
	location.href = "freeList.app?pageNum=" + pageNum;
}