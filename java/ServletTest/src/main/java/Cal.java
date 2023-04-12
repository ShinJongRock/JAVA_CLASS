

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cal
 */
@WebServlet("/Cal")
public class Cal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.setContentType("text/html");      //문자열 형태의 type에 지정된 MIME Type으로 Content Type을 지정한다.
	    response.setContentType("text/html");      //
	    response.setCharacterEncoding("euc-kr");   //현재 JSP로 전달되는 내용을 지정한 캐리터셋을로 변환해 준다.      
	                                                 // HTML 폼에서 한글을 
	    
	    String Fnum = request.getParameter("Fnum");
	    String Snum = request.getParameter("Snum");
	    String chk = request.getParameter("chk");
	    
	    Calc calc = new Calc(Fnum ,Snum,chk);
	    
//	    float num = 0;
//	    
//	    if(chk.equals("+"))num = Integer.parseInt(Fnum) + Integer.parseInt(Snum);
//	    if(chk.equals("-"))num = Integer.parseInt(Fnum) + Integer.parseInt(Snum);
//	    if(chk.equals("*"))num = Integer.parseInt(Fnum) + Integer.parseInt(Snum);
//	    if(chk.equals("/"))num = Integer.parseInt(Fnum) + Integer.parseInt(Snum);
//	    
	    String tmp = Float.toString(calc.oper());
	    
	    PrintWriter out = response.getWriter();       //응답 스트림에 텍스트로 기록
	      //PrintWriter  바이트문자를 문자 형태로 가지는 객체로 바꾼다.
	      //getWriter(); 메소드로 응답으로 내보낼 출력 스트팀을 얻어 낸후 
	      //out.print(HTML 태그) 형태로 작성하여 스트림에 텍스트를 기록한다.
	    
	    
	    out.write("<HTML><HEAD><TITLE>ServletTest</TITLE></HEAD>");
	    out.write("<BODY><H1>");
	    out.write(Fnum);
	    out.write(chk);
	    out.write(Snum);

	    out.write("=");
	    out.write(tmp);
	    
	    
	    
	    
	}


}
