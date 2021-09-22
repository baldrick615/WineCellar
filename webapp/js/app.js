(function () {
  var app = angular.module('WineCellarApp', ['ngRoute']);
  app.config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        controller: 'MainController',
        templateUrl: 'views/master.html',
      })
      .when('/add', {
        controller: 'AddController',
        templateUrl: 'views/add-bottle.html',
      })
      .otherwise({
        templateUrl: 'views/master.html',
      });
  });
});
