drop schema mono_post cascade;

create schema if not exists mono_post
;

create table if not exists mono_post.users
(
    users_id int8 GENERATED ALWAYS AS identity( INCREMENT 1 START 10000001 MINVALUE 10000001 MAXVALUE 99999999 CACHE 1 ),
    PRIMARY key (users_id) ,
    first_name varchar(30) not null,
    second_name varchar(30) not null,
    patronymic_name varchar(30),
    phone_number varchar(15) unique not null,
    email varchar(100) unique not null
)
;

create table if not exists mono_post.office
(
    office_id int8 GENERATED ALWAYS AS identity( INCREMENT 1 START 10001 MINVALUE 10001 MAXVALUE 99999 CACHE 1 ),
    PRIMARY KEY(office_id),
    address varchar(250) unique not null,
    description text
)
;

create table if not exists mono_post.sending_parcel
(
    parcel_id int8 GENERATED ALWAYS AS IDENTITY( INCREMENT 1 START 100000001 MINVALUE 100000001 MAXVALUE 999999999 CACHE 1 ),
    PRIMARY KEY(parcel_id),
    users_id int8,
    foreign key (users_id) references mono_post.users(users_id),
    sender_office_id int8,
    foreign key (sender_office_id) references mono_post.office(office_id),
    receiver_office_id int8,
    foreign key (receiver_office_id) references mono_post.office(office_id),
    receiver_phone_number varchar(15) not null,
    receiver_first_name varchar(30) not null,
    receiver_second_name varchar(30) not null,
    receiver_patronymic_name varchar(30),
    parcel_status varchar(20) not null,
    create_date timestamp not null,
    update_status timestamp not null
)
;

create table if not exists mono_post.notification
(
    notification_id int8 GENERATED ALWAYS AS IDENTITY( INCREMENT 1 START 100000001 MINVALUE 100000001 MAXVALUE 999999999 CACHE 1 ),
    PRIMARY KEY(notification_id),
    parcel_id int8,
    foreign key (parcel_id) references mono_post.sending_parcel(parcel_id),
    notification_status varchar(20) not null,
    texts varchar(300)
)
;