drop schema lojadanilet;
create schema lojadanilet;
use lojadanilet;

create table Usuario (
	idUsuario int not null auto_increment,
    login varchar(45) not null,
    senha varchar(45) not null,
    tipo varchar(45) not null,
    primary key(idUsuario)
);

create table Marca(
	idMarca int not null auto_increment,
    nomeMarca varchar(45) not null,
    representanteComercial varchar(45) not null,
    primary key (idMarca)
);

create table Produto(
	idProduto int not null auto_increment,
    nomeProduto varchar(45) not null,
    preco decimal(10,2) not null,
    quantidadeEstoque int not null,
    idMarca int not null,
    primary key (idProduto),
    foreign key (idMarca) references Marca(idMarca)
);

create table Item (
	idItem int not null auto_increment,
    preco decimal (10,2) not null,
    quantidade int not null,
    idProduto int not null,
    primary key (idItem),
    foreign key (idProduto) references Produto(idProduto)
);

create table Venda(
	idVenda int not null auto_increment,
    precoVenda decimal(10,2) not null,
    dataVenda date not null,
    nomeCliente varchar(45) not null,
    primary key (idVenda)
);

create table ItemVenda(
idItem int not null,
idVenda int not null,
foreign key (idItem) references Item(idItem),
foreign key (idVenda) references Venda(idVenda)
);

insert into usuario (login, senha, tipo) values ("daniel", "1234", "Administrador");
insert into usuario (login, senha, tipo) values ("luciano", "1234", "Atendente");

