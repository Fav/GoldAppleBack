/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : icss

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-11-29 21:31:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `aabb04a`
-- ----------------------------
DROP TABLE IF EXISTS `aabb04a`;
CREATE TABLE `aabb04a` (
  `AABB04A010` varchar(36) NOT NULL COMMENT '编号',
  `AABB04A020` varchar(36) DEFAULT NULL COMMENT '关联编号用户id',
  `AABB04A030` double DEFAULT NULL COMMENT '建筑面积',
  `AABB04A040` double DEFAULT NULL COMMENT '赠送面积',
  `AABB04A050` varchar(500) DEFAULT NULL COMMENT '所在市',
  `AABB04A060` varchar(500) DEFAULT NULL COMMENT '所在区县',
  `AABB04A070` varchar(500) DEFAULT NULL COMMENT '所在小区',
  `AABB04A080` double DEFAULT NULL COMMENT '经度',
  `AABB04A090` double DEFAULT NULL COMMENT '纬度',
  `AABB04A100` varchar(500) DEFAULT NULL COMMENT '房屋图片 路径',
  `AABB04A110` varchar(500) DEFAULT NULL COMMENT '房屋描述 三居室',
  `AABB04A120` varchar(500) DEFAULT NULL COMMENT '户主',
  PRIMARY KEY (`AABB04A010`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aabb04a
-- ----------------------------
