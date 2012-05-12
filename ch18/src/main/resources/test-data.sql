insert into contact (first_name, last_name, birth_date) values ('Clarence', 'Ho', '1980-07-30');
insert into contact (first_name, last_name, birth_date) values ('Scott', 'Tiger', '1990-11-02');
insert into contact (first_name, last_name, birth_date) values ('John', 'Smith', '1964-02-28');
insert into contact (first_name, last_name, birth_date) values ('Peter', 'Jackson', '1944-1-10');
insert into contact (first_name, last_name, birth_date) values ('Jacky', 'Chan', '1955-10-31');
insert into contact (first_name, last_name, birth_date) values ('Susan', 'Boyle', '1970-05-06');
insert into contact (first_name, last_name, birth_date) values ('Tinner', 'Turner', '1967-04-30');
insert into contact (first_name, last_name, birth_date) values ('Lotus', 'Notes', '1990-02-28');
insert into contact (first_name, last_name, birth_date) values ('Henry', 'Dickson', '1997-06-30');
insert into contact (first_name, last_name, birth_date) values ('Sam', 'Davis', '2001-01-31');
insert into contact (first_name, last_name, birth_date) values ('Max', 'Beckham', '2002-02-01');
insert into contact (first_name, last_name, birth_date) values ('Paul', 'Simon', '2002-02-28');

insert into hobby (hobby_id) values ('Swimming');
insert into hobby (hobby_id) values ('Jogging');
insert into hobby (hobby_id) values ('Programming');
insert into hobby (hobby_id) values ('Movies');
insert into hobby (hobby_id) values ('Reading');

insert into contact_hobby_detail(contact_id, hobby_id) values (1, 'Swimming'); 
insert into contact_hobby_detail(contact_id, hobby_id) values (1, 'Movies'); 
insert into contact_hobby_detail(contact_id, hobby_id) values (2, 'Swimming');