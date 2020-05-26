
create database software_architecture;
use software_architecture;

CREATE TABLE `dm_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `aaa` varchar(10) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

INSERT INTO dm_user (id, username, email, password, aaa) VALUES (1, 'zhangsan', 'zhangsan@163.com', '1234567', '');
INSERT INTO dm_user (id, username, email, password, aaa) VALUES (2, 'lisi', 'lisi@126.com', '567890', '');

CREATE TABLE `dm_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int not NULL,
  `order_date` varchar(10) not NULL,
  `amount` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

INSERT INTO dm_order (id, user_id, order_date, amount) VALUES (1, 1, '2020-09-09', '100RMB');
INSERT INTO dm_order (id, user_id, order_date, amount) VALUES (2, 1, '2020-09-10', '50RMB');
INSERT INTO dm_order (id, user_id, order_date, amount) VALUES (3, 1, '2020-09-11', '200RMB');


