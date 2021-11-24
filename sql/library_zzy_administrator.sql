use library_zzy;
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `ano` char(7) NOT NULL,
  `aname` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` char(6) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contact` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ano`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
INSERT INTO `administrator` VALUES ('0000001','admin','12345','87896666');
INSERT INTO `administrator` VALUES ('0000002','admin2','12345','8789666');