USE kadaijin;


CREATE TABLE user (
    userID INT AUTO_INCREMENT PRIMARY KEY,
    userName VARCHAR(255),
    totalLogin INT
);

CREATE TABLE logs (
    logID INT AUTO_INCREMENT PRIMARY KEY,
    timestamp TIMESTAMP,
    usersID INT,
    FOREIGN KEY (usersID) REFERENCES user(userID)
);
