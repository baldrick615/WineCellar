(function () {
  app.factory('wines', [
    '$http',
    function ($http) {
      return $http
        .get('/winecellar/webapi/wines')
        .success(function (data) {
          return data;
        })
        .error(function (err) {
          return err;
        });
    },
  ]);
});
