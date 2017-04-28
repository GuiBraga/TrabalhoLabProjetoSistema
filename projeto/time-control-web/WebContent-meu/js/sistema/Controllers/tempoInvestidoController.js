angular.module("timeControl").controller("tempoInvestidoController", ['$scope', '$http', '$rootScope', '$route', function($scope, $http, $rootScope, $route){ 
	
	$http({
		method : "GET",
		url : "http://localhost:8080/time-control/atividade/" + $rootScope.usuario.codigo + "/todos"
	}).then(function mySucces(response) {
		$scope.atividades = response.data;
	}, function myError(response) {
	});
	
	$scope.$on('go', function(event, args) {
		$scope.tempoInvestido = {};
		$scope.tempoInvestido = { atividade:{}, dataInicio: args.argument.inicio, dataFim: args.argument.fim};
		$scope.isEdit=false;
	});
	
	$scope.$on('edit', function(event, args) {
		$scope.tempoInvestido = {};
		$scope.tempoInvestido = { atividade:args.argument.atividade, dataInicio: args.argument.start._d,
				dataFim: args.argument.end._d,	descricao: args.argument.descricao};
		$scope.isEdit=true;
	});
	
	$scope.editar = function(atividade){
		$scope.tempoInvestido = {atividade:atividade};
		$scope.isEdit=true;
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
				$scope.tempoInvestido = {};
				$route.reload();
			}, function(response){
				alert("Erro ao Salvar, tente novamente!");
			});
		}
	}
}]);