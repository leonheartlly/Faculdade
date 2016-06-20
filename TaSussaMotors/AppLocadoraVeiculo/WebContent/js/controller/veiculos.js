var veiculoApp = angular.module("VeiculoControllers", []);

var urlBase = "http://localhost:8080/Webproject/rest";

veiculoApp.controller("VeiculoController", function($scope, $http) {
	
	
	function listar(){
		 $http.get(urlBase +"/veiculo")
		    .then(function(response) {
		        $scope.veiculos = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar veiculos(Chamada GET)");
		    });
		 $http.get(urlBase +"/categoria")
		    .then(function(response) {
		        $scope.categorias = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar categoria(Chamada GET)");
		    });
	}
	
	listar();
	
	$scope.veiculo = {
			"marca" : "",
			"modelo" : "",
			"ano" : "",
			"valor" : "",
			"categoria" : "",
			"observacao" : ""
		};
	
	$scope.seleciona = function(veiculo) {
		$scope.veiculo = veiculo;
		new Veiculo(veiculo.ano, veiculo.marca, veiculo.modelo, veiculo.valor, veiculo.observacao, categoria); 
	};
	

	$scope.ordena = function(ordena){
		$scope.varOrdenacao = ordena;
	};
	
	
	$scope.novo = function() {
		$scope.veiculo = "";
	};
	
	$scope.buscaCategoriaVeiculo = function() {
		if($scope.categoria.idCategoria == null || $scope.categoria.idCategoria =="") {
			window.alert("Numero de categoria inválido");
		} else {
			listarPorCategoria($scope.categoria);
		}
	}
	

	
	function listarPorCategoria(categoria){
		 $http.get(urlBase +"/veiculo/categoria/" + categoria.idCategoria)
		    .then(function(response) {
		        $scope.veiculos = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar veiculos por locacao (Chamada GET)");
		    });
	}
	
	function atualizar(veiculo) {
		 $http.put(urlBase +"/veiculo/"+veiculo.idVeiculo, veiculo)
		    .then(function(response) {
		        $scope.veiculo = response.data;
		        window.alert("Veiculo atualizado(Chamada PUT)");
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
		var pos = getVeiculoPos($scope.veiculo);
		if(pos >=0 ) {
			if(window.confirm("Tem certeza??")) {
				deletarVeiculo($scope.veiculo);
			}else{
				window.alert("Não existe veículo com este Id");
			}
		}
	};
	
	function getVeiculoPos(veiculo) {
		for(i=0; i<$scope.veiculos.length; i++) {
			if($scope.veiculos[i].idVeiculo === veiculo.idVeiculo) {
				return i;
			}
		}
		return -1;
	}
	
/*	function clienteValida(cliente) {
		var expRel = new RegExp("^\\d{3}\\.\\d{3}\\-\\d{2}$");
		if(expRel.test(cliente.cpf) && cliente.nome != null 
			&& cliente.nome.length > 0 ) {
			return true;
		}
		return false;
	}
*/
});

Veiculo = function(ano, marca, modelo, valor, categoria, observacao ) {
	this.marca = marca;
	this.modelo = modelo;
	this.ano = ano;
	this.valor = valor;
	this.observacao = observacao
	this.categoria.idCategoria = categoria.idCategoria;
	this.categoria.preco = categoria.preco;
	this.categoria.descricao = categoria.descricao;
	
	Veiculo.prototype.toString = function() {
		return marca + " " + modelo + " " + ano;
	};
}
