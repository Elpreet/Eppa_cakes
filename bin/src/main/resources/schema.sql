CREATE TABLE units (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       description VARCHAR(255) NOT NULL
);

CREATE TABLE cheeses (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255) NOT NULL,
                         quantity INT,
                         weight INT NOT NULL,
                         unitsId INT NOT NULL,
                         price DECIMAL(5, 2),
                         specSheet VARCHAR(255)
);

INSERT INTO units (description) VALUES
                                    ('Lb. Wheel'), ('Lb. Half Wheel'), ('Lb. Quarter Wheel'),
                                    ('Lb. Eighth Wheel'), ('Lb. Square'), ('Lb. Tomme');

INSERT INTO cheeses (name, quantity, weight, unitsId, price, specSheet)
VALUES ('Carles Roquefort AOC', 10, 3, 2, 39.95, 'http://makertomonger.com/carles-roquefort'),
       ('Carles Roquefort AOC', 17, 6, 1, 75.99, 'http://makertomonger.com/carles-roquefort'),
       ('Alp Blossom', 18, 6, 2, 152.00, 'http://makertomonger.com/alp-blossom-2'),
       ('Alp Blossom', 4, 6, 2, 152.00, 'http://makertomonger.com/alp-blossom-2'),
       ('Alp Blossom', 1, 3, 3, 72.5, 'http://makertomonger.com/alp-blossom-2'),
       ('Alp Blossom', 4, 1.5, 4, 26.5, 'http://makertomonger.com/alp-blossom-2'),
       ('Stinky Feet Cheese', 20, 4, 5, 4.20, NULL),
       ('Chällerhocker', 15, 4, 1, 249.99, 'http://makertomonger.com/wp-content/uploads/2015/11/Challerhocker-Long-Form.jpg'),
       ('Chällerhocker', 17, 2, 2, 129.99, 'http://makertomonger.com/wp-content/uploads/2015/11/Challerhocker-Long-Form.jpg');