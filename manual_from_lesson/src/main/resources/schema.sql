--create schema if not exists my_schema;
--use my_schema;
--
--CREATE TABLE IF NOT EXISTS animal (
--    id   INTEGER  NOT NULL AUTO_INCREMENT,
--    name VARCHAR(128) NOT NULL,
--    PRIMARY KEY (id)
--);


CREATE TABLE IF NOT EXISTS animal (
    id serial NOT NULL,
    name VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);