var module = angular.module('indexApp');

module.controller('kidsPathshalaController', function($scope) {
    
});

module.controller('imagesController', function($scope) {
		$scope.myArray =[					
							{
								"president":{
									"rank":"1st",
									"name": "Rajendra Prasad"
								}
							},
							{
								"president":{
									"rank":"2nd",
									"name": "Sarvepalli Radhakrishnan"
								},
							},
							{
								"president":{
									"rank":"3rd",
									"name": "Zakir Husain"
								}
							},
							{
								"president":{
									"rank":"4th",
									"name": "Varahagiri Venkata Giri"
								}
							},
							{
								"president":{
									"rank":"5th",
									"name": "Mohammad Hidayatullah"
								}
							},
							{
								"president":{
									"rank":"6th",
									"name": "Varahagiri Venkata Giri"
								}
							},
							{
								"president":{
									"rank":"7th",
									"name": "Fakhruddin Ali Ahmed"
								}
							},
							{
								"president":{
									"rank":"8th",
									"name": "Basappa Danappa Jatti"
								}
							},
							{
								"president":{
									"rank":"9th",
									"name": "Neelam Sanjiva Reddy"
								}
							},
							{
								"president":{
									"rank":"10th",
									"name": "Zail Singh"
								}
							},
							{
								"president":{
									"rank":"11th",
									"name": "Ramaswamy Venkataraman"
								}
							},
							{
								"president":{
									"rank":"12th",				
									"name": "Shankar Dayal Sharma"
								}
							},
							{
								"president":{
									"rank":"13th",
									"name": "Kocheril Raman Narayanan"
								}
							},
							{
								"president":{
									"rank":"14th",				
									"name": "Avul Pakir Jainulabdeen Abdul Kalam"
								}
							},
							{
								"president":{
									"rank":"15th",
									"name": "Pratibha Patil"
								}
							},
							{
								"president":{
									"rank":"16th",
									"name": "Pranab Mukherjee"
								}
							},
							{
								"president":{
									"rank":"17th",
									"name": "Ram Nath Kovind"
								}
							}
						];
		var length = $scope.myArray.length;
		var index = 0;
		var object = $scope.myArray[index].president;
		$scope.name = object.name;
		$scope.rank = object.rank;
		$scope.previous = function(){
			index = index - 1;
			if (index < 0 ){
				index = length - 1;
			}
			object = $scope.myArray[index].president;
			$scope.name = object.name;
			$scope.rank = object.rank;
		};
		$scope.next = function(){
			index = index + 1;
			if (index > length - 1 ){
				index = 0;
			}
			object = $scope.myArray[index].president;
			$scope.name = object.name;
			$scope.rank = object.rank;
		};
});
