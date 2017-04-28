angular.module("timeControl").controller("homeController", ["$scope", "$rootScope", "$http", function($scope, $rootScope, $http){
  
  $("#calendar").fullCalendar({
			locale: "pt-br",
			defaultView: 'agendaWeek',
			showMinutes: true,
			showAllDay: false,
			header: {
				left: 'prev,next',
				center: 'title',
				right: 'agendaWeek,agendaDay'
			},
			defaultDate: new Date(),
			navLinks: true, 
			selectable: true,
			selectHelper: true,
			select: function(start, end) {
				$("#modal-tempo-investido").modal("show");
				var dateStart = new Date(start._i[0],start._i[1],start._i[2],start._i[3],start._i[4],start._i[5]);
				var dateEnd = new Date(end._i[0],end._i[1],end._i[2],end._i[3],end._i[4],end._i[5]);
				$rootScope.$broadcast('go', { argument: {inicio: dateStart, fim: dateEnd}});
			},
			ignoreTimezone: false,
			editable: false,
			eventLimit: true,
			events: $scope.events,
			timeFormat: 'H:mm',
			eventClick: function(event, element) {
				$("#modal-tempo-investido").modal("show");
				$rootScope.$broadcast('edit',{argument: event})
				console.log(event);
		    }
		});

    $(".fc-time-grid-container").height("498px");

    $http({
		method : "GET",
		url : "http://localhost:8080/time-control/tempoinvestido/" + $rootScope.usuario.codigo + "/todos"
	}).then(function mySucces(response) {
		$scope.events = response.data;
		for (i = 0; i < $scope.events.length; i++) { 
			$scope.events[i].start = new Date($scope.events[i].start);
			$scope.events[i].end = new Date($scope.events[i].end);
		}
	    $('#calendar').fullCalendar( 'removeEventSource', $scope.events);
	    $('#calendar').fullCalendar( 'addEventSource', $scope.events);         
	    $('#calendar').fullCalendar( 'refetchEvents' );
	}, function myError(response) {
	});
 }]);
