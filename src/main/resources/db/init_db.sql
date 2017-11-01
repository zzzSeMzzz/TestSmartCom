CREATE TABLE IF NOT EXISTS `users`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `id_role` int(11) DEFAULT NULL,
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