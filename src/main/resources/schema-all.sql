DROP TABLE people IF EXISTS;

CREATE TABLE people  (
    people_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    identifier BIGINT,
    first_name VARCHAR(20),
    last_name VARCHAR(20)
);