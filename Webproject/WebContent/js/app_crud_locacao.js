var app = angular.module("crudAppLocacao", []);

var urlBase = "http://localhost:8080/Webproject/rest";

app.controller("ClienteCtrl", function($scope, $http) {	
	
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
			"cpf" : "um cpf",
			"nome" : "um nome",
			"endereco" : "um endereço",
			"telefone" : "um telefone"
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
	
	function atualizar(cliente) {
		 $http.put(urlBase +"/cliente"+cliente.idCliente, cliente)
		    .then(function(response) {
		        $scope.cliente = response.data;
		        listar();
		    }, function(response){
		    	window.alert("Erro ao atualizar cliente(Chamada PUT)");
		    });
		
	}
	
	function inserir(cliente) {
		 $http.post(urlBase +"/cliente",cliente)
		    .then(function(response) {
		        $scope.cliente = response.data;
		        listar();
		    }, function(response){
		    	window.alert("Erro ao inserir cliente(Chamada POST)");
		    });
		
	}
	
	$scope.salvar = function() {
		if($scope.cliente.idCliente == null || $scope.cliente.idCliente =="") {
			inserir($scope.cliente);
		} else {
			atualizar($scope.cliente);
		}
	}
	
	function deletarCliente(cliente) {
		 $http['delete'](urlBase +"/cliente/" + cliente.idCliente)
		    .then(function(response) {
		        $scope.cliente = "";
		        listar();
		    }, function(response){
		    	window.alert("Erro ao deletar cliente(Chamada DELETE)");
		    });
		
	}

	$scope.deletar = function() {
		var pos = getClientePos($scope.cliente);
		if(pos >=0 ) {
			if(window.confirm("Tem certeza??")) {
				deletarCliente($scope.cliente);
			}else{
				window.alert("Não existe cliente com este Id");
			}
		}
	};
	
	function getClientePos(cliente) {
		for(i=0; i<$scope.clientes.length; i++) {
			if($scope.clientes[i].cpf === cliente.cpf) {
				return i;
			}
		}
		return -1;
	}
	
	function clienteValida(cliente) {
		var expRel = new RegExp("^\\d{3}\\.\\d{3}\\-\\d{2}$");
		if(expRel.test(cliente.cpf) && cliente.nome != null 
			&& cliente.nome.length > 0 ) {
			return true;
		}
		return false;
	}
})

Cliente = function(cpf, nome, endereco, telefone) {
	this.cpf = cpf;
	this.nome = nome;
	this.endereco = endereco;
	this.telefone = telefone;
	
	Cliente.prototype.toString = function() {
		return nome + " " + cpf;
	};
}
