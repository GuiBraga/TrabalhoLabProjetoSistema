angular.module("timeControl").config(['$routeProvider', function($routeProvider){
    $routeProvider.when("/homeSite", {
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
		templateUrl: "layout/sistema/login.html",
		controller: "usuarioController",
    resolve:{
      logado: function(loginService){
            loginService.showLayoutSistema(false);
      }
    }
    });

    $routeProvider.when("/cadastro", {
        templateUrl: "layout/sistema/cadastro.html",
        controller: "usuarioController",
        resolve:{
          logado: function(loginService){
                loginService.showLayoutSistema(false);
          }
        }
    });

    $routeProvider.when("/inicio", {
        templateUrl: "layout/sistema/inicio.html",
        controller: "homeController",
        resolve: {
          logado: function(loginService){
            loginService.showLayoutSistema(true);
            loginService.validaLogado();
          }
        }
    });

    $routeProvider.when("/atividades", {
        templateUrl: "layout/sistema/atividades/lista-atividade.html",
        controller: "atividadeController",
        resolve: {
          logado: function(loginService){
            loginService.showLayoutSistema(true);
            loginService.validaLogado(true);
          }
        }
    });

    $routeProvider.when("/tempo_investido", {
        templateUrl: "layout/sistema/tempo_investido/lista-tempo-investido.html",
        controller: "tempoInvestidoController",
        resolve: {
          logado: function(loginService){
            loginService.showLayoutSistema(true);
            loginService.validaLogado(true);
          }
        }
    });

    $routeProvider.when("/historico", {
        templateUrl: "layout/sistema/historico/lista-historico.html",
        controller: "historicoController",
        resolve: {
          logado: function(loginService){
            loginService.showLayoutSistema(true);
            loginService.validaLogado(true);
          }
        }
    });

    $routeProvider.when("/relatorios", {
        templateUrl: "layout/sistema/relatorios/lista-relatorios.html",
        controller: "relatoriosController",
        resolve: {
          logado: function(loginService){
              loginService.showLayoutSistema(true);
            loginService.validaLogado(true);
          }
        }
    });
    $routeProvider.when("/403", {
       templateUrl: "layout/403.html",
       controller: "erroController",
       });

    $routeProvider.otherwise({redirectTo: "/403"});
}]);
