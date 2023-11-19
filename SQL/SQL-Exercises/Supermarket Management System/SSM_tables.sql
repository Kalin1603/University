create database sms_db;
use sms_db;
create table towns
(
    id int primary key identity,
    name nvarchar(50) not null,
    mayor_name nvarchar(60) not null
);
create table customers
(
    id int primary key identity,
    first_name nvarchar(30) not null,
    last_name nvarchar(30) not null,
    age int not null,
    balance decimal(11,2) not null,
    registered_into_system_on datetime2 not null,
    home_town_id int not null,
    constraint fk_customers_towns
        foreign key (home_town_id)
        references towns(id)
);
create table supermarkets
(
    id int primary key identity,
    name nvarchar(50) not null,
    number_of_employees int not null,
    is_active bit default 1,
    town_id int not null,
    constraint fk_supermarkets_towns
        foreign key(town_id)
        references towns(id)
);
create table products
(
    id int primary key identity,
    name nvarchar(100) not null,
    category nvarchar(30) not null,
    price_per_unit decimal(11,2) not null
);
create table receipts
(
    id int primary key identity,
    quantity int not null,
    purchased_on datetime2 not null,
    product_id int not null,
    customer_id int not null,
    supermarket_id int not null,
    constraint fk_recipts_products
        foreign key(product_id)
        references products(id),
    constraint fk_recipts_customers
        foreign key(customer_id)
        references customers(id),
    constraint fk_recipts_supermarkets
        foreign key (supermarket_id)
        references supermarkets(id)
);