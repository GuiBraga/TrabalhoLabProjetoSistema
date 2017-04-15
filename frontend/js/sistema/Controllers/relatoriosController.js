angular.module("timeControl").controller("relatoriosController", function($scope){

  $scope.atividades=[
    {
    "id": 1,
    "nomeAtividade": "ler",
    "prioridadeAtividade": "0",
    "totalGastoSegunda": "13.00",
    "totalGastoTerca": "20.00",
    "totalGastoQuarta": "8.00",
    "totalGastoQuinta": "10.00",
    "totalGastoSexta": "10.00",
    "totalGastoSabado": "10.00",
    "totalGastoDomingo": "10.00",
  },
  {
    "id": 2,
    "nomeAtividade": "estudar",
    "prioridadeAtividade": "1",
    "totalGastoSegunda": "10.00",
    "totalGastoTerca": "10.00",
    "totalGastoQuarta": "10.00",
    "totalGastoQuinta": "10.00",
    "totalGastoSexta": "6.00",
    "totalGastoSabado": "19.00",
    "totalGastoDomingo": "21.00",
  },
  {
    "id": 3,
    "nomeAtividade": "academia",
    "prioridadeAtividade": "2",
    "totalGastoSegunda": "10.00",
    "totalGastoTerca": "10.00",
    "totalGastoQuarta": "1.00",
    "totalGastoQuinta": "0.00",
    "totalGastoSexta": "10.00",
    "totalGastoSabado": "14.00",
    "totalGastoDomingo": "10.00",
    }
  ];

      var colunas=[
          {id: "t", label: "Dia da semana", type: "string"},
          {id: "s", label: "Tempo", type: "number"}
      ];

      $scope.graficos = [];
      $scope.atividades.map(function(atividade){
        var graficoDados=  [{c: [
              {v: "Seg"},
              {v: atividade.totalGastoSegunda},
          ]},
          {c: [
              {v: "Ter"},
              {v:  atividade.totalGastoTerca},
          ]},
          {c: [
              {v: "Qua"},
              {v: atividade.totalGastoQuarta},
          ]},
          {c: [
              {v: "Qui"},
              {v: atividade.totalGastoQuinta},
          ]},
          {c: [
              {v: "Sex"},
              {v: atividade.totalGastoSexta},
          ]},
          {c: [
              {v: "Sab"},
              {v: atividade.totalGastoSabado},
          ]},
          {c: [
              {v: "Dom"},
              {v: atividade.totalGastoDomingo},
          ]}];

        var corPrioridade = ["yellow", "#00FFFF"];
        if(atividade.prioridadeAtividade == 0){
          corPrioridade = ["green", "#34b04f"];
        }
        if(atividade.prioridadeAtividade == 1){
          corPrioridade = ["yellow", "#f8e64a"];
        }
        if(atividade.prioridadeAtividade == 2){
          corPrioridade = ["red", "#f44336"];
        }

        $scope.graficos.push({

          data: {"cols": colunas, "rows": graficoDados},
          "type": "ColumnChart",
          options: {
            backgroundColor: "#f0fbfc",
          colors : corPrioridade,
            'title': atividade.nomeAtividade,
               "isStacked": "true",
                  "displayExactValues": true,

                  "vAxis": {
              "title": "Tempo investido",
              "gridlines": {
                  "count": 24
              }
          },
          "hAxis": {
              "title": "Dias da semana"
          }
          }
        });

      });

      $scope.chartReady = function() {
                  fixGoogleChartsBarsBootstrap();
              };
      function fixGoogleChartsBarsBootstrap() {

           $(".google-visualization-table-table img[width]").each(function(index, img) {
               $(img).css("width", $(img).attr("width")).css("height", $(img).attr("height"));
           });
       }
 });
