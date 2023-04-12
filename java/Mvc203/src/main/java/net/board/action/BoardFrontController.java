  package net.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardFrontController
 */
@WebServlet("/BoardFrontController")
public class BoardFrontController extends HttpServlet implements Servlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String RequestURI=request.getRequestURI();// 요청이 들어온 전체 uri를 불러온다 "localhost:8080/Day5/~~~.bo"
    	String contextPath=request.getContextPath(); // 내 프로젝트까지 있는 주소만 불러온다. "localhost:8080/Day5/"~~~.bo
    	String command = RequestURI.substring(contextPath.length()); // 전체 URI에서 문자열을 contextPath에 담긴 "localhost:8080/Day5/" 를 자른 주소만 넣는다.

    	ActionForward forward = null;
    	Action action = null;
    	
		 if(command.equals("/BoardWrite.bo")){
			 forward=new ActionForward();

			 forward.setRedirect(false);
			 forward.setPath("./board/qna_board_write.jsp");

		 }else if(command.equals("/BoardReplyAction.bo")){
			 action = new BoardReplyView();
			 try{
				 forward=action.execute(request, response);
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		 }else if(command.equals("/BoardDelete.bo")){
			 forward=new ActionForward();
			 forward.setRedirect(false);
			 forward.setPath("./board/qna_board_delete.jsp");
			 
		 }else if(command.equals("/BoardModify.bo")){
			 action = new BoardModifyView();
			 try{
				 forward=action.execute(request, response);
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		 }else if(command.equals("/BoardAddAction.bo")){
			 action  = new BoardAddAction();
			 try {
				 forward=action.execute(request, response );
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		 }else if(command.equals("/BoardReplyView.bo")){
			 action = new BoardReplyAction();
			 try{
				 forward=action.execute(request, response);
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		 }else if(command.equals("/BoardModifyAction.bo")){
			 action = new BoardModifyAction();
			 try{
				 forward=action.execute(request, response);
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		 }else if(command.equals("/BoardDeleteAction.bo")){
			 action = new BoardDeleteAction();
			 try{
				 forward=action.execute(request, response);
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		 }else if(command.equals("/BoardList.bo")){
			 action = new BoardListAction(); // 객체만 생성했음. 
			 try{
				 forward = action.execute(request, response); // redirect, forward인지 값을 반환
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		 }else if(command.equals("/BoardDetailAction.bo")){
			 action = new BoardDetailAction();
			 try{
				 forward=action.execute(request, response);
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		 }

		 
		 
		 if(forward.isRedirect()){ // 센드리다이렉트 방식
			 response.sendRedirect(forward.getPath());
		 }else{ // 포워드
			 RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
			 dispatcher.forward(request, response);
		 }

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
