(function () {
  var app = angular.module('WineCellarApp');

  app.controller('createController', function ($scope, $http) {
    $scope.regions = [
    	  'Au',
	      'Ca',
	      'Fr',
	      'Wa',
	      'Or',
	      'OtherUs',
	      'ROW', 
	      'It',
	      'Sp',
	      'OtherEU'
	      
	    ],
    
      ($scope.varietals = [
        'cabernetSauvignon',
        'champagne',
        'chardonnay',
        'merlot',
        'otherRed',
        'otherWhite',
        'pinotNoir',
        'shiraz',
      ]);

    $scope.createWine = function () {
    	console.log($scope.wine)
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
      
      $scope.wine.name = '';
      $scope.wine.vintage = '';
      $scope.wine.region = '';
      $scope.wine.quantity = '';
      $scope.price = '';
      $scope.wine.varietal = '';
      $scope.disableCreate = false;
    };
  });
})();
