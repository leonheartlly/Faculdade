var app = angular.module("crudAppLocacao", []);

var urlBase = "http://localhost:8080/Webproject/rest";

app.controller("CategoriaCtrl", function($scope, $http) {	
	
	function listar(){
		 $http.get(urlBase +"/categoria")
		    .then(function(response) {
		        $scope.categorias = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar categorias(Chamada GET)");
		    });
	}
	
	listar();	
	
	$scope.categoria = {
			"id" : "",
			"descricao" : "",
			"preco" : ""
		};
	
	
	$scope.seleciona = function(categoria) {
			$scope.categoria = categoria;
			new Categoria(categoria.id, categoria.descricao, categoria.preco); 	
	};
	

	$scope.ordena = function(ordena){
		$scope.varOrdenacao = ordena;
	};
	
	$scope.novo = function() {
		$scope.categoria = "";
	};
	
	function atualizar(categoria) {
		 $http.put(urlBase +"/categoria/"+categoria.idCategoria, categoria)
		    .then(function(response) {
		        $scope.categoria = response.data;
		        listar();
		    }, function(response){
		    	window.alert("Erro ao atualizar categoria(Chamada PUT)");
		    });
		
	}
	
	function inserir(categoria) {
		 $http.post(urlBase +"/categoria",categoria)
		    .then(function(response) {
		        $scope.categoria = response.data;
		        listar();
		    }, function(response){
		    	window.alert("Erro ao inserir categoria(Chamada POST)");
		    });
		
	}
	
	$scope.salvar = function() {
		if($scope.categoria.idCategoria == null || $scope.categoria.idCategoria =="") {
			inserir($scope.categoria);
		} else {
			atualizar($scope.categoria);
		}
	}
	
	function deletarCategoria(categoria) {
		 $http['delete'](urlBase +"/categoria/" + categoria.idCategoria)
		    .then(function(response) {
		        $scope.categoria = "";
		        listar();
		    }, function(response){
		    	window.alert("Erro ao deletar categoria(Chamada DELETE)");
		    });
		
	}

	$scope.deletar = function() {
		deletarCategoria($scope.categoria);
	};
})

var Categoria = function(id, descricao, preco) {
	this.id = id;
	this.descricao = descricao;
	this.preco = preco;
};

