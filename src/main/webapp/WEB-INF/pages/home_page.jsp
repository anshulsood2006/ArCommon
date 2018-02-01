<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the index page</title>
</head>
<body>
<div data-ng-app="">
	<p>Name Here: <input type="text" data-ng-model="name" placeholder="Enter Name Here"></p>
	<h1>Hello {{name}}</h1>
	<h1>home.do is called</h1>
</div>
</body>
</html>