create table rules(
    id serial primary key,
    name_rules varchar(255),
    creation bool,
    removal bool,
    closing bool,
    editing bool
);

create table role(
    id serial primary key,
    name_role varchar(255)
);

cerate table rules_role(
    id serial primary key,
    id_rules int references rules(id)
    id_role int references role(id)
);

create table users(
    id serial primary key,
    name_user varchar(255),
    id_role_user int references role(id)
);

create table category(
    id serial primary key,
    name_category varchar(255)
);

create table state(
    id serial primary key,
    name_state varchar(255)
);

create table item(
    id serial primary key,
    name_item varchar(255),
    id_users_item int references users(id),
    id_category_item int references category(id),
    id_state_item int references state(id)
);

create table comments(
    id serial primary key,
    comment text,
    id_item_comment int references item(id)
);

create table attaches(
    id serial primary key,
    path_file text,
    id_item_attach int references item(id)
);