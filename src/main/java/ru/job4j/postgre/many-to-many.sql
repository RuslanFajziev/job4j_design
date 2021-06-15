create table hobby(
    id serial primary key,
    name varchar(255)
);

create table student(
    id serial primary key,
    name varchar(255)
);

create table hobby_student(
    id serial primary key,
    hobby int references hobby(id),
    student int references student(id)
);

--drop table hobby_student;

insert into hobby(name) values('sport');
insert into hobby(name) values('tennis');
insert into hobby(name) values('programming');

insert into student(name) values('Vasil');
insert into student(name) values('Petro');
insert into student(name) values('Bulba');

insert into hobby_student(student, hobby) values(1, 1);
insert into hobby_student(student, hobby) values(1, 2);
insert into hobby_student(student, hobby) values(2, 3);
insert into hobby_student(student, hobby) values(3, 2);
insert into hobby_student(student, hobby) values(3, 3);

SELECT * FROM student;
SELECT * FROM hobby;
SELECT * FROM hobby_student;

SELECT student.id as "student id", student.name as "student name", hobby.name as "hobby name" FROM student
LEFT JOIN hobby_student ON hobby_student.student = student.id
LEFT JOIN hobby ON  hobby_student.hobby = hobby.id