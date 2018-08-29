app.run(function($rootScope) {
    $rootScope.color = 'blue';
});

app.controller('myCtrl', function($scope,$location,$timeout,$interval,customService,$http) {
	$scope.x1 = "StupenDOUS";
	$scope.x2 = angular.lowercase($scope.x1);
	$scope.x3 = angular.uppercase($scope.x1);
	$scope.mousemove = 0;
	$scope.click = 0;
	$scope.myFunc = function(myEvent){
		$scope.xLoc = myEvent.clientX;
		$scope.yLoc = myEvent.clientY;
	}
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
app.directive('myDirective', function() {
  return {
    require: 'ngModel',
    link: function(scope, element, attr, mCtrl) {
      function myValidation(value) {
        if (value.indexOf("e") > -1) {
          mCtrl.$setValidity('charE', true);
        } else {
          mCtrl.$setValidity('charE', false);
        }
        return value;
      }
      mCtrl.$parsers.push(myValidation);
    }
  };
});
app.config(function($sceDelegateProvider) {
    $sceDelegateProvider.resourceUrlWhitelist([
        'https://tryit.w3schools.com/**'
    ]);
});
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "AngularJS.html"
    })
    .when("/red", {
        templateUrl : "pages/page1.html"
    })
    .when("/blue", {
        templateUrl : "pages/green.html"
    })
    .when("/black", {
        templateUrl : "pages/blue.html"
    });
});