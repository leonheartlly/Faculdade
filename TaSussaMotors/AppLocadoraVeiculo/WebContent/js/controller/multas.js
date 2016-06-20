var multaApp = angular.module("MultaControllers", []);

var urlBase = "http://localhost:8080/Webproject/rest";

multaApp.controller("MultaController", function($scope, $http) {
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
			new Multa(multa.idMulta, multa.valor, multa.descricao); 	
	};
	


	$scope.ordena = function(ordena){
		$scope.varOrdenacao = ordena;
	};
	
	$scope.novo = function() {
		$scope.multa = "";
	};
	
	//Pesquisa por Locacao
	$scope.listarPorLocacao = function (locacao){
		 $http.get(urlBase +"/multa/locacao/"+locacao.idLocacao)
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
	
	$scope.buscaMultaLocacao = function() {
		if($scope.locacao.idLocacao == null || $scope.locacao.idLocacao =="") {
			window.alert("Numero de locacao inválido");
		} else {
			listarPorLocacao($scope.locacao);
		}
	}

	$scope.deletar = function() {
		var pos = getMultaPos($scope.multa);
		if(pos >=0 ) {
			if(window.confirm("Tem certeza??")) {
				deletarMulta($scope.multa);
			}else{
				window.alert("Não existe multa com este Id");
			}
		}
	};
	
	function getMultaPos(multa) {
		for(i=0; i<$scope.multas.length; i++) {
			if($scope.multas[i].idMulta === multa.idMulta) {
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

Multa = function(idMulta, descricao, valor) {
	this.idMulta = descricao;
	this.valor = valor;
	this.descricao = descricao;	
	Veiculo.prototype.toString = function() {
		return descricao + " " + valor;
	};
}
