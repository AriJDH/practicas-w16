-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: mysql
-- Tiempo de generación: 24-08-2022 a las 20:43:58
-- Versión del servidor: 10.8.3-MariaDB-1:10.8.3+maria~jammy
-- Versión de PHP: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `libros`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor`
--

CREATE TABLE `autor` (
  `idAutor` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `nacionalidad` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `autor`
--

INSERT INTO `autor` (`idAutor`, `nombre`, `nacionalidad`) VALUES
(1, 'emanuel', 'Francia'),
(2, 'Emanuel', 'Argentina'),
(3, 'Condori', 'Argentina'),
(4, 'Juan1', 'Argentina'),
(5, 'Juan2', 'Argentina'),
(6, 'Pepe', 'Colombia'),
(7, 'Melisa', 'Uruguay'),
(8, 'Pedrito', 'Italiana'),
(9, 'J.K. Rowling.', 'Inglaterra');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

CREATE TABLE `estudiante` (
  `idLector` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) NOT NULL,
  `carrera` varchar(255) NOT NULL,
  `edad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estudiante`
--

INSERT INTO `estudiante` (`idLector`, `nombre`, `apellido`, `direccion`, `carrera`, `edad`) VALUES
(1, 'Fernando', 'Rivero', 'Calle falsa 123', 'ING Informatica', 54),
(2, 'Priscila', 'Mujica', 'San Rafa 123', 'ING Civil', 21),
(3, 'Eduardo', 'Juan Cruz', 'Veni a buscarlo', 'ING Electronica', 34),
(4, 'Juan', 'Pala', 'Calle 443', 'ING Mecanica', 24),
(5, 'Pedro', 'Gaston', 'Bosbonia 123', 'ING Mecatronica', 44),
(6, 'Gaston', 'Duki', 'duki 443', 'ING Naval', 27),
(7, 'Filipo', 'Galle', 'Calle falsa 2121', 'Ing Naval', 54);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `idLibro` int(11) NOT NULL,
  `titulo` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `editorial` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `Area` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`idLibro`, `titulo`, `editorial`, `Area`) VALUES
(1, 'Game Of Thrones', 'Alfa Omega', 'Ciencia Ficcion'),
(2, 'El juego del calamar', 'Salamandra', 'Internet'),
(3, 'Perro Salchicha', 'Salamandra', 'Internet'),
(4, 'Harry Potter', 'Una Editorial', 'Ciencia Ficcion'),
(5, 'Shotter', 'Editorial Buena', 'Accion'),
(6, 'El universo:Guia de viaje', 'Pedro Navaja', 'Internet'),
(7, 'Bases de datos', 'Tecnologia Suprema', 'Base de datos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libroautor`
--

CREATE TABLE `libroautor` (
  `idAutor` int(11) NOT NULL,
  `idLibro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libroautor`
--

INSERT INTO `libroautor` (`idAutor`, `idLibro`) VALUES
(1, 6),
(2, 6),
(3, 3),
(4, 5),
(6, 1),
(9, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `idPrestamo` int(11) NOT NULL,
  `fecha_prestamo` date DEFAULT NULL,
  `fecha_devolucion` date DEFAULT NULL,
  `devuelto` tinyint(1) DEFAULT NULL,
  `idLector` int(11) NOT NULL,
  `idLibro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`idPrestamo`, `fecha_prestamo`, `fecha_devolucion`, `devuelto`, `idLector`, `idLibro`) VALUES
(1, '2022-08-24', '2022-08-31', 0, 7, 1),
(2, '2022-08-24', '2022-08-30', 0, 7, 2),
(3, '2022-08-24', '2022-08-29', 0, 4, 3),
(4, '2022-08-24', '2022-08-28', 0, 5, 4),
(5, '2022-08-24', '2022-09-20', 0, 6, 7);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autor`
--
ALTER TABLE `autor`
  ADD PRIMARY KEY (`idAutor`);

--
-- Indices de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD PRIMARY KEY (`idLector`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`idLibro`);

--
-- Indices de la tabla `libroautor`
--
ALTER TABLE `libroautor`
  ADD KEY `libroautor_libro_null_fk` (`idLibro`),
  ADD KEY `libroautor_autor_null_fk` (`idAutor`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`idPrestamo`),
  ADD KEY `prestamo_estudiante_null_fk` (`idLector`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `autor`
--
ALTER TABLE `autor`
  MODIFY `idAutor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  MODIFY `idLector` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `libro`
--
ALTER TABLE `libro`
  MODIFY `idLibro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  MODIFY `idPrestamo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `libroautor`
--
ALTER TABLE `libroautor`
  ADD CONSTRAINT `libroautor_autor_null_fk` FOREIGN KEY (`idAutor`) REFERENCES `autor` (`idAutor`),
  ADD CONSTRAINT `libroautor_libro_null_fk` FOREIGN KEY (`idLibro`) REFERENCES `libro` (`idLibro`);

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `prestamo_estudiante_null_fk` FOREIGN KEY (`idLector`) REFERENCES `estudiante` (`idLector`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
