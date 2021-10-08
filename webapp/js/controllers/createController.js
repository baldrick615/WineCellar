(function () {
  var app = angular.module('WineCellarApp');

  app.controller('createController', function ($scope, $http) {
    ($scope.regions = [
      'au',
      'ca',
      'fr',
      'wa',
      'or',
      'otherUS',
      'ROW',
      'it',
      'sp',
      'otherEU'
    ]),
      ($scope.varietals = [
        'cabernetSauvignon',
        'champagne',
        'chardonnay',
        'merlot',
        'otherRed',
        'otherWhite',
        'pinotNoir',
        'shiraz'
        
      ]);

    $scope.createWine = function () {
      $http.post('/winecellar/webapi/wines', $scope.wine).then(
        function (response) {
          $scope.createStatus = 'create Successful!';
          $scope.disableCreate = true;
        },
        function (response) {
          $scope.createStatus = 'error creating wine';
          console.log('error http POST wines' + response.status);
        }
      );
    };

    $scope.clear = function () {
      $scope.wine.vintage = '';
      $scope.wine.name = '';
      $scope.wine.region = '';
      $scope.wine.quantity = '';
      $scope.price = '';
      $scope.wine.varietal = '';
      $scope.disableCreate = false;
    };
  });
})();
