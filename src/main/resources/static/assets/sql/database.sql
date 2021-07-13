DELIMITER //
CREATE OR REPLACE TRIGGER newOrder
    AFTER INSERT ON orders FOR EACH ROW
    BEGIN
        UPDATE statistics
        SET count = count + 1
        WHERE id = NEW.product_id;
    END //
DELIMITER ;

INSERT INTO commodity (id, name)
VALUES (1, 'Gas'),
       (2, 'Electricity'),
       (3, 'Wind');

INSERT INTO product (id, name, current_price, commodity_id)
VALUES (1, 'Peak', RAND(), 2),
       (2, 'Spot', RAND(), 1),
       (3, 'Flex', RAND(), 1),
       (4, 'Time', RAND(), 3),
       (5, 'Flex', RAND(), 2),
       (6, 'Solid', RAND(), 3);

INSERT INTO statistics (id, count)
VALUES (1, 0),
       (2, 0),
       (3, 0),
       (4, 0),
       (5, 0),
       (6, 0);