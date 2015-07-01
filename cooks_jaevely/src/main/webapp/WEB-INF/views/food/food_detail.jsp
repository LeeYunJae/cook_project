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
<link href='common/css/modalStyle.css' rel='stylesheet'>
<link href="food/css/food.css" rel="stylesheet">

<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- Custom JS -->
<script src="food/js/food_detail.js"></script>
<script src="common/js/common.js"></script>
<script src="common/js/signUp.js"></script>

<style>
#slogan {
   top: 50%;
   left: 50%;
   width: 600px;
   height: 400px;
   margin-left: 250px;
}

#foodFiles {
	margin-left: 20%;
}

</style>

</head>



<body>
	<jsp:include page="../common/navTop.jsp" />

	<input type="hidden" id="f_num" value="${foodFileMapVO.f_num}">
	<input type="hidden" id="userId" value="${loginUser.id}">
	<input type="hidden" id="f_recipe" value="${foodFileMapVO.f_recipe}">
	<input type="hidden" id="f_origin" value="${foodFileMapVO.f_origin}">
	<input type="hidden" id="f_ingredients" value="${foodFileMapVO.f_ingredients}">

	<!-- Page Content -->

	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<img class="img-responsive" id="mainFile" src="fileUpload/${foodFileMapVO.saveFileName}" alt="">
			</div>
	
			<div class="menu-info">
				<h1>${foodFileMapVO.f_name}</h1>
				<table class="menuinfo-text">
					<tr>
						<td>가격</td>
						<td>${foodFileMapVO.f_price}원</td>
					</tr>
					<tr>
						<td>마일리지</td>
						<td><c:out value="${foodFileMapVO.f_price*0.05}"></c:out>(5%)</td>

					</tr>
					<tr>
						<td>구매수량</td>
						<td><select class="form-control qty-select-form" id="foodCount" name="foodCount">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
						</select></td>
					</tr>
				</table>
		
				 <a class="btn btn-primary btn-md" onclick="beforBuy()">구매하기</a>
				<%-- <a class="btn btn-primary btn-md" href="buyFoodForm.app?f_num=${foodFileMapVO.f_num}">구매하기</a> --%>	
				<a class="btn btn-primary btn-md" href="#">장바구니</a>			
				
				<c:if test="${loginUser.id==resUser || loginUser.user_Level==2}"> 
					<a class="btn btn-primary btn-md" href="deleteFood.app?r_num=${foodFileMapVO.r_num}&f_num=${foodFileMapVO.f_num}">음식 삭제하기</a>						
				</c:if> 	
					
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="themline">
					<p style="font-size: 20px; color: #d85c9a; margin-left: 520px;">Menu</p>
				</div>

				<!-- 사진부분 -->				
				<img src="food/images/slogan1.png" alt="slogan" id="slogan"><br><br>
				
				<c:forEach var="files" items="${foodFilesList}">
					<img src="fileUpload/${files.saveFileName}" id="foodFiles" alt="" align="middle">
					<br><br><br>
				</c:forEach>
				
						
			</div>
			
			<div class="row">
				<div class="col-md-12">
					<div class="themline">
						<p style="font-size: 20px; color: #d85c9a; margin-left: 520px;">Recipe</p>
					</div>
					<div class="recipe">

						<br>
						<h3 id="howToCook">${foodFileMapVO.f_name}만드는 법</h3><br>

						<div class="form-group">
							<label for="foodName" class="col-sm-1 control-label">재료</label>
							<div id="show_ingre"></div>
						</div>
						<hr>
						
						<div class="form-group">
							<!-- <label for="foodName" class="col-sm-1 control-label">1</label>
							<p></p> -->
							<div id="show_recipe"></div>	
						</div>
						
						<br>
						
						
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="themline">
						<p style="font-size: 20px; color: #d85c9a; margin-left: 522px;">Detail</p>
					</div>
					<h3>상세정보</h3>
					<div class="product-list-text">
						<p style="font-size: 20px;">유통기간</p>
						<p>${foodFileMapVO.f_ex_date} </p>
					</div>
					
				</div>
				
				<div class="col-md-12">
					<div class="origin-text">
						<p style="font-size: 20px;">원산지 안내</p>		
							<div id="show_origin"></div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="themline">
						<p style="font-size: 20px; color: #d85c9a; margin-left: 520px;">Review</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="themline">
						<p style="font-size: 20px; color: #d85c9a; margin-left: 520px;">QnA</p>
					</div>
				</div>
			</div>
		</div>
	</div>



	<!--     </div> -->
	<!-- /.container -->

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
