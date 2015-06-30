$(document).ready( function(){

})
var count=1 ;

//레시피 단계 추가
function addRecipe() {
		count++;
		var recipeLevel = count + "단계 레시피를 입력하세요";
		
		var textarea = document.createElement("TEXTAREA");
		textarea.setAttribute("class", "form-control");
//		textarea.setAttribute("row", "3");
//		textarea.setAttribute("id", "recipe");
		textarea.setAttribute("id", count);
		textarea.setAttribute("placeholder", recipeLevel);
		
		$('#recipeClass').append(textarea);
		
}

var countIngre=1 ;
function addIngre() {
	countIngre++;
	
	//원재료명 추가
	var label = document.createElement("LABEL");
	label.setAttribute("class", "col-sm-2 control-label");
	label.setAttribute("for", "ingredients"+countIngre);
	label.setAttribute("style", "width: 180px");
	
	var div = document.createElement("DIV");
	div.setAttribute("class", "col-sm-4");
	
	var input = document.createElement("INPUT");
	input.setAttribute("type", "text");
	input.setAttribute("class", "form-control");
	input.setAttribute("id", "ingredients"+countIngre);
	
	//원산지 추가	
	var label1 = document.createElement("LABEL");
	label1.setAttribute("class", "col-sm-1 control-label");
	label1.setAttribute("for", "origin"+countIngre);	 
	
	var div1 = document.createElement("DIV");
	div1.setAttribute("class", "col-sm-4");
	
	var input1 = document.createElement("INPUT");
	input1.setAttribute("type", "text");
	input1.setAttribute("class", "form-control");
	input1.setAttribute("id", "origin"+countIngre);
	
	var b = document.createElement("BR");
	
	div.appendChild(input);
	div1.appendChild(input1);
	
	$('#addClass').append(label);
	$('#addClass').append(div);
	
	$('#addClass').append(label1);
	$('#addClass').append(div1);
	
//	alert("카운트===> " + countIngre);

 }  

function totalDetail() {

	var totalRecipe="" ;
	for(var i=1 ; i<=count ; i++){
	//	alert($('#'+i).val());
		totalRecipe += $('#'+i).val();
		totalRecipe += "**********";
	}	
	
	var totalIngre=""		//재료
	var totalOrigin=""	//재료(원산지)형식
	
	for(var j=1 ; j<=countIngre ; j++) {
		totalIngre += $('#ingredients'+j).val() ;
		totalOrigin += $('#ingredients'+j).val() ;
		
		if($('#origin' + j).val()!="") 
		{
			totalOrigin += "(" ;
			totalOrigin += $('#origin' + j).val();
			totalOrigin += ")" ;			
		}
		
		
		totalIngre += "*****";
		totalOrigin += "*****";
		
//		alert("토탈 재료===>" + totalIngre);
//		alert("토탈 재료(원산지)===>" + totalIngreOrigin);
	}
	addFoodDetail(totalRecipe, totalIngre, totalOrigin);	
}

function addFoodDetail(totalRecipe, totalIngre, totalOrigin) {
//	var f_name = $('#f_name').val();
//	var f_price = $('#f_price').val();
	
	var f_recipe = totalRecipe ;
	var f_ingredients = totalIngre ;
	var f_origin = totalOrigin ;
	
//	var r_num = $('#r_num').val() ;
	
//	$('#f_name').val(f_name);
//	$('#f_price').val(f_price);
	$('#f_recipe').val(f_recipe);
	$('#f_ingredients').val(f_ingredients);
	$('#f_origin').val(f_origin);
//	$('#r_num').val(r_num);
	
	//alert("f_ingredients==> " + f_ingredients);
	//alert("f_origin==> " + totalIngreOrigin);
	
	document.detailForm.submit();

	
	// location.href = "addFood.app?f_name="+f_name+"&f_price="+f_price+"&f_recipe="+f_recipe+"&f_ingredients="+ f_ingredients +"&f_origin=" + f_origin+ "&r_num="+r_num;	
}

