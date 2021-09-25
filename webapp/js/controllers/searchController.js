app.controller('searchController', function ($scope, $http) {
  $scope.getAllWines = function () {
    $http.get('/winecellar/webapi/wines').then(function (response) {
      $scope.wines = response.data;
    });
  };
});
