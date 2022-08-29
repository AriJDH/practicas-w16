CREATE DATABASE  IF NOT EXISTS `empresa_internet` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `empresa_internet`;
-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: localhost    Database: empresa_internet
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `Cliente`
--

DROP TABLE IF EXISTS `Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Cliente` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(30) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `fecha_nacimiento` datetime NOT NULL,
  `Plan_idPlan` int NOT NULL,
  `Ciudad_idCiudad` int NOT NULL,
  PRIMARY KEY (`idCliente`,`Plan_idPlan`,`Ciudad_idCiudad`),
  KEY `fk_Cliente_Plan1_idx` (`Plan_idPlan`),
  KEY `fk_Cliente_Ciudad1_idx` (`Ciudad_idCiudad`),
  CONSTRAINT `fk_Cliente_Ciudad1` FOREIGN KEY (`Ciudad_idCiudad`) REFERENCES `Ciudad` (`idCiudad`),
  CONSTRAINT `fk_Cliente_Plan1` FOREIGN KEY (`Plan_idPlan`) REFERENCES `Plan` (`idPlan`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cliente`
--

LOCK TABLES `Cliente` WRITE;
/*!40000 ALTER TABLE `Cliente` DISABLE KEYS */;
INSERT INTO `Cliente` VALUES (1,'123','Gabriel','1996-09-18 00:00:00',1,2),(2,'123','Ruth','1995-11-02 00:00:00',2,1),(3,'123','Pamela','1990-10-23 00:00:00',3,1),(4,'123','Gonzalo','1990-10-23 00:00:00',5,2),(5,'123','Nahuel','1995-10-23 00:00:00',3,2),(6,'123','Alejandro','1997-10-21 00:00:00',1,3),(7,'123','Esteban','1997-10-27 00:00:00',4,2),(8,'123','Claudio','1998-10-25 00:00:00',5,3),(9,'123','Erika','1992-10-20 00:00:00',2,2),(10,'123','Felipe','1994-10-20 00:00:00',1,3);
/*!40000 ALTER TABLE `Cliente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-24 13:54:21
