<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="org.apache.catalina.valves.rewrite.RewriteValve"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ご予約変更</title>
    <link rel="stylesheet" type="text/css" href="meisai.css"/>
    <script type="text/javascript">
      <!--
        function checkData(obj){
          var msg = "";
          var rsvYy = parseInt(obj.rsvYy.value);
          var rsvMm = parseInt(obj.rsvMm.value) - 1;
          var rsvDd = parseInt(obj.rsvDd.value);
          var rsvHh = parseInt(obj.rsvHh.value);
          var rsvMi = parseInt(obj.rsvMi.value);
          var rsvDay = new Date( rsvYy, rsvMm, rsvDd, rsvHh, rsvMi,0);
          var toDay = new Date();

          if( rsvDay.getTime() < toDay.getTime() ){
            msg += "予約日時が過去日又は無効な日付です。\n";
          }
          if((rsvDay.getTime() - toDay.getTime()) / 24 / 60 / 60 / 1000 >= 365){
            msg += "一年以上先の予約は承れません。\n";
          }
          if(msg.length > 0){
            alert(msg);
            return false;
          }else{
            return true;
          }
        }

      function monthDaySubmit(){

    	    //宣言
			const rsvYy = document.frm1.rsvYy;
			const rsvMm = document.frm1.rsvMm;
			const rsvDd = document.frm1.rsvDd;
			const rsvHh = document.frm1.rsvHh;
			const rsvMi = document.frm1.rsvMi;
			const person = document.frm1.person;
			const courseId = document.frm1.courseId;

			// 値(数値)を取得
			const num1 = rsvYy.selectedIndex;      //年
			const num2 = rsvMm.selectedIndex;      //月
			const num3 = rsvDd.selectedIndex;      //日
			const num4 = rsvHh.selectedIndex;      //時
			const num5 = rsvMi.selectedIndex;      //分
			const num6 = person.selectedIndex;     //人数
			const num7 = courseId.selectedIndex;   //コースID
				//※例）繋げると "const num1 = document.frm1.rsvYy.selectedIndex;" となる。

			// 値(数値)から値(value値)を取得
			const str1 = rsvYy.options[num1].value;                     //年
			const str2 = rsvMm.options[num2].value;                     //月
			const str3 = rsvDd.options[num3].value;                     //日
			const str4 = rsvHh.options[num4].value;                     //時
			const str5 = rsvMi.options[num5].value;                     //分
			const str6 = person.options[num6].value;                     //人数
			const str7 = courseId.options[num7].value;                     //コースID
				//※例）繋げると "const str1 = document.frm1.rsvYy.
													//options[document.frm1.rsvYy.selectedIndex].value; " となる。

			document.getElementById("y").value = str1;                  //年
			document.getElementById("m").value = str2;                  //月
			document.getElementById("d").value = str3;                  //日
			document.getElementById("h").value = str4;                  //時
			document.getElementById("mi").value = str5;                  //分
			document.getElementById("pe").value = str6;                  //人数
			document.getElementById("cId").value = str7;                  //コースID
			document.monthDayForm.submit();                             //サブミット
		}

      //-->
    </script>
  </head>

<body>
<% System.out.println("rsvupdate.jsp start"); %>
  <jsp:useBean id="userInfo" class="model.User" scope="session"/>
  <jsp:useBean id="reserve" class="model.Reserve" scope="request"/>
  <jsp:useBean id="courseList" class="java.util.ArrayList" scope="request"/>
    <%
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
    %>

    <h2><jsp:getProperty property="usrName" name="userInfo"/>様  ご予約</h2>
    <br/>
    <%
        IdealException msg = (IdealException)request.getAttribute("msg");
        if(msg != null) {
      %>
        <p>
          <%= msg.getMsg() %>
        </p>
    <%		 } %>
    <form id="frm1" name="frm1" action="ReserveOperationSvl" onSubmit="return checkData(this)" method="post">
      <table border>
      <tr>
          <th>予約番号</th>
          <td><jsp:getProperty property="rsvId" name="reserve"/></td>
        </tr>
        <tr>

          <th>日付</th>
          <td>
             <select name="rsvYy" onchange="monthDaySubmit();">
				<%
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
				%>
				<option value = "<%= i %>" <%= selected %> >
					<%= i %> 年
				</option>
				<%
				}
System.out.println("rsvupdate.jsp yy " + rc_yy);
				%>
				</select>
				<select name="rsvMm" onchange="monthDaySubmit();" >
				<%
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

								%>
									<%! String mm; %>
									<% mm = String.format("%02d", i); %>
								<option value = "<%= mm %>" <%= selected %> >
									<%= mm %> 月
								</option>
							<%
								}
System.out.println("rsvupdate.jsp mm " + rc_mm);
							%>
						</select>
						<select name="rsvDd">
							<%
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
								%>
									<%! String dd; %>
									<% dd = String.format("%02d", i); %>
								<option value = "<%= dd %>" <%= selected %> >
									<%= dd %> 日
								</option>
							<%
								}
System.out.println("rsvupdate.jsp dd " + rc_dd);
							%>
						</select>
          </td>
        </tr>
        <tr>
          <th>時刻</th>
          <td>
            <select name = "rsvHh">
              <%

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
                %>
                <option value = "<%= i %>" <%= selected %> >
                  <%= i %> 時
                </option>
              <%
                //System.out.println(c_hh);
                c_hh++;
                }
System.out.println("rsvupdate.jsp hh " + rc_hh);
              %>
            </select>
            <select name = "rsvMi">
              <%

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
                %>
                 <%! String mi; %>
				<% mi = String.format("%02d", i); %>
                <option value = "<%= mi %>" <%= selected %> >
				<%= mi %> 分
                </option>
              <%
                //System.out.println(c_mi);
                c_mi++;
                }
System.out.println("rsvupdate.jsp mi " + rc_mi);
              %>
              </select>
          </td>
        </tr>
        <tr>
          <th>人数</th>
          <td>
            <select name = "person">

              <%
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
                %>
                <option value = "<%= i %>"  <%= selected %>>
                  <%= i %> 名
                </option>
              <%
                //System.out.println("personカウンター" + c_p);
                c_p++;
                }
System.out.println("rsvupdate.jsp person " + rc_p);
              %>


            </select>
          </td>
        </tr>
        <tr>
          <th>コース</th>
          <td>
            <select name = "courseId">
              <%

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
                %>
                <option value="<%= cl.getCourseId() %>"  <%= selected %>>
                  <%= cl.getCourseName() %>
                </option>
              <%
                //System.out.println("コースIDカウンター" + c_cid);
                c_cid++;
                }
System.out.println("rsvupdate.jsp courseid " + rc_id);
              %>
            </select>
          </td>
        </tr>
        <tr>
          <td id="sub" colspan="2">席を確認します。確認を押してください。
            <input type="submit" value=" 確認" />
          </td>
        </tr>
        <input type="hidden" name="rsvId" value="<jsp:getProperty property="rsvId" name="reserve"/>"/>

        <input type="hidden" name="usrId" value="<jsp:getProperty property="usrId" name="userInfo"/>"/>

        <input type="hidden" name="mode" value="12"/>
      </table>
      <br />
    </form>
    <form name="monthDayForm" action="ReserveUpdateSvl" method="post">
			<input type="hidden" id="y" name="y"  />
			<input type="hidden" id="m" name="m"  />
			<input type="hidden" id="d" name="d"  />
			<input type="hidden" id="h" name="h"  />
			<input type="hidden" id="mi" name="mi"  />
			<input type="hidden" id="pe" name="pe"  />
			<input type="hidden" id="cId" name="cId"  />
			<input type="hidden" id="rsvId" name="rsvId" value="<jsp:getProperty property="rsvId" name="reserve"/>"/>
	</form>
    <br />
    <p id="boder"><a href="ReserveListSvl">予約一覧に戻る</a></p>
  </body>
</html>
