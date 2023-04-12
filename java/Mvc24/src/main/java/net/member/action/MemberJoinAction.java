package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.member.db.MemberDAO;
import net.member.db.MemberBean;

public class MemberJoinAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO memberdao = new MemberDAO(); // DAO 쿼리문을 날릴 객체 생성 
		MemberBean memberdata = new MemberBean(); // 빈즈 클래스에 데이터를 삽입할 객체 생성
		ActionForward forward = new ActionForward(); // actionforward의 객체를 생성하면 안의 변수를 사용가능함.
		boolean result = false;
		
		// 빈즈 클래스에 데이터 삽입
		try {
			memberdata.setId(request.getParameter("id"));
			memberdata.setPw(request.getParameter("pw"));
			memberdata.setEmail(request.getParameter("email"));
			memberdata.setName(request.getParameter("name"));
			memberdata.setAddr(request.getParameterValues("addr")); //주소를 배열로 받음.
			memberdata.setPin(request.getParameter("pin"));
			memberdata.setYear(request.getParameter("year"));
			memberdata.setMonth(request.getParameter("month"));
			memberdata.setDay(request.getParameter("day"));
			memberdata.setHobby(request.getParameterValues("hobby"));
			memberdata.setIntro(request.getParameter("intro"));
			
			// 멤버 DAO의 Insert 함수에 memberdata의 값을 넣어라 (beans 클래스)
			result = memberdao.memberInsert(memberdata);
			
			if(result == false) {
				System.out.println("회원등록 안됨");
				return null;
			}
			System.out.println("회원 등록 완료 (액션 클래스임)");
			
			forward.setRedirect(true);
			forward.setPath("./main.lg");
			return forward;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
