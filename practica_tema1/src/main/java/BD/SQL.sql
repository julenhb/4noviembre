/* Author:  julen
 * Created: 2 nov 2022
 */
drop database if exists practica4;
create database practica4;
use practica4;

drop table if exists usuario;
create table usuario(
nombre varchar(80) NOT NULL,
apellidos varchar(80) NOT NULL,
email varchar(80) NOT NULL,
pass varchar(80) NOT NULL,
PRIMARY KEY (email)
);

drop table if exists cliente;
create table cliente(
email_usuario varchar(80) NOT NULL,
nombre varchar(80),
apellidos varchar(80),
tlf VARCHAR(9) NOT NULL,
tarifa varchar(80) NOT NULL,
PRIMARY KEY (tlf)
);


describe usuario;
describe cliente;

select*from usuario;
select*from cliente;



