(function () {
  var app = angular.module('WineCellarApp');
  app.controller('homeController', function ($scope) {
    

    $scope.caroWines = [
      {
        name: 'last wine',
        vintage: 2012,
        vintage: 'otherWhite',
        region: 'ca',
        price: 26,
        quantity: 5,
      },
      {
        name: 'last wine -1',
        vintage: 2017,
        vintage: 'otherRed',
        region: 'ca',
        price: 16,
        quantity: 3,
      },
      {
        name: 'last wine-2',
        vintage: 2018,
        vintage: 'merlot',
        region: 'fr',
        price: 11,
        quantity: 4,
      },
    ];
  });
})();
