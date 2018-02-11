<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html data-ng-app="indexApp">
<head>
	<spring:url value="/resources/styles/index.css" var="style" />
	<spring:url value="/resources/scripts/index.js" var="script" />
	<spring:url value="/resources/scripts/contact.js" var="script1" />
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-route.min.js"></script>
	<link href="${style}" rel="stylesheet">
	<script src="${script}"></script>
	<script src="${script1}"></script>
	<title>Welcome to ${initParam.websiteNickName}</title>
</head>
<body data-ng-controller="indexController">
	<div id="header" class="header">
		<nav>
			<a href="#!/main" class="button">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			<a href="#!/products" class="button">We Offer</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="#!/contact" class="button">Contact Us</a>
		</nav>
	</div>
	<div id="main">
		<div data-ng-view></div>
	</div>
	<div id="footer" class="footer">
		<p><footer> <b>&copy; Copyright 2018 <a href="http://www.myfriendwa.com/arcommon"><i>${initParam.websiteFullName}</i></a></b></footer>
	</div>
</body>
</html>