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
			"preco" : "",
			"descricao" : ""
		};
	


	
	$scope.seleciona = function(categoria) {
			$scope.categoria = categoria;
			new categoria(categoria.preco, categoria.descricao); 	
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



