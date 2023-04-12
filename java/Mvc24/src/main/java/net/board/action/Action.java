package net.board.action;

import javax.servlet.http.*;

public interface Action {
	
	// 추상메서드
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
