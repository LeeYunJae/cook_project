$(document).ready( function() {
	getRecipe();
	getIngre();
	getOrigin();
	
})

function getRecipe() {
	var f_recipe = $('#f_recipe').val();		//레시피내용
	//var f_number = f_recipe.indexOf("**********");	//**********을 구분자로 문자열 배열에 저장
	//alert("f_number" + f_number);
	
	var html = "";
	var recipe = f_recipe.split("**********")
	for(var i=0 ; i<recipe.length-1 ; i++) {
		
		html += '<label for="foodName" class="col-sm-1 control-label">' + (i+1) + '</label>';
		html += '<p>' +recipe[i] + '</p>';	
		
	}
	$('#show_recipe').html(html);	
}

function getIngre() {
	var f_ingredients = $('#f_ingredients').val();
	
	var html = '<p>';
	var ingredients = f_ingredients.split("*****")
	for(var i=0 ; i<ingredients.length-1 ; i++) {	 
		
		html += ingredients[i] + ',   ';		
	}
	
	html+= '</p>';
	$('#show_ingre').html(html);	
}

function getOrigin() {
	var f_origin = $('#f_origin').val();		//원산지 
	//var f_number = f_origin.indexOf("*****");
	
	var html = '<p>';
	var origin = f_origin.split("*****")
	for(var i=0 ; i<origin.length-1 ; i++) {	 
		
		html += origin[i] + ',   ';		
	}
	html += '</p>';
	$('#show_origin').html(html);	
}

function beforBuy() {
	var f_num = $('#f_num').val();
	var foodCount = document.getElementById("foodCount").value;
	//alert(foodCount);
	
	location.href="buyFoodForm.app?f_num="+f_num+"&count="+foodCount;
	
}
