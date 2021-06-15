--drop table person;
--drop table age;

create table age(
    id serial primary key,
    age int2
);

create table person(
    id serial primary key,
    name varchar(255),
    agePosition int2 references age(id)
);

insert into age(age) values(36);
insert into age(age) values(30);
insert into age(age) values(25);

insert into person(name, agePosition) values('Vasil', 1);
insert into person(name, agePosition) values('Petro', 2);
insert into person(name, agePosition) values('Vano', 1);
insert into person(name, agePosition) values('Bulba', 3);

SELECT * FROM age;
SELECT * FROM person;

SELECT person.id, person.name, age.age AS "wozrast" FROM person
LEFT JOIN age
ON person.agePosition = age.id