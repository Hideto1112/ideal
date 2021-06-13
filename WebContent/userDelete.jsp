<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>お客様脱会手続き</title>
		<link rel="stylesheet" type="text/css" href="meisai.css"/>
	</head>
	<body>
		<jsp:useBean id="user" class ="model.User" scope="request"/>

		<h2>お客様脱会手続き</h2>
		<br/>
		<%
			IdealException msg = (IdealException)request.getAttribute("msg");

			 if(msg != null) {
		%>
			<p>
				<%= msg.getMsg() %>
			</p>

		 <% } %>
		<br/>



		<table border>
			<tr>

				<th>お客様ID</th>
				<td><jsp:getProperty property="usrId" name="user"/></td>
			</tr>
			<tr>

				<th>お名前</th>
				<td><jsp:getProperty property="usrName" name="user"/></td>
			</tr>

			<tr>

				<th>住 所</th>
				<td><jsp:getProperty property="address" name="user"/></td>
			</tr>
			<tr>

				<th>電話番号</th>
				<td><jsp:getProperty property="phone" name="user"/></td>
			</tr>
			<tr>

				<th>e-mail</th>
				<td><jsp:getProperty property="mail" name="user"/></td>
			</tr>
			<tr>

				<form action = "UserOperationSvl" method = "post">
					<td id="sub" colspan="2">お客様情報を削除します。確認してください！

						<input type = "hidden" name = "usrId" value = "<jsp:getProperty property="usrId" name="user"/>" />

						<input type = "hidden" name = "mode" value = "13" />
						<input type = "submit" value = "脱会"/>
					</td>
				</form>
			</tr>
		</table>
		<br/>
		<br/>

		<p id="boder"><a href="userIndex.jsp">戻る</a></p>
	</body>
</html>