create database dbContatos;

use dbContatos;

create table tb_contato(

email varchar(255) primary key,

nome varchar(255)

);

insert into tb_contato values ('carloseduardodantas@iftm.edu.br','Carlos Eduardo');

insert into tb_contato values ('angoti@iftm.edu.br','Edson Angoti');

select email,nome from tb_contato;