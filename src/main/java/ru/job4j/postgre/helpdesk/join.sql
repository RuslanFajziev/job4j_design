create table departments(
    id serial primary key,
    name varchar(255)
);

create table emploees(
    id serial primary key,
    name varchar(255),
    id_departments int references departments(id)
);

insert into departments(name) values('departments_1');
insert into departments(name) values('departments_2');
insert into departments(name) values('departments_3');

insert into emploees(name, id_departments) values('Petrov', 1);
insert into emploees(name, id_departments) values('Sidorov', 1);

insert into emploees(name, id_departments) values('Bulba', 3);
insert into emploees(name, id_departments) values('Cipko', 3);

-- 2 --
select * from departments as dp
left join emploees as emp on emp.id_departments = dp.id;
select * from emploees as emp
left join departments as dp on emp.id_departments = dp.id;

select * from departments as dp
right join emploees as emp on emp.id_departments = dp.id;
select * from emploees as emp
right join departments as dp on emp.id_departments = dp.id;

select * from departments as dp
cross join emploees as emp;
select * from emploees as emp
cross join departments as dp;
-- 3 --
select * from departments as dp
left join emploees as emp on emp.id_departments = dp.id
where emp.id_departments is null;
-- 4 --
select * from departments as dp
left join emploees as emp on emp.id_departments = dp.id;
select * from emploees as emp
right join departments as dp on emp.id_departments = dp.id;

select * from emploees as emp
left join departments as dp on emp.id_departments = dp.id;
select * from departments as dp
right join emploees as emp on emp.id_departments = dp.id;
-- 5 --
create table teens(
    id serial primary key,
    name varchar(255)
);

create table gender(
    id serial primary key,
    name varchar(255)
);

insert into teens(name) values('teans 1');
insert into teens(name) values('teans 2');
insert into teens(name) values('teans 3');

insert into gender(name) values('mens');
insert into gender(name) values('womens');

select * from teens
cross join gender;