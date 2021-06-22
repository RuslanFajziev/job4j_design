create table CarBody(
    id serial primary key,
    name varchar(255)
);

create table CarEngine(
    id serial primary key,
    name varchar(255)
);

create table CarGearbox(
    id serial primary key,
    name varchar(255)
);

create table Car(
    id serial primary key,
    name varchar(255),
    CarBody_id int references CarBody(id),
    CarEngine_id int references CarEngine(id),
    CarGearbox_id int references CarGearbox(id)
);

insert into CarBody(name) values('седан');
insert into CarBody(name) values('хэтчбек');
insert into CarBody(name) values('универсал');

insert into CarEngine(name) values('дизель');
insert into CarEngine(name) values('бензиновый');
insert into CarEngine(name) values('электрический');

insert into CarGearbox(name) values('автомат');
insert into CarGearbox(name) values('механика');
insert into CarGearbox(name) values('робот');

insert into Car(name, CarBody_id, CarEngine_id, CarGearbox_id) values('Лада веста', 1, 2, 2);
insert into Car(name, CarBody_id, CarEngine_id, CarGearbox_id) values('Лада веста', 1, 1, 3);

insert into Car(name, CarBody_id, CarEngine_id, CarGearbox_id) values('Лада калина', 2, 2, 3);
insert into Car(name, CarBody_id, CarEngine_id, CarGearbox_id) values('Лада калина', 2, 1, 2);

-- Вывести список всех машин и все привязанные к ним детали --
select cr.name as "Модель авто", crB.name as Кузов, crE.name as "Тип двигателя", crG.name as "Трансмиссия" from Car as cr
left join CarBody as crB on crB.id = cr.CarBody_id
left join CarEngine as crE on crE.id = cr.CarEngine_id
left join CarGearbox as crG on crG.id = cr.CarGearbox_id;
-- Вывести отдельно детали (1 деталь - 1 запрос), которые не используются НИ в одной машине, кузова, двигатели, коробки передач --
select name as "данный тип кузова не используется" from CarBody where id not in (select CarBody_id from Car);
select name as "данный тип двигателя не используется" from CarEngine where id not in (select CarEngine_id from Car);
select name as "данный тип трансмиссии не используется" from CarGearbox where id not in (select CarGearbox_id from Car);

