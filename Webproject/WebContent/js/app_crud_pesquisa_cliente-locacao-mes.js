var app = angular.module("crudAppLocacao", []);

var urlBase = "http://localhost:8080/Webproject/rest";

app.controller("PesquisaClienteLocMCtrl", function($scope, $http) {	
	
	function listar(){
		 $http.get(urlBase +"/cliente")
		    .then(function(response) {
		        $scope.clientes = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar clientes(Chamada GET)");
		    });
	}
	
	listar();
	
	$scope.cliente = {
			"cpf" : "",
			"nome" : "",
			"endereco" : "",
			"telefone" : ""
		};
	


	
	$scope.seleciona = function(cliente) {
			$scope.cliente = cliente;
			new Cliente(cliente.cpf, cliente.nome, cliente.endereco, cliente.telefone); 	
	};
	


	$scope.ordena = function(ordena){
		$scope.varOrdenacao = ordena;
	};
	
	$scope.novo = function() {
		$scope.cliente = "";
	};
	

	
})

