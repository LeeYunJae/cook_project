package kr.co.cooks.service;

import java.util.HashMap;

import kr.co.cooks.dao.UserDao;
import kr.co.cooks.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired UserDao userDao;
	UserVO userVO;
	
	public UserVO validation_Check(String email, String password) {
		
		HashMap<String, String> params = new HashMap<>();
		
		params.put("email", email);
		params.put("password", password);
		
		return userDao.existUser(params);
		
	}
	
	public void signUpUser(UserVO userVO) {
		
		userDao.signUpUser(userVO);
	}

	public void userUpdate(UserVO userVO) {
		
		userDao.userUpdate(userVO);
	}
}
