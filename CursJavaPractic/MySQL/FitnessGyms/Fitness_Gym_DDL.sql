DROP DATABASE IF EXISTS fitness_gym;
CREATE DATABASE fitness_gym;
USE fitness_gym;

DROP TABLE IF EXISTS janitors;
CREATE TABLE janitors(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) NOT NULL ,
surname VARCHAR(30) NOT NULL ,
date_of_birth VARCHAR(15) NOT NULL ,
salary INT NOT NULL,
UNIQUE(name,surname,date_of_birth)
);

DROP TABLE IF EXISTS managers;
CREATE TABLE managers(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20) NOT NULL ,
surname VARCHAR(20) NOT NULL ,
date_of_birth VARCHAR(20) NOT NULL,
salary INT NOT NULL,
UNIQUE(name,surname,date_of_birth)
);

DROP TABLE IF EXISTS trainers;
CREATE TABLE trainers(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) NOT NULL ,
surname VARCHAR(30) NOT NULL ,
date_of_birth VARCHAR(15) NOT NULL ,
salary INT NOT NULL,
UNIQUE(name,surname,date_of_birth)
);

DROP TABLE IF EXISTS courses;
CREATE TABLE courses(
id INT PRIMARY KEY AUTO_INCREMENT,
course_type VARCHAR(30) NOT NULL UNIQUE,
date VARCHAR(30) NOT NULL,
time VARCHAR(10) NOT NULL,
duration int not null,
trainers_id INT NOT NULL,
CONSTRAINT fk_trainers_courses
FOREIGN KEY (trainers_id)
REFERENCES trainers(id),
UNIQUE(date,time,trainers_id)
);

DROP TABLE IF EXISTS gyms;
CREATE TABLE gyms(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20) NOT NULL ,
address VARCHAR(20) NOT NULL ,
city VARCHAR(20) NOT NULL ,
managers_id INT NOT NULL ,
CONSTRAINT fk_gyms_managers
FOREIGN KEY (managers_id)
REFERENCES managers(id),
UNIQUE(address,city,managers_id)
);

DROP TABLE IF EXISTS gyms_janitors;
CREATE TABLE gyms_janitors(
id INT PRIMARY KEY AUTO_INCREMENT,
gyms_id INT NOT NULL,
CONSTRAINT fk_gyms_janitors
FOREIGN KEY (gyms_id)
REFERENCES gyms(id),
janitors_id INT NOT NULL,
CONSTRAINT fk_janitors_gyms
FOREIGN KEY (janitors_id)
REFERENCES janitors(id)
);

DROP TABLE IF EXISTS gyms_courses;
CREATE TABLE gyms_courses(
id INT PRIMARY KEY AUTO_INCREMENT,
gyms_id INT NOT NULL,
CONSTRAINT fk_gyms_courses
FOREIGN KEY (gyms_id)
REFERENCES gyms(id),
courses_id INT NOT NULL,
CONSTRAINT fk_courses_gyms
FOREIGN KEY (courses_id)
REFERENCES courses(id)
);

DROP TABLE IF EXISTS customers;
CREATE TABLE customers(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) NOT NULL ,
surname VARCHAR(30) NOT NULL,
date_of_birth VARCHAR(30) NOT NULL,
UNIQUE(name,surname,date_of_birth)
);

DROP TABLE IF EXISTS gyms_customers;
CREATE TABLE gyms_customers(
id INT PRIMARY KEY AUTO_INCREMENT,
gyms_id INT NOT NULL,
CONSTRAINT fk_gyms_customers
FOREIGN KEY (gyms_id)
REFERENCES gyms(id),
customers_id INT NOT NULL,
CONSTRAINT fk_customers_gyms
FOREIGN KEY (customers_id)
REFERENCES customers(id)
);

DROP TABLE IF EXISTS subscriptions;
CREATE TABLE subscriptions(
id INT PRIMARY KEY AUTO_INCREMENT,
subscription_type VARCHAR(20) NOT NULL ,
number_of_courses INT NOT NULL,
price INT NOT NULL,
enroll VARCHAR(20) NOT NULL,
end_of_enrollment VARCHAR(20) NOT NULL
);

DROP TABLE IF EXISTS customers_subscriptions;
CREATE TABLE customers_subscriptions(
id INT PRIMARY KEY AUTO_INCREMENT,
customers_id INT NOT NULL,
CONSTRAINT fk_customers_subscriptions
FOREIGN KEY (customers_id)
REFERENCES customers(id),
subscriptions_id INT NOT NULL,
CONSTRAINT fk_subscriptions_customers
FOREIGN KEY (subscriptions_id)
REFERENCES subscriptions(id),
UNIQUE(customers_id,subscriptions_id)
);

