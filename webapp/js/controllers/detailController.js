(function () {
  var app = angular.module('WineCellarApp');
  app.controller(
    'detailController',
    function ($scope, $http, $routeParams) {
      var wineId = $routeParams.id;
      console.log($routeParams)
      getWinesById = function () {
        $http.get('/winecellar/webapi/wines/' + $routeParams.id).then(
          function (response) {
            let wines = response.data;
            if (wines.length == 1) {
              $scope.wine = wines[0];
            } else {
              console.log('error generating data by id')
            }
          },
          function (response) {
            console.log('error http GET wines');
          }
        );
        getWinesById();
      };
      
    });
})();
