<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

		<title>ご予約一覧画面</title>

		<link rel="stylesheet" type="text/css" href="ichirann_a.css"/>
</head>
<body>
<jsp:useBean id="reserveList" class="java.util.ArrayList" scope="request"></jsp:useBean>
<jsp:useBean id="userInfo" class="model.User" scope = "session" />

		<h2>
			<jsp:getProperty name="userInfo" property="usrName" />様　ご予約一覧
		</h2>
		<br/>



		<table border>

					<tr>
						<td id="head">NO</td>
						<td id="head">ご予約日時</td>
						<td id="head">人数</td>
						<td id="head">コース名</td>
						<td id="head">テーブル名</td>
						<td id="head">登録日時</td>
						<td colspan="2" id="head">　　</td>
					</tr>
<%
	// ArrayList<Reserve> al = new ArrayList<Reserve>();
	//	al = (ArrayList<Reserve>)reserveList;
	for(int i = 0; i < reserveList.size(); i++){
		Reserve rsv = (Reserve)reserveList.get(i);
		LocalDateTime d = LocalDateTime.parse(rsv.getRsvDate());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分");

		LocalDateTime d2 = LocalDateTime.parse(rsv.getAppDate());
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分");



%>
				<tr>
					<td width="50px"></td>
					<td width="250px"></td>
					<td width="50px"></td>
					<td width="300px"></td>
					<td width="200px"></td>
					<td width="300px"></td>
					<td width="50px"></td>
					<td width="50px"></td>

				</tr>

				<tr>


					<td id="meisai"><%= i + 1 %></td>

					<td id="meisai">
						<%= dtf.format(d) %>
					</td>
					<td id="meisai">
						<%= rsv.getPerson() %>
					</td>

					<td id="meisai">
						<%= rsv.getCourseName() %>
					</td>

					<td id="meisai">
						<%= rsv.getTableName() %>
					</td>

					<td id="meisai">
						<%= dtf2.format(d2) %>
 					</td>

						<form action = "ReserveUpdateSvl" method = "post">
							<td id="meisai">
								<!--1.更新ボタン  引渡し情報の処理モード(mode)に予約変更画面表示を設定-->
								<input type="submit" value="変更"/>
								<input type = "hidden" name = "rsvId" value = "<%= rsv.getRsvId() %>" />
							</td>
						</form>
						<form action = "ReserveDeleteSvl" method = "post">
							<td id="meisai">
								<!--2.取消ボタン  引渡し情報の処理モード(mode)に予約変更画面表示を設定-->
								<input type="submit" value="取消"/>
								<input type = "hidden" name = "rsvId" value = "<%= rsv.getRsvId() %>" />
							</td>
						</form>
				</tr>
<% } %>

				<tr>
					<td width="50px"></td>
					<td width="250px"></td>
					<td width="50px"></td>
					<td width="300px"></td>
					<td width="200px"></td>
					<td width="300px"></td>
					<td width="50px"></td>
					<td width="50px"></td>

				</tr>

			<tr>
				<td colspan="10"  id="boder">

					<form action = "ReserveInsertSvl" method = "post">

						<input type = "submit" value = "新規ご予約"/>
					</form>
				</td>
			</tr>
		</table>
		<br />
		<br />
		<p id="boder"><a href="StatusSvl?mode=777&usrId=<%= userInfo.getUsrId() %>">予約状況確認</a></p>
		<p id="boder"><a href="userIndex.jsp">戻る</a></p>
	</body>
</html>