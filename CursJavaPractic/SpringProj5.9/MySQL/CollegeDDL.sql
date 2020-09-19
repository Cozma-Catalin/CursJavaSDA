drop database if exists college;
create database college;
use college;

drop table if exists students;
create table students(
id int auto_increment primary key not null,
name varchar(20) ,
surname varchar(20),
grade int 
);

