package kr.co.cooks.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.cooks.service.RecipeCommentService;
import kr.co.cooks.vo.RecipeCommentVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RecipeCommentController {
	@Autowired RecipeCommentService commentService;
	
	//코멘트 쓰기
	@RequestMapping(value="/recipeCommentWrite.app")
	public ModelAndView recipeCommentWrite(@ModelAttribute RecipeCommentVO commentVO, HttpSession session, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView();
		
		commentVO.setId((String)session.getAttribute("id"));
		
		mav.addObject("commentVO", commentService.commentWrite(commentVO));
		mav.setViewName("JSON");			

		return mav ;		
	}
	
	//코멘트 읽기
	@RequestMapping("/recipeCommentRead.app")
	public ModelAndView recipeCommentRead(int recipe_num, int endRow, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("commentVO", commentService.commentRead(recipe_num, endRow));
		mav.setViewName("JSON");
				
		return mav;		
	}

}
