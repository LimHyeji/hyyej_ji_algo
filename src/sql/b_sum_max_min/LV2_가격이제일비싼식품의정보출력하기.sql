SELECT *
FROM food_product
WHERE price = (SELECT max(price) FROM food_product);