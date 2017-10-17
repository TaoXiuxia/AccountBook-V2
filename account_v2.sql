/*
Navicat MySQL Data Transfer

Source Server         : 59DB
Source Server Version : 50719
Source Host           : 59.110.231.132:3306
Source Database       : xxxx

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-10-01 13:47:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for balance
-- ----------------------------
DROP TABLE IF EXISTS `balance`;
CREATE TABLE `balance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `month` date NOT NULL,
  `actual_balance` float(255,2) NOT NULL COMMENT '本月末结余，即下月初结余',
  PRIMARY KEY (`id`),
  KEY `reference_to_user` (`user_id`),
  CONSTRAINT `reference_to_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for expenditure
-- ----------------------------
DROP TABLE IF EXISTS `expenditure`;
CREATE TABLE `expenditure` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `money` float(255,2) NOT NULL,
  `type_of_money` varchar(255) DEFAULT NULL,
  `date` date NOT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `dele` int(1) DEFAULT NULL COMMENT '-1：删除；1未删除',
  PRIMARY KEY (`id`),
  KEY `foreignkey_to_item2` (`item_id`),
  KEY `foreignkey_to_user2` (`user_id`),
  CONSTRAINT `foreignkey_to_item2` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`),
  CONSTRAINT `foreignkey_to_user2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for income
-- ----------------------------
DROP TABLE IF EXISTS `income`;
CREATE TABLE `income` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `money` float(255,2) NOT NULL,
  `type_of_money` varchar(255) DEFAULT NULL,
  `date` date NOT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `dele` int(1) DEFAULT NULL COMMENT '-1：删除；1未删除',
  PRIMARY KEY (`id`),
  KEY `foreignkey_to_user1` (`user_id`),
  KEY `foreignkey_to_item1` (`item_id`),
  CONSTRAINT `foreignkey_to_item1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`),
  CONSTRAINT `foreignkey_to_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '表示此项对应哪个user，如果是1表示是公有项',
  `name` char(50) DEFAULT NULL,
  `in_or_ex` varchar(3) NOT NULL COMMENT 'in表示收入，ex表示支出',
  `remark` char(200) DEFAULT NULL,
  `dele` int(1) NOT NULL COMMENT '-1：删除；1未删除',
  `sort` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `foreignkey_to_user` (`user_id`),
  CONSTRAINT `foreignkey_to_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pay_method
-- ----------------------------
DROP TABLE IF EXISTS `pay_method`;
CREATE TABLE `pay_method` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `is_count_in_this_month_ex` int(1) DEFAULT NULL COMMENT '是否计入本月支出，1：是；0：否；（-1为收入，收入不考虑此字段）',
  `in_or_ex` varchar(255) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `dele` int(1) NOT NULL COMMENT '-1：删除；1未删除',
  `sort` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `age` int(3) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `register_time` datetime NOT NULL,
  `last_login_time` datetime NOT NULL,
  `activation_code` char(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Procedure structure for insertItem
-- ----------------------------
DROP PROCEDURE IF EXISTS `insertItem`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `insertItem`(
	IN userId INT,
	IN itemName VARCHAR(50),
	IN remark VARCHAR(200),
	IN inOrEx VARCHAR(3),
	IN dele INT,
	OUT result INT
)
BEGIN

START TRANSACTION; #开始一个事物

INSERT INTO item ( user_id, name, in_or_ex, remark, dele, sort )
    VALUES (userId, itemName, inOrEx, remark, dele, 0);

SET result=LAST_INSERT_ID();

UPDATE item set item.sort = result WHERE item.id = result;

COMMIT; #主动提交  

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for insertPayMethod
-- ----------------------------
DROP PROCEDURE IF EXISTS `insertPayMethod`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `insertPayMethod`(
	IN userId INT,
	IN name VARCHAR(50),
	IN is_count_in_this_month_ex INT,
	IN remark VARCHAR(200),
	IN inOrEx VARCHAR(3),
	IN dele INT,
	OUT result INT
)
BEGIN

START TRANSACTION; #开始一个事物

INSERT INTO pay_method ( user_id, name, is_count_in_this_month_ex, in_or_ex, remark, dele, sort )
    VALUES (userId, name, is_count_in_this_month_ex, inOrEx, remark, dele, 0);

SET result=LAST_INSERT_ID();

UPDATE pay_method set pay_method.sort = result WHERE pay_method.id = result;

COMMIT; #主动提交  

END
;;
DELIMITER ;

