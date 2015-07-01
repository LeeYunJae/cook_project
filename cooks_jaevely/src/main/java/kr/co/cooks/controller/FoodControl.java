package kr.co.cooks.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.cooks.service.FoodService;
import kr.co.cooks.vo.FoodMainFileListMapVO;
import kr.co.cooks.vo.FoodVO;
import kr.co.cooks.vo.RestaurantVO;
import kr.co.cooks.vo.UserVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FoodControl {
	private static final Logger logger = LoggerFactory.getLogger(LoginControl.class);	
	@Autowired FoodService foodService ;

	FoodVO foodVO ;
	FoodMainFileListMapVO foodFileMapVO ;
	RestaurantVO restaurantVO ;

	
	//한 레스토랑에 있는 총 음식 리스트
	@RequestMapping(value="/foodList.app")
	public ModelAndView foodList(@RequestParam String r_num, HttpSession session) {	

		ModelAndView mav = new ModelAndView();
		restaurantVO = foodService.getResInfo(r_num) ;	//가게에 대한 정보
		HashMap<String, Object> hashMap= foodService.list(r_num);	//음식 리스트
		


		mav.addObject("r_num", r_num);
		mav.addObject("restaurant", restaurantVO);
		mav.addObject("foodFileList", hashMap.get("foodFileList"));
		mav.setViewName("food/food_list");

		return mav;
	}

	//음식 상세정보 가져오기
	@Transactional
	@RequestMapping(value="/getFoodDetail.app")
	public ModelAndView getFoodDetail(@RequestParam String r_num, int f_num, HttpSession session) {		
		ModelAndView mav = new ModelAndView();

		foodFileMapVO = foodService.getFoodDetail(f_num) ;					//음식 정보 가져오기
		HashMap<String, Object> hashMap=foodService.getFoodFiles(f_num);	//추가 사진들 가져오기						
		restaurantVO = foodService.getResInfo(r_num) ;	//가게에 대한 정보
		
		
		mav.addObject("foodFileMapVO", foodFileMapVO);
		mav.addObject("foodFilesList", hashMap.get("foodFilesList"));
		mav.addObject("resUser", restaurantVO.getId()); //레스토랑 주인 아이디 가져오기
		mav.setViewName("food/food_detail");

		return mav;
	}

	//음식 등록하기 폼
	@RequestMapping(value="/addFoodForm.app")
	public ModelAndView addFoodForm(@RequestParam String r_num, HttpSession session) {	
		ModelAndView mav = new ModelAndView();

		mav.addObject("r_num", r_num);
		mav.setViewName("food/food_addForm");

		return mav;
	}

	//음식 등록하기 
	@RequestMapping(value="/addFood.app", method=RequestMethod.POST)
	public String addFood(@ModelAttribute FoodVO foodVO, HttpSession session, MultipartHttpServletRequest multipartReq) {	

		foodService.addFood(foodVO, multipartReq);

		return "redirect:/foodList.app?r_num=" + foodVO.getR_num() ;
	}

	//음식 삭제하기 
	@RequestMapping(value="/deleteFood.app")
	public String deleteFood(@RequestParam String r_num, int f_num, HttpSession session) {	

		foodService.deleteFood(f_num);

		return "redirect:/foodList.app?r_num=" + r_num ;
	}
	
	//음식 구매하기
	@RequestMapping(value="/buyFoodForm.app")
	public ModelAndView buyFoodForm(@RequestParam int f_num, int count, HttpSession session) {	
		ModelAndView mav = new ModelAndView();
		
		UserVO userVO = (UserVO)session.getAttribute("loginUser");
		
		foodFileMapVO = foodService.getFoodDetail(f_num);
		
		
		
		
		//System.out.println("f_num===>" + f_num);

		mav.addObject("userVO", userVO);	//음식 구매하는 고객 정보
		mav.addObject("f_num", f_num);		//음식번호
		mav.addObject("f_name", foodFileMapVO.getF_name());		//음식이름
		mav.addObject("f_price", foodFileMapVO.getF_price());	//음식이름
		mav.addObject("count", count);	//음식이름
		

		
		//mav.addObject("r_num", r_num);
		mav.setViewName("food/food_buyForm");

		return mav;
	}

}
