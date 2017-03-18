angular.module('timeControl').directive('uiConfirmacao', function(){

	return {
		templateUrl: 'layout/sistema/uiConfirmacao.html',
		restrict: 'E',
		scope:{
			identificador: "@",
			fechar: '@',
			confirmar: '@',
			titulo: '@',
			mensagem: '@'
		},
		replace: true,
	}
});
