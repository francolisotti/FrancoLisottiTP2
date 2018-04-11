-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 11-04-2018 a las 14:53:47
-- Versión del servidor: 5.7.19
-- Versión de PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tp3`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cartas`
--

DROP TABLE IF EXISTS `cartas`;
CREATE TABLE IF NOT EXISTS `cartas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `palo` varchar(50) NOT NULL,
  `valor` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cartas`
--

INSERT INTO `cartas` (`id`, `palo`, `valor`) VALUES
(1, 'Oro', 1),
(2, 'Oro', 2),
(3, 'Oro', 3),
(4, 'Oro', 4),
(5, 'Oro', 5),
(6, 'Oro', 6),
(7, 'Oro', 7),
(8, 'Oro', 8),
(9, 'Oro', 9),
(10, 'Oro', 10),
(11, 'Oro', 11),
(12, 'Oro', 12),
(13, 'Espada', 1),
(14, 'Espada', 2),
(15, 'Espada', 3),
(16, 'Espada', 4),
(17, 'Espada', 5),
(18, 'Espada', 6),
(19, 'Espada', 7),
(20, 'Espada', 8),
(21, 'Espada', 9),
(22, 'Espada', 10),
(23, 'Espada', 11),
(24, 'Espada', 12),
(25, 'Basto', 1),
(26, 'Basto', 2),
(27, 'Basto', 3),
(28, 'Basto', 4),
(29, 'Basto', 5),
(30, 'Basto', 6),
(31, 'Basto', 7),
(32, 'Basto', 8),
(33, 'Basto', 9),
(34, 'Basto', 10),
(35, 'Basto', 11),
(36, 'Basto', 12),
(37, 'Copa', 1),
(38, 'Copa', 2),
(39, 'Copa', 3),
(40, 'Copa', 4),
(41, 'Copa', 5),
(42, 'Copa', 6),
(43, 'Copa', 7),
(44, 'Copa', 8),
(45, 'Copa', 9),
(46, 'Copa', 10),
(47, 'Copa', 11),
(48, 'Copa', 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carta_x_partida`
--

DROP TABLE IF EXISTS `carta_x_partida`;
CREATE TABLE IF NOT EXISTS `carta_x_partida` (
  `id_partida` int(11) NOT NULL,
  `id_carta` int(11) NOT NULL,
  KEY `pfk_partida` (`id_partida`),
  KEY `pfk_carta` (`id_carta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partidas`
--

DROP TABLE IF EXISTS `partidas`;
CREATE TABLE IF NOT EXISTS `partidas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `puntaje` int(11) DEFAULT NULL,
  `nombre_ganador` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `carta_x_partida`
--
ALTER TABLE `carta_x_partida`
  ADD CONSTRAINT `pfk_carta` FOREIGN KEY (`id_carta`) REFERENCES `cartas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pfk_partida` FOREIGN KEY (`id_partida`) REFERENCES `partidas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
