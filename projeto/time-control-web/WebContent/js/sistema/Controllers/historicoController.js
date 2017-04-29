
angular.module("timeControl").controller("historicoController", ['$scope', '$http', '$rootScope', '$location','$route', function($scope, $http, $rootScope, $location,$route) {


$(document).ready(function(){
		$('#mensagemUsuario').removeClass('in');
	});
	$http({
		method : "GET",
		url : "http://localhost:8080/time-control/historico/buscaHistorico/" + $rootScope.usuario.codigo
	}).then(function mySucces(response) {
		$scope.historicos = response.data;
	}, function myError(response) {
	});
}]);
