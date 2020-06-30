-- Table: user
create table users (
  id serial not null primary key,
  username varchar(255) not null,
  password varchar(255) not null
);

-- Table: role
create table roles (
  id serial not null primary key,
  name varchar(100) not null
);

-- Table: user_role (table for mapping users on roles)
create table users_roles (
  user_id int not null,
  role_id int not null,

  foreign key (user_id) references users(id),
  foreign key (role_id) references roles(id),

  unique (user_id, role_id)
);

-- Insert data
insert into users values (1, 'admin', 'admin');

insert into roles values (1, 'ROLE_USER');
insert into roles values (2, 'ROLE_ADMIN');

insert into users_roles values (1, 2);
