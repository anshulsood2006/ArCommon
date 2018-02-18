var module = angular.module('wishApp',[]); 

module.controller('watsappController', function($scope, $location) {
	
	var wisherName = $location.search().from;
	var wishText = " wishing you Happy Holi";
	if (typeof wisherName == "undefined" || wisherName == ""){
		wisherName = "";
		$scope.wishMessage = wishText ;
	}
	else{
		$scope.wishMessage = wisherName +" is "+ wishText; ;
	}
	
	$scope.populateName = function () {
		wisherName = prompt("Please enter your name:", "");
		if (typeof wisherName == "undefined" || wisherName == ""){
			alert("Name is mandatory");
			return false;
		}
		else{
			$location.search ("from",wisherName);
			$scope.wishMessage = wisherName +" is "+ wishText;
			sendViaWatsapp();
		}
	};
});

function sendViaWatsapp(){
	var url = document.URL;
	var urlParams = new URLSearchParams(window.location.search);
	var str = encodeURIComponent(urlParams.get("from")+ " has sent you wishes. Click here: "+url);
	window.location = "whatsapp://send?text="+str;
}