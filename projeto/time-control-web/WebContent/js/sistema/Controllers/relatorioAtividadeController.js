angular.module("timeControl").controller("relatorioAtividadeController",['$scope', '$http', '$rootScope', '$location','$route', '$timeout', function($scope, $http, $rootScope, $location,$route, $timeout) {
	$scope.isEdit = true;
	$scope.marcados = [];

	$(document).ready(function(){
		$('#mensagemUsuario').removeClass('in');
	});

	$http({
		method : "GET",
		url : "http://localhost:8080/time-control/historico/buscaRelatorio/" + $rootScope.usuario.codigo
	}).then(function mySucces(response) {
		$scope.relatorios = response.data;
	}, function myError(response) {
	}); 
	$scope.todasAtividades = true;
	$scope.marcar = function(relatorio){
		
		var posicao = ($scope.marcados.map((atividadeLoop, key) => {atividadeLoop.nome == relatorio.atividade.nome; return key})).length;
		console.log(posicao);
		console.log($scope.marcados);
		if(posicao < 0){
			$scope.marcados.splice(posicao[0], 1);
		}
		else{
			$scope.marcados.push(relatorio);
		}
	};

	$scope.mostrarAtividadesMarcadas = function(){
		$scope.todasAtividades = false;
		$scope.atividadesMarcadas = true;
		$scope.todosNomesMarcados = "Relátorio das atividades "+$scope.marcados.sort(function(a, b){return a.atividade.nome > b.atividade.nome})
		.map(relatorio => relatorio.atividade.nome).join(" | ");
		$scope.relatorios = $scope.marcados;
	}

$scope.isMarcado = function(atividade){
	var posicao = ($scope.marcados.map((atividadeLoop, key) => {atividadeLoop.nome == atividade.nome; return key})).length;
	return posicao.length > 0;
}

$scope.mostrarTodasAtividades = function(){
	$scope.todasAtividades = true;
	$scope.atividadesMarcadas = false;
	$scope.marcados = [];
	$http({
		method : "GET",
		url : "http://localhost:8080/time-control/historico/buscaRelatorio/" + $rootScope.usuario.codigo
	}).then(function mySucces(response) {
		$scope.relatorios = response.data;
	}, function myError(response) {
	}); 
}
 }]);
