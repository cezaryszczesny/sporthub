create table account
(
    id          BIGSERIAL    NOT NULL,
    id_operator BIGINT,
    email       VARCHAR(255) NOT NULL,
    password    VARCHAR(255) NOT NULL,
    create_time timestamp    NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT account_email_unique UNIQUE (email)
);
create table operator
(
    id         BIGSERIAL   NOT NULL,
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
    id                  BIGSERIAL   NOT NULL,
    description         VARCHAR(50) NOT NULL,
    id_operator_player  BIGINT      NOT NULL,
    id_operator_coach   BIGINT      NOT NULL,
    id_operator_creator BIGINT      NOT NULL,
    id_facility         BIGINT,
    from_time           timestamp   NOT NULL,
    to_time             timestamp   NOT NULL,
    PRIMARY KEY (id)
);
create table facility
(
    id                   BIGSERIAL   NOT NULL,
    name                 VARCHAR(50) NOT NULL,
    training_room_number VARCHAR(5)  NOT NULL,
    is_outside           BOOLEAN,
    people_limit         INTEGER,
    PRIMARY KEY (id)
);
create table coach
(
    id           BIGSERIAL NOT NULL,
    id_operator  BIGINT    NOT NULL,
    id_specialty BIGINT    NOT NULL,
    is_active    BOOLEAN,
    PRIMARY KEY (id)
);
create table coach_specialty
(
    id   BIGSERIAL   NOT NULL,
    name VARCHAR(25) NOT NULL,
    PRIMARY KEY (id)
);
create table player
(
    id          BIGSERIAL NOT NULL,
    id_operator BIGINT    NOT NULL,
    id_position BIGINT    NOT NULL,
    birth_date  DATE      NOT NULL,
    height      INTEGER   NOT NULL,
    weight      INTEGER   NOT NULL,
    team_name   VARCHAR(25),
    id_stats    BIGINT,
    id_foot     BIGINT    NOT NULL,
    id_status   BIGINT    NOT NULL,
    id_diet     BIGINT    NOT NULL,
    PRIMARY KEY (id)
);
create table player_diet
(
    id   BIGSERIAL   NOT NULL,
    name VARCHAR(25) NOT NULL,
    PRIMARY KEY (id)
);
create table player_foot
(
    id   BIGSERIAL   NOT NULL,
    name VARCHAR(25) NOT NULL,
    PRIMARY KEY (id)
);
create table player_position
(
    id   BIGSERIAL   NOT NULL,
    name VARCHAR(25) NOT NULL,
    PRIMARY KEY (id)
);
create table player_status
(
    id   BIGSERIAL   NOT NULL,
    name VARCHAR(25) NOT NULL,
    PRIMARY KEY (id)
);
create table previous_season_stats
(
    id           BIGSERIAL NOT NULL,
    id_player    BIGINT    NOT NULL,
    goals        INTEGER   NOT NULL,
    assists      INTEGER   NOT NULL,
    red_cards    INTEGER   NOT NULL,
    yellow_cards INTEGER   NOT NULL,
    PRIMARY KEY (id)
);

--create foreign keys

alter table account
    add constraint account_id_operator_fkey foreign key (id_operator) references operator (id);
alter table operator
    add constraint operator_id_account_fkey foreign key (id_account) references account (id);
alter table operator
    add constraint operator_id_player_fkey foreign key (id_player) references player (id);
alter table operator
    add constraint operator_id_coach_fkey foreign key (id_coach) references coach (id);
alter table player
    add constraint player_id_operator_fkey foreign key (id_operator) references operator (id);
alter table player
    add constraint player_id_position_fkey foreign key (id_position) references player_position (id);
alter table player
    add constraint player_id_status_fkey foreign key (id_status) references player_status (id);
alter table player
    add constraint player_id_stats_fkey foreign key (id_stats) references previous_season_stats (id);
alter table player
    add constraint player_id_diet_fkey foreign key (id_diet) references player_diet (id);
alter table player
    add constraint player_id_foot_fkey foreign key (id_foot) references player_foot (id);
alter table previous_season_stats
    add constraint previous_seasons_stats_id_player_fkey foreign key (id_player) references player (id);
alter table coach
    add constraint coach_id_specialty_fkey foreign key (id_specialty) references coach_specialty (id);
alter table task
    add constraint task_id_operator_coach_fkey foreign key (id_operator_player) references operator (id);
alter table task
    add constraint task_id_operator_player_fkey foreign key (id_operator_coach) references operator (id);
alter table task
    add constraint task_id_operator_creator_fkey foreign key (id_operator_creator) references operator (id);
alter table task
    add constraint task_id_facility_fkey foreign key (id_facility) references facility (id);
