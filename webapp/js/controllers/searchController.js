(function () {
  var app = angular.module('WineCellarApp');
  app.controller('searchController', function ($scope, $http, $location) {
    $scope.getWines = function () {
      $http.get('/winecellar/webapi/wines').then(
        function (response) {
          $scope.wines = response.data;
          
        },
        function (response) {
          console.log('error getting wines ' + response.status);
        }
      );
    };
    $scope.goToUpdateView = function (id) {
      console.log('go to the update view');
      $location.path('/update/' + id);
    };
    
    $scope.goToDetailView = function(id){
    	console.log('go to the detailBottle view');
    	$location.path('/detail/' + id)
    };
    
    

    $scope.getWines();
  });
})();
