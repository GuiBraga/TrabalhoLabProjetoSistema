angular.module("timeControl").controller("relatoriosController", ['$scope', '$http', '$rootScope', '$location','$route', function($scope, $http, $rootScope, $location,$route) {

	$(document).ready(function(){
		$('#mensagemUsuario').removeClass('in');
	});
	
	$http({
		method : "GET",
		url : "http://localhost:8080/time-control/historico/buscaRelatorio/" + $rootScope.usuario.codigo
	}).then(function mySucces(response) {
		$scope.relatorios = response.data;
		
		var colunas=[
	          {id: "t", label: "Dia da semana", type: "string"},
	          {id: "s", label: "Tempo", type: "number"}
	      ];

	      $scope.graficosPrioridadeBaixa = [];
	      $scope.graficosPrioridadeMedia = [];
	      $scope.graficosPrioridadeAlta = [];
	      $scope.relatorios.map(function(relatorio){

	      var graficoDados=  [{c: [
	            {v: "Seg"},
	            {v: relatorio.segunda},
	        ]},
	        {c: [
	            {v: "Ter"},
	            {v:  relatorio.terca},
	        ]},
	        {c: [
	            {v: "Qua"},
	            {v: relatorio.quarta},
	        ]},
	        {c: [
	            {v: "Qui"},
	            {v: relatorio.quinta},
	        ]},
	        {c: [
	            {v: "Sex"},
	            {v: relatorio.sexta},
	        ]},
	        {c: [
	            {v: "Sab"},
	            {v: relatorio.sabado},
	        ]},
	        {c: [
	            {v: "Dom"},
	            {v: relatorio.domingo},
	        ]}];
	        var configuracoesGraficos = {

	          data: {"cols": colunas, "rows": graficoDados},
	          "type": "ColumnChart",
	          options: {
	            fontName: "Poppins Regular",
	            backgroundColor: "#f0fbfc",
	            legend: "none",
	            'title': relatorio.atividade.nomeAtividade,
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
	                
	        if(relatorio.atividade.prioridadeAtividade == 0){
	                  configuracoesGraficos.options.colors = ["green", "#34b04f"];
	                    $scope.graficosPrioridadeBaixa.push(configuracoesGraficos);
	                }
	                
	        if(relatorio.atividade.prioridadeAtividade == 1){
	                  configuracoesGraficos.options.colors = ["yellow", "#f8e64a"];
	                    $scope.graficosPrioridadeMedia.push(configuracoesGraficos);
	                }
	        
	        if(relatorio.atividade.prioridadeAtividade == 2){
	                  configuracoesGraficos.options.colors = ["red", "#f44336"];
	                    $scope.graficosPrioridadeAlta.push(configuracoesGraficos);
	                }
	      });

	      somarTotalHoras();
	      
	      function somarTotalHoras(){
	    	  $scope.relatorios.forEach(function(relatorio){
	    		  relatorio.totalHoras = parseFloat(relatorio.segunda) + parseFloat(relatorio.terca) + parseFloat(relatorio.quarta) + parseFloat(relatorio.quinta) + parseFloat(relatorio.sexta) + parseFloat(relatorio.sabado) + parseFloat(relatorio.domingo)
	    	  });	
	      }
	      
	      function ordenarTotalHoras(dados){
	    	  dados.sort(function(atual, proximo){
	    		  return proximo.totalHoras - atual.totalHoras
	    	  });
	    	  return dados;
	      }
	      
	      $scope.rankingGrafico = {};
	      
	      function montaGraficoRanking(){
	    	  var colunas=[
	    		  {id: "t", label: "Atividades", type: "string"},
	    		  {id: "s", label: "", type: "number"},
	    		  {type:"string", role: "style"}
	    		  ];
	    	  
	    	  
	    	  
	    	  var graficoDados = [];
	    	  var atividadesOrdenadas = ordenarTotalHoras($scope.relatorios);
	    	  atividadesOrdenadas.map(function(relatorio){
	    		  
	    		  var corPrioridade = "#00FFFF";
	    		  if(relatorio.atividade.prioridadeAtividade == 0){
	    			  corPrioridade = "#34b04f";
	    			  
	    		  }
	    		  if(relatorio.atividade.prioridadeAtividade == 1){
	    			  corPrioridade = "#f8e64a";
	    		  }	           
	    		  if(relatorio.atividade.prioridadeAtividade == 2){
	    			  corPrioridade = "#f44336";
	    			  
	    		  }
	    		  graficoDados.push({c: [
	    			  {v: relatorio.atividade.nomeAtividade},
	    			  {v: relatorio.totalHoras},
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

	}, function myError(response) {
	});
	
	$scope.chartReady = function() {
		fixGoogleChartsBarsBootstrap();
	};
	function fixGoogleChartsBarsBootstrap() {
		
		$(".google-visualization-table-table img[width]").each(function(index, img) {
			$(img).css("width", $(img).attr("width")).css("height", $(img).attr("height"));
		});
	}
      
 }]);
