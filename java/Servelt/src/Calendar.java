import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Calendar;

public class Calendar extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException {
      response.setContentType("text/html");      //문자열 형태의 type에 지정된 MIME Type으로 Content Type을 지정한다.
      response.setContentType("text/html");      //
      response.setCharacterEncoding("euc-kr");   //현재 JSP로 전달되는 내용을 지정한 캐리터셋을로 변환해 준다.      
                                                 // HTML 폼에서 한글을 입력할 때 정상적으로 처리하려면 반드시 필요하다.
      
      Calendar c = Calendar.getInstance(); 
      //Calendar는 국가별 시간대별 시간을 제공 (년,월,일,시간,분,날짜)
      //Calendar 사용하기 위해서는  Calendar.getInstance(); 사용해야 한다.
      
      int year = c.get(Calendar.YEAR); //년
      int month = c.get(Calendar.MONTH); //달
      int dayofweek = c.get(Calendar.DAY_OF_WEEK); 
      int hour = c.get(Calendar.HOUR_OF_DAY);
      int minute = c.get(Calendar.MINUTE);
      int second = c.get(Calendar.SECOND);
      
      PrintWriter out = response.getWriter();       //응답 스트림에 텍스트로 기록
      //PrintWriter  바이트문자를 문자 형태로 가지는 객체로 바꾼다.
      //getWriter(); 메소드로 응답으로 내보낼 출력 스트팀을 얻어 낸후 
      //out.print(HTML 태그) 형태로 작성하여 스트림에 텍스트를 기록한다.


      out.write("<HTML><HEAD><TITLE>ServletTest</TITLE></HEAD>");
      out.write("<BODY><H1>");
      out.write("Current time"); //현재시간
      out.write(Integer.toString(hour));
      out.write("time"); //시
      out.write(Integer.toString(minute));
      out.write("minute"); //분
      out.write(Integer.toString(second));
      out.write("second");//초
      out.write("</H1></BODY></HTML>");
      out.close();
   }
}