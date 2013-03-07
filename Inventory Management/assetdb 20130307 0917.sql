-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.38-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema assetdb
--

CREATE DATABASE IF NOT EXISTS assetdb;
USE assetdb;

--
-- Definition of table `borrowed`
--

DROP TABLE IF EXISTS `borrowed`;
CREATE TABLE `borrowed` (
  `BORRWED_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ITEM_ID` varchar(45) NOT NULL,
  `USER_ID` varchar(45) NOT NULL,
  `DATE_BORROWED` datetime NOT NULL,
  `DATE_RETURNED` datetime NOT NULL,
  PRIMARY KEY (`BORRWED_ID`),
  KEY `FK_BORROWED_1` (`ITEM_ID`),
  KEY `FK_borrowed_2` (`USER_ID`),
  CONSTRAINT `FK_BORROWED_1` FOREIGN KEY (`ITEM_ID`) REFERENCES `items` (`ITEM_ID`),
  CONSTRAINT `FK_borrowed_2` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `borrowed`
--

/*!40000 ALTER TABLE `borrowed` DISABLE KEYS */;
/*!40000 ALTER TABLE `borrowed` ENABLE KEYS */;


--
-- Definition of table `comments`
--

DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `COMMENT_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ITEM_ID` varchar(45) NOT NULL,
  `USER_ID` varchar(45) NOT NULL,
  `TEXT` varchar(120) NOT NULL,
  `DATE_COMMENT` datetime NOT NULL,
  PRIMARY KEY (`COMMENT_ID`),
  KEY `FK_comments_1` (`ITEM_ID`),
  KEY `FK_comments_2` (`USER_ID`),
  CONSTRAINT `FK_comments_1` FOREIGN KEY (`ITEM_ID`) REFERENCES `items` (`ITEM_ID`),
  CONSTRAINT `FK_comments_2` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comments`
--

/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;


--
-- Definition of table `feeds`
--

DROP TABLE IF EXISTS `feeds`;
CREATE TABLE `feeds` (
  `FEED_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `USER_ID` varchar(45) NOT NULL,
  `ACTION_ID` int(10) unsigned NOT NULL,
  `ITEM_ID` varchar(45) NOT NULL,
  `DATE_POSTED` datetime NOT NULL,
  PRIMARY KEY (`FEED_ID`),
  KEY `FK_FEEDS_1` (`USER_ID`),
  KEY `FK_feeds_2` (`ITEM_ID`),
  CONSTRAINT `FK_FEEDS_1` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`),
  CONSTRAINT `FK_feeds_2` FOREIGN KEY (`ITEM_ID`) REFERENCES `items` (`ITEM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feeds`
--

/*!40000 ALTER TABLE `feeds` DISABLE KEYS */;
/*!40000 ALTER TABLE `feeds` ENABLE KEYS */;


--
-- Definition of table `groups`
--

DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `GRP_ID` varchar(45) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`GRP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `groups`
--

/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;


--
-- Definition of table `item_types`
--

DROP TABLE IF EXISTS `item_types`;
CREATE TABLE `item_types` (
  `ITEM_TYPE_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`ITEM_TYPE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item_types`
--

/*!40000 ALTER TABLE `item_types` DISABLE KEYS */;
INSERT INTO `item_types` (`ITEM_TYPE_ID`,`NAME`) VALUES 
 (1,'Phone'),
 (2,'Tablet'),
 (3,'USB');
/*!40000 ALTER TABLE `item_types` ENABLE KEYS */;


--
-- Definition of table `items`
--

DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `ITEM_ID` varchar(45) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `PROD_ID` int(10) unsigned NOT NULL,
  `ITEM_TYPE_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ITEM_ID`),
  KEY `FK_items_2` (`ITEM_TYPE_ID`),
  KEY `FK_items_1` (`PROD_ID`),
  CONSTRAINT `FK_items_1` FOREIGN KEY (`PROD_ID`) REFERENCES `products` (`PROD_ID`),
  CONSTRAINT `FK_items_2` FOREIGN KEY (`ITEM_TYPE_ID`) REFERENCES `item_types` (`ITEM_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `items`
--

/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` (`ITEM_ID`,`NAME`,`PROD_ID`,`ITEM_TYPE_ID`) VALUES 
 ('12343212','I9300-a',1,1),
 ('24543344','Galaxy tablet-a',2,2),
 ('33445423','Galaxy tablet-b',2,2),
 ('34321232','USB-a',3,3),
 ('46778769','USB-b',3,3),
 ('54241234','19300-b',1,1);
/*!40000 ALTER TABLE `items` ENABLE KEYS */;


--
-- Definition of table `permission`
--

DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `PERM_ID` varchar(45) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `MAX_DEV_COUNT` int(10) unsigned NOT NULL,
  PRIMARY KEY (`PERM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `permission`
--

/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;


--
-- Definition of table `pictures`
--

DROP TABLE IF EXISTS `pictures`;
CREATE TABLE `pictures` (
  `PIC_ID` varchar(45) NOT NULL,
  `USER_ID` varchar(45) NOT NULL,
  `URL` varchar(45) NOT NULL,
  `DATE_UPLOADED` datetime NOT NULL,
  PRIMARY KEY (`PIC_ID`),
  KEY `FK_PICTURES_1` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pictures`
--

/*!40000 ALTER TABLE `pictures` DISABLE KEYS */;
/*!40000 ALTER TABLE `pictures` ENABLE KEYS */;


--
-- Definition of table `products`
--

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `PROD_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `DESC` varchar(45) NOT NULL,
  PRIMARY KEY (`PROD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` (`PROD_ID`,`NAME`,`DESC`) VALUES 
 (1,'I9300','This is a phone'),
 (2,'Galaxy tab','this is a tablet'),
 (3,'USB','this is a usb');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `USER_ID` varchar(45) NOT NULL,
  `DISPLAY_NAME` varchar(45) NOT NULL,
  `LDAP_ID` varchar(45) NOT NULL,
  `GRP_ID` varchar(45) NOT NULL,
  `PERM_ID` varchar(45) NOT NULL,
  `PIC_ID` varchar(45) NOT NULL,
  PRIMARY KEY (`USER_ID`) USING BTREE,
  KEY `FK_users_1` (`PERM_ID`),
  KEY `FK_users_2` (`GRP_ID`),
  KEY `FK_users_3` (`PIC_ID`),
  CONSTRAINT `FK_users_1` FOREIGN KEY (`PERM_ID`) REFERENCES `permission` (`PERM_ID`),
  CONSTRAINT `FK_users_2` FOREIGN KEY (`GRP_ID`) REFERENCES `groups` (`GRP_ID`),
  CONSTRAINT `FK_users_3` FOREIGN KEY (`PIC_ID`) REFERENCES `pictures` (`PIC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
