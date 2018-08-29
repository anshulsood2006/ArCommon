var module = angular.module('wishApp',[]); 

module.config(['$locationProvider', function($locationProvider){
	$locationProvider.html5Mode({
		enabled: true,
		requireBase: false
	});
}]);

module.controller('watsappController', function($scope, $location, $window) {
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
			if (wisherName == null){
				$scope.wishMessage = wishText;
				return true;
			}
			else{
				$location.search ("from",wisherName);
				$scope.wishMessage = wisherName +" is "+ wishText;
				var str = encodeURIComponent(wisherName+ " has sent you wishes. Click here: "+ $location.absUrl());
				$window.location.href = "whatsapp://send?text="+str;
				return true;
			}
		}
	};
});