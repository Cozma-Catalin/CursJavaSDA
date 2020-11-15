drop database if exists fitness;
create database fitness;
use fitness;

drop table if exists workouts;
create table workouts(
id int primary key auto_increment not null,
name varchar(20) not null,
duration varchar(10) not null,
aerobic tinyint not null
);

drop table if exists subscriptions;
create table subscriptions(
id int primary key auto_increment ,
name varchar(20) not null,
price varchar(10) not null,
begin_subscription varchar(15) not null,
end_of_subscription varchar(15) not null,
workout_id int unique ,
constraint fk_subscription_workout
foreign key (workout_id)
references workouts(id)
);

drop table if exists gyms;
create table gyms(
id int primary key auto_increment not null,
name varchar(15) not null,
city varchar(15) not null,
address varchar(30) not null,
subscription_id int unique,
constraint fk_gyms_subscription
foreign key (subscription_id)
references subscriptions(id)
);

drop table if exists persons;
create table persons(
id int primary key auto_increment not null,
name varchar(20) not null,
surname varchar(20) not null,
year_of_birth int not null,
gym_id int ,
constraint fk_persons_gyms
foreign key (gym_id)
references gyms(id),
subscription_id int ,
constraint fk_persons_subscriptions
foreign key (subscription_id)
references subscriptions(id),
workout_id int ,
constraint fk_persons_workouts
foreign key (workout_id)
references workouts(id)
);

