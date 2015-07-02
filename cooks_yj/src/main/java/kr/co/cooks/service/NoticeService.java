package kr.co.cooks.service;

import java.util.HashMap;
import java.util.List;

import kr.co.cooks.dao.NoticeDao;
import kr.co.cooks.vo.NoticeVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Service
public class NoticeService {
	@Autowired NoticeDao noticeDao;
	NoticeVO noticeVO;
	ModelAndView mav = new ModelAndView();
	
	List<NoticeVO> noticelist;
	
	public HashMap<String, Object> NoticeList(int pageNum){
		
		HashMap<String, Object> hm = new HashMap<>();
		int count=0;
		int pageSize=10;
		int pageBlock=10;
		
		if(pageNum <= 0){
			pageNum=1;
		}
		
		count=noticeDao.getNoticeArticleCount();
		
		if(count>0){
			HashMap<String, Integer> pageing = new HashMap<>();
			pageing.put("startRow", 1);
			pageing.put("endRow", 10);
			noticelist=noticeDao.getNoticeArticles(pageing);
		} else {
			noticelist=null;
		}
		
		hm.put("count", count);
		hm.put("noticelist", noticelist);
		
		return hm;
	}
	
	public void noticeWrite(NoticeVO noticeVO){
		noticeDao.noticeWrite(noticeVO);
	}
	
	
	public void noticeHit(int no_Num){
		noticeDao.noticeHit(no_Num);
	}
	
	public NoticeVO noticeContent(int no_Num, NoticeVO noticeVO){
		return noticeDao.noticeContent(no_Num);
	}
	
	public NoticeVO getNoticeUpdate(int no_Num){
		return noticeDao.getNoticeUpdate(no_Num);
	}
	
	public void noticeUpdate(NoticeVO noticeVO){
		noticeDao.noticeUpdate(noticeVO);
	}
	
	public void noticeDelete(int no_Num){
		noticeDao.noticeDelete(no_Num);
	}
}
