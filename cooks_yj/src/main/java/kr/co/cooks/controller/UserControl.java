package kr.co.cooks.controller;

import javax.servlet.http.HttpSession;

import kr.co.cooks.service.UserService;
import kr.co.cooks.vo.UserVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserControl {
	
	private static final Logger logger = LoggerFactory.getLogger(UserControl.class);
	
	@Autowired UserService userService;
	UserVO userVO;
	
	@RequestMapping(value = "/emailCheck", method=RequestMethod.POST)
	public ModelAndView signUpEmailCheck(@RequestParam String signUp_email) {
		
		System.out.println("이메일 중복검사 : " +signUp_email);
		
		ModelAndView mav = new ModelAndView();
		
		String email = userService.signUpEmailCheck(signUp_email);
		if(email == null) {
			mav.addObject("status", "success");
			mav.setViewName("JSON");
			
		} else {
			mav.addObject("status", "fail");
			mav.setViewName("JSON");
		}
		
		 return mav;
	}
	
	@RequestMapping(value = "/signUp", method=RequestMethod.POST)
	public ModelAndView signUpUser(@ModelAttribute UserVO userVO) {
		
		System.out.println(userVO);
		userService.signUpUser(userVO);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("status", "success");
		mav.setViewName("JSON");
		return mav;
	}
	
	
	@RequestMapping(value = "userInfo.app")
	public String userInfo(HttpSession session) {
		
		System.out.println("session 값 : " +session.getAttribute("loginUser"));
		
		return "user/mypage_UserInfo";
	}
	
	@RequestMapping(value = "userUpdate.app")
	public ModelAndView userUpdate(@ModelAttribute UserVO userVO,
									@RequestParam String pwd, HttpSession session) {
		
		System.out.println("JSON으로 넘어온 user정보 : " +userVO);
		System.out.println("pwd 값 : " +pwd);
		
		String status = userService.userUpdate(userVO, pwd);
		
		ModelAndView mav = new ModelAndView();
		
		if(status == "success") {
			session.setAttribute("loginUser", userVO);
			mav.addObject("status", "success");
		} else {
			mav.addObject("status", "fail");
		}
		
		mav.setViewName("JSON");
		
		return mav;
	}
	
	@RequestMapping(value = "userOrderList.app")
	public String userOrderList(HttpSession session) {
		
		System.out.println("session 값 : " +session.getAttribute("loginUser"));
		
		return "user/mypage_OrderList";
	}
	
	
	
	
	
}
