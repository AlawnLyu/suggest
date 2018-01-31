/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : suggestion

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-01-31 13:10:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `report_result`
-- ----------------------------
DROP TABLE IF EXISTS `report_result`;
CREATE TABLE `report_result` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `description` text COMMENT '举报描述',
  `images` varchar(255) DEFAULT '' COMMENT '图片',
  `create_time` varchar(32) DEFAULT '' COMMENT '创建时间',
  `is_view` smallint(1) DEFAULT NULL COMMENT '是否查看；1：已查看，0：未查看',
  `is_deal` smallint(1) DEFAULT NULL COMMENT '是否处理，1：已处理；0：未处理',
  `deal_suggest` text COMMENT '处理意见',
  `deal_time` varchar(32) DEFAULT '' COMMENT '处理时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

