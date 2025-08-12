-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: mysql-vipulpaighan.alwaysdata.net
-- Generation Time: Aug 12, 2025 at 06:32 PM
-- Server version: 10.11.13-MariaDB
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vipulpaighan_employee_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `emp_id` int(11) NOT NULL,
  `emp_name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phoneno` varchar(15) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`emp_id`, `emp_name`, `email`, `phoneno`, `city`, `gender`, `password`) VALUES
(2, 'Rohan', 'rohan@gmail.com', '09898989898', 'Nagpur', 'Male', '$2a$10$MdZdf/FBIGeRUqij0tL0IOI5ueiu3LR0MUsglellXLrGMUlVjwbAi'),
(4, 'Lucky', 'lucky@gmail.com', '9999999999', 'Nagpur', 'Male', '$2a$10$TSHjrnqYV6iUVXM1az4jwudEPxLNaIMZJ5TKIHTixP.iUVt.t9nEm'),
(5, 'Sumit', 'sumitthakre@gmail.com', '9921163483', 'Nagpur', 'Male', '$2a$10$Ed.E8/K2iCMqhemLwGTyDOfVlMdTjdXddUV9igONlOzhEoWEaTwIS'),
(6, 'ROHIT', 'rohitnkam15@gmail.com', '9158453792', 'Nagpur', 'Male', '$2a$10$IvKWLJE0UUilVGfChi3LteRcOt6bvyDRMT2cp4drLKCsIZ0BkkB9W');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`emp_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `emp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
