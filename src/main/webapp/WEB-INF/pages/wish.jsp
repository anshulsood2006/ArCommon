<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="/resources/fonts/league-gothic.regular.ttf" var="font" />
<spring:url value="/resources/styles/wish.css" var="style" />
<spring:url value="/resources/scripts/wish.js" var="script" />
<spring:url value="/resources/images/image.jpg" var="image" />

<html data-ng-app="wishApp">

<head>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular.min.js"></script>
	<script src="${script}"></script>
	<link href="${style}" rel="stylesheet">
</head>

<body data-ng-controller="watsappController">
<div class="container">
	<div class="leftContainer">
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
	<div class="centerContainer">
		<div class="headerContainer">
			<marquee behavior="alternate" class="wish">{{wishMessage}}</marquee>
		</div>
		<div class="mainContainer">
			<img src="${image}" width="99%" height="95%">
		</div>
		<div class="footerContainer">
			<button data-ng-click="populateName()" class="myButton">Share your wishes via Watsapp</button>
		</div>
	</div>
	<div class="rightContainer">
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
</div>
</body>
</html>