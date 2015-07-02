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
	
	public String signUpEmailCheck(String signUp_email) {
		
		return userDao.signUpEmailCheck(signUp_email);
		
		
	}
	
	public UserVO validation_Check(String email, String password) {
		
		HashMap<String, String> params = new HashMap<>();
		
		params.put("email", email);
		params.put("password", password);
		
		return userDao.existUser(params);
		
	}
	
	public void signUpUser(UserVO userVO) {
		
		userDao.signUpUser(userVO);
	}
	

	public String userUpdate(UserVO userVO, String pwd) {
		
		HashMap<String, String> params = new HashMap<>();
		params.put("email", userVO.getId());
		params.put("password", pwd);
		
		if( userDao.existUser(params) != null ) {
			
			userDao.userUpdate(userVO);
			return "success";
			
		} else 
			return "fail";
			
	}
	
	
}
