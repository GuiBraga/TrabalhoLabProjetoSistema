angular.module("timeControl").controller("timeControlController", function($scope, $rootScope){

  $rootScope.showLayoutSistema = true;

  $(document).ready(function(){
    $('.sistema').show();
    $('header').removeClass('header-page');

    $('.menu-topo').removeClass('esconde');
    $('.logo').removeClass('usuario');
  });

});
