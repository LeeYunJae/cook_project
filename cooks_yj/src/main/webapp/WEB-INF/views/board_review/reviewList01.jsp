<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Dash Board-Review</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="community/css/shop-homepage.css" rel="stylesheet">
    <link href='common/css/modalStyle.css' rel='stylesheet'>

	<style>
	#teamMember {
		height: 30px;
		-webkit-transition: all 0.3s ease;
		-moz-transition: all 0.3s ease;
		-o-transition: all 0.3s ease;
		transition: all 0.3s ease;
	}
	
	#teamMember.fullSize {
		height: 80px;
		-webkit-transition: all 0.3s ease;
		-moz-transition: all 0.3s ease;
		-o-transition: all 0.3s ease;
		transition: all 0.3s ease;
	}
	
	textarea {
		height: 100%;
		resize: none;
	}
	</style>

	<!-- jQuery -->
    <script src="js/jquery-1.11.1.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	<!-- Custom JS -->
    <script src="common/js/common.js"></script>
    <script src="common/js/signUp.js"></script>
    <script src="user/user.js"></script>
    <script src="common/js/reviewList.js"></script>

</head>
<body>

    <jsp:include page="../common/navTop.jsp"/>

    <!-- Page Content -->
    <div class="container">

        <div class="row">
        
        <div class="row row-offcanvas row-offcanvas-left">

				<div class="col-sm-9 col-md-10 main" style="width: 100%;">

					<!--toggle sidebar button-->
					<p class="visible-xs">
						<button type="button" class="btn btn-primary btn-xs"
							data-toggle="offcanvas">
							<i class="glyphicon glyphicon-chevron-left"></i>
						</button>
					</p>

					<h2 class="sub-header">Cook's Review</h2>
					
					
	<form>
		<div class="form-group">
			<div id="teamMember" style="cursor: text">
				<textarea id="textA" cols="100%" placeholder="무슨 일이 일어나고 있나요?"></textarea>
			</div>
		</div>

		<div id="addBtn" class="form-group" style="display: none">
			<div class="col-sm-10" style="padding-left: 0px;">
				<button type="submit" class="btn btn-default">사진추가</button>
				<button type="submit" class="btn btn-default col-sm-offset-9">글쓰기</button>
			</div>
		</div>
	</form>
					
					<div class="table-responsive">
						<table class="table table-striped" id='reviewListTable'>
							<thead>
								<tr>
									<th style="width: 6%;">#</th>
									<th style="width: 12%; text-align: center;">이미지</th>
									<th>제 목</th>
									<th style="width: 12%; text-align: center;">작성자</th>
									<th style="width: 12%; text-align: center;">날짜</th>
									<th style="width: 10%; text-align: center;">평점</th>
								</tr>
							</thead>
							<tbody style="font-size: 11px;">
							
							<c:forEach var="reviewList" items="${reviewList }">
							
								<tr style="height: 5em;">
									<td style="vertical-align:middle;">${reviewList.re_Num }</td>
									<td style="vertical-align:middle;"><img src="community/images/galbi.jpg" style="width: 95%; height: 5em;"></td>
									<td style="vertical-align:middle;">${reviewList.re_Title }</td>
									<td style="vertical-align:middle; text-align: center;">${reviewList.id }</td>
									<td style="vertical-align:middle; text-align: center;">${reviewList.re_Date }</td>
									<td style="vertical-align:middle; text-align: center;">★★★★★</td>
								</tr>
								
							</c:forEach>
							
							</tbody>
						</table>
						
						<button type="submit" class="btn btn-sm btn-default">글쓰기</button>
					</div>

				</div>
				<!--/row-->
			</div>

		</div> <!-- row -->
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

	<script>
		$('#textA').click(function() {
			$('#textA').removeAttr('placeholder');
			if ($('#teamMember').hasClass('fullSize')) {} 
			else {
				$('#teamMember').addClass('fullSize');
				$('#addBtn').css('display', '');
			}
		});

		$('#textA').focusout(function() {
			if ($('#textA').val().length > 0) {

			} else {

				$('#textA').attr('placeholder', '여러분의 후기를 남겨주세요~');
				$('#teamMember').removeClass('fullSize');
				$('#addBtn').css('display', 'none');
			}
		});
		
		
	</script>

</body>
</html>
