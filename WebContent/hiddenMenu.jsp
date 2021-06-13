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
<title>hidden</title>

</head>
<body>
<% System.out.println("hiddencourse start"); %>
	<jsp:useBean id="typeId" class="model.Menu"/>
	<form name="obj" action="MenuMaintenanceSvl" method="post">
		<input type="hidden" />
		<% request.setAttribute("typeId", "typeId"); %>
	</form>
	<script>
		document.obj.submit();
	</script>
</body>
</html>