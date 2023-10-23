create table plant
(
    id                    int primary key auto_increment,
    name                  varchar(250),
    watering_every_x_days int
);
create table account
(
    id   int primary key auto_increment,
    name varchar(250)
);
create table account_plant
(
    id          int primary key auto_increment,
    quantity    int,
    account_id  int,
    plant_id    int,
    last_remind date,
    next_remind date,
    foreign key (account_id) references account (account_id),
    foreign key (plant_id) references plant (plant_id)
);