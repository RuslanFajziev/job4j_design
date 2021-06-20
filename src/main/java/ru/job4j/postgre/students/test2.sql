create table studentsMY(
    id serial primary key,
    name varchar(255)
);

create table subjects(
    id serial primary key,
    name varchar(255)
);

create table studentsMY_subjects(
    id serial primary key,
    student_id int references studentsMY(id),
    subject_id int references subjects(id),
    mark int
);

insert into studentsMY(name) values ('Аня');
insert into studentsMY(name) values ('Ваня');
insert into studentsMY(name) values ('Боря');

insert into subjects(name) values ('Математика');
insert into subjects(name) values ('Русский');
insert into subjects(name) values ('Информатика');

insert into studentsMY_subjects(student_id, subject_id, mark) values (1, 1, 5);
insert into studentsMY_subjects(student_id, subject_id, mark) values (1, 2, 5);
insert into studentsMY_subjects(student_id, subject_id, mark) values (1, 3, 5);

insert into studentsMY_subjects(student_id, subject_id, mark) values (2, 1, 5);
insert into studentsMY_subjects(student_id, subject_id, mark) values (2, 2, 4);
insert into studentsMY_subjects(student_id, subject_id, mark) values (2, 3, 4);

insert into studentsMY_subjects(student_id, subject_id, mark) values (3, 1, 3);
insert into studentsMY_subjects(student_id, subject_id, mark) values (3, 2, 5);
insert into studentsMY_subjects(student_id, subject_id, mark) values (3, 3, 3);

select avg(mark) from studentsMY_subjects;
select min(mark) from studentsMY_subjects;
select max(mark) from studentsMY_subjects;

select s.name, avg(ss.mark) from studentsMY_subjects as ss join subjects s on ss.subject_id = s.id
group by s.name;
having avg(ss.mark) > 4.5;

select s.name, avg(ss.mark) from studentsMY_subjects as ss join studentsMY s on ss.student_id = s.id
group by s.name;