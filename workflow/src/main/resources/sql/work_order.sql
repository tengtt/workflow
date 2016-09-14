/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : workflow

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2016-09-14 17:47:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for work_order
-- ----------------------------
DROP TABLE IF EXISTS `work_order`;
CREATE TABLE `work_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_type` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `process_instance_id` int(11) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of work_order
-- ----------------------------
