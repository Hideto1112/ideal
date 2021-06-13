<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="controller.*"%>
<%@ page import="model.*"%>
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
	color: #006799;
	font-size: 18pt;
}

th {
	text-align: left;
	background: #006799;
	color: #C8EDFF;
}

td {
	background: #C8EDFF;
}

th#bottom {
	text-align: center;
}

p {
	text-align: center;
}
-->
</style>
<script type="text/javascript">
<!--
	function dataCheck(obj) {
		var msg = "";
		if (obj.courseName.value.length < 1) {
			msg += "コース名を入力してください。\n";
		}
		if (!obj.price.value.match(/^[0-9]+$/g)) {
			msg += "価格を数値で入力してください。\n";
		}
		var i;
		for (i = 0; i < obj.orderFlg.length; i++) {
			if (obj.orderFlg[i].checked)
				break;
		}
		if (i >= obj.orderFlg.length) {
			msg += "オーダーの可否をチェックしてください\n";
		}
		if (msg.length > 0) {
			alert(msg);
			return false;
		} else {
			return true;
		}
	}
//-->
</script>
</head>
<body>
	<%
System.out.println("course insert.jsp start");
		int typeId;
		try {
			typeId = Integer.parseInt(request.getParameter("typeId"));
		} catch (NumberFormatException e) {
			typeId = 100;
		}
	%>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<jsp:useBean id="adminInfo" class="model.Admin" scope="session" />
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
	<jsp:useBean id="typeMenuList" class="java.util.ArrayList"
		scope="request" />
	<jsp:useBean id="oneCourse" class="java.util.ArrayList" scope="request" />

	<table boder>
		<form action="CourseOperationSvl" method="post"
			onSubmit="return dataCheck(this);">
			<%--表題--%>
			<caption>新しいコースを追加</caption>
			<%--コース名の表示(テキスト) --%>
			<tr>
				<th>コース名</th>
				<td><input type="text" name="courseName" size="30" /></td>
			</tr>
			<tr>
				<%--価格の表示(テキスト) --%>
				<th>価格</th>
				<td><input type="text" name="price" size="6" /></td>
			</tr>
			<%--オーダー可(ラジオボタン) --%>
			<tr>
				<th>オーダー可</th>
				<td><input type="radio" name="orderFlg" value="1" />可 <input
					type="radio" name="orderFlg" value="0" />不可</td>
			</tr>
			<%--コメント表示--%>
			<tr>
				<th>コメント</th>
				<td><textarea name="detail" rows="4" cols="30"></textarea></td>
			</tr>
			<%--前菜の表示(プルダウンメニュー)--%>
			<tr>
				<th>前菜</th>
				<td><select name="appetizerId">
						<option value="0"></option>
						<%
							for (Object o : typeMenuList) {
								Menu m = (Menu) o;
								String selected = "";
								if (typeId == m.getTypeId()) {
									selected = "selected";
								} else {
									selected = "";
								}
							if (((Menu) o).getTypeId() == Course.COURSE_MENU_TYPE_ID[0]) {
						%>
						<option value="<%=((Menu) o).getMenuId()%>" <%=selected%>>
							<%=((Menu) o).getMenuName()%>

						</option>
						<%
							}
							}
						%>
				</select></td>
			</tr>
			<tr>
				<th>スープ</th>
				<td><select name="soupId">
						<option value="0"></option>
						<%
							for (Object o : typeMenuList) {
								Menu m = (Menu) o;
								String selected = "";
								if (typeId == m.getTypeId()) {
									selected = "selected";
								} else {
									selected = "";
								}
							if (((Menu) o).getTypeId() == Course.COURSE_MENU_TYPE_ID[1]) {
						%>
						<option value="<%=((Menu) o).getMenuId()%>" <%=selected%>>
							<%=((Menu) o).getMenuName()%>

						</option>
						<%
							}
							}
						%>
				</select></td>
			</tr>
			<tr>
				<th>パスタ</th>
				<td><select name="pastaId">
						<option value="0"></option>
						<%
							for (Object o : typeMenuList) {
								Menu m = (Menu) o;
								String selected = "";
								if (typeId == m.getTypeId()) {
									selected = "selected";
								} else {
									selected = "";
								}
							if (((Menu) o).getTypeId() == Course.COURSE_MENU_TYPE_ID[2]) {
						%>
						<option value="<%=((Menu) o).getMenuId()%>" <%=selected%>>
							<%=((Menu) o).getMenuName()%>

						</option>
						<%
							}
							}
						%>
				</select></td>
			</tr>
			<tr>
				<th>肉料理</th>
				<td><select name="meatId">
						<option value="0"></option>
						<%
							for (Object o : typeMenuList) {
								Menu m = (Menu) o;
								String selected = "";
								if (typeId == m.getTypeId()) {
									selected = "selected";
								} else {
									selected = "";
								}
							if (((Menu) o).getTypeId() == Course.COURSE_MENU_TYPE_ID[3]) {
						%>
						<option value="<%=((Menu) o).getMenuId()%>" <%=selected%>>
							<%=((Menu) o).getMenuName()%>

						</option>
						<%
							}
							}
						%>
				</select></td>
			</tr>
			<tr>
				<th>魚料理</th>
				<td><select name="fishId">
						<option value="0"></option>
						<%
							for (Object o : typeMenuList) {
								Menu m = (Menu) o;
								String selected = "";
								if (typeId == m.getTypeId()) {
									selected = "selected";
								} else {
									selected = "";
								}
							if (((Menu) o).getTypeId() == Course.COURSE_MENU_TYPE_ID[4]) {
						%>
						<option value="<%=((Menu) o).getMenuId()%>" <%=selected%>>
							<%=((Menu) o).getMenuName()%>
						</option>
						<%
							}
							}
						%>
				</select></td>
			</tr>
			<tr>
				<th>デザート</th>
				<td><select name="desserId">
						<option value="0"></option>
						<%
							for (Object o : typeMenuList) {
								Menu m = (Menu) o;
								String selected = "";
								if (typeId == m.getTypeId()) {
									selected = "selected";
								} else {
									selected = "";
								}
							if (((Menu) o).getTypeId() == Course.COURSE_MENU_TYPE_ID[5]) {
						%>
						<option value="<%=((Menu) o).getMenuId()%>" <%=selected%>>
							<%=((Menu) o).getMenuName()%>
						</option>
						<%
							}
							}
						%>
				</select></td>
			</tr>
			<input type="hidden" name="mode"
				value="<%=CourseOperationSvl.INSERT%>" />
				<input type="hidden"name="typeId" value="100" />
			<tr>
				<th colspan="2" id="bottom"><input type="submit"
					value="コースをを追加" /></th>
			</tr>
	</table>
	<%--一覧表示画面へ戻る --%>
	<p>
		<a href="MenuMaintenanceSvl?typeId=<%=typeId%>">一覧表示画面へ戻る</a>
	</p>
</body>
</html>