package net.board.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardDAO;

// command 클래스
public class BoardListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDAO boarddao=new BoardDAO(); // DB객체 생성
		List<?> boardlist=new ArrayList<>(); // 리스트 생성 (여러개의 글을 출력할 리스트)

		int page=1; // 페이징 최소 
		int limit=10; // 페이징 최대

		if(request.getParameter("page")!=null){ // 1.2.3.4.5 문자열 url ?page=2 2 '2'
			page=Integer.parseInt(request.getParameter("page")); // '2' -> 2
		}

		int listcount=boarddao.getListCount(); // DAO와 디비 접속 총 리스트 수를 받아옴.
		boardlist = boarddao.getBoardList(page,limit); // DAO와 디비 접속 리스트를 받아옴.

		//총 페이지 수.
		int maxpage=(int)((double)listcount/limit+0.95); //0.95를 더해서 올림 처리.
		//현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
		int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
		//현재 페이지에 보여줄 마지막 페이지 수.(10, 20, 30 등...)
		int endpage = maxpage;

		if (endpage>startpage+10-1) endpage=startpage+10-1;

		request.setAttribute("page", page);		  //현재 페이지 수.
		request.setAttribute("maxpage", maxpage); //최대 페이지 수.
		request.setAttribute("startpage", startpage); //현재 페이지에 표시할 첫 페이지 수.
		request.setAttribute("endpage", endpage);     //현재 페이지에 표시할 끝 페이지 수.
		request.setAttribute("listcount",listcount); //글 수.
		request.setAttribute("boardlist", boardlist); // 글 출력 

		ActionForward forward= new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./board/qna_board_list.jsp");
		return forward;
	}
}



