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

    $scope.goToDetailView = function (id) {
      console.log('go to the detailBottle view');
      $location.path('/detail/' + id);
    };
  });
})();
