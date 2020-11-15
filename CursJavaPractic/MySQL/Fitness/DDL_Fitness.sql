drop database if exists fitness;
create database fitness;
use fitness;

DROP TABLE IF EXISTS trainers;
CREATE TABLE trainers(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) NOT NULL ,
surname VARCHAR(30) NOT NULL ,
date_of_birth VARCHAR(15) NOT NULL ,
salary INT NOT NULL,
UNIQUE(name,surname,date_of_birth)
);


drop table if exists workouts;
create table workouts(
id int primary key auto_increment not null,
name varchar(20) not null,
duration varchar(10) not null,
trainers_id int not null,
constraint fk_workouts_trainers
foreign key (trainers_id)
references trainers(id)
);

drop table if exists subscriptions;
create table subscriptions(
id int primary key auto_increment ,
name varchar(20) not null,
price varchar(10) not null,
begin_subscription varchar(15) not null,
end_of_subscription varchar(15) not null
);


drop table if exists gyms;
create table gyms(
id int primary key auto_increment not null,
name varchar(15) not null,
city varchar(15) not null,
address varchar(30) not null,
unique(city,address)
);

drop table if exists customers;
create table customers(
id int primary key auto_increment not null,
name varchar(20) not null,
surname varchar(20) not null,
year_of_birth int not null,
subscriptions_id int not null,
constraint fk_customers_subscriptions
foreign key (subscriptions_id)
references subscriptions(id)
);

drop table if exists gyms_customers;
create table gyms_customers(
id int primary key auto_increment,
gyms_id int not null,
constraint fk_gyms_customers
foreign key (gyms_id)
references gyms(id),
customers_id int not null,
constraint fk_customers_gyms
foreign key (customers_id)
references customers(id)
);

drop table if exists gyms_workouts;
create table gyms_workouts(
id int primary key auto_increment,
gyms_id int not null,
constraint fk_gyms_workouts
foreign key (gyms_id)
references gyms(id),
workouts_id int unique ,
constraint fk_workouts_gyms
foreign key (workouts_id)
references workouts(id)
);
