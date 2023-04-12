import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Calendar;

public class Calendar extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException {
      response.setContentType("text/html");      //���ڿ� ������ type�� ������ MIME Type���� Content Type�� �����Ѵ�.
      response.setContentType("text/html");      //
      response.setCharacterEncoding("euc-kr");   //���� JSP�� ���޵Ǵ� ������ ������ ĳ���ͼ����� ��ȯ�� �ش�.      
                                                 // HTML ������ �ѱ��� �Է��� �� ���������� ó���Ϸ��� �ݵ�� �ʿ��ϴ�.
      
      Calendar c = Calendar.getInstance(); 
      //Calendar�� ������ �ð��뺰 �ð��� ���� (��,��,��,�ð�,��,��¥)
      //Calendar ����ϱ� ���ؼ���  Calendar.getInstance(); ����ؾ� �Ѵ�.
      
      int year = c.get(Calendar.YEAR); //��
      int month = c.get(Calendar.MONTH); //��
      int dayofweek = c.get(Calendar.DAY_OF_WEEK); 
      int hour = c.get(Calendar.HOUR_OF_DAY);
      int minute = c.get(Calendar.MINUTE);
      int second = c.get(Calendar.SECOND);
      
      PrintWriter out = response.getWriter();       //���� ��Ʈ���� �ؽ�Ʈ�� ���
      //PrintWriter  ����Ʈ���ڸ� ���� ���·� ������ ��ü�� �ٲ۴�.
      //getWriter(); �޼ҵ�� �������� ������ ��� ��Ʈ���� ��� ���� 
      //out.print(HTML �±�) ���·� �ۼ��Ͽ� ��Ʈ���� �ؽ�Ʈ�� ����Ѵ�.


      out.write("<HTML><HEAD><TITLE>ServletTest</TITLE></HEAD>");
      out.write("<BODY><H1>");
      out.write("Current time"); //����ð�
      out.write(Integer.toString(hour));
      out.write("time"); //��
      out.write(Integer.toString(minute));
      out.write("minute"); //��
      out.write(Integer.toString(second));
      out.write("second");//��
      out.write("</H1></BODY></HTML>");
      out.close();
   }
}