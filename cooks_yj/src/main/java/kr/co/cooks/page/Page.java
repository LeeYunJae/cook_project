package kr.co.cooks.page;

import org.springframework.stereotype.Service;

@Service
public class Page {
	private int startRow, endRow ;
	private StringBuffer sb ;
	
	private Page() {
	}
	
	//싱글톤
	private static  Page page = new Page() ;
	
	public static Page getInstance() {		
		return page ;		
	}
		
	public void paging(int pageNum, int count, int pageSize, int pageBlock) {
		
		int totalPage = (int)Math.ceil((double)count/pageSize);
		startRow = (pageNum-1) * pageSize + 1 ;
		endRow = pageNum * pageSize ;
		
		int startPage = (int)((pageNum-1)/pageBlock) * pageBlock + 1 ;
		int endPage = startPage + pageBlock -1 ;
		
		if(endPage > totalPage) {	//
			endPage = totalPage ;
		}
		
		sb = new StringBuffer() ;
		
		if(startPage < pageBlock) {	//1~10페이지 사이일 경우
			sb.append("<img src='images/hot.gif' width='30' height='9'>");			
		}else {
			sb.append("<img src='images/hot.gif' width='30' height='9'>");
			sb.append(" onclick='location.href=\"list.daejeon?pageNum=startPage-pageBlock");
			sb.append("\"' stytle='cursor:pointer'> ");
		}
		
		sb.append("&nbsp;|");
		for(int i=startPage ; i<=endPage ;i++){
			if(i == pageNum) {
				sb.append("&nbsp;&nbsp;<b><font color='#91B7EF'>");
				sb.append(i);
				sb.append("</font></b>");
			}
			else {
				sb.append("&nbsp;&nbsp;<a href='list.daejeon?pageNum=");
				sb.append(i);
				sb.append("'>");
				sb.append(i);
				sb.append("</a>");				
			}
		}
		
		sb.append("&nbsp;|");
		if(endPage<totalPage) {	
			sb.append("<img src='images/hot.gif' width='30' height='9'>");
			sb.append(" onclick='location.href=\"list.daejeon?pageNum=startPage+pageBlock");
			sb.append("\"' style='cursor:pointer'> ");
		}else {	//페이지가 totalPage보다 작으면 TotalPage까지 보여주는게아니라 EndPage까지 보여줌
			sb.append("<img src='images/hot.gif' width='30' height='9'>");		
		}
	}
	
	public int getStartRow() {
		return startRow ;
	}
	
	public int getEndRow() {
		return endRow ;
	}
	
	public StringBuffer getsb() {
		return sb;
	}
}
