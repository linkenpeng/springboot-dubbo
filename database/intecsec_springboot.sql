/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost
 Source Database       : intecsec_springboot

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : utf-8

 Date: 06/04/2020 20:50:17 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(150) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `content` varchar(1024) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `delete_mark` tinyint DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
--  Records of `blog`
-- ----------------------------
BEGIN;
INSERT INTO `blog` VALUES ('1', 'one', 'content', '0', '2020-01-31 11:05:18', '2020-01-31 11:05:27'), ('2', 'tow', 'tow content', '0', '2020-01-31 11:05:22', '2020-01-31 11:06:10'), ('3', 'one', 'content', '0', '2018-08-23 17:38:23', '2018-08-23 17:38:23'), ('4', 'one', 'content', '0', '2018-08-23 17:42:46', '2018-08-23 17:42:46'), ('5', 'one', 'content', '0', '2018-08-23 17:42:46', '2018-08-23 17:42:46'), ('6', 'one', 'content', '0', '2018-08-23 17:42:46', '2018-08-23 17:42:46'), ('7', 'one', 'content', '0', '2018-08-23 17:42:46', '2018-08-23 17:42:46'), ('8', 'one', 'content', '0', '2018-08-23 17:42:46', '2018-08-23 17:42:46'), ('9', 'one', 'content', '0', '2018-08-23 17:42:46', '2018-08-23 17:42:46'), ('10', 'one', 'content', '0', '2018-08-23 17:42:46', '2018-08-23 17:42:46'), ('11', 'one', 'content', '0', '2018-08-23 17:42:47', '2018-08-23 17:42:47'), ('12', 'one', 'content', '0', '2018-08-23 17:42:47', '2018-08-23 17:42:47'), ('13', 'one', 'content', '0', '2018-08-23 17:42:47', '2018-08-23 17:42:47'), ('14', 'one', 'content', '0', '2018-08-23 17:42:47', '2018-08-23 17:42:47'), ('15', 'one', 'content', '0', '2018-08-23 17:42:47', '2018-08-23 17:42:47'), ('16', 'one', 'content', '0', '2018-08-23 17:42:47', '2018-08-23 17:42:47'), ('17', 'one', 'content', '0', '2018-08-23 17:42:47', '2018-08-23 17:42:47'), ('18', 'one', 'content', '0', '2018-08-23 17:42:48', '2018-08-23 17:42:48'), ('19', 'one', 'content', '0', '2018-08-23 17:42:48', '2018-08-23 17:42:48'), ('20', 'one', 'content', '0', '2018-08-23 17:42:48', '2018-08-23 17:42:48'), ('21', 'one', 'content', '0', '2018-08-23 17:42:48', '2018-08-23 17:42:48');
COMMIT;

-- ----------------------------
--  Table structure for `id_gen`
-- ----------------------------
DROP TABLE IF EXISTS `id_gen`;
CREATE TABLE `id_gen` (
  `id_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID名称，比如public_id；外部根据此名称来获取id',
  `next_start_id` bigint NOT NULL DEFAULT '1' COMMENT '当取ID时，获取到的起始ID',
  `fetch_len` int NOT NULL DEFAULT '100' COMMENT '每次取ID的长度，比如100，返回100个ID',
  `id_desc` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '备注说明',
  PRIMARY KEY (`id_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=COMPACT COMMENT='ID生成表，所有数字ID由ID服务统一生成；注意：该表不允许并发操作，请使用统一的工具（加锁）来操作';

-- ----------------------------
--  Records of `id_gen`
-- ----------------------------
BEGIN;
INSERT INTO `id_gen` VALUES ('goms_oid', '10200700', '300', 'GOMS OID'), ('goms_unit_id', '10855200', '600', 'GOMS UNIT ID');
COMMIT;

-- ----------------------------
--  Table structure for `mall_item`
-- ----------------------------
DROP TABLE IF EXISTS `mall_item`;
CREATE TABLE `mall_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `item_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `item_price` bigint NOT NULL DEFAULT '0',
  `item_image` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `item_desc` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_mark` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
--  Records of `mall_item`
-- ----------------------------
BEGIN;
INSERT INTO `mall_item` VALUES ('1', '沐浴露', '2600', '2.jpg', '沐浴露', '2020-04-05 16:00:00', '2020-04-05 16:00:00', '0'), ('2', '洗发水', '4300', '3.jpg', '洗发水', '2020-04-05 16:00:26', '2020-04-05 16:00:26', '0');
COMMIT;

-- ----------------------------
--  Table structure for `mall_order`
-- ----------------------------
DROP TABLE IF EXISTS `mall_order`;
CREATE TABLE `mall_order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(64) COLLATE utf8mb4_general_ci NOT NULL,
  `user_id` bigint NOT NULL,
  `order_status` mediumint NOT NULL,
  `price_amount` bigint NOT NULL DEFAULT '0',
  `discount_amount` bigint DEFAULT '0',
  `coupon_amount` bigint DEFAULT '0',
  `point_amount` bigint DEFAULT '0',
  `delivery_fee` bigint DEFAULT '0',
  `pay_amount` bigint DEFAULT '0',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` datetime DEFAULT CURRENT_TIMESTAMP,
  `delete_mark` tinyint DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
--  Records of `mall_order`
-- ----------------------------
BEGIN;
INSERT INTO `mall_order` VALUES ('2', '20200427121526770', '1', '10', '6900', '0', '0', '0', '0', '0', '2020-04-27 12:15:26', '2020-04-27 12:15:26', '0'), ('3', '20200427163123748', '1', '10', '6900', '0', '0', '0', '0', '0', '2020-04-27 16:31:23', '2020-04-27 16:31:23', '0'), ('4', '20200527145347367', '1', '10', '6900', '0', '0', '0', '0', '0', '2020-05-27 14:53:47', '2020-05-27 14:53:47', '0'), ('5', '20200529163726484', '1', '10', '6900', '0', '0', '0', '0', '0', '2020-05-29 16:37:26', '2020-05-29 16:37:26', '0');
COMMIT;

-- ----------------------------
--  Table structure for `mall_order_consignee`
-- ----------------------------
DROP TABLE IF EXISTS `mall_order_consignee`;
CREATE TABLE `mall_order_consignee` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_id` bigint NOT NULL DEFAULT '0',
  `user_id` bigint NOT NULL DEFAULT '0',
  `province` varchar(15) DEFAULT '',
  `city` varchar(20) DEFAULT '',
  `area` varchar(30) DEFAULT '' COMMENT '20',
  `address` varchar(100) DEFAULT '',
  `consignee_name` varchar(50) DEFAULT '',
  `mobile` varchar(20) DEFAULT '',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_mark` tinyint DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `mall_order_consignee`
-- ----------------------------
BEGIN;
INSERT INTO `mall_order_consignee` VALUES ('2', '1', '1', '广东省', '广州市', '越秀区', '东风东路761号', '陈先生', '15873905393', '2020-04-26 18:47:45', '2020-04-26 18:49:25', '0'), ('3', '1', '1', '广东省', '广州市', '越秀区', '东风东路761号', '陈先生', '15873905393', '2020-04-26 18:47:45', '2020-04-26 18:49:25', '0'), ('4', '1', '1', '广东省', '广州市', '越秀区', '东风东路761号', '陈先生', '15873905393', '2020-04-26 18:47:45', '2020-04-26 18:49:25', '0'), ('5', '1', '1', '广东省', '广州市', '越秀区', '东风东路761号', '陈先生', '15873905393', '2020-04-26 18:47:45', '2020-04-26 18:49:25', '0');
COMMIT;

-- ----------------------------
--  Table structure for `mall_order_item`
-- ----------------------------
DROP TABLE IF EXISTS `mall_order_item`;
CREATE TABLE `mall_order_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_id` bigint NOT NULL DEFAULT '0',
  `item_id` bigint NOT NULL DEFAULT '0',
  `item_price` bigint NOT NULL DEFAULT '0',
  `item_num` int NOT NULL DEFAULT '0',
  `item_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '',
  `coupon` decimal(12,6) DEFAULT '0.000000',
  `coupon_amout` bigint DEFAULT '0',
  `point_money` decimal(12,6) DEFAULT '0.000000',
  `point_amount` int DEFAULT '0',
  `discount` decimal(12,6) DEFAULT '0.000000',
  `discount_amount` bigint DEFAULT '0',
  `gmt_created` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` datetime DEFAULT CURRENT_TIMESTAMP,
  `delete_mark` tinyint DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
--  Records of `mall_order_item`
-- ----------------------------
BEGIN;
INSERT INTO `mall_order_item` VALUES ('1', '1', '1', '2600', '2', '沐浴露', '0.000000', '0', '0.000000', '0', '0.000000', '0', '2020-04-27 12:15:26', '2020-04-27 12:15:26', '0'), ('2', '1', '2', '4300', '3', '洗发水', '0.000000', '0', '0.000000', '0', '0.000000', '0', '2020-04-27 12:15:26', '2020-04-27 12:15:26', '0'), ('3', '1', '1', '2600', '2', '沐浴露', '0.000000', '0', '0.000000', '0', '0.000000', '0', '2020-04-27 16:31:23', '2020-04-27 16:31:23', '0'), ('4', '1', '2', '4300', '3', '洗发水', '0.000000', '0', '0.000000', '0', '0.000000', '0', '2020-04-27 16:31:23', '2020-04-27 16:31:23', '0'), ('5', '1', '1', '2600', '2', '沐浴露', '0.000000', '0', '0.000000', '0', '0.000000', '0', '2020-05-27 14:53:47', '2020-05-27 14:53:47', '0'), ('6', '1', '2', '4300', '3', '洗发水', '0.000000', '0', '0.000000', '0', '0.000000', '0', '2020-05-27 14:53:47', '2020-05-27 14:53:47', '0'), ('7', '1', '1', '2600', '2', '沐浴露', '0.000000', '0', '0.000000', '0', '0.000000', '0', '2020-05-29 16:37:26', '2020-05-29 16:37:26', '0'), ('8', '1', '2', '4300', '3', '洗发水', '0.000000', '0', '0.000000', '0', '0.000000', '0', '2020-05-29 16:37:26', '2020-05-29 16:37:26', '0');
COMMIT;

-- ----------------------------
--  Table structure for `mall_user`
-- ----------------------------
DROP TABLE IF EXISTS `mall_user`;
CREATE TABLE `mall_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `password` varchar(64) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `nick_name` varchar(128) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `avatar` varchar(128) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '头像',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_mark` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
--  Records of `mall_user`
-- ----------------------------
BEGIN;
INSERT INTO `mall_user` VALUES ('1', 'peter', '123456', 'linken', '2.jpg', '2020-03-22 12:27:18', '2020-05-27 05:02:58', '0'), ('2', 'linken', '111111', 'linken', '2.png', '2020-04-05 15:59:15', '2020-04-05 15:59:15', '0');
COMMIT;

-- ----------------------------
--  Table structure for `mall_user_consignee`
-- ----------------------------
DROP TABLE IF EXISTS `mall_user_consignee`;
CREATE TABLE `mall_user_consignee` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `province` varchar(15) DEFAULT '',
  `city` varchar(20) DEFAULT '',
  `area` varchar(30) DEFAULT '' COMMENT '20',
  `address` varchar(100) DEFAULT '',
  `consignee_name` varchar(50) DEFAULT '',
  `mobile` varchar(20) DEFAULT '',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_mark` tinyint DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records of `mall_user_consignee`
-- ----------------------------
BEGIN;
INSERT INTO `mall_user_consignee` VALUES ('1', '1', '广东省', '广州市', '越秀区', '东风东路761号', '陈先生', '15873905393', '2020-04-26 18:47:45', '2020-04-26 18:49:25', '0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
