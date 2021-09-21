var wineapp = angular.module('WineCellarApp');

wineapp.controller('MasterController', ['$scope', 'wines', function($scope, wines){
	wines.success(function(data){
		$scope.wines = data;
	})
}])