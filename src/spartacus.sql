-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-05-2017 a las 12:16:08
-- Versión del servidor: 10.1.16-MariaDB
-- Versión de PHP: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `spartacus`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `batalla`
--

CREATE TABLE `batalla` (
  `id` int(9) NOT NULL,
  `perdedorId` int(9) NOT NULL,
  `ganadorId` int(9) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `premio` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `batalla`
--

INSERT INTO `batalla` (`id`, `perdedorId`, `ganadorId`, `fecha`, `premio`) VALUES
(1, 2, 1, '2017-05-28 22:00:00', 50),
(2, 2, 1, '2017-05-28 22:00:00', 80),
(3, 2, 1, '2017-05-28 22:00:00', 30),
(4, 2, 1, '2017-05-28 22:00:00', 10),
(5, 2, 1, '2017-05-28 22:00:00', 10),
(6, 2, 1, '2017-05-28 22:00:00', 20),
(7, 2, 1, '2017-05-28 22:00:00', 10),
(8, 2, 1, '2017-05-28 22:00:00', 150),
(9, 1, 2, '2017-05-28 22:00:00', 30),
(10, 1, 2, '2017-05-28 22:00:00', 10),
(11, 1, 2, '2017-05-28 22:00:00', 0),
(12, 1, 2, '2017-05-28 22:00:00', 15),
(13, 1, 2, '2017-05-28 22:00:00', 35),
(14, 1, 2, '2017-05-29 13:02:48', 25),
(15, 2, 1, '2017-05-29 13:03:37', 25),
(16, 2, 1, '2017-05-29 13:06:40', 45),
(17, 1, 2, '2017-05-29 13:07:25', 25),
(18, 2, 1, '2017-05-29 13:09:45', 25),
(19, 2, 1, '2017-05-29 13:10:17', 45),
(20, 2, 1, '2017-05-29 13:11:24', 55),
(21, 1, 2, '2017-05-29 13:12:04', 15),
(22, 2, 1, '2017-05-29 13:16:00', 55),
(23, 2, 1, '2017-05-29 13:17:05', 135),
(24, 1, 2, '2017-05-29 13:20:17', 25),
(25, 1, 2, '2017-05-29 13:20:41', 25),
(26, 1, 2, '2017-05-29 13:26:03', 65),
(27, 1, 2, '2017-05-29 13:29:05', 25),
(28, 2, 1, '2017-05-29 13:29:50', 25),
(29, 1, 2, '2017-05-29 13:52:33', 5),
(30, 1, 2, '2017-05-29 13:52:53', 15),
(31, 1, 2, '2017-05-29 14:42:44', 55),
(32, 2, 1, '2017-05-29 14:43:23', 35),
(33, 1, 2, '2017-05-30 06:17:11', 15),
(34, 2, 1, '2017-05-30 06:52:28', 95),
(35, 1, 2, '2017-05-30 06:57:42', 15),
(36, 1, 2, '2017-05-30 07:09:31', 15),
(37, 1, 2, '2017-05-30 07:12:00', 25),
(38, 2, 1, '2017-05-30 07:17:09', 35),
(39, 1, 2, '2017-05-30 07:34:19', 35),
(40, 1, 2, '2017-05-30 07:36:45', 15),
(41, 3, 2, '2017-05-30 08:15:57', 25),
(42, 2, 1, '2017-05-30 08:16:24', 65);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gladiadores`
--

CREATE TABLE `gladiadores` (
  `id` int(9) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `precio` int(9) NOT NULL,
  `victorias` int(9) NOT NULL DEFAULT '0',
  `derrotas` int(9) NOT NULL DEFAULT '0',
  `descripcion` varchar(200) NOT NULL,
  `fuerza` int(9) NOT NULL,
  `agilidad` int(9) NOT NULL,
  `vitalidad` int(9) NOT NULL,
  `propietario` int(9) NOT NULL DEFAULT '0',
  `defensa` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `gladiadores`
--

INSERT INTO `gladiadores` (`id`, `nombre`, `precio`, `victorias`, `derrotas`, `descripcion`, `fuerza`, `agilidad`, `vitalidad`, `propietario`, `defensa`) VALUES
(1, 'Victus', 1000, 1, 0, 'Gladiador Común', 10, 10, 7, 0, 13),
(2, 'Victor', 100000, 0, 0, 'BOSS', 50, 50, 50, 3, 50),
(3, 'Antonio', 125, 0, 0, 'El gitanillo', 15, 15, 15, 0, 15),
(4, 'Paquius Gitanus', 1000, 0, 1, 'Cuidado con la cartera.', 1, 27, 1, 0, 1),
(5, 'Juanius', 1000, 0, 0, 'Gladiador Común', 25, 15, 22, 0, 18),
(6, 'Marcus Atilius', 5000, 0, 0, 'Lucha en la arena para pagar sus deudas', 18, 15, 20, 0, 19),
(7, 'Vero', 4000, 0, 0, 'Famoso por su gran combate contra Prisco', 15, 18, 19, 0, 19),
(8, 'Prisco', 4000, 0, 0, 'Famoso por su gran combate contra Vero', 19, 19, 18, 0, 15),
(9, 'Tetraites', 3250, 0, 0, 'Famoso por su gran victoria sobre Prudes', 15, 15, 20, 0, 20),
(10, 'Spiculus', 5000, 0, 0, 'Mantiene gran relación con el emperador Nerón', 21, 13, 17, 0, 17),
(11, 'Carpóforo', 6000, 0, 0, 'Es un bestiari, lucha contra bestias en la arena', 19, 20, 18, 0, 18),
(12, 'Crixo', 9000, 0, 0, 'Brazo derecho de Spartacus', 22, 19, 25, 0, 21),
(13, 'Flamma', 7000, 0, 0, 'Llego a ganar 4 veces el rudis.', 20, 20, 22, 0, 18),
(14, 'Comodo', 2500, 0, 0, 'Acostumbraba a luchar con gladiadores que estaban armados con espadas de madera', 16, 14, 15, 0, 14),
(15, 'Spartacus', 10000, 0, 0, 'Inició una rebelión contra su Lanista Batiato.', 25, 25, 25, 0, 25),
(16, 'Aulus', 1000, 0, 0, 'Gladiador Común', 7, 13, 12, 3, 8),
(17, 'Appius', 1000, 0, 0, 'Gladiador Común', 13, 7, 12, 3, 8),
(19, 'Caius', 1000, 0, 1, 'Gladiador Común', 5, 15, 10, 3, 10),
(20, 'Gnaeus', 1000, 0, 0, 'Gladiador Común', 10, 10, 10, 3, 10),
(21, 'Decimus', 1000, 0, 0, 'Gladiador Común', 10, 15, 5, 0, 15),
(22, 'Kaeso', 1000, 0, 0, 'Gladiador Común', 5, 20, 5, 0, 10),
(23, 'Mamercus', 1000, 0, 0, 'Gladiador Común', 8, 7, 20, 0, 5),
(24, 'Publius', 1000, 0, 0, 'Gladiador Común', 8, 8, 16, 0, 8),
(26, 'Sextus', 1000, 0, 0, 'Gladiador Común', 10, 10, 10, 0, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(10) NOT NULL,
  `login` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `permisos` tinyint(1) NOT NULL DEFAULT '1',
  `saldo` int(9) NOT NULL DEFAULT '1000',
  `victorias` int(9) NOT NULL DEFAULT '0',
  `derrotas` int(9) NOT NULL DEFAULT '0',
  `ratio` float NOT NULL DEFAULT '0',
  `email` varchar(100) NOT NULL,
  `apellidos` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `login`, `pass`, `nombre`, `permisos`, `saldo`, `victorias`, `derrotas`, `ratio`, `email`, `apellidos`) VALUES
(1, 'chochi', '1234', 'Borja', 1, 2005, 0, 0, 0, 'borja370@gmail.com', 'Castera Romero'),
(2, 'Clony', '1', 'Javier', 1, 3960, 0, 0, 0, 'Clony90@gmail.com', 'Velando'),
(3, 'NPC', '654321', 'NPC', 1, 1000, 0, 0, 0, 'NPC@hotmail.com', 'NPC');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `batalla`
--
ALTER TABLE `batalla`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `gladiadores`
--
ALTER TABLE `gladiadores`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `batalla`
--
ALTER TABLE `batalla`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
--
-- AUTO_INCREMENT de la tabla `gladiadores`
--
ALTER TABLE `gladiadores`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
