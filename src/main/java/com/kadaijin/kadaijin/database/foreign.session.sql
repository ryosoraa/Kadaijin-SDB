USE kadaijin;

DROP TABLE logs;
DROP TABLE user;

-- ALTER TABLE logs MODIFY timestamp TIMESTAMP;


CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255),
    total_login INT
);

CREATE TABLE logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    timestamp TIMESTAMP,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES user(id)
);

-- ALTER TABLE logs
-- ADD CONSTRAINT login_cascade
-- FOREIGN KEY (id)
-- REFERENCES user(userid)
-- ON DELETE CASCADE;

