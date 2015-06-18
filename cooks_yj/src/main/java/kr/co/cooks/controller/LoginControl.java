package kr.co.cooks.controller;

import javax.servlet.http.HttpSession;

import kr.co.cooks.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginControl {

	private static final Logger logger = LoggerFactory.getLogger(LoginControl.class);
	
	@Autowired UserService loginService;
	
/*	페이지 이동만 필요할 경우 */
  
	@RequestMapping(value = "/home.app")
	public ModelAndView mainForm() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("login");
		
		return mav;
	}
	
	
	@RequestMapping(value = "/login.app")
	public ModelAndView login(@RequestParam String email, String password) {

		System.out.println("이메일 : " +email);
		System.out.println("비밀번호 : " +password);

		ModelAndView mav = new ModelAndView();

		int status = loginService.validation_Check(email, password);

		if(status==1) {

			//session.setAttribute("email", email);

			mav.setViewName("home");

		} else if(status==2) {
			System.out.println("패스워드가 틀렸습니다.");
			mav.setViewName("home");

		} else {
			System.out.println("회원이 아닙니다.");
			mav.setViewName("home");
			
		}

		return mav;
	}

	
}
