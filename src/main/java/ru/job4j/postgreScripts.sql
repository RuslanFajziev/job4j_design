create table hardware(
    id serial primary key,
    name varchar(255),
    forServer bool,
    producer text
);

insert into hardware(name, forserver, producer) values('CPU', true, 'China');
insert into hardware(name, forserver, producer) values('RAM', false, 'Japanese');
insert into hardware(name, forserver, producer) values('PowerUnit', true, 'Russian');

update hardware set producer = 'China' where name = 'PowerUnit';

delete from hardware;

select * from hardware;