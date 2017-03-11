angular.module("timeControl").config(function($routeProvider){
    $routeProvider.when("/inicio", {
		templateUrl: "layout/sistema/inicio.html",
		controller: "timeControlController",
    });

 $routeProvider.when("/atividades", {
		templateUrl: "layout/sistema/atividades/lista-atividade.html",
		controller: "timeControlController",
    });
    $routeProvider.otherwise({redirectTo: "/atividades"});
});