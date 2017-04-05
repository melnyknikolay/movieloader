var purchaseApp = angular.module("purchaseApp", []);
purchaseApp.controller("purchaseController", function ($scope, $http) {
    $scope.text = null;
    $scope.year = null;
    $scope.type = null;
    $scope.postdata = function (text, year, type) {
        var data = {
            text: text,
            year: year,
            type: type
        };
//Call the services
        $http.post('/rest/public', JSON.stringify(data))
}});