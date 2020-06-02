package com.freehoon.web.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freehoon.common.Search;
import com.freehoon.web.board.dao.BoardDAO;
import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.board.model.ReplyVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO boardDAO;

	@Override
	public List<BoardVO> getBoardList(Search search) throws Exception {
		return boardDAO.getBoardList(search);
	}
	
	@Override
	public int insertBoard(BoardVO boardVO) throws Exception {
		return boardDAO.insertBoard(boardVO);
	}

	//@Transactional
	@Override
	public BoardVO getBoardContent(int bid) throws Exception {
		
		BoardVO boardVO = new BoardVO();
		
		boardDAO.updateViewCnt(bid);
		
		boardVO = boardDAO.getBoardContent(bid);
		
//		boardVO.setBid(bid);
//		boardVO.setCate_cd("1111111111111111111111111111111111111111111111111111");
//		boardDAO.updateBoard(boardVO);
		
//		try {
//			boardVO.setBid(bid);
//			boardVO.setCate_cd("1111111111111111111111111111111111111");
//			boardDAO.updateBoard(boardVO);
//		} catch (RuntimeException e) {
//			throw new NotFoundException();
//		}
		
		return boardVO;
	}

	@Override
	public int updateBoard(BoardVO boardVO) throws Exception {
		return boardDAO.updateBoard(boardVO);
	}

	@Override
	public int deleteBoard(int bid) throws Exception {
		return boardDAO.deleteBoard(bid);
	}

	//총 게시글 개수 확인
	@Override
	public int getBoardListCnt(Search search) throws Exception {
		return boardDAO.getBoardListCnt(search);
	}

	// 댓글 리스트
	@Override
	public List<ReplyVO> getReplyList(int bid) throws Exception {
		return boardDAO.getReplyList(bid);
	}

	@Override
	public int saveReply(ReplyVO replyVO) throws Exception {
		return boardDAO.saveReply(replyVO);
	}

	@Override
	public int updateReply(ReplyVO replyVO) throws Exception {
		return boardDAO.updateReply(replyVO);
	}

	@Override
	public int deleteReply(int rid) throws Exception {
		return boardDAO.deleteReply(rid);
	}

}