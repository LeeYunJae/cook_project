<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

     <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
        <div class="container topnav">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand topnav" href="/cooks/cooksMain.app">Cook's</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
        			<li id="signUpBtn"><a><span class="glyphicon glyphicon-user" data-toggle="modal" data-target="#signUp" data-backdrop="static"> 회원가입</span></a></li>
        			<li id="userPage" style='display:none'><a><span class="glyphicon glyphicon-user"> ${loginUser.name }</span></a></li>
                	<li id="loginBtn"><a><span class="glyphicon glyphicon-log-in" data-toggle="modal" data-target="#signIn" data-backdrop="static"> 로그인</span></a></li>
                	<li id="logoutBtn" style='display:none'><a><span class="glyphicon glyphicon-log-out" > 로그아웃</span></a></li>
        			<li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> 장바구니</a></li>
      			</ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->

<!--     <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation"> -->
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
<!--                 <a class="navbar-brand" href="#">Start Bootstrap</a> -->
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">1인메뉴</a>
                    </li>
                    <li>
                        <a href="#">맛집</a>
                    </li>
                    <li>
                        <a href="#">커뮤니티</a>
                    </li>
                    <li>
                        <a href="#">공지사항</a>
                    </li>
                    <li>
                        <a href="#">음식후기</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
<!--     </nav> -->
    </nav>
    
   
<script>

/* 로그인 했을 때와 로그인 하지 않았을 때 보여주는 버튼을 다르게 해주는 함수.  */
$.getJSON('/cooks/loginUser.app', function(data) {
	if(data.status == 'fail') {
		$('#loginBtn').css('display', '');
		$('#signUpBtn').css('display', '');
		
	} else {
		console.log("data정보 : ", data.loginUser)
		$('#logoutBtn').css('display', '');
		$('#userPage').css('display', '');
		$('#loginBtn').css('display', 'none');
		$('#signUpBtn').css('display', 'none');
	}
});
	
/* 로그아웃. */
$('#logoutBtn').click(function(event) {
	
	$.getJSON('/cooks/logoutUser.app', function(data) {
		if(data.status == 'success') {
			location.href = '/cooks/cooksMain.app';
		} else {
			alert('로그아웃 되지 않았습니다.');
		}
	});
	
});

/* 회원정보 페이지 */
$('#userPage').click(function(event) {
	location.href = '/cooks/userInfo.app';
});


</script>
