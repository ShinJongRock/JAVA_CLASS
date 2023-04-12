package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberDAO memberdao = new MemberDAO(); // DAO 쿼리문을 날릴 객체 생성
		MemberBean memberdata = new MemberBean(); // 빈즈 클래스에 데이터를 삽입할 객체 생성
		ActionForward forward = new ActionForward(); // actionforward의 객체를 생성하면 안의 변수를 사용가능함.
		
		try {
		memberdata.setId(request.getParameter("id"));
		
		MemberBean member = memberdao.memberInfo(memberdata);
		
		request.setAttribute("member", member);
		
		forward.setRedirect(false);
   		forward.setPath("./member/memberInfo.jsp");
   		return forward;
		}catch(Exception e) {
			System.out.println("INFO 액션 : 회원정보 가져오기 실패");
			e.printStackTrace();
		}
		return null;
	}

}
