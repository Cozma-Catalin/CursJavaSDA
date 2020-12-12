DROP DATABASE IF EXISTS travel_agency;
CREATE DATABASE travel_agency;
USE travel_agency;

CREATE TABLE continents(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(15) NOT NULL UNIQUE
);

CREATE TABLE countries(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20) NOT NULL,
continents_id INT ,
CONSTRAINT fk_countries_continents
FOREIGN KEY (continents_id)
REFERENCES continents(id)
);

CREATE TABLE cities(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20) NOT NULL ,
countries_id INT NOT NULL,
CONSTRAINT fk_cities_countries
FOREIGN KEY (countries_id)
REFERENCES countries(id)
);

CREATE TABLE airports(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) NOT NULL,
cities_id INT NOT NULL,
CONSTRAINT fk_airports_cities
FOREIGN KEY (cities_id)
REFERENCES cities(id)
);

CREATE TABLE rooms(
id INT PRIMARY KEY AUTO_INCREMENT ,
type VARCHAR(15) NOT NULL,
number_of_rooms INT NOT NULL,
extra_bed TINYINT ,
rooms_available INT NOT NULL
);


CREATE TABLE hotels(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20) NOT NULL,
address VARCHAR(50) NOT NULL,
number_of_stars DOUBLE NOT NULL,
description VARCHAR(100) NOT NULL,
cities_id INT NOT NULL,
CONSTRAINT fk_hotels_cities
FOREIGN KEY (cities_id)
REFERENCES cities(id)
);

CREATE TABLE hotels_rooms(
id INT PRIMARY KEY AUTO_INCREMENT,
hotels_id INT NOT NULL,
CONSTRAINT fk_hotels_rooms
FOREIGN KEY (hotels_id)
REFERENCES hotels(id),
rooms_id INT NOT NULL,
CONSTRAINT fk_rooms_hotels
FOREIGN KEY (rooms_id)
REFERENCES rooms(id)
);

CREATE TABLE flights(
id INT PRIMARY KEY AUTO_INCREMENT ,
flight_number VARCHAR(20) NOT NULL,
departure_date DATE NOT NULL,
departure_time TIME NOT NULL,
departure_airport INT NOT NULL,
CONSTRAINT fk_departure_airport
FOREIGN KEY (departure_airport)
REFERENCES airports(id),
arriving_date DATE NOT NULL,
arriving_time TIME NOT NULL,
arriving_airport INT NOT NULL,
CONSTRAINT fk_arriving_airport
FOREIGN KEY (arriving_airport)
REFERENCES airports(id),
price DOUBLE NOT NULL,
seats_available INT NOT NULL
);

CREATE TABLE trips(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) NOT NULL,
meal_type VARCHAR(15) NOT NULL,
departure_date DATE NOT NULL,
departure_flight INT NOT NULL ,
CONSTRAINT fk_departure_flight
FOREIGN KEY (departure_flight)
REFERENCES flights(id),
staying_hotel INT  ,
CONSTRAINT fk_hotels_trips
FOREIGN KEY (staying_hotel)
REFERENCES hotels(id),
return_date DATE NOT NULL,
returning_flight INT NOT NULL,
CONSTRAINT fk_returning_flight
FOREIGN KEY (returning_flight)
REFERENCES flights(id),
number_of_days INT NOT NULL,
promoted TINYINT NOT NULL,
price_for_adults DOUBLE NOT NULL,
price_for_child DOUBLE NOT NULL,
number_of_adults INT NOT NULL,
number_of_children INT ,
trip_price DOUBLE NOT NULL,
number_of_trips_available INT NOT NULL
);

CREATE TABLE accounts(
id INT PRIMARY KEY AUTO_INCREMENT,
user_name VARCHAR(15) NOT NULL UNIQUE,
password VARCHAR(15) NOT NULL,
logged_in TINYINT 
);

CREATE TABLE customers(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20) NOT NULL,
surname VARCHAR(30) NOT NULL,
address VARCHAR(30) NOT NULL,
date_of_birth DATE NOT NULL,
phone_number VARCHAR(20) NOT NULL,
email VARCHAR(40) NOT NULL ,
accounts_id INT NOT NULL ,
CONSTRAINT fk_customers_accounts
FOREIGN KEY (accounts_id)
REFERENCES accounts(id),
UNIQUE(email,accounts_id) 
);

CREATE TABLE purchased_trips(
id INT PRIMARY KEY AUTO_INCREMENT,
trips_id INT NOT NULL,
CONSTRAINT fk_trips_purchased
FOREIGN KEY (trips_id)
REFERENCES trips(id),
customers_id INT NOT NULL,
CONSTRAINT fk_customers_trips
FOREIGN KEY (customers_id)
REFERENCES customers(id)
);


