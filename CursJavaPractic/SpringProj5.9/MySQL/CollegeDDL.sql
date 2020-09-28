drop database if exists college;
create database college;
use college;

drop table if exists students;
create table students(
id int auto_increment primary key not null,
name varchar(20) ,
surname varchar(20),
age int 
);

drop table if exists teachers;
create table teachers(
id int primary key auto_increment not null,
name varchar(20),
surname varchar(20),
major varchar(20)
);

