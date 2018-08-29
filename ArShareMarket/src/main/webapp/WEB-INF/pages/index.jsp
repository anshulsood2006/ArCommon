<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/resources/styles/index.css" var="style" />
<spring:url value="/resources/scripts/index.js" var="index" />
<spring:url value="/resources/scripts/products.js" var="products" />
<spring:url value="/resources/scripts/contact.js" var="contact" />
<spring:url value="/resources/scripts/kids/pathshala/index.js" var="contact" />

<html data-ng-app="indexApp">
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-route.min.js"></script>
	<link href="${style}" rel="stylesheet">
	<script src="${index}"></script>
	<script src="${products}"></script>
	<script src="${contact}"></script>
	<title>Welcome to ${initParam.websiteNickName}</title>
</head>
<body data-ng-controller="indexController">
<div class="container">
	<div class="leftContainer"></div>
	<div class="centerContainer">
		<div class="headerContainer">
			<nav>
				<a href="#!/main" class="button">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<a href="#!/products" class="button">Pathshala</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="#!/contact" class="button">Contact Us</a>
			</nav>
		</div>
		<div class="mainContainer">
			<div data-ng-view></div>
		</div>
		<div class="footerContainer">
			<b>&copy; Copyright 2018 <a href="http://www.myfriendwa.com/arcommon"><i>${initParam.websiteFullName}</i></a></b>
		</div>
	</div>
	<div class="rightContainer"></div>
</div>	
</body>
</html>