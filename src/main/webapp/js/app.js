var app = angular.module("geektic", ['ngRoute', 'angular-md5']);
app.config(function($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'views/main.html'
    }).when('/rechercher', {
        templateUrl: 'views/fRecherche.html',
        controller: 'RechercherCtrl'
    }).when('/listerUtilisateurs', {
        templateUrl: 'views/listeUtilisateurs.html',
        controller: 'ListerUtilisateursCtrl'
    }).when('/utilisateur', {
        templateUrl: 'views/utilisateur.html',
        controller: 'AfficherUtilisateurCtrl'
    });
});

app.controller('RechercherCtrl', function($scope, $http) {
    $http.get('http://localhost:8080/centre_interets/lister').success(function(data, status, headers, config) {
    	$scope.listInterets = data;
        $scope.selection = [];
        $scope.result = false;
        $scope.verifSelected = function(idInteret)	{
        	if($scope.selection.indexOf(idInteret) > -1)	{
        		$scope.selection.splice($scope.selection.indexOf(idInteret), 1);
        	} else	{
        		$scope.selection.push(idInteret)
        	}
        }
        $scope.search = function()	{
        	listeInteret = $scope.selection.join();
        	sexe = $scope.sexe;
        	$http.get('http://localhost:8080/utilisateur/rechercher/'+sexe+'/'+listeInteret).success(function(data, status, headers, config)	{
        		$scope.listUtilisateurs = data;
        	});
        	$scope.resultat = true;
        }
    });
});

app.controller('ListerUtilisateursCtrl', function($scope, $http) {
    $http.get('http://localhost:8080/utilisateur/lister').success(function(data, status, headers, config) {
        $scope.listUtilisateurs = data;
    });
});

app.controller('AfficherUtilisateurCtrl', function($scope, $route, $routeParams, $http, md5) {
    $http.get('http://localhost:8080/utilisateur/afficher/' + $route.current.params.id).success(function(data, status, headers, config) {
    	$scope.utilisateur = data;
        $scope.utilisateur.gravatar = md5.createHash(data.mail);
    });
});