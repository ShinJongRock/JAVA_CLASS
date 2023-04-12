package net.board.action;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/BoardFrontController")
public class BoardFrontController extends HttpServlet{
   protected void doProcess(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      String RequestURI = request.getRequestURI();
      String contextPath = request.getContextPath();
      String command = RequestURI.substring(contextPath.length());
      ActionFoward forward = null; // 페이지 이동방식과 URL 담는 클래스
      Action action = null; // 동적바인딩을 위한 인터페이스

      if (command.equals("/BoardList.bo")) {
         action = new BoardListAction();
         try {
            forward = action.execute(request, response);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      
      if(command.equals("/BoardWrite.bo")) {
    	  forward=new ActionFoward();
    	  forward.setRedirect(false);
    	  forward.setPath("./Model2/Mvc_board_list.jsp");
      }
   
   
   if(forward.isRedirect()) {
        response.sendRedirect(forward.getPath());
     }else {
        RequestDispatcher dispatcher= request.getRequestDispatcher(forward.getPath());
        dispatcher.forward(request, response);
     }
   
   }
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      doProcess(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      doProcess(request, response);
   }
}