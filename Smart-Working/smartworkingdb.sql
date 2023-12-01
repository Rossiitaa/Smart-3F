-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Nov 24, 2023 alle 09:43
-- Versione del server: 10.4.28-MariaDB
-- Versione PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smartworkingdb`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `state`
--

CREATE TABLE `state` (
  `state_id` bigint(20) NOT NULL,
  `state` enum('ASSENZA','SMART_WORKING') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `state`
--

INSERT INTO `state` (`state_id`, `state`) VALUES
(1, 'ASSENZA'),
(2, 'SMART_WORKING');

-- --------------------------------------------------------

--
-- Struttura della tabella `state_seq`
--

CREATE TABLE `state_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `state_seq`
--

INSERT INTO `state_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Struttura della tabella `user`
--

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `user`
--

INSERT INTO `user` (`user_id`, `firstname`, `lastname`) VALUES
(1, 'Alessio', 'Bellone'),
(2, 'Rosario', 'Scuotto'),
(3, 'Franco', 'Parisi'),
(4, 'Stefano', 'Leva');

-- --------------------------------------------------------

--
-- Struttura della tabella `user_seq`
--

CREATE TABLE `user_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `user_seq`
--

INSERT INTO `user_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Struttura della tabella `user_state`
--

CREATE TABLE `user_state` (
  `date` date NOT NULL,
  `state_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `ore` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `user_state`
--

INSERT INTO `user_state` (`date`, `state_id`, `user_id`, `ore`) VALUES
('2023-11-24', 2, 1, 8),
('2023-11-24', 2, 4, 8),
('2023-11-25', 1, 3, 8),
('2023-11-25', 2, 1, 8),
('2023-11-26', 1, 4, 8),
('2023-11-27', 1, 2, 5),
('2023-11-27', 1, 4, 8);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `state`
--
ALTER TABLE `state`
  ADD PRIMARY KEY (`state_id`);

--
-- Indici per le tabelle `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indici per le tabelle `user_state`
--
ALTER TABLE `user_state`
  ADD PRIMARY KEY (`date`,`state_id`,`user_id`),
  ADD KEY `FKnq7lqe2q7b8dnw9du88cp8t0n` (`state_id`),
  ADD KEY `FKfo8ndsdie8fajd20rm9sknypp` (`user_id`);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `user_state`
--
ALTER TABLE `user_state`
  ADD CONSTRAINT `FKfo8ndsdie8fajd20rm9sknypp` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `FKnq7lqe2q7b8dnw9du88cp8t0n` FOREIGN KEY (`state_id`) REFERENCES `state` (`state_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
