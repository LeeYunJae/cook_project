package kr.co.cooks.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.cooks.service.RecipeCommentService;
import kr.co.cooks.vo.RecipeCommentVO;
import kr.co.cooks.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RecipeCommentControl {
	@Autowired RecipeCommentService commentService;
	
	//코멘트 쓰기
	@RequestMapping(value="/recipeCommentWrite.app")
	public void recipeCommentWrite(@ModelAttribute RecipeCommentVO commentVO, HttpSession session) {
		
		UserVO sessionVO = (UserVO)session.getAttribute("loginUser");		
		commentVO.setId(sessionVO.getId());
		
		commentService.commentWrite(commentVO);		
	}
	
	//코멘트 읽기
	@RequestMapping("/recipeCommentRead.app")
	public ModelAndView recipeCommentRead(int recipe_num, int endRow, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("recipeCommentUserVO", commentService.commentRead(recipe_num, endRow));
		mav.setViewName("JSON");
				
		return mav;		
	}
	
	//코멘트 삭제
	@RequestMapping("/recipeCommentDelete.app")
	public void recipeCommentDelete(@RequestParam int recipe_num, int rcomment_num, HttpSession session) {
		
		commentService.commentDelete(recipe_num, rcomment_num);		
	}
	
	//모든 코멘트 삭제
	@RequestMapping(value="/recipeAllCommentDelete.app")
	public void recipeAllCommentDelete(@RequestParam int recipe_num, HttpSession session) {
		commentService.recipeAllCommentDelete(recipe_num);
	}
}
