package kr.co.cooks.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.cooks.service.FoodService;
import kr.co.cooks.vo.FoodMainFileListMapVO;
import kr.co.cooks.vo.FoodVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	//음식 상세정보 가져오기
	@RequestMapping(value="/getFoodDetail.app")
	public ModelAndView getFoodDetail(@RequestParam int f_num, HttpSession session) {		
		ModelAndView mav = new ModelAndView();

		foodFileMapVO = foodService.getFoodDetail(f_num) ;
		HashMap<String, Object> hashMap=foodService.getFoodFiles(f_num);

		mav.addObject("foodFileMapVO", foodFileMapVO);
		mav.addObject("foodFilesList", hashMap.get("foodFilesList"));
		mav.setViewName("food/food_detail");

		return mav;
	}

	//한 레스토랑에 있는 총 음식 리스트
	@RequestMapping(value="/foodList.app")
	public ModelAndView foodList(@RequestParam String r_num, HttpSession session) {	
		
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> hashMap= foodService.list(r_num);
		
		
		mav.addObject("r_num", r_num);
		mav.addObject("foodFileList", hashMap.get("foodFileList"));
		mav.setViewName("food/food_list");
		
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
		
//		System.out.println("f_name===>" + foodVO.getF_name());
//		System.out.println("f_recipe===>" + foodVO.getF_recipe());
//		System.out.println("f_ingredients===>" + foodVO.getF_ingredients());
//		System.out.println("f_origin===>" + foodVO.getF_origin());
//		System.out.println("r_num===>" + foodVO.getR_num());
//		
//		
//		System.out.println("사진====" +multiReq.getParameter("food_mainFile"));
//		System.out.println("사진===>>>>>" +multiReq.getFile("food_mainFile"));

//		foodService.addFood(foodVO);
		foodService.addFood(foodVO, multipartReq);
	
		return "redirect:/foodList.app?r_num=" + foodVO.getR_num() ;
	}

}
