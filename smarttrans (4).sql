-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 19 mai 2019 à 00:34
-- Version du serveur :  5.7.21
-- Version de PHP :  5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `smarttrans`
--

-- --------------------------------------------------------

--
-- Structure de la table `abonne`
--

DROP TABLE IF EXISTS `abonne`;
CREATE TABLE IF NOT EXISTS `abonne` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nom` varchar(11) NOT NULL,
  `prenom` varchar(11) NOT NULL,
  `date_naissance` varchar(255) NOT NULL,
  `cin` varchar(11) NOT NULL,
  `addresse` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `abonne`
--

INSERT INTO `abonne` (`id`, `username`, `password`, `nom`, `prenom`, `date_naissance`, `cin`, `addresse`) VALUES
(23, 'Khalil', 'Khalil', 'Khalil', 'Khalil', '2019-05-01 00:00:00', '12345678', 'aaaa'),
(24, 'aaaaa', 'aaaaaaaaaaa', 'aaaaa', 'aaaaa', '2019-05-01 00:00:00', '11111111', 'aaaaaa');

-- --------------------------------------------------------

--
-- Structure de la table `abonnement`
--

DROP TABLE IF EXISTS `abonnement`;
CREATE TABLE IF NOT EXISTS `abonnement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_achat` varchar(255) NOT NULL,
  `date_expiration` varchar(255) NOT NULL,
  `id_abonne` int(11) DEFAULT NULL,
  `id_tarif` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_abonne` (`id_abonne`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `abonnement`
--

INSERT INTO `abonnement` (`id`, `date_achat`, `date_expiration`, `id_abonne`, `id_tarif`) VALUES
(8, '2019-04-06', '2020-03-27', 15, 12),
(9, '2019-04-06', '2020-04-06', 15, 12),
(10, '2019-04-13', '2020-04-13', 21, 18),
(11, '2019-04-13', '2019-10-13', 21, 18);

-- --------------------------------------------------------

--
-- Structure de la table `bus`
--

DROP TABLE IF EXISTS `bus`;
CREATE TABLE IF NOT EXISTS `bus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model` varchar(500) NOT NULL,
  `kilometrage` double NOT NULL,
  `matricule` varchar(255) DEFAULT NULL,
  `nbr_places` int(11) DEFAULT NULL,
  `date_mise_circulation` varchar(255) DEFAULT NULL,
  `date_derniere_visite` varchar(255) DEFAULT NULL,
  `date_maintenance` varchar(255) DEFAULT NULL,
  `id_ligne` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_ligne` (`id_ligne`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `chauffeur`
--

DROP TABLE IF EXISTS `chauffeur`;
CREATE TABLE IF NOT EXISTS `chauffeur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `date_naissance` varchar(255) NOT NULL,
  `cin` varchar(8) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `nbTacheTotal` int(11) NOT NULL,
  `nbTacheParJour` int(11) NOT NULL,
  `dispo` int(11) NOT NULL,
  `nomLigne` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `chauffeur`
--

INSERT INTO `chauffeur` (`id`, `username`, `password`, `nom`, `prenom`, `date_naissance`, `cin`, `adresse`, `nbTacheTotal`, `nbTacheParJour`, `dispo`, `nomLigne`) VALUES
(2, 'ghazi', 'ghazi', 'ghazi', 'ghazi', '2019-05-02 00:00:00', '12345678', 'aaaa', 0, 0, 1, 'Ligne Ghazi2 , moyentransport= Train');

-- --------------------------------------------------------

--
-- Structure de la table `chefstation`
--

DROP TABLE IF EXISTS `chefstation`;
CREATE TABLE IF NOT EXISTS `chefstation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `date_naissance` varchar(255) NOT NULL,
  `cin` varchar(8) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `nomLigne` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `chefstation`
--

INSERT INTO `chefstation` (`id`, `username`, `password`, `nom`, `prenom`, `date_naissance`, `cin`, `adresse`, `nomLigne`) VALUES
(2, 'khalil', 'khalil123', 'khalil', 'khalil', '2019-04-30', '12345678', 'aaaa', 'Ligne AA2D2dsq , moyentransport= Bus');

-- --------------------------------------------------------

--
-- Structure de la table `ligne`
--

DROP TABLE IF EXISTS `ligne`;
CREATE TABLE IF NOT EXISTS `ligne` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `MoyenTransport` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=75 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ligne`
--

INSERT INTO `ligne` (`id`, `nom`, `MoyenTransport`) VALUES
(59, 'AA2D2dsq', 'Bus'),
(56, 'AA2D', 'Bus'),
(55, 'Ghazi2', 'Train'),
(54, 'AA2D', 'Train'),
(53, 'AA2D', 'Train'),
(69, 'AA2D', 'Train'),
(70, '55', 'Train'),
(74, 'dqsq', 'Train'),
(73, 'L1-2D', 'Train'),
(72, '12312', 'Train'),
(71, '12312', 'Train'),
(61, 'AA2D', 'Bus'),
(52, 'AA2D', 'Train'),
(50, 'AA2D', 'Train');

-- --------------------------------------------------------

--
-- Structure de la table `lignesparabonnement`
--

DROP TABLE IF EXISTS `lignesparabonnement`;
CREATE TABLE IF NOT EXISTS `lignesparabonnement` (
  `id_ligne` int(11) NOT NULL,
  `id_abonnement` int(11) NOT NULL,
  KEY `id_ligne` (`id_ligne`),
  KEY `id_abonnement` (`id_abonnement`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `lignestations`
--

DROP TABLE IF EXISTS `lignestations`;
CREATE TABLE IF NOT EXISTS `lignestations` (
  `id_ligne` int(11) NOT NULL,
  `id_station` int(11) NOT NULL,
  KEY `FK_ligne` (`id_ligne`),
  KEY `FK_station` (`id_station`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `metro`
--

DROP TABLE IF EXISTS `metro`;
CREATE TABLE IF NOT EXISTS `metro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(255) NOT NULL,
  `matricule` varchar(255) DEFAULT NULL,
  `nbr_places` int(11) DEFAULT NULL,
  `date_mise_circulation` varchar(255) DEFAULT NULL,
  `date_derniere_visite` varchar(255) DEFAULT NULL,
  `date_maintenance` varchar(255) DEFAULT NULL,
  `id_ligne` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_ligne` (`id_ligne`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tarif` double NOT NULL,
  `id_ligne` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_ligne` (`id_ligne`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `station`
--

DROP TABLE IF EXISTS `station`;
CREATE TABLE IF NOT EXISTS `station` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `longitude` double NOT NULL,
  `latitude` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `station`
--

INSERT INTO `station` (`id`, `nom`, `longitude`, `latitude`) VALUES
(1, 'Kram', 2515315.22, 525154.15),
(2, 'Khaznadar', 2515315.22, 525154.15),
(3, 'Aouina', 2515315.22, 525154.15),
(4, 'Centre ville', 2515315.22, 525154.15);

-- --------------------------------------------------------

--
-- Structure de la table `tache`
--

DROP TABLE IF EXISTS `tache`;
CREATE TABLE IF NOT EXISTS `tache` (
  `id_tache` int(11) NOT NULL AUTO_INCREMENT,
  `id_chauffeur` int(11) NOT NULL,
  `id_chef_station` int(11) NOT NULL,
  `id_voyage` int(11) NOT NULL,
  PRIMARY KEY (`id_tache`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tache`
--

INSERT INTO `tache` (`id_tache`, `id_chauffeur`, `id_chef_station`, `id_voyage`) VALUES
(21, 2, 10, 2);

-- --------------------------------------------------------

--
-- Structure de la table `tarif`
--

DROP TABLE IF EXISTS `tarif`;
CREATE TABLE IF NOT EXISTS `tarif` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tarif` double NOT NULL,
  `id_ligne` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_ligne` (`id_ligne`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tarif`
--

INSERT INTO `tarif` (`id`, `tarif`, `id_ligne`) VALUES
(18, 45, 2),
(19, 100, 7),
(20, 70, 6);

-- --------------------------------------------------------

--
-- Structure de la table `trafic`
--

DROP TABLE IF EXISTS `trafic`;
CREATE TABLE IF NOT EXISTS `trafic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `ligne_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ligne_id` (`ligne_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `train`
--

DROP TABLE IF EXISTS `train`;
CREATE TABLE IF NOT EXISTS `train` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nb_wagon` int(11) NOT NULL,
  `matricule` varchar(255) DEFAULT NULL,
  `nbr_places` int(11) DEFAULT NULL,
  `date_mise_circulation` varchar(255) DEFAULT NULL,
  `date_derniere_visite` varchar(255) DEFAULT NULL,
  `date_maintenance` varchar(255) DEFAULT NULL,
  `id_ligne` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_ligne` (`id_ligne`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `numero` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `mail`, `numero`, `role`) VALUES
(1, 'ghazi', 'ghazi', 'ghazi.selma@esprit.tn', '23347048', 'chauffeur'),
(2, 'khalil', 'khalil123', 'khalil.benmayassa@esprit.tn', '23347048', 'chef'),
(3, 'admin', 'admin', '', '23347048', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `voyage`
--

DROP TABLE IF EXISTS `voyage`;
CREATE TABLE IF NOT EXISTS `voyage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  `heure_depart` datetime NOT NULL,
  `heure_arrive` datetime NOT NULL,
  `destination_depart` varchar(500) NOT NULL,
  `destination_arrive` varchar(500) NOT NULL,
  `id_ligne` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `voyage`
--

INSERT INTO `voyage` (`id`, `type`, `heure_depart`, `heure_arrive`, `destination_depart`, `destination_arrive`, `id_ligne`) VALUES
(2, 'Cotidien', '2019-05-11 07:15:00', '2019-05-11 08:00:00', 'Manouba', 'Passage', 56);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
