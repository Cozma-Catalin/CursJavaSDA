drop database if exists construction_store;
create database construction_store;
use construction_store;

drop table if exists shopping_carts;
create table shopping_carts(
id int primary key auto_increment 
);

drop table if exists client_accounts;
create table client_accounts(
id int primary key auto_increment ,
name varchar(20) not null,
surname varchar(20) not null,
email varchar(30) not null,
password varchar(15) not null
);

drop table if exists clients_shopping_carts;
create table clients_shopping_carts(
id int primary key auto_increment not null,
clients_id int ,
constraint fk_clients_cart
foreign key (clients_id)
references client_accounts(id),
shopping_carts_id int ,
constraint fk_shopping_carts_client
foreign key (shopping_carts_id)
references shopping_carts(id)
);

drop table if exists admin_account;
create table admin_account(
id int primary key auto_increment ,
name varchar(20) not null,
surname varchar(20) not null,
email varchar(20) not null,
password varchar(20) not null
);

drop table if exists warehouses;
create table warehouses(
id int primary key auto_increment ,
name varchar(20) not null,
city varchar(20) not null,
address varchar(30) not null
);

drop table if exists departments;
create table departments(
id int primary key auto_increment ,
name varchar(30) not null unique
);

drop table if exists cements;
create table cements(
id int primary key auto_increment,
brand varchar(20) not null,
size varchar(20) not null,
price double not null,
quantity double not null,
departments_id int ,
constraint fk_cements_departments
foreign key (departments_id)
references departments(id)
);

drop table if exists shopping_carts_cements;
create table shopping_carts_cements(
id int primary key auto_increment ,
shopping_carts_id int ,
constraint fk_shopping_carts_cements
foreign key (shopping_carts_id)
references shopping_carts(id),
cements_id int ,
constraint fk_cements_shopping_carts
foreign key (cements_id)
references cements(id)
);

drop table if exists screwdrivers;
create table screwdrivers(
id int primary key auto_increment ,
brand varchar(20) not null,
size varchar(20) not null,
head_type varchar(20) not null,
price double not null,
quantity double not null,
departments_id int ,
constraint fk_screwdrivers_departments
foreign key (departments_id)
references departments(id)
);

drop table if exists paints;
create table paints(
id int primary key auto_increment,
brand varchar(20) not null,
color varchar(20) not null,
size varchar(20) not null,
used_for varchar(20) not null,
price double not null,
quantity double not null,
departments_id int,
constraint fk_paints_departments
foreign key (departments_id)
references departments(id)
);

drop table if exists cements_warehouses;
create table cements_warehouses(
id int primary key auto_increment ,
cements_id int ,
constraint fk_cements_warehouses
foreign key (cements_id)
references cements(id),
warehouses_id int ,
constraint fk_warehouses_cements
foreign key (warehouses_id)
references warehouses(id)
);

drop table if exists screwdrivers_warehouses;
create table screwdrivers_warehouses(
id int primary key auto_increment ,
screwdrivers_id int ,
constraint fk_screwdrivers_warehouses
foreign key (screwdrivers_id)
references screwdrivers(id),
warehouses_id int ,
constraint fk_warehouses_screwdrivers
foreign key (warehouses_id)
references warehouses(id)
);

drop table if exists paints_warehouses;
create table paints_warehouses(
id int primary key auto_increment ,
paints_id int ,
constraint fk_paints_warehouses
foreign key (paints_id)
references paints(id),
warehouses_id int ,
constraint fk_warehouses_paints
foreign key (warehouses_id)
references warehouses(id)
);



