angular.module("timeControl").controller("usuarioController", ['$scope', '$http', '$rootScope', '$location', function($scope, $http, $rootScope, $location) {

	$('.menu-topo').addClass('esconde');
	$('.logo').addClass('usuario');

	$scope.loginInvalid = false;
	
	$scope.logar = function () {	
		if($scope.email != undefined && $scope.email != null && $scope.senha != undefined && $scope.senha != null){
			$http({
				method : "GET",
				url : "http://localhost:8080/time-control/usuario/validaLogin",
				params : {"email" : $scope.email, "senha": $scope.senha}
			}).then(function mySucces(response) {
				$scope.loginInvalid = false;
				$location.path('/inicio');
				$rootScope.usuario = response.data;
			}, function myError(response) {
				$scope.loginInvalid = true;
			});
		}
	}
	
	$scope.registrar = function (){
		if($scope.usuario.email != undefined && $scope.usuario.email != null && $scope.usuario.senha != undefined && $scope.usuario.senha != null 
				&& $scope.usuario.profissao != undefined && $scope.usuario.profissao != null && $scope.usuario.nome != undefined && $scope.usuario.nome != null){
			var req = {
					 method: 'POST',
					 url: 'http://localhost:8080/time-control/usuario/',
					 headers: {
					   'Content-Type': 'application/json'
					 },
					 data: $scope.usuario
					}
	
			$http(req).then(function(response){
				alert("Salvo com Sucesso!");
				$location.path('/login');
			}, function(response){
				if(response.status = 409){
					alert("Já existe usuário cadastrado para esse email!");
				}else{
					alert("Erro ao Salvar, tente novamente!");
				}
			});
		}
	}
}]);
