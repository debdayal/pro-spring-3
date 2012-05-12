insert into contact (first_name, last_name, birth_date) values ('Clarence', 'Ho', '1980-07-30');
insert into contact (first_name, last_name, birth_date) values ('Scott', 'Tiger', '1990-11-02');

insert into hobby (hobby_id) values ('Swimming');
insert into hobby (hobby_id) values ('Jogging');
insert into hobby (hobby_id) values ('Programming');
insert into hobby (hobby_id) values ('Movies');
insert into hobby (hobby_id) values ('Reading');

insert into contact_hobby_detail(contact_id, hobby_id) values (1, 'Swimming'); 
insert into contact_hobby_detail(contact_id, hobby_id) values (1, 'Movies'); 
insert into contact_hobby_detail(contact_id, hobby_id) values (2, 'Swimming');