/*
-- Query: SELECT * FROM mydatabase.reserva
LIMIT 0, 1000

-- Date: 2014-11-27 16:40
*/

CREATE  TABLE users (

  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));


CREATE TABLE user_roles (
  user_role_id INT(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  ROLE VARCHAR(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (ROLE,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));

create table cliente(
id_cliente int not null primary key auto_increment,
nome varchar(50) not null,
idade int not null,
cpf varchar(20) not null,
email varchar(30),
telefone varchar(15) not null,
endereco varchar(50) not null,
bairro varchar(20) not null,
estado varchar(2) not null,
cep varchar(10) not null,
pais varchar(10) not null,
numero varchar(10) not null,
data varchar(20) not null,
cidade varchar(40) not null,
username varchar(50),
FOREIGN KEY (username) REFERENCES users(username)
);

/*create table contato(
id_contato int not null primary key auto_increment,
email varchar(20) not null,
assunto varchar(20) not null,
nome varchar(20) not null,
mensagem varchar(800) not null
);*/

create table hotel(
id_hotel int not null primary key auto_increment,
nome varchar(30) not null,
cnpj varchar(14) not null,
qtdestrelas varchar(10) not null,
preco float not null,
ddd varchar(4) not null,
telefone varchar(10) not null,
qtd_quarto int not null,
pais varchar(20) not null,
linkTitle varchar(100) not null,
link1 varchar(100) not null,
link2 varchar(100) not null,
link3 varchar(100) not null,
descricao varchar(500) not null,
cidade varchar(50) not null
);

create table funcionario(
funcionario_id int not null primary key auto_increment,
nome varchar(30) not null,
idade varchar(3) not null,
cpf varchar(15) not null,
email varchar(50) not null,
sexo varchar(20) not null,
telefone varchar(20) not null,
ddd varchar(4) not null,
endereco varchar(50) not null,
bairro varchar(50) not null,
estado varchar(2) not null,
cep varchar(20),
pais varchar(20),
username varchar(50),
FOREIGN KEY (username) REFERENCES users(username)
);

/*create table galeria(
id int not null primary key auto_increment,
link varchar(200) not null
);*/
create table companhia(
companhia_id int not null primary key auto_increment,
nome_companhia varchar(20) not null,
cnpj varchar(14),
ddd varchar(3),
telefone varchar(10),
tipoCompanhia varchar(20)
);



create table destino(
id_destino int not null primary key auto_increment,
cidadedestino varchar(20) not null,
paisdestino varchar(20),
link1 varchar(100),
link2 varchar(100),
link3 varchar(100),
descricao varchar(500)
);

create table pacote(
pacote_id int not null primary key auto_increment,
nome_pacote varchar(20) not null,
cidade_saida varchar(20) not null,
pais_saida varchar(20) not null,
data_inicio date not null,
data_fim date not null,
valor_pacote float not null,
qtd_pct int not null,
id_destino int,
id_hotel int,
companhia_id int,
id_cliente int,
funcionario_id int,
FOREIGN KEY (id_destino) REFERENCES destino(id_destino),
FOREIGN KEY (id_hotel) REFERENCES hotel(id_hotel),
FOREIGN KEY (companhia_id) REFERENCES companhia(companhia_id),
FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
FOREIGN KEY (funcionario_id) REFERENCES funcionario(funcionario_id)
);

create table reserva(
id_reserva int not null primary key auto_increment,
qtd_compra int not null,
id_cliente int,
id_pacote int,
FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
FOREIGN KEY (id_pacote) REFERENCES pacote(pacote_id)
);


