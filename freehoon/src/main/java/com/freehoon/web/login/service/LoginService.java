package com.freehoon.web.login.service;

import javax.servlet.http.HttpSession;

import com.freehoon.web.user.model.UserVO;

public interface LoginService {
	public boolean loginCheck(UserVO userVO, HttpSession session) throws Exception;
	
	public UserVO getLoginInfo(String uid) throws Exception;
	
	public void logout(HttpSession session) throws Exception;
}
