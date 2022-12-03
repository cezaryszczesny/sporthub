create table account (
    id BIGINT NOT NULL,
    id_operator BIGINT,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    create_time DATE NOT NULL,
    PRIMARY KEY (id)
)