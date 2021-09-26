var app = angular.module('WineCellarApp', ['ngRoute']);
app.config(function ($routeProvider) {
  $routeProvider
    .when('/', {
      controller: 'mockDataController',
      templateUrl: 'views/collection.html',
    })
    .when('/add', {
      controller: 'AddController',
      templateUrl: 'views/add-bottle.html',
    })
    .when('/resume', {
      templateUrl: 'views/resume.html',
    })
    .otherwise({
      templateUrl: 'views/collection.html',
    });
});
