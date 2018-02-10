//Define an angular module for the application
var arApp = angular.module('arApp', ['ngRoute']);
//configure our routes
arApp.config(function($routeProvider) {
    $routeProvider
        // route for the home page
        .when('/main', {
            templateUrl : 'pages/home.jsp',
            controller  : 'mainController'
        })
        
        // route for the about page
        .when('/products', {
            templateUrl : 'pages/products.jsp',
            controller  : 'productsController'
        })

        // route for the contact page
        .when('/contact', {
            templateUrl : 'pages/contact.jsp',
            controller  : 'contactController'
        })
        .otherwise({  
            redirectTo: '/main'  
        }); 
});

// create the controller and inject Angular's $scope
arApp.controller('mainController', function($scope) {
    // create a message to display in our view
});

arApp.controller('productsController', function($scope) {
    
});


arApp.controller('contactController', function($scope) {

});
