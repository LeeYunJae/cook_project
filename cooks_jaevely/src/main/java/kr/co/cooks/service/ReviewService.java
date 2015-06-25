package kr.co.cooks.service;

import java.util.HashMap;
import java.util.List;

import kr.co.cooks.dao.ReviewDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReviewService {
	
	@Autowired ReviewDao reviewDao ;
	
	public int getEndPageNum(int pageSize) {
		
		int totalSize = reviewDao.totalSize();
		int endPageNum = totalSize / pageSize;
		
		if( (totalSize % pageSize) > 0 )
			endPageNum++;
		
		return endPageNum;
	}
	
	public List<?> getReviewList(int pageNum, int pageSize) {
		
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("startRow", ((pageNum-1) * pageSize) );
		paramMap.put("pageSize", pageSize);
		
		return reviewDao.getReviewList(paramMap);
		
	}

}
