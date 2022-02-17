CREATE DATABASE `user` DEFAULT CHARACTER SET utf8mb4;

USE `user`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `users` (
  `ID` int AUTO_INCREMENT,
  `LastName` char(35) NOT NULL DEFAULT '',
  `FirstName` char(35) NOT NULL DEFAULT '',
  `CountryCode` char(35) NOT NULL DEFAULT '',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

set autocommit=0;
INSERT INTO `users` (
  `LastName`,
  `FirstName`,
  `CountryCode`
) VALUES
  ('Shinohara','Saaya', 'ARE'),
  ('Hosaka', 'Masami', 'AUS'),
  ('Hosaka', 'Masami', 'AUS'),
  ('Yoshiwara', 'Hiroto', 'CAN'),
  ('Kamino', 'Masanori', 'CHN'),
  ('Hamamoto', 'Toshio', 'CHN'),
  ('Ooshima', 'Haruka', 'GBR'),
  ('Suga', 'Keishi', 'AUS'),
  ('Imoto', 'Haruhisa', 'NCL'),
  ('Oohashi', 'Hisakichi', 'BOL'),
  ('Fukumoto', 'Akiko', 'CCK'),
  ('Yano', 'Yasufumi', 'DNK'),
  ('Hashimoto', 'Hisashi', 'GEO'),
  ('Ariga', 'Haruhisa', 'HKG'),
  ('Akagi', 'Teruo', 'AUT'),
  ('Kasai', 'Haru', 'JPN'),
  ('Kagawa', 'Mieko', 'DEU'),
  ('Kodama', 'Chieko', 'MCO'),
  ('Katsuta', 'Toshinobu', 'RUS'),
  ('Soga', 'Hiroyuki', 'IRL'),
  ('Kanazawa', 'Aki', 'ITA'),
  ('Uesugi', 'Hiroshi', 'JPN'),
  ('Takita', 'Kaho', 'FRA'),
  ('Miyagi', 'Tadaharu', 'SWE'),
  ('Hiratsuka', 'Kouji', 'IND'),
  ('Yokomizo', 'Masayuki', 'TWN'),
  ('Oyamada', 'Saya', 'SWZ'),
  ('Kawai', 'Shigeo', 'PER'),
  ('Abe', 'Sakura', 'SMR'),
  ('Hayashida', 'Yasuko', 'CMR'),
  ('Takemoto', 'Nagisa', 'USA')
;
commit;
