DROP TABLE human IF EXISTS;

CREATE TABLE human  (
    human_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    identifier BIGINT,
    first_name VARCHAR(20),
    last_name VARCHAR(20)
);

DROP TABLE dog IF EXISTS;

CREATE TABLE dog  (
    dog_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    identifier BIGINT,
    nickname VARCHAR(20)
);