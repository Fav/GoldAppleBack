/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : icss

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-11-29 12:32:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `aabb02a`
-- ----------------------------
DROP TABLE IF EXISTS `aabb02a`;
CREATE TABLE `aabb02a` (
  `AABB02A010` varchar(36) NOT NULL COMMENT '编号',
  `AABB02A020` int(11) NOT NULL DEFAULT '5' COMMENT '用户类型',
  `AABB02A030` varchar(20) DEFAULT NULL COMMENT '姓名',
  `AABB02A040` varchar(20) DEFAULT NULL COMMENT '用户名',
  `AABB02A050` varchar(128) NOT NULL DEFAULT '12345' COMMENT '密码',
  `AABB02A060` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `AABB02A070` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `AABB02A080` varchar(10) DEFAULT NULL COMMENT '我的推荐码',
  `AABB02A090` varchar(500) DEFAULT NULL COMMENT '谁推荐我的 用户ID或者为空',
  `AABB02A100` double DEFAULT NULL COMMENT '返利余额',
  `AABB02A110` varchar(500) DEFAULT NULL COMMENT '推荐链接',
  `AABB02A120` varchar(500) DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`AABB02A010`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aabb02a
-- ----------------------------
INSERT INTO `aabb02a` VALUES ('4d93469e-a96c-4155-abdc-cb352767b3b0', '1', 'gy', 'admin', '12345', 'gy@qq.com', '13912345678', null, null, '0', null, null);
