var app = angular.module("crudAppLocacao", []);

var urlBase = "http://localhost:8080/Webproject/rest";

app.controller("PesquisaMultaLocCtrl", function($scope, $http) {	
	
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
			"valor" : "",
			"descricao" : ""
		};
	


	
	$scope.seleciona = function(multa) {
			$scope.multa = multa;
			new multa(multa.valor, multa.descricao); 	
	};
	


	$scope.ordena = function(ordena){
		$scope.varOrdenacao = ordena;
	};
	
	$scope.novo = function() {
		$scope.multa = "";
	};
	
	function listarPorLocacao(locacao){
		 $http.get(urlBase +"/multa/locacao/" + locacao.idLocacao)
		    .then(function(response) {
		        $scope.multas = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar multas por locacao (Chamada GET)");
		    });
	}
})



