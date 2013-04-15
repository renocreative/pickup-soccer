-- PickUp Soccer Application Tables

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS pickupSoccer;
CREATE SCHEMA pickupSoccer;
USE pickupSoccer;

--
-- Table structure for table `User`
--


CREATE TABLE UserProfile (
	userProfileID INT NOT NULL AUTO_INCREMENT,
	firstName VARCHAR(100) NOT NULL,
	lastName VARCHAR(100) NOT NULL,
	photo BLOB,
	PRIMARY KEY (userProfileID)
);


CREATE TABLE Location (
	locationID INT NOT NULL AUTO_INCREMENT,
	fieldName VARCHAR(100) NOT NULL,
	fieldDescription VARCHAR(100) NOT NULL,
	fieldAddress VARCHAR(100) NOT NULL,
	fieldPhoto BLOB,
	PRIMARY KEY (locationID)
);

CREATE TABLE User (
	username VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL,
	password VARCHAR(100) NOT NULL,
	userProfileID INT,
	PRIMARY KEY (username),
	CONSTRAINT fk_user_profile FOREIGN KEY (userProfileID) REFERENCES UserProfile (userProfileID) ON DELETE RESTRICT ON UPDATE CASCADE
);


CREATE TABLE Game (
	gameID INT NOT NULL AUTO_INCREMENT,
	gameStatus INT,
	gameState INT,
	dateHeure DATETIME,
	maxPlayers INT,
	skillLevel VARCHAR(100),
	fieldCost FLOAT,
	comments VARCHAR(100),
	username VARCHAR(100),
	locationID INT ,
	recurrentGameID INT,
	PRIMARY KEY (gameID),
        CONSTRAINT fk_game_recurrent FOREIGN KEY(recurrentGameID) REFERENCES RecurrentGame (recurrentGameID)  ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT fk_game_username FOREIGN KEY(username) REFERENCES User (username)  ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT fk_game_location FOREIGN KEY  (locationID) REFERENCES Location (locationID)  ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE RecurrentGame (
	recurrentGameID INT,
	frequency INT,
	lastDatePlayed DATETIME,
	PRIMARY KEY (recurrentGameID)
);




