angular.module("timeControl").controller("relatoriosController", function($scope){

	$(document).ready(function(){
		$('#mensagemUsuario').removeClass('in');
	});
	
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
  },
  {
    "id": 4,
    "nomeAtividade": "correr",
    "prioridadeAtividade": "2",
    "totalGastoSegunda": "10.00",
    "totalGastoTerca": "10.00",
    "totalGastoQuarta": "1.00",
    "totalGastoQuinta": "1.00",
    "totalGastoSexta": "10.00",
    "totalGastoSabado": "17.00",
    "totalGastoDomingo": "10.00",
    }
  ];

      var colunas=[
          {id: "t", label: "Dia da semana", type: "string"},
          {id: "s", label: "Tempo", type: "number"}
      ];

      $scope.graficosPrioridadeBaixa = [];
      $scope.graficosPrioridadeMedia = [];
      $scope.graficosPrioridadeAlta = [];
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
        var configuracoesGraficos = {

          data: {"cols": colunas, "rows": graficoDados},
          "type": "ColumnChart",
          options: {
            fontName: "Poppins Regular",
            backgroundColor: "#f0fbfc",
            legend: "none",
            'title': atividade.nomeAtividade,
               "isStacked": "false",
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
        };

        var corPrioridade = ["yellow", "#00FFFF"];
                if(atividade.prioridadeAtividade == 0){
                  configuracoesGraficos.options.colors = ["green", "#34b04f"];
                    $scope.graficosPrioridadeBaixa.push(configuracoesGraficos);
                }
                if(atividade.prioridadeAtividade == 1){
                  configuracoesGraficos.options.colors = ["yellow", "#f8e64a"];
                    $scope.graficosPrioridadeMedia.push(configuracoesGraficos);
                }
                if(atividade.prioridadeAtividade == 2){
                  configuracoesGraficos.options.colors = ["red", "#f44336"];
                    $scope.graficosPrioridadeAlta.push(configuracoesGraficos);
                }
      });


      function somarTotalHoras(){
        $scope.atividades.forEach(function(atividade){
          atividade.totalHoras = parseFloat(atividade.totalGastoSegunda) + parseFloat(atividade.totalGastoTerca) + parseFloat(atividade.totalGastoQuarta) + parseFloat(atividade.totalGastoQuinta) + parseFloat(atividade.totalGastoSexta) + parseFloat(atividade.totalGastoSabado) + parseFloat(atividade.totalGastoDomingo)
        });

      }
      function ordenarTotalHoras(dados){
        dados.sort(function(atual, proximo){
          return proximo.totalHoras - atual.totalHoras
        });
        return dados;
      }
      somarTotalHoras();

      $scope.rankingGrafico = {};

      function montaGraficoRanking(){
        var colunas=[
            {id: "t", label: "Atividades", type: "string"},
            {id: "s", label: "", type: "number"},
            {type:"string", role: "style"}
        ];



        var graficoDados = [];
        var atividadesOrdenadas = ordenarTotalHoras($scope.atividades);
        atividadesOrdenadas.map(function(atividade){

          var corPrioridade = "#00FFFF";
          if(atividade.prioridadeAtividade == 0){
            corPrioridade = "#34b04f";

          }
          if(atividade.prioridadeAtividade == 1){
            corPrioridade = "#f8e64a";

          }
          if(atividade.prioridadeAtividade == 2){
            corPrioridade = "#f44336";

          }
          graficoDados.push({c: [
                {v: atividade.nomeAtividade},
                {v: atividade.totalHoras},
                {v: "color: "+ corPrioridade}
            ]});
        });
        $scope.rankingGrafico = {

          data: {"cols": colunas, "rows": graficoDados},
          "type": "BarChart",
          options: {

            fontName: "Poppins Regular",
            backgroundColor: "#f0fbfc",
            legend: "none",
            'title': "",
            "isStacked": true,
            "displayExactValues": true,

                  "vAxis": {
              "title": "Atividades",
              "gridlines": {
                  "count": 24
              }
          },
          "hAxis": {
              "title": "Tempo investido"
          }
          }
        };
      }

      montaGraficoRanking();
      $scope.chartReady = function() {
                  fixGoogleChartsBarsBootstrap();
              };
      function fixGoogleChartsBarsBootstrap() {

           $(".google-visualization-table-table img[width]").each(function(index, img) {
               $(img).css("width", $(img).attr("width")).css("height", $(img).attr("height"));
           });
       }
 });
