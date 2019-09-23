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

 Date: 21/09/2019 15:15:34
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
-- Table structure for BaseStore
-- ----------------------------
DROP TABLE IF EXISTS `BaseStore`;
CREATE TABLE `BaseStore` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `tradeName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `tradeType` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `price` float(20,2) DEFAULT NULL,
  `tradeURL` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `imageURL` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `updateTime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `viewCount` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for formula
-- ----------------------------
DROP TABLE IF EXISTS `formula`;
CREATE TABLE `formula` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `formulaURL` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `formulaPrice` float(10,2) DEFAULT NULL,
  `formulaDescription` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `samplePrice` float(10,2) DEFAULT NULL,
  `flyPrice` float(10,2) DEFAULT NULL,
  `factoryAdress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `updateTime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `formulaName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

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
-- Table structure for newsinformation
-- ----------------------------
DROP TABLE IF EXISTS `newsinformation`;
CREATE TABLE `newsinformation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `source` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `imageUrl` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `summary` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin,
  `updateTime` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

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
-- Table structure for publicityTemplate
-- ----------------------------
DROP TABLE IF EXISTS `publicityTemplate`;
CREATE TABLE `publicityTemplate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `templateName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `templateType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `textDescription` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin,
  `image` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `price` float DEFAULT NULL,
  `updateTime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

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
  `position` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for BaseStore
-- ----------------------------
DROP TABLE IF EXISTS `BaseStore`;
CREATE TABLE `BaseStore` (
  `id` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `tradeName` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `tradeType` varchar(25) COLLATE utf8mb4_bin DEFAULT NULL,
  `price` float(20,2) DEFAULT NULL,
  `tradeURL` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `imageURL` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `updateTime` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `viewCount` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

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
-- Table structure for tradeType
-- ----------------------------
DROP TABLE IF EXISTS `tradeType`;
CREATE TABLE `tradeType` (
  `id` varchar(255) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  `updateTime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for formula
-- ----------------------------
DROP TABLE IF EXISTS `formula`;
CREATE TABLE `formula` (
  `id` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `formulaURL` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `formulaPrice` float(10,2) DEFAULT NULL,
  `formulaDescription` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `samplePrice` float(10,2) DEFAULT NULL,
  `flyPrice` float(10,2) DEFAULT NULL,
  `factoryAdress` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `updateTime` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `formulaName` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for publicityTemplate
-- ----------------------------
DROP TABLE IF EXISTS `publicityTemplate`;
CREATE TABLE `publicityTemplate` (
  `id` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `templateName` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `templateType` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `textDescription` longtext COLLATE utf8mb4_bin,
  `image` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `price` float DEFAULT NULL,
  `updateTime` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for newsinformation
-- ----------------------------
DROP TABLE IF EXISTS `newsinformation`;
CREATE TABLE `newsinformation` (
  `id` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `title` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `source` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `imageUrl` varchar(300) COLLATE utf8mb4_bin DEFAULT NULL,
  `summary` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL,
  `content` longtext COLLATE utf8mb4_bin,
  `updateTime` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


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
