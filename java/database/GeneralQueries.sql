SELECT * FROM cart_items WHERE cart_id = 3;
SELECT * FROM products;
SELECT * FROM shopping_cart
JOIN customer on customer.customer_id = shopping_cart.customer_id;

INSERT INTO cart_items (cart_id, product_id, quantity, price)
VALUES (3,2,4,2.25);
INSERT INTO cart_items (cart_id, product_id, quantity, price)
VALUES (3,4,1,3.50);


SELECT * FROM cart_items
JOIN products ON products.product_id = cart_items.product_id;

--view shopping cart line item details
SELECT products.product_id, products.product_name, products.price, cart_items.quantity, products.image_url
FROM cart_items
JOIN products ON products.product_id = cart_items.product_id;

-- ALTER TABLE cart_items
-- DROP CONSTRAINT PK_cart_line_item;

-- ALTER TABLE cart_items
-- ADD CONSTRAINT PK_cart_item PRIMARY KEY (cart_id, product_id);

-- ALTER TABLE cart_items
-- DROP COLUMN price;

-- ALTER TABLE cart_items
-- ADD CONSTRAINT quantity_check
-- CHECK (quantity > 0);