angular.module("timeControl").config(function($routeProvider){
    $routeProvider.when("/home", {
		templateUrl: "layout/site/home.html",
		controller: "timeControlController",
    });

    $routeProvider.when("/quem-somos", {
		templateUrl: "layout/site/quem-somos.html",
		controller: "paginaController",
    });

     $routeProvider.when("/funcionalidades", {
		templateUrl: "layout/site/funcionalidades.html",
		controller: "paginaController",
    });

    $routeProvider.when("/login", {
		templateUrl: "layout/site/login.html",
		controller: "usuarioController",
    });

    $routeProvider.when("/cadastro", {
        templateUrl: "layout/site/cadastro.html",
        controller: "usuarioController",
    });

    $routeProvider.otherwise({redirectTo: "/home"});
});
