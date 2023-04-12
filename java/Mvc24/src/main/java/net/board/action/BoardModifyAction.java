package net.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.board.db.*;

 public class BoardModifyAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 
		 HttpSession session = request.getSession();
		 String id = (String)session.getAttribute("id"); //세션에 저장된 id가 삭제 버튼으로 접근함.
		 request.setCharacterEncoding("UTF-8");
		 ActionForward forward = new ActionForward();
		 
		 boolean result = false;
		 
		 int num=Integer.parseInt(request.getParameter("BOARD_NUM"));
		 
		 BoardDAO boarddao=new BoardDAO();
		 BoardBean boarddata=new BoardBean();
		 
//		 boolean usercheck=boarddao.isBoardWriter(id, num);
//		 if(usercheck==false){
//		   		response.setContentType("text/html;charset=euc-kr");
//		   		PrintWriter out=response.getWriter();
//		   		out.println("<script>");
//		   		out.println("alert('작성자만 수정할 수 있습니다.');");
//		   		out.println("location.href='./BoardList.bo';");
//		   		out.println("</script>");
//		   		out.close();
//		   		return null;
//		 }
		 
		 try{
			 boarddata.setBOARD_NUM(num);
			 boarddata.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
			 boarddata.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
			 
			 result = boarddao.boardModify(boarddata);
			 if(result==false){
		   		System.out.println("게시판 수정 실패");
		   		return null;
		   	 }
		   	 System.out.println("게시판 수정 완료");
		   	 
		   	 forward.setRedirect(true);
		   	 forward.setPath("./BoardDetailAction.bo?num="+boarddata.getBOARD_NUM());
		   	 return forward;
	   	 }catch(Exception ex){
	   			ex.printStackTrace();	 
		 }
		 
		 return null;
	 }
}