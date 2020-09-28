drop database if exists construction_store;
create database construction_store;
use construction_store;

drop table if exists shopping_carts;
create table shopping_carts(
id int primary key auto_increment not null

);



drop table if exists client_accounts;
create table client_accounts(
id int primary key auto_increment not null,
name varchar(20) not null,
surname varchar(20) not null,
email varchar(30) not null,
password varchar(15) not null,
shopping_carts_id int not null,
constraint fk_client_cart
foreign key (shopping_carts_id)
references shopping_carts(id)
);

drop table if exists admin_account;
create table admin_account(
id int primary key auto_increment not null,
name varchar(20) not null,
surname varchar(20) not null,
email varchar(20) not null,
password varchar(20) not null
);

drop table if exists warehouses;
create table warehouses(
id int primary key auto_increment not null,
name varchar(20) not null,
city varchar(20) not null,
address varchar(30) not null
);

drop table if exists departments;
create table departments(
id int primary key auto_increment not null,
name varchar(30) not null unique
);

drop table if exists cements;
create table cements(
id int primary key not null auto_increment,
brand varchar(20) not null,
size varchar(20) not null,
price double not null,
quantity double not null,
departments_id int not null ,
constraint fk_cements_departments
foreign key (departments_id)
references departments(id)
);

drop table if exists screwdrivers;
create table screwdrivers(
id int primary key auto_increment not null,
brand varchar(20) not null,
size varchar(20) not null,
price double not null,
quantity double not null,
departments_id int not null unique,
constraint fk_screwdrivers_departments
foreign key (departments_id)
references departments(id)
);

drop table if exists paints;
create table paints(
id int primary key not null auto_increment,
brand varchar(20) not null,
size varchar(20) not null,
price double not null,
quantity double not null,
departments_id int not null unique,
constraint fk_paints_departments
foreign key (departments_id)
references departments(id)
);

drop table if exists cements_warehouses;
create table cements_warehouses(
id int primary key auto_increment not null,
cements_id int not null,
constraint fk_cements_warehouses
foreign key (cements_id)
references cements(id),
warehouses_id int not null,
constraint fk_warehouses_cements
foreign key (warehouses_id)
references warehouses(id)
);

drop table if exists screwdrivers_warehouses;
create table screwdrivers_warehouses(
id int primary key auto_increment not null,
screwdrivers_id int not null,
constraint fk_screwdrivers_warehouses
foreign key (screwdrivers_id)
references screwdrivers(id),
warehouses_id int not null,
constraint fk_warehouses_screwdrivers
foreign key (warehouses_id)
references warehouses(id)
);

drop table if exists paints_warehouses;
create table paints_warehouses(
id int primary key auto_increment not null,
paints_id int not null,
constraint fk_paints_warehouses
foreign key (paints_id)
references paints(id),
warehouses_id int not null,
constraint fk_warehouses_paints
foreign key (warehouses_id)
references warehouses(id)
);



