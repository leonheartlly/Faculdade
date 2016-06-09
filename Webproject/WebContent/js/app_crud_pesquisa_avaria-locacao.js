var app = angular.module("crudAppLocacao", []);

var urlBase = "http://localhost:8080/Webproject/rest";

app.controller("PesquisaAvariaLocCtrl", function($scope, $http) {	
	
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
			"valor" : "",
			"descricao" : ""
		};
	


	
	$scope.seleciona = function(avaria) {
			$scope.avaria = avaria;
			new avaria(avaria.valor, avaria.descricao); 	
	};
	


	$scope.ordena = function(ordena){
		$scope.varOrdenacao = ordena;
	};
	
	$scope.novo = function() {
		$scope.avaria = "";
	};
	
	function listarPorLocacao(locacao){
		 $http.get(urlBase +"/avaria/locacao/" + locacao.idLocacao)
		    .then(function(response) {
		        $scope.avarias = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar avarias por locacao (Chamada GET)");
		    });
	}
})




