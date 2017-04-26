angular.module("timeControl").controller("atividadeController",['$scope', '$http', '$rootScope', '$location','$route', function($scope, $http, $rootScope, $location,$route) {
	$scope.isEdit = true;
	
	$http({
		method : "GET",
		url : "http://localhost:8080/time-control/atividade/" + $rootScope.usuario.codigo + "/todos"
	}).then(function mySucces(response) {
		$scope.atividades = response.data;
	}, function myError(response) {
	});
  
  $scope.salvar = function(){
	  if($scope.nomeAtividade != null && $scope.descricaoAtividade != null && $rootScope.usuario != null ){
		  $scope.atividade = {
				  'nome': $scope.nomeAtividade,
				  'descricao': $scope.descricaoAtividade,
				  'categoria': $scope.categoriaAtividade,
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
  
		$http(req).then(function(response){
			
			$route.reload();
			alert("Salvo com Sucesso!");
		}, function(response){
			if(response.status = 409){
				alert("Erro ao salvar, já existe uma atividade cadastrada com esse nome.");
			}else{
				alert("Erro ao salvar, tente novamente!");
			}
		});
  }
  
  $scope.editar = function(id){
	  if($scope.nomeAtividade != null && $scope.descricaoAtividade != null && $rootScope.usuario != null ){
		  $scope.atividade = {
				  'nome': $scope.nomeAtividade,
				  'descricao': $scope.descricaoAtividade,
				  'categoria': $scope.categoriaAtividade,
				  'codigo': $scope.codigoAtividade,
				  'usuario' : $rootScope.usuario
		  } 
	  }
	  
	  var req = {
				 method: 'PUT',
				 url: 'http://localhost:8080/time-control/atividade/' + id,
				 headers: {
				   'Content-Type': 'application/json'
				 },
				 data: $scope.atividade
				}
  
		$http(req).then(function(response){
			$route.reload();
			alert("Edição realizada com Sucesso!");
		}, function(response){
			if(response.status = 409){
				alert("Erro ao editar, já existe uma atividade cadastrada com esse nome.");
			}else{
				alert("Erro ao editar, tente novamente!");
			}
		});
  }
  
  $scope.excluir = function(id){
	  var req = {
				 method: 'DELETE',
				 url: 'http://localhost:8080/time-control/atividade/' + id,
				 headers: {
				   'Content-Type': 'application/json'
				 }
				}
	  
	  $http(req).then(function(response){
		  alert("Excluído com Sucesso!");
		  $route.reload();
			
		}, function(response){
			alert("Erro ao excluir, tente novamente!");
		});
  }
  
  $scope.carregarAtividadeModal = function(id, visualizacao){
	  
	  if(visualizacao){
		   $scope.isEdit = false;
		   $scope.editAtividade = false;
		}else{
			 $scope.isEdit = true;
			 $scope.editAtividade = true;
		}
	  
	  $http({
			method : "GET",
			url : "http://localhost:8080/time-control/atividade/" + id
		}).then(function mySucces(response) {
			
			$scope.atividade = response.data;
			$scope.nomeAtividade = $scope.atividade.nome;
			$scope.descricaoAtividade = $scope.atividade.descricao;
			$scope.categoriaAtividade = $scope.atividade.categoria;
			$scope.codigoAtividade = $scope.atividade.codigo;
			
			
		}, function myError(response) {
		});
  }
 }]);