package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
	
		// �α��� �׼��� ����� ����� ���� �����Ŷ�� �Ǵ�. 
		MemberDAO memberdao = new MemberDAO(); // DAO �������� ���� ��ü ����
		MemberBean memberdata = new MemberBean(); // ���� Ŭ������ �����͸� ������ ��ü ����
		ActionForward forward = new ActionForward(); // actionforward�� ��ü�� �����ϸ� ���� ������ ��밡����.
		
		boolean result;
		try {
			// main �α��� ������ ������ id�� pw �Ķ���͸� ���� Ŭ������ �ִ´�. 
			memberdata.setId(request.getParameter("mid"));
			memberdata.setPw(request.getParameter("mpw"));
			
			result = memberdao.memberLogin(memberdata);
			
			
			// admin���� �Ϲ� �α������� Ȯ���� �Խ������� �̵�
		
			if(result==false) {
				forward.setRedirect(true);
				forward.setPath("./main.jsp");
				
			}
				
			
				session.setAttribute("id", memberdata.getId());
				forward.setRedirect(false);
				forward.setPath("/BoardList.bo");
				return forward;
				
				
			
			
		}catch(Exception e) {
			System.out.println("������ ��� ����");
			e.printStackTrace();
		}
		return null;
	}

}
