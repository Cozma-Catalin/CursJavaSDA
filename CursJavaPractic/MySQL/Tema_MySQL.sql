drop database if exists cinema;
create database cinema;
use cinema;

drop table if exists movie_types;
create table movie_types(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name_type VARCHAR(20) NOT NULL,
viewing_option VARCHAR(10) NOT NULL
);

drop table if exists directors;
create table directors(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
directors_name VARCHAR(30) NOT NULL,
directors_surname VARCHAR(20) NOT NULL
);

drop table if exists movies;
create table movies(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(50) NOT NULL,
movie_types_id INT NOT NULL,
CONSTRAINT fk_movies_movie_types
FOREIGN KEY (movie_types_id)
REFERENCES movie_types(id),
launch_year INT NOT NULL,
launch_country VARCHAR(20) NOT NULL,
movie_lenght INT NOT NULL,
movie_language VARCHAR(10) NOT NULL,
directors_id INT NOT NULL,
CONSTRAINT fk_movies_directors
FOREIGN KEY (directors_id)
REFERENCES directors(id)
);

drop table if exists actors;
create table actors(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
actors_name VARCHAR(20) NOT NULL,
actors_surname VARCHAR(20) NOT NULL,
sex_type VARCHAR(1) NOT NULL
);

drop table if exists reviewers;
create table reviewers(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
reviewers_name VARCHAR(20) NOT NULL,
reviewers_surname VARCHAR(20) NOT NULL,
age INT NOT NULL
);

drop table if exists ratings;
create table ratings(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
reviewers_id INT NOT NULL,
CONSTRAINT fk_ratings_reviewers
FOREIGN KEY (reviewers_id)
REFERENCES reviewers(id),
movies_id INT NOT NULL,
CONSTRAINT fk_ratings_movies
FOREIGN KEY (movies_id)
REFERENCES movies(id),
stars INT NOT NULL
);

drop table if exists movie_cast;
create table movie_cast(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
movies_id INT NOT NULL,
CONSTRAINT fk_movie_cast_movies
FOREIGN KEY (movies_id)
REFERENCES movies(id),
actors_id INT NOT NULL,
CONSTRAINT fk_movie_cast_actors
FOREIGN KEY (actors_id)
REFERENCES actors(id),
role_played VARCHAR(20) NOT NULL
);

insert into movie_types(name_type,viewing_option)
values
('action','2D'),
('action','3D'),
('drama','2D'),
('drama','3D'),
('thriller','2D'),
('thriller','3D'),
('comedy','2D'),
('comedy','3D'),
('documentary','2D'),
('documentary','3D'),
('horror','2D'),
('horror','3D'),
('adventure','2D'),
('adventure','3D');

insert into directors(directors_name,directors_surname)
values
('David','Lynch'),
('Andrei','Tarkovski'),
('Akira','Kurosawa'),
('Peter','Jaclson'),
('Ridley','Scott'),
('Steven','Spielberg'),
('James','Cameron'),
('Ethan','Coen');

insert into movies(title,movie_types_id,launch_year,launch_country,movie_language,movie_lenght,directors_id)
values
('Lucky',4,2017,'USA','English',88,1),
('The Mirror',3,1975,'USA','English',108,2),
('Offret',3,1986,'USA','English',143,2),
('Akahige',3,1965,'Japan','Japanese',185,3),
('The Hobbit: An unexpected Journey',14,2012,'USA','English',166,4),
('The Hobbit: The Desolation of Smaug',14,2013,'USA','English',161,4),
('The Hobbit: The battle of the Five Armies',14,2014,'USA','English',144,4),
('The Lord of the Rings: The Fellowship of the Ring',14,2001,'USA','English',178,4),
('The Lord of the Rings: The Two Towers',14,2002,'USA','English',179,4),
('The Lord of the Rings: The Return of the King',14,2003,'USA','English',201,4),
('Alien: Covenant',11,2017,'USA','English',123,5),
('Exodus: Gods and Kings',14,2014,'USA','English',150,5),
('American Gangster',5,2007,'USA','English',157,5),
('Kingdom of Heaven',1,2005,'USA','English',144,5),
('Hannibal',12,2001,'USA','English',131,5),
('Indiana Jones and the Raiders of the Lost Ark',13,1981,'USA','English',115,6),
('Indiana Jones and the Temple of Doom',13,1984,'USA','English',118,6),
('Indiana Jones and the Last Crusade',13,1989,'USA','English',127,6),
('Indiana Jones and the Kingdom of the Crystal Skull',13,2008,'USA','English',124,6),
('Jurassic Park',5,1993,'USA','English',127,6),
('Jurassic Park: The Lost World',5,1997,'USA','English',129,6),
('Ready Player One',6,2018,'USA','English',139,6),
('The Terminator',1,1984,'USA','English',108,7),
('The Terminator: Judgement Day',1,1991,'USA','English',137,7),
('Titanic',3,1997,'USA','English',194,7),
('Hail, Caesar !',8,2016,'USA','English',106,8);

insert into actors(actors_name,actors_surname,sex_type)
values
('Ralph','Fennes','M'),
('Christian','Bale','M'),
('Joaquin','Pheonix','M'),
('Jude','Law','M'),
('Michael','Caine','M'),
('Geoffrey','Rush','M'),
('Liam','Neeson','M'),
('Ben','Kingsley','M'),
('Brad','Pitt','M'),
('Tom','Cruise','M'),
('Leonardo','Di Caprio','M'),
('Arnold','Schwarzeneger','M'),
('Willem','Dafoe','M'),
('Russell','Crowe','M'),
('Anthony','Hopkins','M'),
('Tom','Hanks','M'),
('Matt','Damon','M'),
('Julia','Roberts','F'),
('Charlize','Theron','F'),
('Angelina','Jolie','F'),
('Scarlett','Johansson','F');


insert into reviewers(reviewers_name,reviewers_surname,age)
values
('Catalin','Cozma',32),
('Andi','Moisescu',45),
('Albert','Einstein',151);

insert into ratings(reviewers_id,movies_id,stars)
values
(1,1,2),(1,2,2),(1,3,2),(1,4,2),(1,5,3),(1,6,2),(1,7,4),(1,8,3),(1,9,4),(1,10,3),(1,11,3),(1,12,4),(1,13,3),
(1,14,4),(1,15,4),(1,16,4),(1,17,3),(1,18,4),(1,19,3),(1,20,2),(1,21,4),(1,22,4),(1,23,4),(1,24,3),(1,25,3),(1,26,2),
(2,1,2),(2,2,2),(2,3,3),(2,4,4),(2,5,3),(2,6,2),(2,7,4),(2,8,3),(2,9,4),(2,10,3),(2,11,3),(2,12,4),(2,13,3),
(2,14,4),(2,15,4),(2,16,4),(2,17,3),(2,18,4),(2,19,3),(2,20,2),(2,21,4),(2,22,4),(2,23,4),(2,24,3),(2,25,3),(2,26,2),
(3,1,2),(3,2,2),(3,3,2),(3,4,2),(3,5,3),(3,6,2),(3,7,4),(3,8,3),(3,9,4),(3,10,3),(3,11,3),(3,12,4),(3,13,3),
(3,14,4),(3,15,4),(3,16,4),(3,17,3),(3,18,4),(3,19,3),(3,20,2),(3,21,4),(3,22,4),(3,23,4),(3,24,3),(3,25,3),(3,26,2);

insert into movie_cast(movies_id,actors_id,role_played)
values
(1,1,'main role'),(2,5,'main role'),(3,8,'main role'),(4,16,'main role'),(5,14,'main role'),(6,11,'main role'),(7,12,'main role'),(8,6,'main role'),
(9,1,'main role'),(10,13,'main role'),(11,8,'main role'),(12,2,'main role'),(13,10,'main role'),(14,7,'main role'),(15,4,'main role'),(16,10,'main role'),
(17,16,'main role'),(18,17,'main role'),(19,9,'main role'),(20,9,'main role'),(21,11,'main role'),(22,3,'main role'),(23,6,'main role'),(24,14,'main role'),
(25,17,'main role'),(26,19,'main role'),
(1,3,'secondary role'),(2,2,'secondary role'),(3,12,'secondary role'),(4,21,'secondary role'),(5,4,'secondary role'),(6,17,'secondary role'),(7,15,'secondary role'),(8,3,'secondary role'),
(9,20,'secondary role'),(10,3,'secondary role'),(11,4,'secondary role'),(12,9,'secondary role'),(13,1,'secondary role'),(14,16,'secondary role'),(15,14,'secondary role'),(16,7,'secondary role'),
(17,6,'secondary role'),(18,7,'secondary role'),(19,18,'secondary role'),(20,3,'secondary role'),(21,8,'secondary role'),(22,13,'secondary role'),(23,6,'secondary role'),(24,4,'secondary role'),
(25,12,'secondary role'),(26,13,'secondary role');

-- sa se afis toti actorii de gen M
select * from actors where sex_type = 'M';
-- sa se afis toti actorii de gen F
select * from actors where sex_type = 'F';
-- sa se afiseze filmele lansate inainte de 1990
select * from movies where launch_year < 1990;
-- sa se afiseze filmele de drama si comedie
select * from movies inner join movie_types on movies.movie_types_id = movie_types.id where name_type = 'drama' or name_type = 'comedy';
-- sa se afiseze filmele care nu au fost lansate in Romania
select * from movies where launch_country <> 'Romania';
-- sa se afiseze filmele regizate de Steven Spielberg
select * from movies inner join directors on movies.directors_id = directors.id where directors_name = 'Steven' and directors_surname = 'Spielberg';
-- sa se afiseze filmele ce dureaza mai mult de 2ore
select * from movies where movie_lenght > 120;
-- sa se afiseze cate filme au durata intre 1-2 ore
select count(movie_lenght) from movies where movie_lenght > 60 and movie_lenght < 120; 
-- sa se afiseze toti reviewer-ii cu varsta mai mare de 18 ani
select * from reviewers where age > 18;
-- sa se afis cati reviewer-i sunt mai tineri de 18 ani
select count(age) from reviewers where age < 18;
-- sa se afiseze filmele care au mai mult de 3 stele
select * from ratings inner join movies on ratings.movies_id = movies.id where stars > 3;
-- sa se afiseze cate filme au mai putin de 3 stele
select count(stars) from ratings where stars < 3;
-- sa se afiseze media de varsta a reviewer-lor
select avg(age) from reviewers;
-- sa se afiseze durata medie a tuturor filmelor
select avg(movie_lenght) from movies;
-- sa se afiseze actorii dintr unu anumit film
select * from movie_cast inner join actors on movie_cast.actors_id = actors.id inner join movies on movie_cast.movies_id = movies.id where movies.title = 'Titanic';
-- sa se afiseze filmele in care un anumit actor a avut rol principal
select * from movie_cast inner join movies on movie_cast.movies_id = movies.id inner join actors on movie_cast.actors_id = actors.id where role_played = 'main role' and actors.actors_name = 'Christian' and actors.actors_surname = 'Bale';
-- sa se afiseze filmele de un anumit tip
select * from movies inner join movie_types on movies.movie_types_id = movie_types.id where name_type = 'drama';
-- sa se afiseze filmele care nu sunt 3D
select * from movies inner join movie_types on movies.movie_types_id = movie_types.id where viewing_option <> '3D';
-- sa se afiseze filmele de comedie si 2D
select * from movies inner join movie_types on movies.movie_types_id = movie_types.id where name_type = 'comedy' and viewing_option = '2D';