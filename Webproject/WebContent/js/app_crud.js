var app = angular.module("appPessoas", []);

app.controller("PessoaCtrl", function($scope) {
	$scope.pessoas = [ {
		"cpf" : "111.222-34",
		"nome" : "Fulano de Tal",
		"endereco" : "Rua Teste, 34",
		"fone" : "2323-4545"
	}, {
		"cpf" : "222.444-55",
		"nome" : "Beltrano o Tal",
		"endereco" : "Rua Final, 67",
		"fone" : "4545-6767"
	}, {
		"cpf" : "333.444-90",
		"nome" : "Ciclano de Tal",
		"endereco" : "Rua Bla, 22",
		"fone" : "6767-8989"
	} ];

	$scope.pessoa = {
		"cpf" : "um cpf",
		"nome" : "um nome",
		"endereco" : "um endereço",
		"fone" : "um telefone"
	};
	
	$scope.seleciona = function(pessoa) {
		$scope.pessoa = pessoa;
		new Pessoa(pessoa.cpf, pessoa.nome, pessoa.endereco, pessoa.fone); 	
	};
	
	$scope.ordena = function(ordena){
		$scope.varOrdenacao = ordena;
	};

	$scope.deletar = function() {
		var pos = getPessoaPos($scope.pessoa);
		if(pos >=0 ) {
			if(window.confirm("Tem certeza??")) {
				$scope.pessoas.splice(pos, 1);
				$scope.novo();
			}
		}
	};
	
	$scope.novo = function() {
		$scope.pessoa = "";
	};
	
	$scope.salvar = function() {
		var pos = getPessoaPos($scope.pessoa.cpf); 
		if(pos === -1 ) {
				$scope.pessoas.push($scope.pessoa);
				$scope.novo();
		} else {
			$scope.pessoas[pos] = $scope.pessoa;
		}
	} 
	
	function getPessoaPos(pessoa) {
		for(i=0; i<$scope.pessoas.length; i++) {
			if($scope.pessoas[i].cpf === pessoa.cpf) {
				return i;
			}
		}
		return -1;
	}

	function pessoaValida(pessoa) {
		var expRel = new RegExp("^\\d{3}\\.\\d{3}\\-\\d{2}$");
		if(expRel.test(pessoa.cpf) && pessoa.nome != null 
			&& pessoa.nome.length > 0 ) {
			return true;
		}
		return false;
	}
})


//usado para construir novos objetos Pessoa
Pessoa = function(cpf, nome, endereco, fone) {
	this.cpf = cpf;
	this.nome = nome;
	this.endereco = endereco;
	this.fone = fone;
	
	Pessoa.prototype.toString = function() {
		return nome + " " + cpf;
	};
}
