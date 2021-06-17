create table certificate(
    id serial primary key,
    name_certificate varchar(255)
);

create table person(
    id serial primary key,
    name_person varchar(255),
    id_certificate_person int references certificate(id)
);

insert into certificate(name_certificate) values('Java june level');
insert into certificate(name_certificate) values('Java middle level');
insert into certificate(name_certificate) values('Java senor level');

insert into person(name_person, id_certificate_person) values('Petrov', 1);
insert into person(name_person, id_certificate_person) values('Ivanov', 1);
insert into person(name_person, id_certificate_person) values('Faiziev', 3);
insert into person(name_person, id_certificate_person) values('Choy', 2);
insert into person(name_person) values('Bulba');

select
        name_person,
        id_certificate_person,
        name_certificate
from person as pr
join certificate as crt on crt.id = pr.id_certificate_person
order by id_certificate_person desc;

select
        name_person as Name,
        id_certificate_person as ID,
        name_certificate
from person as pr
join certificate as crt on crt.id = pr.id_certificate_person
order by id_certificate_person desc;

select
        pr.name_person as Name,
        pr.id_certificate_person as ID,
        crt.name_certificate
from person as pr
join certificate as crt on crt.id = pr.id_certificate_person
where pr.id_certificate_person > 1
order by id_certificate_person desc;