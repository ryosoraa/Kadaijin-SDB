USE kadaijin;

CREATE TABLE user(
    userID INT NOT NULL AUTO_INCREMENT,
    userName VARCHAR(50),
    totalLogin INT,
    PRIMARY KEY(userID)
);


CREATE TABLE logs (
    logID INT NOT NULL AUTO_INCREMENT,
    timestamp VARCHAR(100),
    userID INT,
    PRIMARY KEY(logID),
    FOREIGN KEY (userID) REFERENCES user(userID)
);
