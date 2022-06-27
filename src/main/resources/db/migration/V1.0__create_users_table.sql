DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS user_seq;

CREATE SEQUENCE user_seq START WITH 100000;

CREATE TABLE users (
    user_id INTEGER PRIMARY KEY NOT NULL,
    username VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    phone VARCHAR,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_ad TIMESTAMP NOT NULL DEFAULT NOW()
);

ALTER TABLE users ALTER COLUMN user_id SET DEFAULT nextval('user_seq');

CREATE OR REPLACE FUNCTION trigger_set_updated_at()
    RETURNS TRIGGER AS $$
    BEGIN
        NEW.updated_ad = NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_updated_ad
    BEFORE UPDATE ON users
    FOR EACH ROW
        EXECUTE PROCEDURE trigger_set_updated_at();
