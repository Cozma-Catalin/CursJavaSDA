DROP DATABASE IF EXISTS travel_agency;
CREATE DATABASE travel_agency;
USE travel_agency;

CREATE TABLE continents(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(15) NOT NULL UNIQUE
);

CREATE TABLE countries(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20) NOT NULL UNIQUE,
continents_id INT NOT NULL,
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


CREATE TABLE hotels(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20) NOT NULL,
number_of_stars DOUBLE NOT NULL,
description VARCHAR(100) NOT NULL,
cities_id INT NOT NULL,
CONSTRAINT fk_hotels_cities
FOREIGN KEY (cities_id)
REFERENCES cities(id)
);

CREATE TABLE rooms(
id INT PRIMARY KEY AUTO_INCREMENT,
type VARCHAR(15) NOT NULL,
number_of_rooms INT NOT NULL,
extra_bed TINYINT 
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

CREATE TABLE meals(
id INT PRIMARY KEY AUTO_INCREMENT,
bed_breakfast TINYINT,
half_board TINYINT,
full_board TINYINT,
all_inclusive TINYINT
);

CREATE TABLE trips(
id INT PRIMARY KEY AUTO_INCREMENT,
departure_airport INT NOT NULL,
CONSTRAINT fk_trips_airports
FOREIGN KEY (departure_airport)
REFERENCES airports(id),
arriving_hotel INT NOT NULL,
CONSTRAINT fk_trips_hotels
FOREIGN KEY (arriving_hotel)
REFERENCES hotels(id),
departure_date DATE NOT NULL,
return_date DATE NOT NULL,
number_of_days INT NOT NULL,
price_for_adults DOUBLE NOT NULL,
price_for_child DOUBLE NOT NULL,
number_of_adults INT NOT NULL,
number_of_child INT,
trip_price DOUBLE NOT NULL
);

CREATE TABLE trips_meals(
id INT PRIMARY KEY AUTO_INCREMENT,
trips_id INT NOT NULL,
CONSTRAINT fk_trips_meals
FOREIGN KEY (trips_id)
REFERENCES trips(id),
meals_id INT NOT NULL,
CONSTRAINT fk_meal_trips
FOREIGN KEY (meals_id)
REFERENCES meals(id)
);

CREATE TABLE accounts(
id INT PRIMARY KEY AUTO_INCREMENT,
user_name VARCHAR(15) NOT NULL UNIQUE,
password VARCHAR(15) NOT NULL,
logged_in TINYINT NOT NULL
);

CREATE TABLE customers(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20) NOT NULL,
surname VARCHAR(30) NOT NULL,
date_of_birth DATE NOT NULL,
address VARCHAR(30) NOT NULL,
phone_number VARCHAR(10) NOT NULL,
email VARCHAR(30) NOT NULL UNIQUE,
accounts_id INT NOT NULL UNIQUE,
CONSTRAINT fk_customers_accounts
FOREIGN KEY (accounts_id)
REFERENCES accounts(id) 
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



