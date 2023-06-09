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
	
		// 로그인 액션은 빈즈에서 끌어올 값은 없을거라고 판단. 
		MemberDAO memberdao = new MemberDAO(); // DAO 쿼리문을 날릴 객체 생성
		MemberBean memberdata = new MemberBean(); // 빈즈 클래스에 데이터를 삽입할 객체 생성
		ActionForward forward = new ActionForward(); // actionforward의 객체를 생성하면 안의 변수를 사용가능함.
		
		boolean result = false;
		try {
			// main 로그인 폼에서 가져올 id와 pw 파라미터를 빈즈 클래스에 넣는다. 
			memberdata.setId(request.getParameter("mid"));
			memberdata.setPw(request.getParameter("mpw"));
			
			result = memberdao.memberLogin(memberdata);
			
			
			if(result == false) {
				System.out.println("Action : 로그인 실패");
				forward.setRedirect(false);
				forward.setPath("./member/main.jsp");
				return forward;
			}
			System.out.println("Action : 로그인 성공");
			session.setAttribute("id", memberdata.getId());
			String user = (String)session.getAttribute("id");
			
			
			// admin인지 일반 사용자인지 확인 게시판으로 이동...
 			forward.setRedirect(true);
			forward.setPath("./BoardList.bo");
			return forward;
			
			
		}catch(Exception e) {
			System.out.println("데이터 등록 실패");
			e.printStackTrace();
		}
		return null;
	}

}
