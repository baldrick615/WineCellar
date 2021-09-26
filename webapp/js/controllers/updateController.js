app.controller(
  'updateController',
  function ($scope, $routeParams, $location, $http) {
    // Select wine by name, then edit any available field
    $http.get('/winecellar/webapi/wines/' + $routeParams.id).then(
      function (response) {
        let wines = response.data;
        if (wines.length == 1) {
          $scope.wine = wine[0];
        } else {
          //.error (function(err){{
          //return err;
        }
      },
      ($scope.goToSearchView = function () {
        console.log('go to search view');
        $location.path('/search');
      }),
      ($scope.updateWine = function () {
        $http.put('winecellar/webapi/wines', $scope.wine).then(
          function (response) {
            $scope.updateStatus = 'update successful';
          },
          function (response) {
            $scope.updateStatus = 'error updating information';
          }
        );
      }),

      $scope.getWinesById()
    
  }
);
