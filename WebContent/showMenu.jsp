<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.text.*,model.*,controller.*"%>
<% System.out.println("showmenu0"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>メニュー紹介</title>
<link rel="stylesheet" type="text/css" href="showMenu.css" />
<script type="text/javascript">
<!--
				//1.メニュー名クリック時のコメント表示、
				function showDetail(id){
					//1.引き渡されたメニュー番号の"style.display"が"block"の時、
					if(document.getElementById(id).style.display == 'block'){
						//1.引き渡されたメニュー番号の"style.display"を"none"に設定する。
						document.getElementById(id).style.display = 'none';
					}
					//2.引き渡されたメニュー番号の"style.display"が"block"以外の時、
					else{
						//1.引き渡されたメニュー番号の"style.display"を"block"に設定する。
						document.getElementById(id).style.display = 'block';
					}
				}
				//2.メニュー名クリック時のメニュー名のフォント変更、
				function change(id,val){
					//1.引き渡された色区分(val)が"0"の時
					if(val == 0){
						//1.引き渡されたメニュー番号のフォント色を"red"、フォントの太さを"bold"に設定する。
						document.getElementById(id).style.color = 'red';
						document.getElementById(id).style.fontWeight = 'bold';
					}
					//2.引き渡された色区分(val)が"0"以外の時
					else{
						//1.引き渡されたメニュー番号のフォント色を"DarkOliveGreen"、フォントの太さを"normal"に設定する。
						document.getElementById(id).style.color = 'DarkOliveGreen';
						document.getElementById(id).style.fontWeight = 'normal';
					}
				}
			//-->
		</script>

</head>
<body>
<% System.out.println("showmenu start"); %>
<jsp:useBean id = "courseList" class="java.util.ArrayList" scope ="request" />
<jsp:useBean id = "menuList" class="java.util.ArrayList" scope ="request" />
	<%
		//通貨フォーマット
		NumberFormat cf = NumberFormat.getCurrencyInstance(new Locale("ja",
				"JP"));
	%>
	<h1>メニュー紹介</h1>
	<br />

	<table cellspacing="0">
		<tr>

			<td id="title" colspan="2">■コース料理<br /> <br />
			</td>
		</tr>
		<%
			ArrayList<Course> al = Course.getOneCourseList();
		  	for(int i = 0; i < al.size() ; i++) {
		  		Course c = al.get(i);
		%>
					<tr>

					<td id="courseMenu">
						<%= c.getCourseName() %>
<% System.out.println("1" + c.getCourseName()); %>
						<div id="courseDetail">
							<%= c.getDetail() %>
<% System.out.println("2" + c.getDetail()); %>
						</div></td>

					<td id="coursePrice">
						<%= cf.format(c.getPrice()) %>
<% System.out.println("3" + cf.format(c.getPrice())); %>
					</td>
					</tr>
							<% for(int j = 0; j < courseList.size(); j++){
								c = (Course)courseList.get(j);
									if(c.getCourseId() == (i + 1)) {
							%>
							<tr>
								<td id="subMenu">
								<div id="subMenu">
										<%= c.getMenuName() %>
<% System.out.println("4" + c.getMenuName()); %>
							    </div>
								</td>
							</tr>
									<% } %>
							<% } %>
		<% } %>
		</table>
		<table>
			<tr>

				<td id="title" colspan="2">■一品料理</td>
			</tr>
<%
			ArrayList<Menu> me = Menu.getMenuList();
				int a = 0;
				for(int i = 0; i < me.size(); i++){
					Menu m = me.get(i);
				%>
				<%
	if(m.getTypeId() != a){ %>
	<% a = m.getTypeId();
	System.out.println("a="+a);
	%>
				<tr id="type">
				<td colspan="2" id="type">
					<div id="type"><%= m.getTypeName() %></div>
					<% System.out.println("1"+m.getTypeName()); %>
				</td>
			</tr>
						<% } %>
			<% if(m.getDetail() != null){ %>
						<tr>
				<td id="menu">
					<div class="menu" id="menu<%= i %>" onMouseOver="change('menu<%= i %>',0);"
						onMouseOut="change('menu<%= i %>',1);" onClick="showDetail('<%= i %>')">

						<%= m.getMenuName() %></div>
						<% System.out.println("2"+ m.getMenuName()); %>

					<div class="exp" id="<%= i %>"><%= m.getDetail() %></div>
					<% System.out.println("3" + m.getDetail()); %>
					</td>
				<td id="price"><%= cf.format(m.getPrice())%></td>
				<% System.out.println("4" +cf.format(m.getPrice()));  %>
				</tr>
			<%}else{%>
				<tr>
				<td id="menu">
				<div class="menu" ><%= m.getMenuName() %></div>
				<% System.out.println("2"+ m.getMenuName()); %>
				</td>
				<td id="price"><%= cf.format(m.getPrice())%></td>
				<% System.out.println("4" +cf.format(m.getPrice()));  %>
				</tr>
			<%} %>

			<% } %>




		</table>
		<br />


		<p>
			<a href="home.jsp">[戻る]</a>
		</p>
</body>
</html>