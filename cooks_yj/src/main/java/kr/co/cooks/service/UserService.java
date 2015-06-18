package kr.co.cooks.service;

import kr.co.cooks.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired UserDao userDao;
	
	public int validation_Check(String email, String password) {
		
		String pwd = "";
		int status=0;
				
		pwd = userDao.validation_Check(email);
		
		if(pwd !="") {
			if(password.equals(pwd)) {
				status = 1;
				
			} else {
				status = 2;
				
			}
		} else {
			status = 3;
			
		}
		
		return status;
	}

}
