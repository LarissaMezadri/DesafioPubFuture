create table conta (
	id int AUTO_INCREMENT primary key,
	saldo decimal (8,2) not null,
	tipoConta varchar (30) not null,
	instituicaoFinanceira varchar(30) not null
);

create table receitas (
	id int AUTO_INCREMENT primary key,
	valor decimal (7,2) not null ,
	dataRecebimento date not null,
	dataRecebimentoEsperado date not null, 
	descricao varchar (30) not null,
	tipoReceita varchar (30) not null,
	contaId int not null,
	CONSTRAINT receita_conta_fk FOREIGN KEY (contaId) REFERENCES conta(id)
);

create table despesas (
	id int AUTO_INCREMENT primary key,
	valor decimal (7,2) not null ,
	dataPagamento date not null,
	dataPagamentoEsperado date not null, 
	tipoDespesa varchar (30) not null,
	contaId int not null,
	CONSTRAINT despesa_conta_fk FOREIGN KEY (contaId) REFERENCES conta(id)
);

