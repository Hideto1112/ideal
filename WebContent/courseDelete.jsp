<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="controller.*" %>
<%@ page import="model.*" %>
<%@ include file="incFile.jsp" %>
<% System.out.println("coursedel start"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<style>
<!--
table {
	margin: auto;
}

caption {
	color: #990000;
	font-size: 18pt;
}

th {
	text-align: left;
	background: #990000;
	color: #FFD7D7;
}

td {
	background: #FFD7D7;
	text-align: left;
	padding-left: 10px;
}

th#bottom {
	text-align: center;
}

p {
	text-align: center;
}
-->
</style>
</head>
<body>
<% System.out.println("coursedel start2"); %>
<jsp:useBean id="typeMenuList" class="java.util.ArrayList" scope="request"/>
<jsp:useBean id="oneCourse" class="java.util.ArrayList" scope="request" />
<% System.out.println("coursedel start31"); %>
<table border>

<%--タイトル --%>
<caption>コースの削除</caption>
<%--コース名 --%>
<%
	NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("ja",
			"JP"));
	int typeId = Integer.parseInt(request.getParameter("typeId"));
	Course c1 = (Course)oneCourse.get(0);
	int cId = c1.getCourseId();
%>
<form action="CourseOperationSvl" method="post">
<tr>
<th>コース名</th>
	<td>
		<%= c1.getCourseName() %>
	</td>
<% System.out.println("coursedel start4"); %>
</tr>
<%--価格 --%>
<tr>
<th>価格</th>
	<td>
			<%= nf.format(c1.getPrice()) %>
	</td>
</tr>
<%--オーダー可--%>
<tr>
<th>オーダー可</th>
	<%
		int flg = c1.getOrderFlg();
		if(flg == 0) {
	%>
	<td>不可</td>
	<% }else{ %>
	<td>可</td>
	<% } %>
</tr>
<%--コメント --%>
<tr>
<th>コメント</th>
	<td>
		<%= c1.getDetail() %>
	</td>
</tr>
<%--前菜 --%>
<tr>
<th>前菜</th>
	<td>
		<%
		for(int i = 0; i < oneCourse.size(); i++) {
			Course c = (Course)oneCourse.get(i);
		%>
				<% if(c.getTypeId() == Course.getCOURSE_MENU_TYPE_ID()[0]) { %>
		<%= c.getMenuName() %>
		<% } %>
		<% } %>
	</td>
</tr>
<%--スープ --%>
<tr>
<th>スープ</th>
	<td>
		<%
		for(int i = 0; i < oneCourse.size(); i++) {
			Course c = (Course)oneCourse.get(i);
		%>
				<% if(c.getTypeId() == Course.getCOURSE_MENU_TYPE_ID()[1]) { %>
		<%= c.getMenuName() %>
		<% } %>
		<% } %>
	</td>
</tr>
<%--パスタ --%>
<tr>
<th>パスタ</th>
	<td>
		<%
		for(int i = 0; i < oneCourse.size(); i++) {
			Course c = (Course)oneCourse.get(i);
		%>
				<% if(c.getTypeId() == Course.getCOURSE_MENU_TYPE_ID()[2]) { %>
		<%= c.getMenuName() %>
		<% } %>
		<% } %>
	</td>
</tr>
<%--肉料理 --%>
<tr>
<th>肉料理</th>
	<td>
		<%
		for(int i = 0; i < oneCourse.size(); i++) {
			Course c = (Course)oneCourse.get(i);
		%>
				<% if(c.getTypeId() == Course.getCOURSE_MENU_TYPE_ID()[3]) { %>
		<%= c.getMenuName() %>
		<% } %>
		<% } %>
	</td>
</tr>
<%--魚料理 --%>
<tr>
<th>魚料理</th>
	<td>
		<%
		for(int i = 0; i < oneCourse.size(); i++) {
			Course c = (Course)oneCourse.get(i);
		%>
				<% if(c.getTypeId() == Course.getCOURSE_MENU_TYPE_ID()[4]) { %>
		<%= c.getMenuName() %>
		<% } %>
		<% } %>
	</td>
</tr>
<%--デザート --%>
<tr>
<th>デザート</th>
	<td>
		<%
		for(int i = 0; i < oneCourse.size(); i++) {
			Course c = (Course)oneCourse.get(i);
		%>
				<% if(c.getTypeId() == Course.getCOURSE_MENU_TYPE_ID()[5]) { %>
		<%= c.getMenuName() %>
		<% } %>
		<% } %>
	</td>
</tr>

<%--ボタン --%>
<th colspan = "2" id = "bottom">
	<input type = "submit" value = "削除"/>
</th>

<input type = "hidden" name = "mode" value = "<%= CourseOperationSvl.DELETE %>" />
<input type = "hidden" name = "typeId" value= "<%= typeId %>" />
<input type = "hidden" name = "courseId" value= "<%= cId %>" />
</form>
</table>
	<p>
		<a href="MenuMaintenanceSvl?typeId=<%= typeId %>">一覧表示画面へ戻る</a>
	</p>
</body>
</html>