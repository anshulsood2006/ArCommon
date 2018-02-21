var module = angular.module('indexApp');

module.controller('kidsPathshalaController', function($scope) {
    
});

module.controller('imagesController', function($scope) {
	$scope.presidentList = ["Rajendra Prasad","Sarvepalli Radhakrishnan","Zakir Husain","Varahagiri Venkata Giri","Mohammad Hidayatullah","Varahagiri Venkata Giri","Fakhruddin Ali Ahmed","Basappa Danappa Jatti","Neelam Sanjiva Reddy","Zail Singh","Ramaswamy Venkataraman","Shankar Dayal Sharma","Kocheril Raman Narayanan","Avul Pakir Jainulabdeen Abdul Kalam","Pratibha Patil","Pranab Mukherjee","Ram Nath Kovind"]
	var length = $scope.presidentList.length;
	var index = 0;
	$scope.imageUrl = $scope.presidentList[index];
	$scope.previous = function(){
		index = index - 1;
		if (index < 0 ){
			index = length - 1;
		}
		$scope.imageUrl = $scope.presidentList[index];
	}
	$scope.next = function(){
		index = index + 1;
		if (index > length - 1 ){
			index = 0;
		}
		$scope.imageUrl = $scope.presidentList[index];
	}
});
