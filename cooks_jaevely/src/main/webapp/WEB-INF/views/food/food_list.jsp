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

<title>맛있는 Cooks</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="food/css/business-frontpage.css" rel="stylesheet">


<!-- jQuery -->
<script src="js/jquery-1.11.1.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- Custom JS -->
<script src="common/js/common.js"></script>
<script src="common/js/signUp.js"></script>

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
				<h2>${restaurant.r_name}</h2>
				<p>${restaurant.r_info}</p>

			</div>
			<div class="col-sm-4">
				<h2>Contact Us</h2>
				<address>
					<strong>상세주소</strong><br>${restaurant.r_address}<br>
				</address>
				<address>
					<abbr title="Phone">P : </abbr>${restaurant.r_phone}<br> 
				</address>
			</div>
			
			<c:if test="${loginUser.id==restaurant.id || loginUser.user_Level==2}"> 
				<a class="btn btn-primary btn-md" href="addFoodForm.app?r_num=${r_num}">음식 추가하기</a>						
			</c:if>		
			
		</div> <!-- /.row -->

		<hr>
		
			<div class="row">
				<c:forEach var="food" items="${foodFileList}">
					<div class="col-sm-6" align="center">
							<a href="getFoodDetail.app?r_num=${food.r_num}&f_num=${food.f_num}">
								<img class="img-circle img-responsive img-center" src="fileUpload/${food.saveFileName}" alt="" style="height: 300px; width: 300px;">
							</a>
							<a href="getFoodDetail.app?r_num=${food.r_num}&f_num=${food.f_num}">${food.f_name}</a>
							<br>
						<c:out value="${food.f_price}"></c:out>
					</div>
					<br>
				</c:forEach>
			</div> <!-- /.row -->

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

<jsp:include page="../common/sign_modal.jsp"/>
</body>

</html>
