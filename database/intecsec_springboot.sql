/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : intecsec_springboot

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 21/06/2022 23:41:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(150) DEFAULT NULL,
  `content` varchar(1024) DEFAULT NULL,
  `delete_mark` tinyint DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of blog
-- ----------------------------
BEGIN;
INSERT INTO `blog` VALUES (1, 'one', 'content', 0, '2020-01-31 11:05:18', '2020-01-31 11:05:27');
INSERT INTO `blog` VALUES (2, 'tow', 'tow content', 0, '2020-01-31 11:05:22', '2020-01-31 11:06:10');
COMMIT;

-- ----------------------------
-- Table structure for mall_item
-- ----------------------------
DROP TABLE IF EXISTS `mall_item`;
CREATE TABLE `mall_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `item_name` varchar(255) NOT NULL DEFAULT '',
  `item_price` bigint NOT NULL DEFAULT '0',
  `item_image` varchar(255) NOT NULL DEFAULT '',
  `item_desc` varchar(255) NOT NULL DEFAULT '',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_mark` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of mall_item
-- ----------------------------
BEGIN;
INSERT INTO `mall_item` VALUES (1, '沐浴露', 2600, '2.jpg', '沐浴露', '2020-04-05 16:00:00', '2020-04-05 16:00:00', 0);
INSERT INTO `mall_item` VALUES (2, '洗发水', 4300, '3.jpg', '洗发水', '2020-04-05 16:00:26', '2020-04-05 16:00:26', 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_order
-- ----------------------------
DROP TABLE IF EXISTS `mall_order`;
CREATE TABLE `mall_order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(64) NOT NULL DEFAULT '',
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of mall_order
-- ----------------------------
BEGIN;
INSERT INTO `mall_order` VALUES (14, '20200628154433653', 1, 10, 6900, 0, 0, 0, 0, 6900, '2020-06-28 15:44:33', '2020-06-28 15:44:33', 0);
INSERT INTO `mall_order` VALUES (15, '20200628154733470', 1, 10, 6900, 0, 0, 0, 0, 6900, '2020-06-28 15:47:33', '2020-06-28 15:47:33', 0);
INSERT INTO `mall_order` VALUES (16, '20220621231918573', 1, 10, 6900, 0, 0, 0, 0, 6900, '2022-06-21 23:19:18', '2022-06-21 23:19:18', 0);
INSERT INTO `mall_order` VALUES (17, '20220621233146277', 1, 10, 6900, 0, 0, 0, 0, 6900, '2022-06-21 23:31:46', '2022-06-21 23:31:46', 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_order_consignee
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of mall_order_consignee
-- ----------------------------
BEGIN;
INSERT INTO `mall_order_consignee` VALUES (14, 14, 1, '广东省', '广州市', '越秀区', '东风东路761号', '陈先生', '15873905393', '2020-04-26 18:47:45', '2020-04-26 18:49:25', 0);
INSERT INTO `mall_order_consignee` VALUES (15, 15, 1, '广东省', '广州市', '越秀区', '东风东路761号', '陈先生', '15873905393', '2020-04-26 18:47:45', '2020-04-26 18:49:25', 0);
INSERT INTO `mall_order_consignee` VALUES (16, 16, 1, '广东省', '广州市', '天河区', '天河北路11号', '陈先生', '15873905393', '2020-04-26 18:47:45', '2020-06-28 15:49:45', 0);
INSERT INTO `mall_order_consignee` VALUES (17, 17, 1, '广东省', '广州市', '天河区', '天河北路11号', '陈先生', '15873905393', '2020-04-26 18:47:45', '2020-06-28 15:49:45', 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_order_item
-- ----------------------------
DROP TABLE IF EXISTS `mall_order_item`;
CREATE TABLE `mall_order_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_id` bigint NOT NULL DEFAULT '0' COMMENT '订单id',
  `item_id` bigint NOT NULL DEFAULT '0' COMMENT '商品id',
  `item_price` bigint NOT NULL DEFAULT '0' COMMENT '商品价格',
  `item_num` int NOT NULL DEFAULT '0' COMMENT '购买数量',
  `item_name` varchar(128) NOT NULL DEFAULT '' COMMENT '商品名称',
  `actual_price` bigint NOT NULL DEFAULT '0' COMMENT '实付价格，商品价格-优惠价格',
  `coupon_amount` bigint NOT NULL DEFAULT '0' COMMENT '优惠券优惠金额(分)',
  `point_amount` bigint NOT NULL DEFAULT '0' COMMENT '积分优惠金额(分)',
  `discount_amount` bigint NOT NULL DEFAULT '0' COMMENT '总优惠金额(分)',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_mark` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of mall_order_item
-- ----------------------------
BEGIN;
INSERT INTO `mall_order_item` VALUES (22, 14, 1, 2600, 1, '沐浴露', 0, 0, 0, 0, '2020-06-28 15:44:33', '2020-06-28 15:44:33', 0);
INSERT INTO `mall_order_item` VALUES (23, 14, 2, 4300, 2, '洗发水', 0, 0, 0, 0, '2020-06-28 15:44:33', '2020-06-28 15:44:33', 0);
INSERT INTO `mall_order_item` VALUES (24, 15, 1, 2600, 1, '沐浴露', 0, 0, 0, 0, '2020-06-28 15:47:33', '2020-06-28 15:47:33', 0);
INSERT INTO `mall_order_item` VALUES (25, 15, 2, 4300, 2, '洗发水', 0, 0, 0, 0, '2020-06-28 15:47:33', '2020-06-28 15:47:33', 0);
INSERT INTO `mall_order_item` VALUES (26, 16, 1, 2600, 2, '沐浴露', 0, 0, 0, 0, '2022-06-21 23:19:18', '2022-06-21 23:19:18', 0);
INSERT INTO `mall_order_item` VALUES (27, 16, 2, 4300, 3, '洗发水', 0, 0, 0, 0, '2022-06-21 23:19:18', '2022-06-21 23:19:18', 0);
INSERT INTO `mall_order_item` VALUES (28, 17, 1, 2600, 2, '沐浴露', 0, 0, 0, 0, '2022-06-21 23:31:46', '2022-06-21 23:31:46', 0);
INSERT INTO `mall_order_item` VALUES (29, 17, 2, 4300, 3, '洗发水', 0, 0, 0, 0, '2022-06-21 23:31:46', '2022-06-21 23:31:46', 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_user
-- ----------------------------
DROP TABLE IF EXISTS `mall_user`;
CREATE TABLE `mall_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) NOT NULL DEFAULT '',
  `password` varchar(64) NOT NULL DEFAULT '',
  `salt` varchar(255) NOT NULL DEFAULT '',
  `nick_name` varchar(128) NOT NULL DEFAULT '',
  `avatar` varchar(128) NOT NULL DEFAULT '' COMMENT '头像',
  `role` varchar(255) NOT NULL DEFAULT '',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_mark` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of mall_user
-- ----------------------------
BEGIN;
INSERT INTO `mall_user` VALUES (1, 'peter', '123456', '', 'linken', '2.jpg', '', '2020-03-22 12:27:18', '2020-05-27 05:02:58', 0);
INSERT INTO `mall_user` VALUES (2, 'linken', '111111', '', 'linken', '2.png', '', '2020-04-05 15:59:15', '2020-04-05 15:59:15', 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_user_consignee
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
-- Records of mall_user_consignee
-- ----------------------------
BEGIN;
INSERT INTO `mall_user_consignee` VALUES (1, 1, '广东省', '广州市', '天河区', '天河北路11号', '陈先生', '15873905393', '2020-04-26 18:47:45', '2020-06-28 15:49:45', 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
