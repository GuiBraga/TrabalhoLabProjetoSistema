angular.module("timeControl").controller("atividadeController",['$scope', '$http', '$rootScope', '$location','$route', '$timeout', function($scope, $http, $rootScope, $location,$route, $timeout) {
	$scope.isEdit = true;
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


			$rootScope.tipoMensagemUsuario = 'success';
			$rootScope.tituloMensagemParaUsuario = '';
			$rootScope.mensagemParaUsuario = 'Salvo com Sucesso!';
			$('#mensagemUsuario').addClass('in');

			//$route.reload();
			$timeout(function(){$route.reload();}, 5000);
			//alert("Salvo com Sucesso!");
		}, function(response){
			if(response.status = 409){
				$rootScope.tipoMensagemUsuario = 'warning';
				$rootScope.tituloMensagemParaUsuario = 'Atenção';
				$rootScope.mensagemParaUsuario = 'Erro ao salvar, já existe uma atividade cadastrada com esse nome.';
				$('#mensagemUsuario').addClass('in');
				$timeout(function(){$route.reload();}, 5000);
				//alert("Erro ao salvar, já existe uma atividade cadastrada com esse nome.");
			}else{
				$rootScope.tipoMensagemUsuario = 'danger';
				$rootScope.tituloMensagemParaUsuario = 'Atenção';
				$rootScope.mensagemParaUsuario = 'Erro ao Salvar, tente novamente!';
				$('#mensagemUsuario').addClass('in');
				$timeout(function(){$route.reload();}, 5000);
				//alert("Erro ao salvar, tente novamente!");
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

			$rootScope.tipoMensagemUsuario = 'success';
			$rootScope.tituloMensagemParaUsuario = '';
			$rootScope.mensagemParaUsuario = 'Edição realizada com Sucesso!';
			$('#mensagemUsuario').addClass('in');
			//$route.reload();
			$timeout(function(){$route.reload();}, 5000);
			//alert("Edição realizada com Sucesso!");
		}, function(response){
			if(response.status = 409){
				$rootScope.tipoMensagemUsuario = 'warning';
				$rootScope.tituloMensagemParaUsuario = '';
				$rootScope.mensagemParaUsuario = 'Erro ao editar, já existe uma atividade cadastrada com esse nome.';
				$('#mensagemUsuario').addClass('in');
				$timeout(function(){$route.reload();}, 5000);
				//alert("Erro ao editar, já existe uma atividade cadastrada com esse nome.");
			}else{
				$rootScope.tipoMensagemUsuario = 'danger';
				$rootScope.tituloMensagemParaUsuario = '';
				$rootScope.mensagemParaUsuario = 'Erro ao editar, tente novamente!';
				$('#mensagemUsuario').addClass('in');
				$timeout(function(){$route.reload();}, 5000);
				//alert("Erro ao editar, tente novamente!");
			}
		});
  }

  $scope.excluir = function(id){
		console.log(1);
	  var req = {
				 method: 'DELETE',
				 url: 'http://localhost:8080/time-control/atividade/' + id,
				 headers: {
				   'Content-Type': 'application/json'
				 }
				}

	  $http(req).then(function(response){
			$rootScope.tipoMensagemUsuario = 'success';
			$rootScope.tituloMensagemParaUsuario = '';
			$rootScope.mensagemParaUsuario = 'Excluído com Sucesso!';
			$('#mensagemUsuario').addClass('in');
		  $timeout(function(){$route.reload();}, 5000);
			//alert("Excluído com Sucesso!");
		  //$route.reload();

		}, function(response){
			$rootScope.tipoMensagemUsuario = 'danger';
			$rootScope.tituloMensagemParaUsuario = '';
			$rootScope.mensagemParaUsuario = 'Erro ao excluir, tente novamente!';
			$('#mensagemUsuario').addClass('in');
			$timeout(function(){$route.reload();}, 5000);
			//alert("");
		});
  }

  $scope.carregarAtividadeModalVisualizar = function(id){
	 
	  $scope.isEdit = false;
	  $scope.editAtividade = false;

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
  
  $scope.carregarAtividadeModalEditar = function(id){
		 
	  $scope.isEdit = true;
	  $scope.editAtividade = true;

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

$scope.idExcluir = '';
	$scope.eventoModal = function(id){
		$scope.idExcluir = id;
		$scope.callbackModal = $scope.excluir;

	};


 }]);
