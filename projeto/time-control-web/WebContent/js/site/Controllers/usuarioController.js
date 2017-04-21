angular.module("timeControl").controller("usuarioController", ['$scope', '$http', '$rootScope', '$location', function($scope, $http, $rootScope, $location) {

	$('.menu-topo').addClass('esconde');
	$('.logo').addClass('usuario');

	$scope.logar = function () {
		if($scope.email != undefined && $scope.senha != undefined && $scope.email != null && $scope.senha != null){
			$http({
				method : "GET",
				url : "http://localhost:8080/time-control/usuario/validaLogin",
				params : {"email" : $scope.email, "senha": $scope.senha}
			}).then(function mySucces(response) {
				$location.path('/inicio');
				$rootScope.usuario = response.data;
			}, function myError(response) {
				alert("Senha ou usuário incorretos!");
			});
		}
	}
}]);
