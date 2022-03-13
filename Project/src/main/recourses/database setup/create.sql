create database if not exists Coursela;

use Coursela;

create table if not exists Course
(
    course_id   varchar(64)  not null,
    course_name varchar(128) unique not null,
    institution varchar(64)  not null,
    course_url  varchar(255) unique not null,
    constraint Course_pk
    primary key (course_id)
    );

create table if not exists Reviewer
(
    reviewer_id   int auto_increment,
    reviewer_name varchar(32) not null,
    constraint Reviewer_pk
    primary key (reviewer_id)
    );

create table if not exists Review
(
    review_id   int auto_increment,
    review_date date                 not null,
    rating      smallint check ( rating in (1, 2, 3, 4, 5) ) not null,
    reviewer_id int not null,
    course_id   varchar(64)  not null,
    constraint Review_pk
    primary key (review_id),
    constraint Review_fk
    foreign key (reviewer_id) references Reviewer(reviewer_id),
    foreign key (course_id) references Course(course_id)
    );





