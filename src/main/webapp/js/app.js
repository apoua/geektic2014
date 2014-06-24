var app = angular.module("geektic", ['ngRoute']);
application.config(function($routeProvider) {
    $routeProvider
            .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
    })
            .when('/rechercher', {
        templateUrl: 'views/fRecherche.html',
        controller: 'RechercherCtrl'
    })
            .when('/listerUtilisateurs', {
        templateUrl: 'views/listeUtilisateurs.html',
        controller: 'ListerUtlisateursCtrl'
    });
});
app.controller('MainCtrl', function($scope, $http) {
    $http.get('/utilisateur').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});
app.controller('RechercherCtrl', function($scope, $http) {
    $http.get('/utilisateur/rechercher').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});
app.controller('ListerUtlisateursCtrl', function($scope, $http) {
    $http.get('/utilisateur/list').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});