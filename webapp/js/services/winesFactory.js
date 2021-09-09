(function () {
  var winesFactory = function ($http) {
    var wines = [
      {
        name: 'Cakebread',
        vintage: 2018,
        color: 'red',
        price: 38.5,
        varietal: 'cabernet sauvignon',
        quantity: 12,
        region: 'ca',
      },
      {
        name: 'Silver Oak',
        vintage: 2012,
        color: 'red',
        price: 145,
        varietal: 'cabernet sauvignon',
        quantity: 4,
        region: 'ca',
      },
      {
        name: 'Cakebread',
        vintage: 2018,
        color: 'red',
        price: 38.5,
        varietal: 'cabernet sauvignon',
        quantity: 12,
        region: 'ca',
      },
      {
        name: 'Silver Oak',
        vintage: 2015,
        color: 'red',
        price: 155,
        varietal: 'cabernet sauvignon',
        quantity: 2,
        region: 'ca',
      },
      {
        name: 'Chateau Sauverain',
        vintage: 2018,
        color: 'white',
        price: 21,
        varietal: 'Chardonnay',
        quantity: 9,
        region: 'otherUs',
      },
      {
        name: 'Decoy',
        vintage: 2016,
        color: 'red',
        price: 82,
        varietal: 'merlot',
        quantity: 1,
        region: 'ca',
      },
    ];

    var factory = {};
    factory.getWines = function () {
      return wines;
    };
    factory.getWines = function (name) {
      for (var i = 0, len = $scope.wines.length; i < len; i++) {
        if ($scope.wines[i].name === name) {
          return wines[i];
        }
      }
      return {};
    };
    return factory;
  };
  angular.module('WineCellarApp').factory('winesFactory', winesFactory);
});
