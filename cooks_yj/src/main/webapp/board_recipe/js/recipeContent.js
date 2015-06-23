$(document).ready( function() {
	var recipe_num = parseInt($('#recipe_num').val());
	
	getComment(1);
	getLike();
	addHit();
	
	commentPageNum = parseInt($("#commentPageNum").val());	//value=1
	
	//코멘트 '추가'버튼 눌린 경우
	$("#comment_write").click( function() {
		$.ajax({
			type : "POST",
			url : "recipeCommentWrite.app",
			async : true,
			dataType : "json",
			data : {
				recipe_num : $('#recipe_num').val(),
				rcomment_content : $('#rcomment_content').val(),
			},
			success : function(data) {
				getComment(1);	
			},
			error : function(xhr) {
				
				alert("error html = " + xhr.statusText);
			}	
		});
	});	
}); 

//코멘트 가져오기
function getComment(commentPageNum)  {
	event.preventDefault();
	
	if(commentPageNum==1) {
		$('#commentPageNum').val(1);
	}
	
	commentPageNum = parseInt(commentPageNum);
	
	$.ajax({
		type : "POST",
		url : "recipeCommentRead.app",
		async : true,
		dataType : "json",
		data : {
			recipe_num : $('#recipe_num').val(),
			endRow : commentPageNum*20
		},
		success : function(data) {
			var html = '';
			
			$.each(data.commentVO, function(entryIndex, entry) {
				var formatted_date = new Date(entry.rcomment_date);				
	
				html += '<div class="row">';
				html += '<div class="col-md-2 col-sm-3 text-center">' + entry.id + '</div>';
				html += '<div class="col-md-10 col-sm-9">';
				html += '<div class="panel" style="background: #F5F5F5">' + entry.rcomment_content;
				
				html += '<div id="inlineFooter" style="float: right">';
				html += '<a onclick="recipeCommentUpdateForm()">댓글 수정 </a> . ' ;	
				html += '<a onclick="recipeCommentDelete(' + entry.rcomment_num +')">댓글 삭제 </a>' ;			
				html += '</div>'
				
				html += '<input type="hidden" id="recipe_num" value="${entry.recipe_num}">';
				
				html += '<div class="row">';
				html += '<div class="col-xs-9">';
				html += '<small class="text-muted">' +formatted_date.toLocaleString() + '</small>';
				html += '</div>';
				html += '</div>';
				html += '</div>';
				html += '</div>';
				html += '</div>';	
				
			});
			$('#show_comment').html(html);				
			$('#rcomment_content').val("");	//댓글 입력값 초기화	
		},
		error : function(xhr) {
			
			alert("error html = " + xhr.statusText);
		}	
	});
}

//댓글달기 폼으로 포커스 이동
function getFocus() {
	document.getElementById("rcomment_content").focus();
}

//좋아요
function clickLike() {
	$('#like').hide() ;
	$('#dislike').show() ;
	
	$.ajax({
		type : "POST",
		url : "recipeLike.app",
		async : true,
		dataType : "json",
		data : {
			recipe_num : $('#recipe_num').val(),			
		},
		success : function(data) {
			var recipe_like = data.recipe_like ;
			
			$('#recipe_like_form').text(recipe_like);			
		}		
	});
}

//좋아요 취소
function clickDislike() {
	$('#like').show() ;
	$('#dislike').hide() ;
	
	$.ajax({
		type : "POST",
		url : "recipeDislike.app",
		async : true,
		dataType : "json",
		data : {
			recipe_num : $('#recipe_num').val(),			
		},
		success : function(data) {
			var recipe_like = data.recipe_like ;
			
			$('#recipe_like_form').text(recipe_like);			
		}		
	});
}

//좋아요 수 가져오기
function getLike() {
	$.ajax({
		type : "POST",
		url : "getRecipeLike.app",
		async : true,
		dataType : "json",
		data : {
			recipe_num : $('#recipe_num').val(),			
		},
		success : function(data) {		
			var recipe_like = data.recipe_like ;
			
			$('#recipe_like_form').text(recipe_like);
		}
	});
}

//조회수 추가
function addHit() {
	$.ajax({
		type : "POST",
		url : "recipeHit.app",
		async : true,
		dataType : "json",
		data : {
			recipe_num : $('#recipe_num').val(),			
		},
		success : {}
	
	});	
}

//코멘트 삭제
function recipeCommentDelete(comment_num) {
//	alert("들어옴 comment_num ===> " + comment_num);
//	alert("레시피넘 ===> " + $('#recipe_num').val());
//	alert("코멘트넘 ===> " + comment_num);	
	
	$.ajax({
		type : "POST",
		url : "recipeCommentDelete.app",
		async : true,
		dataType : "json",
		data : {
			recipe_num : $('#recipe_num').val(),
			rcomment_num : comment_num,		
		},
		success : function(data) {
			getComment(1);			
		},
		error : function(xhr) {			
			alert("error html = " + xhr.statusText);
		}		
	});		
}

//코멘트 수정 폼
function recipeCommentUpdateForm(comment_num) {
	alert("수정")
	
	var recipeCommentUpdateForm = document.getElementById('recipeCommentUpdateForm');
		recipeCommentUpdateForm.show();
	
}

//코멘트 수정
function recipeCommentUpdate(comment_num) {

	$.ajax({
		type : "POST",
		url : "recipeCommentUpdate.app",
		async : true,
		dataType : "json",
		data : {
			recipe_num : $('#recipe_num').val(),
			rcomment_num : comment_num,		
		},
		success : function(data) {
			getComment(1);			
		},
		error : function(xhr) {			
			alert("error html = " + xhr.statusText);
		}		
	});	
	
}

