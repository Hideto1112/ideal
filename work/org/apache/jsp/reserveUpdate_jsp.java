/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.20
 * Generated at: 2021-05-09 09:27:48 UTC
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

public final class reserveUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

 String mm; 
 String dd; 
 String mi; 
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
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<title>ご予約変更</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"meisai.css\"/>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("      <!--\r\n");
      out.write("        function checkData(obj){\r\n");
      out.write("          var msg = \"\";\r\n");
      out.write("          var rsvYy = parseInt(obj.rsvYy.value);\r\n");
      out.write("          var rsvMm = parseInt(obj.rsvMm.value) - 1;\r\n");
      out.write("          var rsvDd = parseInt(obj.rsvDd.value);\r\n");
      out.write("          var rsvHh = parseInt(obj.rsvHh.value);\r\n");
      out.write("          var rsvMi = parseInt(obj.rsvMi.value);\r\n");
      out.write("          var rsvDay = new Date( rsvYy, rsvMm, rsvDd, rsvHh, rsvMi,0);\r\n");
      out.write("          var toDay = new Date();\r\n");
      out.write("\r\n");
      out.write("          if( rsvDay.getTime() < toDay.getTime() ){\r\n");
      out.write("            msg += \"予約日時が過去日又は無効な日付です。\\n\";\r\n");
      out.write("          }\r\n");
      out.write("          if((rsvDay.getTime() - toDay.getTime()) / 24 / 60 / 60 / 1000 >= 365){\r\n");
      out.write("            msg += \"一年以上先の予約は承れません。\\n\";\r\n");
      out.write("          }\r\n");
      out.write("          if(msg.length > 0){\r\n");
      out.write("            alert(msg);\r\n");
      out.write("            return false;\r\n");
      out.write("          }else{\r\n");
      out.write("            return true;\r\n");
      out.write("          }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("      function monthDaySubmit(){\r\n");
      out.write("\r\n");
      out.write("    \t    //宣言\r\n");
      out.write("\t\t\tconst rsvYy = document.frm1.rsvYy;\r\n");
      out.write("\t\t\tconst rsvMm = document.frm1.rsvMm;\r\n");
      out.write("\t\t\tconst rsvDd = document.frm1.rsvDd;\r\n");
      out.write("\t\t\tconst rsvHh = document.frm1.rsvHh;\r\n");
      out.write("\t\t\tconst rsvMi = document.frm1.rsvMi;\r\n");
      out.write("\t\t\tconst person = document.frm1.person;\r\n");
      out.write("\t\t\tconst courseId = document.frm1.courseId;\r\n");
      out.write("\r\n");
      out.write("\t\t\t// 値(数値)を取得\r\n");
      out.write("\t\t\tconst num1 = rsvYy.selectedIndex;      //年\r\n");
      out.write("\t\t\tconst num2 = rsvMm.selectedIndex;      //月\r\n");
      out.write("\t\t\tconst num3 = rsvDd.selectedIndex;      //日\r\n");
      out.write("\t\t\tconst num4 = rsvHh.selectedIndex;      //時\r\n");
      out.write("\t\t\tconst num5 = rsvMi.selectedIndex;      //分\r\n");
      out.write("\t\t\tconst num6 = person.selectedIndex;     //人数\r\n");
      out.write("\t\t\tconst num7 = courseId.selectedIndex;   //コースID\r\n");
      out.write("\t\t\t\t//※例）繋げると \"const num1 = document.frm1.rsvYy.selectedIndex;\" となる。\r\n");
      out.write("\r\n");
      out.write("\t\t\t// 値(数値)から値(value値)を取得\r\n");
      out.write("\t\t\tconst str1 = rsvYy.options[num1].value;                     //年\r\n");
      out.write("\t\t\tconst str2 = rsvMm.options[num2].value;                     //月\r\n");
      out.write("\t\t\tconst str3 = rsvDd.options[num3].value;                     //日\r\n");
      out.write("\t\t\tconst str4 = rsvHh.options[num4].value;                     //時\r\n");
      out.write("\t\t\tconst str5 = rsvMi.options[num5].value;                     //分\r\n");
      out.write("\t\t\tconst str6 = person.options[num6].value;                     //人数\r\n");
      out.write("\t\t\tconst str7 = courseId.options[num7].value;                     //コースID\r\n");
      out.write("\t\t\t\t//※例）繋げると \"const str1 = document.frm1.rsvYy.\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t//options[document.frm1.rsvYy.selectedIndex].value; \" となる。\r\n");
      out.write("\r\n");
      out.write("\t\t\tdocument.getElementById(\"y\").value = str1;                  //年\r\n");
      out.write("\t\t\tdocument.getElementById(\"m\").value = str2;                  //月\r\n");
      out.write("\t\t\tdocument.getElementById(\"d\").value = str3;                  //日\r\n");
      out.write("\t\t\tdocument.getElementById(\"h\").value = str4;                  //時\r\n");
      out.write("\t\t\tdocument.getElementById(\"mi\").value = str5;                  //分\r\n");
      out.write("\t\t\tdocument.getElementById(\"pe\").value = str6;                  //人数\r\n");
      out.write("\t\t\tdocument.getElementById(\"cId\").value = str7;                  //コースID\r\n");
      out.write("\t\t\tdocument.monthDayForm.submit();                             //サブミット\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("      //-->\r\n");
      out.write("    </script>\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
 System.out.println("rsvupdate.jsp start"); 
      out.write("\r\n");
      out.write("  ");
      model.User userInfo = null;
      synchronized (session) {
        userInfo = (model.User) _jspx_page_context.getAttribute("userInfo", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (userInfo == null){
          userInfo = new model.User();
          _jspx_page_context.setAttribute("userInfo", userInfo, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("  ");
      model.Reserve reserve = null;
      reserve = (model.Reserve) _jspx_page_context.getAttribute("reserve", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (reserve == null){
        reserve = new model.Reserve();
        _jspx_page_context.setAttribute("reserve", reserve, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write("\r\n");
      out.write("  ");
      java.util.ArrayList courseList = null;
      courseList = (java.util.ArrayList) _jspx_page_context.getAttribute("courseList", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (courseList == null){
        courseList = new java.util.ArrayList();
        _jspx_page_context.setAttribute("courseList", courseList, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write("\r\n");
      out.write("    ");

    //今日の日付を取得
    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH) + 1;
    int day = cal.get(Calendar.DATE);
    int hour = cal.get(Calendar.HOUR_OF_DAY);
    int minute = cal.get(Calendar.MINUTE);

    //System.out.println(year + "年" + month + "月" + day + "日");
System.out.println("rsvupdate.jsp 01");
  //予約情報
    int rc_yy = reserve.getRsvYy(); //予約した年
    int rc_mm = reserve.getRsvMm(); //予約した月
	int rc_dd = reserve.getRsvDd(); //予約した日
	System.out.println("rsvupdate.jsp 10" + rc_yy);
	System.out.println("rsvupdate.jsp 10" + rc_mm);
	System.out.println("rsvupdate.jsp 10" + rc_dd);

	//月末の設定
	cal.set(rc_yy,rc_mm -1, 1);
	int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

	//予約情報の確認
	//System.out.println(reserve);
    //System.out.println("予約年:" + rc_yy);
    //System.out.println("予約月:" + rc_mm);
    //System.out.println("予約日:" + rc_dd);
    
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <h2>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((model.User)_jspx_page_context.findAttribute("userInfo")).getUsrName())));
      out.write("様  ご予約</h2>\r\n");
      out.write("    <br/>\r\n");
      out.write("    ");

        IdealException msg = (IdealException)request.getAttribute("msg");
        if(msg != null) {
      
      out.write("\r\n");
      out.write("        <p>\r\n");
      out.write("          ");
      out.print( msg.getMsg() );
      out.write("\r\n");
      out.write("        </p>\r\n");
      out.write("    ");
		 } 
      out.write("\r\n");
      out.write("    <form id=\"frm1\" name=\"frm1\" action=\"ReserveOperationSvl\" onSubmit=\"return checkData(this)\" method=\"post\">\r\n");
      out.write("      <table border>\r\n");
      out.write("      <tr>\r\n");
      out.write("          <th>予約番号</th>\r\n");
      out.write("          <td>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((model.Reserve)_jspx_page_context.findAttribute("reserve")).getRsvId())));
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("\r\n");
      out.write("          <th>日付</th>\r\n");
      out.write("          <td>\r\n");
      out.write("             <select name=\"rsvYy\" onchange=\"monthDaySubmit();\">\r\n");
      out.write("\t\t\t\t");

System.out.println("rsvupdate.jsp ");
				for(int i = year; i <= year + 1; i ++){
					String selected ="";
					if(reserve == null){
						if(year == i){
							selected = "selected";
							}
					}else if(rc_yy == i){
						selected = "selected";
						}
				
      out.write("\r\n");
      out.write("\t\t\t\t<option value = \"");
      out.print( i );
      out.write('"');
      out.write(' ');
      out.print( selected );
      out.write(" >\r\n");
      out.write("\t\t\t\t\t");
      out.print( i );
      out.write(" 年\r\n");
      out.write("\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t");

				}
System.out.println("rsvupdate.jsp yy " + rc_yy);
				
      out.write("\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t<select name=\"rsvMm\" onchange=\"monthDaySubmit();\" >\r\n");
      out.write("\t\t\t\t");

								for(int i = 1; i <= 12; i ++){
									String selected ="";

									if(reserve == null){
										if(i == month){
											rc_mm = i;
											selected = "selected";
										}
									}else if(rc_mm == i){
										selected = "selected";
									}

								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
 mm = String.format("%02d", i); 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value = \"");
      out.print( mm );
      out.write('"');
      out.write(' ');
      out.print( selected );
      out.write(" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print( mm );
      out.write(" 月\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t");

								}
System.out.println("rsvupdate.jsp mm " + rc_mm);
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t<select name=\"rsvDd\">\r\n");
      out.write("\t\t\t\t\t\t\t");

								for(int i = 1; i <= lastday; i ++){
									String selected ="";

									if(reserve == null){
										if(day == i){
											selected = "selected";
										}
									}else if(rc_dd == i){
										selected = "selected";
									}else if(day > lastday){
										if(i == 1){
											rc_dd = 1;
											selected = "selected";
										}
									}
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
 dd = String.format("%02d", i); 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value = \"");
      out.print( dd );
      out.write('"');
      out.write(' ');
      out.print( selected );
      out.write(" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print( dd );
      out.write(" 日\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t");

								}
System.out.println("rsvupdate.jsp dd " + rc_dd);
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <th>時刻</th>\r\n");
      out.write("          <td>\r\n");
      out.write("            <select name = \"rsvHh\">\r\n");
      out.write("              ");


                int rc_hh = reserve.getRsvHh(); //予約した時
                int c_hh = 1; //Hhカウンター

                for(int i = 17; i <= 21; i ++){
                  String selected ="";

                  //System.out.println("予約時:" + rc_hh);
                  // selectの設定
                  if(reserve == null){
                	  //カウンターが 1（初期値）の時、17時に設定する。
                    if(c_hh == 1){
                      selected = "selected";
                    }
                  }else if(rc_hh == i){
                	  //予約情報の時間と iが同じならば、該当時間に設定
                    selected = "selected";
                  }


                  //System.out.println("hh_select:" + selected);
                
      out.write("\r\n");
      out.write("                <option value = \"");
      out.print( i );
      out.write('"');
      out.write(' ');
      out.print( selected );
      out.write(" >\r\n");
      out.write("                  ");
      out.print( i );
      out.write(" 時\r\n");
      out.write("                </option>\r\n");
      out.write("              ");

                //System.out.println(c_hh);
                c_hh++;
                }
System.out.println("rsvupdate.jsp hh " + rc_hh);
              
      out.write("\r\n");
      out.write("            </select>\r\n");
      out.write("            <select name = \"rsvMi\">\r\n");
      out.write("              ");


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
                  }
                
      out.write("\r\n");
      out.write("                 ");
      out.write("\r\n");
      out.write("\t\t\t\t");
 mi = String.format("%02d", i); 
      out.write("\r\n");
      out.write("                <option value = \"");
      out.print( mi );
      out.write('"');
      out.write(' ');
      out.print( selected );
      out.write(" >\r\n");
      out.write("\t\t\t\t");
      out.print( mi );
      out.write(" 分\r\n");
      out.write("                </option>\r\n");
      out.write("              ");

                //System.out.println(c_mi);
                c_mi++;
                }
System.out.println("rsvupdate.jsp mi " + rc_mi);
              
      out.write("\r\n");
      out.write("              </select>\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <th>人数</th>\r\n");
      out.write("          <td>\r\n");
      out.write("            <select name = \"person\">\r\n");
      out.write("\r\n");
      out.write("              ");

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
                  }
                  //System.out.println("p_select:" + selected);
                
      out.write("\r\n");
      out.write("                <option value = \"");
      out.print( i );
      out.write('"');
      out.write(' ');
      out.write(' ');
      out.print( selected );
      out.write(">\r\n");
      out.write("                  ");
      out.print( i );
      out.write(" 名\r\n");
      out.write("                </option>\r\n");
      out.write("              ");

                //System.out.println("personカウンター" + c_p);
                c_p++;
                }
System.out.println("rsvupdate.jsp person " + rc_p);
              
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            </select>\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <th>コース</th>\r\n");
      out.write("          <td>\r\n");
      out.write("            <select name = \"courseId\">\r\n");
      out.write("              ");


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
                  }
                  //System.out.println("s" + selected);
                
      out.write("\r\n");
      out.write("                <option value=\"");
      out.print( cl.getCourseId() );
      out.write('"');
      out.write(' ');
      out.write(' ');
      out.print( selected );
      out.write(">\r\n");
      out.write("                  ");
      out.print( cl.getCourseName() );
      out.write("\r\n");
      out.write("                </option>\r\n");
      out.write("              ");

                //System.out.println("コースIDカウンター" + c_cid);
                c_cid++;
                }
System.out.println("rsvupdate.jsp courseid " + rc_id);
              
      out.write("\r\n");
      out.write("            </select>\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td id=\"sub\" colspan=\"2\">席を確認します。確認を押してください。\r\n");
      out.write("            <input type=\"submit\" value=\" 確認\" />\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <input type=\"hidden\" name=\"rsvId\" value=\"");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((model.Reserve)_jspx_page_context.findAttribute("reserve")).getRsvId())));
      out.write("\"/>\r\n");
      out.write("\r\n");
      out.write("        <input type=\"hidden\" name=\"usrId\" value=\"");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((model.User)_jspx_page_context.findAttribute("userInfo")).getUsrId())));
      out.write("\"/>\r\n");
      out.write("\r\n");
      out.write("        <input type=\"hidden\" name=\"mode\" value=\"12\"/>\r\n");
      out.write("      </table>\r\n");
      out.write("      <br />\r\n");
      out.write("    </form>\r\n");
      out.write("    <form name=\"monthDayForm\" action=\"ReserveUpdateSvl\" method=\"post\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"y\" name=\"y\"  />\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"m\" name=\"m\"  />\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"d\" name=\"d\"  />\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"h\" name=\"h\"  />\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"mi\" name=\"mi\"  />\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"pe\" name=\"pe\"  />\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"cId\" name=\"cId\"  />\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"rsvId\" name=\"rsvId\" value=\"");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((model.Reserve)_jspx_page_context.findAttribute("reserve")).getRsvId())));
      out.write("\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("    <br />\r\n");
      out.write("    <p id=\"boder\"><a href=\"ReserveListSvl\">予約一覧に戻る</a></p>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
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
