var avariaApp = angular.module("AvariaControllers", []);

var urlBase = "http://localhost:8080/Webproject/rest";

avariaApp.controller("AvariaController", function($scope, $http) {
	
	
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
			"descricao" : "",
		};
	
	$scope.seleciona = function(avaria) {
		$scope.avaria = avaria;
		new Avaria(avaria.idAvaria, avaria.descricao); 
	};
	
	
	$scope.ordena = function(ordena){
		$scope.varOrdenacao = ordena;
	};
	
	
	$scope.novo = function() {
		$scope.avaria = "";
	};
	
	$scope.listarPorLocacao = function (locacao){
		 $http.get(urlBase +"/avaria/locacao/" + locacao.idLocacao)
		    .then(function(response) {
		        $scope.avarias = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar avarias por locacao (Chamada GET)");
		    });
	}
	
	$scope.buscaAvariaLocacao = function() {
		if($scope.locacao.idLocacao == null || $scope.locacao.idLocacao =="") {
			window.alert("Numero de locacao inválido");
		} else {
			listarPorLocacao($scope.locacao);
		}
	}
	
	function atualizar(avaria) {
		 $http.put(urlBase +"/avaria/"+avaria.idAvaria, avaria)
		    .then(function(response) {
		        $scope.avaria = response.data;
		        window.alert("avaria atualizada(Chamada PUT)");
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
		if($scope.avaria.idAvaria == null || $scope.avaria.idAvarias =="") {
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
		var pos = getAvariaPos($scope.avaria);
		if(pos >=0 ) {
			if(window.confirm("Tem certeza??")) {
				deletarAvaria($scope.avaria);
			}else{
				window.alert("Não existe avaria com este Id");
			}
		}
	};
	
	function getAvariaPos(avaria) {
		for(i=0; i<$scope.avarias.length; i++) {
			if($scope.avarias[i].idAvaria === avaria.idAvaria) {
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

Avaria = function(idAvaria, descricao) {
	this.idAvaria = idAvaria;
	this.descricao = descricao;
	
	Avaria.prototype.toString = function() {
		return descricao;
	};
}
