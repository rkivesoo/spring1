package com.spring.mapper;

import java.util.HashMap;
import java.util.List;

import com.spring.mb2replay.board.BoardVO;



public interface BoardMapper {
	public int getListCount();
	public List<BoardVO> getBoardList(HashMap<String, Integer>hashmap);
	public BoardVO getDetail(int num);
	//public boolean boardInsert(BoardVO board);
	public int boardInsert(BoardVO board);
	
	public int boardReplyupdate(BoardVO board);
	public int boardReply(BoardVO board);
	
	//public BoardVO boardModifyForm(int num);
	//public boolean boardModify(BoardVO modifyboard);
	public int boardModify(BoardVO modifyboard);
	
	//public boolean boardDelete(int num);
	public int boardDelete(int num);
	public void setReadCountUpdate(int num);
	public int isBoardWriter(HashMap<String, String>hashmap);
}
