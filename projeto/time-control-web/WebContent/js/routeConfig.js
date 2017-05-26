angular.module("timeControl").config(['$routeProvider', function($routeProvider){
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
    
    $routeProvider.when("/relatoriosAtividades", {
        templateUrl: "layout/sistema/relatorios/lista-atividade.html",
        controller: "relatorioAtividadeController",
    });

    $routeProvider.when("/relatorios", {
        templateUrl: "layout/sistema/relatorios/lista-relatorios.html",
        controller: "relatoriosController",
    });

    $routeProvider.otherwise({redirectTo: "/home"});
}]);
