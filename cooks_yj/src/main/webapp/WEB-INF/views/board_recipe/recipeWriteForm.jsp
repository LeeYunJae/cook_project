<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

				<div class="col-sm-9 col-md-10 main">
					<p class="visible-xs">
						<button type="button" class="btn btn-primary btn-xs"
							data-toggle="offcanvas">
							<i class="glyphicon glyphicon-chevron-left"></i>
						</button>
					</p>

					<h2 class="sub-header">나만 아는 레시피</h2>

					<br>

					<div class="well bs-component">

						<form class="form-horizontal" action="recipeWrite.app"
							method="post">
							<div class="form-group">
								<label for="id">글쓴이 : </label> ${id}
								<hr>
								<!--  <input type="text" class="form-control" id="recipt_title" placeholder="제목을 입력하세요"> -->
							</div>

							<div class="form-group">
								<label for="recipe_title">제 목</label> 
								<input type="text" name="recipe_title" class="form-control" placeholder="제목을 입력하세요">
							</div>

							<div class="form-group">
								<label for="recipe_content">내 용</label>
								<textarea name="recipe_content" class="form-control" rows="10" cols="7" placeholder="내용을 입력하세요."></textarea>
							</div>
							<br>

							<div class="form-group">
								<button type="button" class="btn btn-default col-sm-1">취소</button>
								<button type="submit" class="btn btn-primary col-sm-1">등록하기</button>
							</div>

						</form>
					</div>

				</div>
			</div>

		</div>
		<!--/row-->
	</div>
	<!--/.container-->

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
