CREATE DATABASE  IF NOT EXISTS `netcracker_hotel` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `netcracker_hotel`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: netcracker_hotel
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attribute`
--

DROP TABLE IF EXISTS `attribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attribute` (
  `attribute_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `attribute_name` varchar(25) NOT NULL,
  `datatype` varchar(20) NOT NULL,
  PRIMARY KEY (`attribute_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attribute`
--

LOCK TABLES `attribute` WRITE;
/*!40000 ALTER TABLE `attribute` DISABLE KEYS */;
INSERT INTO `attribute` (`attribute_id`, `type_id`, `attribute_name`, `datatype`) VALUES (1,1,'first_name','varchar'),(2,1,'last_name','varchar'),(3,1,'username','varchar'),(4,1,'password','varchar'),(5,1,'avatar','varchar'),(6,2,'country','varchar'),(7,2,'city','varchar'),(8,2,'address','varchar'),(9,2,'class','int'),(10,3,'cost','int'),(11,3,'capacity','int'),(12,3,'hotel_id','int'),(13,4,'user_id','int'),(14,4,'pay_value','int'),(15,4,'is_paid','int'),(16,4,'room_id','int'),(18,4,'arrival_date','date'),(19,4,'leave_date','date'),(21,2,'photo','varchar'),(22,1,'email','varchar'),(23,1,'enabled','boolean'),(24,1,'authority','varchar'),(25,2,'hotel_name','varchar'),(26,2,'hotel_description','varchar'),(27,7,'token_user_id','int'),(28,7,'token','varchar'),(29,7,'token_date','date'),(31,8,'userid','int'),(32,8,'hotelid','int'),(33,8,'feedback','varchar'),(34,8,'status','varchar'),(35,8,'time','date'),(36,8,'star','int'),(37,2,'main_photo','varchar');
/*!40000 ALTER TABLE `attribute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entity`
--

DROP TABLE IF EXISTS `entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entity` (
  `entity_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) NOT NULL,
  PRIMARY KEY (`entity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entity`
--

LOCK TABLES `entity` WRITE;
/*!40000 ALTER TABLE `entity` DISABLE KEYS */;
INSERT INTO `entity` (`entity_id`, `type_id`) VALUES (1,1),(2,1),(52,2),(54,2),(55,2),(58,2),(61,2),(63,2),(65,2),(67,2),(69,2),(70,2),(71,2),(73,2),(75,2),(76,2),(78,2),(81,2),(83,1),(85,8),(86,1),(87,1),(88,1),(89,1),(90,1),(91,1),(92,1),(93,1),(94,1),(95,1),(96,1),(97,1),(98,1),(99,8);
/*!40000 ALTER TABLE `entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persistent_logins`
--

DROP TABLE IF EXISTS `persistent_logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persistent_logins`
--

LOCK TABLES `persistent_logins` WRITE;
/*!40000 ALTER TABLE `persistent_logins` DISABLE KEYS */;
/*!40000 ALTER TABLE `persistent_logins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type` (
  `type_id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` (`type_id`, `name`) VALUES (1,'user'),(2,'hotel'),(3,'room'),(4,'order'),(6,'photos'),(7,'verification_token'),(8,'review');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userconnection`
--

DROP TABLE IF EXISTS `userconnection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userconnection` (
  `userId` varchar(255) NOT NULL,
  `providerId` varchar(255) NOT NULL,
  `providerUserId` varchar(255) NOT NULL,
  `rank` int(11) NOT NULL,
  `displayName` varchar(255) DEFAULT NULL,
  `profileUrl` varchar(512) DEFAULT NULL,
  `imageUrl` varchar(512) DEFAULT NULL,
  `accessToken` varchar(512) NOT NULL,
  `secret` varchar(512) DEFAULT NULL,
  `refreshToken` varchar(512) DEFAULT NULL,
  `expireTime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`userId`,`providerId`,`providerUserId`),
  UNIQUE KEY `UserConnectionRank` (`userId`,`providerId`,`rank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userconnection`
--

LOCK TABLES `userconnection` WRITE;
/*!40000 ALTER TABLE `userconnection` DISABLE KEYS */;
/*!40000 ALTER TABLE `userconnection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `value`
--

DROP TABLE IF EXISTS `value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `value` (
  `value_id` int(11) NOT NULL AUTO_INCREMENT,
  `entity_id` int(11) NOT NULL,
  `attribute_id` int(11) NOT NULL,
  `attribute_value` varchar(90) NOT NULL,
  PRIMARY KEY (`value_id`)
) ENGINE=InnoDB AUTO_INCREMENT=518 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `value`
--

LOCK TABLES `value` WRITE;
/*!40000 ALTER TABLE `value` DISABLE KEYS */;
INSERT INTO `value` (`value_id`, `entity_id`, `attribute_id`, `attribute_value`) VALUES (1,1,1,'roma'),(2,1,2,'rodevich'),(3,1,3,'admin'),(4,1,4,'$2a$11$Z30CWyK5OxD9VqknNWaSfu79V/K.7AJTEhOkJOGoyEnUfZHQH8GK2'),(5,1,22,'admin@gmail.com'),(7,1,24,'ADMIN'),(8,1,23,'1'),(9,1,5,''),(10,2,1,'firstn'),(11,2,2,'lastname'),(12,2,3,'user'),(13,2,4,'$2a$10$PaTYSdJZUkjlMwXQU66Hdef8D7tY2nXhqvcCU3JvYido7CFRloH6m'),(14,2,22,'user@gmail.com'),(15,2,24,'USER'),(16,2,23,'1'),(17,2,5,''),(272,52,6,'Zanzibar'),(273,52,7,'Pemba Island'),(274,52,8,'Psv-zanzibar estate'),(275,52,9,'5'),(276,52,25,'Manta Resort'),(277,52,26,'Underwater Rooms, spa treatment, scuba diving'),(279,51,37,'53'),(280,55,6,'Finland'),(281,55,7,'Levi'),(282,55,8,'Harjatie 4'),(283,55,9,'4'),(284,55,25,'Golden Crown Levin Iglut'),(285,55,26,'Fully insulated and heated glass igloos'),(295,55,37,'57'),(296,58,6,'Japan'),(297,58,7,'Tokyo Prefecture'),(298,58,8,'Toshima-ku Ikebukuro 1-17-7 Lumiere Buld. 7F'),(299,58,9,'2'),(300,58,25,'Book And Bed Tokyo'),(301,58,26,'A haven for bibliophilen'),(303,58,37,'59'),(310,61,6,'Costa Rica'),(311,61,7,'Provincia de Puntarenas'),(312,61,8,'Playas de Manuel Antonio,  Km 5, Costa Rica., Manuel Antonio'),(313,61,9,'3'),(314,61,25,'Hotel Costa Verde'),(315,61,26,'Guests can sleep in an upcycled 1965 Boeing 727'),(317,61,37,'62'),(326,65,6,'Bolivia'),(327,65,7,'Colchani'),(328,65,8,'Orillas Salar de Uyuni'),(329,65,9,'3'),(330,65,25,'Hotel Palacio de Sal'),(331,65,26,'Luxury hotel in the middle of the Bolivian desert'),(333,65,37,'66'),(334,67,6,'Peru'),(335,67,7,'Yucuruche'),(336,67,8,'Via Yarapa 123'),(337,67,9,'5'),(338,67,25,'Treehouse Lodge'),(339,67,26,'Featuring bungalows located at the top of trees'),(341,67,37,'68'),(354,71,6,'Spain'),(355,71,7,'Elciego'),(356,71,8,'Torrea, 1'),(357,71,9,'5'),(358,71,25,'MarquÃ©s de Riscal, a Luxury Collection'),(359,71,26,'The hotel is architect Frank Gehry\'s first hotel project'),(361,71,37,'72'),(362,73,6,'Belarus'),(363,73,7,'Minsk'),(364,73,8,'Prospect Pobediteley 59, Tsentralny District'),(365,73,9,'4'),(366,73,25,'Victoria & SPA Hotel Minsk'),(367,73,26,'Offering a restaurant, free sauna and indoor pool'),(369,73,37,'74'),(376,76,6,'Belarus'),(377,76,7,'Minsk'),(378,76,8,'Kirova Street 18, Leninsky District'),(379,76,9,'5'),(380,76,25,'President Hotel'),(381,76,26,'Fitness centre, an indoor pool and Wi-Fi are available'),(383,76,37,'77'),(384,78,6,'Belarus'),(385,78,7,'Brest'),(386,78,8,'Tyukhinichskaya Street 1'),(387,78,9,'4'),(388,78,25,'Rynkauka Tourist Complex'),(389,78,26,'A private sandy beach and free rental bikes'),(391,78,37,'79'),(392,85,31,'2'),(393,85,32,'73'),(394,85,33,'superPuperHotel'),(395,85,34,'0'),(396,85,35,'today'),(397,85,36,'55'),(398,52,37,'53'),(399,55,37,'57'),(400,58,37,'59'),(401,61,37,'62'),(402,65,37,'66'),(403,67,37,'68'),(404,71,37,'72'),(405,73,37,'74'),(406,76,37,'77'),(407,78,37,'79'),(408,86,1,'333333'),(409,86,2,'333333'),(410,86,3,'333333'),(411,86,4,'$2a$10$SJAJTvhKLtzm6Lh2gn/eZ.8fo7VYG5V3jVGS9fYUvW9dkKFNZdiou'),(412,86,22,'33@mai.ru'),(413,86,24,'USER'),(414,86,23,'1'),(415,86,5,''),(416,87,1,'4444444'),(417,87,2,'444444'),(418,87,3,'444444'),(419,87,4,'$2a$10$v0jO6wIMdSnfhmgUtQUEy.TXNu9Y5J.Twc1Yer3FX3yXYYhJ6g/R.'),(420,87,22,'44@mail.ru'),(421,87,24,'USER'),(422,87,23,'1'),(423,87,5,''),(424,88,1,'555555'),(425,88,2,'555555'),(426,88,3,'555555'),(427,88,4,'$2a$10$t4agRcDcK1iK79hJpAPWTOgs629pmYdQqwACruVivoBSxdWV61xbm'),(428,88,22,'55@mail.ru'),(429,88,24,'BLOCKED'),(430,88,23,'1'),(431,88,5,''),(432,89,1,'666666'),(433,89,2,'666666'),(434,89,3,'666666'),(435,89,4,'$2a$10$1HfF1datOIJXHv5ag0h7qepbbv4H1xhAVHIbasQnt2dV0MOpYaTjK'),(436,89,22,'666@mail.ru'),(437,89,24,'USER'),(438,89,23,'1'),(439,89,5,''),(440,90,1,'777777'),(441,90,2,'777777'),(442,90,3,'777777'),(443,90,4,'$2a$10$VswEiScVCLJwDAVf1WS8Du68404v4aPq6go5nIujfTFAoB4p8Tnge'),(444,90,22,'777@mail.ru'),(445,90,24,'USER'),(446,90,23,'1'),(447,90,5,''),(448,91,1,'888888'),(449,91,2,'888888'),(450,91,3,'888888'),(451,91,4,'$2a$10$DEWwtwp/YAh0KZSWFBjL6eRRYJSVNcNF1XJ4HOILF2lFifZV.CcHW'),(452,91,22,'888@mail.ru'),(453,91,24,'USER'),(454,91,23,'1'),(455,91,5,''),(456,92,1,'999999'),(457,92,2,'999999'),(458,92,3,'999999'),(459,92,4,'$2a$10$xXRaptHfpMisV8637pq/HOsXdHHCLGois.T/yDc9NtOjeo9TdhpGS'),(460,92,22,'999@mail.ru'),(461,92,24,'USER'),(462,92,23,'1'),(463,92,5,''),(464,93,1,'000000'),(465,93,2,'000000'),(466,93,3,'000000'),(467,93,4,'$2a$10$nKQnK3X4wyoRnh/6gUe9Mup9yLRpykR/UjYaVEEaEYjIlAplx/QWi'),(468,93,22,'000@mail.ru'),(469,93,24,'USER'),(470,93,23,'1'),(471,93,5,''),(472,94,1,'aaaaaa'),(473,94,2,'aaaaaa'),(474,94,3,'aaaaaa'),(475,94,4,'$2a$10$iXF.IkWiSxsf8HHjUAzb8eimXJLgngXM/x9ANphvFVIwmqNE24H.6'),(476,94,22,'aaa@mail.ru'),(477,94,24,'USER'),(478,94,23,'1'),(479,94,5,''),(480,95,1,'bbbbbb'),(481,95,2,'bbbbbb'),(482,95,3,'bbbbbb'),(483,95,4,'$2a$10$Tnm40lcCsIHSZlrfqD0nWO113Yhq5Kr7WkPtjT9ZpSuVvb31xlWFu'),(484,95,22,'bbb@mail.ru'),(485,95,24,'USER'),(486,95,23,'1'),(487,95,5,''),(488,96,1,'cccccc'),(489,96,2,'cccccc'),(490,96,3,'cccccc'),(491,96,4,'$2a$10$5.RCKjDxE8mzsMsQdSrHSO7LWArBlM9XQw83aUZBIHTVMY8E8eaJa'),(492,96,22,'cccc@mail.ru'),(493,96,24,'USER'),(494,96,23,'1'),(495,96,5,''),(496,97,1,'dddddd'),(497,97,2,'dddddd'),(498,97,3,'dddddd'),(499,97,4,'$2a$10$e1BeZp41uAwi5iLN.xycqO7pKKd9nuv0aNC7rTD6pvIs6BupB3AKi'),(500,97,22,'ddd@mail.ru'),(501,97,24,'USER'),(502,97,23,'1'),(503,97,5,''),(504,98,1,'eeeeee'),(505,98,2,'eeeeee'),(506,98,3,'eeeeee'),(507,98,4,'$2a$10$zP6M1wFWJ0lFebLHZyHh1etaZGAswP8W40DURdt26MmsOdMqU5DDS'),(508,98,22,'eee@mail.ru'),(509,98,24,'USER'),(510,98,23,'1'),(511,98,5,''),(512,99,31,'2'),(513,99,32,'76'),(514,99,33,''),(515,99,34,'pending'),(516,99,35,'2017-04-25 12:10'),(517,99,36,'1');
/*!40000 ALTER TABLE `value` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-29 15:08:31
