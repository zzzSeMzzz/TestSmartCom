CREATE TABLE IF NOT EXISTS `users`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `id_role` int(11) DEFAULT NULL,
PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `roles`(
  `id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

DELETE FROM roles;

INSERT INTO roles (`id`, `role`) VALUE (1, 'manager');
INSERT INTO roles (`id`, `role`) VALUE (2, 'customer');

#создает стандартного пользователя, если в таблице пользователей его нет
INSERT INTO users (login, pass, id_role)
  SELECT * FROM (SELECT 'admin', 'adm',1) AS tmp
  WHERE NOT EXISTS (
      SELECT login, pass FROM users WHERE login = 'admin' AND pass = 'adm'
  ) LIMIT 1;