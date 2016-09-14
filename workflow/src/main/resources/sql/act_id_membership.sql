/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : workflow

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2016-09-14 17:47:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for act_id_membership
-- ----------------------------
DROP TABLE IF EXISTS `act_id_membership`;
CREATE TABLE `act_id_membership` (
  `USER_ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `GROUP_ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`USER_ID_`,`GROUP_ID_`),
  KEY `ACT_FK_MEMB_GROUP` (`GROUP_ID_`),
  CONSTRAINT `ACT_FK_MEMB_USER` FOREIGN KEY (`USER_ID_`) REFERENCES `act_id_user` (`ID_`),
  CONSTRAINT `ACT_FK_MEMB_GROUP` FOREIGN KEY (`GROUP_ID_`) REFERENCES `act_id_group` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_id_membership
-- ----------------------------
INSERT INTO `act_id_membership` VALUES ('headmarket', 'headmarket');
INSERT INTO `act_id_membership` VALUES ('headquarters', 'headquarters');
INSERT INTO `act_id_membership` VALUES ('open', 'open');
INSERT INTO `act_id_membership` VALUES ('operation', 'operation');
INSERT INTO `act_id_membership` VALUES ('province', 'province');
INSERT INTO `act_id_membership` VALUES ('chentt', 'user');
