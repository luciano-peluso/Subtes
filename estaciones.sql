-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-10-2023 a las 17:19:11
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `subte`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estaciones`
--

CREATE TABLE `estaciones` (
  `estacion` varchar(30) DEFAULT NULL,
  `estacion_siguiente` varchar(32) NOT NULL,
  `combinacion` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `estaciones`
--

INSERT INTO `estaciones` (`estacion`, `estacion_siguiente`, `combinacion`) VALUES
('J.M. ROSAS', 'ECHEVERRIA', NULL),
('ECHEVERRIA', 'DE LOS INCAS', NULL),
('DE LOS INCAS', 'TRONADOR', NULL),
('TRONADOR', 'FEDERICO LACROZE', NULL),
('FEDERICO LACROZE', 'DORREGO', NULL),
('DORREGO', 'MALABIA', NULL),
('MALABIA', 'ANGEL GALLARDO', NULL),
('ANGEL GALLARDO', 'MEDRANO', NULL),
('MEDRANO', 'CARLOS GARDEL', NULL),
('CARLOS GARDEL', 'PUEYRREDON', NULL),
('PUEYRREDON', 'PASTEUR', 'H'),
('PASTEUR', 'CALLAO', NULL),
('CALLAO', 'URUGUAY', NULL),
('URUGUAY', 'CARLOS PELLEGRINI', NULL),
('CARLOS PELLEGRINI', 'FLORIDA', 'B y C'),
('FLORIDA', 'L.N. ALEM', NULL),
('L.N. ALEM', '', 'E');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
