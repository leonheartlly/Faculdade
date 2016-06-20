var locacaoApp = angular.module("LocacaoControllers", []);

var urlBase = "http://localhost:8080/Webproject/rest";

locacaoApp.controller("LocacaoController", function($scope, $http) {
	
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
			"idLocacao" : "",
			"idVeiculo" : "",
			"idCliente" : "",
			"idFuncionario_cad" : "",
			"idFuncionario_ret" : "",
			"data" : "",
			"hora" : ""
		};
	


	
	$scope.seleciona = function(locacao) {
			 $http.get(urlBase +"/avaria/locacao/" + locacao.idLocacao)
			    .then(function(response) {
			        $scope.avarias = response.data;
			    }, function(response){
			    	window.alert("Erro ao listar avarias por locacao (Chamada GET)");
			    });
			 
			 $http.get(urlBase +"/multa/locacao/"+locacao.idLocacao)
			    .then(function(response) {
			        $scope.multas = response.data;
			    }, function(response){
			    	window.alert("Erro ao listar multas por locacao (Chamada GET)");
			    });
			 
				$scope.locacao = locacao;
				new Locacao(locacao.idLocacao, locacao.idVeiculo, locacao.idCliente, locacao.idFuncionario_cad, locacao.idFuncionario_ret, locacao.data, locacao.hora); 	
				
	};
	
	// Inicializa Multa para o Modal
	$scope.prepararMulta = function(locacao) {
		$scope.multa = new Multa(locacao);
	};
	
	// Inicializa Avaria para o Modal
	$scope.prepararAvaria = function(locacao) {
		$scope.avaria = new Avaria(locacao);	
	};

	$scope.ordena = function(ordena){
		$scope.varOrdenacao = ordena;
	};
	
	$scope.novo = function() {
		$scope.locacao = "";
	};
	
	// Associa Avaria
	$scope.associarAvaria = function(avaria) {
		$scope.avarias.push(avaria);
		
		$scope.locacao.avarias = $scope.avarias;
		
		 $http.put(urlBase +"/locacao/"+ $scope.locacao.idLocacao, $scope.locacao)
		    .then(function(response) {
		        $scope.locacao = response.data;
		        listar();
		    }, function(response){
		    	window.alert("Erro ao atualizar locacao(Chamada PUT)");
		    });
		 
		 $http.get(urlBase +"/avaria/locacao/" + locacao.idLocacao)
		    .then(function(response) {
		        $scope.avarias = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar avarias por locacao (Chamada GET)");
		    });
	};
	
	// Associa Multa
	$scope.associarMulta = function(multa) {
		$scope.multas.push(multa);
		
		$scope.locacao.multas = $scope.multas;
		
		 $http.put(urlBase +"/locacao/"+ $scope.locacao.idLocacao, $scope.locacao)
		    .then(function(response) {
		        $scope.locacao = response.data;
		        listar();
		    }, function(response){
		    	window.alert("Erro ao atualizar locacao(Chamada PUT)");
		    });
		 
		 $http.get(urlBase +"/multa/locacao/"+locacao.idLocacao)
		    .then(function(response) {
		        $scope.multas = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar multas por locacao (Chamada GET)");
		    });
	};
	
	// Pesquisa por Funcionario
	$scope.listarPorFuncionario = function(funcionario){
		 $http.get(urlBase +"/locacao/funcionario/" + funcionario.idfuncionario)
		    .then(function(response) {
		        $scope.locacoes = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar locacoes por funcionario (Chamada GET)");
		    });
	}
	
	// Pesquisa por Veiculo
	$scope.listarPorVeiculo = function(veiculo){
		 $http.get(urlBase +"/locacao/veiculo/"+ veiculo.idVeiculo)
		    .then(function(response) {
		        $scope.locacoes = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar locacoes por veiculo (Chamada GET)");
		    });
	}
	
	// Pesquisa por Mes
	$scope.listarPorMes = function(mes){
		 $http.get(urlBase +"/locacao/mes/"+ mes)
		    .then(function(response) {
		        $scope.locacoes = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar locacoes por mes (Chamada GET)");
		    });
	}
	
	function atualizar(locacao) {
		 $http.put(urlBase +"/locacao/"+locacao.idLocacao, locacao)
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
		if($scope.locacao.idLocacao == null || $scope.locacao.idLocacao =="") {
			inserir($scope.locacao);
		} else {
			atualizar($scope.locacao);
		}
	}
	
	function deletarLocacao(locacao) {
		 $http['delete'](urlBase +"/locacao/" + locacao.idLocacao)
		    .then(function(response) {
		        $scope.locacao = "";
		        listar();
		    }, function(response){
		    	window.alert("Erro ao deletar locacao(Chamada DELETE)");
		    });
		
	}

	$scope.deletar = function() {
		var pos = getLocacaoPos($scope.locacao);
		if(pos >=0 ) {
			if(window.confirm("Tem certeza??")) {
				deletarLocacao($scope.locacao);
			}else{
				window.alert("Não existe locação com este Id");
			}
		}
	};
	
	function getLocacaoPos(locacao) {
		for(i=0; i<$scope.locacoes.length; i++) {
			if($scope.locacoes[i].matricula === locacao.matricula) {
				return i;
			}
		}
		return -1;
	}
	
	Locacao = function(idLocacao, veiculo, cliente, funcionario_cad, funcionario_rec, data, hora) {
		this.idLocacao = idLocacao;
		this.veiculo.idVeiculo = veiculo.idVeiculo;
		this.cliente.idCliente = cliente.idCliente;
		this.funcionario_cad.matricula = funcionario_cad.matricula;
		this.funcionario_rec.matricula = funcionario_rec.matricula;
		this.data = data;
			
		Rent.prototype.toString = function() {
			return id + " " + vehicle.id;
		};
	}
});


