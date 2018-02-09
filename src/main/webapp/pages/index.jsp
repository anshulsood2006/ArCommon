<!DOCTYPE html>
<html data-ng-app="arApp">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-route.min.js"></script>
<script src="scripts/ArCommonApplication.js"></script>
<link rel="stylesheet" type="text/css" href="styles/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to ${initParam.websiteNickName}</title>
</head>
<body data-ng-controller="mainController">
	<div id="header" class="header">
		<nav>
			<a href="#!/main">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			<a href="#!/about">About Us</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			<a href="#!/contact">Contact Us</a>
		</nav>
	</div>
	<div id="main">
		<div data-ng-view></div>
	</div>
	<div id="footer" class="footer">
		<p><footer>&copy; Copyright 2018 <a href="http://www.myfriendwa.com/pages/index.jsp"><i>${initParam.websiteFullName}</i></a></footer>
	</div>
</body>
</html>