USE kadaijin;

-- DROP TABLE logs;
-- DROP TABLE user;

 ALTER TABLE logs MODIFY timestamp TIMESTAMP;


-- CREATE TABLE user (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     user_name VARCHAR(255),
--     total_login INT
-- );

-- CREATE TABLE logs (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     timestamp TIMESTAMP,
--     user_id INT,
--     FOREIGN KEY (user_id) REFERENCES user(id)
-- );

-- ALTER TABLE logs
-- ADD CONSTRAINT login_cascade
-- FOREIGN KEY (id)
-- REFERENCES user(userid)
-- ON DELETE CASCADE;


    alter table account
       modify column dates varchar(255);

    create table logs (
        id integer not null auto_increment,
        timestamp datetime(6),
        user_id integer not null,
        primary key (id)
    ) engine=InnoDB;

    create table user (
        id integer not null auto_increment,
        total_login integer,
        user_name varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table logs
       add constraint FK6313q4colhy85u9nyh7c6hy50
       foreign key (user_id)
       references user (id);
