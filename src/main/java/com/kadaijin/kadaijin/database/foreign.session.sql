USE kadaijin;

CREATE TABLE customer (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(50),
    password VARCHAR(50)
);


CREATE TABLE log (
    user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    username VARCHAR (50) NOT NULL,
    login_result VARCHAR (50) NOT NULL,
    timestamp TIMESTAMP,
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);
