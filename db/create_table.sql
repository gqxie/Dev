DROP TABLE IF EXISTS t_user;
CREATE TABLE `t_user` (
  `userID` bigint(20) NOT NULL,
  `account` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `birthDay` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `nickName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;






