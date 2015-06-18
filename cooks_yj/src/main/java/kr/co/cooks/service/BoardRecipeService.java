package kr.co.cooks.service;

import java.util.HashMap;
import java.util.List;

import kr.co.cooks.dao.BoardRecipeDao;
import kr.co.cooks.page.Page;
import kr.co.cooks.vo.BoardRecipeVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoardRecipeService {
	@Autowired
	BoardRecipeDao recipeDao;
	BoardRecipeVO recipeVO;
	Page page;
	
	int count;	//총 글의 갯수
	List<BoardRecipeVO> recipeList;
	
	public HashMap<String, Object> list(String pageNum) {
		
		HashMap<String, Object> hashMap = new HashMap<>();
		
		int pageSize = 10 ;	 //한 페이지에 보여질 글의 갯수
		int pageBlock = 10 ; //한 페이지에 보여질 링크 갯수
		
		count = recipeDao.getArticleCount();	//총 글의 갯수
		page.paging(Integer.parseInt(pageNum), count, pageSize, pageBlock);
		
		//글이 있으면	
		if(count>0) {		
			HashMap<String, Integer> rowHashMap = new HashMap<>();
			
			rowHashMap.put("startRow", page.getStartRow());
			rowHashMap.put("endRow", page.getEndRow());
			
			recipeList = recipeDao.getAticles(rowHashMap) ;
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
	

}
