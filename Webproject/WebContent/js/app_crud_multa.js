var app = angular.module("crudAppLocacao", []);

var urlBase = "http://localhost:8080/Webproject/rest";

app.controller("MultaCtrl", function($scope, $http) {	
	
	function listar(){
		 $http.get(urlBase +"/multa")
		    .then(function(response) {
		        $scope.multas = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar multas(Chamada GET)");
		    });
	}
	
	listar();
	
	$scope.multa = {
			"id" : "",
			"valor" : "",
			"descricao" : ""
		};
	


	
	$scope.seleciona = function(multa) {
			$scope.multa = multa;
			new Multa(multa.id, multa.valor, multa.descricao); 	
	};
	


	$scope.ordena = function(ordena){
		$scope.varOrdenacao = ordena;
	};
	
	$scope.novo = function() {
		$scope.multa = "";
	};
	
	//Pesquisa por Locacao
	function listarPorLocacao(locacao){
		 $http.get(urlBase +"/multa/locacao/" + locacao.idLocacao)
		    .then(function(response) {
		        $scope.multas = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar multas por locacao (Chamada GET)");
		    });
}
	
	
	function atualizar(multa) {
		 $http.put(urlBase +"/multa/"+multa.idMulta, multa)
		    .then(function(response) {
		        $scope.multa = response.data;
		        listar();
		    }, function(response){
		    	window.alert("Erro ao atualizar multa(Chamada PUT)");
		    });
		
	}
	
	function inserir(multa) {
		 $http.post(urlBase +"/multa",multa)
		    .then(function(response) {
		        $scope.multa = response.data;
		        listar();
		    }, function(response){
		    	window.alert("Erro ao inserir multa(Chamada POST)");
		    });
		
	}
	
	$scope.salvar = function() {
		if($scope.multa.idMulta == null || $scope.multa.idMulta =="") {
			inserir($scope.multa);
		} else {
			atualizar($scope.multa);
		}
	}
	
	function deletarMulta(multa) {
		 $http['delete'](urlBase +"/multa/" + multa.idMulta)
		    .then(function(response) {
		        $scope.multa = "";
		        listar();
		    }, function(response){
		    	window.alert("Erro ao deletar multa(Chamada DELETE)");
		    });
		
	}

	$scope.deletar = function() {
		deletarMulta($scope.multa);
	};
})


var Multa = function(id, valor, descricao) {
	this.id = id;
	this.valor = valor;
	this.descricao = descricao;
	
}

