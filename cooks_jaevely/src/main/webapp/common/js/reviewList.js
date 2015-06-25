var currentPageNum;
var endPageNum;

// $(document).ready(function() {}) ;
$(function () {
	loadReviewList(1);
	
	
}); //document.ready


// 페이징처리.
function setPageNum(currentPageNum, endPageNum) {
	window.currentPageNum = currentPageNum;
	window.endPageNum = endPageNum;
	
	$('#pageNum').html(currentPageNum);
	
	if(currentPageNum <= 1)
		$('#prevBtn').css('display', 'none');
	else
		$('#prevBtn').css('display', '');
	
	if(currentPageNum >= endPageNum)
		$('#nextBtn').css('display', 'none');
	else
		$('#nextBtn').css('display', '');
	
} // setPageNum

$('#writeReviewBtn').click(function(event) {
	
	$.post('/cooks/writeReply.app',
			{
				id : loginUser.id,
				re_Title : $('#re_Title'),
				re_Content : $('#re_Content'),
				re_Date : $('#re_Date'),
				re_Grade : $('#re_Grade'),
				re_Fname : $('#re_Fname'),
				re_Dept : $('#re_Dept'),
				re_Position : $('#re_Position'),
				f_Num : $('#f_Num')
			
			}, function(data) {
				
				if(data.status == "success") {
					alert("등록성공");
					// 폼 리셋 시켜주는 $('#btnCancel').click(); 이벤트 추가.
				} else 
					alert("등록실패");
			}, 'JSON' /* function(data) */  )
			/* 서버 요청이 실패할 경우 호출될 함수 등록. */
			.fail(function(jqXHR, textStatus, errorThrown) {
				alert(textStatus + ":" +errorThrown);
			});
});


// 리뷰리스트
function loadReviewList(pageNum) {
	if(pageNum <= 0) pageNum = currentPageNum;
	
	$.getJSON('/cooks/reviewList.app?pageNum='+pageNum, function(data) {
		
		setPageNum(data.currentPageNum, data.endPageNum);
		
		var reviewList = data.reviewList;
		
		$('.data-row').remove();
		
		for(var i=0 ; i < reviewList.length ; i++) {
			
			$('<tr>').addClass('data-row').css('height', '5em')
			.append($('<td>').html(reviewList[i].re_Num).css('vertical-align', 'middle'))
			.append(
					$('<td>').append(
							$('<img>').attr('src', '#').css('width', '95%').css('height', '5em')
							)
							.css('vertical-align', 'middle')
						)
			.append(
					$('<td>').append(
							$('<a>').attr('href', '#')
									.attr('data-replyNo', reviewList[i].re_Num)
									.html(reviewList[i].re_Title)
							)
							.css('vertical-align', 'middle')
						)
			.append($('<td>').html(reviewList[i].id).css('vertical-align', 'middle').css('text-align', 'center'))
			.append($('<td>').html(reviewList[i].re_Date).css('vertical-align', 'middle').css('text-align', 'center'))
			.append($('<td>').html("★★★★★").css('vertical-align', 'middle').css('text-align', 'center'))
			.appendTo('#reviewListTbody')
		} // for
		
	});
} // loadReviewList