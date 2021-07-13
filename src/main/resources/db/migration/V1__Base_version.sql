create schema if not exists palantir;

create table palantir.site
(
    id                  bigserial        not null,
    name                varchar(255)     not null,
    host                varchar(255)     not null,
    routForUser         varchar(255)     not null,
    success_http_code   int              not null,
    not_found_http_code double precision not null,
    active              bit(1)           not null,
    primary key (id)
);