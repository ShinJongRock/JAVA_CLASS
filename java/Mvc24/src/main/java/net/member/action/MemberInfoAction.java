package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberDAO memberdao = new MemberDAO(); // DAO �������� ���� ��ü ����
		MemberBean memberdata = new MemberBean(); // ���� Ŭ������ �����͸� ������ ��ü ����
		ActionForward forward = new ActionForward(); // actionforward�� ��ü�� �����ϸ� ���� ������ ��밡����.
		
		try {
		memberdata.setId(request.getParameter("id"));
		
		MemberBean member = memberdao.memberInfo(memberdata);
		
		request.setAttribute("member", member);
		
		forward.setRedirect(false);
   		forward.setPath("./member/memberInfo.jsp");
   		return forward;
		}catch(Exception e) {
			System.out.println("INFO �׼� : ȸ������ �������� ����");
			e.printStackTrace();
		}
		return null;
	}

}
