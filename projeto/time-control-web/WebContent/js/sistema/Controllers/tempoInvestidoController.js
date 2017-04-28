angular.module("timeControl").controller("tempoInvestidoController", ['$scope', '$http', '$rootScope','$route', '$timeout', function($scope, $http, $rootScope, $route, $timeout){


	$(document).ready(function(){
		$('#mensagemUsuario').removeClass('in');
	});		

	$http({
		method : "GET",
		url : "http://localhost:8080/time-control/atividade/" + $rootScope.usuario.codigo + "/todos"
	}).then(function mySucces(response) {
		$scope.atividades = response.data;
	}, function myError(response) {
	});

	$rootScope.$on('go', function(event, args) {
		$scope.tempoInvestido = {};
		$scope.tempoInvestido = { atividade:{}, dataInicio: args.argument.inicio, dataFim: args.argument.fim};
		$scope.isEdit=false;
		$scope.isPut = false;
	});
	
	$scope.$on('edit', function(event, args) {
		$scope.tempoInvestido = {};
		$scope.tempoInvestido = { atividade:args.argument.atividade, dataInicio: args.argument.start._d,
				dataFim: args.argument.end._d,	descricao: args.argument.descricao};
		$scope.isEdit=false;
		$scope.isPut = true;
	});
	
	$scope.editar = function(atividade){
		$scope.tempoInvestido = {atividade:atividade};
		$scope.isEdit = true;
		$scope.isPut = false;
	}

	$scope.isPut = false;
	
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

							$rootScope.tipoMensagemUsuario = 'success';
							$rootScope.tituloMensagemParaUsuario = '';
							$rootScope.mensagemParaUsuario = 'Salvo com Sucesso!';

							$('#mensagemUsuario').addClass('in');

//						$timeout(function(){$route.reload();}, 5000);
					}, function(response){
						$rootScope.tipoMensagemUsuario = 'danger';
						$rootScope.tituloMensagemParaUsuario = 'Atenção';
						$rootScope.mensagemParaUsuario = 'Erro ao Salvar, tente novamente!';
						$('#mensagemUsuario').addClass('in');
						$timeout(function(){$route.reload();}, 5000);
					});
		}
	}

	$scope.salvarEdit = function(){
		
	};
	

	$scope.idExcluir = '';
		$scope.eventoModal = function(id){
			$scope.idExcluir = id;
			$scope.callbackModal = $scope.excluir;

		};

}]);
