create database if not exists quiz;
use quiz;

drop table if exists Users;
drop table if exists Questions;
drop table if exists Answers;

create table Users
(
    id int primary key auto_increment,
    username varchar(50) unique not null,
    password varchar(50) not null,
    highscore int not null
);

create table Questions
(
    id int primary key auto_increment,
    text longtext not null
);

create table Answers
(
    id int primary key auto_increment,
    text longtext not null,
    isCorrect boolean not null,
    questionId int
);

alter table Answers add foreign key (questionId) references Questions(id);