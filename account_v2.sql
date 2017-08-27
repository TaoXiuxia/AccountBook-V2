/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : account_v2

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2017-08-27 18:29:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for balance
-- ----------------------------
DROP TABLE IF EXISTS `balance`;
CREATE TABLE `balance` (
  `id` int(11) NOT NULL auto_increment,
  `user_id` int(11) NOT NULL,
  `month` date NOT NULL,
  `actual_balance` float(255,2) NOT NULL default '0.00' COMMENT '本月末结余，即下月初结余',
  PRIMARY KEY  (`id`),
  KEY `reference_to_user` (`user_id`),
  CONSTRAINT `reference_to_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for expenditure
-- ----------------------------
DROP TABLE IF EXISTS `expenditure`;
CREATE TABLE `expenditure` (
  `id` int(11) NOT NULL auto_increment,
  `item_id` int(11) default NULL,
  `user_id` int(11) NOT NULL,
  `money` float(255,2) NOT NULL,
  `type_of_money` varchar(255) default NULL,
  `date` date NOT NULL,
  `remark` varchar(200) default NULL,
  `dele` int(2) default '1' COMMENT '1表示未删除，-1表示已删除',
  PRIMARY KEY  (`id`),
  KEY `foreignkey_to_item2` (`item_id`),
  KEY `foreignkey_to_user2` (`user_id`),
  CONSTRAINT `foreignkey_to_item2` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `foreignkey_to_user2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for income
-- ----------------------------
DROP TABLE IF EXISTS `income`;
CREATE TABLE `income` (
  `id` int(11) NOT NULL auto_increment,
  `item_id` int(11) default NULL,
  `user_id` int(11) NOT NULL,
  `money` float(255,2) NOT NULL,
  `type_of_money` varchar(255) default NULL,
  `date` date NOT NULL,
  `remark` varchar(200) default NULL,
  `dele` int(2) default '1' COMMENT '1表示未删除，-1表示已删除',
  PRIMARY KEY  (`id`),
  KEY `foreignkey_to_item1` (`item_id`),
  KEY `foreignkey_to_user1` (`user_id`),
  CONSTRAINT `foreignkey_to_item1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `foreignkey_to_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL auto_increment,
  `user_id` int(11) NOT NULL COMMENT '表示此项对应哪个user，如果是1表示是公有项',
  `name` char(50) default NULL,
  `in_or_ex` varchar(3) NOT NULL COMMENT 'in表示收入，ex表示支出',
  `remark` char(200) default NULL,
  `dele` int(2) NOT NULL default '1' COMMENT '1表示未删除，-1表示已删除',
  `sort` int(5) default NULL,
  PRIMARY KEY  (`id`),
  KEY `foreignkey_to_user` (`user_id`),
  CONSTRAINT `foreignkey_to_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 10240 kB; (`user_id`) REFER `account_v2/user`(`';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `age` int(3) default NULL,
  `sex` char(1) default NULL,
  `remark` varchar(255) default NULL,
  `register_time` datetime NOT NULL,
  `last_login_time` datetime NOT NULL,
  `activation_code` char(6) default NULL,
  `dele` int(2) default '1' COMMENT '1表示未删除，-1表示已删除',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
