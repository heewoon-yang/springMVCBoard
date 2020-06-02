package com.freehoon.web.login.dao;

import javax.servlet.http.HttpSession;

import com.freehoon.web.user.model.UserVO;

public interface LoginDAO {
	//01_01. 회원 로그인 체크
	public boolean loginCheck(UserVO userVO) throws Exception;
	//01_02. 회원 로그인 정보
	public UserVO getLoginInfo(String uid) throws Exception;
	//01_03. 회원 로그아웃
	public void logout(HttpSession session) throws Exception;
}
