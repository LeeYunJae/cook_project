package kr.co.cooks.dao;

import java.util.List;

import kr.co.cooks.vo.FoodFileListMapVO;
import kr.co.cooks.vo.FoodFileListVO;
import kr.co.cooks.vo.FoodVO;

public interface FoodDao {
	
	//음식 상세정보 가져오기 
	public FoodVO getFoodDetail(int f_num);
	
	//한 레스토랑의 총 음식 개수 가져오기
	public int getFoodCount(String r_num);
	
	//음식 목록 가져오기
	public List<FoodFileListMapVO> getArticles(String r_num);
	
	//음식 추가하기
	public void addFood(FoodVO foodVO);
	
	//메인 사진 추가
	public void addFoodFileUpload(FoodFileListVO foodFileVO);

}