use champions_league;

select * from matches inner join teams as host_team on matches.host_team = host_team.id
inner join teams as away_team on  matches.away_team = away_team.id
inner join referees as central_referee on matches.central_referee = central_referee.id
inner join referees as left_side_referee on matches.side_referee_1 = left_side_referee.id
inner join referees as right_side_referee on matches.side_referee_2 = right_side_referee.id
inner join stadiums on matches.stadiums_id = stadiums.id ;

select * from teams inner join cities on teams.cities_id = cities.id
inner join stadiums on teams.stadiums_id = stadiums.id;

