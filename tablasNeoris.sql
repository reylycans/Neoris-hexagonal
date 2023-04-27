create database neoris;
use neoris;
create table persona (
	id int primary key not null auto_increment,
    nombre varchar(50) not null,
    genero varchar(9) not null,
	edad int(3) not null,
    identificacion varchar(10) not null,
    direccion varchar(60) not null,
    telefono varchar(10) not null
);

create table cliente (
	id int primary key not null auto_increment,
    contrasena varchar(4) not null,
    estado boolean not null,
    id_persona int not null unique,
    foreign key (id_persona) references persona(id)
);


create table cuenta (
	id int primary key not null auto_increment,
    numero_cuenta varchar(6) not null,
    tipo_cuenta varchar(9) not null,
	saldo_inicial numeric not null,
    estado boolean not null,
    id_cliente int not null,
    foreign key (id_cliente) references cliente(id)
);


create table movimientos (
	id int primary key not null auto_increment,
    fecha datetime not null,
    tipo_movimiento varchar(20) not null,
	valor numeric not null,
    saldo numeric not null,
    id_cuenta int not null,
	foreign key (id_cuenta) references cuenta(id)
);