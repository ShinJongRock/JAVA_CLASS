
package net.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.board.db.BoardDAO;
import net.board.db.BoardBean;

public class BoardModifyView implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 	ActionForward forward = new ActionForward();
		 	HttpSession session = request.getSession();
			String id = (String)session.getAttribute("id");
			
		 	request.setCharacterEncoding("UTF-8");
	   		
			BoardDAO boarddao=new BoardDAO();
		   	BoardBean boarddata=new BoardBean();
		   	
			int num=Integer.parseInt(request.getParameter("num")); // ��й�ȣ �Է�
			boolean usercheck=boarddao.isBoardWriter(id, num);
			 if(usercheck==false){
			   		response.setContentType("text/html;charset=euc-kr");
			   		PrintWriter out=response.getWriter();
			   		out.println("<script>");
			   		out.println("alert('�ۼ��ڸ� ������ �� �ֽ��ϴ�.');");
			   		out.println("location.href='./BoardList.bo';");
			   		out.println("</script>");
			   		out.close();
			   		return null;
			 }
			
		   	boarddata=boarddao.getDetail(num);
		   	
		   	if(boarddata==null){
		   		System.out.println("(����)�󼼺��� ����");
		   		return null;
		   	}
		   	System.out.println("(����)�󼼺��� ����");
		   	
		   	request.setAttribute("boarddata", boarddata);
		   	forward.setRedirect(false);
	   		forward.setPath("./board/qna_board_modify.jsp");
	   		return forward;
	 }
}