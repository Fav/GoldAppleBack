/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : icss

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-11-29 21:16:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `aabb03a`
-- ----------------------------
DROP TABLE IF EXISTS `aabb03a`;
CREATE TABLE `aabb03a` (
  `AABB03A010` varchar(36) NOT NULL COMMENT '编号 GUID',
  `AABB03A020` varchar(36) DEFAULT NULL COMMENT '房屋信息',
  `AABB03A030` varchar(500) DEFAULT NULL COMMENT '装修套餐',
  `AABB03A040` varchar(500) DEFAULT NULL COMMENT '装修进度',
  `AABB03A050` varchar(500) DEFAULT NULL COMMENT '主材产品 主材产品编号逗号相连',
  `AABB03A060` varchar(500) DEFAULT NULL COMMENT '顾问',
  `AABB03A070` double DEFAULT NULL COMMENT '金额',
  `AABB03A080` int(11) DEFAULT NULL COMMENT '状态 返利中，已完成',
  `AABB03A090` datetime DEFAULT NULL COMMENT '开始时间',
  `AABB03A100` datetime DEFAULT NULL COMMENT '预计结束时间',
  `AABB03A110` varchar(500) DEFAULT NULL COMMENT '返利金额',
  `AABB03A120` varchar(36) DEFAULT NULL COMMENT '用户id 一个用户可能有多个装修事件',
  PRIMARY KEY (`AABB03A010`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aabb03a
-- ----------------------------
