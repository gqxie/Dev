/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50637
Source Host           : 127.0.0.1:3306
Source Database       : dev

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2017-11-23 15:01:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_app
-- ----------------------------
DROP TABLE IF EXISTS `t_app`;
CREATE TABLE `t_app` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `appname` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userID` bigint(20) DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `birthDay` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `nickName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
