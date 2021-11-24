use library_zzy;
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bno` char(8) COLLATE utf8_unicode_ci NOT NULL,
  `category` char(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `press` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `author` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` decimal(7,2) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`bno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `book` VALUES ('20200001','history','世界历史','安徽文艺出版社',2009,'马健',46.80,54,39),
('20200030','computer','数据库系统原理教程','清华大学出版社',1998,'王珊',18.50,20,5),
('20200304','music','勋伯格和声学','上海音乐出版社',2007,'阿诺德·勋伯格',28.00,15,0),
('20201005','mathematics','概率论与数理统计','高等教育出版社',2010,'盛骤',41.80,32,20),
('20203001','computer','MYSQL必知必会','人民邮电出版社',2009,'Ben Forta',39.00,26,15);

