<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>管理者ログイン画面</title>
<link rel="stylesheet" type="text/css" href="login.css" />
<script type="text/JavaScript" src="incScript.js"></script>
<script type="text/JavaScript">
<!--
	function dataCheck(obj) {
		//1.名前、パスワードの未入力チェック
		if (obj.elements[0].value.length == 0
				|| obj.elements[1].value.length == 0) {
			//1.名前、パスワードが未入力の時、アラーとを表示し、"false"をリターンする。
			alert("お名前、パスワードは必ず入力してください。");
			return false;
		} else {
			//2.名前、パスワードがともに入力されていた時、"true"をリターンする。
			return true;
		}
	}
//-->
</script>
</head>
<body>
	<h2>管理者ログイン</h2>
	<br />
	<%
		IdealException msg = (IdealException) request.getAttribute("msg");
		if (msg != null) {
	%>
	<div>
		<%=msg.getMsg()%>
	</div>
	<%
		}
	%>

	<form name="loginForm" action="AdminLoginSvl" method="post"
		onsubmit="return dataCheck(this);">

		<table border="1">
			<tr>
				<th>管理者名</th>
				<td><input type="text" name="admName" size="10" maxlength="10"
					style="ime-mode: active:"/></td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td><input type="password" name="password" size="8"
					maxlength="8" style="ime-mode: inactive;" /></td>
			</tr>
			<tr>
				<td id="sub" colspan="2"><input type="submit" value=" 送 信 " />
				</td>
			</tr>
		</table>
	</form>
	<br />
	<p id="boder">
		<a href="home.jsp">ホームページ</a>
	</p>
</body>
</html>