var categoriaApp = angular.module("CategoriaControllers", []);

var urlBase = "http://localhost:8080/Webproject/rest";

categoriaApp.controller("CategoriaController", function($scope, $http) {
	
	
	function listar(){
		 $http.get(urlBase +"/categoria")
		    .then(function(response) {
		        $scope.categorias = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar categoria(Chamada GET)");
		    });
	}
	
	listar();
	
	$scope.seleciona = function(categoria) {
			$scope.categoria = categoria;
			new Categoria(categoria.idCategoria, categoria.preco, categoria.descricao); 	
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
		var pos = getCategoriaPos($scope.categoria);
		if(pos >=0 ) {
			if(window.confirm("Tem certeza??")) {
				deletarCategoria($scope.categoria);
			}else{
				window.alert("Não existe categoria com este Id");
			}
		}
	};
	
	function getCategoriaPos(categoria) {
		for(i=0; i<$scope.categorias.length; i++) {
			if($scope.categorias[i].idCategoria === categoria.idCategoria) {
				return i;
			}
		}
		return -1;
	}
	
//	function clienteValida(cliente) {
//		var expRel = new RegExp("^\\d{3}\\.\\d{3}\\-\\d{2}$");
//		if(expRel.test(cliente.cpf) && cliente.nome != null 
//			&& cliente.nome.length > 0 ) {
//			return true;
//		}
//		return false;
//	}
});

Categoria = function(idCategoria, descricao, preco) {
	this.idCategoria = idCategoria;
	this.descricao = descricao;
	this.preco = preco;
	
	Categoria.prototype.toString = function() {
		return descricao;
	};
}
