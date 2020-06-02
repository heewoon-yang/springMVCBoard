package com.freehoon.web.board.service;

import java.util.List;

import com.freehoon.common.Search;
import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.board.model.ReplyVO;

public interface BoardService {
	public List<BoardVO> getBoardList(Search search) throws Exception;
	
	public int insertBoard(BoardVO boardVO) throws Exception;
	
	public BoardVO getBoardContent(int bid) throws Exception;

	public int updateBoard(BoardVO boardVO) throws Exception;

	public int deleteBoard(int bid) throws Exception;
	//총 게시글 개수 확인
	public int getBoardListCnt(Search search) throws Exception;
	
	// 댓글 리스트
	public List<ReplyVO> getReplyList(int bid) throws Exception;
	public int saveReply(ReplyVO replyVO) throws Exception;
	public int updateReply(ReplyVO replyVO) throws Exception;
	public int deleteReply(int rid) throws Exception;
}
