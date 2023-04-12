

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
	
		
		response.setContentType("text/html");      //���ڿ� ������ type�� ������ MIME Type���� Content Type�� �����Ѵ�.
	    response.setContentType("text/html");      //
	    response.setCharacterEncoding("euc-kr");   //���� JSP�� ���޵Ǵ� ������ ������ ĳ���ͼ����� ��ȯ�� �ش�.      
	                                                 // HTML ������ �ѱ��� 
	    
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
	    
	    PrintWriter out = response.getWriter();       //���� ��Ʈ���� �ؽ�Ʈ�� ���
	      //PrintWriter  ����Ʈ���ڸ� ���� ���·� ������ ��ü�� �ٲ۴�.
	      //getWriter(); �޼ҵ�� �������� ������ ��� ��Ʈ���� ��� ���� 
	      //out.print(HTML �±�) ���·� �ۼ��Ͽ� ��Ʈ���� �ؽ�Ʈ�� ����Ѵ�.
	    
	    
	    out.write("<HTML><HEAD><TITLE>ServletTest</TITLE></HEAD>");
	    out.write("<BODY><H1>");
	    out.write(Fnum);
	    out.write(chk);
	    out.write(Snum);

	    out.write("=");
	    out.write(tmp);
	    
	    
	    
	    
	}


}
