<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>お客様情報変更</title>
		<link rel="stylesheet" type="text/css" href="meisai.css"/>
		<script type="text/JavaScript" src="incScript.js"></script>
		<script type="text/JavaScript">
			<!--
				//1.入力項目チェック
				function checkData(obj){
					//1.メッセージを宣言
					var msg = "";
					//2.名前が未入力の時、
					if(obj.usrName.value == null || obj.usrName.value == ""){
						//1.メッセージに"お名前を入力してください！\n"を追加
						msg += "お名前を入力してください！\n";
					}

					//8.メッセージが空白の時、
					if(msg == ""){
						//1."true"を返す。
						return true;
					}else{
					//9.メッセージが空白以外の時、
						//1.アラーとでメッセージを表示し"false"を返す。
						alert(msg);
						return false;
					}
				}
			//-->
		</script>
	</head>
	<body>
		<h1>お客様情報変更</h1>
		<br/>
		<jsp:useBean id="user" class="model.User" scope = "request" />
		<form action="UserOperationSvl" onsubmit="return checkData(this)" method="post">
<% System.out.println("userUpdate.jsp userId:" + user.getUsrId()); %>
			<table border>
				<tr>
					<th>お客様ID</th>
					<td><jsp:getProperty name="user" property="usrId"/></td>
				</tr>
				<tr>

					<th>お名前</th>
					<td><input type="text" name="usrName" size="30" maxlength="30" style="ime-mode: active;"
							value="<jsp:getProperty name="user" property="usrName"/>" />
					</td>
				</tr>
				<tr>

					<th>住 所</th>
					<td><input type="text" name="address" size="50" maxlength="200" style="ime-mode: active;"
								value="<jsp:getProperty name="user" property="address"/>"/>
					</td>
				</tr>
				<tr>

					<th>電話番号</th>
					<td><input type="text" name="phone" size="15" maxlength="20" style="ime-mode: disabled;"
									value="<jsp:getProperty name="user" property="phone"/>"/></td>
				</tr>
				<tr>

					<th>e-mail</th>
					<td><input type="text" name="mail" size="30" maxlength="100" style="ime-mode: disabled;"
								value="<jsp:getProperty name="user" property="mail"/>"/></td>
				</tr>
				<tr>

					<th>パスワード</th>
					<div >
					<td>
					<input type="password" name="password" size="8" maxlength="8" style="ime-mode: inactive;" value=""/>
					<span class="font">※変更時のみ入力してください。</span>
					</td></div>



				</tr>
				<!-- 変更：12 -->
				<input type = "hidden" name = "mode" value = "12" />
				<tr>

					<td id="sub" colspan="2">※は必修入力です。
						<input type="submit" value=" 変更 " />
					</td>
				</tr>

			</table>
		</form>
		<br />

		<p id="boder"><a href="userIndex.jsp">処理メニューに戻る</a></p>
	</body>
</html>