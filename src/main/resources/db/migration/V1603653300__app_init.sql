create schema if not exists sports_profile;
create sequence public.hibernate_seq;

CREATE
    TABLE
    IF NOT EXISTS sports_profile.polar_token
(
    id           VARCHAR(255) NOT NULL PRIMARY KEY,
    access_token varchar(255) NOT NULL,
    token_type   varchar(255) NOT NULL,
    expires_in   varchar(255) NOT NULL,
    x_user_id     varchar(255) NOT NULL
);

CREATE
    TABLE
    IF NOT EXISTS sports_profile.sports_profile
(
    id           VARCHAR(255) NOT NULL PRIMARY KEY
);
