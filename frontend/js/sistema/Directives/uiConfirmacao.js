angular.module('timeControl').directive('uiConfirmacao', function(){

	return {
		templateUrl: 'layout/sistema/uiConfirmacao',
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