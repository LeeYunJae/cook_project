<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Cook's</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="main/css/main.css" rel="stylesheet">
    <link href="main/css/sb-admin-2.css" rel="stylesheet">
    <link href="main/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='common/css/modalStyle.css' rel='stylesheet'>
    
    <!-- jQuery -->
    <script src="js/jquery-1.11.1.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	<!-- Custom JS -->
    <script src="common/js/common.js"></script>
    <script src="common/js/signUp.js"></script>

</head>
<body>

<jsp:include page="../common/navTop.jsp"/>

    <!-- Page Content -->
	<header id="carousel-example-generic" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="item active">
				<div class="fill" style="background-image: url('main/images/salad.jpg');"></div>
			</div>
			<div class="item">
				<div class="fill" style="background-image: url('main/images/steak.jpg');"></div>
			</div>
			<div class="item">
				<div class="fill" style="background-image: url('main/images/dessert.jpg');"></div>
			</div>
		</div>

		<a class="left carousel-control" href="#carousel-example-generic"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"></span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right"></span>
		</a>
	</header>

	<div class="col-md-12">
      <div class="input-group custom-search-form">
         <input type="text" class="form-control-search" placeholder="Search...">
         <span class="input-group-btn">
            <button class="btn btn-default" type="button">
               <i class="fa fa-search"></i>
            </button>
         </span>
      </div>
   </div>

	<div class="welcome">Welcome Cook's.</div>

	<div class="container">

		<div class="row">
			<div class="col-md-7">
				<div class="thumbnail">
					<img src="main/images/galbi.jpg" alt="">
					<div class="caption">
						<h4 class="pull-right">$24.99</h4>
						<h4>
							<a href="#">First Product</a>
						</h4>
					</div>
					<div class="ratings">
						<p class="pull-right">15 reviews</p>
						<p>
							<span class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span>
						</p>
					</div>
				</div>
			</div>

			<div class="col-md-5">
				<div class="thumbnail">
					<img src="main/images/kimchizzim.jpg" alt="">
					<div class="caption">
						<h4 class="pull-right">$64.99</h4>
						<h4>
							<a href="#">Second Product</a>
						</h4>
					</div>
					<div class="ratings">
						<p class="pull-right">12 reviews</p>
						<p>
							<span class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star-empty"></span>
						</p>
					</div>
				</div>
			</div>
			<div class="col-sm-4 col-lg-4 col-md-4">
				<div class="thumbnail">
					<img src="main/images/bulgogi.jpg" alt="">
					<div class="caption">
						<h4 class="pull-right">$94.99</h4>
						<h4>
							<a href="#">Fifth Product</a>
						</h4>
					</div>
					<div class="ratings">
						<p class="pull-right">18 reviews</p>
						<p>
							<span class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star-empty"></span>
						</p>
					</div>
				</div>
			</div>

			<div class="col-sm-4 col-lg-4 col-md-4">
				<div class="thumbnail">
					<img src="main/images/gangjung.jpg" alt="">
					<div class="caption">
						<h4 class="pull-right">$94.99</h4>
						<h4>
							<a href="#">Fifth Product</a>
						</h4>
					</div>
					<div class="ratings">
						<p class="pull-right">18 reviews</p>
						<p>
							<span class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star-empty"></span>
						</p>
					</div>
				</div>
			</div>

			<div class="col-sm-4 col-lg-4 col-md-4">
				<div class="thumbnail">
					<img src="main/images/gungjoong.jpg" alt="">
					<div class="caption">
						<h4 class="pull-right">$94.99</h4>
						<h4>
							<a href="#">Fifth Product</a>
						</h4>
					</div>
					<div class="ratings">
						<p class="pull-right">18 reviews</p>
						<p>
							<span class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star-empty"></span>
						</p>
					</div>
				</div>
			</div>

			<div class="col-md-5">
				<div class="thumbnail">
					<img src="main/images/zzimdak.jpg" alt="">
					<div class="caption">
						<h4 class="pull-right">$74.99</h4>
						<h4>
							<a href="#">Third Product</a>
						</h4>
					</div>
					<div class="ratings">
						<p class="pull-right">31 reviews</p>
						<p>
							<span class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star-empty"></span>
						</p>
					</div>
				</div>
			</div>

			<div class="col-md-7">
				<div class="thumbnail">
					<img src="main/images/zzuggumi.jpg" alt="">
					<div class="caption">
						<h4 class="pull-right">$84.99</h4>
						<h4>
							<a href="#">Fourth Product</a>
						</h4>
					</div>
					<div class="ratings">
						<p class="pull-right">6 reviews</p>
						<p>
							<span class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star"></span> <span
								class="glyphicon glyphicon-star-empty"></span> <span
								class="glyphicon glyphicon-star-empty"></span>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div> <!-- /container -->

<!-- ................ Footer container ............ -->
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
    
<jsp:include page="../common/sign_modal.jsp"/>
	
</body>
</html>