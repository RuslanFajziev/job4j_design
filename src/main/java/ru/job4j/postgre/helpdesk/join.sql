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

-- 2  Выполнить запросы с left, rigth, full, cross соединениями --
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
-- 3 Используя left join найти департаменты, у которых нет работников --
select * from departments as dp
left join emploees as emp on emp.id_departments = dp.id
where emp.id_departments is null;
-- 4 Используя left и right join написать запросы, которые давали бы одинаковый результат --
select * from departments as dp
left join emploees as emp on emp.id_departments = dp.id;
select * from emploees as emp
right join departments as dp on emp.id_departments = dp.id;

select * from emploees as emp
left join departments as dp on emp.id_departments = dp.id;
select * from departments as dp
right join emploees as emp on emp.id_departments = dp.id;
-- 5 Создать таблицу teens с атрибутами name, gender и заполнить ее. Используя cross join составить все возможные разнополые пары --
create table teens(
    id serial primary key,
    name varchar(255),
    gender varchar(255)
);

insert into teens(name, gender) values('Petr', 'mens');
insert into teens(name, gender) values('Vasay', 'mens');
insert into teens(name, gender) values('Nikolay', 'mens');
insert into teens(name, gender) values('Irina', 'womens');
insert into teens(name, gender) values('Lera', 'womens');
insert into teens(name, gender) values('Natasha', 'womens');

select tn.name, tnR.name from teens as tn
cross join teens as tnR
where tn.gender <> tnR.gender;