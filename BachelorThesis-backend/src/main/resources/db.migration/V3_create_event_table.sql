CREATE TABLE event
(
    id          INT          NOT NULL,
    name        VARCHAR(255) NOT NULL,
    start_date  DATE         NOT NULL,
    end_date    DATE         NOT NULL,
    start_time  TIME         NOT NULL,
    end_time    TIME         NOT NULL,
    description VARCHAR(255) NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);