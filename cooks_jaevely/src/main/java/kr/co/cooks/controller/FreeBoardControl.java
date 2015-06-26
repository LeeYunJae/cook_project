package kr.co.cooks.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import kr.co.cooks.service.FreeBoardService;
import kr.co.cooks.vo.FreeBoardUserVO;
import kr.co.cooks.vo.FreeBoardVO;
import kr.co.cooks.vo.RecipeBoardUserVO;
import kr.co.cooks.vo.RecipeBoardVO;
import kr.co.cooks.vo.UserVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FreeBoardControl {

	private static final Logger logger = LoggerFactory.getLogger(LoginControl.class);

	@Autowired FreeBoardService freeService ;

	FreeBoardUserVO freeUserVO;

	//글 목록(리스트)
	@RequestMapping(value="/freeList.app")
	public ModelAndView freeList(@RequestParam(defaultValue="1") String pageNum, HttpSession session) {		
		ModelAndView mav = new ModelAndView();

		HashMap<String, Object> hashMap= freeService.list(pageNum);

		mav.addObject("pageNum", pageNum);
		mav.addObject("count", hashMap.get("count"));
		mav.addObject("freeList", hashMap.get("freeList"));
		mav.addObject("pagecode", hashMap.get("pagecode"));		
		mav.setViewName("board_free/freeList");

		return mav;
	}

	//글 쓰기 폼
	@RequestMapping(value="/freeWriteForm.app")
	public ModelAndView freeWriteForm(@RequestParam String pageNum, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("pageNum", pageNum);
		mav.setViewName("board_free/freeWriteForm");

		return mav;		
	}

	//글 쓰기
	@RequestMapping(value="/freeWrite.app")
	public String freeWrite(@ModelAttribute FreeBoardVO freeVO, HttpSession session) {

		UserVO sessionVO = (UserVO)session.getAttribute("loginUser");		
		freeVO.setId(sessionVO.getId());

		freeService.write(freeVO);		

		return "redirect:/freeList.app?pageNum="+1;		
	}

	//글 읽기
	@RequestMapping(value="/freeContent.app")
	public ModelAndView freeContent(@RequestParam int free_num, @RequestParam String pageNum, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		int freeCommentCount=0 ;

		freeUserVO=freeService.content(free_num);
		freeCommentCount=freeService.getCommentCount(free_num);	//댓글 개수

		mav.addObject("freeUserVO", freeUserVO);
		mav.addObject("freeCommentCount",freeCommentCount);	
		mav.addObject("pageNum", pageNum);		

		mav.setViewName("board_free/freeContent");		

		return mav ;
	}

	//글 수정 폼
	@RequestMapping(value="/freeUpdateForm.app")
	public ModelAndView freeUpdateForm(@RequestParam int free_num, @RequestParam String pageNum, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		freeUserVO=freeService.getUpdateFree(free_num);

		mav.addObject("freeUserVO", freeUserVO);
		mav.addObject("pageNum", pageNum);

		mav.setViewName("board_free/freeUpdateForm");		

		return mav ;		
	}

	//글 수정
	@RequestMapping(value="/freeUpdate.app")
	public String freeUpdate(@ModelAttribute  FreeBoardVO freeVO, @RequestParam String pageNum) {

		freeService.update(freeVO);

		return "redirect:/freeContent.app?free_num="+freeVO.getFree_num() +"&pageNum=" + pageNum ;	
	}

	//글 삭제
	@RequestMapping(value="/freeDelete.app")
	public String freeDelete(@RequestParam int free_num) {

		freeService.delete(free_num);

		return "redirect:/freeList.app?pageNum=" + 1 ;	
	}

	//조회수 추가
	@RequestMapping(value="/freeHit.app")
	public ModelAndView freeHit(int free_num) {
		ModelAndView mav = new ModelAndView();

		freeService.freeHit(free_num);
		mav.setViewName("JSON");

		return mav ;						
	}

}
