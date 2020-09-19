drop database if exists dealer;

create database dealer;

use dealer;

create table cars(
id int primary key not null auto_increment,
brand varchar(15) not null,
model varchar(15) not null,
year int not null,
color varchar(10) not null,
fuel_type varchar(10) not null
);  

insert into cars(brand,model,year,color,fuel_type)
values
('Audi','Q5',2015,'Grey','Diesel');

select * from cars;

insert into cars(brand,model,year,color,fuel_type)
values
('BMW','M3',2002,'Pink','Gas');

select * from cars;

insert into cars(brand,model,year,color,fuel_type)
values
('VW','Passat',2019,'Blue','Gas');

select * from cars;

delete from cars where model = 'Passat';

insert into cars(brand,model,year,color,fuel_type)
values
('Mazda','CX5',2020,'Red','Gas');

select * from cars;

-- clienti nume,prenume,varsta,adresa
drop table if exists clients;
create table clients(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
name VARCHAR(20) NOT NULL,
surname VARCHAR(30) NOT NULL,
age INT NOT NULL,
adress VARCHAR(60) NOT NULL,
car_id INT NOT NULL ,
CONSTRAINT fk_clients_cars
FOREIGN KEY(car_id)
REFERENCES cars(id)
);

drop table if exists rar;
create table rar(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
month VARCHAR(10) NOT NULL,
day INT NOT NULL,
hour INT NOT NULL,
car_id INT NOT NULL,
CONSTRAINT fk_rar_cars
FOREIGN KEY(car_id)
REFERENCES cars(id) 
);

-- facem legatura intre tabela cars si clients
-- vrem sa stim care client a cumparat o anumita masina
-- 1 alegem tabela copil(Child Table)/ care va contine o coloana foreign key
-- 2 alegem coloana care va fi referentiata in tabela copil
-- 3 declaram foreign key ul in tabela copil

insert into clients(name,surname,age,adress,car_id)
values
('Catalin','Cozma',32,'gftagdhasd Galati',1),
('Alex','Matei',34,'ggdasiaj Iasi',4),
('Vasile','Ciobanu',50,'dfsgdfgj,kas Vaslui',2),
('Gheorghe','Superman-Batman',20,'gdfysagfa Bucuresti',1),
('Grigore','Opinca',48,'hajsfbhjla Bacau',2);

select * from cars;


-- creem o tabela programari rar: coloane cu luna,ziua,ora
-- facem legatura intre tabela cars si rar
select * from clients;

insert into rar(month,day,hour,car_id)
values
('February',3,14,1),
('Jully',7,12,4),
('October',14,18,2);
select * from rar;

-- LEASING : CUMPARATORUL,MASINA,ANUL TERMINARII

drop table if exists leasing;
create table leasing(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
client_id INT NOT NULL,
CONSTRAINT fk_leasing_clients 
FOREIGN KEY leasing(client_id)
REFERENCES clients(id),
car_id INT NOT NULL,
CONSTRAINT fk_leasing_cars
FOREIGN KEY leasing(car_id)
REFERENCES cars(id),
finishing_year INT NOT NULL
);

insert into leasing(client_id,car_id,finishing_year)
values
(2,1,2025),
(4,2,2022),
(2,4,2020);

select * from leasing;

