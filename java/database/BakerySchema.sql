BEGIN TRANSACTION;
DROP TABLE IF EXISTS users, customer, shopping_cart, orders,
	custom_cakes, products, discount, order_items, cart_items;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE customer(
	customer_id SERIAL,
	customer_name VARCHAR(100) NOT NULL DEFAULT 'Guest',
	customer_phone INT,
	customer_email VARCHAR(300) NOT NULL,
	user_id INT,
	CONSTRAINT PK_customer PRIMARY KEY (customer_id),
	CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE shopping_cart(
	cart_id SERIAL,
	customer_id INT NOT NULL,
	created_on DATE NOT NULL DEFAULT CURRENT_DATE,
	CONSTRAINT PK_shopping_cart PRIMARY KEY (cart_id),
	CONSTRAINT FK_customer_id FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

CREATE TABLE orders(
	order_number SERIAL,
	customer_id INT NOT NULL,
	order_placed TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	order_status VARCHAR(20) DEFAULT 'Order Pending',
	order_pickup DATE NOT NULL,
	CONSTRAINT PK_order_number PRIMARY KEY (order_number),
	CONSTRAINT FK_customer_id FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

CREATE TABLE custom_cakes(
	custom_cake_id SERIAL,
-- 	order_number INT NOT NULL,
	cake_size INT,
	cake_shape VARCHAR(50) CHECK (cake_shape IN ('Round', 'Sheet')),
	cake_layers INT NOT NULL CHECK (cake_layers > 0 AND cake_layers < 4),
	cake_tiers INT CHECK (cake_tiers > 0 AND cake_tiers < 4),
	cake_flavors VARCHAR(50) CHECK (cake_flavors IN ('Vanilla', 'Chocolate', 'Red Velvet', 'Yellow')),
	cake_style VARCHAR(50) CHECK (cake_style IN ('Standard', 'Pound', 'Angel Food')),
	cake_filling VARCHAR(50),
	icing_type VARCHAR(50),
	icing_flavor VARCHAR(50),
	icing_color VARCHAR(50),
	request_status VARCHAR(50) DEFAULT 'Under Review',
	CONSTRAINT PK_custom_cake_id PRIMARY KEY (custom_cake_id)
-- 	CONSTRAINT FK_order_number FOREIGN KEY (order_number) REFERENCES orders(order_number)
);

CREATE TABLE discount(
	discount_code VARCHAR(10),
	discount_percent DECIMAL(8,2),
	start_date DATE,
	end_date DATE,
	description VARCHAR(200),
	CONSTRAINT PK_discount_code PRIMARY KEY (discount_code)
);

CREATE TABLE products(
	product_id SERIAL,
	product_type VARCHAR(50),
	product_name VARCHAR(50),
	description VARCHAR(255),
	price DECIMAL(8,2),
	custom_cake_id INT,
	image_url VARCHAR(255),
	keywords VARCHAR(255),
	discount_code VARCHAR(10),
	CONSTRAINT PK_product_id PRIMARY KEY (product_id),
	CONSTRAINT FK_custom_cake_id FOREIGN KEY (custom_cake_id) REFERENCES custom_cakes(custom_cake_id),
	CONSTRAINT FK_discount_code FOREIGN KEY (discount_code) REFERENCES discount(discount_code)
);

CREATE TABLE cart_items(
	line_item SERIAL,
	cart_id INT NOT NULL,
	product_id INT NOT NULL,
	quantity INT DEFAULT 1 CHECK (quantity > 0),
	CONSTRAINT PK_cart_item PRIMARY KEY (cart_id, product_id);
	CONSTRAINT FK_cart_id FOREIGN KEY (cart_id) REFERENCES shopping_cart(cart_id),
	CONSTRAINT FK_cart_product_id FOREIGN KEY (product_id) REFERENCES products(product_id)
);

CREATE TABLE order_items(
	line_item SERIAL,
	order_number INT NOT NULL,
	product_id INT NOT NULL,
	quantity INT DEFAULT 1,
	price DECIMAL(8,2) NOT NULL,
	CONSTRAINT PK_order_line_item PRIMARY KEY (line_item),
	CONSTRAINT FK_order_number FOREIGN KEY (order_number) REFERENCES orders(order_number),
	CONSTRAINT FK_order_product_id FOREIGN KEY (product_id) REFERENCES products(product_id)
);

COMMIT TRANSACTION;