package kr.co.cooks.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.cooks.service.ReviewService;
import kr.co.cooks.vo.ReviewFileListVO;
import kr.co.cooks.vo.ReviewVO;
import kr.co.cooks.vo.UserVO;

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
public class ReviewControl {
	private static final Logger logger = LoggerFactory.getLogger(ReviewControl.class);

	@Autowired ReviewService reviewService;
	UserVO userVO;
	
	static final int PAGE_DEFAULT_SIZE = 5;
	
	@RequestMapping(value = "/reviewListView.app")
	public ModelAndView reviewListView(@RequestParam(defaultValue = "1") int pageNum) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("pageNum", pageNum);
		mav.setViewName("board_review/reviewList");
		return mav;
	}
	
	@RequestMapping(value = "/reviewList.app")
	public ModelAndView reviewList(@RequestParam(defaultValue = "1") int pageNum,
									@RequestParam(defaultValue = "5") int pageSize,
									HttpSession session) {
		
		if(pageSize <= 0)
			pageSize = PAGE_DEFAULT_SIZE;
		
		// 끝페이지 계산하는 메서드.
		int endPageNum = reviewService.getEndPageNum(pageSize);
		
		if(pageNum <= 0 ) pageNum = 1; // 페이지번호가 0보다 작거나 같을 수 없으니까 1페이지로 셋팅.
		if(pageNum > endPageNum) pageNum = endPageNum; // 페이지번호가 끝페이지 보다 클 경우에는 끝페이지번호가 페이지번호.
		
		List<?> reviewList = reviewService.getReviewList(pageNum, pageSize);
		
		ModelAndView mav = new ModelAndView();
		
		// session에 "loginUser"가 있으면 loginUser_Id를 담아서 보냄. => 로그인 한 사람만 글 쓰게 하기 위해.
		if(session.getAttribute("loginUser") != null) {
			userVO = (UserVO)session.getAttribute("loginUser");
			mav.addObject("loginUser_Id", userVO.getId());
		}
		
		mav.addObject("status", "success");
		mav.addObject("currentPageNum", pageNum);
		mav.addObject("endPageNum", endPageNum);
		mav.addObject("reviewList", reviewList);
		mav.setViewName("JSON");
		
		return mav;
	}
	
	@RequestMapping(value = "/writeReview.app", method = RequestMethod.POST)
	public ModelAndView insertReview(@ModelAttribute ReviewVO reviewVO, HttpSession session, MultipartHttpServletRequest multipartReq) {

		//System.out.println(multipartReq.getParameter("re_Content"));
		System.out.println("멀티파트" +multipartReq.getFile("re_Fname").getOriginalFilename());
		userVO = (UserVO)session.getAttribute("loginUser");
		reviewVO.setId(userVO.getId()); // session 의 id를 가져와서 reviewVO에 set 해줌.

		reviewService.insertReview(reviewVO, multipartReq);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("status", "success");
		mav.setViewName("redirect:/reviewListView.app");

		return mav;
	}
	
	@RequestMapping(value ="/contentReview.app")
	public ModelAndView contentReview(@RequestParam int re_Num, int pageNum, HttpSession session) {
		
		userVO = (UserVO)session.getAttribute("loginUser");

		ReviewFileListVO reviewFileListVO = reviewService.contentReview(re_Num);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("pageNum", pageNum);
		mav.addObject("contentReview", reviewFileListVO);
		mav.setViewName("board_review/reviewContent");
		
		return mav;
		
	}
	
	@RequestMapping(value = "/deleteReview.app", method = RequestMethod.GET)
	public ModelAndView deleteReview(@RequestParam int re_Num, int pageNum, HttpSession session)  {
		
		//userVO = (UserVO)session.getAttribute("loginUser");
		
		System.out.println("re_Num번 삭제요청 : "+re_Num);
		
		ModelAndView mav = new ModelAndView();
		reviewService.deleteReview(re_Num);
		
		mav.setViewName("redirect:/reviewListView.app?pageNum="+pageNum);
		return mav;
		
	}
	
	@RequestMapping(value = "updateReviewForm.app")
	public ModelAndView getUpdateReview(@RequestParam int re_Num, int pageNum) {
		ModelAndView mav = new ModelAndView();
		
		ReviewVO review = reviewService.getUpdateReviewForm(re_Num);
		
		mav.addObject("review", review);
		mav.addObject("pageNum", pageNum);
		mav.setViewName("board_review/reviewUpdateForm");
		return mav;
	}
	
	@RequestMapping(value = "/updateReview.app", method = RequestMethod.POST)
	public ModelAndView updateReview(@ModelAttribute ReviewVO reviewVO, int pageNum,
									MultipartHttpServletRequest multipartReq) {

		int re_Num = reviewVO.getRe_Num();
		
		//System.out.println("멀티파트" +multipartReq.getFile("re_Fname").getOriginalFilename());

		reviewService.updateReview(reviewVO, multipartReq);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/contentReview.app?re_Num="+re_Num+"&pageNum="+pageNum);

		return mav;
	}
	
	

}
