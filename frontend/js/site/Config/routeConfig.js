angular.module("timeControl").config(function($routeProvider){
    $routeProvider.when("/home", {
		templateUrl: "layout/site/home.html",
		controller: "timeControlController",
    });

     $routeProvider.when("/funcionalidades", {
		templateUrl: "layout/site/funcionalidades.html",
		controller: "timeControlController",
    });

    $routeProvider.when("/login", {
		templateUrl: "layout/site/login.html",
		controller: "timeControlController",
    });

    $routeProvider.otherwise({redirectTo: "/home"});
});