drop database if exists library;
create database library;
use library;

drop table if exists sections;
create table sections(
id int auto_increment primary key not null,
name varchar(20) not null
);

drop table if exists authors;
create table authors(
id int primary key auto_increment not null,
name varchar(20) not null,
surname varchar(20) not null
);

drop table if exists books;
create table books(
id int primary key auto_increment not null,
title varchar(30) not null,
authors_id int not null,
constraint fk_books_authors
foreign key (authors_id)
references authors(id),
sections_id int not null unique,
constraint fk_books_section
foreign key (sections_id)
references sections(id)
);

