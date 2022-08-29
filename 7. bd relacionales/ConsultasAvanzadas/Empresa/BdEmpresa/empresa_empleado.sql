CREATE DATABASE  IF NOT EXISTS `empresa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `empresa`;
-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: empresa
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
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `cod_emp` varchar(10) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `puesto` varchar(50) DEFAULT NULL,
  `fecha_alta` date DEFAULT NULL,
  `salario` int DEFAULT NULL,
  `comision` int DEFAULT NULL,
  `depto_nro` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`cod_emp`),
  KEY `depto_nro` (`depto_nro`),
  CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`depto_nro`) REFERENCES `departamento` (`depto_nro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES ('1','Dill','Moriarty','Database Administrator II','2022-02-05',6990,18,'1'),('10','Ximenez','O\'Brollachain','Information Systems Manager','2022-07-06',7745,46,'10'),('11','Jose','Lassen','Software Test Engineer III','2022-07-29',5892,14,'2'),('12','Alex','Lassen','Software Test Engineer III','2022-07-29',5892,14,'2'),('2','Richmond','Lassen','Software Test Engineer III','2022-07-29',5892,14,'2'),('3','Shelley','Blencowe','Database Administrator III','2022-06-23',5491,35,'3'),('4','Walliw','Arangy','Dental Hygienist','2021-11-24',3115,29,'4'),('5','Bonni','Bruntje','Quality Engineer','2022-08-19',7553,26,'5'),('6','Temp','Epton','VP Marketing','2021-10-07',3827,32,'6'),('7','Tiffani','Hurton','Civil Engineer','2021-12-25',1602,39,'7'),('8','Tillie','Minchella','Account Representative III','2021-10-15',1909,19,'8'),('9','Crichton','Pitford','Senior Quality Engineer','2021-10-21',4763,13,'9');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-24 15:32:16
