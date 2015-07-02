package kr.co.cooks.dao;

import java.util.List;
import java.util.Map;

import kr.co.cooks.vo.ReviewFileListVO;
import kr.co.cooks.vo.ReviewFileVO;
import kr.co.cooks.vo.ReviewVO;

public interface ReviewDao {

	public int totalSize() ;
	public List<?> getReviewList(Map<String, Object> paramMap);
	public void insertReview(ReviewVO reviewVO);
	public void insertFileUpload(ReviewFileVO reviewFileVO);
	public ReviewFileListVO contentReview(int re_Num);
	public void deleteReview(int re_Num);
	public void deleteReviewPhoto(int re_Num);
	public ReviewVO getUpdateReviewForm(int re_Num);
	public void updateReview(ReviewVO reviewVO);
	public void updateFileUpload(ReviewFileVO reviewFileVO);
}
