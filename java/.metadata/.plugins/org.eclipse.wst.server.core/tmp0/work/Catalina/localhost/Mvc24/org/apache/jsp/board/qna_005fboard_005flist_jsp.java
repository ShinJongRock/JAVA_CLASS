/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.65
 * Generated at: 2022-10-17 14:56:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.text.SimpleDateFormat;
import net.board.db.*;

public final class qna_005fboard_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("net.board.db");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	List boardList=(List)request.getAttribute("boardlist");
	int listcount=((Integer)request.getAttribute("listcount")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
	
	String id = (String)session.getAttribute("id");
	String pw= (String)session.getAttribute("pw");
	

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("	<title>MVC 게시판</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 게시판 리스트 -->\r\n");
      out.write("<table >\r\n");
      out.write("	<tr align=\"center\" valign=\"middle\">\r\n");
      out.write("		<td colspan=\"4\">MVC 게시판</td>\r\n");
      out.write("		<td align=right>\r\n");
      out.write("			<font size=2>글 개수 : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${listcount }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</font>\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	\r\n");
      out.write("	<tr align=\"center\" valign=\"middle\" bordercolor=\"#333333\">\r\n");
      out.write("		<td style=\"font-family:Tahoma;font-size:8pt;\" width=\"8%\" height=\"26\">\r\n");
      out.write("			<div align=\"center\">번호</div>\r\n");
      out.write("		</td>\r\n");
      out.write("		<td style=\"font-family:Tahoma;font-size:8pt;\" width=\"50%\">\r\n");
      out.write("			<div align=\"center\">제목</div>\r\n");
      out.write("		</td>\r\n");
      out.write("		<td style=\"font-family:Tahoma;font-size:8pt;\" width=\"14%\">\r\n");
      out.write("			<div align=\"center\">작성자</div>\r\n");
      out.write("		</td>\r\n");
      out.write("		<td style=\"font-family:Tahoma;font-size:8pt;\" width=\"17%\">\r\n");
      out.write("			<div align=\"center\">날짜</div>\r\n");
      out.write("		</td>\r\n");
      out.write("		<td style=\"font-family:Tahoma;font-size:8pt;\" width=\"11%\">\r\n");
      out.write("			<div align=\"center\">조회수</div>\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	\r\n");
      out.write("	");

		for(int i=0;i<boardList.size();i++){
			BoardBean bl=(BoardBean)boardList.get(i);
	
      out.write("\r\n");
      out.write("	<tr align=\"center\" valign=\"middle\" bordercolor=\"#333333\"\r\n");
      out.write("		onmouseover=\"this.style.backgroundColor='F8F8F8'\"\r\n");
      out.write("		onmouseout=\"this.style.backgroundColor=''\">\r\n");
      out.write("		<td height=\"23\" style=\"font-family:Tahoma;font-size:10pt;\">\r\n");
      out.write("			");
      out.print(bl.getBOARD_NUM());
      out.write("\r\n");
      out.write("		</td>\r\n");
      out.write("		\r\n");
      out.write("		<td style=\"font-family:Tahoma;font-size:10pt;\">\r\n");
      out.write("			<div align=\"left\">\r\n");
      out.write("			");
if(bl.getBOARD_RE_LEV()!=0){ 
      out.write("\r\n");
      out.write("				");
for(int a=0;a<=bl.getBOARD_RE_LEV()*2;a++){ 
      out.write("\r\n");
      out.write("				&nbsp;\r\n");
      out.write("				");
} 
      out.write("\r\n");
      out.write("				▶\r\n");
      out.write("			");
}else{ 
      out.write("\r\n");
      out.write("				▶\r\n");
      out.write("			");
} 
      out.write("\r\n");
      out.write("			<a href=\"./BoardDetailAction.bo?num=");
      out.print(bl.getBOARD_NUM());
      out.write("\"> \r\n");
      out.write("			<!-- 상세 보기 해당계시글의 번호 -->\r\n");
      out.write("				");
      out.print(bl.getBOARD_SUBJECT());
      out.write("\r\n");
      out.write("			</a>\r\n");
      out.write("			</div>\r\n");
      out.write("		</td>\r\n");
      out.write("		\r\n");
      out.write("		<td style=\"font-family:Tahoma;font-size:10pt;\">\r\n");
      out.write("			<div align=\"center\">");
      out.print(bl.getBOARD_NAME() );
      out.write("</div>\r\n");
      out.write("		</td>\r\n");
      out.write("		<td style=\"font-family:Tahoma;font-size:10pt;\">\r\n");
      out.write("			<div align=\"center\">");
      out.print(bl.getBOARD_DATE() );
      out.write("</div>\r\n");
      out.write("		</td>	\r\n");
      out.write("		<td style=\"font-family:Tahoma;font-size:10pt;\">\r\n");
      out.write("			<div align=\"center\">");
      out.print(bl.getBOARD_READCOUNT() );
      out.write("</div>\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	");
} 
      out.write("\r\n");
      out.write("	<tr align=center height=20>\r\n");
      out.write("		<td colspan=7 style=font-family:Tahoma;font-size:10pt;>\r\n");
      out.write("			");
if(nowpage<=1){ 
      out.write("\r\n");
      out.write("			[이전]&nbsp;\r\n");
      out.write("			");
}else{ 
      out.write("\r\n");
      out.write("			<a href=\"./BoardList.bo?page=");
      out.print(nowpage-1 );
      out.write("\">[이전]</a>&nbsp;\r\n");
      out.write("			");
} 
      out.write("\r\n");
      out.write("			\r\n");
      out.write("	\r\n");
      out.write("			\r\n");
      out.write("			");
for(int a=startpage;a<=endpage;a++){
				if(a==nowpage){
      out.write("\r\n");
      out.write("				[");
      out.print(a );
      out.write("]\r\n");
      out.write("				");
}else{ 
      out.write("\r\n");
      out.write("				<a href=\"./BoardList.bo?page=");
      out.print(a );
      out.write('"');
      out.write('>');
      out.write('[');
      out.print(a );
      out.write("]</a>&nbsp;\r\n");
      out.write("				");
} 
      out.write("\r\n");
      out.write("			");
} 
      out.write("\r\n");
      out.write("			\r\n");
      out.write("	\r\n");
      out.write("			");
if(nowpage>=maxpage){ 
      out.write("\r\n");
      out.write("			[다음]\r\n");
      out.write("			");
}else{ 
      out.write("\r\n");
      out.write("			<a href=\"./BoardList.bo?page=");
      out.print(nowpage+1 );
      out.write("\">[다음]</a>\r\n");
      out.write("			");
} 
      out.write("\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr align=\"right\">\r\n");
      out.write("		<td colspan=\"5\">\r\n");
      out.write("	   		<a href=\"./BoardWrite.bo\">[글쓰기]</a>\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
if(id.equals("admin")){ 
      out.write("\r\n");
      out.write("	<a href = \"./MemberList.lg\">user_info</a>\r\n");
} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
