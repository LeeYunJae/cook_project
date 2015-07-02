package kr.co.cooks.dao;

import java.util.List;

import kr.co.cooks.vo.RestaurantFileListVO;
import kr.co.cooks.vo.RestaurantFileVO;
import kr.co.cooks.vo.RestaurantVO;

public interface RestaurantDao {
	public List<RestaurantFileListVO> getRestaurant();
	public void addRestaurant(RestaurantVO restaurantVO);
	public void addFileUpload(RestaurantFileVO restaurantFileVO);

}
