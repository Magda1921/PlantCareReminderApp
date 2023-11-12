create table account
(
    id        int auto_increment primary key,
    user_name varchar(255) not null,
    email     varchar(255) not null unique,
    password  varchar(255) not null,
    createdAt timestamp default current_timestamp
);

create table plant
(
    id                 int auto_increment primary key,
    name               varchar(255) not null,
    individual_name    varchar(255) not null unique,
    watering_frequency int          not null,
    last_watering      date,
    foreign key (account_id) references account(id)
)