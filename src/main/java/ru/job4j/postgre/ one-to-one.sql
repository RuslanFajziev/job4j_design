--drop table worker;
--drop table pass_number;

create table pass_number(
    id serial primary key,
    pass int2
);

create table worker(
    id serial primary key,
    name varchar(255),
    passPosition int2 references pass_number(id) unique
);

insert into pass_number(pass) values(1);
insert into pass_number(pass) values(2);
insert into pass_number(pass) values(3);

insert into worker(name, passPosition) values('Vasil', 1);
insert into worker(name, passPosition) values('Petro', 3);
insert into worker(name, passPosition) values('Bulba', 2);

SELECT worker.id, worker.name, pass_number.pass FROM worker
LEFT JOIN pass_number
ON worker.passPosition = pass_number.id