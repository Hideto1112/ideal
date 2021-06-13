<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

		<title>ご予約取消確認</title>

		<link rel="stylesheet" type="text/css" href="meisai.css"/>
	</head>
	<body>
<jsp:useBean id="userInfo" class="model.User" scope="session" />
<jsp:useBean id="reserve" class="model.Reserve" scope="request" />


		<h2>
			<jsp:getProperty name="userInfo" property="usrName" />様　ご予約取消
		</h2>
		<br/>



		<table border>
			<tr>

				<th>ご予約番号</th>
				<td>
					<jsp:getProperty name="reserve" property="rsvId" />
				</td>
			</tr>
			<tr>

				<th>日付</th>
				<td>
					<jsp:getProperty name="reserve" property="rsvYyMmDd" />
				</td>
			</tr>
			<tr>

				<th>時刻</th>
				<td>
					<jsp:getProperty name="reserve" property="rsvHhMi" />
				</td>
			</tr>
			<tr>

				<th>人数</th>
				<td>
					<jsp:getProperty name="reserve" property="person" />
				</td>
			</tr>
			<tr>

				<th>コース</th>
				<td>
					<jsp:getProperty name="reserve" property="courseName" />
				</td>
			</tr>
			<tr>

				<th>テーブル</th>
				<td>
					<jsp:getProperty name="reserve" property="tableName" />
				</td>
			</tr>
			<tr>


				<form action = "ReserveOperationSvl" method = "post">
					<td id="sub" colspan="2">ご予約を取消します。確認後、取消しボタンを押してください。

						<input type = "hidden" name = "rsvId" value = "<jsp:getProperty name="reserve" property="rsvId" />" />

						<input type = "hidden" name = "mode" value = "13" />
						<input type = "submit" value = "取消"/>
					</td>
				</form>
			</tr>
		</table>
		<br />
		<br />

		<p id="boder"><a href="ReserveListSvl">予約一覧に戻る</a></p>
	</body>
</html>