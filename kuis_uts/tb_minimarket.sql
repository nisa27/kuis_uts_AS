-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 03, 2019 at 04:11 PM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_minimarket`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_minimarket`
--

CREATE TABLE `tb_minimarket` (
  `id` int(11) NOT NULL,
  `kode` int(4) NOT NULL,
  `nama` varchar(40) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `nohp` int(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_minimarket`
--

INSERT INTO `tb_minimarket` (`id`, `kode`, `nama`, `alamat`, `nohp`) VALUES
(1, 111, 'adijaya', 'karangwuluh', 12),
(2, 112, 'UntungMarket', 'Margapadang', 12),
(3, 113, 'UsahaKita', 'Kalijambe', 12),
(4, 114, 'Toko Tyas', 'Bulakwaru', 12);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_minimarket`
--
ALTER TABLE `tb_minimarket`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_minimarket`
--
ALTER TABLE `tb_minimarket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
