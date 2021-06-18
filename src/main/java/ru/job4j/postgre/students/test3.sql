create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values('TV', 30000);
insert into devices(name, price) values('PC', 50000);
insert into devices(name, price) values('Сoffee machine', 15000);
insert into devices(name, price) values('Mixer', 10000);
insert into devices(name, price) values('TV', 20000);
insert into devices(name, price) values('PC', 23000);
insert into devices(name, price) values('Сoffee machine', 3700);
insert into devices(name, price) values('Mixer', 1500);

insert into people(name) values ('Аня');
insert into people(name) values ('Ваня');
insert into people(name) values ('Боря');

insert into devices_people(device_id, people_id) values(1, 1);
insert into devices_people(device_id, people_id) values(2, 1);
insert into devices_people(device_id, people_id) values(3, 2);
insert into devices_people(device_id, people_id) values(4, 2);
insert into devices_people(device_id, people_id) values(2, 3);
insert into devices_people(device_id, people_id) values(3, 3);
insert into devices_people(device_id, people_id) values(4, 3);
insert into devices_people(device_id, people_id) values(5, 1);
insert into devices_people(device_id, people_id) values(6, 1);
insert into devices_people(device_id, people_id) values(7, 2);
insert into devices_people(device_id, people_id) values(8, 2);
insert into devices_people(device_id, people_id) values(6, 3);
insert into devices_people(device_id, people_id) values(7, 3);
insert into devices_people(device_id, people_id) values(8, 3);

select dev.name, avg(dev.price) from devices as dev
group by dev.name;

select pl.name, avg(dev.price) from devices_people as devPl
join people pl on pl.id = devPl.people_id
join devices dev on dev.id = devPl.device_id
group by pl.name;

select pl.name, avg(dev.price) from devices_people as devPl
join people pl on pl.id = devPl.people_id
join devices dev on dev.id = devPl.device_id
group by pl.name
having avg(dev.price) > 5000;