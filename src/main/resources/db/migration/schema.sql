CREATE TABLE IF NOT EXISTS users (
                       id SERIAL PRIMARY KEY,
                       login VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(50) NOT NULL
);

INSERT INTO users (login, password, role)
VALUES ('admin', 'admin123', 'ADMIN'),
       ('user', 'user123', 'USER');