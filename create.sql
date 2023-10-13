create table account (id integer not null auto_increment, password varchar(255), username varchar(255), primary key (id)) engine=InnoDB;
create table logs (logid integer not null auto_increment, usersid integer, timestamp varchar(255), primary key (logid)) engine=InnoDB;
create table user (total_login integer, userid integer not null auto_increment, user_name varchar(255), primary key (userid)) engine=InnoDB;
alter table logs add constraint FKftpxvgvwpyowy064c1njq62do foreign key (usersid) references user (userid);
create table account (id integer not null auto_increment, password varchar(255), username varchar(255), primary key (id)) engine=InnoDB;
create table logs (logid integer not null auto_increment, userid integer, timestamp varchar(255), primary key (logid)) engine=InnoDB;
create table user (total_login integer, userid integer not null auto_increment, user_name varchar(255), primary key (userid)) engine=InnoDB;
alter table logs add constraint FKeyvmibysowvue2tnma9x383mb foreign key (userid) references user (userid);
