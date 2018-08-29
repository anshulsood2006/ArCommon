var module = angular.module('indexApp');

module.controller('contactController', function($scope) {
    
});

module.controller('emailController', function($scope) {
	$scope.submit = function(){
		alert('Submitted');
	}
});