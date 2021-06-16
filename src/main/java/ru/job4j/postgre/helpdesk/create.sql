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
    name_role varchar(255),
    id_rules_role int references rules(id)
);

create table users(
    id serial primary key,
    name_user varchar(255),
    id_role_user int references role(id)
);

create table item(
    id serial primary key,
    name_item varchar(255),
    id_users_item int references users(id)
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

create table category(
    id serial primary key,
    name_category varchar(255)
);

create table state(
    id serial primary key,
    name_state varchar(255)
);

create table item_category_state(
    id serial primary key,
    item_id int references item(id),
    category_id int references category(id),
    state_id int references state(id)
);
