package com.freehoon.web.login.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.freehoon.web.login.dao.LoginDAO;
import com.freehoon.web.user.model.UserVO;

@Service
public class LoginServiceImpl implements LoginService {

	@Inject
	private LoginDAO loginDAO;
	
	@Override
	public boolean loginCheck(UserVO userVO, HttpSession session) throws Exception {
		boolean result = loginDAO.loginCheck(userVO);
		if(result) {
			String uid = userVO.getUid();
			userVO = loginDAO.getLoginInfo(uid);
			
			session.setAttribute("uid", userVO.getUid());
			session.setAttribute("name", userVO.getName());
		}
		return result;
	}

	@Override
	public UserVO getLoginInfo(String uid) throws Exception {
		return loginDAO.getLoginInfo(uid);
	}

	@Override
	public void logout(HttpSession session) throws Exception {
		//세션 변수 개별 삭제
		//session.removeAttribute("uid");
		//세션 정보를 초기화 시킴
		session.invalidate();
	}

}
