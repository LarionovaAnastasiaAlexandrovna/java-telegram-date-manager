CREATE TABLE IF NOT EXISTS AppUser (
                                    id_user        BIGINT PRIMARY KEY NOT NULL UNIQUE,
                                    name           TEXT NOT NULL,
                                    login          TEXT NOT NULL UNIQUE,
                                    password_hash  VARCHAR(64) NOT NULL -- для хранения хэша SHA-256
);