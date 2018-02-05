//Define an angular module for the application
var app = angular.module("ArCommonApplication", ["ngRoute"]);

//Define Routing for the application
app.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/Content/Add', {
                templateUrl: 'htmls/add.html',
                controller: 'ArCommonAddContentController'
            }).
            when('/Content/Show', {
                templateUrl: 'htmls/show.html',
                controller: 'ArCommonShowContentController'
            }).
            otherwise({
                redirectTo: '/Content/Add'
            });
}]);