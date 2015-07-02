$(document).ready( function() {
	var totalPrice = $('#totalPrice').val();
	$('#finalResultPrice').val(totalPrice);		//총 결제금액 세팅
	
});


//토탈 계산해야할 가격 계산하기
function resultPrice() {
	var totalPrice = $('#totalPrice').val();		//음식 합계 ( 음식가격 * 수량 )
	var userMileage = $('#userMileage').val();		//사용자가 보유하고있는 마일리지
	var useMileage = $('#mileageForm').val();		//쓰려고 입력한 마일리지
	
	
	if(useMileage>totalPrice) {		//사용하고자하는 마일리지 > 음식 합계
		alert("마일리지는 합계보다 적게 쓸 수 있습니다");
		$('#mileageForm').val("");
		$('#finalResultPrice').val("");
	}
	
	else {	//사용하고자하는 마일리지 <= 음식 합계
		if(useMileage > userMileage ) {		//사용하고자하는 마일리지 > 사용자 마일리지
			alert("보유하고 있는 마일리지는"+userMileage+"입니다");			
			$('#mileageForm').val("");
		}
		
		else {	//사용하고자하는 마일리지 <= 사용자 마일리지
			var resultPrice = totalPrice - useMileage ;
			$('#finalResultPrice').val(resultPrice);			
			$('#o_price').val(resultPrice);		
		}
	}
		
}

function buy() {
	var f_num = $('#f_num').val();					//음식 번호
	var count = $('#count').val();					//수량 
	var o_price = $('#finalResultPrice').val();		//음식 가격 * 수량 -마일리지
	
	//쓰려고 입력한 마일리지
	if($('#mileageForm').val()==""){	//쓰려는 마일리지가 0인 경우
		var useMileage = 0 ;
	}
	else {	//쓰려는 마일리지가 0이 아닌 경우
		var useMileage = $('#mileageForm').val();	
	}
	
	location.href="buyFood.app?f_num=" + f_num +"&count="+ count + "&useMileage=" + useMileage +"&o_price="+ o_price ;
}

