package kr.co.cooks.service;

import java.util.HashMap;
import java.util.List;

import kr.co.cooks.dao.FreeBoardDao;
import kr.co.cooks.vo.FreeBoardUserVO;
import kr.co.cooks.vo.FreeBoardVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FreeBoardService {
	@Autowired FreeBoardDao freeDao;
	
	int count;	//총 글의 갯수
	List<FreeBoardVO> freeList;

	public HashMap<String, Object> list(String pageNum) {

		HashMap<String, Object> hashMap = new HashMap<>();

		int pageSize = 10 ;	 //한 페이지에 보여질 글의 갯수
		int pageBlock = 10 ; //한 페이지에 보여질 링크 갯수

		count = freeDao.getfreeCount();	//총 글의 갯수

		//page.paging(Integer.parseInt(pageNum), count, pageSize, pageBlock);

		//글이 있으면	
		if(count>0) {		
			HashMap<String, Integer> rowHashMap = new HashMap<>();

//			rowHashMap.put("startRow", page.getStartRow());
//			rowHashMap.put("endRow", page.getEndRow());

			rowHashMap.put("startRow", 1);
			rowHashMap.put("endRow", 10);

			freeList = freeDao.getArticles(rowHashMap) ;
		}
		//글이 없으면
		else {			
			freeList = null ;
		}	

		hashMap.put("count",  count);	//총 글의 갯수
		hashMap.put("freeList", freeList);	//글이 들어있는 list
		//hashMap.put("pagecode", page.getsb().toString());

		return hashMap;
	}
	
	public void write(FreeBoardVO freeVO) {		
		freeDao.write(freeVO);
	}	
	
	public FreeBoardUserVO content(int free_num) {
		return freeDao.content(free_num);
	}
	
	public int getCommentCount(int free_num) {
		return freeDao.getCommentCount(free_num);
	}
	
	public FreeBoardUserVO getUpdateFree(int free_num) {
		return freeDao.getUpdateFree(free_num);	
	}
	
	public void update(FreeBoardVO freeVO) {
		freeDao.update(freeVO);
	}
	
	@Transactional
	public void delete(int free_num){
		freeDao.freeAllCommentDelete(free_num);		
		freeDao.delete(free_num);		
	}
	
	public void freeHit(int free_num) {
		freeDao.freeHit(free_num);
	}
}
