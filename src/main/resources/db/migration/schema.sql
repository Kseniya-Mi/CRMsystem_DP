CREATE TABLE IF NOT EXISTS users (
                       id SERIAL PRIMARY KEY,
                       login VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(50) NOT NULL
);

