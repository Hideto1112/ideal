<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="controller.*" %>
<%@ page import="model.*" %>
<%@ include file="incFile.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Menu Maintenance</title>

<style>
<!--
body {
	background-image: url(./img/背景.jpg);
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}

table {
	text-align: center;
	margin: auto;
}

caption {
	font-size: 18pt;
	color: white;
}

tr#data0 {
	background: #E3FFE3;
}

tr#data1 {
	background: #A4FFDB;
}

th {
	background: #007B66;
	color: #ECFFF3;
}

td {
	text-align: center;
	vertical-align: top;
	white-space: nowrap;
}

#code {
	width: 40px;
	text-align: center;
}

#menu {
	width: 250px;
}

#price {
	width: 60px;
	text-align: center;
	padding-right: 5px;
}

#comm {
	width: 400px;
}

#ord {
	width: 100px;
	text-align: center;
}

#btn {
	width: 100px;
}

h1 {
	text-align: center;
	background: #007B66;
	color: #ECFFF3;
}

div#type1 {
	width: 140px;
	border: solid gray 1px;
	background: #E3FFE3;
	color: #007B53;
	padding: 2px;
	cursor: pointer;
	margin-top: 5px;
}

div#type2 {
	width: 140px;
	border: solid gray 1px;
	background: #007B53;
	color: #E3FFE3;
	padding: 2px;
	cursor: pointer;
	margin-top: 5px;
}
-->
</style>

</head>
<body>
	<h1>=== メニューマスターメンテナンス ===</h1>

	<%
		String[] order = { "不可", "可" };
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("ja",
				"JP"));
		int typeId;
		String style = "id = 'type1'";
		try {
			typeId = Integer.parseInt(request.getParameter("typeId"));
		} catch (NumberFormatException e) {
			typeId = 100;
		}
	%>
	<jsp:useBean id="mType" class="java.util.ArrayList" scope="request" />
	<jsp:useBean id="menu" class="java.util.ArrayList" scope="request" />
	<table>
		<tr>
			<td id="outer">
				<%
					for (int i = 0; i < mType.size(); i++) {
						MenuType mt = (MenuType) mType.get(i);
						if (typeId == mt.getTypeId()) {
							style = " id = 'type2'";
						} else {
							style = " id = 'type1'";
						}
				%>
				<form name="frm<%=i%>" action="MenuMaintenanceSvl" method="post">
					<input type="hidden" name="typeId" value="<%=mt.getTypeId()%>"/>
					<div <%=style%> onclick="document.frm<%=i%>.submit();">
						<%=mt.getTypeName()%>

					</div>

				</form> <%
 	}
 %>
			</td>
			<td id="outer">
				<table>
					<caption>
						&lt;&lt;&lt;
						<%
							try {
						%>
						<%=((Menu) menu.get(0)).getTypeName()%>
						<%
							} catch (Exception e) {
						%>
						メニューがありません。
						<%
							}
						%>
						&gt;&gt;&gt;
					</caption>

					<tr>
						<th id="code">ID</th>
						<th id="menu">メニュー</th>
						<th id="price">価格</th>
						<th id="comm">コメント</th>
						<th id="ord">オーダー可</th>
						<th id="btn" colspan="2"></th>
					</tr>
					<%
						for (int i = 0; i < menu.size(); i++) {
							Menu m = (Menu) menu.get(i);
					%>

					<tr id="data<%=i % 2%>">
						<td id="code"><%=m.getMenuId()%></td>
						<td id="menu"><%=m.getMenuName()%></td>
						<td id="price"><%=nf.format(m.getPrice())%></td>
						<td id="comm"><%=fmtNull(m.getDetail())%></td>
						<td id="ord"><%=order[m.getOrderFlg()]%></td>
						<form action="MenuUpdateSvl" method="post">
							<td><input type="submit" value="更新" />
							</td>
							<!-- 隠しフィールド -->
							<input type="hidden" name="mode" /> <input type="hidden"
								name="menuId" value="<%=m.getMenuId()%>" /> <input
								type="hidden" name="typeId" value="<%=typeId%>" />
						</form>
						<form action="MenuDeleteSvl" method="post">
							<td><input type="submit" value="削除" />
							</td>
							<!-- 隠しフィールド -->
							<input type="hidden" name="mode" /> <input type="hidden"
								name="menuId" value="<%=m.getMenuId()%>" />
						 <input type="hidden" name="typeId" value="<%=typeId%>" />
						</form>

					</tr>
					<%
						}
					%>
					<tr>
						<form action="MenuInsertSvl" method="post">
							<th colspan="7">
							<input type="hidden" name="typeId"value="<%=typeId%>" />
							<input type="hidden" name="mode"/>
							<input type="submit"value="新しいメニューの追加" />
							</th>
						</form>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<div align="center">
		<p id="boder"><a href="adminIndex.jsp">管理者処理選択に戻る</a></p>
	</div>
</body>
</html>