drop database if exists champions_league;
create database champions_league;
use champions_league;

--  cities: nume, tara

drop table if exists cities;
create table cities(
id int not null auto_increment primary key,
cities_name varchar(30) not null,
country varchar(25) not null
); 

-- stadiums: nume, oras, capacitate maxima

drop table if exists stadiums;
create table stadiums(
id int not null auto_increment primary key,
stadiums_name varchar(30) not null,
cities_id int not null,
constraint fk_stadiums_cities
foreign key (cities_id)
references cities(id),
capacity int not null
);

--  footbalTeams: nume, cate meciuri a jucat, din ce oras este, pozitia in clasament, cate goluri are inscrise si cate primite, pe ce stadion joaca

drop table if exists teams;
create table teams(
id int not null auto_increment primary key,
teams_name varchar(30) not null,
cities_id int not null,
constraint fk_teams_cities
foreign key (cities_id)
references cities(id),
stadiums_id int not null ,
constraint fk_teams_stadiums
foreign key (stadiums_id)
references stadiums(id),
games_played int not null,
teams_rank int not null,
goals_scored int not null,
goals_received int not null
);

-- players: nume, prenume, varsta, pozitia pe care joaca, numarul de pe tricou, echipa la care joaca, cate suspendari a avut jucatorul, cate goluri a marcat

drop table if exists players;
create table players(
id int not null auto_increment primary key,
players_name varchar(40) not null,
players_surname varchar(40) not null,
players_age int not null,
players_position varchar(20) not null,
shirt_number int not null,
teams_id int not null,
constraint fk_players_teams
foreign key (teams_id)
references teams(id),
suspensions int not null,
goals_scored int not null
);

-- coaches: nume, prenume, varsta, ani de experienta, echipa pe care o antreneaza, daca e antrebor principal sau nu

drop table if exists coaches;
create table coaches(
id int not null auto_increment primary key,
coaches_name varchar(30) not null,
coaches_surname varchar(30) not null,
coaches_age int not null,
coaches_experience int not null,
teams_id int not null,
constraint fk_coaches_teams
foreign key (teams_id)
references teams(id),
head_coach tinyint not null
);

-- referees: nume, prenume, varsta, ani de experienta, daca este arbitru central sau nu

drop table if exists referees;
create table referees(
id int not null auto_increment primary key,
referees_name varchar(30) not null,
referees_surname varchar(30) not null,
referees_age int not null,
referees_experience int,
central_referee tinyint not null
);

-- matches: data meciului, ora meciului, echipa gazda, echipa oaspete, scorul, arbitrul principal, arbitrul tusier 1, arbitrul tusier 2, stadionul pe care se joaca, numarul de cartonase rosii, nr de cartonase galbene si nr de penaltiuri

drop table if exists matches;
create table matches(
id int not null auto_increment primary key,
games_date date not null,
games_time time not null,
host_team int not null,
constraint fk_host_teams
foreign key (host_team)
references teams(id),
away_team int not null,
constraint fk_away_teams
foreign key (away_team)
references teams(id),
score varchar(10) not null,
central_referee int not null ,
constraint fk_central_referee
foreign key (central_referee)
references referees(id),
side_referee_1 int not null ,
constraint fk_side_referee_1
foreign key (side_referee_1)
references referees(id),
side_referee_2 int not null ,
constraint fk_side_referee_2
foreign key (side_referee_2)
references referees(id),
stadiums_id int not null,
constraint fk_matches_stadiums
foreign key (stadiums_id)
references stadiums(id),
red_cards int not null,
yellow_cards int not null,
penalties int not null
);
