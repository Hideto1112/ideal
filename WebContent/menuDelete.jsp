<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="controller.*" %>
<%@ page import="model.*" %>
<%@ include file="incFile.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<style>
			<!--
				body{
					background-image: url(./img/背景.jpg) ;
					background-repeat: no-repeat;
					background-attachment: fixed;
					background-size: cover;
					}
				table{text-align:center;margin:auto;}
				caption{font-size:20pt;color:#0a0a0a;}
				th{text-align:left;background-color:SlateBlue;color:Lavender;}
				td{background:#FFD7D7;}
				th#bottom{text-align:center;}
				p{text-align:center;}
				a{color: #ffd700;}
				h1{color:white;}

			-->
		</style>
     </head>
  <body style="background-image: url(./img/背景.jpg); background-size: cover">
   <%
     request.setCharacterEncoding("UTF-8");
    %>
    <jsp:useBean id = "oneMenu" class = "model.Menu" scope = "request"/>
    <%
     int typeId = oneMenu.getTypeId();
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
    <div align="center">
      <h1>メニューの削除</h1>
      <form id="frm1" name="frm1" action="MenuOperationSvl" method="post">
        <table border="1">
          <tr>
            <th>メニュー名</th>
            <td>
              <jsp:getProperty name = "oneMenu" property = "menuName"/>
            </td>
          </tr>
           <tr>
            <th>価格</th>
            <td>
              <jsp:getProperty name = "oneMenu" property = "price"/>
            </td>
          </tr>
          <tr>
            <th>オーダー可</th>

              <% int i = oneMenu.getOrderFlg();
              	if(i == 0) {
              %>
            	<td>不可</td>
              <% 	}else{ %>
              <td>可</td>
            	<% } %>


          </tr>
           <tr>
            <th>分類</th>
            <td>
              <jsp:getProperty name = "oneMenu" property = "typeName"/>
            </td>
          </tr>
           <tr>
            <th>コメント</th>
            <td>
              <%= fmtNull(oneMenu.getDetail()) %>
            </td>
          </tr>
          <input type="hidden" name="mode" value="<%= MenuOperationSvl.DELETE %>"/>
          <input type="hidden" name="typeId" value='<jsp:getProperty name = "oneMenu" property = "typeId"/>'/>
          <input type="hidden" name="menuId" value='<jsp:getProperty name = "oneMenu" property = "menuId"/>'/>
          <tr>
            <th colspan = "2" id = "bottom">
            <input type="submit" value="メニューを削除"/>
            </th>
          </tr>
        </form>
      </table>
      <p><a href ="MenuMaintenanceSvl?typeId=<%=typeId %>">一覧表示画面へ戻る</a></p>
    </div>
   </body>
</html>