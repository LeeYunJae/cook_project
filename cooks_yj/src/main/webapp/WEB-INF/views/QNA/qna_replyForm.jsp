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

    <title>Dash Board-notice</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="community/css/shop-homepage.css" rel="stylesheet">
    <link href='common/css/modalStyle.css' rel='stylesheet'>
    
    <!-- jQuery -->
    <script src="js/jquery-1.11.1.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	<!-- Custom JS -->
	<script src="community/js/community.js"></script>
    <script src="common/js/common.js"></script>
    <script src="common/js/signUp.js"></script>
    <script src="qna/qna_replywriteForm.js"></script>
    
    
</head>

<body>

 <jsp:include page="../common/navTop.jsp"/>

    <!-- Page Content -->
    <div class="container">

        <div class="row">
        
        <div class="row row-offcanvas row-offcanvas-left">

				<div class="col-sm-3 col-md-2 sidebar-offcanvas" id="sidebar"
					role="navigation">

					<ul class="nav nav-sidebar" style="margin-top: 15px;">
						<li><a href="#">자유게시판</a></li>
						<li><a href="#">나만 아는 레시피</a></li>
						<li><a href="#">공지사항</a></li>
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

					<h2 class="sub-header">Q&A</h2>
				
			<div>

						<form>
							<input type="hidden" id="pageNum" name="pageNum" value="${pageNum}">
							<input type="hidden" id="q_Num" value="${q_Num}">
							<div class="form-group">
								<label for="id">글쓴이 : </label> ${loginUser.name}
								<hr>
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">제 목</label> 
								<input type="text" class="form-control" id="q_Title" name="q_Title" placeholder="제목을 입력하세요.">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">내 용</label>
								<textarea class="form-control" rows="3" cols="7" id="q_Content" name="q_Content" placeholder="내용을 입력하세요."></textarea>
							</div>

							<table>
								<tr>
									<td><input type="button" id="qnaReplyWriteBtn" value="글쓰기"></td>
									<td><input type="reset" value="글쓰기취소"></td>
								</tr>
							</table>

						</form>

					</div>	
						
						<!-- Button trigger modal -->
<!-- 						<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#writeForm" data-backdrop="static">글쓰기</button> -->
					</div>

				</div>
				<!--/row-->
			</div>

		</div> <!-- row -->

	
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
    
<jsp:include page="../common/sign_modal.jsp"/>
    
</body>
</html>
