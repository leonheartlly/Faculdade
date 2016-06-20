var myApp = angular.module('crudAppLocacao', [ 'ui.router' ]);

myApp.config(function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise("/home");

	$stateProvider

	.state('home', {
		url : '/home',
		templateUrl : 'index.html'
	})
	
	.state('cadastro-cliente', {
		url : "/cadastro-cliente",
		templateUrl : "pages/cadastro-cliente.html"

	})

	.state('cadastro-veiculo', {
		url : "/cadastro-veiculo",
		templateUrl : "pages/cadastro-veiculo.html"

	})

	.state('cadastro-avaria', {
		url : "/cadastro-avaria",
		templateUrl : "pages/cadastro-avaria.html"

	})

	.state('cadastro-categoria', {
		url : "/cadastro-categoria",
		templateUrl : "pages/cadastro-categoria.html"

	})

	.state('cadastro-funcionario', {
		url : "/cadastro-funcionario",
		templateUrl : "pages/cadastro-funcionario.html"

	})

	.state('cadastro-locacao', {
		url : "/cadastro-locacao",
		templateUrl : "pages/cadastro-locacao.html"

	})

	.state('cadastro-multa', {
		url : "/cadastro-multa",
		templateUrl : "pages/cadastro-multa.html"

	})
});
