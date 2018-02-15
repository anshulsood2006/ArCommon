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
	<script src="https://rawgit.com/dwmkerr/angular-modal-service/master/dst/angular-modal-service.js"></script>
	<script src="${script}"></script>
	<link href="${style}" rel="stylesheet">
</head>

<body onLoad="scroll()" data-ng-controller="watsappController">
	<form action="/arcommon/wishesJSP" method="post">
		<table>
			<tr><td colspan="2" align="center"><input type="text" size="80" id="message" data-ng-model="message"></td></tr>
			<tr><td colspan="2" align="center"><img src="${image}" width="100%" height="100%"></img></td></tr>
			<tr><td colspan="2"><input type="hidden" name="messageType" value="0"> <!-- 1 for family and 0 for you only --></td></tr>
			<tr><td colspan="2" align="center"><a href="whatsapp://send?text=" data-ng-click="promptForName();" class="button">Share via Watsapp</a></td></tr>
		</table>
	</form>
	<div align="center">
	<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
		<!-- My Ads -->
		<ins class="adsbygoogle"
		     style="display:block"
		     data-ad-client="ca-pub-0952325864419872"
		     data-ad-slot="9422275632"
		     data-ad-format="auto"></ins>
		<script>
		(adsbygoogle = window.adsbygoogle || []).push({});
		</script>
	</div>
</body>
</html>