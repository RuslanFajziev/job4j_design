insert into rules(name_rules, creation, removal, closing, editing)
            values('FULL', true, true, true, true);
insert into rules(name_rules, creation, removal, closing, editing)
            values('Edit', false, false, false, true);
insert into rules(name_rules, creation, removal, closing, editing)
            values('Cr_Re_Cl', true, true, true, false);

insert into role(name_role) values('ADMIN');
insert into role(name_role) values('MANAGER');
insert into role(name_role) values('SUPPORT');

insert into rules_role(id_rules, id_role) values(1, 1);
insert into rules_role(id_rules, id_role) values(2, 3);
insert into rules_role(id_rules, id_role) values(3, 2);

insert into users(name_user, id_role_user) values('Admin1', 1);
insert into users(name_user, id_role_user) values('Manager3', 2);
insert into users(name_user, id_role_user) values('User7', 3);

insert into category(name_category) values('access');
insert into category(name_category) values('management');
insert into category(name_category) values('requests');

insert into state(name_state) values('new');
insert into state(name_state) values('closed');
insert into state(name_state) values('active');
insert into state(name_state) values('removed');

insert into item(name_item, id_users_item, id_category_item, id_state_item) values('Give rights', 1, 1, 1);
insert into item(name_item, id_users_item, id_category_item, id_state_item) values('Check Access', 1, 1, 3);
insert into item(name_item, id_users_item, id_category_item, id_state_item) values('to hold a meeting', 2, 2, 2);
insert into item(name_item, id_users_item, id_category_item, id_state_item) values('Call subordinates', 2, 2, 4);
insert into item(name_item, id_users_item, id_category_item, id_state_item) values('Reply to mail to client 1', 3, 3, 1);
insert into item(name_item, id_users_item, id_category_item, id_state_item) values('Reply to mail to client 2', 3, 3, 4);
insert into item(name_item, id_users_item, id_category_item, id_state_item) values('Reply to mail to client 3', 3, 3, 2);
insert into item(name_item, id_users_item, id_category_item, id_state_item) values('Reply to mail to client 4', 3, 3, 3);

insert into comments(comment, id_item_comment) values('quickly', 1);
insert into comments(comment, id_item_comment) values('quickly', 2);
insert into comments(comment, id_item_comment) values('quickly', 3);
insert into comments(comment, id_item_comment) values('Skype or WhatsApp', 4);
insert into comments(comment, id_item_comment) values('Skype or WhatsApp', 5);
insert into comments(comment, id_item_comment) values('Skype or WhatsApp', 6);
insert into comments(comment, id_item_comment) values('Find out if the customer is happy with the answer', 7);
insert into comments(comment, id_item_comment) values('Find out if the customer is happy with the answer', 8);

insert into attaches(path_file, id_item_attach) values('d:\1.log', 5);
insert into attaches(path_file, id_item_attach) values('d:\111.log', 5);
insert into attaches(path_file, id_item_attach) values('d:\111111111.log', 5);
insert into attaches(path_file, id_item_attach) values('d:\2.log', 6);
insert into attaches(path_file, id_item_attach) values('d:\2222.log', 6);
insert into attaches(path_file, id_item_attach) values('d:\222222222222.log', 6);
insert into attaches(path_file, id_item_attach) values('d:\3.log', 7);
insert into attaches(path_file, id_item_attach) values('d:\4.log', 8);
insert into attaches(path_file, id_item_attach) values('d:\4444444.log', 8);