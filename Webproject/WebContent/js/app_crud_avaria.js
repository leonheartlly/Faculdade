var app = angular.module("crudAppLocacao", []);

var urlBase = "http://localhost:8080/Webproject/rest";

app.controller("AvariaCtrl", function($scope, $http) {	
	
	function listar(){
		 $http.get(urlBase +"/avaria")
		    .then(function(response) {
		        $scope.avarias = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar avarias(Chamada GET)");
		    });
	}
	
	listar();
	
	$scope.avaria = {
			"id" : "",
			"valor" : "",
			"descricao" : ""
		};
	
	
	$scope.seleciona = function(avaria) {
			$scope.avaria = avaria;
			new Avaria(avaria.id, avaria.valor, avaria.descricao); 	
	};
	


	$scope.ordena = function(ordena){
		$scope.varOrdenacao = ordena;
	};
	
	$scope.novo = function() {
		$scope.avaria = "";
	};
	
	//Limpa a pesquisa
	$scope.limpar = function(){
		$scope.avarias = null;
	}
	
	//Pesquisa por locacao
	$scope.listarPorLocacao = function(locacao){
		 $http.get(urlBase +"/avaria/locacao/" + locacao.idLocacao)
		    .then(function(response) {
		        $scope.avarias = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar avarias por locacao (Chamada GET)");
		    });
	}
	
	function atualizar(avaria) {
		 $http.put(urlBase +"/avaria/"+avaria.idAvaria, avaria)
		    .then(function(response) {
		        $scope.avaria = response.data;
		        listar();
		    }, function(response){
		    	window.alert("Erro ao atualizar avaria(Chamada PUT)");
		    });
		
	}
	
	function inserir(avaria) {
		 $http.post(urlBase +"/avaria",avaria)
		    .then(function(response) {
		        $scope.avaria = response.data;
		        listar();
		    }, function(response){
		    	window.alert("Erro ao inserir avaria(Chamada POST)");
		    });
		
	}
	
	$scope.salvar = function() {
		if($scope.avaria.idAvaria == null || $scope.avaria.idAvaria =="") {
			inserir($scope.avaria);
		} else {
			atualizar($scope.avaria);
		}
	}
	
	function deletarAvaria(avaria) {
		 $http['delete'](urlBase +"/avaria/" + avaria.idAvaria)
		    .then(function(response) {
		        $scope.avaria = "";
		        listar();
		    }, function(response){
		    	window.alert("Erro ao deletar avaria(Chamada DELETE)");
		    });
		
	}

	$scope.deletar = function() {
		deletarAvaria($scope.avaria);
	};
})

var Avaria = function(id, descricao, valor) {
	this.id = id;
	this.descricao = descricao;
	this.valor = valor;
};
