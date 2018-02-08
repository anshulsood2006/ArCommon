//Define an angular module for the application
var arApp = angular.module('arApp', ['ngRoute']);
//configure our routes
arApp.config(function($routeProvider) {
    $routeProvider
        // route for the home page
        .when('/main', {
            templateUrl : 'htmls/home.html',
            controller  : 'mainController'
        })

        // route for the about page
        .when('/about', {
            templateUrl : 'htmls/about.html',
            controller  : 'aboutController'
        })

        // route for the contact page
        .when('/contact', {
            templateUrl : 'htmls/contact.html',
            controller  : 'contactController'
        })
        .otherwise({  
            redirectTo: '/main'  
        }); 
});

// create the controller and inject Angular's $scope
arApp.controller('mainController', function($scope) {
    // create a message to display in our view
    $scope.message = 'Look! I am a home page.';
});

arApp.controller('aboutController', function($scope) {
    $scope.message = 'Look! I am an about page.';
});

arApp.controller('contactController', function($scope) {
    $scope.message = 'Look! I am contact page.';
});
