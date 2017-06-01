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
INSERT INTO `attribute` VALUES (1,1,'first_name','varchar'),(2,1,'last_name','varchar'),(3,1,'username','varchar'),(4,1,'password','varchar'),(5,1,'avatar','varchar'),(6,2,'country','varchar'),(7,2,'city','varchar'),(8,2,'address','varchar'),(9,2,'class','int'),(10,3,'cost','int'),(11,3,'capacity','int'),(12,3,'hotel_id','int'),(13,4,'user_id','int'),(14,4,'pay_value','int'),(15,4,'is_paid','int'),(16,4,'room_id','int'),(18,4,'arrival_date','date'),(19,4,'leave_date','date'),(21,2,'photo','varchar'),(22,1,'email','varchar'),(23,1,'enabled','boolean'),(24,1,'authority','varchar'),(25,2,'hotel_name','varchar'),(26,2,'hotel_description','varchar'),(27,7,'token_user_id','int'),(28,7,'token','varchar'),(29,7,'token_date','date'),(31,8,'userid','int'),(32,8,'hotelid','int'),(33,8,'feedback','varchar'),(34,8,'status','varchar'),(35,8,'time','date'),(36,8,'star','int'),(37,2,'main_photo','varchar'),(38,8,'rev_username','varchar'),(39,4,'firstname','varchar'),(40,4,'lastname','varchar'),(41,4,'ord_user','varchar'),(42,4,'ord_hotel','varchar'),(43,8,'rev_hotel','varchar'),(44,2,'hotel_enabled','boolean');
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
) ENGINE=InnoDB AUTO_INCREMENT=251 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entity`
--

LOCK TABLES `entity` WRITE;
/*!40000 ALTER TABLE `entity` DISABLE KEYS */;
INSERT INTO `entity` VALUES (1,1),(2,1),(52,2),(54,2),(55,2),(58,2),(61,2),(63,2),(65,2),(67,2),(69,2),(70,2),(71,2),(73,2),(75,2),(76,2),(78,2),(81,2),(83,1),(101,2),(102,3),(103,3),(104,3),(105,3),(106,3),(107,3),(108,3),(109,3),(110,3),(111,3),(112,3),(113,3),(114,3),(115,3),(116,3),(117,3),(118,3),(119,3),(120,3),(121,3),(122,3),(123,3),(124,3),(125,3),(126,3),(127,3),(128,3),(129,3),(130,3),(131,3),(132,3),(133,3),(134,3),(135,3),(136,3),(137,3),(138,3),(139,3),(140,3),(141,3),(142,3),(143,3),(152,8),(153,8),(178,1),(180,1),(181,1),(182,1),(183,1),(184,1),(185,1),(186,1),(187,1),(188,1),(189,1),(190,1),(191,1),(192,1),(193,1),(194,1),(195,1),(196,1),(197,1),(198,1),(199,1),(200,1),(201,1),(202,1),(203,8),(204,8),(205,8),(206,4),(207,4),(208,8),(209,8),(210,1),(211,1),(212,1),(213,1),(214,1),(215,1),(216,1),(217,1),(218,1),(219,1),(220,1),(221,1),(222,1),(223,1),(224,1),(225,1),(226,1),(227,1),(228,1),(229,1),(230,1),(231,1),(232,1),(233,1),(234,1),(235,1),(236,1),(237,1),(238,8),(239,4),(240,8),(241,4),(242,4),(243,4),(244,4),(245,4),(246,8),(247,4),(248,8),(249,4),(250,4);
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
INSERT INTO `type` VALUES (1,'user'),(2,'hotel'),(3,'room'),(4,'order'),(6,'photos'),(7,'verification_token'),(8,'review');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserConnection`
--

DROP TABLE IF EXISTS `UserConnection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserConnection` (
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
-- Dumping data for table `UserConnection`
--

LOCK TABLES `UserConnection` WRITE;
/*!40000 ALTER TABLE `UserConnection` DISABLE KEYS */;
/*!40000 ALTER TABLE `UserConnection` ENABLE KEYS */;
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
  `attribute_value` varchar(100) NOT NULL,
  PRIMARY KEY (`value_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1605 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `value`
--

LOCK TABLES `value` WRITE;
/*!40000 ALTER TABLE `value` DISABLE KEYS */;
INSERT INTO `value` VALUES (1,1,1,'roma'),(2,1,2,'rodevich'),(3,1,3,'admin'),(4,1,4,'$2a$11$Z30CWyK5OxD9VqknNWaSfu79V/K.7AJTEhOkJOGoyEnUfZHQH8GK2'),(5,1,22,'admin@gmail.com'),(7,1,24,'ADMIN'),(8,1,23,'1'),(9,1,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/1494874930327.jpg'),(10,2,1,'firstname'),(11,2,2,'lastname'),(12,2,3,'user'),(13,2,4,'$2a$10$PaTYSdJZUkjlMwXQU66Hdef8D7tY2nXhqvcCU3JvYido7CFRloH6m'),(14,2,22,'user@gmail.com'),(15,2,24,'USER'),(16,2,23,'1'),(17,2,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/1494875336248.jpg'),(272,52,6,'Zanzibar'),(273,52,7,'Pemba Island'),(274,52,8,'Psv-zanzibar estate'),(275,52,9,'5'),(276,52,25,'Manta Resort'),(277,52,26,'Underwater Rooms, spa treatment, scuba diving'),(280,55,6,'Finland'),(281,55,7,'Levi'),(282,55,8,'Harjatie 4'),(283,55,9,'4'),(284,55,25,'Golden Crown Levin Iglut'),(285,55,26,'Fully insulated and heated glass igloos'),(295,55,37,'57'),(296,58,6,'Japan'),(297,58,7,'Tokyo Prefecture'),(298,58,8,'Toshima-ku Ikebukuro 1-17-7 Lumiere Buld. 7F'),(299,58,9,'2'),(300,58,25,'Book And Bed Tokyo'),(301,58,26,'A haven for bibliophilen'),(303,58,37,'59'),(310,61,6,'Costa Rica'),(311,61,7,'Provincia de Puntarenas'),(312,61,8,'Playas de Manuel Antonio,  Km 5, Costa Rica., Manuel Antonio'),(313,61,9,'3'),(314,61,25,'Hotel Costa Verde'),(315,61,26,'Guests can sleep in an upcycled 1965 Boeing 727'),(317,61,37,'62'),(326,65,6,'Bolivia'),(327,65,7,'Colchani'),(328,65,8,'Orillas Salar de Uyuni'),(329,65,9,'3'),(330,65,25,'Hotel Palacio de Sal'),(331,65,26,'Luxury hotel in the middle of the Bolivian desert'),(333,65,37,'66'),(334,67,6,'Peru'),(335,67,7,'Yucuruche'),(336,67,8,'Via Yarapa 123'),(337,67,9,'5'),(338,67,25,'Treehouse Lodge'),(339,67,26,'Featuring bungalows located at the top of trees'),(341,67,37,'68'),(354,71,6,'Spain'),(355,71,7,'Elciego'),(356,71,8,'Torrea, 1'),(357,71,9,'5'),(358,71,25,'MarquÃ©s de Riscal, a Luxury Collection'),(359,71,26,'The hotel is architect Frank Gehry\'s first hotel project'),(361,71,37,'72'),(362,73,6,'Belarus'),(363,73,7,'Minsk'),(364,73,8,'Prospect Pobediteley 59, Tsentralny District'),(365,73,9,'4'),(366,73,25,'Victoria & SPA Hotel Minsk'),(367,73,26,'Offering a restaurant, free sauna and indoor pool'),(369,73,37,'74'),(376,76,6,'Belarus'),(377,76,7,'Minsk'),(378,76,8,'Kirova Street 18, Leninsky District'),(379,76,9,'5'),(380,76,25,'President Hotel'),(381,76,26,'Fitness centre, an indoor pool and Wi-Fi are available'),(383,76,37,'77'),(384,78,6,'Belarus'),(385,78,7,'Brest'),(386,78,8,'Tyukhinichskaya Street 1'),(387,78,9,'4'),(388,78,25,'Rynkauka Tourist Complex'),(389,78,26,'A private sandy beach and free rental bikes'),(391,78,37,'79'),(398,52,37,'53'),(525,101,6,'belarus'),(526,101,7,'minsk'),(527,101,8,'qwertgy'),(528,101,9,'4'),(529,101,25,'hotelTemp'),(530,101,26,'description'),(531,101,37,'BTTELV'),(532,102,11,'2'),(533,102,10,'500'),(534,102,12,'101'),(535,103,11,'3'),(536,103,10,'1000'),(537,103,12,'101'),(538,104,11,'4'),(539,104,10,'2000'),(540,104,12,'101'),(541,105,11,'2'),(542,105,10,'100'),(543,105,12,'52'),(544,106,11,'2'),(545,106,10,'200'),(546,106,12,'52'),(547,107,11,'3'),(548,107,10,'500'),(549,107,12,'52'),(550,108,11,'4'),(551,108,10,'600'),(552,108,12,'52'),(553,109,11,'1'),(554,109,10,'300'),(555,109,12,'55'),(556,110,11,'2'),(557,110,10,'500'),(558,110,12,'55'),(559,111,11,'3'),(560,111,10,'700'),(561,111,12,'55'),(562,112,11,'3'),(563,112,10,'1000'),(564,112,12,'55'),(565,113,11,'2'),(566,113,10,'500'),(567,113,12,'58'),(568,114,11,'2'),(569,114,10,'800'),(570,114,12,'58'),(571,115,11,'1'),(572,115,10,'300'),(573,115,12,'58'),(574,116,11,'1'),(575,116,10,'200'),(576,116,12,'61'),(577,117,11,'2'),(578,117,10,'400'),(579,117,12,'61'),(580,118,11,'3'),(581,118,10,'500'),(582,118,12,'61'),(583,119,11,'3'),(584,119,10,'600'),(585,119,12,'61'),(586,120,11,'3'),(587,120,10,'800'),(588,120,12,'61'),(589,121,11,'1'),(590,121,10,'100'),(591,121,12,'65'),(592,122,11,'2'),(593,122,10,'200'),(594,122,12,'65'),(595,123,11,'2'),(596,123,10,'300'),(597,123,12,'65'),(598,124,11,'3'),(599,124,10,'400'),(600,124,12,'65'),(601,125,11,'1'),(602,125,10,'50'),(603,125,12,'67'),(604,126,11,'2'),(605,126,10,'100'),(606,126,12,'67'),(607,127,11,'4'),(608,127,10,'200'),(609,127,12,'67'),(610,128,11,'1'),(611,128,10,'100'),(612,128,12,'71'),(613,129,11,'2'),(614,129,10,'150'),(615,129,12,'71'),(616,130,11,'3'),(617,130,10,'200'),(618,130,12,'71'),(619,131,11,'4'),(620,131,10,'300'),(621,131,12,'71'),(622,132,11,'1'),(623,132,10,'100'),(624,132,12,'73'),(625,133,11,'2'),(626,133,10,'200'),(627,133,12,'73'),(628,134,11,'3'),(629,134,10,'300'),(630,134,12,'73'),(631,135,11,'4'),(632,135,10,'400'),(633,135,12,'73'),(634,136,11,'1'),(635,136,10,'100'),(636,136,12,'76'),(637,137,11,'2'),(638,137,10,'200'),(639,137,12,'76'),(640,138,11,'3'),(641,138,10,'250'),(642,138,12,'76'),(643,139,11,'3'),(644,139,10,'400'),(645,139,12,'76'),(646,140,11,'4'),(647,140,10,'450'),(648,140,12,'76'),(649,141,11,'1'),(650,141,10,'50'),(651,141,12,'78'),(652,142,11,'2'),(653,142,10,'100'),(654,142,12,'78'),(655,143,11,'3'),(656,143,10,'150'),(657,143,12,'78'),(731,152,31,'2'),(732,152,38,'user'),(733,152,32,'67'),(734,152,43,'Treehouse Lodge'),(735,152,33,'qqqqqqeewewewe'),(736,152,34,'blocked'),(737,152,35,'2017-05-06 11:03'),(738,152,36,'7'),(739,153,31,'2'),(740,153,38,'user'),(741,153,32,'58'),(742,153,43,'Book And Bed Tokyo'),(743,153,33,'normalno voobshe'),(744,153,34,'approved'),(745,153,35,'2017-05-06 11:25'),(746,153,36,'4'),(747,52,44,'1'),(748,55,44,'1'),(749,58,44,'1'),(750,61,44,'1'),(751,65,44,'1'),(752,67,44,'1'),(753,71,44,'1'),(754,73,44,'1'),(755,76,44,'1'),(756,78,44,'1'),(757,101,44,'0'),(940,178,1,'kadabra'),(941,178,2,'kadabra'),(942,178,3,'kadabra'),(943,178,4,'$2a$10$.jg/HcVqnWyIXXsGw5JZ3e4vuEWze4sWPGXK5ucDZn01UTF1CTDEu'),(944,178,22,'kadabra@mail.ru'),(945,178,24,'USER'),(946,178,23,'1'),(947,178,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(958,180,1,'karamba'),(959,180,2,'karamba'),(960,180,3,'karamba'),(961,180,4,'$2a$10$m48IBabyF2lluqqnId5Lkef9MCYfE9GLnDJI3dStza6sMDVdERtgO'),(962,180,22,'karamba@mail.ru'),(963,180,24,'USER'),(964,180,23,'1'),(965,180,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(966,181,1,'boltun'),(967,181,2,'boltun'),(968,181,3,'boltun'),(969,181,4,'$2a$10$wC3JdrwH7p5lx.c5n3164.sBHeZ9odkopzghCjI.Z.NiSdIB8wIHm'),(970,181,22,'boltun@mail.ru'),(971,181,24,'USER'),(972,181,23,'0'),(973,181,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(974,182,1,'mulchun'),(975,182,2,'mulchun'),(976,182,3,'mulchun'),(977,182,4,'$2a$10$/OF.i4JCz9e8qI02SWVZF.l0mE7UX3kbENUYr2nc4PRWgu521Hpeu'),(978,182,22,'mulchun@mail.ru'),(979,182,24,'BLOCKED'),(980,182,23,'0'),(981,182,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(982,183,1,'balbes'),(983,183,2,'balbes'),(984,183,3,'balbes'),(985,183,4,'$2a$10$bhmcfIhPjObFvz3izh1SpuJk55jj5L/sDhvWxEYE2.3JV2lL6mHwG'),(986,183,22,'balbes@mail.ru'),(987,183,24,'USER'),(988,183,23,'0'),(989,183,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(990,184,1,'karandash'),(991,184,2,'karandash'),(992,184,3,'karandash'),(993,184,4,'$2a$10$h.r7O820sN3gZ9b4G9rYx.D8MfJ3loKNpSIiX18rxbgcmgA4jOjwW'),(994,184,22,'karandash@mail.ru'),(995,184,24,'USER'),(996,184,23,'1'),(997,184,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(998,185,1,'korovkin'),(999,185,2,'korovkin'),(1000,185,3,'korovkin'),(1001,185,4,'$2a$10$4/R87ktsyPDePWFQQazoiuhofe6SiZI08bMfZwrIyy7Wec4Ptzeq2'),(1002,185,22,'korovkin@mail.ru'),(1003,185,24,'BLOCKED'),(1004,185,23,'1'),(1005,185,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1006,186,1,'voronov'),(1007,186,2,'voronov'),(1008,186,3,'voronov'),(1009,186,4,'$2a$10$1BOqlOtUl1BKGyG3HhP14.Gn3Thqmdpu.vx2XDdnfb/0wqB.VJ5RW'),(1010,186,22,'voronov@mail.ru'),(1011,186,24,'USER'),(1012,186,23,'1'),(1013,186,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1014,187,1,'fantikov'),(1015,187,2,'fantikov'),(1016,187,3,'fantikov'),(1017,187,4,'$2a$10$Mv6YY16HXDl1W9q/W61FyOpFCSLmneZ/ZckgpM2DqBEat42W0Kbc2'),(1018,187,22,'fantikov@mail.ru'),(1019,187,24,'USER'),(1020,187,23,'0'),(1021,187,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1022,188,1,'loshadkin'),(1023,188,2,'loshadkin'),(1024,188,3,'loshadkin'),(1025,188,4,'$2a$10$4iq.DN8uRk7y9ApqjoK2Cu6oahrZu5jif/rdmzruc64bzCKlh2iq6'),(1026,188,22,'loshadkin@mail.ru'),(1027,188,24,'USER'),(1028,188,23,'0'),(1029,188,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1030,189,1,'Albert'),(1031,189,2,'Einstein'),(1032,189,3,'albert'),(1033,189,4,'$2a$10$FW41GbLXADBkOP7CrbPiLuarHLaxQI7X/xT95wY3OI.yW3tKyYRJS'),(1034,189,22,'albert@mail.ru'),(1035,189,24,'USER'),(1036,189,23,'1'),(1037,189,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1038,190,1,'bolobolkin'),(1039,190,2,'bolobolkin'),(1040,190,3,'bolobolkin'),(1041,190,4,'$2a$10$YkugurXQZyH7K/qLuYgtWO5rHSCPh6v3I58p5C/dA9.vvlCyhG7TG'),(1042,190,22,'bolobolkin@mail.ru'),(1043,190,24,'USER'),(1044,190,23,'0'),(1045,190,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1046,191,1,'pereperdiaev'),(1047,191,2,'pereperdiaev'),(1048,191,3,'pereperdiaev'),(1049,191,4,'$2a$10$E6vhvgrNhcLlnhq7hYruZOLp4P3.YanD70fEjo3xp1dkrbFk49Qum'),(1050,191,22,'pereperdiaev@mail.ru'),(1051,191,24,'USER'),(1052,191,23,'1'),(1053,191,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1054,192,1,'kalashnikov'),(1055,192,2,'kalashnikov'),(1056,192,3,'kalashnikov'),(1057,192,4,'$2a$10$jx/FnK/de080NlxANK1kJOCX8yYxRTE9zHOto5BA8DHpOASLFzmfS'),(1058,192,22,'kalashnikov@mail.ru'),(1059,192,24,'USER'),(1060,192,23,'1'),(1061,192,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1062,193,1,'koshelot'),(1063,193,2,'koshelot'),(1064,193,3,'koshelot'),(1065,193,4,'$2a$10$yNIXjke0TcZKHe/BNlXL5.qB3vfTXrxDg7kLoUKXJQnXxWj.wmLOq'),(1066,193,22,'koshelot@mail.ru'),(1067,193,24,'USER'),(1068,193,23,'1'),(1069,193,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1070,194,1,'pirozkov'),(1071,194,2,'pirozkov'),(1072,194,3,'pirozkov'),(1073,194,4,'$2a$10$isxkONp4kf1DY6TZfdqY2ewPGH2QaRXYe1CIWKVY/XSBROSlftzeC'),(1074,194,22,'pirozkov@mail.ru'),(1075,194,24,'BLOCKED'),(1076,194,23,'1'),(1077,194,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1078,195,1,'zirinovskij'),(1079,195,2,'zirinovskij'),(1080,195,3,'zirinovskij'),(1081,195,4,'$2a$10$ziXHtwBZqXLoTmG2B51ZcOSPKPvyCp01B9tKfesEYLgEI1Lt6x256'),(1082,195,22,'zirinovskij@mail.ru'),(1083,195,24,'BLOCKED'),(1084,195,23,'1'),(1085,195,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1086,196,1,'pushkin'),(1087,196,2,'pushkin'),(1088,196,3,'pushkin'),(1089,196,4,'$2a$10$7GGNrL5Gg1cdx9Z5K7qYK.4viOa6Vob2i2hWdgj8epAcLbPzUg1sS'),(1090,196,22,'pushkin@mail.ru'),(1091,196,24,'ADMIN'),(1092,196,23,'1'),(1093,196,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1094,197,1,'lermontov'),(1095,197,2,'lermontov'),(1096,197,3,'lermontov'),(1097,197,4,'$2a$10$FpoVqAr0s/bTGKlPQ2GUSeN3q.YufWv45BcSVAl7fs7AOPWkEyxzi'),(1098,197,22,'lermontov@mail.ru'),(1099,197,24,'USER'),(1100,197,23,'1'),(1101,197,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1102,198,1,'turgenev'),(1103,198,2,'turgenev'),(1104,198,3,'turgenev'),(1105,198,4,'$2a$10$8uvh1C8yEOl1Vco2RtXF2OfkBRcfj7W08ZzLGqWzIPMBUT0gy9Msq'),(1106,198,22,'turgenev@mail.ru'),(1107,198,24,'USER'),(1108,198,23,'1'),(1109,198,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1110,199,1,'aleksandr'),(1111,199,2,'griboedov'),(1112,199,3,'griboedov'),(1113,199,4,'$2a$10$iuxBYPz25h0c5e4TtOkyDeDOn4g1w1nIP3GVM96CIP9m8srXwFJvy'),(1114,199,22,'griboedov@mail.ru'),(1115,199,24,'BLOCKED'),(1116,199,23,'0'),(1117,199,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1118,200,1,'barack'),(1119,200,2,'obama'),(1120,200,3,'barack'),(1121,200,4,'$2a$10$Nq24F5iDjJONB3p6Zh3CuuY0r434NRshrIchV0RWRP.DT3.zpTuR2'),(1122,200,22,'obama@mail.ru'),(1123,200,24,'USER'),(1124,200,23,'1'),(1125,200,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1126,201,1,'donald'),(1127,201,2,'trump'),(1128,201,3,'donald'),(1129,201,4,'$2a$10$ryRnbg.ojOMNnJYtiapVQ.9Kv1BPKDljBDbNn0c1DkbkABX9KTcqe'),(1130,201,22,'donald@mail.ru'),(1131,201,24,'USER'),(1132,201,23,'0'),(1133,201,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1134,202,1,'dmitrij'),(1135,202,2,'medvedev'),(1136,202,3,'medvedev'),(1137,202,4,'$2a$10$7ksmbEEVBaZ1mbXpgz718ueREh4Y/DS3XJhJNIGjladGI8vGP8Bru'),(1138,202,22,'medvedev@mail.ru'),(1139,202,24,'USER'),(1140,202,23,'0'),(1141,202,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1142,203,31,'2'),(1143,203,38,'user'),(1144,203,32,'76'),(1145,203,43,'President Hotel'),(1146,203,33,'super hotel, i like it'),(1147,203,34,'approved'),(1148,203,35,'2017-05-16 01:10'),(1149,203,36,'9'),(1150,204,31,'2'),(1151,204,38,'user'),(1152,204,32,'73'),(1153,204,43,'Victoria & SPA Hotel Minsk'),(1154,204,33,'pretty good, but not perfect'),(1155,204,34,'approved'),(1156,204,35,'2017-05-16 01:11'),(1157,204,36,'5'),(1158,205,31,'178'),(1159,205,38,'kadabra'),(1160,205,32,'76'),(1161,205,43,'President Hotel'),(1162,205,33,'nice hotel for me'),(1163,205,34,'approved'),(1164,205,35,'2017-05-16 01:13'),(1165,205,36,'8'),(1166,206,13,'178'),(1167,206,16,'126'),(1168,206,41,'kadabra'),(1169,206,42,'Treehouse Lodge'),(1170,206,18,'2017-06-06 00:00:00.0'),(1171,206,19,'2017-06-30 00:00:00.0'),(1172,206,14,'100'),(1173,206,15,'0'),(1174,206,39,'Kadabra'),(1175,206,40,'Kadabrovna'),(1176,207,13,'197'),(1177,207,16,'134'),(1178,207,41,'lermontov'),(1179,207,42,'Victoria & SPA Hotel Minsk'),(1180,207,18,'2017-05-17 00:00:00.0'),(1181,207,19,'2017-05-30 00:00:00.0'),(1182,207,14,'300'),(1183,207,15,'0'),(1184,207,39,'lermontov'),(1185,207,40,'lermontov'),(1186,208,31,'197'),(1187,208,38,'lermontov'),(1188,208,32,'73'),(1189,208,43,'Victoria & SPA Hotel Minsk'),(1190,208,33,'tak sebe hotel)'),(1191,208,34,'approved'),(1192,208,35,'2017-05-16 01:23'),(1193,208,36,'3'),(1194,209,31,'197'),(1195,209,38,'lermontov'),(1196,209,32,'76'),(1197,209,43,'President Hotel'),(1198,209,33,'perfetto! '),(1199,209,34,'approved'),(1200,209,35,'2017-05-16 01:24'),(1201,209,36,'10'),(1202,52,21,'IGMDOASYCDMCJMJNGX'),(1203,52,21,'IBMJ'),(1204,52,21,'DFZHPXFTYQDQUJOP'),(1205,55,21,'FPTJWYQIWXPGBNJOMJSVVFVZB'),(1206,55,21,'VRQDKZ'),(1207,55,21,'WNPN'),(1208,55,21,'MCILLUQFS'),(1209,58,21,'JTWVDAXMSEOPZIBIIQK'),(1210,58,21,'KWSSBLRRDTTKV'),(1211,58,21,'BRQYUKERREIDCPFBBPTKSCW'),(1212,58,21,'BGEMD'),(1213,61,21,'JAHDAENQGETQEVZIBWOGZ'),(1214,61,21,'KGXTUEQBRUJPJCBG'),(1215,61,21,'VHB'),(1216,61,21,'RRGMMSK'),(1217,65,21,'RKWPAVN'),(1218,65,21,'UIV'),(1219,65,21,'HURNBFZUROMICAPNRJV'),(1220,65,21,'OMUJXLTVMZSRLW'),(1221,65,21,'WYHIHMYSIFA'),(1222,67,21,'WILRJKFWZDLUKSMBULMRPIOWAU'),(1223,67,21,'GLAAPMICPHJTTSBPEGUHXVCHLAS'),(1224,67,21,'FIMQYN'),(1225,67,21,'WLY'),(1226,67,21,'GKLCJMDXWWEIGMRZQJEAGXE'),(1227,67,21,'OOVBIRACYIFERVRJIYUSOYNIFEIP'),(1228,71,21,'JIPAIZLUCRGV'),(1229,71,21,'LEVWHANGYVWIJR'),(1230,71,21,'VFFXERS'),(1231,71,21,'BLMVZ'),(1232,71,21,'OUNWVMF'),(1233,71,21,'PAOBEWWXLSTY'),(1234,71,21,'VTUHZDQYSVRBEB'),(1235,71,21,'RKTELDA'),(1236,73,21,'DAHOZPMQBXBXJIGFCILS'),(1237,73,21,'VNXL'),(1238,73,21,'KFPHNILMSTPWRFIPPZOZSPVCF'),(1239,73,21,'BRTXKV'),(1240,73,21,'YYYQZXIQLBIFBOGVARTYQ'),(1241,73,21,'RXNOO'),(1242,73,21,'WFZPWILRCSBAZIPMNXDOTWYYVK'),(1243,76,21,'KGRD'),(1244,76,21,'BTDUQKTAJJ'),(1245,76,21,'XCMXBFQDWM'),(1246,76,21,'LPKYYWNNEUPKWARLMSRKSCIW'),(1247,76,21,'SUCKDCCRPYQLZAYCHSPQTWMGEHEL'),(1248,76,21,'JMZKXWQ'),(1249,78,21,'RFKXCLSRGV'),(1251,78,21,'CHWIXQSEEZVEUSLGBOLOBNHMSLJ'),(1252,78,21,'QNLLHCUPNXXJXBJ'),(1253,78,21,'MNLARXZWSOJBMWQWJVCNTPI'),(1254,78,21,'HYVIEODZNAZKVQESZFGSGEFE'),(1255,78,21,'YLFZVGWYREQH'),(1256,101,21,'NVTNLJSUXHZKP'),(1257,101,21,'WEGH'),(1258,101,21,'UZBWTZZYJLVSHEFTU'),(1259,210,1,'solomon'),(1260,210,2,'solomon'),(1261,210,3,'solomon'),(1262,210,4,'$2a$10$7UdQSed3Mmf9HA5VrcJC1.U0DK.smwJWQ11TpQvrkF9Ep8YH./h8i'),(1263,210,22,'solomon@mail.ru'),(1264,210,24,'USER'),(1265,210,23,'1'),(1266,210,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1267,211,1,'foberje'),(1268,211,2,'foberje'),(1269,211,3,'foberje'),(1270,211,4,'$2a$10$A2u/1pPBAn0buvSJf2L3r.1885R.1d.sEXR5erXE7XPbXMjSKqsVi'),(1271,211,22,'foberje@mail.ru'),(1272,211,24,'USER'),(1273,211,23,'1'),(1274,211,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1275,212,1,'harlej'),(1276,212,2,'harlej'),(1277,212,3,'harlej'),(1278,212,4,'$2a$10$9An8DJl5nbR6fCNDvzEM4u.yGj7uhEsxxiDKAJzwi9ts9zoS1Ufvy'),(1279,212,22,'harlej@mail.ru'),(1280,212,24,'USER'),(1281,212,23,'1'),(1282,212,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1283,213,1,'papugaj'),(1284,213,2,'papugaj'),(1285,213,3,'papugaj'),(1286,213,4,'$2a$10$WmdFD5GHDvCMGmvbBvUdKuQB5pN5Rq/t2MwNBK5pZWpn2cXxM5gS6'),(1287,213,22,'papugaj@mail.ru'),(1288,213,24,'USER'),(1289,213,23,'1'),(1290,213,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1291,214,1,'korovin'),(1292,214,2,'korovin'),(1293,214,3,'korovin'),(1294,214,4,'$2a$10$yi4N/1s0dpK7SXa3U5tdeuLomGNqHMtdXEl90LzJS/O4gy42Dqgva'),(1295,214,22,'korovin@mail.ru'),(1296,214,24,'USER'),(1297,214,23,'1'),(1298,214,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1299,215,1,'azazello'),(1300,215,2,'azazello'),(1301,215,3,'azazello'),(1302,215,4,'$2a$10$42Pk9Lo3ZrZn1DDZW12Av.zAb7dRJypapykWOwVHbY0Etu7hZ8U.S'),(1303,215,22,'azazello@mail.ru'),(1304,215,24,'BLOCKED'),(1305,215,23,'1'),(1306,215,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1307,216,1,'voland'),(1308,216,2,'voland'),(1309,216,3,'voland'),(1310,216,4,'$2a$10$sgMaSiRit9GSBtWEJq7op.HghDj31u6zgDhkoTjTjR3RSSPsWmUZC'),(1311,216,22,'voland@mail.ru'),(1312,216,24,'USER'),(1313,216,23,'1'),(1314,216,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/RMF.jpg'),(1315,217,1,'begemot'),(1316,217,2,'begemot'),(1317,217,3,'begemot'),(1318,217,4,'$2a$10$wUwRnkIAEnwQ/31Yr9BQvu6mnzPyZilXSrVdH03kV.5gN0s2JgDOq'),(1319,217,22,'begemot@mail.ru'),(1320,217,24,'USER'),(1321,217,23,'1'),(1322,217,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1323,218,1,'berlioz'),(1324,218,2,'berlioz'),(1325,218,3,'berlioz'),(1326,218,4,'$2a$10$0khCL6b9Bt868UbrMYunf.5YFMsaqppfFTVQt748WPEPGd.0PNf4q'),(1327,218,22,'berlioz@mail.ru'),(1328,218,24,'BLOCKED'),(1329,218,23,'0'),(1330,218,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1331,219,1,'fantomas'),(1332,219,2,'fantomas'),(1333,219,3,'fantomas'),(1334,219,4,'$2a$10$Kqqlvj6c.jcXRdIQ6dSUoO/w1B2T66cDHXR4Hgj9BUEHDlDEvrdU2'),(1335,219,22,'fantomas@mail.ru'),(1336,219,24,'USER'),(1337,219,23,'1'),(1338,219,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1339,220,1,'viffagij'),(1340,220,2,'viffagij'),(1341,220,3,'viffagij'),(1342,220,4,'$2a$10$dTgxMcYQ2sQzXtPe2ja3WuUr74zUN7A7YXl9dsVL55ZrtCAB3GtvS'),(1343,220,22,'viffagij@mail.ru'),(1344,220,24,'USER'),(1345,220,23,'1'),(1346,220,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1347,221,1,'sobakin'),(1348,221,2,'sobakin'),(1349,221,3,'sobakin'),(1350,221,4,'$2a$10$.HLQTI/pEHhaJ./CRxOy2OkFTvOJnnXHRPbNcWhO3ZN9jecy7rYUe'),(1351,221,22,'sobakin@mail.ru'),(1352,221,24,'USER'),(1353,221,23,'1'),(1354,221,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1355,222,1,'dantes'),(1356,222,2,'dantes'),(1357,222,3,'dantes'),(1358,222,4,'$2a$10$SeiarCC/WXVxAvpnrg5SNufdO1m0fT0JTcRS8hwTxQSpt/nmZSVZG'),(1359,222,22,'dantes@mail.ru'),(1360,222,24,'ADMIN'),(1361,222,23,'1'),(1362,222,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1363,223,1,'danglar'),(1364,223,2,'danglar'),(1365,223,3,'danglar'),(1366,223,4,'$2a$10$VOMbgwJhyX77LxrqCIiCZO6XGYseU/iAYH5hXiOWCt54yQR9AI0O2'),(1367,223,22,'danglar@mail.ru'),(1368,223,24,'ADMIN'),(1369,223,23,'0'),(1370,223,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1371,224,1,'kadruss'),(1372,224,2,'kadruss'),(1373,224,3,'kadruss'),(1374,224,4,'$2a$10$lLXSaALOw3x4AWOfGYRs3.17vqNlGViIiqIu.CPbhC0lmAsRbW1ky'),(1375,224,22,'kadruss@mail.ru'),(1376,224,24,'USER'),(1377,224,23,'0'),(1378,224,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1379,225,1,'mersedes'),(1380,225,2,'mersedes'),(1381,225,3,'mersedes'),(1382,225,4,'$2a$10$md/tKpnbtVxOz9F3Ksn7qefgtIu6/xqGO.zvnin1wBwEGE9OOypwG'),(1383,225,22,'mersedes@mail.ru'),(1384,225,24,'USER'),(1385,225,23,'1'),(1386,225,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1387,226,1,'morrel'),(1388,226,2,'morrel'),(1389,226,3,'morrel'),(1390,226,4,'$2a$10$rSlXCBy2KfeWndwhL3VQ.eL6QbjuuC8WcM71F9HhaZ6BTjN7q.Diq'),(1391,226,22,'morrel@mail.ru'),(1392,226,24,'USER'),(1393,226,23,'0'),(1394,226,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1395,227,1,'karkonta'),(1396,227,2,'karkonta'),(1397,227,3,'karkonta'),(1398,227,4,'$2a$10$DgGGPhra3XPdArSrsil3L.z888oGgQjj8dFyRJo8o0YRPehhkm3zC'),(1399,227,22,'karkonta@mail.ru'),(1400,227,24,'USER'),(1401,227,23,'0'),(1402,227,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1403,228,1,'morser'),(1404,228,2,'morser'),(1405,228,3,'morser'),(1406,228,4,'$2a$10$6N7MQP/yHZ4O50iKaQlY3OKjub0JIcAKCS108jLvMFI0o0XRnAuFa'),(1407,228,22,'morser@mail.ru'),(1408,228,24,'USER'),(1409,228,23,'1'),(1410,228,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1411,229,1,'mondego'),(1412,229,2,'mondego'),(1413,229,3,'mondego'),(1414,229,4,'$2a$10$pI76j9XuEWSMA/E3ihMF.eBxFeSaf7ozB89Qw.h7lAw5SaxQr8PwW'),(1415,229,22,'mondego@mail.ru'),(1416,229,24,'USER'),(1417,229,23,'1'),(1418,229,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1419,230,1,'vilfor'),(1420,230,2,'vilfor'),(1421,230,3,'vilfor'),(1422,230,4,'$2a$10$gNzcyMMTKVRlsWT2K/BiXu41CG9eAR0VG6HMHGc0aIz.iTaK1PJnC'),(1423,230,22,'vilfor@mail.ru'),(1424,230,24,'USER'),(1425,230,23,'1'),(1426,230,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1427,231,1,'barrua'),(1428,231,2,'barrua'),(1429,231,3,'barrua'),(1430,231,4,'$2a$10$UAA0Er2OEpwAhvMJhvpExuxn6xHGfMnNObit3IjFScP/2d5Gh686y'),(1431,231,22,'barrua@mail.ru'),(1432,231,24,'USER'),(1433,231,23,'1'),(1434,231,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/MJPKLZMHUSA.jpg'),(1435,232,1,'bertuccho'),(1436,232,2,'bertuccho'),(1437,232,3,'bertuccho'),(1438,232,4,'$2a$10$t5NsDx2ysEJaCTSxRVP.K.6.wfNB.kN6lyhVvh4sGVpQOZwh3dKIC'),(1439,232,22,'bertuccho@mail.ru'),(1440,232,24,'USER'),(1441,232,23,'1'),(1442,232,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1443,233,1,'djacopo'),(1444,233,2,'djacopo'),(1445,233,3,'djacopo'),(1446,233,4,'$2a$10$Zukkp80UPVw6XYRFoq2bCOIGVRXzjtRFZi2rQGmZuEeMkkycHZES6'),(1447,233,22,'djacopo@mail.ru'),(1448,233,24,'USER'),(1449,233,23,'1'),(1450,233,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1451,234,1,'batisten'),(1452,234,2,'batisten'),(1453,234,3,'batisten'),(1454,234,4,'$2a$10$mDsIDiSwSVxEDBbKCvW6..AelLM8l8vFE1aWa65.R6rZboTbC/ykW'),(1455,234,22,'batisten@mail.ru'),(1456,234,24,'USER'),(1457,234,23,'1'),(1458,234,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1459,235,1,'peppino'),(1460,235,2,'peppino'),(1461,235,3,'peppino'),(1462,235,4,'$2a$10$JGznU9WheoX8zl9f5M7ZUe7f9PtMzICXeTlg3sJgawc3w5gkRTzKu'),(1463,235,22,'peppino@mail.ru'),(1464,235,24,'USER'),(1465,235,23,'1'),(1466,235,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1467,236,1,'monteki'),(1468,236,2,'monteki'),(1469,236,3,'monteki'),(1470,236,4,'$2a$10$FXVw7Yk3YY95H9mleYfYyOB62phBa2jgcE4Om28NYRNpHzIVpJI6S'),(1471,236,22,'monteki@mail.ru'),(1472,236,24,'USER'),(1473,236,23,'1'),(1474,236,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1475,237,1,'cappuletti'),(1476,237,2,'cappuletti'),(1477,237,3,'cappuletti'),(1478,237,4,'$2a$10$zTH9eYCphZEjx.zxvFS24.2bwGUBDAt7cQ6VGRvA9YMVLbZ4dgmB2'),(1479,237,22,'cappuletti@mail.ru'),(1480,237,24,'USER'),(1481,237,23,'1'),(1482,237,5,'http://res.cloudinary.com/netcrackerhotel/image/upload/v1494376267/defaultuserpic.jpg'),(1483,238,31,'231'),(1484,238,38,'barrua'),(1485,238,32,'55'),(1486,238,43,'Golden Crown Levin Iglut'),(1487,238,33,'Nice hotel, I like it all and will stay more times!'),(1488,238,34,'blocked'),(1489,238,35,'2017-05-28 00:06'),(1490,238,36,'9'),(1491,239,13,'231'),(1492,239,16,'111'),(1493,239,41,'barrua'),(1494,239,42,'Golden Crown Levin Iglut'),(1495,239,18,'2017-07-10 00:00:00.0'),(1496,239,19,'2017-07-15 00:00:00.0'),(1497,239,14,'700'),(1498,239,15,'0'),(1499,239,39,'barrua'),(1500,239,40,'babarrua'),(1501,240,31,'216'),(1502,240,38,'voland'),(1503,240,32,'76'),(1504,240,43,'President Hotel'),(1505,240,33,'I am so angry with this hotel. So expensive, so belorussian'),(1506,240,34,'approved'),(1507,240,35,'2017-05-28 00:18'),(1508,240,36,'8'),(1509,241,13,'216'),(1510,241,16,'136'),(1511,241,41,'voland'),(1512,241,42,'President Hotel'),(1513,241,18,'2017-08-08 00:00:00.0'),(1514,241,19,'2017-08-09 00:00:00.0'),(1515,241,14,'100'),(1516,241,15,'0'),(1517,241,39,'Voland'),(1518,241,40,'Volandovich'),(1519,242,13,'2'),(1520,242,16,'140'),(1521,242,41,'user'),(1522,242,42,'President Hotel'),(1523,242,18,'2017-07-03 00:00:00.0'),(1524,242,19,'2017-07-06 00:00:00.0'),(1525,242,14,'450'),(1526,242,15,'0'),(1527,242,39,'bambarbia'),(1528,242,40,'kergudu'),(1529,243,13,'2'),(1530,243,16,'106'),(1531,243,41,'user'),(1532,243,42,'Manta Resort'),(1533,243,18,'2017-08-09'),(1534,243,19,'2017-08-23'),(1535,243,14,'200'),(1536,243,15,'0'),(1537,243,39,'zbignev'),(1538,243,40,'brzezinski'),(1539,244,13,'2'),(1540,244,16,'125'),(1541,244,41,'user'),(1542,244,42,'Treehouse Lodge'),(1543,244,18,'2017-11-08 00:00:00.0'),(1544,244,19,'2017-11-14 00:00:00.0'),(1545,244,14,'50'),(1546,244,15,'0'),(1547,244,39,'maksim'),(1548,244,40,'potashev'),(1549,245,13,'2'),(1550,245,16,'109'),(1551,245,41,'user'),(1552,245,42,'Golden Crown Levin Iglut'),(1553,245,18,'2017-06-04 00:00:00.0'),(1554,245,19,'2017-07-31 00:00:00.0'),(1555,245,14,'300'),(1556,245,15,'0'),(1557,245,39,'Angela'),(1558,245,40,'Merkel'),(1559,246,31,'230'),(1560,246,38,'vilfor'),(1561,246,32,'52'),(1562,246,43,'Manta Resort'),(1563,246,33,'Incredibly good, nice, perfect!'),(1564,246,34,'approved'),(1565,246,35,'2017-05-28 00:34'),(1566,246,36,'10'),(1567,247,13,'230'),(1568,247,16,'107'),(1569,247,41,'vilfor'),(1570,247,42,'Manta Resort'),(1571,247,18,'2017-06-14 00:00:00.0'),(1572,247,19,'2017-06-15 00:00:00.0'),(1573,247,14,'500'),(1574,247,15,'0'),(1575,247,39,'vilfor'),(1576,247,40,'vilforovich'),(1577,248,31,'230'),(1578,248,38,'vilfor'),(1579,248,32,'58'),(1580,248,43,'Book And Bed Tokyo'),(1581,248,33,'I have never been in this hotel, so i don\'t know anything'),(1582,248,34,'approved'),(1583,248,35,'2017-05-28 00:35'),(1584,248,36,'5'),(1585,249,13,'1'),(1586,249,16,'127'),(1587,249,41,'admin'),(1588,249,42,'Treehouse Lodge'),(1589,249,18,'2017-06-08 00:00:00.0'),(1590,249,19,'2017-06-16 00:00:00.0'),(1591,249,14,'200'),(1592,249,15,'0'),(1593,249,39,'adminchik'),(1594,249,40,'adminovich'),(1595,250,13,'1'),(1596,250,16,'129'),(1597,250,41,'admin'),(1598,250,42,'MarquÃÂÃÂ©s de Riscal, a Luxury Collection'),(1599,250,18,'2017-06-06 00:00:00.0'),(1600,250,19,'2017-06-14 00:00:00.0'),(1601,250,14,'150'),(1602,250,15,'0'),(1603,250,39,'Vasiaa'),(1604,250,40,'Pupkin');
/*!40000 ALTER TABLE `value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `xx`
--

DROP TABLE IF EXISTS `xx`;
/*!50001 DROP VIEW IF EXISTS `xx`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `xx` AS SELECT 
 1 AS `entity_id`,
 1 AS `attribute_name`,
 1 AS `attribute_value`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `xx`
--

/*!50001 DROP VIEW IF EXISTS `xx`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `xx` AS (select `ooo`.`entity_id` AS `entity_id`,`attribute`.`attribute_name` AS `attribute_name`,`ooo`.`attribute_value` AS `attribute_value` from (`value` `ooo` join `attribute` on((`ooo`.`attribute_id` = `attribute`.`attribute_id`))) where `ooo`.`entity_id` in (select `entity`.`entity_id` from (`entity` join `type` on((`entity`.`type_id` = `type`.`type_id`))) where (`type`.`type_id` = '2')) order by `ooo`.`entity_id`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-01 15:23:15
