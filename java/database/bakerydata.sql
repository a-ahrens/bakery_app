--products table data
INSERT INTO products(product_type, product_name, description, price, image_url, keywords)
VALUES('cupcake', 'total chocolate cupcake', 'chocolate cupcake with chocolate icing and chocolate chips', 2.25, 'https://www.twopeasandtheirpod.com/wp-content/uploads/2015/03/Ultimate-Chocolate-Cupcakes-2.jpg', 'chocolate, cupcake, chocolate chip, icing, modern');
INSERT INTO products(product_type, product_name, description, price, image_url, keywords)
VALUES('cupcake', 'vanilla cupcake', 'vanilla cake with cream cheese frosting and sprinkles', 2.25, 'https://www.bostongirlbakes.com/wp-content/uploads/2018/04/MG_5052.jpg', 'cupcake, vanilla, sprinkles, cream cheese frosting, classic');
INSERT INTO products(product_type, product_name, description, price, image_url, keywords)
VALUES('muffin', 'blueberry muffin', 'our home-made muffin cake with fresh blueberries and a crunchy crystal sugar top', 2.25, 'https://ohsweetbasil.com/wp-content/uploads/the-best-blueberry-muffins-recipe-6-scaled.jpg', 'blueberry, muffin, classic');
INSERT INTO products(product_type, product_name, description, price, image_url, keywords)
VALUES('muffin', 'Fooberry &#8482; muffin', 'our home-made muffin cake with Fooberries &#8482;, made in partnership with the foo fighters', 3.50, 'https://www.sidechef.com/recipe/360a1d89-37de-444d-abbd-e8ccc162c690.jpg?d=1408x1120', 'Fooberry, muffin, modern, Foo Fighters, signature');
INSERT INTO products(product_type, product_name, description, price, image_url, keywords)
VALUES('brownie', 'fudge brownie', 'our signature brownie made with homemade fudge', 3.00, 'https://suebeehomemaker.com/wp-content/uploads/2021/11/triple-chocolate-brownies-recipecard.jpg', 'fudge, chocolate, brownie, classic');
INSERT INTO products(product_type, product_name, description, price, image_url, keywords)
VALUES('brownie', 'fluff brownie', 'a chocolate brownie mixed with gooey marshmallow', 3.00, 'https://www.thehomecookskitchen.com/wp-content/uploads/2020/10/triple-chocolate-brownies-incontent1.jpg', 'chocolate, marshamllow, brownie, modern');
INSERT INTO products(product_type, product_name, description, price, image_url, keywords)
VALUES('pie', 'country-style apple pie', 'our home-made apple pie with cinnamon sugar mixed in', 25.00, 'https://www.southernliving.com/thmb/fi3aPea-dRvahcmk42j0M-hoKc4=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/2589601_mailb_mailbox_apple_pie_003_0_0-2000-de5c23bb4c4e433fb6d5547d19cb3bcd-e219a711b4b94df792dcd2c8fd997d6a.jpg', 'apple, pie, cinnamon, classic, signature');
INSERT INTO products(product_type, product_name, description, price, image_url, keywords)
VALUES('pie', 'Fooberry &#8482; pie', 'made in partnership with the Foo Fighters, our homemade pie crust stuffed with Fooberries &#8482;', 30.00, 'https://www.inspiredtaste.net/wp-content/uploads/2022/07/Easy-Homemade-Blueberry-Pie-2-1200.jpg', 'Fooberry, Foo Fighters, pie, modern, signature');
INSERT INTO products(product_type, product_name, description, price, image_url, keywords)
VALUES('scone', 'classic lemon raspberry scone', 'our buttery scone with delicious raspberries topped with a sugary glaze and lemon zest', 2.50, 'https://www.mybakingaddiction.com/wp-content/uploads/2015/04/glazed-raspberry-scones-735x1103.jpg', 'raspberry, lemon, glaze, scone, classic');
INSERT INTO products(product_type, product_name, description, price, image_url, keywords)
VALUES('scone', 'Fooberry &#8482; scone', 'our buttery scone with Fooberries &#8482 and poppy seeds, made in partnership with the Foo Fighters', 4.00, 'https://sugarspunrun.com/wp-content/uploads/2017/08/Triple-Berry-Scones-1-of-1.jpg', 'Fooberry, Foo Fighters, scone, poppy seed, modern, signature');
INSERT INTO products(product_type, product_name, description, price, image_url, keywords)
VALUES('cookie', 'Chocolate Chip Cookie', 'classic, just like grandma used to make chocolate chip cookie', 1.00, 'https://www.shugarysweets.com/wp-content/uploads/2020/05/chocolate-chip-cookies-recipe-735x735.jpg', 'chocolate chip, cookie, classic');
INSERT INTO products(product_type, product_name, description, price, image_url, keywords)
VALUES('cookie', 'Smores Cookie', 'chocolate chunks, marshamallow, and graham cracker bits all baked together golden brown', 1.50, 'https://www.jessicagavin.com/wp-content/uploads/2022/06/smores-cookies-29-1200.jpg', 'chocolate chip, cookie, marshmallow, graham cracker, smores, modern, signature');
INSERT INTO products(product_type, product_name, description, price, image_url, keywords)
VALUES('bar', 'Lemon bar', 'a retro classic made with real lemon and dusted with powdered sugar', 2.50, 'https://preppykitchen.com/wp-content/uploads/2020/02/Lemon-bars-1x1-2.jpg', 'lemon, bar, powdered sugar, classic, signature');
INSERT INTO products(product_type, product_name, description, price, image_url, keywords)
VALUES('bar', 'Smores bar', 'a cookie bar with graham cracker, marshmallow, and chocolate layers', 2.50, 'https://www.averiecooks.com/wp-content/uploads/2019/08/smoresbars-14.jpg', 'Smores, marshmallow, chocolate, bar, modern');
INSERT INTO products(product_type, product_name, description, price, image_url, keywords)
VALUES('danish', 'Apple danish', 'our signature cream cheese danish with spiced apple filling and topped with icing', 3.00, 'https://cakescottage.com/wp-content/uploads/2019/09/apple-danish-ba-640x792.jpg', 'apple, cinnamon, cream cheese, icing, danish, signature, classic');
INSERT INTO products(product_type, product_name, description, price, image_url, keywords)
VALUES('danish', 'Fooberry &#8482; danish', 'our signature cream cheese danish with a Fooberry &#8482; filling, made in partnership with the Foo Fighters', 5.00, 'https://sugarapron.com/wp-content/uploads/2017/05/blueberry-danish-f1.jpg', 'Fooberry, Foo Fighters, Danish, cream cheese, signature, modern');

--Custom Cakes
INSERT INTO custom_cakes (cake_size, cake_shape, cake_layers, cake_tiers, cake_flavors, cake_style, cake_filling, icing_type, icing_flavor, icing_color) 
VALUES (8, 'Round', 2, 1, 'Vanilla', 'Standard', 'Strawberry', 'Cream Cheese', 'Vanilla', 'White' );
INSERT INTO custom_cakes (cake_size, cake_shape, cake_layers, cake_tiers, cake_flavors, cake_style, cake_filling, icing_type, icing_flavor, icing_color) 
VALUES (12, 'Sheet', 2, 1, 'Chocolate', 'Standard', 'Butter Cream', 'Frosting', 'Chocolate', 'NA' );

--Add custom cakes to products table
INSERT INTO products(product_type, product_name, description, price, image_url, keywords, custom_cake_id)
VALUES('cake', 'Vanilla Strawberry Cake', 'A vanilla cake with strawberry filling and cream cheese icing', 22.00, 'https://www.tasteofhome.com/wp-content/uploads/2018/01/Vanilla-Bean-Cake-with-White-Chocolate-Ganache_exps129488_HC2379809B04_03_5b_RMS-8.jpg', 'cake, vanilla, cream cheese, strawberry', 1);
INSERT INTO products(product_type, product_name, description, price, image_url, keywords, custom_cake_id)
VALUES('cake', 'Chocolate Cake', 'A chocolate cake with butter cream filling and chocolate icing', 22.00, 'https://completecomfortfoods.com/wp-content/uploads/2022/06/Hersheys-Chocolate-Cake-with-Cream-Cheese-Filling-and-Chocolate-Cream-Cheese-Buttercream2A.jpg', 'cake, cream cheese, chocolate', 2);







