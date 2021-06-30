-- TODO: 30.06.2021 Watch tutorial and create table in database
DROP TABLE IF EXISTS statistics;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS commodity;

CREATE TABLE commodity (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    current_price DEC(7,2) NOT NULL,
    commodity_id INT NOT NULL,
    FOREIGN KEY (commodity_id) REFERENCES commodity (id)
);

CREATE TABLE IF NOT EXISTS orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    power DEC(7,2) NOT NULL,
    price DEC(7,2) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product (id)
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