var module = angular.module('learningApp', []);

module.controller('learningHomeController', function($scope, $http) {
	$scope.getRequest = function(){
		$http.get("http://localhost:8080/arcommon/services/dukaan/product/get", {headers:{'Content-Type': 'application/json','Authorization':'Basic YW5zaHVsOnBhc3N3b3Jk'}})
		.then(
				function successCallback(response){
					$scope.response = response;
					console.log(response.data);
				}, 
				function errorCallback(response){
					console.log("Unable to perform get request");
				}
        );
	};
	
	var data = '{"Product":[{"Id":"0","Name":"Biscuit","Price":200.0,"MRP":210.0,"Quantity":10},{"Id":"1","Name":"Biscuit","Price":200.0,"MRP":210.0,"Quantity":10},{"Id":"2","Name":"Biscuit","Price":200.0,"MRP":210.0,"Quantity":10},{"Id":"3","Name":"Biscuit","Price":200.0,"MRP":210.0,"Quantity":10}]}';
	$scope.postRequest = function(){
		$http.post("http://localhost:8080/arcommon/services/dukaan/product/add", data, {headers:{'Content-Type': 'application/json','Authorization':'Basic YW5zaHVsOnBhc3N3b3Jk'}})
		.then(
				function successCallback(response){
					$scope.response = response;
					console.log(response.data);
				}, 
				function errorCallback(response){
					console.log("Unable to perform post request");
				}
        );
	};
});
