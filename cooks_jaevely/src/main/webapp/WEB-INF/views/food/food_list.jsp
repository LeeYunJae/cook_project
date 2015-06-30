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

<title>Business Frontpage - Start Bootstrap Template</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="food/css/business-frontpage.css" rel="stylesheet">


<!-- jQuery -->
<script src="js/jquery-1.11.1.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
</head>

<body>
	<jsp:include page="../common/navTop.jsp" />
	
	 <!-- Image Background Page Header -->
    <!-- Note: The background image is set within the business-casual.css file. -->
    <header class="business-header-babonae">
        <div class="container">
            <div class="row">
<!--                 <div class="col-lg-12"> -->
<!--                     <h1 class="tagline">풍차 쭈꾸미</h1> -->
<!--                 </div> -->
            </div>
        </div>
    </header>


	<!-- Page Content -->
	<div class="container">

		<div class="row">
			<div class="col-sm-8">
				<h2>바보네</h2>
				<p>바보네는 1995년 양산에서 시작해</p>
				<p>신선한 재료와</p>
			</div>
			<div class="col-sm-4">
				<h2>Contact Us</h2>
				<address>
					<strong>상세주소</strong> <br>3481 Melrose Place <br>Beverly
					Hills, CA 90210 <br>
				</address>
				<address>
					<abbr title="Phone">P:</abbr>(043) 456-7890 <br> <abbr
						title="Email">E:</abbr> <a href="mailto:#">name@example.com</a>
				</address>
			</div>
		</div>
		<!-- /.row -->

		<hr>
		
			<div class="row">
				<c:forEach var="food" items="${foodFileList}">
					<div class="col-sm-6" align="center">
							<a href="getFoodDetail.app?f_num=${food.f_num}">
								<img class="img-circle img-responsive img-center" src="fileUpload/${food.saveFileName}" alt="" style="height: 300px; width: 300px;">
							</a>
							<a href="getFoodDetail.app?f_num=${food.f_num}">${food.f_name}</a>
							<br>
						<c:out value="${food.f_price}"></c:out>
					</div>
					<br>
				</c:forEach>
			</div>
		<!-- /.row -->

		<hr>

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Your Website 2014</p>
				</div>
			</div>
			<!-- /.row -->
		</footer>

	</div>
	<!-- /.container -->

	<div id="sign_Modal"></div>
</body>

</html>
