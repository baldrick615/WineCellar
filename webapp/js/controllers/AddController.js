(function () {
  var wineCellarApp = angular.module('WineCellarApp');

  wineCellarApp.controller('AddController', function ($scope) {
    $scope.newWine = [];

    $scope.upload = function () {
      $http.post('/winecellar/webapi/wines/add', $scope.wines).then(
        function (response) {
          $scope.uploadStatus = 'Upload successful';
        },
        function (response) {
          $scope.uploadStatus = 'error uploading new bottle!';
          console.log('error POST new wine: ' + response.status);
        }
      );
    };
  });
});
