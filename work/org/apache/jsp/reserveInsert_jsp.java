/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.20
 * Generated at: 2021-05-16 06:46:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.catalina.valves.rewrite.RewriteValve;
import java.util.*;
import model.*;

public final class reserveInsert_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

 String Mm; 
 String Dd; 
 String Mi; 
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("model");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("org.apache.catalina.valves.rewrite.RewriteValve");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("\t\t<title>ご予約</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"meisai.css\"/>\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t<!--\r\n");
      out.write("\t\t\t\tfunction checkData(obj){\r\n");
      out.write("\t\t\t\t\tvar msg = \"\";\r\n");
      out.write("\t\t\t\t\tvar rsvYy = parseInt(obj.rsvYy.value);\r\n");
      out.write("\t\t\t\t\tvar rsvMm = parseInt(obj.rsvMm.value) - 1;\r\n");
      out.write("\t\t\t\t\tvar rsvDd = parseInt(obj.rsvDd.value);\r\n");
      out.write("\t\t\t\t\tvar rsvHh = parseInt(obj.rsvHh.value);\r\n");
      out.write("\t\t\t\t\tvar rsvMi = parseInt(obj.rsvMi.value);\r\n");
      out.write("\t\t\t\t\tvar rsvDay = new Date( rsvYy, rsvMm, rsvDd, rsvHh, rsvMi,0);\r\n");
      out.write("\t\t\t\t\tvar toDay = new Date();\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tif( rsvDay.getTime() < toDay.getTime() ){\r\n");
      out.write("\t\t\t\t\t\tmsg += \"予約日時が過去日又は無効な日付です。\\n\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tif((rsvDay.getTime() - toDay.getTime()) / 24 / 60 / 60 / 1000 >= 365){\r\n");
      out.write("\t\t\t\t\t\tmsg += \"一年以上先の予約は承れません。\\n\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tif(msg.length > 0){\r\n");
      out.write("\t\t\t\t\t\talert(msg);\r\n");
      out.write("\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\treturn true;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t//-->\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\t<body>\r\n");
      out.write("\t");
      model.User userInfo = null;
      synchronized (session) {
        userInfo = (model.User) _jspx_page_context.getAttribute("userInfo", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (userInfo == null){
          userInfo = new model.User();
          _jspx_page_context.setAttribute("userInfo", userInfo, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      out.write('	');
      model.Reserve reserve = null;
      reserve = (model.Reserve) _jspx_page_context.getAttribute("reserve", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (reserve == null){
        reserve = new model.Reserve();
        _jspx_page_context.setAttribute("reserve", reserve, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write('\r');
      out.write('\n');
      out.write('	');
      java.util.ArrayList courseList = null;
      courseList = (java.util.ArrayList) _jspx_page_context.getAttribute("courseList", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (courseList == null){
        courseList = new java.util.ArrayList();
        _jspx_page_context.setAttribute("courseList", courseList, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write("\r\n");
      out.write("\t\t");

		//今日の日付を取得
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);

		//月の末日判定
		int lastday = cal.getActualMaximum(Calendar.DATE);
		
      out.write("\r\n");
      out.write("\t\t<h2>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((model.User)_jspx_page_context.findAttribute("userInfo")).getUsrName())));
      out.write("様  ご予約</h2>\r\n");
      out.write("\t\t<br/>\r\n");
      out.write("\t\t");

				IdealException msg = (IdealException)request.getAttribute("msg");
				if(msg != null) {
			
      out.write("\r\n");
      out.write("\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t");
      out.print( msg.getMsg() );
      out.write("\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t");
		 } 
      out.write("\r\n");
      out.write("\t\t<form id=\"frm1\" name=\"frm1\" action=\"ReserveOperationSvl\" onSubmit=\"return checkData(this)\" method=\"post\">\r\n");
      out.write("\t\t\t<table border>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<th>日付</th>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<select name=\"rsvYy\">\r\n");
      out.write("\t\t\t\t\t\t\t");

								//System.out.println(reserve);
								int rc_yy = reserve.getRsvYy(); //予約した年

								for(int i = year; i <= year + 1; i ++){
									String selected ="";

									//System.out.println("予約年:" + rc_yy);

									if(reserve == null){
										if(i == year){
											selected = "selected";
										}
									}else if(rc_yy == i){
										selected = "selected";
									}else if(i == year){
										selected = "selected";
									}
									//System.out.println("yy_select:" + selected);
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value = \"");
      out.print( i );
      out.write('"');
      out.write(' ');
      out.print( selected );
      out.write(" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print( i );
      out.write(" 年\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t");

								}
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t<select name=\"rsvMm\"  >\r\n");
      out.write("\t\t\t\t\t\t\t");

								int rc_mm = reserve.getRsvMm(); //予約した月

								for(int i = 1; i <= 12; i ++){
									String selected ="";

									//System.out.println("予約月:" + rc_mm);
									if(reserve == null){
										if(i == month){
											selected = "selected";
										}
									}else if(rc_mm == i){
										selected = "selected";
									}else if(i == month){
										selected = "selected";
									}
									//System.out.println("mm_select:" + selected);
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t");
 Mm = String.format("%02d", i); 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value = \"");
      out.print( Mm );
      out.write('"');
      out.write(' ');
      out.print( selected );
      out.write(" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print( Mm );
      out.write(" 月\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t");

								}
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t<select name=\"rsvDd\">\r\n");
      out.write("\t\t\t\t\t\t\t");

								int rc_dd = reserve.getRsvDd(); //予約した分

								for(int i = 1; i <= lastday; i ++){
									String selected ="";

									//System.out.println("予約分:" + rc_dd);
									if(reserve == null){
										if(i == day){
											selected = "selected";
										}
									}else if(rc_dd == i){
										selected = "selected";
									}else if(i == day){
										selected = "selected";
									}
									//System.out.println("dd_select:" + selected);
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t");
 Dd = String.format("%02d", i); 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value = \"");
      out.print( Dd );
      out.write('"');
      out.write(' ');
      out.print( selected );
      out.write(" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print( Dd );
      out.write(" 日\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t");

								}
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>時刻</th>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<select name = \"rsvHh\">\r\n");
      out.write("\t\t\t\t\t\t\t");


								int rc_hh = reserve.getRsvHh(); //予約した時
								int c_hh = 1; //Hhカウンター

								for(int i = 17; i <= 21; i ++){
									String selected ="";

									//System.out.println("予約分:" + rc_hh);
									if(reserve == null){
										if(c_hh == 1){
											selected = "selected";
										}
									}else if(rc_hh == i){
										selected = "selected";
									}else if(c_hh == 1){
										selected = "selected";
									}
									//System.out.println("hh_select:" + selected);
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value = \"");
      out.print( i );
      out.write('"');
      out.write(' ');
      out.print( selected );
      out.write(" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print( i );
      out.write(" 時\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t");

								//System.out.println(c_hh);
								c_hh++;
								}
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t<select name = \"rsvMi\">\r\n");
      out.write("\t\t\t\t\t\t\t");


								int rc_mi = reserve.getRsvMi(); //予約した分
								int c_mi = 1; //Miカウンター

								for(int i = 0; i <= 45; i += 15){
									String selected ="";

									//System.out.println("予約分:" + rc_mi);
									if(reserve == null){
										if(c_mi == 1){
											selected = "selected";
										}
									}else if(rc_mi == i){
										selected = "selected";
									}else if(c_mi == 1){
										selected = "selected";
									}
									//System.out.println("mi_select:" + selected);
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t");
 Mi = String.format("%02d", i); 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value = \"");
      out.print( Mi );
      out.write('"');
      out.write(' ');
      out.print( selected );
      out.write(" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print( Mi );
      out.write(" 分\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t");

								//System.out.println(c_mi);
								c_mi++;
								}
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>人数</th>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<select name = \"person\">\r\n");
      out.write("\t\t\t\t\t\t\t");


								int rc_p = reserve.getPerson(); //予約した人数
								int c_p = 1; //personカウンター

								for(int i = 1; i < 7; i ++){
									String selected ="";

									//System.out.println("予約人数" + rc_p);
									if(reserve == null){
										if(c_p == 1){
											selected = "selected";
										}
									}else if(rc_p == i){
										selected = "selected";
									}else if(c_p == 1){
										selected = "selected";
									}
									//System.out.println("p_select:" + selected);
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value = \"");
      out.print( i );
      out.write('"');
      out.write(' ');
      out.write(' ');
      out.print( selected );
      out.write(">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print( i );
      out.write(" 名\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t");

								//System.out.println("personカウンター" + c_p);
								c_p++;
								}
							
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>コース</th>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<select name = \"courseId\">\r\n");
      out.write("\t\t\t\t\t\t\t");


								Course cl;
								int rc_id = reserve.getCourseId(); //予約したコース料理

								int c_cid = 1; //コースIDカウンター

								for(Object o: courseList){
									cl = (Course)o;
									String selected ="";

									//System.out.println("コースID" + rc_id);
									if(reserve == null){
										if(c_cid == 1){
											selected = "selected";
										}
									}else if(rc_id == cl.getCourseId()){
										selected = "selected";
									}else if(c_cid == 1){
										selected = "selected";
									}
									//System.out.println("s" + selected);
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"");
      out.print( cl.getCourseId() );
      out.write('"');
      out.write(' ');
      out.write(' ');
      out.print( selected );
      out.write(">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print( cl.getCourseName() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t");

								//System.out.println("コースIDカウンター" + c_cid);
								c_cid++;
								}
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"sub\" colspan=\"2\">席を確認します。確認を押してください。\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\" 確認\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"usrId\" value=\"");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((model.User)_jspx_page_context.findAttribute("userInfo")).getUsrId())));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"mode\" value=\"11\"/>\r\n");
      out.write("\t\t\t\t<input type = \"hidden\" name = \"mailMode\" value = \"987\" />\r\n");
      out.write("\t\t\t\t<!-- モード 11  新規予約（INSERT） -->\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t\t<p id=\"boder\"><a href=\"ReserveListSvl\">予約一覧に戻る</a></p>\r\n");
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
