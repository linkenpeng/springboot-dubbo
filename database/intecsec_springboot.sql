/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : intecsec_springboot

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2020-06-08 14:22:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(150) DEFAULT NULL,
  `content` varchar(1024) DEFAULT NULL,
  `delete_mark` tinyint(4) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', 'one', 'content', '0', '2020-01-31 11:05:18', '2020-01-31 11:05:27');
INSERT INTO `blog` VALUES ('2', 'tow', 'tow content', '0', '2020-01-31 11:05:22', '2020-01-31 11:06:10');
INSERT INTO `blog` VALUES ('3', 'one', 'content', '0', '2018-08-23 17:38:23', '2018-08-23 17:38:23');
INSERT INTO `blog` VALUES ('4', 'one', 'content', '0', '2018-08-23 17:42:46', '2018-08-23 17:42:46');
INSERT INTO `blog` VALUES ('5', 'one', 'content', '0', '2018-08-23 17:42:46', '2018-08-23 17:42:46');
INSERT INTO `blog` VALUES ('6', 'one', 'content', '0', '2018-08-23 17:42:46', '2018-08-23 17:42:46');
INSERT INTO `blog` VALUES ('7', 'one', 'content', '0', '2018-08-23 17:42:46', '2018-08-23 17:42:46');
INSERT INTO `blog` VALUES ('8', 'one', 'content', '0', '2018-08-23 17:42:46', '2018-08-23 17:42:46');
INSERT INTO `blog` VALUES ('9', 'one', 'content', '0', '2018-08-23 17:42:46', '2018-08-23 17:42:46');
INSERT INTO `blog` VALUES ('10', 'one', 'content', '0', '2018-08-23 17:42:46', '2018-08-23 17:42:46');
INSERT INTO `blog` VALUES ('11', 'one', 'content', '0', '2018-08-23 17:42:47', '2018-08-23 17:42:47');
INSERT INTO `blog` VALUES ('12', 'one', 'content', '0', '2018-08-23 17:42:47', '2018-08-23 17:42:47');
INSERT INTO `blog` VALUES ('13', 'one', 'content', '0', '2018-08-23 17:42:47', '2018-08-23 17:42:47');
INSERT INTO `blog` VALUES ('14', 'one', 'content', '0', '2018-08-23 17:42:47', '2018-08-23 17:42:47');
INSERT INTO `blog` VALUES ('15', 'one', 'content', '0', '2018-08-23 17:42:47', '2018-08-23 17:42:47');
INSERT INTO `blog` VALUES ('16', 'one', 'content', '0', '2018-08-23 17:42:47', '2018-08-23 17:42:47');
INSERT INTO `blog` VALUES ('17', 'one', 'content', '0', '2018-08-23 17:42:47', '2018-08-23 17:42:47');
INSERT INTO `blog` VALUES ('18', 'one', 'content', '0', '2018-08-23 17:42:48', '2018-08-23 17:42:48');
INSERT INTO `blog` VALUES ('19', 'one', 'content', '0', '2018-08-23 17:42:48', '2018-08-23 17:42:48');
INSERT INTO `blog` VALUES ('20', 'one', 'content', '0', '2018-08-23 17:42:48', '2018-08-23 17:42:48');
INSERT INTO `blog` VALUES ('21', 'one', 'content', '0', '2018-08-23 17:42:48', '2018-08-23 17:42:48');

-- ----------------------------
-- Table structure for id_gen
-- ----------------------------
DROP TABLE IF EXISTS `id_gen`;
CREATE TABLE `id_gen` (
  `id_name` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID名称，比如public_id；外部根据此名称来获取id',
  `next_start_id` bigint(20) NOT NULL DEFAULT '1' COMMENT '当取ID时，获取到的起始ID',
  `fetch_len` int(11) NOT NULL DEFAULT '100' COMMENT '每次取ID的长度，比如100，返回100个ID',
  `id_desc` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '备注说明',
  PRIMARY KEY (`id_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=COMPACT COMMENT='ID生成表，所有数字ID由ID服务统一生成；注意：该表不允许并发操作，请使用统一的工具（加锁）来操作';

-- ----------------------------
-- Records of id_gen
-- ----------------------------
INSERT INTO `id_gen` VALUES ('item_id', '1000', '1', 'ITEM_ID');
INSERT INTO `id_gen` VALUES ('order_id', '1000', '1', 'ORDER ID');
INSERT INTO `id_gen` VALUES ('user_id', '1000', '1', 'USER_ID');

-- ----------------------------
-- Table structure for mall_item
-- ----------------------------
DROP TABLE IF EXISTS `mall_item`;
CREATE TABLE `mall_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(255) NOT NULL DEFAULT '',
  `item_price` bigint(20) NOT NULL DEFAULT '0',
  `item_image` varchar(255) NOT NULL DEFAULT '',
  `item_desc` varchar(255) NOT NULL DEFAULT '',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_mark` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of mall_item
-- ----------------------------
INSERT INTO `mall_item` VALUES ('1', '沐浴露', '2600', '2.jpg', '沐浴露', '2020-04-05 16:00:00', '2020-04-05 16:00:00', '0');
INSERT INTO `mall_item` VALUES ('2', '洗发水', '4300', '3.jpg', '洗发水', '2020-04-05 16:00:26', '2020-04-05 16:00:26', '0');

-- ----------------------------
-- Table structure for mall_order
-- ----------------------------
DROP TABLE IF EXISTS `mall_order`;
CREATE TABLE `mall_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(64) NOT NULL DEFAULT '',
  `user_id` bigint(20) NOT NULL,
  `order_status` mediumint(9) NOT NULL,
  `price_amount` bigint(20) NOT NULL DEFAULT '0',
  `discount_amount` bigint(20) DEFAULT '0',
  `coupon_amount` bigint(20) DEFAULT '0',
  `point_amount` bigint(20) DEFAULT '0',
  `delivery_fee` bigint(20) DEFAULT '0',
  `pay_amount` bigint(20) DEFAULT '0',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` datetime DEFAULT CURRENT_TIMESTAMP,
  `delete_mark` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of mall_order
-- ----------------------------
INSERT INTO `mall_order` VALUES ('2', '20200427121526770', '1', '10', '6900', '0', '0', '0', '0', '0', '2020-04-27 12:15:26', '2020-04-27 12:15:26', '0');
INSERT INTO `mall_order` VALUES ('3', '20200427163123748', '1', '10', '6900', '0', '0', '0', '0', '0', '2020-04-27 16:31:23', '2020-04-27 16:31:23', '0');
INSERT INTO `mall_order` VALUES ('4', '20200527145347367', '1', '10', '6900', '0', '0', '0', '0', '0', '2020-05-27 14:53:47', '2020-05-27 14:53:47', '0');
INSERT INTO `mall_order` VALUES ('5', '20200529163726484', '1', '10', '6900', '0', '0', '0', '0', '0', '2020-05-29 16:37:26', '2020-05-29 16:37:26', '0');

-- ----------------------------
-- Table structure for mall_order_consignee
-- ----------------------------
DROP TABLE IF EXISTS `mall_order_consignee`;
CREATE TABLE `mall_order_consignee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL DEFAULT '0',
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `province` varchar(15) DEFAULT '',
  `city` varchar(20) DEFAULT '',
  `area` varchar(30) DEFAULT '' COMMENT '20',
  `address` varchar(100) DEFAULT '',
  `consignee_name` varchar(50) DEFAULT '',
  `mobile` varchar(20) DEFAULT '',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_mark` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of mall_order_consignee
-- ----------------------------
INSERT INTO `mall_order_consignee` VALUES ('2', '1', '1', '广东省', '广州市', '越秀区', '东风东路761号', '陈先生', '15873905393', '2020-04-26 18:47:45', '2020-04-26 18:49:25', '0');
INSERT INTO `mall_order_consignee` VALUES ('3', '1', '1', '广东省', '广州市', '越秀区', '东风东路761号', '陈先生', '15873905393', '2020-04-26 18:47:45', '2020-04-26 18:49:25', '0');
INSERT INTO `mall_order_consignee` VALUES ('4', '1', '1', '广东省', '广州市', '越秀区', '东风东路761号', '陈先生', '15873905393', '2020-04-26 18:47:45', '2020-04-26 18:49:25', '0');
INSERT INTO `mall_order_consignee` VALUES ('5', '1', '1', '广东省', '广州市', '越秀区', '东风东路761号', '陈先生', '15873905393', '2020-04-26 18:47:45', '2020-04-26 18:49:25', '0');

-- ----------------------------
-- Table structure for mall_order_item
-- ----------------------------
DROP TABLE IF EXISTS `mall_order_item`;
CREATE TABLE `mall_order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL DEFAULT '0',
  `item_id` bigint(20) NOT NULL DEFAULT '0',
  `item_price` bigint(20) NOT NULL DEFAULT '0',
  `item_num` int(11) NOT NULL DEFAULT '0',
  `item_name` varchar(128) NOT NULL DEFAULT '',
  `coupon` decimal(12,6) DEFAULT '0.000000',
  `coupon_amout` bigint(20) DEFAULT '0',
  `point_money` decimal(12,6) DEFAULT '0.000000',
  `point_amount` int(11) DEFAULT '0',
  `discount` decimal(12,6) DEFAULT '0.000000',
  `discount_amount` bigint(20) DEFAULT '0',
  `gmt_created` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` datetime DEFAULT CURRENT_TIMESTAMP,
  `delete_mark` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of mall_order_item
-- ----------------------------
INSERT INTO `mall_order_item` VALUES ('1', '1', '1', '2600', '2', '沐浴露', '0.000000', '0', '0.000000', '0', '0.000000', '0', '2020-04-27 12:15:26', '2020-04-27 12:15:26', '0');
INSERT INTO `mall_order_item` VALUES ('2', '1', '2', '4300', '3', '洗发水', '0.000000', '0', '0.000000', '0', '0.000000', '0', '2020-04-27 12:15:26', '2020-04-27 12:15:26', '0');
INSERT INTO `mall_order_item` VALUES ('3', '1', '1', '2600', '2', '沐浴露', '0.000000', '0', '0.000000', '0', '0.000000', '0', '2020-04-27 16:31:23', '2020-04-27 16:31:23', '0');
INSERT INTO `mall_order_item` VALUES ('4', '1', '2', '4300', '3', '洗发水', '0.000000', '0', '0.000000', '0', '0.000000', '0', '2020-04-27 16:31:23', '2020-04-27 16:31:23', '0');
INSERT INTO `mall_order_item` VALUES ('5', '1', '1', '2600', '2', '沐浴露', '0.000000', '0', '0.000000', '0', '0.000000', '0', '2020-05-27 14:53:47', '2020-05-27 14:53:47', '0');
INSERT INTO `mall_order_item` VALUES ('6', '1', '2', '4300', '3', '洗发水', '0.000000', '0', '0.000000', '0', '0.000000', '0', '2020-05-27 14:53:47', '2020-05-27 14:53:47', '0');
INSERT INTO `mall_order_item` VALUES ('7', '1', '1', '2600', '2', '沐浴露', '0.000000', '0', '0.000000', '0', '0.000000', '0', '2020-05-29 16:37:26', '2020-05-29 16:37:26', '0');
INSERT INTO `mall_order_item` VALUES ('8', '1', '2', '4300', '3', '洗发水', '0.000000', '0', '0.000000', '0', '0.000000', '0', '2020-05-29 16:37:26', '2020-05-29 16:37:26', '0');

-- ----------------------------
-- Table structure for mall_user
-- ----------------------------
DROP TABLE IF EXISTS `mall_user`;
CREATE TABLE `mall_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) NOT NULL DEFAULT '',
  `password` varchar(64) NOT NULL DEFAULT '',
  `nick_name` varchar(128) NOT NULL DEFAULT '',
  `avatar` varchar(128) NOT NULL DEFAULT '' COMMENT '头像',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_mark` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of mall_user
-- ----------------------------
INSERT INTO `mall_user` VALUES ('1', 'peter', '123456', 'linken', '2.jpg', '2020-03-22 12:27:18', '2020-05-27 05:02:58', '0');
INSERT INTO `mall_user` VALUES ('2', 'linken', '111111', 'linken', '2.png', '2020-04-05 15:59:15', '2020-04-05 15:59:15', '0');

-- ----------------------------
-- Table structure for mall_user_consignee
-- ----------------------------
DROP TABLE IF EXISTS `mall_user_consignee`;
CREATE TABLE `mall_user_consignee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `province` varchar(15) DEFAULT '',
  `city` varchar(20) DEFAULT '',
  `area` varchar(30) DEFAULT '' COMMENT '20',
  `address` varchar(100) DEFAULT '',
  `consignee_name` varchar(50) DEFAULT '',
  `mobile` varchar(20) DEFAULT '',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_mark` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of mall_user_consignee
-- ----------------------------
INSERT INTO `mall_user_consignee` VALUES ('1', '1', '广东省', '广州市', '越秀区', '东风东路761号', '陈先生', '15873905393', '2020-04-26 18:47:45', '2020-04-26 18:49:25', '0');
