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

<title>Dash Board-Recommend</title>

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
<script src="community/js/community.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

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

		<!--     <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation"> -->
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!--                 <a class="navbar-brand" href="#">Start Bootstrap</a> -->
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
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
		<!--     </nav> -->
	</nav>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="row row-offcanvas row-offcanvas-left">

				<div class="col-sm-3 col-md-2 sidebar-offcanvas" id="sidebar"
					role="navigation">

					<ul class="nav nav-sidebar" style="margin-top: 15px;">
						<li><a href="#">자유게시판</a></li>
						<li><a href="#">나만 아는 레시피</a></li>
						<li class="active"><a href="#">이런 메뉴 어때요?</a></li>
					</ul>

				</div>
				<!--/span-->

				<div class="col-sm-9 col-md-10 main">

					<!--toggle sidebar button-->
					<p class="visible-xs">
						<button type="button" class="btn btn-primary btn-xs"
							data-toggle="offcanvas">
							<i class="glyphicon glyphicon-chevron-left"></i>
						</button>
					</p>

					<h2 class="sub-header">이런 메뉴 어때요?</h2>

					<c:if test="${count == 0 }">
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<td>게시판에 저장된 글이 없습니다</td>
									</tr>
								</thead>
							</table>
						</div>
					</c:if>


					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<td>번호</td>
									<td>제목</td>
									<td>작성자</td>
									<td>작성일</td>
									<td>조회수</td>
									<td>좋아요</td>
								</tr>
							</thead>
							
							<tbody>
							
							<c:forEach var="recipe" items="${recipeList}">
								<tr>
									<td>
										<c:out value="${recipe.recipe_num}"></c:out>
									</td>
									<td>
										<a href="recipeContent.app?recipe_num=${recipe.recipe_num}&pageNum=${pageNum}">${recipe.recipe_title}</a>
									</td>
									<td>
										<c:out value="${recipe.id}"></c:out>
									</td>
									<td>
										<c:out value="${recipe.recipe_date}"></c:out>
									</td>
									<td>
										<c:out value="${recipe.recipe_hit}"></c:out>
									</td>
									<td>
										<c:out value="${recipe.recipe_like}"></c:out>
									</td>									
								</tr>
								</c:forEach>
							</tbody>
						</table>
						
						<!-- Button trigger modal -->
						<!--  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#writeForm" data-backdrop="static">글쓰기</button> -->
						<form action="recipeWriteForm.app" method="post">
							<input type="submit" value="글쓰기"/> 
						</form>
					</div>

				</div>
				<!--/row-->
			</div>

		</div>
		<!-- row -->
	</div>
	<!-- /container -->


	<div class="container">

		<hr>

		<!-- Footer -->
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
  	<div id="writeForm_Modal"></div>  

</body>

</html>
