(function () {
  var wineCellarApp = angular.module('WineCellarApp');
  wineCellarApp.controller(
    'bottleController',
    function ($scope, $http, $routeParams) {
      $scope.getWinesById = function () {
        $http.get('/winecellar/webapi/wines/' + $routeParams.wineId).then(
          function (response) {
            let wines = response.data;
            if (wines.length == 1) {
              $scope.wine = wines[0];
            } else {
              console.log('error getting wine by requested id');
            }
          },
          function (response) {
            console.log('error getting wine by id: ' + response.status);
          }
        );
      };
      $scope.getWinesById();
    }
  );
})();
