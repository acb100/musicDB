DROP DATABASE IF EXISTS musicdatabase;
CREATE DATABASE musicdatabase;

USE musicdatabase;

CREATE TABLE album
(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
artist_name VARCHAR(45) DEFAULT NULL,
album_title VARCHAR(45) DEFAULT NULL,
song_name VARCHAR(45) DEFAULT NULL,
release_year INT DEFAULT NULL
);

INSERT INTO album VALUES
('1', 'Kanye West', 'Yeezus',  'I Am A God', '2013');