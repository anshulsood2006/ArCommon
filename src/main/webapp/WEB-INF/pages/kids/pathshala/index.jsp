<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="/resources/scripts/kids/pathshala/index.js" var="script" />
<spring:url value="/resources/styles/kids/pathshala/index.css" var="style" />
<spring:url value="/resources/images/kids/pathshala/" var="image" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular.min.js"></script>
<link href="${style}" rel="stylesheet">
	<script src="${script}"></script>
<title>Welcome to the home page of kids Pathshala</title>
</head>
<body>
	<div class="mainContainer">
		<div class="mainContainerHeader"><br/>Presidents of India</div>
		<div class="mainContainerContent" data-ng-controller="imagesController">
		<a href="" class="previous round" data-ng-click="previous()"><b>&lt;&lt; Previous</b></a>
		<div class="content">{{rank}}<br/>{{name}}</div>
			<a href="" class="next round" data-ng-click="next()"><b>Next &gt;&gt;</b></a>
		</div>
	</div>
</body>
</html>