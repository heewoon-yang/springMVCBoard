package com.freehoon.web.login.dao;

import javax.servlet.http.HttpSession;

import com.freehoon.web.user.model.UserVO;

public interface LoginDAO {
	//01_01. ȸ�� �α��� üũ
	public boolean loginCheck(UserVO userVO) throws Exception;
	//01_02. ȸ�� �α��� ����
	public UserVO getLoginInfo(String uid) throws Exception;
	//01_03. ȸ�� �α׾ƿ�
	public void logout(HttpSession session) throws Exception;
}
