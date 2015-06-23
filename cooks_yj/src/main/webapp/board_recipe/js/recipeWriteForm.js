function recipeWriteCancel() {	
	var pageNum = parseInt($('#pageNum').val());
	
	location.href = "recipeList.app?pageNum=" + pageNum;
}