CREATE DATABASE IF NOT EXISTS `locacao` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `locacao`;
-- Copiando estrutura para tabela locacao.multa
CREATE TABLE IF NOT EXISTS `multa` (
  `idMulta` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) NOT NULL,
  `valor` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`idMulta`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela locacao.multa: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `multa` DISABLE KEYS */;
INSERT INTO `multa` (`idMulta`, `descricao`, `valor`) VALUES
	(1, 'avanço de sinal vermelho', 180.00),
	(2, 'excesso de velocidade', 90.00),
	(3, 'ultrapassagem louca', 1000.00),
	(6, 'ultrapassagem por baixo', 10.00);
/*!40000 ALTER TABLE `multa` ENABLE KEYS */;

-- Copiando estrutura para tabela locacao.avaria
CREATE TABLE IF NOT EXISTS `avaria` (
  `idAvaria` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) NOT NULL,
  `valor` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`idAvaria`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela locacao.avaria: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `avaria` DISABLE KEYS */;
INSERT INTO `avaria` (`idAvaria`, `descricao`, `valor`) VALUES
	(1, 'quebra parabrisa', NULL),
	(2, 'amassado no parachoque', NULL),
	(3, 'roda empenada', NULL),
	(4, 'roda quebrada', NULL);
/*!40000 ALTER TABLE `avaria` ENABLE KEYS */;


-- Copiando estrutura para tabela locacao.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `preco` decimal(18,2) DEFAULT NULL,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela locacao.categoria: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`idCategoria`, `preco`, `descricao`) VALUES
	(1, 45000.00, 'Carro básico.'),
	(2, 90000.00, 'Completo menos ar.'),
	(3, 140000.00, 'Carro completo.');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;


-- Copiando estrutura para tabela locacao.veiculo
CREATE TABLE IF NOT EXISTS `veiculo` (
  `idVeiculo` int(11) NOT NULL AUTO_INCREMENT,
  `idCategoria` int(11) DEFAULT NULL,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `ano` int(11) DEFAULT NULL,
  `valor` decimal(18,2) DEFAULT NULL,
  `observacao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idVeiculo`),
  KEY `fk_Veiculo_Categoria_idx` (`idCategoria`),
  CONSTRAINT `fk_Veiculo_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela locacao.veiculo: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `veiculo` DISABLE KEYS */;
INSERT INTO `veiculo` (`idVeiculo`, `idCategoria`, `marca`, `modelo`, `ano`, `valor`, `observacao`) VALUES
	(1, 1, 'ford focus', 'Sedan', 2015, NULL, NULL),
	(2, 1, 'vw fusca', 'hatch', 2014, NULL, NULL),
	(3, 2, 'bmw serie x', 'Sedan', 2011, 150000.00, NULL),
	(5, 1, 'ford ka', 'hatch', 2016, 45000.00, 'ipva pago'),
	(6, 1, 'r', 'r', 56, 56.00, 'teste'),
	(7, 2, 'classic', 'Sedan', 206, NULL, NULL),
	(8, 1, 'gol', 'h', 2000, 2500.00, 'nada');


-- Copiando estrutura para tabela locacao.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `cpf` varchar(14) NOT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `telefone` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela locacao.cliente: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`idCliente`, `nome`, `cpf`, `endereco`, `telefone`) VALUES
	(1, 'Fulano', '111.111.111-11', 'Rua X 555', '2222-2222'),
	(2, 'Ciclano', '222.222.222-22', 'Rua Y 666', '3333-3333'),
	(3, 'Beltrano', '333.333.333-33', 'Rua Z 777', '4444-4444'),
	(4, 'Teste', '500.500.500-50', 'Rua H 999', '9999-9999');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


-- Copiando estrutura para tabela locacao.funcionario
CREATE TABLE IF NOT EXISTS `funcionario` (
  `idfuncionario` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` varchar(45) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `telefone` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`idfuncionario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela locacao.funcionario: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` (`idfuncionario`, `matricula`, `nome`, `endereco`, `telefone`) VALUES
	(1, 'A120', 'Osama', 'Rua A 730', '1111-1111'),
	(2, 'B420', 'Magneto', 'Rua B 760', '2222-222'),
	(3, 'C720', 'Barack Obama', 'Rua H 888', '3333-3333');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;


-- Copiando estrutura para tabela locacao.locacao
CREATE TABLE IF NOT EXISTS `locacao` (
  `idLocacao` int(11) NOT NULL AUTO_INCREMENT,
  `idVeiculo` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idFuncionario_cad` int(11) NOT NULL,
  `idFuncionario_rec` int(11) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `hora` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`idLocacao`),
  KEY `fk_Locacao_Veiculo1_idx` (`idVeiculo`),
  KEY `fk_Locacao_Cliente1_idx` (`idCliente`),
  KEY `fk_Locacao_Funcionario1_idx` (`idFuncionario_cad`),
  KEY `fk_Locacao_Funcionario2_idx` (`idFuncionario_rec`),
  CONSTRAINT `fk_Locacao_Cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Locacao_Funcionario1` FOREIGN KEY (`idFuncionario_cad`) REFERENCES `funcionario` (`idfuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Locacao_Funcionario2` FOREIGN KEY (`idFuncionario_rec`) REFERENCES `funcionario` (`idfuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Locacao_Veiculo1` FOREIGN KEY (`idVeiculo`) REFERENCES `veiculo` (`idVeiculo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela locacao.locacao: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `locacao` DISABLE KEYS */;
INSERT INTO `locacao` (`idLocacao`, `idVeiculo`, `idCliente`, `idFuncionario_cad`, `idFuncionario_rec`, `data`, `hora`) VALUES
	(1, 1, 1, 1, NULL, '2016-01-10', NULL),
	(2, 1, 2, 1, 2, '2016-01-11', NULL),
	(3, 2, 2, 2, NULL, '2016-02-13', NULL),
	(4, 3, 1, 2, 1, '2016-03-15', NULL);
/*!40000 ALTER TABLE `locacao` ENABLE KEYS */;


-- Copiando estrutura para tabela locacao.locacao_avaria
CREATE TABLE IF NOT EXISTS `locacao_avaria` (
  `idAvaria` int(11) NOT NULL,
  `idLocacao` int(11) NOT NULL,
  PRIMARY KEY (`idAvaria`,`idLocacao`),
  KEY `fk_Avaria_has_Locacao_Locacao1_idx` (`idLocacao`),
  KEY `fk_Avaria_has_Locacao_Avaria1_idx` (`idAvaria`),
  CONSTRAINT `fk_Avaria_has_Locacao_Avaria1` FOREIGN KEY (`idAvaria`) REFERENCES `avaria` (`idAvaria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Avaria_has_Locacao_Locacao1` FOREIGN KEY (`idLocacao`) REFERENCES `locacao` (`idLocacao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela locacao.locacao_avaria: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `locacao_avaria` DISABLE KEYS */;
INSERT INTO `locacao_avaria` (`idAvaria`, `idLocacao`) VALUES
	(1, 1),
	(2, 1),
	(3, 2),
	(1, 3);
/*!40000 ALTER TABLE `locacao_avaria` ENABLE KEYS */;


-- Copiando estrutura para tabela locacao.locacao_multa
CREATE TABLE IF NOT EXISTS `locacao_multa` (
  `idLocacao` int(11) NOT NULL,
  `idMulta` int(11) NOT NULL,
  PRIMARY KEY (`idLocacao`,`idMulta`),
  KEY `fk_Locacao_has_Multa_Multa1_idx` (`idMulta`),
  KEY `fk_Locacao_has_Multa_Locacao1_idx` (`idLocacao`),
  CONSTRAINT `fk_Locacao_has_Multa_Locacao1` FOREIGN KEY (`idLocacao`) REFERENCES `locacao` (`idLocacao`),
  CONSTRAINT `fk_Locacao_has_Multa_Multa1` FOREIGN KEY (`idMulta`) REFERENCES `multa` (`idMulta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela locacao.locacao_multa: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `locacao_multa` DISABLE KEYS */;
INSERT INTO `locacao_multa` (`idLocacao`, `idMulta`) VALUES
	(1, 1),
	(2, 2),
	(3, 3);
/*!40000 ALTER TABLE `locacao_multa` ENABLE KEYS */;

