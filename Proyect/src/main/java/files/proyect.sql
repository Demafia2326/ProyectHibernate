-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-12-2019 a las 10:53:41
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.2.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyect`
--
CREATE DATABASE IF NOT EXISTS `proyect` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `proyect`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `num_social` int(11) NOT NULL,
  `domicilio` varchar(75) NOT NULL,
  `telefono` int(9) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `num_social` (`num_social`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colaborador`
--

CREATE TABLE IF NOT EXISTS `colaborador` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(75) NOT NULL,
  `domicilio` varchar(150) NOT NULL,
  `banco` varchar(150) NOT NULL,
  `num_cuenta` int(11) NOT NULL,
  `nif` varchar(9) NOT NULL,
  `telefono` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `codigo` (`codigo`),
  UNIQUE KEY `nif` (`nif`),
  UNIQUE KEY `telefono` (`telefono`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE IF NOT EXISTS `pago` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(4) NOT NULL,
  `concepto` varchar(200) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fecha_pago` timestamp NULL DEFAULT current_timestamp(),
  `nif_colaborador` varchar(9) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `nif_colaborador` (`nif_colaborador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `participan`
--

CREATE TABLE IF NOT EXISTS `participan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nif_colaborador` varchar(9) NOT NULL,
  `cod_proyecto` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nif_colaborador` (`nif_colaborador`),
  KEY `cod_proyecto` (`cod_proyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto`
--

CREATE TABLE IF NOT EXISTS `proyecto` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) DEFAULT NULL,
  `fecha_inicio` timestamp NULL DEFAULT NULL,
  `fecha_fin` timestamp NULL DEFAULT NULL,
  `cuantia` int(11) NOT NULL,
  `cod_cliente` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `cod_cliente` (`cod_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `nif_colabora_nif` FOREIGN KEY (`nif_colaborador`) REFERENCES `colaborador` (`nif`) ON DELETE CASCADE;

--
-- Filtros para la tabla `participan`
--
ALTER TABLE `participan`
  ADD CONSTRAINT `cod_proyecto_cod` FOREIGN KEY (`cod_proyecto`) REFERENCES `proyecto` (`codigo`) ON DELETE CASCADE,
  ADD CONSTRAINT `nif_colab_nif` FOREIGN KEY (`nif_colaborador`) REFERENCES `colaborador` (`nif`);

--
-- Filtros para la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD CONSTRAINT `proyecto_cliente` FOREIGN KEY (`cod_cliente`) REFERENCES `cliente` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
