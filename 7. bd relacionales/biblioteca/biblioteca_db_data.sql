CREATE DATABASE  IF NOT EXISTS `biblioteca_db` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `biblioteca_db`;
-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: 127.0.0.1    Database: biblioteca_db
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
  `idAutor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `nacionalidad` varchar(45) NOT NULL,
  PRIMARY KEY (`idAutor`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Autor`
--

LOCK TABLES `Autor` WRITE;
/*!40000 ALTER TABLE `Autor` DISABLE KEYS */;
INSERT INTO `Autor` VALUES (1,'Oliver Berry','Británica'),(2,'Mark A. Garlick','Británica'),(3,'Mark Mackenzie','Británica'),(4,'Valerie Stimac','Estadounidense'),(5,'Daniel Kellmereit','Alemana'),(6,'Daniel Obodovski','Rusa'),(7,'J. K. Rowling','Británica'),(8,'Helma Spona','Alemana'),(9,'Paul Beynon-Davies','Británica'),(10,'Douglas E. Comer','Estadounidense'),(11,'Julio Verne','Francesa'),(12,'Elsa Morante','Italiana'),(13,'John Foot','Británica');
/*!40000 ALTER TABLE `Autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Estudiante`
--

DROP TABLE IF EXISTS `Estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Estudiante` (
  `idLector` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `carrera` varchar(45) NOT NULL,
  `edad` int NOT NULL,
  PRIMARY KEY (`idLector`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Estudiante`
--

LOCK TABLES `Estudiante` WRITE;
/*!40000 ALTER TABLE `Estudiante` DISABLE KEYS */;
INSERT INTO `Estudiante` VALUES (1,'Gonzalo Nahuel','Di Pierro','Lincoln 3872','Informática',29),(2,'Filippo','Galli','Via Nicolai 27','Futbolista',59),(3,'Marcos','Galperin','Ibirapita 4422','Emprendimiento',50),(4,'Juan','Moreno','Otero 191','Informática',25),(5,'Ruben','Marquez','Senador Perez 319','Letras',29),(6,'Marcela','Alvarez','25 De Mayo 225','Letras',23);
/*!40000 ALTER TABLE `Estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Libro`
--

DROP TABLE IF EXISTS `Libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Libro` (
  `idLibro` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(60) NOT NULL,
  `editorial` varchar(45) NOT NULL,
  `area` varchar(45) NOT NULL,
  PRIMARY KEY (`idLibro`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Libro`
--

LOCK TABLES `Libro` WRITE;
/*!40000 ALTER TABLE `Libro` DISABLE KEYS */;
INSERT INTO `Libro` VALUES (1,'El Universo: Guía de viaje','GeoPlaneta','Cosmología'),(2,'The Silent Intelligence: The Internet of Things','Dnd Ventures LLC','Internet'),(3,'Harry Potter y la piedra filosofal','Salamandra','Fantasía'),(4,'Harry Potter y la cámara secreta','Salamandra','Fantasía'),(5,'Harry Potter y el prisionero de Azkaban','Salamandra','Fantasía'),(6,'Harry Potter y el cáliz de fuego','Salamandra','Fantasía'),(7,'Harry Potter y la Orden del Fénix','Salamandra','Fantasía'),(8,'Harry Potter y el misterio del príncipe','Salamandra','Fantasía'),(9,'Harry Potter y las Reliquias de la Muerte','Salamandra','Fantasía'),(10,'Harry Potter y el legado maldito','Salamandra','Fantasía'),(11,'Programación de bases de datos con MySQL Y PHP','Alfaomega & Marcombo','Base de datos'),(12,'Sistemas de bases de datos','Reverte','Base de datos'),(13,'El Libro de Internet','Pearson','Internet'),(14,'Veinte mil leguas de viaje submarino','LEA','Ciencia ficción'),(15,'La historia','Lumen','Ficción'),(16,'Calcio','HarperCollins Publishers','Fútbol');
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
  KEY `PK_LibroAutor_idAutor` (`idAutor`),
  KEY `PK_LibroAutor_idLibro` (`idLibro`),
  CONSTRAINT `FK_LibroAutor_Autor` FOREIGN KEY (`idAutor`) REFERENCES `Autor` (`idAutor`),
  CONSTRAINT `FK_LibroAutor_Libro` FOREIGN KEY (`idLibro`) REFERENCES `Libro` (`idLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LibroAutor`
--

LOCK TABLES `LibroAutor` WRITE;
/*!40000 ALTER TABLE `LibroAutor` DISABLE KEYS */;
INSERT INTO `LibroAutor` VALUES (1,1),(2,1),(3,1),(4,1),(5,2),(6,2),(7,3),(7,4),(7,5),(7,6),(7,7),(7,8),(7,9),(7,10),(8,11),(9,12),(10,13),(11,14),(12,15),(13,16);
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
  `fechaPrestamo` date NOT NULL,
  `fechaDevolucion` date NOT NULL,
  `devuelto` bit(1) NOT NULL,
  PRIMARY KEY (`idLector`,`idLibro`),
  KEY `PK_Prestamo_idLector` (`idLector`),
  KEY `PK_Prestamo_idLibro` (`idLibro`),
  CONSTRAINT `FK_Prestamo_Estudiante` FOREIGN KEY (`idLector`) REFERENCES `Estudiante` (`idLector`),
  CONSTRAINT `FK_Prestamo_Libro` FOREIGN KEY (`idLibro`) REFERENCES `Libro` (`idLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Prestamo`
--

LOCK TABLES `Prestamo` WRITE;
/*!40000 ALTER TABLE `Prestamo` DISABLE KEYS */;
INSERT INTO `Prestamo` VALUES (1,1,'2021-10-01','2022-01-10',_binary ''),(1,2,'2021-10-01','2022-01-10',_binary ''),(2,16,'2021-01-01','2021-07-16',_binary ''),(3,12,'2022-04-05','2022-05-05',_binary ''),(4,11,'2021-06-16','2021-07-16',_binary '\0'),(5,3,'2022-03-19','2022-06-19',_binary '\0'),(5,4,'2022-03-19','2022-06-19',_binary '\0'),(5,5,'2022-03-19','2022-06-19',_binary '\0'),(6,14,'2021-12-01','2022-12-01',_binary '\0');
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

-- Dump completed on 2022-08-25  0:11:48
