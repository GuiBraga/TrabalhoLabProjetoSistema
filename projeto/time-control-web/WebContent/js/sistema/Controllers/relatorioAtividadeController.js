angular.module("timeControl").controller("relatorioAtividadeController",['$scope', '$http', '$rootScope', '$location','$route', '$timeout', function($scope, $http, $rootScope, $location,$route, $timeout) {
	$scope.isEdit = true;
	$scope.marcados = [];

	$(document).ready(function(){
		$('#mensagemUsuario').removeClass('in');
	});

//$scope.atividades = [{nome: 'atividade0'},
//{nome: 'atividade1'},
//{nome: 'atividade2'},
//{nome: 'atividade3'},
//{nome: 'atividade4'},
//{nome: 'atividade5'},
//{nome: 'atividade6'},
//].sort(function(a, b){return a.nome > b.nome});

	$http({
		method : "GET",
		url : "http://localhost:8080/time-control/atividade/" + $rootScope.usuario.codigo + "/todos"
	}).then(function mySucces(response) {
		$scope.atividades = response.data;
	}, function myError(response) {
	}); 

	$scope.marcar = function(atividade){
		var posicao = ($scope.marcados.map((atividadeLoop, key) => {atividadeLoop.nome == atividade.nome; return key})).length;
		console.log(posicao);
		console.log($scope.marcados);
		if(posicao < 0){
			$scope.marcados.splice(posicao[0], 1);
		}
		else{
			$scope.marcados.push(atividade);
		}
	};

	$scope.mostrarAtividadesMarcadas = function(){
		$scope.todosNomesMarcados = "Relátorio das atividades "+$scope.marcados.sort(function(a, b){return a.nome > b.nome}).map(ativ => ativ.nome).join(" | ");
		$scope.atividades = $scope.marcados;
	}

$scope.isMarcado = function(atividade){
	var posicao = ($scope.marcados.map((atividadeLoop, key) => {atividadeLoop.nome == atividade.nome; return key})).length;
	return posicao.length > 0;
}
 }]);
