var module = angular.module('myApp' , []);

module.controller('imagesController', function($scope) {
	$scope.list= ["Akhil", "Anshul", "Abhishek", "Ashok"];
	$scope.myArray=["1st":{
	"name":"Akhil",
	"Tenure":"Akhil",
	"imagePath","Akhil"
	},
	"2nd":{
		"name":"Anshul",
		"Tenure":"Anshul",
		"imagePath","Anshul"
	},
	"3rd":{
		"name":"Abhishek",
		"Tenure":"Abhishek",
		"imagePath","Abhishek"
	},
	"4th":{
		"name":"Ashok",
		"Tenure":"Ashok",
		"imagePath","Ashok"
	}];
	alert($scope.list.length);
	var length = $scope.list.length;
	var index = 0;
	$scope.imageUrl = $scope.list[index];
	$scope.previous = function(){
		index = index - 1;
		if (index < 0 ){
			index = length - 1;
		}
		$scope.imageUrl = $scope.list[index];
	}
	$scope.next = function(){
		index = index + 1;
		if (index > length - 1 ){
			index = 0;
		}
		$scope.imageUrl = $scope.list[index];
	}
});
