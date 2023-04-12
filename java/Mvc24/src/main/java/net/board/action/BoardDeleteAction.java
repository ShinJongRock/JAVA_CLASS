package net.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.board.db.*;

public class BoardDeleteAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id"); //세션에 저장된 id가 삭제 버튼으로 접근함.
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		
	   	boolean result=false;
	   	boolean usercheck=false;
	   	
//	   	int num=Integer.parseInt(request.getParameter("num")); // 비밀번호 받아오기 
	   	int num=Integer.parseInt(request.getParameter("num")); //get방식으로 넘어온 게시판 번호 받아오기
	   	BoardDAO boarddao=new BoardDAO();
	   	usercheck=boarddao.isBoardWriter(id, num);
	   	
	   	if(usercheck==false){
	   		response.setContentType("text/html;charset=euc-kr");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('해당 게시글 작성자만 삭제할 수 있습니다.');");
	   		out.println("location.href='./BoardList.bo';");
	   		out.println("</script>");
	   		out.close();
	   		return null;
	   	}
	   	
	   	result=boarddao.boardDelete(num);
	   	if(result==false){
	   		System.out.println("게시판 삭제 실패");
	   		return null;
	   	}
	   	
	   	System.out.println("게시판 삭제 성공");
	   	forward.setRedirect(true);
   		forward.setPath("./BoardList.bo");
   		return forward;
	 }
}