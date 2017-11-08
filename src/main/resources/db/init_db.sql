CREATE TABLE IF NOT EXISTS `users`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `id_role` int(11) DEFAULT NULL,
  `id_customer` int(11) DEFAULT NULL,
PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `roles`(
  `role` varchar(255) DEFAULT NULL
);

DELETE FROM roles;

INSERT INTO roles (`role`) VALUE ('ROLE_MANAGER');
INSERT INTO roles (`role`) VALUE ('ROLE_CUSTOMER');


INSERT INTO users (login, pass, id_role)
  SELECT * FROM (SELECT 'admin', 'adm', 0) AS tmp
  WHERE NOT EXISTS (
      SELECT login, pass FROM users WHERE login = 'admin' AND pass = 'adm'
  ) LIMIT 1;

CREATE TABLE IF NOT EXISTS `customer`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `order`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `order_date` DATE DEFAULT NULL,
  `shipment_date` DATE DEFAULT NULL,
  `order_number` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `item`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `category` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `order_item`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `items_count` int(11) NOT NULL,
  `item_price` int(11) NOT NULL,
  PRIMARY KEY (`id`)
);