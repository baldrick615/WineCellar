(function () {
  var app = angular.module('WineCellarApp');

  app.controller(
    'updateController',
    function ($scope, $http, $routeParams, $location) {
      var wineId = $routeParams.id;
      $scope.getWinesById = function () {
        $http.get('/winecellar/webapi/wines/' + $routeParams.id).then(
          function (response) {
            let wines = response.data;
            if (wines.length == 1) {
              $scope.wine = wines[0];
            } else {
              //error
            }
          },
          function (response) {
            console.log('error http GET wines');
          }
        );
      };
      
      $scope.goToSearchView = function(){
      $location.path('/search')
      }

      $scope.updateWine = function () {
        $http.put('/winecellar/webapi/wines', $scope.wine).then(
          function (response) {
            $scope.updateStatus = 'update successful';
          },
          function (response) {
            $scope.updateStatus = 'error trying to update wine!';
            console.log('error http PUT wines: ' + response.status);
          }
        );
      };
      
      $scope.deleteWine = function () {
        $http.delete('/winecellar/webapi/wines/' + $scope.wine.id).then(
          function (response) {
            $scope.updateStatus = 'delete successful';
            $scope.disableUpdate = true;
          },
          function (response) {
            $scope.updateStatus = 'error trying to delete record';
            console.log('error http DELETE: ' + response.status);
          }
        );
      };
    	
      
      

      $scope.getWinesById();

      $scope.regions = ['au', 'wa', 'or', 'ca', 'fr', 'it', 'ROW', 'otherUS'];
      
      
      $scope.varietals = [
        'otherRed',
        'merlot',
        'chardonnay',
        'champagne',
        'sauvignonBlanc',
        'shiraz',
        'cabernetSauvignon',
        'otherWhite',
        'pinotNoir'
      ];
    }
  );
})();
