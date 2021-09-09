var app = angular.module('WineCellarApp', ['ngRoute']);

app.config(function ($routeProvider) {
  $routeProvider
    .when('/search', {
      controller: 'searchController',
      templateUrl: 'search.html',
    })
    // .when('notes',{
    // 	controller: 'NotesController',
    // 	templateUrl: 'notes.html'
    // })
    .otherwise({
      redirectTo: '/',
    });
});
