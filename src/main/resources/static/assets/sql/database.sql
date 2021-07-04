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

