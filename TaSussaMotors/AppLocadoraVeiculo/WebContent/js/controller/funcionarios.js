var funcionarioApp = angular.module("FuncionarioControllers", []);

var urlBase = "http://localhost:8080/Webproject/rest";

funcionarioApp.controller("FuncionarioController", function($scope, $http) {
	
	
	function listar(){
		 $http.get(urlBase +"/funcionario")
		    .then(function(response) {
		        $scope.funcionarios = response.data;
		    }, function(response){
		    	window.alert("Erro ao listar funcionarios(Chamada GET)");
		    });
	}
	
	listar();
	
	$scope.seleciona = function(funcionario) {
			$scope.funcionario = funcionario;
			new Funcionario(funcionario.idfuncionario, funcionario.matricula, funcionario.nome, funcionario.endereco, funcionario.telefone); 	
	};
	


	$scope.ordena = function(ordena){
		$scope.varOrdenacao = ordena;
	};
	
	$scope.novo = function() {
		$scope.funcionario = "";
	};
	
	function atualizar(funcionario) {
		 $http.put(urlBase +"/funcionario/"+funcionario.idfuncionario, funcionario)
		    .then(function(response) {
		        $scope.funcionario = response.data;
		        listar();
		    }, function(response){
		    	window.alert("Erro ao atualizar funcionario(Chamada PUT)");
		    });
		
	}
	
	function inserir(funcionario) {
		 $http.post(urlBase +"/funcionario",funcionario)
		    .then(function(response) {
		        $scope.funcionario = response.data;
		        listar();
		    }, function(response){
		    	window.alert("Erro ao inserir funcionario(Chamada POST)");
		    });
		
	}
	
	$scope.salvar = function() {
		if($scope.funcionario.idfuncionario == null || $scope.funcionario.idfuncionario =="") {
			inserir($scope.funcionario);
		} else {
			atualizar($scope.funcionario);
		}
	}
	
	function deletarFuncionario(funcionario) {
		 $http['delete'](urlBase +"/funcionario/" + funcionario.idfuncionario)
		    .then(function(response) {
		        $scope.funcionario = "";
		        listar();
		    }, function(response){
		    	window.alert("Erro ao deletar funcionario(Chamada DELETE)");
		    });
		
	}

	$scope.deletar = function() {
		var pos = getFuncionarioPos($scope.funcionario);
		if(pos >=0 ) {
			if(window.confirm("Tem certeza??")) {
				deletarFuncionario($scope.funcionario);
			}else{
				window.alert("Não existe funcionario com este Id");
			}
		}
	};
	
	function getFuncionarioPos(funcionario) {
		for(i=0; i<$scope.funcionarios.length; i++) {
			if($scope.funcionarios[i].matricula === funcionario.matricula) {
				return i;
			}
		}
		return -1;
	}

});

Funcionario = function(idfuncionario, matricula, nome, endereco, telefone) {
	this.idfuncionario = idfuncionario;
	this.matricula = matricula;
	this.nome = nome;
	this.endereco = endereco;
	this.telefone = telefone;
	
	Funcionario.prototype.toString = function() {
		return nome + " " + matricula;
	};
}
