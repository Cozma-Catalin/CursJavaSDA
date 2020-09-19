drop database if exists library;
create database library;
use library;

drop table if exists sections;
create table sections(
id int auto_increment primary key not null,
name varchar(20)
);


drop table if exists books;
create table books(
id int primary key auto_increment not null,
name varchar(20),
surname varchar(20),
sections_id int,
constraint fk_books_section
foreign key (sections_id)
references sections(id)
);


drop table if exists authors;
create table authors(
id int primary key auto_increment not null,
name varchar(20),
surname varchar(20),
books_id int,
constraint fk_authors_book
foreign key (books_id)
references books(id)
);