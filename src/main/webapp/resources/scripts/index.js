//Define an angular module for the application
var index = angular.module('indexApp', ['ngRoute']);
//configure our routes
index.config(function($routeProvider) {
    $routeProvider
        // route for the home page
        .when('/main', {
            templateUrl : 'home.do',
            controller  : 'indexController'
        })
        
        // route for the about page
        .when('/products', {
            templateUrl : 'products.do',
            controller  : 'productsController'
        })

        // route for the contact page
        .when('/contact', {
            templateUrl : 'contact.do',
            controller  : 'contactController'
        })
        .otherwise({  
            redirectTo: '/main'  
        }); 
});

// create the controller and inject Angular's $scope
index.controller('indexController', function($scope) {
    // create a message to display in our view
});

index.controller('productsController', function($scope) {
    
});

index.controller('contactController', function($scope) {

});

index.controller('emailController', function($scope) {
	$scope.submit = function(){
		alert('Submitted');
	}
});