angular.module("timeControl").controller("historicoController", function($scope){

	$(document).ready(function(){
		$('#mensagemUsuario').removeClass('in');
	});
	
  $scope.atividades=[
    {
    "id": 1,
    "nomeAtividade": "ler",
    "totalGastoSemanaRetrasada": "10:00",
    "totalGastoSemanaPassada": "20:00",
    "totalGastoSemanaAtual": "30:00"
  },
  {
    "id": 2,
    "nomeAtividade": "estudar",
    "totalGastoSemanaRetrasada": "40:00",
    "totalGastoSemanaPassada": "50:00",
    "totalGastoSemanaAtual": "40:00"
  },
  {
    "id": 3,
    "nomeAtividade": "academia",
    "totalGastoSemanaRetrasada": "20:00",
    "totalGastoSemanaPassada": "10:00",
    "totalGastoSemanaAtual": "5:00"
    }
  ];

 });
