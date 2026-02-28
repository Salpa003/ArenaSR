--liquibase formatted sql

--changeset salpa:1
CREATE TABLE users
(
    id       BIGSERIAL PRIMARY KEY,
    username VARCHAR(32) UNIQUE NOT NULL,
    password VARCHAR(32)        NOT NULL,
    gold     DOUBLE PRECISION DEFAULT 0.0,
    wins     INTEGER          DEFAULT 0,
    losses   INTEGER          DEFAULT 0
);