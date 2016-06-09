var app = angular.module("crudAppLocacao", []);

var urlBase = "http://localhost:8080/Webproject/rest";

app.controller("PesquisaVeiculoCatCtrl", function($scope, $http) {	
	
	function listar(){
		 $http.get(urlBase +"/veiculo")
		    .then(function(response) {
		        $scope.veiculos = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar veiculos(Chamada GET)");
		    });
	}
	
	listar();
	
	$scope.veiculo = {
			"marca" : "",
			"modelo" : "",
			"ano" : "",
			"valor" : "",
			"observacao" : ""
		};
	


	
	$scope.seleciona = function(veiculo) {
			$scope.veiculo = veiculo;
			new Veiculo(veiculo.ano, veiculo.marca, veiculo.modelo, veiculo.observacao, veiculo.valor, new Categoria()); 	
	};
	


	$scope.ordena = function(ordena){
		$scope.varOrdenacao = ordena;
	};
	
	$scope.novo = function() {
		$scope.veiculo = "";
	};
	function listarPorCategoria(categoria){
		 $http.get(urlBase +"/veiculo/categoria/{preco:" + categoria.preco +"}")
		    .then(function(response) {
		        $scope.veiculos = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar veiculos por categoria (Chamada GET)");
		    });
	}
})



