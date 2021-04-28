
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `content` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `delete_mark` tinyint(4) NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES (1, 'one', 'content', 0, '2020-01-31 11:05:18', '2020-01-31 11:05:27');
INSERT INTO `blog` VALUES (2, 'tow', 'tow content', 0, '2020-01-31 11:05:22', '2020-01-31 11:06:10');

-- ----------------------------
-- Table structure for mall_item
-- ----------------------------
DROP TABLE IF EXISTS `mall_item`;
CREATE TABLE `mall_item`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `item_price` bigint(20) NOT NULL DEFAULT 0,
  `item_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `item_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `gmt_created` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_update` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `delete_mark` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall_item
-- ----------------------------
INSERT INTO `mall_item` VALUES (1, '沐浴露', 2600, '2.jpg', '沐浴露', '2020-04-05 16:00:00', '2020-04-05 16:00:00', 0);
INSERT INTO `mall_item` VALUES (2, '洗发水', 4300, '3.jpg', '洗发水', '2020-04-05 16:00:26', '2020-04-05 16:00:26', 0);

-- ----------------------------
-- Table structure for mall_order
-- ----------------------------
DROP TABLE IF EXISTS `mall_order`;
CREATE TABLE `mall_order`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `user_id` bigint(20) NOT NULL,
  `order_status` mediumint(9) NOT NULL,
  `price_amount` bigint(20) NOT NULL DEFAULT 0,
  `discount_amount` bigint(20) NULL DEFAULT 0,
  `coupon_amount` bigint(20) NULL DEFAULT 0,
  `point_amount` bigint(20) NULL DEFAULT 0,
  `delivery_fee` bigint(20) NULL DEFAULT 0,
  `pay_amount` bigint(20) NULL DEFAULT 0,
  `gmt_created` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_update` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `delete_mark` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall_order
-- ----------------------------
INSERT INTO `mall_order` VALUES (14, '20200628154433653', 1, 10, 6900, 0, 0, 0, 0, 6900, '2020-06-28 15:44:33', '2020-06-28 15:44:33', 0);
INSERT INTO `mall_order` VALUES (15, '20200628154733470', 1, 10, 6900, 0, 0, 0, 0, 6900, '2020-06-28 15:47:33', '2020-06-28 15:47:33', 0);

-- ----------------------------
-- Table structure for mall_order_consignee
-- ----------------------------
DROP TABLE IF EXISTS `mall_order_consignee`;
CREATE TABLE `mall_order_consignee`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL DEFAULT 0,
  `user_id` bigint(20) NOT NULL DEFAULT 0,
  `province` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  `area` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '20',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  `consignee_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  `gmt_created` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_update` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `delete_mark` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall_order_consignee
-- ----------------------------
INSERT INTO `mall_order_consignee` VALUES (14, 14, 1, '广东省', '广州市', '越秀区', '东风东路761号', '陈先生', '15873905393', '2020-04-26 18:47:45', '2020-04-26 18:49:25', 0);
INSERT INTO `mall_order_consignee` VALUES (15, 15, 1, '广东省', '广州市', '越秀区', '东风东路761号', '陈先生', '15873905393', '2020-04-26 18:47:45', '2020-04-26 18:49:25', 0);

-- ----------------------------
-- Table structure for mall_order_item
-- ----------------------------
DROP TABLE IF EXISTS `mall_order_item`;
CREATE TABLE `mall_order_item`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '订单id',
  `item_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品id',
  `item_price` bigint(20) NOT NULL DEFAULT 0 COMMENT '商品价格',
  `item_num` int(11) NOT NULL DEFAULT 0 COMMENT '购买数量',
  `item_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '商品名称',
  `actual_price` bigint(20) NOT NULL DEFAULT 0 COMMENT '实付价格，商品价格-优惠价格',
  `coupon_amount` bigint(20) NOT NULL DEFAULT 0 COMMENT '优惠券优惠金额(分)',
  `point_amount` bigint(20) NOT NULL DEFAULT 0 COMMENT '积分优惠金额(分)',
  `discount_amount` bigint(20) NOT NULL DEFAULT 0 COMMENT '总优惠金额(分)',
  `gmt_created` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_update` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `delete_mark` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall_order_item
-- ----------------------------
INSERT INTO `mall_order_item` VALUES (22, 14, 1, 2600, 1, '沐浴露', 0, 0, 0, 0, '2020-06-28 15:44:33', '2020-06-28 15:44:33', 0);
INSERT INTO `mall_order_item` VALUES (23, 14, 2, 4300, 2, '洗发水', 0, 0, 0, 0, '2020-06-28 15:44:33', '2020-06-28 15:44:33', 0);
INSERT INTO `mall_order_item` VALUES (24, 15, 1, 2600, 1, '沐浴露', 0, 0, 0, 0, '2020-06-28 15:47:33', '2020-06-28 15:47:33', 0);
INSERT INTO `mall_order_item` VALUES (25, 15, 2, 4300, 2, '洗发水', 0, 0, 0, 0, '2020-06-28 15:47:33', '2020-06-28 15:47:33', 0);

-- ----------------------------
-- Table structure for mall_user
-- ----------------------------
DROP TABLE IF EXISTS `mall_user`;
CREATE TABLE `mall_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `salt` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码盐',
  `nick_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `avatar` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '头像',
  `role` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色',
  `gmt_created` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_update` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `delete_mark` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall_user
-- ----------------------------
INSERT INTO `mall_user` VALUES (1, 'peter', '123456', '', 'linken', '2.jpg', '', '2020-03-22 12:27:18', '2020-05-27 05:02:58', 0);
INSERT INTO `mall_user` VALUES (2, 'linken', '111111', '', 'linken', '2.png', '', '2020-04-05 15:59:15', '2020-04-05 15:59:15', 0);

-- ----------------------------
-- Table structure for mall_user_consignee
-- ----------------------------
DROP TABLE IF EXISTS `mall_user_consignee`;
CREATE TABLE `mall_user_consignee`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `province` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  `area` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '20',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  `consignee_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  `gmt_created` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_update` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `delete_mark` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall_user_consignee
-- ----------------------------
INSERT INTO `mall_user_consignee` VALUES (1, 1, '广东省', '广州市', '天河区', '天河北路11号', '陈先生', '15873905393', '2020-04-26 18:47:45', '2020-06-28 15:49:45', 0);

-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token`  (
  `id` bigint(20) NOT NULL,
  `token_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `token` blob NULL,
  `authentication_id` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `client_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `authentication` blob NULL,
  `refresh_token` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gmt_created` datetime(0) NULL DEFAULT NULL,
  `gmt_update` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unq_authentication_id`(`authentication_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of oauth_access_token
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `client_id` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `resource_ids` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `client_secret` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `scope` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `authorized_grant_types` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `authorities` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `access_token_validity` int(11) NULL DEFAULT NULL,
  `refresh_token_validity` int(11) NULL DEFAULT NULL,
  `additional_information` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `autoapprove` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gmt_created` datetime(0) NULL DEFAULT NULL,
  `gmt_update` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_client_id`(`client_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `token_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `token` blob NULL,
  `authentication` blob NULL,
  `gmt_created` datetime(0) NULL DEFAULT NULL,
  `gmt_update` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of oauth_refresh_token
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;