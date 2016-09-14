/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : workflow

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2016-09-14 17:47:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for act_id_user
-- ----------------------------
DROP TABLE IF EXISTS `act_id_user`;
CREATE TABLE `act_id_user` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `FIRST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LAST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EMAIL_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PWD_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PICTURE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_id_user
-- ----------------------------
INSERT INTO `act_id_user` VALUES ('chentt', '1', '普通用户', '', '1055954019@qq.com', 'password', null);
INSERT INTO `act_id_user` VALUES ('headmarket', '1', '总部市场部', '', '1055954019@qq.com', 'password', null);
INSERT INTO `act_id_user` VALUES ('headquarters', '1', '总部工单审核员', '', '1055954019@qq.com', 'password', null);
INSERT INTO `act_id_user` VALUES ('open', '1', '开通员', '', '1055954019@qq.com', 'password', null);
INSERT INTO `act_id_user` VALUES ('operation', '1', '运维人员', '', '1055954019@qq.com', 'password', null);
INSERT INTO `act_id_user` VALUES ('province', '1', '省分工单审核员', '', '1055954019@qq.com', 'password', null);
