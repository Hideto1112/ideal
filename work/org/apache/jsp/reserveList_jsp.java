/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.20
 * Generated at: 2021-05-13 03:30:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.*;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class reserveList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("model");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.time.format.DateTimeFormatter");
    _jspx_imports_classes.add("java.time.LocalDateTime");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
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

      out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("\r\n");
      out.write("\t\t<title>?????????????????????</title>\r\n");
      out.write("\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"ichirann_a.css\"/>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      java.util.ArrayList reserveList = null;
      reserveList = (java.util.ArrayList) _jspx_page_context.getAttribute("reserveList", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (reserveList == null){
        reserveList = new java.util.ArrayList();
        _jspx_page_context.setAttribute("reserveList", reserveList, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write('\r');
      out.write('\n');
      model.User userInfo = null;
      synchronized (session) {
        userInfo = (model.User) _jspx_page_context.getAttribute("userInfo", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (userInfo == null){
          userInfo = new model.User();
          _jspx_page_context.setAttribute("userInfo", userInfo, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<h2>\r\n");
      out.write("\t\t\t");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((model.User)_jspx_page_context.findAttribute("userInfo")).getUsrName())));
      out.write("?????????????????????\r\n");
      out.write("\t\t</h2>\r\n");
      out.write("\t\t<br/>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<table border>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"head\">NO</td>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"head\">???????????????</td>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"head\">??????</td>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"head\">????????????</td>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"head\">???????????????</td>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"head\">????????????</td>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\" id=\"head\">??????</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");

	// ArrayList<Reserve> al = new ArrayList<Reserve>();
	//	al = (ArrayList<Reserve>)reserveList;
	for(int i = 0; i < reserveList.size(); i++){
		Reserve rsv = (Reserve)reserveList.get(i);
		LocalDateTime d = LocalDateTime.parse(rsv.getRsvDate());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy???MM???dd??? HH???mm???");

		LocalDateTime d2 = LocalDateTime.parse(rsv.getAppDate());
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy???MM???dd??? HH???mm???");




      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"50px\"></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"250px\"></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"50px\"></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"300px\"></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"200px\"></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"300px\"></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"50px\"></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"50px\"></td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<td id=\"meisai\">");
      out.print( i + 1 );
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<td id=\"meisai\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print( dtf.format(d) );
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td id=\"meisai\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print( rsv.getPerson() );
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<td id=\"meisai\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print( rsv.getCourseName() );
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<td id=\"meisai\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print( rsv.getTableName() );
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<td id=\"meisai\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print( dtf2.format(d2) );
      out.write("\r\n");
      out.write(" \t\t\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<form action = \"ReserveUpdateSvl\" method = \"post\">\r\n");
      out.write("\t\t\t\t\t\t\t<td id=\"meisai\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<!--1.???????????????  ?????????????????????????????????(mode)????????????????????????????????????-->\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"submit\" value=\"??????\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type = \"hidden\" name = \"rsvId\" value = \"");
      out.print( rsv.getRsvId() );
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t<form action = \"ReserveDeleteSvl\" method = \"post\">\r\n");
      out.write("\t\t\t\t\t\t\t<td id=\"meisai\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<!--2.???????????????  ?????????????????????????????????(mode)????????????????????????????????????-->\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"submit\" value=\"??????\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type = \"hidden\" name = \"rsvId\" value = \"");
      out.print( rsv.getRsvId() );
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"50px\"></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"250px\"></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"50px\"></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"300px\"></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"200px\"></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"300px\"></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"50px\"></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"50px\"></td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"10\"  id=\"boder\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<form action = \"ReserveInsertSvl\" method = \"post\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<input type = \"submit\" value = \"???????????????\"/>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t\t<p id=\"boder\"><a href=\"StatusSvl?mode=777&usrId=");
      out.print( userInfo.getUsrId() );
      out.write("\">??????????????????</a></p>\r\n");
      out.write("\t\t<p id=\"boder\"><a href=\"userIndex.jsp\">??????</a></p>\r\n");
      out.write("\t</body>\r\n");
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
