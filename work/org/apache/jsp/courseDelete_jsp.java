/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.20
 * Generated at: 2021-05-17 02:19:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.text.*;
import controller.*;
import model.*;

public final class courseDelete_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {


	static String fmtNull(String s){
		if(s == null || s.equals("")){
			s = "&nbsp";
		}
		return s;

	}

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/incFile.jsp", Long.valueOf(1619838047794L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("java.text");
    _jspx_imports_packages.add("controller");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("model");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
 System.out.println("coursedel start"); 
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("<!--\r\n");
      out.write("table {\r\n");
      out.write("\tmargin: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("caption {\r\n");
      out.write("\tcolor: #990000;\r\n");
      out.write("\tfont-size: 18pt;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th {\r\n");
      out.write("\ttext-align: left;\r\n");
      out.write("\tbackground: #990000;\r\n");
      out.write("\tcolor: #FFD7D7;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("td {\r\n");
      out.write("\tbackground: #FFD7D7;\r\n");
      out.write("\ttext-align: left;\r\n");
      out.write("\tpadding-left: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th#bottom {\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("p {\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
 System.out.println("coursedel start2"); 
      out.write('\r');
      out.write('\n');
      java.util.ArrayList typeMenuList = null;
      typeMenuList = (java.util.ArrayList) _jspx_page_context.getAttribute("typeMenuList", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (typeMenuList == null){
        typeMenuList = new java.util.ArrayList();
        _jspx_page_context.setAttribute("typeMenuList", typeMenuList, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write('\r');
      out.write('\n');
      java.util.ArrayList oneCourse = null;
      oneCourse = (java.util.ArrayList) _jspx_page_context.getAttribute("oneCourse", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (oneCourse == null){
        oneCourse = new java.util.ArrayList();
        _jspx_page_context.setAttribute("oneCourse", oneCourse, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write('\r');
      out.write('\n');
 System.out.println("coursedel start31"); 
      out.write("\r\n");
      out.write("<table border>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<caption>コースの削除</caption>\r\n");
      out.write('\r');
      out.write('\n');

	NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("ja",
			"JP"));
	int typeId = Integer.parseInt(request.getParameter("typeId"));
	Course c1 = (Course)oneCourse.get(0);
	int cId = c1.getCourseId();

      out.write("\r\n");
      out.write("<form action=\"CourseOperationSvl\" method=\"post\">\r\n");
      out.write("<tr>\r\n");
      out.write("<th>コース名</th>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t");
      out.print( c1.getCourseName() );
      out.write("\r\n");
      out.write("\t</td>\r\n");
 System.out.println("coursedel start4"); 
      out.write("\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<th>価格</th>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t\t");
      out.print( nf.format(c1.getPrice()) );
      out.write("\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<th>オーダー可</th>\r\n");
      out.write("\t");

		int flg = c1.getOrderFlg();
		if(flg == 0) {
	
      out.write("\r\n");
      out.write("\t<td>不可</td>\r\n");
      out.write("\t");
 }else{ 
      out.write("\r\n");
      out.write("\t<td>可</td>\r\n");
      out.write("\t");
 } 
      out.write("\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<th>コメント</th>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t");
      out.print( c1.getDetail() );
      out.write("\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<th>前菜</th>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t");

		for(int i = 0; i < oneCourse.size(); i++) {
			Course c = (Course)oneCourse.get(i);
		
      out.write("\r\n");
      out.write("\t\t\t\t");
 if(c.getTypeId() == Course.getCOURSE_MENU_TYPE_ID()[0]) { 
      out.write("\r\n");
      out.write("\t\t");
      out.print( c.getMenuName() );
      out.write("\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<th>スープ</th>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t");

		for(int i = 0; i < oneCourse.size(); i++) {
			Course c = (Course)oneCourse.get(i);
		
      out.write("\r\n");
      out.write("\t\t\t\t");
 if(c.getTypeId() == Course.getCOURSE_MENU_TYPE_ID()[1]) { 
      out.write("\r\n");
      out.write("\t\t");
      out.print( c.getMenuName() );
      out.write("\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<th>パスタ</th>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t");

		for(int i = 0; i < oneCourse.size(); i++) {
			Course c = (Course)oneCourse.get(i);
		
      out.write("\r\n");
      out.write("\t\t\t\t");
 if(c.getTypeId() == Course.getCOURSE_MENU_TYPE_ID()[2]) { 
      out.write("\r\n");
      out.write("\t\t");
      out.print( c.getMenuName() );
      out.write("\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<th>肉料理</th>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t");

		for(int i = 0; i < oneCourse.size(); i++) {
			Course c = (Course)oneCourse.get(i);
		
      out.write("\r\n");
      out.write("\t\t\t\t");
 if(c.getTypeId() == Course.getCOURSE_MENU_TYPE_ID()[3]) { 
      out.write("\r\n");
      out.write("\t\t");
      out.print( c.getMenuName() );
      out.write("\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<th>魚料理</th>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t");

		for(int i = 0; i < oneCourse.size(); i++) {
			Course c = (Course)oneCourse.get(i);
		
      out.write("\r\n");
      out.write("\t\t\t\t");
 if(c.getTypeId() == Course.getCOURSE_MENU_TYPE_ID()[4]) { 
      out.write("\r\n");
      out.write("\t\t");
      out.print( c.getMenuName() );
      out.write("\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<th>デザート</th>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t");

		for(int i = 0; i < oneCourse.size(); i++) {
			Course c = (Course)oneCourse.get(i);
		
      out.write("\r\n");
      out.write("\t\t\t\t");
 if(c.getTypeId() == Course.getCOURSE_MENU_TYPE_ID()[5]) { 
      out.write("\r\n");
      out.write("\t\t");
      out.print( c.getMenuName() );
      out.write("\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<th colspan = \"2\" id = \"bottom\">\r\n");
      out.write("\t<input type = \"submit\" value = \"削除\"/>\r\n");
      out.write("</th>\r\n");
      out.write("\r\n");
      out.write("<input type = \"hidden\" name = \"mode\" value = \"");
      out.print( CourseOperationSvl.DELETE );
      out.write("\" />\r\n");
      out.write("<input type = \"hidden\" name = \"typeId\" value= \"");
      out.print( typeId );
      out.write("\" />\r\n");
      out.write("<input type = \"hidden\" name = \"courseId\" value= \"");
      out.print( cId );
      out.write("\" />\r\n");
      out.write("</form>\r\n");
      out.write("</table>\r\n");
      out.write("\t<p>\r\n");
      out.write("\t\t<a href=\"MenuMaintenanceSvl?typeId=");
      out.print( typeId );
      out.write("\">一覧表示画面へ戻る</a>\r\n");
      out.write("\t</p>\r\n");
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
