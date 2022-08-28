CREATE DATABASE  IF NOT EXISTS `facturas_db` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `facturas_db`;
-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: 127.0.0.1    Database: facturas_db
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
-- Table structure for table `Articulo`
--

DROP TABLE IF EXISTS `Articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Articulo` (
  `id_articulo` int NOT NULL,
  `descripcion_articulo` varchar(45) NOT NULL,
  `iva` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id_articulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Articulo`
--

LOCK TABLES `Articulo` WRITE;
/*!40000 ALTER TABLE `Articulo` DISABLE KEYS */;
/*!40000 ALTER TABLE `Articulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cliente`
--

DROP TABLE IF EXISTS `Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Cliente` (
  `id_cliente` int NOT NULL,
  `nombre_cliente` varchar(40) NOT NULL,
  `apellido_cliente` varchar(40) NOT NULL,
  `direccion_cliente` varchar(40) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cliente`
--

LOCK TABLES `Cliente` WRITE;
/*!40000 ALTER TABLE `Cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `Cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Factura`
--

DROP TABLE IF EXISTS `Factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Factura` (
  `id_factura` int NOT NULL,
  `id_cliente` int NOT NULL,
  `fecha_factura` datetime NOT NULL,
  `importe` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id_factura`),
  KEY `fk_Factura_Cliente1_idx` (`id_cliente`),
  CONSTRAINT `fk_Factura_Cliente1` FOREIGN KEY (`id_cliente`) REFERENCES `Cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Factura`
--

LOCK TABLES `Factura` WRITE;
/*!40000 ALTER TABLE `Factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `Factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FacturaArticulo`
--

DROP TABLE IF EXISTS `FacturaArticulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `FacturaArticulo` (
  `id_factura` int NOT NULL,
  `id_articulo` int NOT NULL,
  `cantidad_articulo` int NOT NULL,
  PRIMARY KEY (`id_factura`,`id_articulo`),
  KEY `fk_Factura_has_Articulo_Articulo1_idx` (`id_articulo`),
  KEY `fk_Factura_has_Articulo_Factura_idx` (`id_factura`),
  CONSTRAINT `fk_Factura_has_Articulo_Articulo1` FOREIGN KEY (`id_articulo`) REFERENCES `Articulo` (`id_articulo`),
  CONSTRAINT `fk_Factura_has_Articulo_Factura` FOREIGN KEY (`id_factura`) REFERENCES `Factura` (`id_factura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FacturaArticulo`
--

LOCK TABLES `FacturaArticulo` WRITE;
/*!40000 ALTER TABLE `FacturaArticulo` DISABLE KEYS */;
/*!40000 ALTER TABLE `FacturaArticulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pago`
--

DROP TABLE IF EXISTS `Pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Pago` (
  `id_pago` varchar(45) NOT NULL,
  `id_factura` int NOT NULL,
  `forma_pago` decimal(10,0) NOT NULL,
  `importe` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id_pago`),
  KEY `fk_Pago_Factura1_idx` (`id_factura`),
  CONSTRAINT `fk_Pago_Factura1` FOREIGN KEY (`id_factura`) REFERENCES `Factura` (`id_factura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pago`
--

LOCK TABLES `Pago` WRITE;
/*!40000 ALTER TABLE `Pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `Pago` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-28 17:21:54
