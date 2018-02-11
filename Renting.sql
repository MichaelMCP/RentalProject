drop table properties;
drop table payment_info;
drop table services;
drop table roles_table;
drop table receipts;
drop table users;

create table users
(
id number(20) primary key,
role number(1) not null,
full_name varchar2(100) not null,
email varchar2(100) not null unique,
password varchar2(100) not null
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
  rating number(3,2)
);


alter table
   properties
add constraint
   fk_properties_owner FOREIGN KEY (owner_id)
references users (id);

create table payment_info(
    id number(20) primary key,
    cost number(20,2) not null,
    user_Id number(20) not null,
    credit_Card_Number number(20) not null
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

commit;
