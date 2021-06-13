<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="controller.*"%>
<%@ page import="model.*"%>
<%@ include file="incFile.jsp" %>
<%@ page import="java.time.LocalDateTime"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.time.format.*" %>
<%@ page import="java.time.Period" %>
<%@ page import="java.time.temporal.TemporalAdjusters" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Status</title>
<link rel="stylesheet" type="text/css" href="status2.css"/>
<style>
<!--
table{
	margin: auto;
}

thead {
	border:1px solid;
}

.table1 tr th{
	border:1px solid;
}



-->
</style>
</head>
<body>
<jsp:useBean id="userInfo" class="model.User" scope = "session" />
<jsp:useBean id="reserve" class="model.Reserve" scope="request"/>
<jsp:useBean id="status" class="java.util.ArrayList" scope="request" />
<jsp:useBean id="baseDate" class="model.BaseDate" scope="request" />
	<%

		String base = baseDate.getBaseDate();
System.out.println("status.jsp basedate= " + base);
		LocalDate ld = LocalDate.parse(base);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy年MM月dd日");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyy年MM月");
		DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd日");
		LocalDate ld3 = ld.plusDays(1L);
System.out.println("status.jsp ld3= " + ld3);
		LocalDate nextMonth = ld3.with(TemporalAdjusters.lastDayOfMonth());
		int per = Period.between(ld, nextMonth).getDays();
System.out.println("status.jsp per= " + per);
		int cnt = 0;
	%>

	<table cellpadding="0" cellspacing="0">
		<thead>
			<tr class="table1">
				<th style="border:1px solid" rowspan="2" >
					<a href="StatusSvl?mode=7&baseDate=<%= base %>"><span>前の一週間</span></a>
				</th>
				<% if(per >= 14) { %>
				<th style="border:1px solid" colspan="14">
					<%= ld.format(dtf2) %>
				</th>
				<% }else { %>
				<th style="border:1px solid" colspan="<%= per %>">
					<% if(per >= 3) {%>
					<%= ld.format(dtf2) %>
					<% }else if(per < 3) {} %>
				</th>
				<th style="border:1px solid" colspan="<%= 14 - per %>">
					<% if((14-per) >= 3) {%>
					<%= ld.plusMonths(1).format(dtf2) %>
					<% }else if((14 - per) < 3) {} %>
				</th>
				<% } %>
				<th style="border:1px solid" rowspan="2"">
					<a href="StatusSvl?mode=77&baseDate=<%= base %>"><span>次の一週間</span></a>
				</th>
			</tr>
			<tr>
				<%
				for(int i = 0; i < 14; i++) {
					cnt++;
System.out.println("status.jsp cnt= " + cnt);
					LocalDate ld2 = LocalDate.parse(base).plusDays(i + 1);
				%>

				<th style="border:1px solid" id="day<%= cnt %>">
					<%= ld2.getDayOfMonth() %><br/>(<%= ld2.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.JAPANESE) %>)
				</th>
				<% } %>
			</tr>
		</thead>
		<tr>
			<th>
				<table cellpadding="0" cellspacing="0" >
					<tr><th>17：00</th></tr>
					<tr><th>17：15</th></tr>
					<tr><th>17：30</th></tr>
					<tr><th>17：45</th></tr>
					<tr><th>18：00</th></tr>
					<tr><th>18：15</th></tr>
					<tr><th>18：30</th></tr>
					<tr><th>18：45</th></tr>
					<tr><th>19：00</th></tr>
					<tr><th>19：15</th></tr>
					<tr><th>19：30</th></tr>
					<tr><th>19：45</th></tr>
					<tr><th>20：00</th></tr>
					<tr><th>20：15</th></tr>
					<tr><th>20：30</th></tr>
					<tr><th>20：45</th></tr>
					<tr><th>21：00</th></tr>
				</table>
			</th>
				<%
						ArrayList<Status> al = (ArrayList<Status>)status;
						int k = 0;
						for(int i = 0; i < 14;i++) {
						int day = ld.getDayOfMonth() + i + 1;
				%>
			<th>
				<%
					for(int j = 0; j < 17; j++) {
						Status sts = (Status)al.get(k);
				%>
				<table cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<% if(sts.getRsvOk() == 1) {	%>
							<a href="ReserveInsertSvl?&y=<%= sts.getRsvYy() %>&m=<%= sts.getRsvMm() %>
							&d=<%= sts.getRsvDd() %>&h=<%= sts.getRsvHh() %>&mi=<%= sts.getRsvMi() %>">
							<span>〇</span>
						<% }else if(sts.getRsvOk() == 0){ %>
							<span>☓</span>
							</a>
						<% }
							k++;
						%>
					</tr>
				</table>
				<% } %>
			</th>
				<% } %>
		</tr>
			<form name="status" action="ReserveInsertSvl" method="post">
				<input type="hidden" id="usrId" name="usrId"/>
			</form>
	</table>
	<br />
		<br />
		<div align="center">
			<p id="boder"><a href="ReserveListSvl">予約一覧に戻る</a></p>
		</div>
</body>
</html>