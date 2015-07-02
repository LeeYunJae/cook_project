package kr.co.cooks.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.cooks.service.RestaurantService;
import kr.co.cooks.vo.RestaurantFileListVO;
import kr.co.cooks.vo.RestaurantVO;
import kr.co.cooks.vo.UserVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RestaurantControl {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeControl.class);
	@Autowired RestaurantService restaurantService;
	RestaurantVO restaurantVO;
	
	
	@RequestMapping(value="/RestaurantList.app")
	public ModelAndView RestaurantList(){
		ModelAndView mav = new ModelAndView();
		
		List<RestaurantFileListVO> restaurantlist = restaurantService.restaurantList();
		
		mav.addObject("restaurantlist", restaurantlist);
		mav.setViewName("restaurant/ResList");
		return mav;
	}
	

	@RequestMapping(value="/AddRestaurantForm.app")
	public ModelAndView AddRestaurantForm(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("restaurant/addResForm");
		return mav;
	}
	
	@RequestMapping(value="/AddRestaurant.app", method=RequestMethod.POST)
	public ModelAndView AddRestaurant(@ModelAttribute RestaurantVO restaurantVO,
									 MultipartHttpServletRequest multipartReq,
									 HttpSession session){
		
		UserVO userVO=(UserVO)session.getAttribute("loginUser");
		restaurantVO.setId(userVO.getId());
		
		System.out.println(restaurantVO);
		
		
		restaurantService.addRestaurant(restaurantVO, multipartReq);
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect:/RestaurantList.app");
		
		return mav;
	}
	
}
