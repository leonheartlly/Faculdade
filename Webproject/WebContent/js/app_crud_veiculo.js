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
//		var pos = getVeiculoPos($scope.veiculo);
//		if($scope.veiculo != null) {
//			if(window.confirm("Tem certeza??")) {
				deletarVeiculo($scope.veiculo);
//			}
//		}else{
//				window.alert("Não existe veiculo com este Id");
//			}
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

Veiculo = function(marca, modelo, ano, valor, observacao) {
	this.marca = marca;
	this.modelo = modelo;
	this.ano = ano;
	this.valor = valor;
	this.observacao = observacao;
	
	Veiculo.prototype.toString = function() {
		return marca + " " + modelo + " " + ano;
	};
}
