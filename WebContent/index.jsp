<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/res.jsp" %>
<title>笔记本</title>
</head>

<body>
	<form action="${path }/TestServlet" method="post">
		请输入雇员ID：<input type="text" name="id"/>
		<input type="submit">
	</form>
<a href="bootstrap.jsp">bootstrap.jsp</a>
</body>
</html>