angular.module('timeControl').directive('uiConfirmacao', function(){

	return {
		templateUrl: 'layout/sistema/uiConfirmacao',
		restrict: 'E',
		scope:{
			id_modal: "@",
			btn_fechar: "@",
			btn_confirmar: "@",
			titulo: '@',
			mensagem: '@'
		},
		replace: true,
	}
});