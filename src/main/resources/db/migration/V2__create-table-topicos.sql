create table topicos(
    id            bigint       not null auto_increment,
    titulo        varchar(255) not null unique,
    mensaje       text         not null,
    fechaCreacion datetime     not null,
    status        varchar(100),
    autor_id      bigint       not null,
    curso_id      bigint       not null,
    primary key (id)
)