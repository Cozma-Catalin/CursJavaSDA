use champions_league;
insert into cities(cities_name,country)
values
('Bucharest','Romania'),('Galati','Romania'),('Cluj','Romania'),('Craiova','Romania'),('Paris','France'),('Munchen','Germany'),('Madrid','Spain'),
('Barcelona','Spain'),('Liverpool','England'),('Munchester','England'),('Roma','Italy'),('Los Angeles','USA'),('Prague','Czech Republic');

insert into stadiums(stadiums_name,cities_id,capacity)
values
('Ghencea',1,31254),('Otelul',2,13500),('Dr. Constantin Radulescu',3,23500),('Ion Oblemenco',4,30944),('Parc des Princes',5,48712),('Allianz Arena',6,75000),('Santiago Bernabeu',7,81044),
('Camp Nou',8,98772),('Anfield',9,54074),('Old Traford',10,74994),('Olimpico di Roma',11,82656),('StubHub Center',12,49499),('Generaly Arena',13,19416);

insert into teams(teams_name,cities_id,stadiums_id,games_played,teams_rank,goals_scored,goals_received)
values
('Steaua',1,1,10,3,15,2),('Otelul Galati',2,2,10,1,20,1),('CFR Cluj',3,3,10,2,16,4),('Universitatea Craiova',4,4,10,5,10,8),('PSG',5,5,10,4,20,5),('Bayern Munchen',6,6,10,6,10,5),('Real Madrid',7,7,10,9,8,3),
('Barcelona',8,8,10,7,5,10),('Liverpool',9,9,10,8,3,2),('Munchester United',10,10,10,10,10,3),('AS Roma',11,11,10,11,6,4),('LA Galaxy',12,12,10,12,12,6),('Sparta Praga',13,13,10,13,6,17);

insert into players(players_name,players_surname,players_age,players_position,shirt_number,teams_id,suspensions,goals_scored)
values
('Karim','Benzema',34,'Forward',9,7,3,56),('Lionel Andres','Messi',34,'Midfield',10,8,0,60),('Cristian','Tanase',33,'Midfield',10,1,2,30),('Cristi','Munteanu',40,'Keeper',99,2,0,0),
('Ciprian','Deac',34,'Midfield',10,3,2,15),('Neymar Jr','da Silva Santos',28,'Midfield',10,5,2,45),('Robben','Arjen',36,'Left wing',10,6,0,29);

insert into coaches(coaches_name,coaches_surname,coaches_age,coaches_experience,teams_id,head_coach)
values
('Zinedine','Zidane',45,5,7,1);

insert into referees(referees_name,referees_surname,referees_age,referees_experience,central_referee)
values
('Catalin','Cozma',32,5,1),('Cristian','Porcaras',28,5,0),('Cristian','Ilie',22,3,0);

insert into matches(games_date,games_time,host_team,away_team,score,central_referee,side_referee_1,side_referee_2,stadiums_id,red_cards,yellow_cards,penalties)
values
('2020.07.13','20:45:00',1,5,'3-0',1,2,3,1,2,6,1);