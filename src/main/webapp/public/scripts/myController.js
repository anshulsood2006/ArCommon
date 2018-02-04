app.controller('myCtrl', function($scope,$location,$timeout,$interval,customService,$http) {
	$http.get("pages/welcome.html")
	.then(function(response) {
		$scope.content = response.data;
		$scope.statusCode = response.status;
		$scope.statusText = response.statusText;            
	});
	$http.get("json/customer.json")
	.then(function(response) {
        $scope.myData = response.data.records;
    });
	$scope.myUrl = $location.absUrl();
	$scope.customeReturn = customService.myFunc(255);
	$scope.color = "yellow";
	$scope.names = ["Anshul", "Akhil", "Abhishek", "Ruchika", "Ashok", "Rasma"];
	$scope.myHeader = "Hello World!";
    $timeout(function () {
        $scope.myHeader = "How are you today?";
    }, 10000);
    $scope.theTime = new Date().toLocaleTimeString();
    $interval(function () {
        $scope.theTime = new Date().toLocaleTimeString();
    }, 10000);
	$scope.addresses = [
        {name:'Jani',country:'Norway'},
        {name:'Carl',country:'Sweden'},
        {name:'Margareth',country:'England'},
        {name:'Hege',country:'Norway'},
        {name:'Joe',country:'Denmark'},
        {name:'Gustav',country:'Sweden'},
        {name:'Birgit',country:'Denmark'},
        {name:'Mary',country:'England'},
        {name:'Kai',country:'Norway'}
    ];
	$scope.cars = {
        car01 : {brand : "Ford", model : "Mustang", color : "red"},
        car02 : {brand : "Fiat", model : "500", color : "white"},
        car03 : {brand : "Volvo", model : "XC90", color : "black"}
    }
    $scope.firstName = "John";
    $scope.changeFirstName = function() {
        $scope.firstName = "ChangedName";
    }
    $scope.fullName = function() {
        return $scope.firstNameF + " "+  $scope.lastNameL;
    }
    $scope.orderBy = function(x) {
        $scope.myOrderBy = x;
    }
    
});
app.controller('myCtrl1', function($scope) {
	$scope.color = "red";
});
app.filter('myCustomeFilter', function() {
    return function(x) {
        var i, c, txt = "";
        for (i = 0; i < x.length; i++) {
            c = x[i];
            if (i % 2 == 0) {
                c = c.toUpperCase();
            }
            txt += c;
        }
        return txt;
    };
});
app.service('customService', function() {
    this.myFunc = function (x) {
        return x.toString(21);
    }
});