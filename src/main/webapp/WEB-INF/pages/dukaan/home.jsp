<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="/resources/styles/dukaan/home.css" var="style" />
<spring:url value="/resources/scripts/dukaan/home.js" var="script" />
<html data-ng-app="dukaanApp">
	<head>
		<link href="${style}" rel="stylesheet">
		<script src="${initParam.angularJsURL}"></script>
		<script src="${script}"></script>
		<title>Welcome to home page of Apki Apni Dukaan</title>
	</head>
	<body>
		<div class = "header">
			<a href="#home">Home</a>
			<a href="#login">Login</a>
		  	<a href="#products">Products</a>
		  	<a href="#contact">Contact</a>
		  	<a href="#about">About</a>
		</div> 
		
		<div class = "main">
			<div class="left"></div>
			<div class = "content" data-ng-controller="dukaanHomeController">
			</div>
			<div class="right">
			</div>
		</div>
		
		<div class = "footer">
			<b>&copy; Copyright 2018 <a href="${initParam.websiteURL}"><i>${initParam.websiteFullName}</i></a></b>
		</div> 
	</body>
</html>