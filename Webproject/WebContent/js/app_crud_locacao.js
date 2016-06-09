var app = angular.module("crudAppLocacao", []);

var urlBase = "http://localhost:8080/Webproject/rest";

app.controller("LocacaoCtrl", function($scope, $http) {	
	
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
	
	//Pesquisa por Funcionario
	function listarPorFuncionario(funcionario){
		 $http.get(urlBase +"/locacao/funcionario/{id:" + funcionario.idfuncionario + "}")
		    .then(function(response) {
		        $scope.locacoes = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar locacoes por funcionario (Chamada GET)");
		    });
	}
	
	//Pesquisa por Veiculo
	function listarPorVeiculo(veiculo){
		 $http.get(urlBase +"/locacao/veiculo/{id:" + veiculo.idVeiculo + "}")
		    .then(function(response) {
		        $scope.locacoes = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar locacoes por veiculo (Chamada GET)");
		    });
	}
	
	//Pesquisa por Mes
	function listarPorMes(mes){
		 $http.get(urlBase +"/locacao/mes/{mes:" + mes + "}")
		    .then(function(response) {
		        $scope.locacoes = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar locacoes por mes (Chamada GET)");
		    });
	}
	
	function atualizar(locacao) {
		 $http.put(urlBase +"/locacao/"+locacao.idlocacao, locacao)
		    .then(function(response) {
		        $scope.locacao = response.data;
		        listar();
		    }, function(response){
		    	window.alert("Erro ao atualizar locacao(Chamada PUT)");
		    });
		
	}
	
	function inserir(locacao) {
		 $http.post(urlBase +"/locacao",locacao)
		    .then(function(response) {
		        $scope.locacao = response.data;
		        listar();
		    }, function(response){
		    	window.alert("Erro ao inserir locacao(Chamada POST)");
		    });
		
	}
	
	$scope.salvar = function() {
		if($scope.locacao.idlocacao == null || $scope.locacao.idlocacao =="") {
			inserir($scope.locacao);
		} else {
			atualizar($scope.locacao);
		}
	}
	
	function deletarlocacao(locacao) {
		 $http['delete'](urlBase +"/locacao/" + locacao.idlocacao)
		    .then(function(response) {
		        $scope.locacao = "";
		        listar();
		    }, function(response){
		    	window.alert("Erro ao deletar locacao(Chamada DELETE)");
		    });
		
	}

	$scope.deletar = function() {
//		var pos = getlocacaoPos($scope.locacao);
//		if($scope.locacao != null) {
//			if(window.confirm("Tem certeza??")) {
				deletarlocacao($scope.locacao);
//			}
//		}else{
//				window.alert("Não existe locacao com este Id");
//			}
	};
})
