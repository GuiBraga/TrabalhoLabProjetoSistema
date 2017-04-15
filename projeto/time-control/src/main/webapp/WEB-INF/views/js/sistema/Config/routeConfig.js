angular.module("timeControl").config(function($routeProvider){
    $routeProvider.when("/inicio", {
		templateUrl: "layout/sistema/inicio.html",
		controller: "homeController",
    });

 $routeProvider.when("/atividades", {
		templateUrl: "layout/sistema/atividades/lista-atividade.html",
		controller: "atividadeController",
    });

$routeProvider.when("/tempo_investido", {
		templateUrl: "layout/sistema/tempo_investido/lista-tempo-investido.html",
		controller: "tempoInvestidoController",
    });

    $routeProvider.otherwise({redirectTo: "/inicio"});
});