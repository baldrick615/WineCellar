app.controller('searchController', function ($scope, $http, $location) {
  $scope.getAllWines = function () {
    $http.get('/winecellar/webapi/wines').then(function (response) {
      $scope.wines = response.data;
    });
  };
});
