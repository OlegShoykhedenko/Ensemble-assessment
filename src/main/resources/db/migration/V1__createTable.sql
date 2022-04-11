create sequence movie_sequence
create table movie (
    id bigint(20) not null default nextval('movie_sequence') ,
    title varchar(255) not null,
    description text not null,
    releaseYear int not null,
    rating double_precision not null,
    likeCount int not null,
    dislikeCount int not null,
    primary key (id)
);