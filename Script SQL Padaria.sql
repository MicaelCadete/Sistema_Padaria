Create database Padaria;
	
use Padaria;

Create table Vendas(
 
idVenda int auto_increment,
CPFFuncionario varchar(15),
CPFCliente varchar(15),
idCliente int,
idFuncionario int,
idProduto int,
nomeProduto varchar(50),
valorProduto double,
quantidadeProduto int,
precoTotalVendas double,
dataVenda datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,

PRIMARY KEY (idVenda)
 
);

Create table Vendas7(
 
idVenda int auto_increment,
idProduto int,
CPFFuncionario varchar(15),
CPFCliente varchar(15),
nomeProduto varchar(50),
valorProduto double,
quantidadeProduto int,
precoTotalVendas double,
dataVenda datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
PRIMARY KEY (idVenda)
 
);

insert into vendas7(CPFFuncionario, CPFCliente, dataVenda, precoTotalVendas)
values('543.123.756-50', '546.234.756-56', '2020/10/19', 13.13);
insert into vendas7(CPFFuncionario, CPFCliente, dataVenda, precoTotalVendas)
values('522.111.756-40', '546.234.756-55', '2021/05/12', 12.12);
insert into vendas7(CPFFuncionario, CPFCliente, dataVenda, precoTotalVendas)
values('521.124.755-51', '546.234.756-54', '2019/03/15', 11.11);

select * from vendas7;

Create table Funcionarios(
 
idFuncionario  int auto_increment NOT NULL,
nomeFuncionario varchar(50) NOT NULL,
cpfFuncionario varchar(14) NOT NULL,
PRIMARY KEY (idFuncionario)
 
);

insert into funcionarios(nomeFuncionario, cpfFuncionario)
values('Hugo', '543.123.756-50');
insert into funcionarios(nomeFuncionario, cpfFuncionario)
values('Vitor', '522.111.756-40');
insert into funcionarios(nomeFuncionario, cpfFuncionario)
values('Natália', '521.124.755-51');
insert into funcionarios(nomeFuncionario, cpfFuncionario)
values('Marco', '563.423.256-20');

select * from funcionarios;

Create table Clientes(
 
idCliente int auto_increment,
nomeCliente varchar(50),
cpfCliente varchar(20),
telefoneCliente varchar(20),
emailCliente varchar(100),
sexoCliente varchar(25),
estadoCivilCliente varchar(25),
dataNascimentoCliente varchar(20),
cepCliente varchar(20),
bairroCliente varchar (50),
logradouroCliente varchar(50),
numeroCliente varchar(10),
complementoCliente varchar(100),
PRIMARY KEY (idCliente)

);

insert into clientes(nomeCliente, cpfCliente, telefoneCliente, emailCliente, sexoCliente, estadoCivilCliente, dataNascimentoCliente, cepCliente, bairroCliente, logradouroCliente, numeroCliente, complementoCliente)
values('Enzo', '546.234.756-56', '1192346-5621', 'enzo@gmail.com', 'Masculino', 'Solteiro(a)', '05/04/2005', '04587-040', 'Santo Amaro', 'Rua Amorim', '130', 'Casa de Esquina');
insert into clientes(nomeCliente, cpfCliente, telefoneCliente, emailCliente, sexoCliente, estadoCivilCliente, dataNascimentoCliente, cepCliente, bairroCliente, logradouroCliente, numeroCliente, complementoCliente)
values('Micael', '546.234.756-55', '1192346-5622', 'micael@gmail.com', 'Masculino', 'Casado(a)', '04/04/2004', '04587-041', 'Interlagos', 'Rua Cadete', '1030', 'Predio Cinza');
insert into clientes(nomeCliente, cpfCliente, telefoneCliente, emailCliente, sexoCliente, estadoCivilCliente, dataNascimentoCliente, cepCliente, bairroCliente, logradouroCliente, numeroCliente, complementoCliente)
values('Fernando', '546.234.756-54', '1192346-5620', 'fernando@gmail.com', 'Masculino', 'Divorciado(a)', '03/03/2003', '04587-039', 'Americanópolis', 'Rua Carmo', '240', 'Casa Azul');
insert into clientes(nomeCliente, cpfCliente, telefoneCliente, emailCliente, sexoCliente, estadoCivilCliente, dataNascimentoCliente, cepCliente, bairroCliente, logradouroCliente, numeroCliente, complementoCliente)
values('Gustavo', '546.234.756-53', '1192346-5619', 'gustavo@gmail.com', 'Masculino', 'Viúvo(a)', '02/02/2002', '04587-038', 'Socorro', 'Rua Freire', '440', 'Apto. 500');
insert into clientes(nomeCliente, cpfCliente, telefoneCliente, emailCliente, sexoCliente, estadoCivilCliente, dataNascimentoCliente, cepCliente, bairroCliente, logradouroCliente, numeroCliente, complementoCliente)
values('Christian', '546.234.756-52', '1192346-5618', 'christian@gmail.com', 'Masculino', 'Separado(a)', '01/01/2001', '04587-037', 'Jurubatuba', 'Rua Mol', '532', 'Casa 05');
insert into clientes(nomeCliente, cpfCliente, telefoneCliente, emailCliente, sexoCliente, estadoCivilCliente, dataNascimentoCliente, cepCliente, bairroCliente, logradouroCliente, numeroCliente, complementoCliente)
values('Marcia', '546.234.756-51', '1192346-5617', 'marcia@gmail.com', 'Feminino', 'Solteiro(a)', '06/06/2006', '04587-036', 'Jabaquara', 'Rua Diniz', '340', 'Casa com portão de alumínio');

select * from clientes;


Create table Produtos(
idProduto int auto_increment,
nomeProduto varchar(50) NOT NULL,
quantidadeProduto int NOT NULL,
valorProduto double NOT NULL,
PRIMARY KEY (idProduto)
 
);

insert into produtos(nomeProduto, quantidadeProduto, valorProduto)
values('Pão', 30, 0.50);
insert into produtos(nomeProduto, quantidadeProduto, valorProduto)
values('Queijo', 10, 2.50);
insert into produtos(nomeProduto, quantidadeProduto, valorProduto)
values('Presunto', 20, 2.00);

select * from produtos;

alter table Vendas add constraint FK_IdFuncionario foreign key(idFuncionario) references Funcionarios(idFuncionario);
 
alter table Vendas add constraint FK_IdCliente foreign key(idCliente) references Clientes(idCliente);
 
alter table Vendas add constraint FK_IdProduto foreign key(idProduto) references Produtos(idProduto);