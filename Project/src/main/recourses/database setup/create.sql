create schema if not exists public;
drop table if exists "review";

drop table if exists "course";
create table "course"
(
    course_id   varchar(64)
            primary key,
    course_name varchar(128) not null,
    institution varchar(64)         not null,
    course_url  varchar             not null
);

drop table if exists "reviewer";
create table "reviewer"
(
    reviewer_id   serial
        constraint reviewer_pk
            primary key,
    reviewer_name varchar(32) not null
);

drop table if exists "review";
create table "review"
(
    review_id   serial
        constraint review_pk
            primary key,
    review_content text not null,
    review_date date        not null,
    rating      int2        not null,
    reviewer_id int         not null references "reviewer" (reviewer_id),
    course_id   varchar(64) not null references "course" (course_id)
);