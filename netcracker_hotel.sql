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
INSERT INTO `attribute` VALUES (1,1,'first_name','varchar'),(2,1,'last_name','varchar'),(3,1,'username','varchar'),(4,1,'password','varchar'),(5,1,'avatar','varchar'),(6,2,'country','varchar'),(7,2,'city','varchar'),(8,2,'address','varchar'),(9,2,'class','int'),(10,3,'cost','int'),(11,3,'capacity','int'),(12,3,'hotel_id','int'),(13,4,'user_id','int'),(14,4,'pay_value','int'),(15,4,'is_paid','int'),(16,5,'room_id','int'),(17,5,'user_id','int'),(18,5,'arrival_date','date'),(19,5,'leave_date','date'),(20,6,'idhotel','int'),(21,6,'photo','varchar'),(22,1,'email','varchar'),(23,1,'enabled','boolean'),(24,1,'authority','varchar'),(25,2,'hotel_name','varchar'),(26,2,'hotel_description','varchar'),(27,7,'token_user_id','int'),(28,7,'token','varchar'),(29,7,'token_date','date'),(31,8,'iduser','int'),(32,8,'hotelid','int'),(33,8,'feedback','varchar'),(34,8,'status','varchar'),(35,8,'time','date'),(36,8,'star','int');
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
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entity`
--

LOCK TABLES `entity` WRITE;
/*!40000 ALTER TABLE `entity` DISABLE KEYS */;
INSERT INTO `entity` VALUES (1,1),(2,1),(52,2),(53,6),(54,2),(55,2),(56,6),(57,6),(58,2),(59,6),(61,2),(62,6),(63,2),(64,6),(65,2),(66,6),(67,2),(68,6),(69,2),(70,2),(71,2),(72,6),(73,2),(74,6),(75,2),(76,2),(77,6),(78,2),(79,6),(81,2),(82,6),(83,1);
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
INSERT INTO `type` VALUES (1,'user'),(2,'hotel'),(3,'room'),(4,'order'),(5,'time_table'),(6,'photos'),(7,'verification_token'),(8,'review');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=418 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `value`
--

LOCK TABLES `value` WRITE;
/*!40000 ALTER TABLE `value` DISABLE KEYS */;
INSERT INTO `value` VALUES (1,1,1,'roma'),(2,1,2,'rodevich'),(3,1,3,'admin'),(4,1,4,'$2a$11$Z30CWyK5OxD9VqknNWaSfu79V/K.7AJTEhOkJOGoyEnUfZHQH8GK2'),(5,1,22,'admin@gmail.com'),(7,1,24,'ADMIN'),(8,1,23,'1'),(9,1,30,''),(10,2,1,'firstn'),(11,2,2,'lastname'),(12,2,3,'user'),(13,2,4,'$2a$10$PaTYSdJZUkjlMwXQU66Hdef8D7tY2nXhqvcCU3JvYido7CFRloH6m'),(14,2,22,'user@gmail.com'),(15,2,24,'USER'),(16,2,23,'1'),(17,2,30,''),(272,52,6,'Zanzibar'),(273,52,7,'Pemba Island'),(274,52,8,'Psv-zanzibar estate'),(275,52,9,'5'),(276,52,25,'Manta Resort'),(277,52,26,'Underwater Rooms, spa treatment, scuba diving'),(278,53,20,'52'),(279,53,21,'53'),(280,55,6,'Finland'),(281,55,7,'Levi'),(282,55,8,'Harjatie 4'),(283,55,9,'4'),(284,55,25,'Golden Crown Levin Iglut'),(285,55,26,'Fully insulated and heated glass igloos'),(286,56,6,'Finland'),(287,56,7,'Levi'),(288,56,8,'Harjatie 4'),(289,56,9,'4'),(290,56,25,'Golden Crown Levin Iglut'),(291,56,26,'Fully insulated and heated glass igloos'),(292,56,20,'54'),(293,56,21,'56'),(294,57,20,'55'),(295,57,21,'57'),(296,58,6,'Japan'),(297,58,7,'Tokyo Prefecture'),(298,58,8,'Toshima-ku Ikebukuro 1-17-7 Lumiere Buld. 7F'),(299,58,9,'2'),(300,58,25,'Book And Bed Tokyo'),(301,58,26,'A haven for bibliophilen'),(302,59,20,'58'),(303,59,21,'59'),(310,61,6,'Costa Rica'),(311,61,7,'Provincia de Puntarenas'),(312,61,8,'Playas de Manuel Antonio,  Km 5, Costa Rica., Manuel Antonio'),(313,61,9,'3'),(314,61,25,'Hotel Costa Verde'),(315,61,26,'Guests can sleep in an upcycled 1965 Boeing 727'),(316,62,20,'61'),(317,62,21,'62'),(326,65,6,'Bolivia'),(327,65,7,'Colchani'),(328,65,8,'Orillas Salar de Uyuni'),(329,65,9,'3'),(330,65,25,'Hotel Palacio de Sal'),(331,65,26,'Luxury hotel in the middle of the Bolivian desert'),(332,66,20,'65'),(333,66,21,'66'),(334,67,6,'Peru'),(335,67,7,'Yucuruche'),(336,67,8,'Via Yarapa 123'),(337,67,9,'5'),(338,67,25,'Treehouse Lodge'),(339,67,26,'Featuring bungalows located at the top of trees'),(340,68,20,'67'),(341,68,21,'68'),(354,71,6,'Spain'),(355,71,7,'Elciego'),(356,71,8,'Torrea, 1'),(357,71,9,'5'),(358,71,25,'MarquÃ©s de Riscal, a Luxury Collection'),(359,71,26,'The hotel is architect Frank Gehry\'s first hotel project'),(360,72,20,'71'),(361,72,21,'72'),(362,73,6,'Belarus'),(363,73,7,'Minsk'),(364,73,8,'Prospect Pobediteley 59, Tsentralny District'),(365,73,9,'4'),(366,73,25,'Victoria & SPA Hotel Minsk'),(367,73,26,'Offering a restaurant, free sauna and indoor pool'),(368,74,20,'73'),(369,74,21,'74'),(376,76,6,'Belarus'),(377,76,7,'Minsk'),(378,76,8,'Kirova Street 18, Leninsky District'),(379,76,9,'5'),(380,76,25,'President Hotel'),(381,76,26,'Fitness centre, an indoor pool and Wi-Fi are available'),(382,77,20,'76'),(383,77,21,'77'),(384,78,6,'Belarus'),(385,78,7,'Brest'),(386,78,8,'Tyukhinichskaya Street 1'),(387,78,9,'4'),(388,78,25,'Rynkauka Tourist Complex'),(389,78,26,'A private sandy beach and free rental bikes'),(390,79,20,'78'),(391,79,21,'79');
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

-- Dump completed on 2017-04-19 22:07:14
