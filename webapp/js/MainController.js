(function () {
  app.controller('MainController', [
    '$scope',
    'wines',
    function ($scope, wines) {
      wines.success(function (data) {
        $scope.wines = data;
      });
    },
  ]);
});
