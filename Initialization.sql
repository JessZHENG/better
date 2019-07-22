SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

-- 表的结构 `hisBuildingBasic`
DROP TABLE IF EXISTS `HISBUILDINGBASIC`;
CREATE TABLE IF NOT EXISTS `HISBUILDINGBASIC`(
    `id` int(6) ZEROFILL AUTO_INCREMENT PRIMARY KEY ,-- private long id;
    `b_type` varchar(6) NOT NULL DEFAULT 'null',-- private String bType;
    `name` varchar(30) NOT NULL  DEFAULT 'null',-- private String name;
    `address` varchar(30) NOT NULL  DEFAULT 'null',-- private String address;
    `uri` varchar(100) NOT NULL  DEFAULT 'null',-- private String uri;
    `lon` varchar(30) NOT NULL  DEFAULT 'null',-- private String lon;
    `lat` varchar(30) NOT NULL  DEFAULT 'null'-- private String lat;
)ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user`
(
    `id`       int(20) primary key,
    `username` varchar(20),
    `email`    varchar(50),
    `password` varchar(100),
    `avatar` varchar(200)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;



