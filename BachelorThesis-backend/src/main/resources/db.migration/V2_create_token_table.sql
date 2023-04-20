CREATE TABLE token
(
    id          BIGINT       NOT NULL,
    token       VARCHAR(255) NOT NULL,
    tokenType   VARCHAR(255) NOT NULL,
    revoked     BOOLEAN,
    expired     BOOLEAN,
    user_id     INT,
    CONSTRAINT pk_token PRIMARY KEY (id)
);