USE kadaijin;

-- DROP TABLE logs;
-- DROP TABLE user;

ALTER TABLE logs MODIFY timestamp TIMESTAMP;


-- CREATE TABLE user (
--     userID INT AUTO_INCREMENT PRIMARY KEY,
--     userName VARCHAR(255),
--     totalLogin INT
-- );

-- CREATE TABLE logs (
--     logID INT AUTO_INCREMENT PRIMARY KEY,
--     timestamp TIMESTAMP,
--     ID INT,
--     FOREIGN KEY (ID) REFERENCES user(userID)
-- );
