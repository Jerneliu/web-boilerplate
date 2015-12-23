create table authorities (
  username varchar(50) not null,
  authority varchar(50) not null
);
create unique index ix_auth_username on authorities (username,authority);