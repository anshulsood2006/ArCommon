<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="/resources/styles/dukaan/index.css" var="style" />
<spring:url value="/resources/scripts/dukaan/index.js" var="script" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular.min.js"></script>
	<link href="${style}" rel="stylesheet">
	<script src="${script}"></script>
<title>Welcome to home page of Apki Apni Dukaan</title>
</head>
<body data-ng-app="dukaanApp">
	<div class="mainContainer">
		<div class="mainContainerHeader"><br/>Place Your Order Here</div>
		<div class="mainContainerContent">
			<div class="content">	
				<form data-ng-app="myApp" data-ng-controller="dukaanIndexController" name="myForm" novalidate>
					<p><b>Name:</b>
						<input type="text" name="user" data-ng-model="user" required>
						<span style="color:red" data-ng-show="myForm.user.$dirty && myForm.user.$invalid">
						<span data-ng-show="myForm.user.$error.required">Name is required.</span>
						</span>
					</p>
					<p><b>Email:</b>
						<input type="email" name="email" data-ng-model="email" required>
						<span style="color:red" data-ng-show="myForm.email.$dirty && myForm.email.$invalid">
						<span data-ng-show="myForm.email.$error.required">Email is required.</span>
						<span data-ng-show="myForm.email.$error.email">Invalid email address.</span>
						</span>
					</p>
					<p><b>Phone:</b>
						<input type="text" name="phone" data-ng-model="phone" required onkeypress='return event.charCode >= 48 && event.charCode <= 57' maxlength="10">
						<span style="color:red" data-ng-show="myForm.phone.$dirty && myForm.phone.$invalid">
						<span data-ng-show="myForm.phone.$error.required">Phone number is required.</span>
						</span>
					</p>
					<p><b>Address:</b>
						<textarea rows="4" cols="50" name="address" data-ng-model="address" required></textarea>
						<span style="color:red" data-ng-show="myForm.address.$dirty && myForm.address.$invalid">
						<span data-ng-show="myForm.address.$error.required">Address is required.</span>
						</span>
					</p>
					<p><b>Order:</b>
						<textarea name="order" data-ng-model="order" required rows="5" cols="50"></textarea>
						<span style="color:red" data-ng-show="myForm.order.$dirty && myForm.order.$invalid">
						<span data-ng-show="myForm.order.$error.required">Order is required.</span>
						</span>
					</p>
					<p>
						<button data-ng-disabled="myForm.user.$invalid || myForm.email.$invalid || myForm.phone.$invalid || myForm.address.$invalid || myForm.order.$invalid || buttonPress" data-ng-click="sendMail()"><b>Place Your Order</b></button>
					</p>
					<div style="color:red; text-align: center;">{{message}}</div>
				</form>
			</div>
		</div>
	</div>
	<div class="footerContainer">
		<b>&copy; Copyright 2018 <a href="http://www.myfriendwa.com/arcommon"><i>${initParam.websiteFullName}</i></a></b>
	</div>
</body>
</html>