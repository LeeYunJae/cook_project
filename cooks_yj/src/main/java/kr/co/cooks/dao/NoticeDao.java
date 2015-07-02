package kr.co.cooks.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.cooks.vo.NoticeVO;

public interface NoticeDao {
	public int getNoticeArticleCount();
	public List<NoticeVO> getNoticeArticles(HashMap<String, Integer> pageing);
	public void noticeWrite(NoticeVO noticeVO);
	public void noticeHit(int no_Num);
	public NoticeVO noticeContent(int no_Num);
	public NoticeVO getNoticeUpdate(int no_Num);
	public void noticeUpdate(NoticeVO noticeVO);
	public void noticeDelete(int no_Num);
}
