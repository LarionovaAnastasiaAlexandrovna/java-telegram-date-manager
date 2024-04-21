CREATE TABLE IF NOT EXISTS Category (
                                        id_category     BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                                        id_user         BIGINT NOT NULL,
                                        category        TEXT NOT NULL UNIQUE,

                                        FOREIGN KEY (id_user) REFERENCES AppUser (id_user)
);