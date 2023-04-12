import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Calendar;

public class ServletTest extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException {
      response.setContentType("text/html");      //臾몄옄�뿴 �삎�깭�쓽 type�뿉 吏��젙�맂 MIME Type�쑝濡� Content Type�쓣 吏��젙�븳�떎.
      response.setContentType("text/html");      //
      response.setCharacterEncoding("euc-kr");   //�쁽�옱 JSP濡� �쟾�떖�릺�뒗 �궡�슜�쓣 吏��젙�븳 罹먮━�꽣�뀑�쓣濡� 蹂��솚�빐 以��떎.      
                                                 // HTML �뤌�뿉�꽌 �븳湲��쓣 �엯�젰�븷 �븣 �젙�긽�쟻�쑝濡� 泥섎━�븯�젮硫� 諛섎뱶�떆 �븘�슂�븯�떎.
      
      Calendar c = Calendar.getInstance(); 
      //Calendar�뒗 援�媛�蹂� �떆媛꾨�蹂� �떆媛꾩쓣 �젣怨� (�뀈,�썡,�씪,�떆媛�,遺�,�궇吏�)
      //Calendar �궗�슜�븯湲� �쐞�빐�꽌�뒗  Calendar.getInstance(); �궗�슜�빐�빞 �븳�떎.
      
      int year = c.get(Calendar.YEAR); //�뀈
      int month = c.get(Calendar.MONTH); //�떖
      int dayofweek = c.get(Calendar.DAY_OF_WEEK); 
      int hour = c.get(Calendar.HOUR_OF_DAY);
      int minute = c.get(Calendar.MINUTE);
      int second = c.get(Calendar.SECOND);
      
      PrintWriter out = response.getWriter();       //�쓳�떟 �뒪�듃由쇱뿉 �뀓�뒪�듃濡� 湲곕줉
      //PrintWriter  諛붿씠�듃臾몄옄瑜� 臾몄옄 �삎�깭濡� 媛�吏��뒗 媛앹껜濡� 諛붽씔�떎.
      //getWriter(); 硫붿냼�뱶濡� �쓳�떟�쑝濡� �궡蹂대궪 異쒕젰 �뒪�듃���쓣 �뼸�뼱 �궦�썑 
      //out.print(HTML �깭洹�) �삎�깭濡� �옉�꽦�븯�뿬 �뒪�듃由쇱뿉 �뀓�뒪�듃瑜� 湲곕줉�븳�떎.


      out.write("<HTML><HEAD><TITLE>ServletTest</TITLE></HEAD>");
      out.write("<BODY><H1>");
      out.write("Current timn"); //�쁽�옱�떆媛�
      out.write(Integer.toString(year));
      out.write("year"); //�뀈
      out.write(Integer.toString(month));
      out.write("month"); //�떖
      out.write(Integer.toString(hour));
      out.write("time"); //�떆
      out.write(Integer.toString(minute));
      out.write("minute"); //遺�
      out.write(Integer.toString(second));
      out.write("second");//珥�
      out.write("</H1></BODY></HTML>");
      out.close();
   }
}