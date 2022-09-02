-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: mysql
-- Tiempo de generación: 01-09-2022 a las 21:35:44
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
-- Base de datos: `movies_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actors`
--

CREATE TABLE `actors` (
  `id` int(10) UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `first_name` varchar(100) COLLATE utf8mb3_unicode_ci NOT NULL,
  `last_name` varchar(100) COLLATE utf8mb3_unicode_ci NOT NULL,
  `rating` decimal(3,1) DEFAULT NULL,
  `favorite_movie_id` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Volcado de datos para la tabla `actors`
--

INSERT INTO `actors` (`id`, `created_at`, `updated_at`, `first_name`, `last_name`, `rating`, `favorite_movie_id`) VALUES
(1, NULL, NULL, 'Sam', 'Worthington', '7.5', 1),
(2, NULL, NULL, 'Zoe', 'Saldana', '5.5', 2),
(3, NULL, NULL, 'Sigourney', 'Weaver', '9.7', 2),
(4, NULL, NULL, 'Leonardo', 'Di Caprio', '3.5', 4),
(5, NULL, NULL, 'Kate', 'Winslet', '1.5', 5),
(6, NULL, NULL, 'Billy', 'Zane', '7.5', 6),
(7, NULL, NULL, 'Mark', 'Hamill', '6.5', 7),
(8, NULL, NULL, 'Harrison', 'Ford', '7.5', 8),
(9, NULL, NULL, 'Carrie', 'Fisher', '7.5', 9),
(10, NULL, NULL, 'Sam', 'Neill', '2.5', 10),
(11, NULL, NULL, 'Laura', 'Dern', '7.5', 11),
(12, NULL, NULL, 'Jeff', 'Goldblum', '4.5', 4),
(13, NULL, NULL, 'Daniel', 'Radcliffe', '7.5', 13),
(14, NULL, NULL, 'Emma', 'Watson', '2.5', 14),
(15, NULL, NULL, 'Rupert', 'Grint', '6.2', 15),
(16, NULL, NULL, 'Shia', 'LaBeouf', '9.5', 16),
(17, NULL, NULL, 'Rosie', 'Huntington-Whiteley', '1.5', 17),
(18, NULL, NULL, 'Matthew', 'Broderick', '6.1', 18),
(19, NULL, NULL, 'James', 'Earl Jones', '7.5', 19),
(20, NULL, NULL, 'Jeremy', 'Irons', '7.2', 20),
(21, NULL, NULL, 'Johnny', 'Depp', '1.5', 21),
(22, NULL, NULL, 'Helena', 'Bonham Carter', '7.5', 1),
(23, NULL, NULL, 'Mia', 'Wasikowska', '7.5', 2),
(24, NULL, NULL, 'Albert', 'Brooks', '2.5', 3),
(25, NULL, NULL, 'Ellen', 'DeGeneres', '2.6', 4),
(26, NULL, NULL, 'Alexander', 'Gould', '7.5', 5),
(27, NULL, NULL, 'Tom', 'Hanks', '4.4', 6),
(28, NULL, NULL, 'Tim', 'Allen', '7.5', 7),
(29, NULL, NULL, 'Sean', 'Penn', '9.2', 8),
(30, NULL, NULL, 'Adam', 'Sandler', '3.1', 9),
(31, NULL, NULL, 'Renee', 'Zellweger', '9.5', 10),
(32, NULL, NULL, 'Emilia', 'Clarke', '8.2', 11),
(33, NULL, NULL, 'Peter', 'Dinklage', '2.3', 12),
(34, NULL, NULL, 'Kit', 'Harington', '2.4', 12),
(35, NULL, NULL, 'Jared', 'Padalecki', '2.8', 14),
(36, NULL, NULL, 'Jensen', 'Ackles', '5.5', 15),
(37, NULL, NULL, 'Jim', 'Beaver', '2.6', 16),
(38, NULL, NULL, 'Andrew', 'Lincoln', '3.3', 17),
(39, NULL, NULL, 'Jon', 'Bernthal', '2.9', 12),
(40, NULL, NULL, 'Sarah', 'Callies', '2.4', 19),
(41, NULL, NULL, 'Jim', 'Caviezel', '1.9', 20),
(42, NULL, NULL, 'Taraji', 'Henson', '5.9', 21),
(43, NULL, NULL, 'Kevin', 'Chapman', '2.9', 1),
(44, NULL, NULL, 'Johnny', 'Galecki', '2.3', 2),
(45, NULL, NULL, 'Jim', 'Parsons', '6.9', 3),
(46, NULL, NULL, 'Kaley', 'Cuoco', '2.3', 4),
(47, NULL, NULL, 'Bryan', 'Cranston', '7.9', 12),
(48, NULL, NULL, 'Aaron', 'Paul', '5.9', 6),
(49, NULL, NULL, 'Anna', 'Gunn', '3.1', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actor_episode`
--

CREATE TABLE `actor_episode` (
  `actor_id` int(10) UNSIGNED NOT NULL,
  `episode_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Volcado de datos para la tabla `actor_episode`
--

INSERT INTO `actor_episode` (`actor_id`, `episode_id`) VALUES
(32, 1),
(32, 2),
(32, 3),
(32, 4),
(32, 5),
(33, 1),
(33, 2),
(33, 3),
(33, 4),
(33, 5),
(33, 6),
(34, 1),
(34, 2),
(34, 4),
(34, 5),
(34, 6),
(35, 7),
(35, 8),
(35, 9),
(35, 10),
(35, 11),
(35, 12),
(35, 13),
(35, 15),
(35, 16),
(35, 17),
(36, 7),
(36, 8),
(36, 9),
(36, 10),
(36, 13),
(36, 14),
(36, 15),
(36, 16),
(36, 17),
(37, 7),
(37, 8),
(37, 9),
(37, 10),
(37, 11),
(37, 12),
(37, 13),
(37, 14),
(37, 15),
(37, 17),
(38, 18),
(38, 19),
(38, 20),
(38, 22),
(38, 23),
(39, 18),
(39, 19),
(39, 20),
(39, 21),
(39, 22),
(39, 23),
(40, 19),
(40, 20),
(40, 21),
(40, 22),
(40, 23),
(41, 24),
(41, 25),
(41, 26),
(41, 27),
(41, 28),
(42, 24),
(42, 25),
(42, 26),
(42, 27),
(42, 28),
(43, 24),
(43, 26),
(43, 27),
(43, 28),
(44, 29),
(44, 30),
(44, 31),
(44, 32),
(44, 33),
(44, 34),
(44, 35),
(44, 36),
(44, 37),
(45, 29),
(45, 31),
(45, 32),
(45, 33),
(45, 34),
(45, 35),
(45, 36),
(45, 37),
(46, 29),
(46, 30),
(46, 33),
(46, 35),
(46, 36),
(46, 37),
(47, 38),
(47, 39),
(47, 40),
(47, 41),
(47, 42),
(47, 45),
(47, 46),
(47, 47),
(47, 48),
(47, 49),
(47, 50),
(47, 51),
(47, 52),
(47, 53),
(47, 54),
(47, 55),
(47, 56),
(48, 40),
(48, 41),
(48, 42),
(48, 43),
(48, 44),
(48, 45),
(48, 47),
(48, 48),
(48, 49),
(48, 50),
(48, 51),
(48, 52),
(48, 54),
(48, 55),
(48, 56),
(48, 57),
(49, 38),
(49, 39),
(49, 40),
(49, 41),
(49, 42),
(49, 43),
(49, 44),
(49, 46),
(49, 47),
(49, 48),
(49, 49),
(49, 50),
(49, 51),
(49, 52),
(49, 54),
(49, 55),
(49, 57);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actor_movie`
--

CREATE TABLE `actor_movie` (
  `actor_id` int(10) UNSIGNED NOT NULL,
  `movie_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Volcado de datos para la tabla `actor_movie`
--

INSERT INTO `actor_movie` (`actor_id`, `movie_id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 2),
(5, 2),
(6, 2),
(7, 3),
(7, 4),
(8, 3),
(8, 4),
(9, 3),
(9, 4),
(10, 5),
(11, 5),
(12, 5),
(13, 6),
(13, 8),
(13, 9),
(14, 6),
(14, 8),
(14, 9),
(15, 6),
(15, 8),
(15, 9),
(16, 7),
(17, 7),
(18, 7),
(19, 10),
(20, 10),
(21, 11),
(22, 11),
(22, 9),
(23, 11),
(24, 12),
(25, 12),
(26, 12),
(27, 13),
(27, 14),
(27, 19),
(28, 13),
(28, 14),
(29, 20),
(30, 21);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `episodes`
--

CREATE TABLE `episodes` (
  `id` int(10) UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `title` varchar(500) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `number` int(10) UNSIGNED DEFAULT NULL,
  `release_date` datetime NOT NULL,
  `rating` decimal(3,1) NOT NULL,
  `season_id` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Volcado de datos para la tabla `episodes`
--

INSERT INTO `episodes` (`id`, `created_at`, `updated_at`, `title`, `number`, `release_date`, `rating`, `season_id`) VALUES
(1, NULL, NULL, 'Winter Is Coming', 1, '2011-01-01 00:00:00', '7.3', 1),
(2, NULL, NULL, 'The North Remembers', 1, '2012-01-01 00:00:00', '8.3', 2),
(3, NULL, NULL, 'Valar Dohaeris', 1, '2013-01-01 00:00:00', '6.3', 3),
(4, NULL, NULL, 'Two Swords', 1, '2014-01-01 00:00:00', '7.5', 4),
(5, NULL, NULL, 'The Wars to Come', 1, '2015-01-01 00:00:00', '9.3', 5),
(6, NULL, NULL, 'The Red Woman', 1, '2016-01-01 00:00:00', '7.7', 6),
(7, NULL, NULL, 'Pilot', 1, '2005-01-01 00:00:00', '7.3', 8),
(8, NULL, NULL, 'In My Time of Dying', 1, '2006-01-01 00:00:00', '8.3', 9),
(9, NULL, NULL, 'The Magnificent Seven', 1, '2007-01-01 00:00:00', '6.3', 10),
(10, NULL, NULL, 'Lazarus Rising', 1, '2008-01-01 00:00:00', '7.5', 11),
(11, NULL, NULL, 'Sympathy for the Devil', 1, '2009-01-01 00:00:00', '9.3', 12),
(12, NULL, NULL, 'Exile on Main St.', 1, '2010-01-01 00:00:00', '7.7', 13),
(13, NULL, NULL, 'Meet the New Boss', 1, '2011-01-01 00:00:00', '7.3', 14),
(14, NULL, NULL, 'We Need to Talk About Kevin', 1, '2012-01-01 00:00:00', '8.3', 15),
(15, NULL, NULL, 'I Think Im Gonna Like It Here', 1, '2013-01-01 00:00:00', '6.3', 16),
(16, NULL, NULL, 'A Very Special Supernatural Special', 1, '2014-01-01 00:00:00', '7.5', 17),
(17, NULL, NULL, 'Out of the Darkness, Into the Fire', 1, '2015-01-01 00:00:00', '9.3', 18),
(18, NULL, NULL, 'Days Gone Bye', 1, '2010-01-01 00:00:00', '7.3', 20),
(19, NULL, NULL, 'What Lies Ahead', 1, '2011-01-01 00:00:00', '8.3', 21),
(20, NULL, NULL, 'Seed', 1, '2012-01-01 00:00:00', '6.3', 22),
(21, NULL, NULL, '30 Days Without an Accident', 1, '2013-01-01 00:00:00', '7.5', 23),
(22, NULL, NULL, 'No Sanctuary', 1, '2014-01-01 00:00:00', '9.3', 24),
(23, NULL, NULL, 'First Time Again', 1, '2015-01-01 00:00:00', '7.7', 25),
(24, NULL, NULL, 'Pilot', 1, '2011-01-01 00:00:00', '7.3', 27),
(25, NULL, NULL, 'The Contingency', 1, '2012-01-01 00:00:00', '8.3', 28),
(26, NULL, NULL, 'Liberty', 1, '2013-01-01 00:00:00', '6.3', 29),
(27, NULL, NULL, 'Panopticon', 1, '2015-01-01 00:00:00', '7.5', 30),
(28, NULL, NULL, 'B.S.O.D.', 1, '2016-01-01 00:00:00', '9.3', 31),
(29, NULL, NULL, 'Pilot', 1, '2005-01-01 00:00:00', '7.3', 32),
(30, NULL, NULL, 'The Bad Fish Paradigm', 1, '2006-01-01 00:00:00', '8.3', 33),
(31, NULL, NULL, 'The Electric Can Opener Fluctuation', 1, '2007-01-01 00:00:00', '6.3', 34),
(32, NULL, NULL, 'The Robotic Manipulation', 1, '2008-01-01 00:00:00', '7.5', 35),
(33, NULL, NULL, 'The Skank Reflex Analysis', 1, '2009-01-01 00:00:00', '9.3', 36),
(34, NULL, NULL, 'The Date Night Variable', 1, '2010-01-01 00:00:00', '7.7', 37),
(35, NULL, NULL, 'The Hofstadter Insufficiency', 1, '2011-01-01 00:00:00', '7.3', 38),
(36, NULL, NULL, 'The Locomotion Interruption', 1, '2012-01-01 00:00:00', '8.3', 39),
(37, NULL, NULL, 'The Matrimonial Momentum', 1, '2013-01-01 00:00:00', '6.3', 40),
(38, NULL, NULL, 'Pilot', 1, '2009-01-01 00:00:00', '7.3', 42),
(39, NULL, NULL, 'Seven Thirty-Seven', 1, '2010-01-01 00:00:00', '8.3', 43),
(40, NULL, NULL, 'No Más', 1, '2011-01-01 00:00:00', '6.3', 44),
(41, NULL, NULL, 'Box Cutter', 1, '2012-01-01 00:00:00', '7.5', 45),
(42, NULL, NULL, 'Live Free or Die', 1, '2013-01-01 00:00:00', '9.3', 46),
(43, NULL, NULL, 'Madrigal', 2, '2013-02-01 00:00:00', '9.3', 46),
(44, NULL, NULL, 'Hazard Pay', 3, '2013-03-01 00:00:00', '9.3', 46),
(45, NULL, NULL, 'Fifty-One', 4, '2013-04-01 00:00:00', '9.3', 46),
(46, NULL, NULL, 'Dead Freight', 5, '2013-05-01 00:00:00', '9.3', 46),
(47, NULL, NULL, 'Buyout', 6, '2013-06-01 00:00:00', '9.3', 46),
(48, NULL, NULL, 'Say My Name', 7, '2013-06-01 00:00:00', '9.3', 46),
(49, NULL, NULL, 'Gliding Over All', 8, '2013-07-01 00:00:00', '9.3', 46),
(50, NULL, NULL, 'Blood Money', 9, '2013-07-01 00:00:00', '9.3', 46),
(51, NULL, NULL, 'Buried', 10, '2013-07-01 00:00:00', '9.3', 46),
(52, NULL, NULL, 'Confessions', 11, '2013-08-01 00:00:00', '9.3', 46),
(53, NULL, NULL, 'Rabid Dog', 12, '2013-09-01 00:00:00', '9.3', 46),
(54, NULL, NULL, 'To hajiilee', 13, '2013-10-01 00:00:00', '9.3', 46),
(55, NULL, NULL, 'Ozymandias', 14, '2013-11-01 00:00:00', '9.3', 46),
(56, NULL, NULL, 'Granite State', 15, '2013-12-01 00:00:00', '9.3', 46),
(57, NULL, NULL, 'Felina', 16, '2013-12-01 00:00:00', '9.3', 46);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genres`
--

CREATE TABLE `genres` (
  `id` int(10) UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `name` varchar(100) COLLATE utf8mb3_unicode_ci NOT NULL,
  `ranking` int(10) UNSIGNED NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Volcado de datos para la tabla `genres`
--

INSERT INTO `genres` (`id`, `created_at`, `updated_at`, `name`, `ranking`, `active`) VALUES
(1, '2016-07-04 03:00:00', NULL, 'Comedia', 1, 1),
(2, '2014-07-04 03:00:00', NULL, 'Terror', 2, 1),
(3, '2013-07-04 03:00:00', NULL, 'Drama', 3, 1),
(4, '2011-07-04 03:00:00', NULL, 'Accion', 4, 1),
(5, '2010-07-04 03:00:00', NULL, 'Ciencia Ficcion', 5, 1),
(6, '2013-07-04 03:00:00', NULL, 'Suspenso', 6, 1),
(7, '2005-07-04 03:00:00', NULL, 'Animacion', 7, 1),
(8, '2003-07-04 03:00:00', NULL, 'Aventuras', 8, 1),
(9, '2008-07-04 03:00:00', NULL, 'Documental', 9, 1),
(10, '2013-07-04 03:00:00', NULL, 'Infantiles', 10, 1),
(11, '2011-07-04 03:00:00', NULL, 'Fantasia', 11, 1),
(12, '2013-07-04 03:00:00', NULL, 'Musical', 12, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Volcado de datos para la tabla `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '2014_10_12_000000_create_users_table', 1),
(2, '2014_10_12_100000_create_password_resets_table', 1),
(3, '2016_10_17_130820_create_genres_table', 1),
(4, '2016_10_17_130829_create_movies_table', 1),
(5, '2016_10_17_130842_create_series_table', 1),
(6, '2016_10_17_130849_create_seasons_table', 1),
(7, '2016_10_17_130903_create_episodes_table', 1),
(8, '2016_10_17_130913_create_actors_table', 1),
(9, '2016_10_17_130925_create_actor_movie_table', 1),
(10, '2016_10_17_130938_create_actor_episode_table', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movies`
--

CREATE TABLE `movies` (
  `id` int(10) UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `title` varchar(500) COLLATE utf8mb3_unicode_ci NOT NULL,
  `rating` decimal(3,1) UNSIGNED NOT NULL,
  `awards` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `release_date` datetime NOT NULL,
  `length` int(10) UNSIGNED DEFAULT NULL,
  `genre_id` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Volcado de datos para la tabla `movies`
--

INSERT INTO `movies` (`id`, `created_at`, `updated_at`, `title`, `rating`, `awards`, `release_date`, `length`, `genre_id`) VALUES
(1, NULL, NULL, 'Avatar', '7.9', 3, '2010-10-04 00:00:00', 120, 5),
(2, NULL, NULL, 'Titanic', '7.7', 11, '1997-09-04 00:00:00', 320, 3),
(3, NULL, NULL, 'La Guerra de las galaxias: Episodio VI', '9.1', 7, '2004-07-04 00:00:00', 1, 5),
(4, NULL, NULL, 'La Guerra de las galaxias: Episodio VII', '9.0', 6, '2003-11-04 00:00:00', 180, 5),
(5, NULL, NULL, 'Parque Jurasico', '8.3', 5, '1999-01-04 00:00:00', 270, 5),
(6, NULL, NULL, 'Harry Potter y las Reliquias de la Muerte - Parte 2', '9.0', 2, '2008-07-04 00:00:00', 190, 6),
(7, NULL, NULL, 'Transformers: el lado oscuro de la luna', '0.9', 1, '2005-07-04 00:00:00', 2, 5),
(8, NULL, NULL, 'Harry Potter y la piedra filosofal', '10.0', 1, '2008-04-04 00:00:00', 120, 8),
(9, NULL, NULL, 'Harry Potter y la cámara de los secretos', '3.5', 2, '2009-08-04 00:00:00', 200, 8),
(10, NULL, NULL, 'El rey león', '9.1', 3, '2000-02-04 00:00:00', 2, 10),
(11, NULL, NULL, 'Alicia en el país de las maravillas', '5.7', 2, '2008-07-04 00:00:00', 120, 3),
(12, NULL, NULL, 'Buscando a Nemo', '8.3', 2, '2000-07-04 00:00:00', 110, 7),
(13, NULL, NULL, 'Toy Story', '6.1', 0, '2008-03-04 00:00:00', 150, 7),
(14, NULL, NULL, 'Toy Story 2', '3.2', 2, '2003-04-04 00:00:00', 120, 7),
(15, NULL, NULL, 'La vida es bella', '8.3', 5, '1994-10-04 00:00:00', 3, 3),
(16, NULL, NULL, 'Mi pobre angelito', '3.2', 1, '1989-01-04 00:00:00', 120, 1),
(17, NULL, NULL, 'Intensamente', '9.0', 2, '2008-07-04 00:00:00', 120, 7),
(18, NULL, NULL, 'Carrozas de fuego', '9.9', 7, '1980-07-04 00:00:00', 180, 1),
(19, NULL, NULL, 'Big', '7.3', 2, '1988-02-04 00:00:00', 130, 8),
(20, NULL, NULL, 'I am Sam', '9.0', 4, '1999-03-04 00:00:00', 130, 3),
(21, NULL, NULL, 'Hotel Transylvania', '7.1', 1, '2012-05-04 00:00:00', 90, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `password_resets`
--

CREATE TABLE `password_resets` (
  `email` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `token` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seasons`
--

CREATE TABLE `seasons` (
  `id` int(10) UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `title` varchar(500) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `number` int(10) UNSIGNED DEFAULT NULL,
  `release_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `serie_id` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Volcado de datos para la tabla `seasons`
--

INSERT INTO `seasons` (`id`, `created_at`, `updated_at`, `title`, `number`, `release_date`, `end_date`, `serie_id`) VALUES
(1, NULL, NULL, 'Primer Temporada', 1, '2011-01-01 00:00:00', '2011-01-01 00:00:00', 1),
(2, NULL, NULL, 'Segunda Temporada', 2, '2012-01-01 00:00:00', '2012-01-01 00:00:00', 1),
(3, NULL, NULL, 'Tercer Temporada', 3, '2013-01-01 00:00:00', '2013-01-01 00:00:00', 1),
(4, NULL, NULL, 'Cuarta Temporada', 4, '2014-01-01 00:00:00', '2014-01-01 00:00:00', 1),
(5, NULL, NULL, 'Quinta Temporada', 5, '2015-01-01 00:00:00', '2015-01-01 00:00:00', 1),
(6, NULL, NULL, 'Sexta Temporada', 6, '2016-01-01 00:00:00', '2016-01-01 00:00:00', 1),
(7, NULL, NULL, 'Septima Temporada', 7, '2017-01-01 00:00:00', '2017-01-01 00:00:00', 1),
(8, NULL, NULL, 'Primer Temporada', 1, '2005-01-01 00:00:00', '2006-01-01 00:00:00', 2),
(9, NULL, NULL, 'Segunda Temporada', 2, '2006-01-01 00:00:00', '2007-01-01 00:00:00', 2),
(10, NULL, NULL, 'Tercer Temporada', 3, '2007-01-01 00:00:00', '2008-01-01 00:00:00', 2),
(11, NULL, NULL, 'Cuarta Temporada', 4, '2008-01-01 00:00:00', '2009-01-01 00:00:00', 2),
(12, NULL, NULL, 'Quinta Temporada', 5, '2009-01-01 00:00:00', '2010-01-01 00:00:00', 2),
(13, NULL, NULL, 'Sexta Temporada', 6, '2010-01-01 00:00:00', '2011-01-01 00:00:00', 2),
(14, NULL, NULL, 'Septima Temporada', 7, '2011-01-01 00:00:00', '2012-01-01 00:00:00', 2),
(15, NULL, NULL, 'Octava Temporada', 8, '2012-01-01 00:00:00', '2013-01-01 00:00:00', 2),
(16, NULL, NULL, 'Novena Temporada', 9, '2013-01-01 00:00:00', '2014-01-01 00:00:00', 2),
(17, NULL, NULL, 'Decima Temporada', 10, '2014-01-01 00:00:00', '2015-01-01 00:00:00', 2),
(18, NULL, NULL, 'Undecima Temporada', 11, '2015-01-01 00:00:00', '2016-01-01 00:00:00', 2),
(19, NULL, NULL, 'Duodecima Temporada', 12, '2016-01-01 00:00:00', '2017-01-01 00:00:00', 2),
(20, NULL, NULL, 'Primer Temporada', 1, '2010-01-01 00:00:00', '2010-01-01 00:00:00', 3),
(21, NULL, NULL, 'Segunda Temporada', 2, '2011-01-01 00:00:00', '2012-01-01 00:00:00', 3),
(22, NULL, NULL, 'Tercer Temporada', 3, '2012-01-01 00:00:00', '2013-01-01 00:00:00', 3),
(23, NULL, NULL, 'Cuarta Temporada', 4, '2013-01-01 00:00:00', '2014-01-01 00:00:00', 3),
(24, NULL, NULL, 'Quinta Temporada', 5, '2014-01-01 00:00:00', '2015-01-01 00:00:00', 3),
(25, NULL, NULL, 'Sexta Temporada', 6, '2015-01-01 00:00:00', '2016-01-01 00:00:00', 3),
(26, NULL, NULL, 'Septima Temporada', 7, '2016-01-01 00:00:00', '2017-01-01 00:00:00', 3),
(27, NULL, NULL, 'Primer Temporada', 1, '2011-01-01 00:00:00', '2012-01-01 00:00:00', 4),
(28, NULL, NULL, 'Segunda Temporada', 2, '2012-01-01 00:00:00', '2013-01-01 00:00:00', 4),
(29, NULL, NULL, 'Tercer Temporada', 3, '2013-01-01 00:00:00', '2014-01-01 00:00:00', 4),
(30, NULL, NULL, 'Cuarta Temporada', 4, '2014-01-01 00:00:00', '2015-01-01 00:00:00', 4),
(31, NULL, NULL, 'Quinta Temporada', 5, '2015-01-01 00:00:00', '2016-01-01 00:00:00', 4),
(32, NULL, NULL, 'Primer Temporada', 1, '2006-01-01 00:00:00', '2008-01-01 00:00:00', 5),
(33, NULL, NULL, 'Segunda Temporada', 2, '2008-01-01 00:00:00', '2009-01-01 00:00:00', 5),
(34, NULL, NULL, 'Tercer Temporada', 3, '2009-01-01 00:00:00', '2010-01-01 00:00:00', 5),
(35, NULL, NULL, 'Cuarta Temporada', 4, '2010-01-01 00:00:00', '2011-01-01 00:00:00', 5),
(36, NULL, NULL, 'Quinta Temporada', 5, '2011-01-01 00:00:00', '2012-01-01 00:00:00', 5),
(37, NULL, NULL, 'Sexta Temporada', 6, '2012-01-01 00:00:00', '2013-01-01 00:00:00', 5),
(38, NULL, NULL, 'Septima Temporada', 7, '2013-01-01 00:00:00', '2014-01-01 00:00:00', 5),
(39, NULL, NULL, 'Octava Temporada', 8, '2014-01-01 00:00:00', '2015-01-01 00:00:00', 5),
(40, NULL, NULL, 'Novena Temporada', 9, '2015-01-01 00:00:00', '2016-01-01 00:00:00', 5),
(41, NULL, NULL, 'Decima Temporada', 10, '2016-01-01 00:00:00', '2017-01-01 00:00:00', 5),
(42, NULL, NULL, 'Primer Temporada', 1, '2008-01-01 00:00:00', '2008-01-01 00:00:00', 6),
(43, NULL, NULL, 'Segunda Temporada', 2, '2009-01-01 00:00:00', '2009-01-01 00:00:00', 6),
(44, NULL, NULL, 'Tercer Temporada', 3, '2010-01-01 00:00:00', '2010-01-01 00:00:00', 6),
(45, NULL, NULL, 'Cuarta Temporada', 4, '2011-01-01 00:00:00', '2011-01-01 00:00:00', 6),
(46, NULL, NULL, 'Quinta Temporada', 5, '2012-01-01 00:00:00', '2012-01-01 00:00:00', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `series`
--

CREATE TABLE `series` (
  `id` int(10) UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `title` varchar(500) COLLATE utf8mb3_unicode_ci NOT NULL,
  `release_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `genre_id` int(10) UNSIGNED DEFAULT NULL,
  `relase_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Volcado de datos para la tabla `series`
--

INSERT INTO `series` (`id`, `created_at`, `updated_at`, `title`, `release_date`, `end_date`, `genre_id`, `relase_date`) VALUES
(1, NULL, NULL, 'Game of Thrones', '2011-01-01 00:00:00', '2016-03-04 00:00:00', 11, NULL),
(2, NULL, NULL, 'Supernatural', '2005-01-01 00:00:00', '2016-01-04 00:00:00', 6, NULL),
(3, NULL, NULL, 'The Walking Dead', '2010-01-01 00:00:00', '2016-01-04 00:00:00', 2, NULL),
(4, NULL, NULL, 'Person of Interest', '2011-01-01 00:00:00', '2015-01-04 00:00:00', 4, NULL),
(5, NULL, NULL, 'The Big Bang Theory', '2007-01-01 00:00:00', '2016-01-04 00:00:00', 1, NULL),
(6, NULL, NULL, 'Breaking Bad', '2008-01-01 00:00:00', '2013-01-04 00:00:00', 3, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `remember_token` varchar(100) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actors`
--
ALTER TABLE `actors`
  ADD PRIMARY KEY (`id`),
  ADD KEY `actors_favorite_movie_id_foreign` (`favorite_movie_id`);

--
-- Indices de la tabla `actor_episode`
--
ALTER TABLE `actor_episode`
  ADD KEY `actor_episode_actor_id_foreign` (`actor_id`),
  ADD KEY `actor_episode_episode_id_foreign` (`episode_id`);

--
-- Indices de la tabla `actor_movie`
--
ALTER TABLE `actor_movie`
  ADD KEY `actor_movie_actor_id_foreign` (`actor_id`),
  ADD KEY `actor_movie_movie_id_foreign` (`movie_id`);

--
-- Indices de la tabla `episodes`
--
ALTER TABLE `episodes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `episodes_season_id_foreign` (`season_id`);

--
-- Indices de la tabla `genres`
--
ALTER TABLE `genres`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `genres_ranking_unique` (`ranking`);

--
-- Indices de la tabla `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`id`),
  ADD KEY `movies_genre_id_foreign` (`genre_id`);

--
-- Indices de la tabla `password_resets`
--
ALTER TABLE `password_resets`
  ADD KEY `password_resets_email_index` (`email`),
  ADD KEY `password_resets_token_index` (`token`);

--
-- Indices de la tabla `seasons`
--
ALTER TABLE `seasons`
  ADD PRIMARY KEY (`id`),
  ADD KEY `seasons_serie_id_foreign` (`serie_id`);

--
-- Indices de la tabla `series`
--
ALTER TABLE `series`
  ADD PRIMARY KEY (`id`),
  ADD KEY `series_genre_id_foreign` (`genre_id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_email_unique` (`email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `actors`
--
ALTER TABLE `actors`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT de la tabla `episodes`
--
ALTER TABLE `episodes`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT de la tabla `genres`
--
ALTER TABLE `genres`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `movies`
--
ALTER TABLE `movies`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `seasons`
--
ALTER TABLE `seasons`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT de la tabla `series`
--
ALTER TABLE `series`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actors`
--
ALTER TABLE `actors`
  ADD CONSTRAINT `actors_favorite_movie_id_foreign` FOREIGN KEY (`favorite_movie_id`) REFERENCES `movies` (`id`);

--
-- Filtros para la tabla `actor_episode`
--
ALTER TABLE `actor_episode`
  ADD CONSTRAINT `actor_episode_actor_id_foreign` FOREIGN KEY (`actor_id`) REFERENCES `actors` (`id`),
  ADD CONSTRAINT `actor_episode_episode_id_foreign` FOREIGN KEY (`episode_id`) REFERENCES `episodes` (`id`);

--
-- Filtros para la tabla `actor_movie`
--
ALTER TABLE `actor_movie`
  ADD CONSTRAINT `actor_movie_actor_id_foreign` FOREIGN KEY (`actor_id`) REFERENCES `actors` (`id`),
  ADD CONSTRAINT `actor_movie_movie_id_foreign` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`);

--
-- Filtros para la tabla `episodes`
--
ALTER TABLE `episodes`
  ADD CONSTRAINT `episodes_season_id_foreign` FOREIGN KEY (`season_id`) REFERENCES `seasons` (`id`);

--
-- Filtros para la tabla `movies`
--
ALTER TABLE `movies`
  ADD CONSTRAINT `movies_genre_id_foreign` FOREIGN KEY (`genre_id`) REFERENCES `genres` (`id`);

--
-- Filtros para la tabla `seasons`
--
ALTER TABLE `seasons`
  ADD CONSTRAINT `seasons_serie_id_foreign` FOREIGN KEY (`serie_id`) REFERENCES `series` (`id`);

--
-- Filtros para la tabla `series`
--
ALTER TABLE `series`
  ADD CONSTRAINT `series_genre_id_foreign` FOREIGN KEY (`genre_id`) REFERENCES `genres` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
