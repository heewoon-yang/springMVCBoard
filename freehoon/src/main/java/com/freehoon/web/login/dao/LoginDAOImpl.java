package com.freehoon.web.login.dao;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.freehoon.web.user.model.UserVO;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public boolean loginCheck(UserVO userVO) throws Exception {
		String name = sqlSession.selectOne("com.freehoon.web.login.loginMapper.loginCheck", userVO);
		return (name == null) ? false : true;
	}

	@Override
	public UserVO getLoginInfo(String uid) throws Exception {
		return sqlSession.selectOne("com.freehoon.web.login.loginMapper.getLoginInfo", uid);
	}

	@Override
	public void logout(HttpSession session) throws Exception {
		// TODO Auto-generated method stub

	}

}
