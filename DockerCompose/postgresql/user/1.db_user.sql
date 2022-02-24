-- DBの作成
CREATE DATABASE usersdb;

-- スキーマの作成
CREATE SCHEMA userschema;

-- スキーマ検索パスの変更
SET search_path TO userschema, public;

-- ユーザーの作成
CREATE USER api WITH PASSWORD 'password';

-- ユーザーに権限を付与
GRANT ALL PRIVILEGES ON DATABASE usersdb TO api;
GRANT ALL PRIVILEGES ON SCHEMA userschema TO api;

-- テーブルを作成
CREATE TABLE userschema.users (
  ID SERIAL NOT NULL,
  Name char(35) NOT NULL DEFAULT '',
  CountryCode char(3) NOT NULL DEFAULT '',
  PRIMARY KEY (ID)
);

-- データの挿入
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Saaya', 'ARE');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Masami', 'AUS');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Masami', 'AUS');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Hiroto', 'CAN');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Masanori', 'CHN');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Toshio', 'CHN');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Haruka', 'GBR');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Keishi', 'AUS');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Haruhisa', 'NCL');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Hisakichi', 'BOL');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Akiko', 'CCK');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Yasufumi', 'DNK');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Hisashi', 'GEO');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Haruhisa', 'HKG');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Teruo', 'AUT');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Haru', 'JPN');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Mieko', 'DEU');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Chieko', 'MCO');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Toshinobu', 'RUS');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Hiroyuki', 'IRL');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Aki', 'ITA');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Hiroshi', 'JPN');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Kaho', 'FRA');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Tadaharu', 'SWE');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Kouji', 'IND');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Masayuki', 'TWN');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Saya', 'SWZ');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Shigeo', 'PER');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Sakura', 'SMR');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Yasuko', 'CMR');
INSERT INTO userschema.users (Name, CountryCode) VALUES ('Nagisa', 'USA');
