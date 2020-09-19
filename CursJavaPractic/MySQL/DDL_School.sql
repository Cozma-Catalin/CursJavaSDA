use school;



drop table if exists students_teachers;
create table students_teachers(
id int not null primary key auto_increment,
students_id int not null,
constraint fk_link_students
foreign key (students_id)
references students(id),
teachers_id int not null,
constraint fk_link_teachers
foreign key (teachers_id)
references teachers(id)
);
