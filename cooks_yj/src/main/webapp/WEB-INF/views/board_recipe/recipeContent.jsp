<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Dash Board-Custom</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="community/css/shop-homepage.css" rel="stylesheet">


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<!-- jQuery -->
<script src="js/jquery.js"></script>
<script src="common/js/common.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<style>
#inlineFooter, #recipe_like_form {
	display: inline-block;
}
</style>

<script>
$(document).ready( function() {
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
				
				var html = '';
				
				$.each(data.commentVO, function(entryIndex, entry) {
					var formatted_date = new Date(entry.rcomment_date);
					
					html += '<div class="row">';
					html += '<div class="col-md-2 col-sm-3 text-center">' + entry.id + '</div>';
					html += '<div class="col-md-10 col-sm-9">';
					html += '<div class="panel" style="background: #F5F5F5">' + entry.rcomment_content;
					html += '<div class="row">';
					html += '<div class="col-xs-9">';
					html += '<small class="text-muted">' + formatted_date.toLocaleString() + '</small>';
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

</script>


</head>


<body>

	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top topnav"
		role="navigation">
		<div class="container topnav">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand topnav" href="#">Cook's</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a><span class="glyphicon glyphicon-log-in"
							data-toggle="modal" data-target="#signIn"> 로그인</span></a></li>
					<li><a><span class="glyphicon glyphicon-user"
							data-toggle="modal" data-target="#signUp"> 회원가입</span></a></li>
					<li><a href="#"><span
							class="glyphicon glyphicon-shopping-cart"></span> 장바구니</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->


		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="#">1인메뉴</a></li>
					<li><a href="#">맛집</a></li>
					<li><a href="#">커뮤니티</a></li>
					<li><a href="#">공지사항</a></li>
					<li><a href="#">음식후기</a></li>
					<li><a href="#">맛집등록</a></li>
					<li><a href="#">메뉴등록</a></li>
					<li><a href="#">주문내역</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="row row-offcanvas row-offcanvas-left">
				<div class="col-sm-3 col-md-2 sidebar-offcanvas" id="sidebar"
					role="navigation">

					<ul class="nav nav-sidebar" style="margin-top: 15px;">
						<li><a href="#">자유게시판</a></li>
						<li class="active"><a href="#">나만 아는 레시피</a></li>
					</ul>

				</div>
				
				<input type="hidden" name="pageNum" value="${pageNum}">
				<input type="hidden" id="recipe_num" value="${recipeVO.recipe_num}">

				<div class="col-sm-9 col-md-10 main">
					<p class="visible-xs">
						<button type="button" class="btn btn-primary btn-xs"
							data-toggle="offcanvas">
							<i class="glyphicon glyphicon-chevron-left"></i>
						</button>
					</p>

					<h2 class="sub-header">나만 아는 레시피</h2>

					<br>

					<div class="panel panel-default">
						<div class="panel-heading">
							<h4>${recipeVO.recipe_title}</h4>
							<label for="id">글쓴이 : </label> ${id} <br>
						</div>
						<div class="panel-body">${recipeVO.recipe_content}</div>
						<div class="panel-footer">
							<div id="inlineFooter">
								<a onclick="clickLike()" id="like">좋아요</a>
								<a onclick="clickDislike()" id="dislike" hidden="hidden">좋아요 취소</a> . 
								<a onclick="getFocus()">댓글달기</a> . 
								<a><span class="glyphicon glyphicon-thumbs-up"></span><div id="recipe_like_form"></div></a>

							</div>

							<!-- 게시글 수정/게시글 삭제 버튼을 좋아요/댓글달기 와 같은줄에 오게하기위해 id값 주고 style에서 inline-block 해줌 -->
							<div id="inlineFooter" style="float: right">
								<a
									href="recipeUpdateForm.app?recipe_num=${recipeVO.recipe_num}&pageNum=${pageNum}">게시글
									수정</a> . <a
									href="recipeDelete.app?recipe_num=${recipeVO.recipe_num}&pageNum=${pageNum}">게시글
									삭제</a> . <a href="recipeList.app?pageNum=${pageNum}">목록으로</a>
							</div>
						</div>
					</div>
					
					
					<div class="well row" id="commentForm">
							<input type="hidden" id="commentPageNum" value="1">
						
						 
						<!-- 댓글이 0개인 경우 -->
						<!--
						<c:if test="${recipeCommentCount == 0 }">
							<h4>등록된 댓글이 없습니다</h4>
						</c:if>
						 -->

						<!-- 기존에 있는 코멘트 읽어오기 -->
						
						 <div id="show_comment"></div>

						<!-- --------------------------------------------------------------------------------- -->

						<form class="form-horizontal" role="form">
							<div class="form-group" style="padding: 14px;">
						<!-- 댓글 입력 창 -->
								<textarea class="form-control" id="rcomment_content" name="rcomment_content"
									placeholder="댓글을 입력하세요!"></textarea>
							</div>
							<c:if test="${id==null}">
								<button class="btn btn-primary pull-right" type="button" id="comment_write" disabled="disabled">추가</button>
							</c:if>
							<c:if test="${id!=null}">
								<button class="btn btn-primary pull-right" type="button" id="comment_write">추가</button>
							</c:if>
							<ul class="list-inline">
								<li><a href=""><i class="glyphicon glyphicon-upload"></i></a></li>
								<li><a href=""><i class="glyphicon glyphicon-camera"></i></a></li>
							</ul>
						</form>
					</div>
				</div>

			</div>

		</div> <!--/row-->
	</div> <!--/.container-->

	<!-- Footer -->
	<div class="container">
		<hr>
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Get Hyped for Food</p>
				</div>
			</div>
		</footer>
	</div>
	<!-- /.container -->

	<div id="sign_Modal"></div>
</body>

</html>
