package kr.co.cooks.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.cooks.service.BoardRecipeService;
import kr.co.cooks.vo.BoardRecipeVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardRecipeController {
	@Autowired BoardRecipeService recipeService ;
	BoardRecipeVO recipeVO;	
	
	//임시 => 글 목록(리스트)로 가는 페이지
	@RequestMapping(value = "/recipePre.app")
	public ModelAndView mainForm(HttpServletRequest req) {		
		ModelAndView mav = new ModelAndView();
		HttpSession session;
		
		String id = "vips";
		session=req.getSession();
		session.setAttribute("id", id);
		
		mav.setViewName("board_recipe/recipeList_pre");
		
		return mav;
	}
	
	//글 목록(리스트)
	@RequestMapping(value="/recipeList.app")
	public ModelAndView recipeList(@RequestParam String pageNum) {		
		ModelAndView mav = new ModelAndView();
		
		HashMap<String, Object> hashMap= recipeService.list(pageNum);
		
		mav.addObject("pageNum", pageNum);
		mav.addObject("count", hashMap.get("count"));
		mav.addObject("recipeList", hashMap.get("recipeList"));
		mav.addObject("pagecode", hashMap.get("pagecode"));		
		mav.setViewName("board_recipe/recipeList");
		
		return mav;
	}
	
	//글 쓰기 폼
	@RequestMapping(value="/recipeWriteForm.app")
	public ModelAndView recipeWriteForm(@RequestParam String pageNum, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("pageNum", pageNum);
		mav.setViewName("board_recipe/recipeWriteForm");
		
		return mav;		
	}
	
	//글 쓰기
	@RequestMapping(value="/recipeWrite.app")
	public String recipeWrite(@ModelAttribute BoardRecipeVO recipeVO, HttpSession session) {
		recipeVO.setId((String)session.getAttribute("id"));
		
		recipeService.write(recipeVO);		
		
		return "redirect:/recipeList.app?pageNum="+1;		
	}
	
	//글 읽기
	@RequestMapping(value="/recipeContent.app")
	public ModelAndView recipeContent(@RequestParam int recipe_num, @RequestParam String pageNum) {
		ModelAndView mav = new ModelAndView();
		int recipeCommentCount=0 ;
		
		recipeVO=recipeService.content(recipe_num);
		recipeCommentCount=recipeService.getCommentCount(recipe_num);	//댓글 개수
				
		mav.addObject("recipeVO", recipeVO);
		mav.addObject("pageNum", pageNum);
		mav.addObject("recipeCommentCount",recipeCommentCount);	
		
		mav.setViewName("board_recipe/recipeContent");		
		
		return mav ;
	}
	
	//글 수정 폼
	@RequestMapping(value="/recipeUpdateForm.app")
	public ModelAndView recipeUpdateForm(@RequestParam int recipe_num, @RequestParam String pageNum) {
		ModelAndView mav = new ModelAndView();
		
		recipeVO=recipeService.getUpdateRecipe(recipe_num);
		
		mav.addObject("recipeVO", recipeVO);
		mav.addObject("pageNum", pageNum);
		
		mav.setViewName("board_recipe/recipeUpdateForm");		
		
		return mav ;		
	}
	
	//글 수정
	@RequestMapping(value="/recipeUpdate.app")
	public String recipeUpdate(@ModelAttribute BoardRecipeVO recipeVO, @RequestParam String pageNum) {
		
		recipeService.update(recipeVO);
		
		return "redirect:/recipeContent.app?recipe_num="+recipeVO.getRecipe_num() +"&pageNum=" + pageNum ;	
	}
	
	//글 삭제
	@RequestMapping(value="/recipeDelete.app")
	public String recipeDelete(@RequestParam int recipe_num, @RequestParam String pageNum) {
		
		recipeService.delete(recipe_num);
		
		return "redirect:/recipeList.app?pageNum=" + pageNum ;	
	}
	
	//좋아요
	@RequestMapping(value="/recipeLike.app")
	public ModelAndView recipeLike(int recipe_num) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("recipe_like", recipeService.addLike(recipe_num));
		mav.setViewName("JSON");
		
		return mav ; 		
	}

	//좋아요 취소
	@RequestMapping(value="/recipeDislike.app")
	public ModelAndView recipeDislike(int recipe_num) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recipe_like", recipeService.minusLike(recipe_num));
		mav.setViewName("JSON");

		return mav ; 		
	}

	//좋아요 수 가져오기
	@RequestMapping(value="/getRecipeLike.app")
	public ModelAndView getRecipeLike(int recipe_num) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("recipe_like", recipeService.getRecipeLike(recipe_num));
		mav.setViewName("JSON");
		
		return mav ; 		
	}
	
	//조회수 추가
	@RequestMapping(value="/recipeHit.app")
	public ModelAndView recipeHit(int recipe_num) {
		ModelAndView mav = new ModelAndView();
		
		recipeService.recipeHit(recipe_num);
		mav.setViewName("JSON");
		
		return mav ; 	
						
	}

}
