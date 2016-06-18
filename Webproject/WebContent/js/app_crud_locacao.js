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
			new Locacao(locacao.idVeiculo, locacao.idCliente, locacao.idFuncionario_cad, locacao.idFuncionario_ret, locacao.data, locacao.hora); 	
	};
	
	//Inicializa Multa para o Modal
	$scope.prepararMulta = function(locacao) {
		$scope.multa = new Multa(locacao);
	};
	
	//Inicializa Avaria para o Modal
	$scope.prepararAvaria = function(locacao) {
		$scope.avaria = new Avaria(locacao);	
	};

	$scope.ordena = function(ordena){
		$scope.varOrdenacao = ordena;
	};
	
	$scope.novo = function() {
		$scope.locacao = "";
	};
	
	//Limpa Pesquisa
	$scope.limpar = function(){
		$scope.locacoes = null;
	}
	
	//Pesquisa por Funcionario
	$scope.listarPorFuncionario = function(funcionario){
		 $http.get(urlBase +"/locacao/funcionario/" + funcionario.idfuncionario)
		    .then(function(response) {
		        $scope.locacoes = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar locacoes por funcionario (Chamada GET)");
		    });
	}
	
	//Pesquisa por Veiculo
	$scope.listarPorVeiculo = function(veiculo){
		 $http.get(urlBase +"/locacao/veiculo/" + veiculo.idVeiculo)
		    .then(function(response) {
		        $scope.locacoes = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar locacoes por veiculo (Chamada GET)");
		    });
	}
	
	//Pesquisa por Mes
	$scope.listarPorMes = function(mes){
		 $http.get(urlBase +"/locacao/mes/" + mes)
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
		deletarlocacao($scope.locacao);
	};
})

var Locacao = function(idVeiculo, idCliente, idFuncionario_cad, idFuncionario_ret, data, hora) {
	this.idVeiculo = idVeiculo;
	this.idCliente = idCliente;
	this.idFuncionario_cad = idFuncionario_cad;
	this.idFuncionario_ret = idFuncionario_ret;
	this.data = data;
	this.hora = hora;
};

