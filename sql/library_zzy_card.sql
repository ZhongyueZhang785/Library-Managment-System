DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `cno` char(7) COLLATE utf8_unicode_ci NOT NULL,
  `cname` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `department` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` int(1) DEFAULT NULL COMMENT '1代表本科生，2代表研究生，3代表教师,4代表其他',
  `cpassword` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
INSERT INTO `card` VALUES 
('1000001','xiaoli','computer',1,'111'),
('1000330','zhou','history',1,'222'),
('2000005','zhang','history',2,'333'),
('2003001','lihua','computer',2,'123'),
('2200012','hua','English',2,'123'),
('6000218','Lisa','history',2,'123'),
('6000324','John','art',2,'123'),
('7000302','Mike','English',3,'123');
