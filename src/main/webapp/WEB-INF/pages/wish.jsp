<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="/resources/fonts/league-gothic.regular.ttf" var="font" />
<spring:url value="/resources/styles/wish.css" var="style" />
<spring:url value="/resources/scripts/wish.js" var="script" />
<spring:url value="/resources/images/image.jpg" var="image" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html data-ng-app="wishApp">

<head>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular.min.js"></script>
	<script src="${script}"></script>
	<link href="${style}" rel="stylesheet">
</head>

<body data-ng-controller="watsappController">
<div class="container">
	<div class="leftContainer"></div>
	<div class="centerContainer">
		<div class="headerContainer">
			<marquee behavior="alternate" class="wish">{{wishMessage}}</marquee>
		</div>
		<div class="mainContainer">
			<img src="${image}" width="99%" height="95%">
		</div>
		<div class="footerContainer">
			<a href="whatsapp://send?text=" data-ng-click="populateName()" class="button">Share via Watsapp</a>
		</div>
	</div>
	<div class="rightContainer"></div>
</div>
</body>
</html>