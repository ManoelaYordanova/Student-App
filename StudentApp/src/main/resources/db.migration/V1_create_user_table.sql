CREATE TABLE user
(
    id          INT       NOT NULL,
    firstname   VARCHAR(255) NOT NULL,
    lastname    VARCHAR(255) NOT NULL,
    email       VARCHAR(255) NOT NULL,
    password    VARCHAR(255) NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);