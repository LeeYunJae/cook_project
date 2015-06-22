package kr.co.cooks.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.cooks.vo.BoardRecipeVO;
import kr.co.cooks.vo.RecipeCommentVO;

public interface BoardRecipeDao {
	
	//총 글 개수 가져오기
	public int getRecipeCount();
	
	//글 목록 가져오기
	public List<BoardRecipeVO> getArticles(HashMap<String, Integer> rowHashMap);
	
	//글 쓰기	
	public void write(BoardRecipeVO recipeVO);
	
	//글읽기
	public BoardRecipeVO content(int recipe_num);
	
	//수정 폼 가져오기
	public BoardRecipeVO getUpdateRecipe(int recipe_num); 
	
	//글 수정하기
	public void update(BoardRecipeVO recipeVO);
	
	//글 삭제하기
	public void delete(int recipe_num);
	
	//댓글 개수 가져오기
	public int getCommentCount(int recipe_num) ;
	
	//댓글 리스트 가져오기
	public List<RecipeCommentVO> getCommentArticles(HashMap<String, Integer> rowHashMap);
	
	//좋아요 추가
	public void addLike(int recipe_num);
	
	//좋아요 취소
	public void minusLike(int recipe_num);
	
	//좋아요 수
	public int getRecipeLike(int recipe_num);
	
	//조회수 
	public void recipeHit(int recipe_num);

}
