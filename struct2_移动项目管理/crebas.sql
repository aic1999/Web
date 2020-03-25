/*
Navicat MySQL Data Transfer

Source Server         : structs2
Source Server Version : 50067
Source Host           : localhost:3306
Source Database       : crebas

Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001

Date: 2018-12-27 10:34:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tcharge`
-- ----------------------------
DROP TABLE IF EXISTS `tcharge`;
CREATE TABLE `tcharge` (
  `CHARGE_CODE` varchar(2) collate utf8_bin NOT NULL,
  `CHARGE_NAME` varchar(10) collate utf8_bin default NULL,
  `CHARGE` decimal(6,2) default NULL,
  PRIMARY KEY  (`CHARGE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tcharge
-- ----------------------------

-- ----------------------------
-- Table structure for `tcharge_rule`
-- ----------------------------
DROP TABLE IF EXISTS `tcharge_rule`;
CREATE TABLE `tcharge_rule` (
  `FUNC_ID` varchar(2) collate utf8_bin NOT NULL,
  `CHARGE_CODE` varchar(2) collate utf8_bin NOT NULL,
  `FUNC_NAME` varchar(10) collate utf8_bin default NULL,
  PRIMARY KEY  (`FUNC_ID`,`CHARGE_CODE`),
  KEY `FK_RELATIONSHIP_4` (`CHARGE_CODE`),
  CONSTRAINT `FK_RELATIONSHIP_4` FOREIGN KEY (`CHARGE_CODE`) REFERENCES `tcharge` (`CHARGE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tcharge_rule
-- ----------------------------

-- ----------------------------
-- Table structure for `tcustomer`
-- ----------------------------
DROP TABLE IF EXISTS `tcustomer`;
CREATE TABLE `tcustomer` (
  `CUSTOMER_ID` decimal(8,0) NOT NULL,
  `ID_TYPE` varchar(2) collate utf8_bin default NULL,
  `ID_NUMBER` varchar(20) collate utf8_bin default NULL,
  `CUSTOMER_NAME` varchar(20) collate utf8_bin default NULL,
  `CUSTOMER_BIRTHDAY` date default NULL,
  `CUSTOMER_SEX` varchar(4) collate utf8_bin default NULL,
  `CUSTOMER_ADDRESS` varchar(50) collate utf8_bin default NULL,
  PRIMARY KEY  (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tcustomer
-- ----------------------------

-- ----------------------------
-- Table structure for `tmobiles`
-- ----------------------------
DROP TABLE IF EXISTS `tmobiles`;
CREATE TABLE `tmobiles` (
  `MOBILE_NUMBER` varchar(11) collate utf8_bin NOT NULL,
  `MOBILE_TYPE` varchar(6) collate utf8_bin NOT NULL,
  `CARD_NUMBER` varchar(13) collate utf8_bin NOT NULL,
  `IS_AVAILABLE` varchar(2) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`MOBILE_NUMBER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tmobiles
-- ----------------------------

-- ----------------------------
-- Table structure for `toperator`
-- ----------------------------
DROP TABLE IF EXISTS `toperator`;
CREATE TABLE `toperator` (
  `OPERATOR_ID` varchar(10) collate utf8_bin NOT NULL,
  `OPERATOR_NAME` varchar(20) collate utf8_bin NOT NULL,
  `OPERATOR_PWD` varchar(20) collate utf8_bin NOT NULL,
  `IS_ADMIN` varchar(2) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`OPERATOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of toperator
-- ----------------------------

-- ----------------------------
-- Table structure for `tuser`
-- ----------------------------
DROP TABLE IF EXISTS `tuser`;
CREATE TABLE `tuser` (
  `USER_ID` decimal(8,0) NOT NULL,
  `MOBILE_NUMBER` varchar(11) collate utf8_bin default NULL,
  `ACCOUNT_ID` decimal(8,0) NOT NULL,
  `CUSTOMER_ID` decimal(8,0) NOT NULL,
  `ROAMING_STATUS` varchar(2) collate utf8_bin NOT NULL,
  `COM_LEVEL` varchar(2) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`USER_ID`,`ACCOUNT_ID`,`CUSTOMER_ID`),
  KEY `FK_RELATIONSHIP_1` (`MOBILE_NUMBER`),
  KEY `FK_RELATIONSHIP_2` (`ACCOUNT_ID`),
  KEY `FK_RELATIONSHIP_3` (`CUSTOMER_ID`),
  CONSTRAINT `FK_RELATIONSHIP_3` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `tcustomer` (`CUSTOMER_ID`),
  CONSTRAINT `FK_RELATIONSHIP_1` FOREIGN KEY (`MOBILE_NUMBER`) REFERENCES `tmobiles` (`MOBILE_NUMBER`),
  CONSTRAINT `FK_RELATIONSHIP_2` FOREIGN KEY (`ACCOUNT_ID`) REFERENCES `taccount` (`ACCOUNT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tuser
-- ----------------------------
