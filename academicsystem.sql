-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 29, 2023 at 03:40 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `academicsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `nama`, `email`, `password`) VALUES
(1, 'Rico Mesias Tamba', 'rico@gmail.com', '123456'),
(2, 'Dennis Salomo Angelos', 'dennis@gmail.com', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `id_class` int(11) NOT NULL,
  `class_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id_class`, `class_name`) VALUES
(1, 'Nama Course yang Diperbarui'),
(2, '3SE2'),
(3, '3SE3'),
(4, '3SE4'),
(5, '3SE5'),
(6, '3SE5'),
(7, 'Nama Course Baru'),
(8, '3ISA1'),
(9, '3ISA1'),
(11, '3ISA1'),
(13, '3ISA1'),
(14, '3ISA1'),
(15, '3ISA1'),
(16, '3ISA1'),
(17, '3ISA1'),
(18, '3ISA1'),
(19, '3ISA1'),
(20, '3ISA1'),
(21, '3ISA1'),
(22, '3ISA1'),
(23, '3ISA1'),
(24, '3ISA1'),
(25, '3ISA1'),
(26, '3ISA1'),
(27, '3ISA1'),
(28, '3ISA1'),
(29, '3ISA1'),
(30, '3ISA1'),
(31, '3ISA1'),
(32, '3ISA1'),
(33, '3ISA1'),
(34, '3ISA1'),
(35, '3ISA1'),
(36, '3ISA1'),
(37, '3ISA1'),
(38, '3ISA1'),
(39, '3ISA1'),
(40, '3ISA1'),
(41, '3ISA1'),
(42, '3ISA11'),
(43, '3ISA11');

-- --------------------------------------------------------

--
-- Table structure for table `lecturer`
--

CREATE TABLE `lecturer` (
  `id_lecturer` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `lecturer`
--

INSERT INTO `lecturer` (`id_lecturer`, `name`, `email`, `password`) VALUES
(15, 'RICO MESIAS TAMBA', 'rricomesias@gmail.com', '223'),
(16, 'RMN', NULL, NULL),
(18, 'RZ', 'RZ@gmail.com', '1234'),
(20, 'RZ', 'RZ@gmail.com', '1234'),
(21, 'RZ', 'RZ@gmail.com', '1234'),
(22, 'RZ', 'RZ@gmail.com', '1234'),
(23, 'RZ', 'RZ@gmail.com', '1234'),
(24, 'RZ', 'RZ@gmail.com', '1234'),
(25, 'RZ', 'RZ@gmail.com', '1234'),
(26, 'RZ', 'RZ@gmail.com', '1234'),
(27, 'RZ', 'RZ@gmail.com', '1234'),
(28, 'RZ', 'RZ@gmail.com', '1234'),
(29, 'RZ', 'RZ@gmail.com', '1234'),
(30, 'RZ', 'RZ@gmail.com', '1234'),
(31, 'RZ', 'RZ@gmail.com', '1234'),
(32, 'RZ', 'RZ@gmail.com', '1234'),
(33, 'RZ', 'RZ@gmail.com', '1234'),
(34, 'RZ', 'RZ@gmail.com', '1234'),
(35, 'RZ', 'RZ@gmail.com', '1234'),
(36, 'RZ', 'RZ@gmail.com', '1234'),
(37, 'RZ', 'RZ@gmail.com', '1234'),
(38, 'RZ', 'RZ@gmail.com', '1234'),
(39, 'RZ', 'RZ@gmail.com', '1234'),
(40, 'RZ', 'RZ@gmail.com', '1234'),
(41, 'RZ', 'RZ@gmail.com', '1234'),
(42, 'RZ', 'RZ@gmail.com', '1234'),
(43, 'RZ', 'RZ@gmail.com', '1234'),
(44, 'RZ', 'RZ@gmail.com', '1234'),
(45, 'RZ', 'RZ@gmail.com', '1234'),
(46, 'RZ', 'RZ@gmail.com', '1234'),
(47, 'RZ', 'RZ@gmail.com', '1234'),
(48, 'RZ', 'RZ@gmail.com', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `lecturersubject`
--

CREATE TABLE `lecturersubject` (
  `id` int(11) NOT NULL,
  `id_lecturer` int(11) DEFAULT NULL,
  `id_subject` int(11) DEFAULT NULL,
  `tahun_ajaran` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `lecturersubject`
--

INSERT INTO `lecturersubject` (`id`, `id_lecturer`, `id_subject`, `tahun_ajaran`) VALUES
(2, 16, 1, '2023'),
(71, 15, 3, '2023'),
(72, 15, 1, '2023'),
(73, 16, 3, '2023'),
(74, 16, 4, '2023'),
(75, 16, 122, '2023'),
(76, 15, 122, '2023');

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `id_schedule` int(11) NOT NULL,
  `due_time` varchar(19) DEFAULT NULL,
  `start_time` varchar(19) DEFAULT NULL,
  `id_class` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `schedule`
--

INSERT INTO `schedule` (`id_schedule`, `due_time`, `start_time`, `id_class`) VALUES
(21, 'Monday, 08:00', 'Monday, 09:00', 8),
(22, 'Monday, 10:00', 'Monday,12:00', 1),
(23, 'Tuesday, 08:00', 'Tuesday, 10:00', 2),
(24, 'Wednesday, 14:00', 'Tuesday, 12:00', 2);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id_student` int(11) NOT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `id_class` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id_student`, `nama`, `email`, `password`, `id_class`) VALUES
(1, 'Dennis Salomo', 'dennis@gmail.com', '123456', 1),
(2, 'Rico', 'felixaukharaya@gmail.com', '123', 1),
(6, 'Rico Mesias', 'fenkz@gmail.com', '123', 2),
(7, 'Updated Name', 'rico@gmail.com', 'newpassword', 2),
(8, 'Ayam', 'ayam@gmail.com', '12344', 1),
(9, '#', '333@gmail.com', '', 1),
(10, '', '', '', 1),
(11, 'dwwf', 'wcw', '2qc', 1),
(12, 'Denok', 'dekino@gmail.com', '12345', 4),
(20, 'Dennok', 'denok@gmail.com', 'g fjhf', 1),
(21, 'Dennok', 'denok@gmail.comhg', '', 1),
(22, 'deniio', 'dennio@gmail.com', '12345', 11),
(23, 'deniio', 'dennio@gmail.comr', '', 11);

-- --------------------------------------------------------

--
-- Table structure for table `studentsubject`
--

CREATE TABLE `studentsubject` (
  `id` int(11) NOT NULL,
  `id_student` int(11) DEFAULT NULL,
  `id_subject` int(11) DEFAULT NULL,
  `tahun_ajaran` varchar(10) DEFAULT NULL,
  `semester` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `studentsubject`
--

INSERT INTO `studentsubject` (`id`, `id_student`, `id_subject`, `tahun_ajaran`, `semester`) VALUES
(1, 7, 2, '2023', 2),
(2, 7, 1, '2023', 2);

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `id_subject` int(11) NOT NULL,
  `subject_name` varchar(255) DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  `id_schedule` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`id_subject`, `subject_name`, `credit`, `id_schedule`) VALUES
(1, '', NULL, 21),
(2, 'Artificial Intelligence', 3, 22),
(3, 'Linear Algebra', 2, 23),
(4, 'Updated Subject Name', 2, 24),
(120, '', NULL, 21),
(121, 'Discrete Math', 2, 23),
(122, 'Ayam', 3, 23),
(123, 'Ayam', 3, 23),
(124, 'Ayam', 3, 23);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id_class`);

--
-- Indexes for table `lecturer`
--
ALTER TABLE `lecturer`
  ADD PRIMARY KEY (`id_lecturer`);

--
-- Indexes for table `lecturersubject`
--
ALTER TABLE `lecturersubject`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_lecturer` (`id_lecturer`),
  ADD KEY `id_subject` (`id_subject`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`id_schedule`),
  ADD KEY `id_class` (`id_class`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id_student`),
  ADD KEY `id_class` (`id_class`);

--
-- Indexes for table `studentsubject`
--
ALTER TABLE `studentsubject`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_student` (`id_student`),
  ADD KEY `id_subject` (`id_subject`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id_subject`),
  ADD KEY `id_schedule` (`id_schedule`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `id_class` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `lecturer`
--
ALTER TABLE `lecturer`
  MODIFY `id_lecturer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT for table `lecturersubject`
--
ALTER TABLE `lecturersubject`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77;

--
-- AUTO_INCREMENT for table `schedule`
--
ALTER TABLE `schedule`
  MODIFY `id_schedule` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id_student` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=135;

--
-- AUTO_INCREMENT for table `studentsubject`
--
ALTER TABLE `studentsubject`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=89;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `id_subject` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=146;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `lecturersubject`
--
ALTER TABLE `lecturersubject`
  ADD CONSTRAINT `lecturersubject_ibfk_1` FOREIGN KEY (`id_lecturer`) REFERENCES `lecturer` (`id_lecturer`),
  ADD CONSTRAINT `lecturersubject_ibfk_2` FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id_subject`);

--
-- Constraints for table `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`id_class`) REFERENCES `course` (`id_class`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`id_class`) REFERENCES `course` (`id_class`);

--
-- Constraints for table `studentsubject`
--
ALTER TABLE `studentsubject`
  ADD CONSTRAINT `studentsubject_ibfk_1` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`),
  ADD CONSTRAINT `studentsubject_ibfk_2` FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id_subject`);

--
-- Constraints for table `subject`
--
ALTER TABLE `subject`
  ADD CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`id_schedule`) REFERENCES `schedule` (`id_schedule`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
