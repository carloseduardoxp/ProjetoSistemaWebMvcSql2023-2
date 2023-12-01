create database dbContatos;

use dbContatos;

create table tb_contato(

email varchar(255) primary key,

nome varchar(255)

);

insert into tb_contato values ('carloseduardodantas@iftm.edu.br','Carlos Eduardo');

insert into tb_contato values ('angoti@iftm.edu.br','Edson Angoti');

select email,nome from tb_contato;

create table tb_login( 
   usuario varchar(255) primary key,
   senha varchar(255)
);

create table tb_role (
   id integer auto_increment,
   nome varchar(255) not null,
   primary key(id)
);

insert into tb_role(nome) values ('ADMIN');
insert into tb_role(nome) values ('USER');

create table tb_role_user (
   usuario varchar(255) not null,
   role_id integer not null,
   primary key(usuario,role_id),
   foreign key(usuario) references tb_login(usuario),
   foreign key(role_id) references tb_role(id)
);

-- insert into tb_role_user(usuario,role_id) values ('teste',1);
-- insert into tb_role_user(usuario,role_id) values ('teste1',2);