-- ユーザーの作成
CREATE USER api;

-- DBの作成
CREATE DATABASE users;

-- ユーザーにDBの権限をまとめて付与
GRANT ALL PRIVILEGES ON DATABASE users TO api;

-- DBを切り替え
\c users

DROP TABLE IF EXISTS users;

-- テーブルを作成
CREATE TABLE users (
  ID SERIAL NOT NULL,
  Name char(35) NOT NULL DEFAULT '',
  CountryCode char(3) NOT NULL DEFAULT '',
  PRIMARY KEY (ID)
);

-- データの挿入
INSERT INTO users (Name, CountryCode) VALUES ('Saaya', 'ARE');
INSERT INTO users (Name, CountryCode) VALUES ('Masami', 'AUS');
INSERT INTO users (Name, CountryCode) VALUES ('Masami', 'AUS');
INSERT INTO users (Name, CountryCode) VALUES ('Hiroto', 'CAN');
INSERT INTO users (Name, CountryCode) VALUES ('Masanori', 'CHN');
INSERT INTO users (Name, CountryCode) VALUES ('Toshio', 'CHN');
INSERT INTO users (Name, CountryCode) VALUES ('Haruka', 'GBR');
INSERT INTO users (Name, CountryCode) VALUES ('Keishi', 'AUS');
INSERT INTO users (Name, CountryCode) VALUES ('Haruhisa', 'NCL');
INSERT INTO users (Name, CountryCode) VALUES ('Hisakichi', 'BOL');
INSERT INTO users (Name, CountryCode) VALUES ('Akiko', 'CCK');
INSERT INTO users (Name, CountryCode) VALUES ('Yasufumi', 'DNK');
INSERT INTO users (Name, CountryCode) VALUES ('Hisashi', 'GEO');
INSERT INTO users (Name, CountryCode) VALUES ('Haruhisa', 'HKG');
INSERT INTO users (Name, CountryCode) VALUES ('Teruo', 'AUT');
INSERT INTO users (Name, CountryCode) VALUES ('Haru', 'JPN');
INSERT INTO users (Name, CountryCode) VALUES ('Mieko', 'DEU');
INSERT INTO users (Name, CountryCode) VALUES ('Chieko', 'MCO');
INSERT INTO users (Name, CountryCode) VALUES ('Toshinobu', 'RUS');
INSERT INTO users (Name, CountryCode) VALUES ('Hiroyuki', 'IRL');
INSERT INTO users (Name, CountryCode) VALUES ('Aki', 'ITA');
INSERT INTO users (Name, CountryCode) VALUES ('Hiroshi', 'JPN');
INSERT INTO users (Name, CountryCode) VALUES ('Kaho', 'FRA');
INSERT INTO users (Name, CountryCode) VALUES ('Tadaharu', 'SWE');
INSERT INTO users (Name, CountryCode) VALUES ('Kouji', 'IND');
INSERT INTO users (Name, CountryCode) VALUES ('Masayuki', 'TWN');
INSERT INTO users (Name, CountryCode) VALUES ('Saya', 'SWZ');
INSERT INTO users (Name, CountryCode) VALUES ('Shigeo', 'PER');
INSERT INTO users (Name, CountryCode) VALUES ('Sakura', 'SMR');
INSERT INTO users (Name, CountryCode) VALUES ('Yasuko', 'CMR');
INSERT INTO users (Name, CountryCode) VALUES ('Nagisa', 'USA');