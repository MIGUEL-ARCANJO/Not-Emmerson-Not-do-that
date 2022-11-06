#create schema agenda
use agenda;

create table contatos(
	id int primary key auto_increment,
    nome varchar(200) not null,
	apelido varchar(200),
    data_nascimento date not null
);

create table endereco(
	id int primary key auto_increment,
    cep char(8) not null,
	complemento varchar(250),
    bairro varchar(100) not null,
    nmrCasa tinyint not null
);

create table compromisso(
	id int primary key auto_increment,
    observacao varchar(500),
    dataCompromisso date not null,
    horaCompromisso date not null,
    idContato int not null,
    foreign key (idContato) references contatos(id)
);

drop table compromisso;

select * from contatos;