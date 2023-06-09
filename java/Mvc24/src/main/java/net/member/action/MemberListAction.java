package net.member.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO memberdao = new MemberDAO(); // DAO 쿼리문을 날릴 객체 생성
		ActionForward forward = new ActionForward(); // actionforward의 객체를 생성하면 안의 변수를 사용가능함.
		
		List <String> array = new ArrayList<>();
		
		array = memberdao.memberList();
		request.setAttribute("array", array);
		
//		ArrayList<Object> memberlist = new ArrayList<>();
//		memberlist = memberdao.memberList();
//		
//		request.setAttribute("memberlist", memberlist);
//		
//		
	   	forward.setRedirect(false);
   		forward.setPath("./member/memberList.jsp");
   		return forward;
   		
	}

}
