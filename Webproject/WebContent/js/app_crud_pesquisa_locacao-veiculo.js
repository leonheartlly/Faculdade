var app = angular.module("crudAppLocacao", []);

var urlBase = "http://localhost:8080/Webproject/rest";

app.controller("PesquisaLocacaoVeicCtrl", function($scope, $http) {	
	
	function listar(){
		 $http.get(urlBase +"/locacao")
		    .then(function(response) {
		        $scope.locacoes = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar locacoes(Chamada GET)");
		    });
	}
	
	listar();
	
	$scope.locacao = {
			"idVeiculo" : "",
			"idCliente" : "",
			"idFuncionario_cad" : "",
			"idFuncionario_ret" : "",
			"data" : "",
			"hora" : ""
		};
	


	
	$scope.seleciona = function(locacao) {
			$scope.locacao = locacao;
			new locacao(locacao.idVeiculo, locacao.idCliente, locacao.idFuncionario_cad, locacao.idFuncionario_ret, locacao.data, locacao.hora); 	
	};
	


	$scope.ordena = function(ordena){
		$scope.varOrdenacao = ordena;
	};
	
	$scope.novo = function() {
		$scope.locacao = "";
	};
	
	function listarPorVeiculo(veiculo){
		 $http.get(urlBase +"/locacao/veiculo/{id:" + veiculo.idVeiculo + "}")
		    .then(function(response) {
		        $scope.locacoes = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar locacoes por veiculo (Chamada GET)");
		    });
	}
})
