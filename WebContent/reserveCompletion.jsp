<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

		<title>ご予約</title>

		<link rel="stylesheet" type="text/css" href="completion.css"/>
			<script type="text/javascript">
			<!--

				//-->
		</script>
	</head>
	<body>
		<jsp:useBean id="reserve" class="model.Reserve" scope="request"/>


		<h2><%= reserve.getUsrName() %>様、ご予約が完了いたしました。</h2>
		<br/>
		<h2><%= reserve.getRsvYyMmDd()%>  <%=reserve.getRsvHhMi() %>より</h2>
		<br/>
		<h2><%= reserve.getCourseName() %>  <%= reserve.getPerson() %>名様</h2>
		<br/>

		<h2>ご予約番号は<%= reserve.getRsvId() %>番です。</h2>
		<br/>
		<h2>ご来店の際、受付にお申し付けください。</h2>

		<br />


		<p id="boder"><a href="ReserveListSvl">予約一覧に戻る</a></p>
	</body>
</html>