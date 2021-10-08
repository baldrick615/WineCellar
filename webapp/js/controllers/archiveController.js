(function () {
  var app = angular.module('WineCellarApp');
  app.controller('archiveController', function ($scope, $http, $location) {
    $scope.getWinesByQuantity = function () {
      $http.get('/winecellar/webapi/wines/archive/0').then(
        function (response) {
          $scope.archiveWines = response.data;
          console.log('number in archives: ' + $scope.archiveWines.length);
        },
        function (response) {
          console.log('error getting wines ' + response.status);
        }
      );
    };
    $scope.getWinesByQuantity();

    $scope.goToUpdateView = function (id) {
      console.log('go to the update view');
      console.log('id: ' + id);
      $location.path('/update/' + id);
    };
  });
})();
