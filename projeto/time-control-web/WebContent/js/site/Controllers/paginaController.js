angular.module("timeControl").controller("paginaController", function($scope){ 

	$('header').addClass('header-page');
	$(document).ready(function(){
		$('#mensagemUsuario').removeClass('in');
	});
});