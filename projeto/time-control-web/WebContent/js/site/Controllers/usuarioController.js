angular.module("timeControl").controller("usuarioController", ['$scope', '$http', function($scope, $http) {

	$('.menu-topo').addClass('esconde');
	$('.logo').addClass('usuario');

	$scope.logar = function () {
		$http({
			method : "GET",
			url : "http://localhost:8080/time-control/usuario/validaLogin",
			params : {"email" : $scope.email, "senha": $scope.senha}
		}).then(function mySucces(response) {
			alert("Logado com sucesso!");
		}, function myError(response) {
			alert("Senha ou usuário incorretos!");
		});
	}
}]);
