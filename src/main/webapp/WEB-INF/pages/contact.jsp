<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular.min.js"></script>
<meta charset="ISO-8859-1">
<style>
input.ng-invalid, textarea.ng-invalid{
    background-color:pink;
}
input.ng-valid, textarea.ng-valid{
    background-color:lightgreen;
}
</style>
<title>Contact Us</title>
</head>
<body>
<br/><br/><br/>
<p><b>If you have any question/suggestion for us. Please use the contact form below.</b></p>
<form name="contactForm" data-ng-app="contactFormApp">
    <table>
		<tr><td><b>First Name</b></td><td><input type="text" name="firstName" data-ng-model="firstName" required maxlength="20" size="49"></td></tr>
		<tr><td><b>Last Name</b></td><td><input type="text" name="lastName" data-ng-model="lastName" required maxlength="20" size="49"/></td><td></td></tr>
		<tr><td><b>Email</b></td><td><input type="email" name="email" data-ng-model="email" required maxlength="50" size="49"/></td></tr>
		<tr><td><b>Description of<br/> Query/Suggestion</b></td><td><textarea rows="4" cols="50" name="description" data-ng-model="description" required maxlength="200"></textarea></td></tr>
		<tr><td></td><td><input type="submit" value="Submit" data-ng-disabled="contactForm.firstName.$valid == false || contactForm.lastName.$valid == false || contactForm.email.$valid == false || contactForm.description.$valid == false"/></td></tr>
		<tr><td></td><td>
			<span style="color:red" data-ng-show="contactForm.firstName.$invalid">
				<span data-ng-show="contactForm.firstName.$error.required">*First Name is required.</span>
			</span>
		</td></tr>
		<tr><td></td><td>
			<span style="color:red" data-ng-show="contactForm.lastName.$invalid">
				<span data-ng-show="contactForm.lastName.$error.required">*Last Name is required.</span>
			</span>
		</td></tr>
		<tr><td></td><td>
			<span style="color:red" data-ng-show="contactForm.email.$invalid">
				<span data-ng-show="contactForm.email.$error.required">*Email is required.</span>
				<span data-ng-show="contactForm.email.$error.email">*Email is invalid.</span>
			</span>
		</td></tr>
		<tr><td></td><td>
			<span style="color:red" data-ng-show="contactForm.description.$invalid">
				<span data-ng-show="contactForm.description.$error.required">*Description is required</span>
			</span>
		</td></tr>
	</table>
</form>

</body>
</html>