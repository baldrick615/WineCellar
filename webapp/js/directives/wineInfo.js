app.directive('wineInfo', function () {
  return {
    restrict: 'E',
    scope: {
      info: '=',
    },
    templateUrl: 'views/collection.html',
  };
});
