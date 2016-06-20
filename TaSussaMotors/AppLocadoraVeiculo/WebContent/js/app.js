angular.module('crudAppLocacao', [ 'ui.router', 'crudAppLocacao.controllers' ])

.config(function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise('/home0');

	$stateProvider

	.state('home', {
		url : '/home',
		templateUrl : 'pages/partial-home.html'
	})

	.state('clientes', {
		url : '/clientes',
		templateUrl : 'pages/partial-clientes.html',
		controller : "ClienteController"
	})
	
	.state('funcionarios', {
		url : '/funcionarios',
		templateUrl : 'pages/partial-funcionarios.html',
		controller : "FuncionarioController"
	})
	
	.state('locacoes', {
		url : '/locacoes',
		templateUrl : 'pages/partial-locacoes.html',
		controller : "LocacaoController",
	})
	
	.state('multas', {
		url : '/multas',
		templateUrl : 'pages/partial-multas.html',
		controller : "MultaController"
	})
	
	.state('veiculos', {
		url : '/veiculos',
		templateUrl : 'pages/partial-veiculos.html',
		controller : "VeiculoController"
	})
	
	.state('categorias', {
		url : '/categorias',
		templateUrl : 'pages/partial-categorias.html',
		controller : "CategoriaController"
	})
	
	.state('avarias', {
		url : '/avarias',
		templateUrl : 'pages/partial-avarias.html',
		controller : "AvariaController"
	})
	

});
