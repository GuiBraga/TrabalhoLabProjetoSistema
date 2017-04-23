angular.module("timeControl").service('loginService', function($rootScope, $location){
  this.validaLogado = function(){

    $rootScope.usuario = {codigo:1 };
    console.log($rootScope.usuario);
      if ($rootScope.usuario) {
        return true;
      }
    //  $location.path('#/403');

    }

    this.showLayoutSistema = function(mostra){
      $rootScope.showLayoutSistema = mostra;
    
    }

});
