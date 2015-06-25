package kr.co.cooks.dao;

import java.util.HashMap;
import java.util.List;

public interface ReviewDao {

	public int totalSize() ;
	public List<?> getReviewList(HashMap<String, Object> paramMap);
}
