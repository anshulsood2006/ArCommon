var module = angular.module('dukaanApp', []);

module.controller('dukaanIndexController', function($scope, $http) {
	
	$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
	  
	$scope.sendMail = function () {
		$scope.orderList = [];
        var order = {};
        order.name = $scope.user;
        order.email = $scope.email;
        order.phone = $scope.phone;
        order.address = $scope.address;
        order.order = $scope.order;
		$scope.orderList.push(order);
		$http({
            url : '/arcommon/order',
            method : "POST",
            data : {
                "orderList" : $scope.orderList
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
