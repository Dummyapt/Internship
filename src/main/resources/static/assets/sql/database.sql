DROP TABLE IF EXISTS statistics;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS commodity;

CREATE TABLE commodity (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    current_price DEC(7,2) NOT NULL,
    commodity_id INT NOT NULL,
    FOREIGN KEY (commodity_id) REFERENCES commodity (id)
);

CREATE TABLE users (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    username VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    password VARCHAR(100) NOT NULL,
    locked BOOL NOT NULL,
    active BOOL NOT NULL,
    roles VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    power DEC(7,2) NOT NULL,
    price DEC(7,2) NOT NULL,
    user_id VARCHAR(100) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS statistics (
    id INT AUTO_INCREMENT PRIMARY KEY,
    count INT NOT NULL
);

DELIMITER //
CREATE OR REPLACE TRIGGER newOrder
    AFTER INSERT ON orders FOR EACH ROW
    BEGIN
        UPDATE statistics
        SET count = count + 1
        WHERE id = NEW.product_id;
    END //
DELIMITER ;

INSERT INTO commodity (name)
VALUES ('Gas'),
       ('Strom');

INSERT INTO product (name, current_price, commodity_id)
VALUES ('SHP', RAND(), 1),
       ('Spot', RAND(), 1),
       ('Flex', RAND(), 1),
       ('Base', RAND(), 2),
       ('Flex', RAND(), 2),
       ('Peak', RAND(), 2);

INSERT INTO statistics (id, count)
VALUES (1, 0),
       (2, 0),
       (3, 0),
       (4, 0),
       (5, 0),
       (6, 0);