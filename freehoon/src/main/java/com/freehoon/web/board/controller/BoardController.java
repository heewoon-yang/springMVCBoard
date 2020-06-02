package com.freehoon.web.board.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.freehoon.common.Pagination;
import com.freehoon.common.Search;
import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.board.model.ReplyVO;
import com.freehoon.web.board.service.BoardService;
import com.freehoon.web.login.controller.LoginController;

@Controller
@RequestMapping(value="/board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class); 
	
	@Inject
	private BoardService boardService;
	
	//게시판 리스트 조회
	@RequestMapping(value="getBoardList", method=RequestMethod.GET)
	public String getBoardList(
			 Model model
			,@RequestParam(required = false, defaultValue = "1") int page
			,@RequestParam(required = false, defaultValue = "1") int range
			,@RequestParam(required = false, defaultValue = "title") String searchType
			,@RequestParam(required = false) String keyword
			,@ModelAttribute("search") Search search
		) throws Exception {
		
		
		logger.info("=================================");
		logger.info("model : "+model);
		logger.info("page : "+page);
		logger.info("range : "+range);
		logger.info("searchType : "+searchType);
		logger.info("keyword : "+keyword);
		logger.info("=================================");
		
		//Search search = new Search();
		model.addAttribute("search",search);
		search.setSearchType(searchType);
		search.setKeyword(keyword);
		
		
		//전체 게시글 개수
		int listCnt = boardService.getBoardListCnt(search);
		
		//Pagination 객체생성
		//Pagination pagination = new Pagination();
		//pagination.pageInfo(page, range, listCnt);
		
//		search.pageInfo(page, range, listCnt);
//		search.pageInfo(page, range, listCnt);
		
		//검색
		search.pageInfo(page, range, listCnt);
		
		//model.addAttribute("pagination", pagination);
		model.addAttribute("pagination", search);
		//model.addAttribute("boardList", boardService.getBoardList(pagination));
		model.addAttribute("boardList", boardService.getBoardList(search));
		
		//스프링 버전확인---S
		String springVersion = org.springframework.core.SpringVersion.getVersion();
		System.out.println("스프링 프레임워크 버전 : " + springVersion);		
		//-------------E
		
		return "board/index";
	}
	
	@RequestMapping("/boardForm")
	public String boardForm(Model model) {
		BoardVO boardVO = new BoardVO();
		model.addAttribute("boardVO", boardVO);
		return "board/boardForm"; 
	}
	
	@RequestMapping(value = "/saveBoard", method = RequestMethod.POST)
	public String saveBoard(	@ModelAttribute("BoardVO") BoardVO boardVO, 
								@RequestParam("mode") String mode,
								RedirectAttributes rttr) throws Exception{
		if(mode.equals("edit")) {
			boardService.updateBoard(boardVO);
		}else {
			boardService.insertBoard(boardVO);
		}
		
		return "redirect:/board/getBoardList";
	}
	
	@RequestMapping(value = "/getBoardContent", method = RequestMethod.GET)
	public String getBoardContent(	Model model, 
									@RequestParam("bid") int bid) throws Exception{
		model.addAttribute("boardContent", boardService.getBoardContent(bid));
		model.addAttribute("replyVO", new ReplyVO());//댓글
		return "board/boardContent";
	}
	
	@RequestMapping(value = "editForm", method = RequestMethod.GET)
	public String editForm(	@RequestParam("bid") int bid, 
							@RequestParam("mode") String mode, 
							Model model) throws Exception{
		model.addAttribute("boardContent", boardService.getBoardContent(bid));
		model.addAttribute("mode", mode);
		model.addAttribute("boardVO", new BoardVO());
		
		return "board/boardForm";
	}
	
	@RequestMapping(value = "/deleteBoard", method = RequestMethod.GET)
	public String deleteBoard(RedirectAttributes rttr, @RequestParam("bid") int bid) throws Exception{
		boardService.deleteBoard(bid);
		return "redirect:getBoardList";
	}
	
	/*
	 * @ExceptionHandler(RuntimeException.class) public String
	 * exceptionHandler(Model model, Exception e ) {
	 * //logger.info("exception : "+e.getMessage());
	 * model.addAttribute("exception",e); return "error/exception"; }
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
