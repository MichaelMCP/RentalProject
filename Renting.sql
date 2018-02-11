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

create or replace trigger user_key_trigger
before insert on users
for each row
begin
    Select users_key.nextval into :new.id from dual;
end;
/

drop sequence properties_key;
create sequence properties_key;

create or replace trigger properties_key_trigger
before insert on properties
for each row
begin
    Select properties_key.nextval into :new.property_id from dual;
end;
/

drop sequence payment_info_key;
create sequence payment_info_key;

create or replace trigger payment_info_key_trigger
before insert on payment_info
for each row
begin
    Select payment_info_key.nextval into :new.id from dual;
end;
/

drop sequence services_key;
create sequence services_key;

create or replace trigger services_key_trigger
before insert on services
for each row
begin
    Select services_key.nextval into :new.id from dual;
end;
/

drop sequence receipts_key;
create sequence receipts_key;

create or replace trigger receipts_key_trigger
before insert on receipts
for each row
begin
    Select receipts_key.nextval into :new.receipt_id from dual;
end;
/

insert into users (role, full_name, email, password) values (1, 'King', 'king@test.com', 123);
insert into payment_info (cost, user_id, credit_Card_Number) values (200, 1, 55555555);
commit;

select * from users;
select * from payment_info;