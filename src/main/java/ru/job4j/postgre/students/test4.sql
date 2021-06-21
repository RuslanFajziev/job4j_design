create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
    type_id int references type(id),
    expired_date date,
    price float
);

insert into type(name) values('Сыр');
insert into type(name) values('Мороженное');
insert into type(name) values('Молоко');

insert into product(name, type_id, expired_date, price) values('Сыр брынза', 1, '2021-06-19', 200);
insert into product(name, type_id, expired_date, price) values('Сыр плавленный', 1, '2021-06-27', 55);
insert into product(name, type_id, expired_date, price) values('Сыр моцарелла', 1, '2021-06-01', 357);
insert into product(name, type_id, expired_date, price) values('Мороженное пастеризованное', 3, '2021-06-19', 35);
insert into product(name, type_id, expired_date, price) values('Мороженное сухое', 3, '2021-06-27', 52);
insert into product(name, type_id, expired_date, price) values('Мороженное соевое', 3, '2021-06-01', 23);
insert into product(name, type_id, expired_date, price) values('Мороженное в стаканчике', 2, '2021-06-27', 50);
insert into product(name, type_id, expired_date, price) values('Мороженное эскимо', 2, '2021-06-01', 78);
insert into product(name, type_id, expired_date, price) values('Мороженное фруктовое', 2, '2021-06-19', 102);
insert into product(name, type_id, expired_date, price) values('Мороженное брикет', 2, '2021-06-19', 352);

-- 1 --
select * from product where type_id in (select id from type where name = 'Сыр');
-- 2 --
select * from product where type_id in (select id from type where name like '%Мороженное%');
-- 3 --
select * from product where expired_date < current_date;
-- 4 --
select pr.name as "Самый дорогой продукт", pr.price цена from product as pr where pr.price in (select max(price) from product);
-- 5 --
select tp.name, count(*) from product as pr
join type as tp on tp.id = pr.type_id
GROUP BY tp.name;
-- 6 --
select * from product where type_id in (select id from type where name = 'Сыр' or name = 'Молоко');
-- 7 --
select quantity.name, quantity.count from (select tp.name, count(*) from product as pr
join type as tp on tp.id = pr.type_id
GROUP BY tp.name) as quantity where quantity.count < 10;

select tp.name, count(*) from product as pr
join type as tp on tp.id = pr.type_id
GROUP BY tp.name
having count(*) < 10;
-- 8 --
select tp.name as "Тип продукта", pr.name as "Название продукта" from product as pr
join type as tp on tp.id = pr.type_id;

select current_date