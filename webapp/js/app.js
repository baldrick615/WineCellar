(function () {
  var app = angular.module('WineCellarApp', ['ngRoute']);
  app.config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        controller: 'MainController',
        templateUrl: 'views/master.html',
      })
      .otherwise({
        templateUrl: 'views/master.html',
      });
  });
});
