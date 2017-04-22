angular.module("timeControl").controller("tempoInvestidoController", ['$scope', '$http', '$rootScope', function($scope, $http, $rootScope){ 
	
	$http({
		method : "GET",
		url : "http://localhost:8080/time-control/atividade/" + $rootScope.usuario.codigo + "/todos"
	}).then(function mySucces(response) {
		$scope.atividades = response.data;
	}, function myError(response) {
	});
	
	$scope.editar = function(atividade){
		$scope.tempoInvestido = {atividade:atividade};
	}
	
	$scope.salvar = function(){
		if($scope.tempoInvestido.descricao != undefined && $scope.tempoInvestido.descricao != null 
				&& $scope.tempoInvestido.dataFim != undefined && $scope.tempoInvestido.dataFim != null
				&& $scope.tempoInvestido.dataInicio != undefined && $scope.tempoInvestido.dataInicio != null
				&& $scope.tempoInvestido.atividade != undefined && $scope.tempoInvestido.atividade != null){
			var req = {
					 method: 'POST',
					 url: 'http://localhost:8080/time-control/tempoinvestido/',
					 headers: {
					   'Content-Type': 'application/json'
					 },
					 data: $scope.tempoInvestido
					}
	
			$http(req).then(function(response){
				alert("Salvo com Sucesso!");
			}, function(response){
				alert("Erro ao Salvar, tente novamente!");
			});
		}
	}
}]);