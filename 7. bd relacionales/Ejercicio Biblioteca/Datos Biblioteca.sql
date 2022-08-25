-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: localhost    Database: biblioteca
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
-- Table structure for table `Autor`
--

DROP TABLE IF EXISTS `Autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Autor` (
  `idAutor` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `nacionalidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idAutor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Autor`
--

LOCK TABLES `Autor` WRITE;
/*!40000 ALTER TABLE `Autor` DISABLE KEYS */;
INSERT INTO `Autor` VALUES (1,'J.K.Rowling','Inglesa'),(2,'Oliver Berry','Uruguaya'),(3,'MacKenzie MacBride','Italiana'),(4,'Mark A. Garlick','Francesa'),(5,'Valerie Stimac','Rusa');
/*!40000 ALTER TABLE `Autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Estudiante`
--

DROP TABLE IF EXISTS `Estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Estudiante` (
  `idLector` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `carrera` varchar(45) NOT NULL,
  `edad` int NOT NULL,
  PRIMARY KEY (`idLector`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Estudiante`
--

LOCK TABLES `Estudiante` WRITE;
/*!40000 ALTER TABLE `Estudiante` DISABLE KEYS */;
INSERT INTO `Estudiante` VALUES (1,'Jonathan ','Bracco','Gaboto 1245','Informatica',25),(2,'Pamela','Pereyra','Lima ','Ing. electronica',25),(3,'Matias','Lamela','Calle falsa 123','Medicina',30),(4,'Sergio ','Cardenas','Calle imaginaria 129','Abogacia',23),(5,'Horacio','Gato','La paz 123','Nutricion',50);
/*!40000 ALTER TABLE `Estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Libro`
--

DROP TABLE IF EXISTS `Libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Libro` (
  `idLibro` int NOT NULL,
  `titulo` varchar(45) DEFAULT NULL,
  `editorial` varchar(45) DEFAULT NULL,
  `area` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Libro`
--

LOCK TABLES `Libro` WRITE;
/*!40000 ALTER TABLE `Libro` DISABLE KEYS */;
INSERT INTO `Libro` VALUES (1,'Harry Potter','lalala','fantasia'),(2,'Game of Thrones','salamandra','fantasia'),(3,'Cocina para principiantes','cocina express','cocina'),(4,'El universo: Guia de viaje','magic','fantasia');
/*!40000 ALTER TABLE `Libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LibroAutor`
--

DROP TABLE IF EXISTS `LibroAutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `LibroAutor` (
  `idAutor` int NOT NULL,
  `idLibro` int NOT NULL,
  PRIMARY KEY (`idAutor`,`idLibro`),
  KEY `fk_Autor_has_Libro_Libro1_idx` (`idLibro`),
  KEY `fk_Autor_has_Libro_Autor_idx` (`idAutor`),
  CONSTRAINT `fk_Autor_has_Libro_Autor` FOREIGN KEY (`idAutor`) REFERENCES `Autor` (`idAutor`),
  CONSTRAINT `fk_Autor_has_Libro_Libro1` FOREIGN KEY (`idLibro`) REFERENCES `Libro` (`idLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LibroAutor`
--

LOCK TABLES `LibroAutor` WRITE;
/*!40000 ALTER TABLE `LibroAutor` DISABLE KEYS */;
INSERT INTO `LibroAutor` VALUES (1,1),(4,2),(5,3),(2,4),(3,4),(4,4);
/*!40000 ALTER TABLE `LibroAutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Prestamo`
--

DROP TABLE IF EXISTS `Prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Prestamo` (
  `idLector` int NOT NULL,
  `idLibro` int NOT NULL,
  `fecha_prestamo` datetime DEFAULT NULL,
  `fecha_devolucion` datetime DEFAULT NULL,
  `devuelto` tinyint DEFAULT NULL,
  PRIMARY KEY (`idLector`,`idLibro`),
  KEY `fk_Estudiante_has_Libro_Libro1_idx` (`idLibro`),
  KEY `fk_Estudiante_has_Libro_Estudiante1_idx` (`idLector`),
  CONSTRAINT `fk_Estudiante_has_Libro_Estudiante1` FOREIGN KEY (`idLector`) REFERENCES `Estudiante` (`idLector`),
  CONSTRAINT `fk_Estudiante_has_Libro_Libro1` FOREIGN KEY (`idLibro`) REFERENCES `Libro` (`idLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Prestamo`
--

LOCK TABLES `Prestamo` WRITE;
/*!40000 ALTER TABLE `Prestamo` DISABLE KEYS */;
INSERT INTO `Prestamo` VALUES (1,1,'2022-08-10 00:00:00','2022-08-22 00:00:00',1),(1,4,'2022-08-16 00:00:00',NULL,0),(2,2,'2022-08-23 00:00:00',NULL,0),(3,3,'2022-05-20 00:00:00','2022-06-01 00:00:00',1),(4,4,'2021-06-20 00:00:00','2021-07-16 00:00:00',1);
/*!40000 ALTER TABLE `Prestamo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-24 17:54:09
