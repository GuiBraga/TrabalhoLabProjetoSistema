angular.module("timeControl").controller("historicoController", function($scope){

  $scope.atividades=[
    {
    "id": 1,
    "nomeAtividade": "ler",
    "totalGastoSemanaRetrasada": "10:00",
    "totalGastoSemanaPassada": "10:00",
    "totalGastoSemanaAtual": "10:00"
  },
  {
    "id": 2,
    "nomeAtividade": "estudar",
    "totalGastoSemanaRetrasada": "10:00",
    "totalGastoSemanaPassada": "10:00",
    "totalGastoSemanaAtual": "10:00"
  },
  {
    "id": 3,
    "nomeAtividade": "academia",
    "totalGastoSemanaRetrasada": "10:00",
    "totalGastoSemanaPassada": "10:00",
    "totalGastoSemanaAtual": "10:00"
    }
  ];

  $scope.myChartObject = {};

      $scope.myChartObject.type = "BarChart";

      $scope.myChartObject.data = {"cols": [
          {id: "t", label: "Topping", type: "string"},
          {id: "s", label: "Horas", type: "number"}
      ], "rows": [
          {c: [
              {v: "Mushrooms"},
              {v: 3},
          ]},
          {c: [
              {v: "Olives"},
              {v: 31}
          ]},
          {c: [
              {v: "Zucchini"},
              {v: 1},
          ]},
          {c: [
              {v: "Pepperoni"},
              {v: 2},
          ]}
      ]};

      $scope.myChartObject.options = {
          'title': 'Ranking de horas gastas na semana retrasada, semana passada, e atual'
      };
 });
