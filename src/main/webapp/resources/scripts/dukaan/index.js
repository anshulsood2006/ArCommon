var module = angular.module('dukaanApp', []);

module.controller('dukaanIndexController', function($scope, $http) {
	
	$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
	  
	$scope.sendMail = function () {
		$scope.itemList = [];
        var order = {};
        order.name = $scope.user;
        order.email = $scope.email;
        order.phone = $scope.phone;
        order.address = $scope.address;
        order.order = $scope.order;
		$scope.itemList.push(order);
		$http({
            url : '/arcommon/order',
            method : "POST",
            data : {
                "list" : $scope.itemList
            }
        }).then(function(response) {
            console.log(response.data);
            $scope.message = response.data;
        }, function(response) {
            console.log(response);
            $scope.message = response;
        });
	}
});
