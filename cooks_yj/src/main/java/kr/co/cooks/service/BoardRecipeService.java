package kr.co.cooks.service;

import java.util.HashMap;
import java.util.List;

import kr.co.cooks.dao.BoardRecipeDao;
import kr.co.cooks.page.Page;
import kr.co.cooks.vo.BoardRecipeVO;
import kr.co.cooks.vo.RecipeCommentVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoardRecipeService {
	@Autowired BoardRecipeDao recipeDao;
	@Autowired Page page;
	
	BoardRecipeVO recipeVO;
	
	int count;	//총 글의 갯수
	List<BoardRecipeVO> recipeList;
	List<RecipeCommentVO> recipeCommentList;
	
	public HashMap<String, Object> list(String pageNum) {
		
		HashMap<String, Object> hashMap = new HashMap<>();
		
		int pageSize = 10 ;	 //한 페이지에 보여질 글의 갯수
		int pageBlock = 10 ; //한 페이지에 보여질 링크 갯수
		
		count = recipeDao.getRecipeCount();	//총 글의 갯수
		
		page.paging(Integer.parseInt(pageNum), count, pageSize, pageBlock);
		
		//글이 있으면	
		if(count>0) {		
			HashMap<String, Integer> rowHashMap = new HashMap<>();
			
			rowHashMap.put("startRow", page.getStartRow());
			rowHashMap.put("endRow", page.getEndRow());
			
			recipeList = recipeDao.getArticles(rowHashMap) ;
		}
		//글이 없으면
		else {			
			recipeList = null ;
			
		}	
		
		hashMap.put("count",  count);	//총 글의 갯수
		hashMap.put("recipeList", recipeList);	//글이 들어있는 list
		hashMap.put("pagecode", page.getsb().toString());
		
		return hashMap;
	}
	
	
	public void write(BoardRecipeVO recipeVO) {
		recipeDao.write(recipeVO);
	}
	
	public BoardRecipeVO content(int recipe_num) {
		return recipeDao.content(recipe_num);	
	}
	
	public BoardRecipeVO getUpdateRecipe(int recipe_num) {
		return recipeDao.getUpdateRecipe(recipe_num);	
	}
	
	public void update(BoardRecipeVO recipeVO) {
		recipeDao.update(recipeVO);
	}
	
	public void delete(int recipe_num){
		recipeDao.delete(recipe_num);		
	}
	
	public int getCommentCount(int recipe_num) {
		return recipeDao.getCommentCount(recipe_num);
	}
	
	public int addLike(int recipe_num){
		recipeDao.addLike(recipe_num);
		
		return getRecipeLike(recipe_num);
	}
	
	public int minusLike(int recipe_num){
		recipeDao.minusLike(recipe_num);
		
		return getRecipeLike(recipe_num);
	}
	
	public int getRecipeLike(int recipe_num) {
		return recipeDao.getRecipeLike(recipe_num);
	}
	
	public void recipeHit(int recipe_num) {
		recipeDao.recipeHit(recipe_num);
	}

}
