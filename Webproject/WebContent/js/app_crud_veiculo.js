var app = angular.module("crudAppLocacao", []);

var urlBase = "http://localhost:8080/Webproject/rest";

app.controller("VeiculoCtrl", function($scope, $http) {	
	
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
			"id" : "",
			"marca" : "",
			"modelo" : "",
			"ano" : "",
			"valor" : "",
			"observacao" : ""
		};
	


	
	$scope.seleciona = function(veiculo) {
			$scope.veiculo = veiculo;
			new Veiculo(veiculo.id, veiculo.ano, veiculo.marca, veiculo.modelo, veiculo.observacao, veiculo.valor); 	
	};
	


	$scope.ordena = function(ordena){
		$scope.varOrdenacao = ordena;
	};
	
	$scope.novo = function() {
		$scope.veiculo = "";
	};
	
	//Limpa lista
	$scope.limpar = function(){
		$scope.veiculos = null;
	}
	
	//Pesquisa por Categoria
	$scope.listarPorCategoria = function(categoria){
		 $http.get(urlBase +"/veiculo/categoria/" + categoria.idCategoria)
		    .then(function(response) {
		        $scope.veiculos = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar veiculos por categoria (Chamada GET)");
		    });
	}
	
	function atualizar(veiculo) {
		 $http.put(urlBase +"/veiculo/"+veiculo.idVeiculo, veiculo)
		    .then(function(response) {
		        $scope.veiculo = response.data;
		        listar();
		    }, function(response){
		    	window.alert("Erro ao atualizar veiculo(Chamada PUT)");
		    });
		
	}
	
	function inserir(veiculo) {
		 $http.post(urlBase +"/veiculo",veiculo)
		    .then(function(response) {
		        $scope.veiculo = response.data;
		        listar();
		    }, function(response){
		    	window.alert("Erro ao inserir veiculo(Chamada POST)");
		    });
		
	}
	
	$scope.salvar = function() {
		if($scope.veiculo.idVeiculo == null || $scope.veiculo.idVeiculo =="") {
			inserir($scope.veiculo);
		} else {
			atualizar($scope.veiculo);
		}
	}
	
	function deletarVeiculo(veiculo) {
		 $http['delete'](urlBase +"/veiculo/" + veiculo.idVeiculo)
		    .then(function(response) {
		        $scope.veiculo = "";
		        listar();
		    }, function(response){
		    	window.alert("Erro ao deletar veiculo(Chamada DELETE)");
		    });
		
	}

	$scope.deletar = function() {
		deletarVeiculo($scope.veiculo);

	};
	
	function getVeiculoPos(veiculo) {
		for(i=0; i<$scope.veiculos.length; i++) {
			if($scope.veiculos[i].modelo === veiculo.modelo) {
				return i;
			}
		}
		return -1;
	}
	
	function veiculoValida(veiculo) {
		//TODO
	}
})

var Veiculo = function(id, ano, marca, modelo, observacao, valor){
	this.id = id;
	this.marca = marca;
	this.modelo = modelo;
	this.ano = ano;
	this.valor = valor;
	this.observacao = observacao;
	
	Veiculo.prototype.toString = function() {
		return marca + " " + modelo + " " + ano;
	};
}
