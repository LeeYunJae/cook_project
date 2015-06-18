package kr.co.cooks.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.cooks.vo.BoardRecipeVO;

public interface BoardRecipeDao {
	//총 글 개수 가져오기
	public int getArticleCount();
	
	//글 목록 가져오기
	public List<BoardRecipeVO> getAticles(HashMap<String, Integer> rowHashMap);

}
