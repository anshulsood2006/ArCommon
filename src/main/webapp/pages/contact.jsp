<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular.min.js"></script>
<meta charset="ISO-8859-1">
<script src="scripts/ContactForm.js"></script>
<title>Contact Us</title>
</head>
<body>
<br/><br/><br/>
<form name="contactForm" data-ng-app="contactFormApp" novalidate>
    <table>
		<tr><td><b>First Name</b></td><td><input type="text" name="firstName" data-ng-model="firstName" required/></td></tr>
		<tr><td><b>Last Name</b></td><td><input type="text" name="lastName" data-ng-model="lastName" required/></td><td></td></tr>
		<tr><td><b>Email</b></td><td><input type="email" name="email" data-ng-model="email" required/></td></tr>
		<tr><td><b>Description</b></td><td><textarea rows="4" cols="50" name="description" data-ng-model="description" required></textarea></td></tr>
		<tr><td></td><td><input type="submit" value="Submit"/></td></tr>
		<tr><td></td><td>
			<span style="color:red" data-ng-show="contactForm.firstName.$dirty && contactForm.firstName.$invalid">
				<span data-ng-show="contactForm.firstName.$error.required">*First Name is required.</span>
			</span>
		</td></tr>
		<tr><td></td><td>
			<span style="color:red" data-ng-show="contactForm.lastName.$dirty && contactForm.lastName.$invalid">
				<span data-ng-show="contactForm.lastName.$error.required">*Last Name is required.</span>
			</span>
		</td></tr>
		<tr><td></td><td>
			<span style="color:red" data-ng-show="contactForm.email.$dirty && contactForm.email.$invalid">
				<span data-ng-show="contactForm.email.$error.required">*Email is required.</span>
				<span data-ng-show="contactForm.email.$error.email">*Email is invalid.</span>
			</span>
		</td></tr>
		<tr><td></td><td>
			<span style="color:red" data-ng-show="contactForm.description.$dirty && contactForm.description.$invalid">
				<span data-ng-show="contactForm.description.$error.required">*Description is required</span>
			</span>
		</td></tr>
	</table>
</form>
</body>
</html>