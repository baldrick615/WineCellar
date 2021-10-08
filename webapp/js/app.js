var app = angular.module('WineCellarApp', ['ngRoute']);

app.config(function ($routeProvider) {
  $routeProvider
    .when('/add', {
      controller: 'createController',
      templateUrl: 'views/addBottle.html',
    })
    .when('/search', {
      controller: 'searchController',
      templateUrl: 'views/search.html',
    })
    .when('/', {
      controller: 'homeController',
      templateUrl: 'views/home.html',
    })
    .when('/update/:id', {
      controller: 'updateController',
      templateUrl: 'views/update.html',
    })
    .when('/detail', {
      controller: 'bottleController',
      templateUrl: 'views/bottleDetails.html',
    })

    .when('/resume', {
      templateUrl: 'views/resume.html',
    })
    .when('/archive', {
      controller: 'archiveController',
      templateUrl: 'views/archive.html',
    })

    .otherwise({
      templateUrl: 'views/collection.html',
    });
});
