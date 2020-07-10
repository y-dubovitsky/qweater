create table if not exists course (
  id serial primary key not null ,
  title varchar(255) not null ,
  length int not null ,
  description varchar(255)
);