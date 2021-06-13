<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>hidden</title>

</head>
<body>
	<jsp:useBean id="userInfo" class="model.User"/>
	<form name="obj" action="userInsertCompletion.jsp" method="post">
		<input type="hidden"/>
			<% request.setAttribute("userInfo", "userInfo"); %>
	</form>
	<script>
		document.obj.submit();
	</script>
</body>
</html>