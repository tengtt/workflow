/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : workflow

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2016-09-14 17:47:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for act_id_group
-- ----------------------------
DROP TABLE IF EXISTS `act_id_group`;
CREATE TABLE `act_id_group` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_id_group
-- ----------------------------
INSERT INTO `act_id_group` VALUES ('headmarket', '1', 'headmarket', null);
INSERT INTO `act_id_group` VALUES ('headquarters', '1', 'headquarters', null);
INSERT INTO `act_id_group` VALUES ('open', '1', 'open', null);
INSERT INTO `act_id_group` VALUES ('operation', '1', 'operation', null);
INSERT INTO `act_id_group` VALUES ('province', '1', 'province', null);
INSERT INTO `act_id_group` VALUES ('user', '1', 'user', null);
