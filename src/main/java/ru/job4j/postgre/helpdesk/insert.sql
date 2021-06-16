insert into rules(name_rules, creation, removal, closing, editing)
            values('FULL', true, true, true, true);
insert into rules(name_rules, creation, removal, closing, editing)
            values('Edit', false, false, false, true);
insert into rules(name_rules, creation, removal, closing, editing)
            values('Cr_Re_Cl', true, true, true, false);

insert into role(name_role, id_rules_role) values('ADMIN', 1);
insert into role(name_role, id_rules_role) values('MANAGER', 3);
insert into role(name_role, id_rules_role) values('SUPPORT', 2);

insert into users(name_user, id_role_user) values('Admin1', 1);
insert into users(name_user, id_role_user) values('Manager3', 2);
insert into users(name_user, id_role_user) values('User7', 3);

insert into item(name_item, id_users_item) values('Give rights', 1);
insert into item(name_item, id_users_item) values('Check Access', 1);
insert into item(name_item, id_users_item) values('to hold a meeting', 2);
insert into item(name_item, id_users_item) values('Call subordinates', 2);
insert into item(name_item, id_users_item) values('Reply to mail to client 1', 3);
insert into item(name_item, id_users_item) values('Reply to mail to client 2', 3);
insert into item(name_item, id_users_item) values('Reply to mail to client 3', 3);
insert into item(name_item, id_users_item) values('Reply to mail to client 4', 3);

insert into comments(comment, id_item_comment) values('quickly', 1);
insert into comments(comment, id_item_comment) values('quickly', 2);
insert into comments(comment, id_item_comment) values('quickly', 3);
insert into comments(comment, id_item_comment) values('Skype or WhatsApp', 4);
insert into comments(comment, id_item_comment) values('Skype or WhatsApp', 5);
insert into comments(comment, id_item_comment) values('Skype or WhatsApp', 6);
insert into comments(comment, id_item_comment) values('Find out if the customer is happy with the answer', 7);
insert into comments(comment, id_item_comment) values('Find out if the customer is happy with the answer', 8);

insert into attaches(path_file, id_item_attach) values('d:\1.log', 5);
insert into attaches(path_file, id_item_attach) values('d:\2.log', 6);
insert into attaches(path_file, id_item_attach) values('d:\3.log', 7);
insert into attaches(path_file, id_item_attach) values('d:\4.log', 8);

insert into category(name_category) values('access');
insert into category(name_category) values('management');
insert into category(name_category) values('requests');

insert into state(name_state) values('new');
insert into state(name_state) values('closed');
insert into state(name_state) values('active');
insert into state(name_state) values('removed');

insert into item_category_state(item_id, category_id, state_id) values(1, 1, 1);
insert into item_category_state(item_id, category_id, state_id) values(2, 1, 3);
insert into item_category_state(item_id, category_id, state_id) values(3, 2, 2);
insert into item_category_state(item_id, category_id, state_id) values(4, 2, 4);
insert into item_category_state(item_id, category_id, state_id) values(5, 3, 1);
insert into item_category_state(item_id, category_id, state_id) values(6, 3, 2);
insert into item_category_state(item_id, category_id, state_id) values(7, 3, 3);
insert into item_category_state(item_id, category_id, state_id) values(8, 3, 4);