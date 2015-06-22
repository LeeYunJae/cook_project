package kr.co.cooks.service;

import java.util.HashMap;
import java.util.List;

import kr.co.cooks.dao.RecipeCommentDao;
import kr.co.cooks.vo.RecipeCommentVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeCommentService {
	@Autowired RecipeCommentDao commentDao ;
	
	public List<RecipeCommentVO> commentWrite(RecipeCommentVO commentVO) {		
		
		commentDao.commentWrite(commentVO);			
		
		return commentRead(commentVO.getRecipe_num(), 10);
	}
	
	public List<RecipeCommentVO> commentRead(int recipe_num, int endRow) {
		HashMap<String, Integer> hashMap = new HashMap<>();
		
		hashMap.put("recipe_num", recipe_num);
		hashMap.put("endRow", endRow);
		
		return commentDao.commentRead(hashMap);
	}
	
	public List<RecipeCommentVO> commentDelete(int recipe_num, int rcomment_num){
		commentDao.commentDelete(rcomment_num);
		
		return commentRead(recipe_num, 10);
	}
}
