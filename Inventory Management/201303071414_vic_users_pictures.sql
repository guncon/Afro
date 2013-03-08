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
INSERT INTO `groups` (`GRP_ID`,`NAME`) VALUES 
 ('0','DPI'),
 ('1','MOBILE APPS'),
 ('2','TG');
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
  `MAX_DEV_COUNT` int(10) NOT NULL,
  PRIMARY KEY (`PERM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `permission`
--

/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` (`PERM_ID`,`NAME`,`MAX_DEV_COUNT`) VALUES 
 ('0','GOD',-1),
 ('1','DPI',20),
 ('2','PL',15),
 ('3','TG',5);
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
INSERT INTO `pictures` (`PIC_ID`,`USER_ID`,`URL`,`DATE_UPLOADED`) VALUES 
 ('1','1','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('10','10','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('11','11','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('12','12','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('13','13','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('14','14','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('15','15','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('16','16','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('17','17','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('18','18','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('19','19','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('2','2','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('20','20','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('21','21','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('22','22','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('23','23','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('24','24','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('25','25','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('26','26','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('27','27','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('28','28','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('29','29','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('3','3','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('30','30','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('31','31','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('32','32','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('33','33','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('34','34','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('35','35','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('36','36','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('37','37','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('38','38','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('39','39','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('4','4','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('40','40','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('41','41','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('42','42','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('43','43','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('44','44','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('45','45','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('46','46','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('5','5','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('6','6','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('7','7','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('8','8','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00'),
 ('9','9','www.android.com/media/android_vector.jpg','2013-03-07 00:00:00');
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
  `PIC_ID` varchar(45) DEFAULT NULL,
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
INSERT INTO `users` (`USER_ID`,`DISPLAY_NAME`,`LDAP_ID`,`GRP_ID`,`PERM_ID`,`PIC_ID`) VALUES 
 ('1','Joel Realubit','1','2','3','1'),
 ('10','Michelle Dingcon','10','2','3','10'),
 ('11','Roselle Elefante','11','2','3','11'),
 ('12','Joyce Ortega','12','2','3','12'),
 ('13','Patrick Faylon','13','2','3','13'),
 ('14','Raj Serafines','14','2','3','14'),
 ('15','Mark Tan','15','2','3','15'),
 ('16','Emarc Magtanong','16','2','3','16'),
 ('17','JC Yu','17','2','3','17'),
 ('18','Jor-el Rivo','18','2','3','18'),
 ('19','Eprom Galang','19','2','3','19'),
 ('2','Aurelio Pascual','2','2','3','2'),
 ('20','Rocky Camacho','20','2','3','20'),
 ('21','Arianne Garing','21','2','3','21'),
 ('22','Paul Siena','22','2','3','22'),
 ('23','Jobelle Azur','23','2','3','23'),
 ('24','John Elevado','24','2','3','24'),
 ('25','Karen Ang','25','2','3','25'),
 ('26','Alexandra Dayrit','26','2','3','26'),
 ('27','Karen Lizzie Aclan','27','2','3','27'),
 ('28','Adonis Villamor','28','2','3','28'),
 ('29','Neil Cruzabra','29','2','3','29'),
 ('3','Angelo Viado','3','2','3','3'),
 ('30','Justin De Guzman','30','2','3','30'),
 ('31','Czarina De Vera','31','2','3','31'),
 ('32','Anne Jasmine Villadare','32','2','3','32'),
 ('33','John Patrick Enriquez','33','2','3','33'),
 ('34','Kermith Galang','34','2','3','34'),
 ('35','Sherie Yu','35','2','3','35'),
 ('36','Geraldine Austria','36','2','3','36'),
 ('37','Nido Molejon','37','2','3','37'),
 ('38','Wilford Alibay','38','2','3','38'),
 ('39','Karla Delos Santos','39','2','3','39'),
 ('4','Mark Lagatao','4','2','3','4'),
 ('40','Allan Castro','40','2','3','40'),
 ('41','Mark Agustin','41','2','3','41'),
 ('42','Mikaela Sitjar','42','2','3','42'),
 ('43','Federico Sandoval','43','2','3','43'),
 ('44','Mark Ching','44','2','3','44'),
 ('45','Clarence Dalan Jr.','45','2','3','45'),
 ('46','Xavier Valenzuela','46','2','3','46'),
 ('5','Sam Francisco','5','2','3','5'),
 ('6','George Tan II','6','2','3','6'),
 ('7','Abi Victa','7','2','3','7'),
 ('8','Manny Abarquez','8','2','3','8'),
 ('9','Jonnah Rinos','9','2','3','9');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
