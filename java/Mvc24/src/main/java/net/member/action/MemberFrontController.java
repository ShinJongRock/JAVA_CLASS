package net.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberFrontController")
public class MemberFrontController extends HttpServlet implements Servlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		System.out.println("---------------------");
		System.out.println(command);
		System.out.println("--------------------");

		ActionForward forward = null;
		Action action = null;

		// �α��� ȭ��
		if(command.equals("/main.lg")) {
			forward = new ActionForward();

			forward.setRedirect(false);
			forward.setPath("./member/main.jsp");
		}
		
		// ȸ������ ��
		else if(command.equals("/joinForm.lg")) {
			forward = new ActionForward();

			forward.setRedirect(false);
			forward.setPath("./member/joinForm.jsp");
		}
		
		// ȸ������ ��ư
		else if(command.equals("/MemberJoinAction.lg")) {
			action = new MemberJoinAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// �α��� Ŭ����
		else if(command.equals("/MemberLoginAction.lg")) {
			action = new MemberLoginAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// �α��� ���� �� �����ڷ� ȸ����� ����� ��
		else if(command.equals("/MemberList.lg")) {
			action = new MemberListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// ȸ�� ������ �������� �� get ���
		else if(command.equals("/MemberInfo.lg")) {
			action = new MemberInfoAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// ȸ�� ����
		else if(command.equals("/MemberDeleteAction.lg")) {
			action = new MemberDeleteAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		
		// Action -> controller -> View
		if(forward.isRedirect()){
			response.sendRedirect(forward.getPath());
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}