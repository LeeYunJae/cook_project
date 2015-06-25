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
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserControl {
	
	private static final Logger logger = LoggerFactory.getLogger(UserControl.class);
	
	@Autowired UserService userService;
	UserVO userVO;
	
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
	public ModelAndView userUpdate(@ModelAttribute UserVO userVO, HttpSession session) {
		
		System.out.println("JSON으로 넘어온 user정보 : " +userVO);

		userService.userUpdate(userVO);
		
		ModelAndView mav = new ModelAndView();
		
		session.setAttribute("loginUser", userVO);
		mav.addObject("status", "success");
		mav.setViewName("JSON");
		
		return mav;
	}
	
}
