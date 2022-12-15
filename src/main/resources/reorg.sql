--CREATE BASE TABLES
create table account
(
    id          BIGINT       NOT NULL,
    id_operator BIGINT,
    email       VARCHAR(255) NOT NULL,
    password    VARCHAR(255) NOT NULL,
    create_time DATE         NOT NULL,
    PRIMARY KEY (id)
);
create table operator
(
    id         BIGINT      NOT NULL,
    id_account BIGINT      NOT NULL,
    first_name VARCHAR(25) NOT NULL,
    last_name  VARCHAR(25) NOT NULL,
    is_player  BOOLEAN,
    id_player  BIGINT,
    id_coach   BIGINT,
    PRIMARY KEY (id)
);
create table task
(
    id               BIGINT      NOT NULL,
    id_operator      BIGINT      NOT NULL,
    player_full_name VARCHAR(50) NOT NULL,
    coach_full_name  VARCHAR(50) NOT NULL,
    created_by       VARCHAR(50) NOT NULL,
    id_facility      BIGINT,
    from_time        DATE        NOT NULL,
    to_time          DATE        NOT NULL,
    PRIMARY KEY (id)
);
create table facility
(
    id                   BIGINT      NOT NULL,
    name                 VARCHAR(50) NOT NULL,
    training_room_number VARCHAR(5)  NOT NULL,
    is_outside           BOOLEAN,
    people_limit         INTEGER,
    PRIMARY KEY (id)
);
create table coach
(
    id           BIGINT NOT NULL,
    id_operator  BIGINT NOT NULL,
    id_specialty BIGINT NOT NULL,
    is_active    BOOLEAN,
    PRIMARY KEY (id)
);
create table coach_specialty
(
    id   BIGINT      NOT NULL,
    name VARCHAR(25) NOT NULL,
    PRIMARY KEY (id)
);
create table player
(
    id          BIGINT  NOT NULL,
    id_operator BIGINT  NOT NULL,
    id_position BIGINT  NOT NULL,
    birth_date  DATE    NOT NULL,
    height      INTEGER NOT NULL,
    weight      INTEGER NOT NULL,
    team_name   VARCHAR(25),
    id_stats    BIGINT  NOT NUll,
    id_foot     BIGINT  NOT NULL,
    id_status   BIGINT  NOT NULL,
    id_diet     BIGINT  NOT NULL,
    PRIMARY KEY (id)
);
create table player_diet
(
    id   BIGINT      NOT NULL,
    name VARCHAR(25) NOT NULL,
    PRIMARY KEY (id)
);
create table player_foot
(
    id   BIGINT      NOT NULL,
    name VARCHAR(25) NOT NULL,
    PRIMARY KEY (id)
);
create table player_position
(
    id   BIGINT      NOT NULL,
    name VARCHAR(25) NOT NULL,
    PRIMARY KEY (id)
);
create table player_status
(
    id   BIGINT      NOT NULL,
    name VARCHAR(25) NOT NULL,
    PRIMARY KEY (id)
);
create table previous_season_stats
(
    id           BIGINT  NOT NULL,
    id_player    BIGINT  NOT NULL,
    goals        INTEGER NOT NULL,
    assists      INTEGER NOT NULL,
    red_cards    INTEGER NOT NULL,
    yellow_cards INTEGER NOT NULL,
    PRIMARY KEY (id)
);
