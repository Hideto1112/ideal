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
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="adminInfo" class="model.Admin" scope = "session" />
		<h2>管理者処理選択</h2>
		<br/>

		<h3><jsp:getProperty name="adminInfo" property="admName" />様、いらっしゃいませ。</h3>


		<br />
		<p><a href="MenuMaintenanceSvl">●メニューメンテナンス</a></p>
		<p><a href="AdminLogoffSvl">●ログオフ</a></p>
</body>
</html>