angular.module("timeControl").config(function($routeProvider){
    $routeProvider.when("/inicio", {
		templateUrl: "layout/sistema/inicio.html",
		controller: "homeController",
    });

 $routeProvider.when("/atividades", {
		templateUrl: "layout/sistema/atividades/lista-atividade.html",
		controller: "atividadeController",
    });

    $routeProvider.otherwise({redirectTo: "/atividades"});
});