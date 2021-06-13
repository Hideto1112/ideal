<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="controller.*"%>
<%@ page import="model.*"%>
<%@ include file="incFile.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Course Update</title>
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
		int typeId;
		try {
			typeId = Integer.parseInt(request.getParameter("typeID"));
		} catch (NumberFormatException e) {
			typeId = 100;
		}
	%>
	<jsp:useBean id="typeMenuList" class="java.util.ArrayList" scope="request" />
	<jsp:useBean id="oneCourse" class="java.util.ArrayList" scope="request" />
	<table boder>
			<%--表題--%>
			<caption>コースの更新</caption>
			<form action="CourseOperationSvl" method="post" onSubmit="return dataCheck(this);">
			<%--コース名の表示(テキスト) --%>
			<tr>
				<th>コース名</th>
				<td><input type="text" name="courseName" size="30"
				value="<%= ((Course)oneCourse.get(0)).getCourseName() %>" />
				</td>
			</tr>
			<tr>
				<%--価格の表示(テキスト) --%>
				<th>価格</th>
				<td><input type="text" name="price" size="10"
				value="<%= ((Course)oneCourse.get(0)).getPrice() %>"/>
				</td>
			</tr>
			<%--オーダー可(ラジオボタン) --%>
			<tr>
				<th>オーダー可</th>
				<% String[] order={"不可","可"}; %>
				<td>
				<% for(int i=0 ;i<order.length ;i++){
					String checked="";
					if(((Course)oneCourse.get(0)).getOrderFlg()==i){
					checked="checked";
					}%>
					<input type="radio" name="orderFlg" value="<%= i %>"<%= checked %>/>
					<%= order[i] %>&nbsp;&nbsp;&nbsp;
				<% } %>
				</td>
			</tr>
			<%--コメント表示--%>
			<tr>
				<th>コメント</th>
				<td><textarea name="detail" rows="4" cols="30">
				<%= fmtNull(((Course)oneCourse.get(0)).getDetail()) %></textarea>
				</td>
			</tr>
			<%--前菜の表示(プルダウンメニュー)--%>
			<tr>
				<th>前菜</th>
				<td><select name="appetizerId">
						<%
							for (Object o : typeMenuList) {
								String selected = "";

								Menu m = (Menu) o;

							if(m.getTypeId() == Course.getCOURSE_MENU_TYPE_ID()[0]) {

								for(int i = 0; i < oneCourse.size();i++) {
									Course c = (Course)oneCourse.get(i);
System.out.println("courseupdate.jst onecourse" + c.getMenuId());
System.out.println("courseupdate.jst menu" + m.getMenuId());
									if(m.getMenuId() == c.getMenuId()) {
										selected = "selected";
									}
								}
						%>
<% System.out.println("courseupdate.jst selected " + selected); %>
						<option value="<%=m.getMenuId()%>" <%= selected %>>
							<%=m.getMenuName()%>

						</option>
						<%
							}
							}
						%>
				</select></td>
			</tr>
			<th>スープ</th>
			<td><select name="soupId">
							<%
							for (Object o : typeMenuList) {
								String selected = "";

								Menu m = (Menu) o;

							if(m.getTypeId() == Course.getCOURSE_MENU_TYPE_ID()[1]) {

								for(int i = 0; i < oneCourse.size();i++) {
									Course c = (Course)oneCourse.get(i);
System.out.println("courseupdate.jst onecourse" + c.getMenuId());
System.out.println("courseupdate.jst menu" + m.getMenuId());
									if(m.getMenuId() == c.getMenuId()) {
										selected = "selected";
									}
								}
						%>
<% System.out.println("courseupdate.jst selected " + selected); %>
						<option value="<%=m.getMenuId()%>" <%= selected %>>
							<%=m.getMenuName()%>

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
											<%
							for (Object o : typeMenuList) {
								String selected = "";

								Menu m = (Menu) o;

							if(m.getTypeId() == Course.getCOURSE_MENU_TYPE_ID()[2]) {

								for(int i = 0; i < oneCourse.size();i++) {
									Course c = (Course)oneCourse.get(i);
System.out.println("courseupdate.jst onecourse" + c.getMenuId());
System.out.println("courseupdate.jst menu" + m.getMenuId());
									if(m.getMenuId() == c.getMenuId()) {
										selected = "selected";
									}
								}
						%>
<% System.out.println("courseupdate.jst selected " + selected); %>
						<option value="<%=m.getMenuId()%>" <%= selected %>>
							<%=m.getMenuName()%>

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
											<%
							for (Object o : typeMenuList) {
								String selected = "";

								Menu m = (Menu) o;

							if(m.getTypeId() == Course.getCOURSE_MENU_TYPE_ID()[3]) {

								for(int i = 0; i < oneCourse.size();i++) {
									Course c = (Course)oneCourse.get(i);
System.out.println("courseupdate.jst onecourse" + c.getMenuId());
System.out.println("courseupdate.jst menu" + m.getMenuId());
									if(m.getMenuId() == c.getMenuId()) {
										selected = "selected";
									}
								}
						%>
<% System.out.println("courseupdate.jst selected " + selected); %>
						<option value="<%=m.getMenuId()%>" <%= selected %>>
							<%=m.getMenuName()%>

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
											<%
							for (Object o : typeMenuList) {
								String selected = "";

								Menu m = (Menu) o;

							if(m.getTypeId() == Course.getCOURSE_MENU_TYPE_ID()[4]) {

								for(int i = 0; i < oneCourse.size();i++) {
									Course c = (Course)oneCourse.get(i);
System.out.println("courseupdate.jst onecourse" + c.getMenuId());
System.out.println("courseupdate.jst menu" + m.getMenuId());
									if(m.getMenuId() == c.getMenuId()) {
										selected = "selected";
									}
								}
						%>
<% System.out.println("courseupdate.jst selected " + selected); %>
						<option value="<%=m.getMenuId()%>" <%= selected %>>
							<%=m.getMenuName()%>

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
											<%
							for (Object o : typeMenuList) {
								String selected = "";

								Menu m = (Menu) o;

							if(m.getTypeId() == Course.getCOURSE_MENU_TYPE_ID()[5]) {

								for(int i = 0; i < oneCourse.size();i++) {
									Course c = (Course)oneCourse.get(i);
System.out.println("courseupdate.jst onecourse" + c.getMenuId());
System.out.println("courseupdate.jst menu" + m.getMenuId());
									if(m.getMenuId() == c.getMenuId()) {
										selected = "selected";
									}
								}
						%>
<% System.out.println("courseupdate.jst selected " + selected); %>
						<option value="<%=m.getMenuId()%>" <%= selected %>>
							<%=m.getMenuName()%>

						</option>
						<%
							}
							}
						%>
				</select></td>
			</tr>
			<input type="hidden" name="mode" value="<%=CourseOperationSvl.UPDATE%>"/>

			<input type="hidden" name="courseId"value='<%= ((Course)oneCourse.get(0)).getCourseId() %>'/>
			<input type="hidden" name="typeId" value="100" />
			<tr>
			<th colspan="2" id="bottom"><input type="submit" value="コースを更新" /></th>
			</tr>
		</form>
	</table>
	<%--一覧表示画面へ戻る --%>
	<p>
		<a href="MenuMaintenanceSvl?typeId=<%=typeId%>">一覧表示画面へ戻る</a>
	</p>
</body>
</html>