package kr.co.cooks.dao;

import java.util.List;

import kr.co.cooks.vo.FoodFileListVO;
import kr.co.cooks.vo.FoodMainFileListMapVO;
import kr.co.cooks.vo.FoodMainFileListVO;
import kr.co.cooks.vo.FoodVO;
import kr.co.cooks.vo.RestaurantVO;

public interface FoodDao {

	//음식 목록 가져오기
	public List<FoodMainFileListMapVO> getArticles(String r_num);

	//음식 상세정보 가져오기 
	public FoodMainFileListMapVO getFoodDetail(int f_num);

	//음식 사진들 가져오기
	public List<FoodFileListVO> getFoodFiles(int f_num) ;
	
	//레스토랑 정보 가져오기
	public RestaurantVO getResInfo(String r_num);	

	//한 레스토랑의 총 음식 개수 가져오기
	public int getFoodCount(String r_num);

	//음식 추가하기
	public void addFood(FoodVO foodVO);

	//메인 사진 추가
	public void addFoodMainFile(FoodMainFileListVO foodMainFileVO);

	//음식 사진들 추가
	public void addFoodFile(FoodFileListVO foodFileVO);

	//음식 삭제
	public void deleteFood(int f_num);
	
	//메인 사진 삭제
	public void deleteFoodMainFile(int f_num);
	
	//메인 사진 삭제
	public void deleteFoodFiles(int f_num);
	


}
