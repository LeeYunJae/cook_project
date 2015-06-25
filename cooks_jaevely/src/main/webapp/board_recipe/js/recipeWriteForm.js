$(document).ready( function() {
	var userId = $('#userId').val() ;
	var pageNum = parseInt($('#pageNum').val());
	
	//alert("아이디 => " + userId );
})


function recipeWriteCancel() {	
	var pageNum = parseInt($('#pageNum').val());
	location.href = "recipeList.app?pageNum=" + pageNum;
}