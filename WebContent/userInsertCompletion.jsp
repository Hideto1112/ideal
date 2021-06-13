<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>登録完了</title>
		<link rel="stylesheet" type="text/css" href="completion.css"/>
	</head>
	<body>
	<jsp:useBean id="userInfo" class="model.User" scope = "session" />

		<h2>お客様情報の登録が完了しました。</h2>
		<br />
		<br />
		<p>
			<jsp:getProperty property="usrName" name="userInfo"/>様のお客様ＩＤは
			<jsp:getProperty property="usrId" name="userInfo"/>でございます。</p>
		<h3>ログインの際に必要となりますので</h3>
		<h3>大切に保管してください。</h3>
		<br />
		<br />
		<p id="border"><a href="home.jsp">ホームページ</a></p>
	</body>
</html>