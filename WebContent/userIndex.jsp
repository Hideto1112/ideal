<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Restaurante IDEALLE</title>
		<link rel="stylesheet" type="text/css" href="index.css"/>
	</head>
	<body>
	<jsp:useBean id="userInfo" class="model.User" scope = "session" />

		<h2>Restaurante IDEALLE</h2>
		<br/>

		<h3>
			<jsp:getProperty name="userInfo" property="usrName" />様、いらっしゃいませ。
		</h3>


		<br />

		<p><a href="ShowMenuSvl">●メニューを見る</a></p>

		<p><a href="ReserveListSvl">●ご予約</a></p>

		<p><a href="UserUpdateSvl">●お客様情報変更</a></p>

		<p><a href="UserLogoffSvl">●ログオフ</a></p>

		<p><a href="UserDeleteSvl">●お客様脱会手続き</a></p>
	</body>
</html>