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
		<title>ご予約</title>
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

			//-->
		</script>
	</head>

	<body>
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

		//月の末日判定
		int lastday = cal.getActualMaximum(Calendar.DATE);
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

					<th>日付</th>
					<td>
						<select name="rsvYy">
							<%
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
								%>
								<option value = "<%= i %>" <%= selected %> >
									<%= i %> 年
								</option>
							<%
								}
							%>
						</select>
						<select name="rsvMm"  >
							<%
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
								%>
								<%! String Mm; %>
								<% Mm = String.format("%02d", i); %>
								<option value = "<%= Mm %>" <%= selected %> >
									<%= Mm %> 月
								</option>
							<%
								}
							%>
						</select>
						<select name="rsvDd">
							<%
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
								%>
								<%! String Dd; %>
								<% Dd = String.format("%02d", i); %>
								<option value = "<%= Dd %>" <%= selected %> >
									<%= Dd %> 日
								</option>
							<%
								}
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
								%>
								<option value = "<%= i %>" <%= selected %> >
									<%= i %> 時
								</option>
							<%
								//System.out.println(c_hh);
								c_hh++;
								}
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
									}else if(c_mi == 1){
										selected = "selected";
									}
									//System.out.println("mi_select:" + selected);
								%>
								<%! String Mi; %>
								<% Mi = String.format("%02d", i); %>
								<option value = "<%= Mi %>" <%= selected %> >
									<%= Mi %> 分
								</option>
							<%
								//System.out.println(c_mi);
								c_mi++;
								}
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
									}else if(c_p == 1){
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
									}else if(c_cid == 1){
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
							%>
						</select>
					</td>
				</tr>
				<tr>
					<td id="sub" colspan="2">席を確認します。確認を押してください。
						<input type="submit" value=" 確認" />
					</td>
				</tr>
				<input type="hidden" name="usrId" value="<jsp:getProperty property="usrId" name="userInfo"/>"/>
				<input type="hidden" name="mode" value="11"/>
				<input type = "hidden" name = "mailMode" value = "987" />
				<!-- モード 11  新規予約（INSERT） -->
			</table>
			<br />
		</form>
		<br />
		<p id="boder"><a href="ReserveListSvl">予約一覧に戻る</a></p>
	</body>
</html>