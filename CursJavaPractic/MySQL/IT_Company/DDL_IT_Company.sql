drop database if exists it_company;
create database it_company;
use it_company;

drop table if exists employees;
create table employees(
id int primary key auto_increment not null,
employees_name varchar(20) not null,
employees_surname varchar(30) not null,
address varchar(40) not null,
age int not null,
department varchar(15) not null,
position varchar(20) not null
);

drop table if exists departments;
create table departments(
id int primary key auto_increment not null,
departments_name varchar(20) not null,
floor_number int not null,
number_of_employees int not null,
department_head varchar(20) not null
);

drop table if exists products;
create table products(
id int primary key auto_increment not null,
products_name varchar(30) not null,
version varchar(10) not null,
price int not null,
clients int not null
);