package kr.co.cooks.controller;

import java.util.HashMap;

import kr.co.cooks.service.BoardRecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardRecipeController {
	@Autowired
	BoardRecipeService recipeService ;
	
	//임시 => 글 목록(리스트)로 가는 페이지
	@RequestMapping(value = "/boardRecipePre.app")
	public ModelAndView mainForm() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("board_recipe/list_pre");
		
		return mav;
	}
	
	//글 목록(리스트)
	@RequestMapping(value="/boardRecipeList.app")
	public ModelAndView boardRecipeList(@RequestParam String pageNum) {
		
		System.out.println("pagenum =====>" +pageNum);
		
		ModelAndView mav = new ModelAndView();
		
		HashMap<String, Object> hashMap= recipeService.list(pageNum);
		
		
//		mav.addObject("pageNum", pageNum);
//		mav.addObject("count", hashMap.get("count"));
//		mav.addObject("recipeList", hashMap.get("recipeList"));
//		mav.addObject("pagecode", hashMap.get("pagecode"));		
		mav.setViewName("board_recipe/list");
		
		return mav;
	}

}
