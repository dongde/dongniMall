/*
Navicat MySQL Data Transfer

Source Server         : 本地Mysql
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : SORM

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-09-21 09:40:47
*/

SET FOREIGN_KEY_CHECKS=0;

########底料商城#########
-- ----------------------------
-- Table structure for BaseStoreDO
-- ----------------------------
DROP TABLE IF EXISTS `BaseStore`;
CREATE TABLE `BaseStore` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `tradeName` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `tradeType` varchar(25) COLLATE utf8mb4_bin DEFAULT NULL,
  `price` float(20,2) DEFAULT NULL,
  `tradeURL` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `imageURL` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `updateTime` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `viewCount` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

########配方管理######
-- ----------------------------
-- Table structure for formulaDO
-- ----------------------------
DROP TABLE IF EXISTS `formulaDO`;
CREATE TABLE `formulaDO` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `formulaURL` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `formulaPrice` float(10,2) DEFAULT NULL,
  `formulaDescription` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `samplePrice` float(10,2) DEFAULT NULL,
  `flyPrice` float(10,2) DEFAULT NULL,
  `factoryAdress` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `updateTime` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `formulaName` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

######新闻资讯#######
-- ----------------------------
-- Table structure for newsinformation
-- ----------------------------
DROP TABLE IF EXISTS `newsinformation`;
CREATE TABLE `newsinformation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `source` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `imageUrl` varchar(300) COLLATE utf8mb4_bin DEFAULT NULL,
  `summary` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL,
  `content` longtext COLLATE utf8mb4_bin,
  `updateTime` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

######宣传模板#####
-- ----------------------------
-- Table structure for templateDO
-- ----------------------------
DROP TABLE IF EXISTS `templateDO`;
CREATE TABLE `templateDO` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `templateName` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `templateType` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `textDescription` longtext COLLATE utf8mb4_bin,
  `image` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `price` float DEFAULT NULL,
  `updateTime` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
