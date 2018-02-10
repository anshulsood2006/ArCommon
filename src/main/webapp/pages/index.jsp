<!DOCTYPE html>
<html data-ng-app="arApp">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-route.min.js"></script>
<script src="scripts/ArCommonApplication.js"></script>
<link rel="stylesheet" type="text/css" href="styles/index_style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to ${initParam.websiteNickName}</title>
</head>
<body data-ng-controller="mainController">
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