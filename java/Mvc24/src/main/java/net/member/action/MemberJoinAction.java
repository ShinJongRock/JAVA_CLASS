package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.member.db.MemberDAO;
import net.member.db.MemberBean;

public class MemberJoinAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO memberdao = new MemberDAO(); // DAO �������� ���� ��ü ���� 
		MemberBean memberdata = new MemberBean(); // ���� Ŭ������ �����͸� ������ ��ü ����
		ActionForward forward = new ActionForward(); // actionforward�� ��ü�� �����ϸ� ���� ������ ��밡����.
		boolean result = false;
		
		// ���� Ŭ������ ������ ����
		try {
			memberdata.setId(request.getParameter("id"));
			memberdata.setPw(request.getParameter("pw"));
			memberdata.setEmail(request.getParameter("email"));
			memberdata.setName(request.getParameter("name"));
			memberdata.setAddr(request.getParameterValues("addr")); //�ּҸ� �迭�� ����.
			memberdata.setPin(request.getParameter("pin"));
			memberdata.setYear(request.getParameter("year"));
			memberdata.setMonth(request.getParameter("month"));
			memberdata.setDay(request.getParameter("day"));
			memberdata.setHobby(request.getParameterValues("hobby"));
			memberdata.setIntro(request.getParameter("intro"));
			
			// ��� DAO�� Insert �Լ��� memberdata�� ���� �־�� (beans Ŭ����)
			result = memberdao.memberInsert(memberdata);
			
			if(result == false) {
				System.out.println("ȸ����� �ȵ�");
				return null;
			}
			System.out.println("ȸ�� ��� �Ϸ� (�׼� Ŭ������)");
			
			forward.setRedirect(true);
			forward.setPath("./main.lg");
			return forward;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
