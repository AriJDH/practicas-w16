-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: mysql
-- Tiempo de generación: 24-08-2022 a las 14:59:20
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
-- Base de datos: `empresa_internet`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `fecha_de_nacimiento` date NOT NULL,
  `provincia` varchar(255) NOT NULL,
  `ciudad` varchar(255) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`nombre`, `apellido`, `fecha_de_nacimiento`, `provincia`, `ciudad`, `id`) VALUES
('emanuel', 'rivero', '2022-08-12', 'buenos aires', 'lugano', 1),
('pepe', 'don bosco', '2022-08-12', 'buenos aires', 'villa del parque', 2),
('melisa', 'barboza', '2022-08-15', 'buenos aires', 'la perla', 3),
('pablo', 'muse', '2022-08-10', 'montevideo', 'buceo', 4),
('camilo', 'espitia', '2022-08-12', 'colombia', 'cartagena', 5),
('martin', 'lucena', '2022-08-20', 'buenos aires', 'la plata', 6),
('eduardo', 'veni a buscar a juan cruz', '2022-08-16', 'buenos aires', 'palermo', 7),
('juan cruz', 'pobre nene', '2022-08-12', 'buenos aires', 'se perdio', 8),
('martin', 'pena', '2022-08-20', 'buenos aires', 'caba', 9),
('eduardo', 'lo perdio', '2022-08-16', 'buenos aires', 'villa del parque', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plan_internet`
--

CREATE TABLE `plan_internet` (
  `velocidad` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  `descuento` int(11) DEFAULT NULL,
  `nombre_plan` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `plan_internet`
--

INSERT INTO `plan_internet` (`velocidad`, `id`, `id_cliente`, `precio`, `descuento`, `nombre_plan`) VALUES
(100, 1, 1, 1500, 30, 'vuela 100 megas'),
(50, 2, 2, 1500, 30, 'vuela 50 megas'),
(10, 3, 3, 1500, 30, 'vuela 10 megas'),
(5, 4, 4, 1500, 30, 'vuela 5 megas'),
(3, 5, 5, 1500, 30, 'vuela 3 megas'),
(1, 6, 6, 1500, 30, 'vuela 1 megas'),
(1000, 7, 7, 1500, 30, 'vuela 1000 megas');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `plan_internet`
--
ALTER TABLE `plan_internet`
  ADD PRIMARY KEY (`id`),
  ADD KEY `plan_internet_cliente_null_fk` (`id_cliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `plan_internet`
--
ALTER TABLE `plan_internet`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `plan_internet`
--
ALTER TABLE `plan_internet`
  ADD CONSTRAINT `plan_internet_cliente_null_fk` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
