angular.module("timeControl").controller("atividadeController",['$scope', '$http', '$rootScope', '$location', function($scope, $http, $rootScope, $location) {

	 $scope.atividades=[
		    {
		    "id": 3,
		    "nomeAtividade": "Atividade 1",
		    "tempoGastoAtividade": "10:00:00",
		    "prioridadeAtividade": "0",
		    "descricaoAtividade": "testando atividade 1"
		  },
		  {
		    "id": 2,
		    "nomeAtividade": "atividade 2",
		    "tempoGastoAtividade": "10:00:00",
		    "prioridadeAtividade": "0",
		    "descricaoAtividade": "teste atividade 2"
		  },
		  {
		    "id": 3,
		    "nomeAtividade": "fazer sistema",
		    "tempoGastoAtividade": "10:00:00",
		    "prioridadeAtividade": "0",
		    "descricaoAtividade": "teste teste teste teste teste teste "
		    }
		  ];
  
  $scope.salvar = function(){
	  if($scope.nomeAtividade != null && $scope.descricaoAtividade != null && $rootScope.usuario != null ){
		  $scope.atividade = {
				  'nome': $scope.nomeAtividade,
				  'descricao': $scope.descricaoAtividade,
//				  'categoria': $scope.categoria,
				  'usuario' : $rootScope.usuario
		  } 
	  }
  
	  var req = {
				 method: 'POST',
				 url: 'http://localhost:8080/time-control/atividade/',
				 headers: {
				   'Content-Type': 'application/json'
				 },
				 data: $scope.atividade
				}
	  
	  console.log(req);

		$http(req).then(function(response){
			alert("Salvo com Sucesso!");
			$location.path('/inicio');
		}, function(response){
			console.log(response);
		});
  }
 }]);