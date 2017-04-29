angular.module("timeControl").controller("historicoController", function($scope){

	angular.module("timeControl").controller("historicoController", function($scope){

		$http({
			method : "GET",
			url : "http://localhost:8080/time-control/atividade/" + $rootScope.usuario.codigo + "/todos"
		}).then(function mySucces(response) {
			$scope.atividades = response.data;
		}, function myError(response) {
		});
		
		console.log($scope.atividades);
	 });
 });
