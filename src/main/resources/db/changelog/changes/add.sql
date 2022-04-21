--liquibase formatted sql
--changeset <rommelua>:<create-manufacturers-table>
CREATE TABLE IF NOT EXISTS manufacturers
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY
        CONSTRAINT manufacturers_pkey
            PRIMARY KEY,
    name VARCHAR(255)
);

ALTER TABLE manufacturers
    OWNER TO postgres;

CREATE TABLE IF NOT EXISTS phones
(
    id              BIGINT GENERATED BY DEFAULT AS IDENTITY
        CONSTRAINT phones_pkey
            PRIMARY KEY,
    price           NUMERIC(19, 2),
    title           VARCHAR(255),
    manufacturer_id BIGINT
        CONSTRAINT fkd0h2crrsjb0qkxerxh6n4gp21
            REFERENCES manufacturers
);

ALTER TABLE phones
    OWNER TO postgres;

INSERT INTO manufacturers (name) VALUES
       ('SAMSUNG'), ('APPLE');

INSERT INTO phones (price, title, manufacturer_id) VALUES
    (10000, 'Galaxy S10', 1),
    (11000, 'Galaxy S20', 1),
    (12000, 'Galaxy S20fe', 1),
    (13000, 'Galaxy S21', 1),
    (5000, 'iPhone X', 2),
    (6000, 'iPhone 11', 2),
    (15000, 'iPhone 12', 2);
