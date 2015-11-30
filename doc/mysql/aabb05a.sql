/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : icss

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-11-29 21:31:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `aabb05a`
-- ----------------------------
DROP TABLE IF EXISTS `aabb05a`;
CREATE TABLE `aabb05a` (
  `AABB05A010` varchar(36) NOT NULL COMMENT '编号',
  `AABB05A020` varchar(36) DEFAULT NULL COMMENT '房屋信息编号',
  `AABB05A030` varchar(500) DEFAULT NULL COMMENT '房屋信息',
  `AABB05A040` varchar(500) DEFAULT NULL COMMENT '客户称呼',
  `AABB05A050` varchar(500) DEFAULT NULL COMMENT '客户联系电话',
  `AABB05A060` varchar(500) DEFAULT NULL COMMENT '装修风格',
  `AABB05A070` varchar(500) DEFAULT NULL COMMENT '邀请码',
  PRIMARY KEY (`AABB05A010`),
  KEY `FK_AABB05A020` (`AABB05A020`),
  CONSTRAINT `FK_AABB05A020` FOREIGN KEY (`AABB05A020`) REFERENCES `aabb04a` (`AABB04A010`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预约信息';

-- ----------------------------
-- Records of aabb05a
-- ----------------------------
