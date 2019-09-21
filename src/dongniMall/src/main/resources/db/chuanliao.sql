/*
 Navicat Premium Data Transfer

 Source Server         : myConnection
 Source Server Type    : MySQL
 Source Server Version : 80014
 Source Host           : localhost:3306
 Source Schema         : chuanliao

 Target Server Type    : MySQL
 Target Server Version : 80014
 File Encoding         : 65001

 Date: 21/09/2019 09:39:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `id` varchar(64) NOT NULL,
  `banner_img` varchar(255) NOT NULL,
  `is_used` tinyint(1) unsigned NOT NULL,
  `url` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for formula
-- ----------------------------
DROP TABLE IF EXISTS `formula`;
CREATE TABLE `formula` (
  `id` varchar(64) NOT NULL,
  `formula_img` varchar(255) NOT NULL,
  `formula_price` decimal(10,2) NOT NULL,
  `description` text NOT NULL,
  `after_sales_service` varchar(20) DEFAULT NULL,
  `sample_price` decimal(10,2) NOT NULL,
  `verify` tinyint(1) NOT NULL COMMENT '0未审核，1审核通过，2审核不通过',
  `phone` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `order_number` varchar(64) NOT NULL,
  `goods_name` varchar(20) NOT NULL,
  `goods_price` decimal(10,2) NOT NULL,
  `goods_img` varchar(255) NOT NULL,
  `goods_count` int(10) NOT NULL,
  `subtotal` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for leave_message
-- ----------------------------
DROP TABLE IF EXISTS `leave_message`;
CREATE TABLE `leave_message` (
  `id` varchar(64) NOT NULL,
  `content` varchar(255) NOT NULL,
  `user_id` varchar(64) NOT NULL,
  `recipient_id` varchar(64) NOT NULL,
  `create_time` datetime NOT NULL,
  `verify` tinyint(1) NOT NULL COMMENT '0未审核，1审核通过，2审核未通过',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for logistics
-- ----------------------------
DROP TABLE IF EXISTS `logistics`;
CREATE TABLE `logistics` (
  `logistics_number` varchar(64) NOT NULL,
  `order_number` varchar(64) NOT NULL,
  `delivery_method` tinyint(1) NOT NULL COMMENT '0申通，1顺丰，2中通，3圆通',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`logistics_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` varchar(64) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(64) NOT NULL,
  `create_time` datetime NOT NULL,
  `permission` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_number` varchar(64) NOT NULL,
  `user_phone` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `payment_amount` decimal(10,2) NOT NULL,
  `payment_method` tinyint(1) NOT NULL COMMENT '0未支付，1支付宝，2微信',
  `order_status` tinyint(1) NOT NULL COMMENT '0未支付，1待发货，2已发货，3已完成',
  `create_time` datetime NOT NULL,
  `complete_time` datetime DEFAULT NULL,
  PRIMARY KEY (`order_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for smallImage
-- ----------------------------
DROP TABLE IF EXISTS `smallImage`;
CREATE TABLE `smallImage` (
  `id` varchar(64) NOT NULL,
  `smallImage_img` varchar(255) NOT NULL,
  `is_used` tinyint(1) unsigned NOT NULL,
  `url` varchar(255) NOT NULL,
  `description` varchar(10) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for teach_video
-- ----------------------------
DROP TABLE IF EXISTS `teach_video`;
CREATE TABLE `teach_video` (
  `id` varchar(64) NOT NULL,
  `cover` varchar(255) NOT NULL,
  `videoUrl` varchar(255) NOT NULL,
  `title` varchar(20) NOT NULL,
  `introduction` text NOT NULL,
  `create_time` datetime NOT NULL,
  `counts` int(10) NOT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `phone` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `gender` tinyint(1) NOT NULL,
  `address` varchar(64) NOT NULL,
  `email` varchar(20) NOT NULL,
  `postal_code` varchar(10) NOT NULL,
  `password` varchar(64) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;
