package kr.co.cooks.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.cooks.vo.RecipeCommentVO;

public interface RecipeCommentDao {
	public void commentWrite(RecipeCommentVO commentVO) ;
	public List<RecipeCommentVO> commentRead(HashMap<String, Integer> hashMap) ;
}
