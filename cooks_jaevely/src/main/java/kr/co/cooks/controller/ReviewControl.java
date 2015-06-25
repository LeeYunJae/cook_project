package kr.co.cooks.controller;

import java.util.List;

import kr.co.cooks.service.ReviewService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ReviewControl {
	
	@Autowired ReviewService reviewService;
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewControl.class);
	static final int PAGE_DEFAULT_SIZE = 5;
	
	
	@RequestMapping(value = "/reviewListView.app")
	public ModelAndView reviewListView() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("board_review/reviewList");
		return mav;
	}
	
	@RequestMapping(value = "/reviewList.app")
	public ModelAndView reviewList(@RequestParam(defaultValue = "1") int pageNum,
									@RequestParam(defaultValue = "5") int pageSize) {
		
		if(pageSize <= 0)
			pageSize = PAGE_DEFAULT_SIZE;
		
		// 끝페이지 계산하는 메서드.
		int endPageNum = reviewService.getEndPageNum(pageSize);
		
		if(pageNum <= 0 ) pageNum = 1; // 페이지번호가 0보다 작거나 같을 수 없으니까 1페이지로 셋팅.
		if(pageNum > endPageNum) pageNum = endPageNum; // 페이지번호가 끝페이지 보다 클 경우에는 끝페이지번호가 페이지번호.
		
		List<?> reviewList = reviewService.getReviewList(pageNum, pageSize);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("status", "success");
		mav.addObject("currentPageNum", pageNum);
		mav.addObject("endPageNum", endPageNum);
		mav.addObject("reviewList", reviewList);
		mav.setViewName("JSON");
		
		return mav;
	}
	

}
