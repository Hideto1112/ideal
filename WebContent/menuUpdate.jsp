<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="controller.*"%>
<%@ page import="model.*"%>
<%@ include file="incFile.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Menu Update</title>
<%--見た目(CSS) --%>
<style>
<!--
body {
	background-image: url(./img/背景.jpg);
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}

table {
	margin: auto;
}

caption {
	color: #0a0a0a;
	font-size: 20pt;
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

a {
	color: #ffd700;
}

h1 {
	text-align: center;
	color: white;
}
-->
</style>
<%--チェックフォーム(JavaScript) --%>
<script type="text/javascript">
<!--
	function dataCheck(obj) {
		var msg = ""; //aleatボックスに表示する文字列を代入する変数を「""」で初期化

		if (obj.menuName.value.length < 1) { //menuNameの文字列の長さが1未満の場合
			msg += "メニュー名を入力してください。\n"; //msgに文字列を追加
		}
		if (!obj.price.value.match(/^[0-9]+$/g)) { //priceが数値の連続ではない場合
			msg += "価格を数値で入力してください。\n"; //msgに文字列を追加
		}
		var i; //ラジオボタンのチェック判定
		for (i = 0; i < obj.orderFlg.length; i++) { //同名のラジオボタンは内部的に配列になっている
			if (obj.orderFlg[i].checked)
				break; //i番目の要素がチェックされていればループ終了
		}
		if (i >= obj.orderFlg.length) { //ループカウンターを評価し最後までループしていれば未チェック
			msg += "オーダーの可否をチェックしてください。\n"; //
		}

		if (msg.length > 0) { //msg変数の長さを判定し文字が代入されている場合
			alert(msg); //alertボックスに内容を表示しfalseを返す
			return false;
		} else { //それ以外はtrueを返す
			return true;
		}
	}
//-->
</script>
</head>
<body>
	<%--インスタンス生成するための設定とデータベース受け取り時の例外処理 --%>
	<%
		request.setCharacterEncoding("utf-8");
		int typeId;
		try {
			typeId = Integer.parseInt(request.getParameter("typeId"));
		} catch (NumberFormatException e) {
			typeId = 200;
		}
	%>
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
	<jsp:useBean id="oneMenu" class="model.Menu" scope="request" />
	<jsp:useBean id="mType" class="java.util.ArrayList" scope="request" />
	<table border>
		<%--表題 --%>
		<h1>メニューの更新</h1>
		<form action="MenuOperationSvl" method="post"
			onsubmit="return dataCheck(this);">
			<%--メニュー名の表示(テキスト) --%>
			<tr>
				<th>メニュー名</th>
				<td><input type="text" name="menuName" size="30"
					value='<jsp:getProperty name="oneMenu" property="menuName"/>' /></td>
			</tr>
			<%--価格の表示(テキスト) --%>
			<tr>
				<th>価格</th>
				<td><input type="text" name="price" size="10"
					value='<jsp:getProperty name ="oneMenu" property="price"/>' /></td>
			</tr>
			<%--オーダー可の表示(ラジオボタン) --%>
			<tr>
				<th>オーダー可</th>
				<%
					String[] order = { "不可", "可" };
				%>
				<td>
					<%
						for (int i = 0; i < order.length; i++) {
							String checked = "";
							if (oneMenu.getOrderFlg() == i) {
								checked = "checked";
							}
					%> <input type="radio" name="orderFlg" value="<%=i%>" <%=checked%> />
					<%=order[i]%>&nbsp;&nbsp;&nbsp; <%
 	}
 %>
				</td>
			</tr>
			<%--分類表示(プルダウンメニュー) --%>
			<tr>
				<th>分類</th>
				<td><select name="typeId">
						<%
							for (Object o : mType) {
								MenuType mt = (MenuType) o;
								String selected = "";
								if(mt.getTypeId()>=200){
								if (typeId == mt.getTypeId()) {
									selected = "selected";
								} else {
									selected = "";
								}
						%>
						<option value="<%=mt.getTypeId()%>" <%=selected%>>
							<%=((MenuType) o).getTypeName()%>
						</option>
						<%
								}
							}
						%>
				</select></td>
			</tr>
			<%--コメントの表示(複数行のテキスト) --%>
			<tr>
				<th>コメント</th>
				<td><textarea name="detail" cols="30" rows="4">
<%=fmtNull(oneMenu.getDetail())%></textarea></td>
			</tr>
			<input type="hidden" name="mode" value="<%=MenuOperationSvl.UPDATE%>" />
			<input type="hidden" name="menuId"
				value='<jsp:getProperty name = "oneMenu" property = "menuId"/>' />
			<input type="hidden" name="typeId"
				value='<jsp:getProperty name = "oneMenu" property = "typeId"/>' />
			<tr>
				<th colspan="2" id="bottom"><input type="submit"
					value="メニューを更新" /></th>
			</tr>
		</form>
	</table>
	<%--一覧表示画面へ戻る --%>
	<p>
		<a href="MenuMaintenanceSvl?typeId=<%= typeId %>">一覧表示画面へ戻る</a>
	</p>
</body>
</html>