//Define an angular module for the application
var module = angular.module('indexApp', ['ngRoute']);
//configure our routes
module.config(function($routeProvider) {
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
        .when('/kidsPathshala', {
            templateUrl : 'kidsPathshala.do',
            controller  : 'kidsPathshalaController'
        })
        .otherwise({  
            redirectTo: '/main'  
        }); 
});

module.controller('indexController', function($scope) {
   
});
