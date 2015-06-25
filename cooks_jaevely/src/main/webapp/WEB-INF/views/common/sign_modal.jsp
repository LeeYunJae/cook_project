<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!-- 로그인 / 회원가입 / 비밀번호 찾기 -->
    
     <!-- 로그인 Modal -->
  <div class="modal fade" id="signIn" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" id="loginCloseBtn" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span> 로그인</h4>
        </div>
        
        <div class="modal-body" style="padding:40px 50px;">
          <form role="form" id="loginForm">
            <div class="form-group">
              <label for="email"><span class="glyphicon glyphicon-envelope"></span> 이메일</label>
              <input type="text" class="form-control" id="login_email" name="email" value='' placeholder="Enter email">
            </div>
            
            <div class="form-group">
              <label for="password"><span class="glyphicon glyphicon-eye-open"></span> 비밀번호</label>
              <input type="password" class="form-control" id="login_password" name="password" value='' placeholder="Enter password">
            </div>
            
            <button type="button" id="btnLogin" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span>로그인</button>
          </form>
        </div> <!-- modal body -->
        
        <div class="modal-footer">
          <p>회원이 아니십니까? <a onclick="close_signIn();" data-toggle="modal" href="#signUp" data-backdrop="static">회원가입</a></p>
          <p>비밀번호를 잊어버리셨습니까? <a onclick="close_signIn();" data-toggle="modal" href="#findPassword" data-backdrop="static">비밀번호 찾기</a></p>      
        </div> <!-- modal footer -->
      </div> <!-- modal content -->      
    </div>
  </div>
    
    
    <!-- 회원가입 Modal -->
  <div class="modal fade" id="signUp" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" id="signUpCloseBtn" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span> 회원가입</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form role="form">
            <div class="form-group">
              <label for="signUp_email"><span class="glyphicon glyphicon-envelope"></span> 이메일</label>
              <input type="text" class="form-control" id="signUp_email" placeholder="Enter email">
            </div>
            
            <div class="form-group">
              <label for="singUp_pwd"><span class="glyphicon glyphicon-eye-open"></span> 비밀번호</label>
              <input type="password" class="form-control" id="signUp_pwd" placeholder="Enter password">
            </div>
            
            <div class="form-group">
            	<label for="signUp_uname"><span class="glyphicon glyphicon-user"></span> 이름</label>
		    	<input type="text" class="form-control" id="signUp_uname" placeholder="Enter user name">		      
            </div>
            
            <div class="form-group">
            	<label for="signUp_uaddress"><span class="glyphicon glyphicon-home"></span> 주소</label>
		     	<input type="text" class="form-control" id="signUp_uaddress" placeholder="Enter address">
            </div>
            
            <div class="form-group">
            	<label for="signUp_phone"><span class="glyphicon glyphicon-phone"></span> 연락처</label>
		      <input type="text" class="form-control" id="signUp_phone" placeholder="Enter phone number">
            </div>
            <button type="button" id="btnSignUp" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span>회원가입</button>
          </form>          
        </div> <!-- modal body -->
      </div> <!-- modal content -->      
    </div>
  </div>
  
    
  <!-- 비밀번호 찾기  Modal -->
  <div class="modal fade" id="findPwd" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" id="findPwdClose" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span>비밀번호 찾기</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form role="form">
            <div class="form-group">
              <label for="input_email"><span class="glyphicon glyphicon-envelope"></span> 계정 이메일을 입력하세요</label>
              <input type="text" class="form-control" id="input_email" placeholder="Enter email">
            </div>  
             <button type="button" onclick="close_findPassword();" class="btn btn-success btn-block" data-toggle="modal" data-target="#changePassword" data-backdrop="static"><span class="glyphicon glyphicon-grain"></span> 인증번호 받기</button>
          </form>
        </div> <!-- modal body -->
        
        <div class="modal-footer">          
        </div> <!-- modal footer -->
      </div> <!-- modal content -->      
    </div>
    </div>
    
  
  <!-- 비밀번호 변경  Modal -->
  <div class="modal fade" id="changePwd" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" id="changePwdClose" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span>비밀번호 변경</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form role="form">
            <div class="form-group">
              <label for="pinNumber"><span class="glyphicon glyphicon-envelope"></span> 인증번호</label>
              <input type="text" class="form-control" id="pinNumber" placeholder="Enter pin number">
            </div>       
            
              <div class="form-group">
              <label for="new_pwd"><span class="glyphicon glyphicon-eye-open"></span> 새 비밀번호</label>
              <input type="password" class="form-control" id="new_pwd" placeholder="Enter password">
            </div>
            
              <div class="form-group">
              <label for="check_pwd"><span class="glyphicon glyphicon-eye-open"></span> 새 비밀번호 확인</label>
              <input type="password" class="form-control" id="check_pwd" placeholder="Enter password again">
            </div>
               
            <button type="button" class="btn btn-success btn-block"><span class="glyphicon glyphicon-grain"></span> 비밀번호 변경하기</button>
          </form>
        </div> <!-- modal body -->
        
        <div class="modal-footer">          
        </div> <!-- modal footer -->
      </div> <!-- modal content -->      
    </div>
  </div>
	