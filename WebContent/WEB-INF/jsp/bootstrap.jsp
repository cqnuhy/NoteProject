<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${path }/bootstrap3/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${path }/bootstrap3/css/bootstrap-theme.min.css" />
<script type="text/javascript" src="${path}/bootstrap3/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/bootstrap3/js/bootstrap.min.js"></script>
<style type="text/css">
div {
	border: solid #CCC 1px; 	
}
</style>
<title>bootstrap实例</title>
</head>
<body>
<div class="contianer">
	<div class="row">
	  <div class="col-md-1"><button type="button" class="btn btn-default">（默认样式）Default</button></div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-4">.col-md-4</div>
	</div>
	<div class="row">
	  <div class="col-md-8">.col-md-8</div>
	  <div class="col-md-4">.col-md-4</div>
	</div>
	<div class="row">
	  <div class="col-md-4">.col-md-4</div>
	  <div class="col-md-4">.col-md-4</div>
	  <div class="col-md-4">.col-md-4</div>
	</div>
	<div class="row">
	  <div class="col-md-6">.col-md-6</div>
	  <div class="col-md-6">.col-md-6</div>
	</div>
	
</div>
</body>
</html>