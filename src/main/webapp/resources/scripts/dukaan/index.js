var module = angular.module('dukaanApp', []);

module.controller('dukaanIndexController', function($scope, $http) {
	
	$scope.buttonPress= false;
	
	$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
	  
	$scope.sendMail = function () {
		if ($scope.phone.length != 10){
			$scope.message = 'Invalid Phone Number..';
			return;
		}
		
		$scope.buttonPress = true;
		$scope.message = 'Placing your order.......';
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
        	$scope.buttonPress = false;
            console.log(response.data);
            $scope.message = 'Order has been placed successfully';
        }, function(response) {
        	$scope.buttonPress = false;
            console.log(response);
            $scope.message = 'Order has been placed successfully';
        }, function(error) {
        	$scope.buttonPress = false;
            console.log(error);
            $scope.message = 'Error placing order';
        });
	}
});
