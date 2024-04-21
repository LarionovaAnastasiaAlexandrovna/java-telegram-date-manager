CREATE TABLE IF NOT EXISTS Message (
                                       id_message      BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                                       id_category     BIGINT NOT NULL,
                                       message         BYTEA NOT NULL,
                                       created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                                       FOREIGN KEY (id_category) REFERENCES Category (id_category)
);