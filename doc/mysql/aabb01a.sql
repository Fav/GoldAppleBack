/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : icss

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-11-29 12:33:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `aabb01a`
-- ----------------------------
DROP TABLE IF EXISTS `aabb01a`;
CREATE TABLE `aabb01a` (
  `aabb01a010` int(11) NOT NULL COMMENT '编号',
  `aabb01a020` varchar(4000) NOT NULL COMMENT '名称',
  PRIMARY KEY (`aabb01a010`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户类型';

-- ----------------------------
-- Records of aabb01a
-- ----------------------------
INSERT INTO `aabb01a` VALUES ('1', '管理员');
INSERT INTO `aabb01a` VALUES ('2', '会员');
INSERT INTO `aabb01a` VALUES ('3', '普通用户');
INSERT INTO `aabb01a` VALUES ('4', '装修人员');
INSERT INTO `aabb01a` VALUES ('5', '游客');
