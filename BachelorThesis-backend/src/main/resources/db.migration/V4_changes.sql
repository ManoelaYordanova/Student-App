ALTER TABLE _event
    DROP COLUMN start_date;

ALTER TABLE _event
    DROP COLUMN end_date ;

ALTER TABLE _event
    DROP COLUMN start_time;

ALTER TABLE _event
    DROP COLUMN end_time;

ALTER TABLE _event
    ADD COLUMN start_date_time TIMESTAMP;

ALTER TABLE _event
    ADD COLUMN end_date_time TIMESTAMP;

ALTER TABLE _event
    ADD COLUMN end_date_time TIMESTAMP;

ALTER TABLE _event
    ADD COLUMN city VARCHAR(255);