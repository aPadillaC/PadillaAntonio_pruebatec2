-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: gestionturnos
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ciudadano`
--

DROP TABLE IF EXISTS `ciudadano`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudadano` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `DNI` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudadano`
--

LOCK TABLES `ciudadano` WRITE;
/*!40000 ALTER TABLE `ciudadano` DISABLE KEYS */;
INSERT INTO `ciudadano` VALUES (1,'76429129Z'),(2,'04313987S'),(3,'24815203C'),(4,'74810687J'),(5,'74873130B'),(6,'25699839F'),(7,'44582457Q'),(8,'74872063W'),(9,'24705380E'),(10,'42899878W');
/*!40000 ALTER TABLE `ciudadano` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tramite`
--

DROP TABLE IF EXISTS `tramite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tramite` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tramite`
--

LOCK TABLES `tramite` WRITE;
/*!40000 ALTER TABLE `tramite` DISABLE KEYS */;
INSERT INTO `tramite` VALUES (1,'Multas'),(2,'Vehiculos'),(3,'Permiso Conducir'),(4,'Otros');
/*!40000 ALTER TABLE `tramite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turno`
--

DROP TABLE IF EXISTS `turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turno` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `BORRADO` tinyint(1) DEFAULT '0',
  `ESTADOCOMPLETADO` tinyint(1) DEFAULT '0',
  `FECHA` date DEFAULT NULL,
  `NUMERO` bigint DEFAULT NULL,
  `ciudadano_id` bigint DEFAULT NULL,
  `TRAMITE_ID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_TURNO_ciudadano_id` (`ciudadano_id`),
  KEY `FK_TURNO_TRAMITE_ID` (`TRAMITE_ID`),
  CONSTRAINT `FK_TURNO_ciudadano_id` FOREIGN KEY (`ciudadano_id`) REFERENCES `ciudadano` (`ID`),
  CONSTRAINT `FK_TURNO_TRAMITE_ID` FOREIGN KEY (`TRAMITE_ID`) REFERENCES `tramite` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turno`
--

LOCK TABLES `turno` WRITE;
/*!40000 ALTER TABLE `turno` DISABLE KEYS */;
INSERT INTO `turno` VALUES (1,0,1,'2024-03-21',NULL,4,3),(2,0,1,'2024-03-21',NULL,1,3),(3,1,0,'2024-03-21',NULL,5,3),(4,0,1,'2024-03-21',NULL,1,4),(5,0,1,'2024-03-21',NULL,10,4),(6,0,1,'2024-03-22',NULL,1,4),(7,0,1,'2024-03-22',NULL,9,3),(8,1,0,'2024-03-22',NULL,1,1),(9,0,1,'2024-03-22',NULL,8,1),(10,0,1,'2024-03-25',NULL,2,2),(11,0,1,'2024-03-25',NULL,5,2),(12,0,1,'2024-03-25',NULL,5,4),(13,0,1,'2024-03-25',NULL,6,1),(14,0,1,'2024-03-25',NULL,6,3),(15,0,0,'2024-03-25',NULL,9,4),(16,0,1,'2024-03-26',NULL,10,4),(17,0,1,'2024-03-26',NULL,10,1),(18,0,1,'2024-03-26',NULL,4,2),(19,0,1,'2024-03-26',NULL,2,2),(20,0,1,'2024-03-26',NULL,4,3),(21,0,0,'2024-03-26',NULL,1,2),(22,0,1,'2024-03-27',NULL,1,4),(23,0,0,'2024-03-27',NULL,5,4),(24,0,0,'2024-03-27',NULL,6,4),(25,0,0,'2024-03-27',NULL,9,3),(26,0,0,'2024-03-27',NULL,1,4),(27,0,0,'2024-03-27',NULL,5,2),(28,0,0,'2024-03-27',NULL,5,3),(29,0,0,'2024-03-27',NULL,8,1),(30,0,0,'2024-03-27',NULL,10,4),(46,0,0,'2024-03-27',NULL,10,4),(47,0,0,'2024-03-27',NULL,8,3),(48,1,0,'2024-03-27',NULL,8,4);
/*!40000 ALTER TABLE `turno` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-27 15:04:13
