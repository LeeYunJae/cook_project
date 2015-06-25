package kr.co.cooks.dao;

import java.util.Map;

import kr.co.cooks.vo.UserVO;

public interface UserDao {
	
	public UserVO existUser(Map<String,String> params);
	public void signUpUser(UserVO userVO);
	public void userUpdate(UserVO userVO);

}
