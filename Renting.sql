drop table rent_transaction;
drop table payment_info;
drop table services;
drop table roles_table;
drop table receipts;
drop table properties;
drop table users;

create table users
(
id number(20) primary key,
role number(1) not null,
full_name varchar2(100) not null,
email varchar2(100) not null unique,
pass varchar2(100) not null,
DTYPE varchar2(100)
);


create table properties(
  property_id number(10) primary key,
  owner_id number(10) not null,
  address1 varchar2(255) not null,
  address2 varchar2(255),
  city varchar2 (30) not null,
  states varchar2 (30) not null,
  zipcode varchar2 (6) not null,
  current_Rent_Price number(36,2) not null,
  rating number(3,2),
  availability number(1) not null
);


alter table
   properties
add constraint
   fk_properties_owner FOREIGN KEY (owner_id)
references users (id);

create table payment_info(
    payment_id number(20) primary key,
    user_id number(20) not null,
    credit_Card_Number varchar2(20) not null,
    experationDate varchar(50),
    cvv number(3)
);

create table services(
    id number(20) primary key,
    service_name varchar2(256) not null,
    service_cost number(10, 2) not null
);

create table roles_table(
    id number(20) primary key,
    user_id number(20),
    user_position varchar2(256) not null,
    user_rank number(2) not null,
    constraint fk_user_role foreign key (user_id) references users(id)
);




create table receipts
(
  receipt_id number(20) primary key,
  payments_time timestamp,
  renter_user_id number(20), --fk
  owner_user_id number(20), --fk
  user_rating number(10),
  amount number(10),
  property_id number(10) --fk
  
);

create table rent_transaction
(
  rent_id number (20) primary key,
  start_date varchar2(50),
  end_date varchar2(50),
  renter_id number(20), --fk
  property_id number(20), --fk
  approval number(1),
  payment_info_id number(20), --fk
  constraint fk_renter_id foreign key (renter_id) references users(id),
  constraint fk_property_id foreign key (property_id) references properties(property_id),
  constraint fk_payment_info_id foreign key (payment_info_id) references payment_info(payment_id)
);

alter table
   payment_info
add constraint
   fk_payment_info_user_id FOREIGN KEY (user_id)
references users (id);


alter table
   receipts
add constraint
   fk_renter_user_id FOREIGN KEY (renter_user_id)
references users (id);

alter table
   receipts
add constraint
   fk_owner_user_id FOREIGN KEY (owner_user_id)
references users (id);

drop sequence users_key;
create sequence users_key;
drop sequence properties_key;
create sequence properties_key;
drop sequence payment_info_key;
create sequence payment_info_key;
drop sequence services_key;
create sequence services_key;
drop sequence receipts_key;
create sequence receipts_key;
drop sequence rent_transaction_key;
create sequence rent_transaction_key;

insert into users (id, role, full_name, email, pass) values (1, 1, 'Randal', 'test@test.com', '123');
insert into users (id, role, full_name, email, pass) values (2, 1, 'Michael', 'test2@test.com', '123');
insert into users (id, role, full_name, email, pass) values (3, 1, 'King', 'test3@test.com', '123');

insert into Properties (property_id, owner_id, address1, city, states, zipcode, current_Rent_Price, rating, availability)
    values (1, 1, '1111 Technology', 'Reston', 'Virginia', '22222', 600, 4, 1);

insert into Properties (property_id, owner_id, address1, city, states, zipcode, current_Rent_Price, rating, availability)
    values (2, 1, '3333 Computer', 'New York', 'New York', '44444', 800, 6, 1);
    
insert into Properties (property_id, owner_id, address1, city, states, zipcode, current_Rent_Price, rating, availability)
    values (3, 2, '8888 Computer', 'New York', 'New York', '99999', 1200, 3, 1);
    
insert into payment_info (payment_id, user_id, credit_Card_Number, experationDate, cvv) values (1, 1, '3333333333333333', 'August 15, 2030', 333);

insert into rent_transaction (rent_id, start_date, end_date, renter_id, property_id, approval, payment_info_id)
    values (1, '02-21-2018', '02-28-2018', 1, 3, 1, 1);

commit;