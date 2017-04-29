angular.module("timeControl").controller("historicoController", ['$scope', '$http', '$rootScope', '$location','$route', function($scope, $http, $rootScope, $location,$route) {

	$http({
		method : "GET",
		url : "http://localhost:8080/time-control/historico/buscaHistorico/" + $rootScope.usuario.codigo
	}).then(function mySucces(response) {
		$scope.historicos = response.data;
		console.log(response.data);
	}, function myError(response) {
	});
}]);
