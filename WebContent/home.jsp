<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Restaurante IDEALLE</title>
		<link rel="stylesheet" type="text/css" href="index.css"/>
	</head>
	<body>


		<h2>■ Restaurante IDEALLE ■</h2>

		<%
				IdealException msg = (IdealException)request.getAttribute("msg");
				if(msg != null) {
			%>
				<p>
					<%= msg.getMsg() %>
				</p>
			<% } %>

		<br />


		<p><a href="ShowMenuSvl">●メニューを見る</a></p>

		<p><a href="userLogin.jsp">●ログイン</a></p>

		<p><a href="userInsert.jsp">●新規お客様登録</a></p>
		<br />

		<p><a href="adminLogin.jsp">●管理者ログイン</a></p>
	</body>
</html>