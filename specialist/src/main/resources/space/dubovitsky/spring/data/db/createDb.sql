create table car
(
  id SERIAL primary key not null,
  model_id int not null,
  name varchar(100) not null,
  cost decimal(10, 2),
  foreign key (model_id) references model(id)
  on update cascade
  on delete cascade
);

create table model
(
  id SERIAL primary key not null,
  name varchar(100) not null,
  mark varchar(100) not null
);

create table option
(
  id   SERIAL primary key not null,
  name varchar(100) not null
);

create table car_options
(
  id        SERIAL primary key not null,
  car_id    int                not null,
  option_id int                not null,
  foreign key (car_id) references car(id)
    on update cascade
    on delete cascade,
  foreign key (option_id) references option(id)
    on update cascade
    on delete cascade
);

