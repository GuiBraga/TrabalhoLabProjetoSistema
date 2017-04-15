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

$routeProvider.when("/historico", {
		templateUrl: "layout/sistema/historico/lista-historico.html",
		controller: "historicoController",
    });

$routeProvider.when("/relatorios", {
		templateUrl: "layout/sistema/relatorios/lista-relatorios.html",
		controller: "relatoriosController",
    });

    $routeProvider.otherwise({redirectTo: "/inicio"});
});
