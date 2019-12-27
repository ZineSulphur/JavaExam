CREATE DATABASE test2;
USE test2;
CREATE TABLE account
(
    username varchar(20) PRIMARY KEY,
    password char(20),
    id int
);
CREATE TABLE student
(
    sno int PRIMARY KEY,
    sname varchar(8),
    ssex char(2),
    sbirthy int,
    sbirthm int,
    smajor char(20),
    sfaulty char(20)
);
CREATE TABLE teacher
(
    tno int PRIMARY KEY,
    tname varchar(8),
    tdepartment char(20),
    tfaulty char(20)
);
CREATE TABLE dean
(
    dno int PRIMARY KEY,
    dname varchar(8),
    dfaulty char(20)
);
CREATE TABLE course
(
    cno int PRIMARY KEY,
    cname varchar(20),
    credit int,
    ctime int
);
CREATE TABLE sc
(
    scno int PRIMARY KEY,
    scourse varchar(20),
    steacher varchar(8),
    sstudent varchar(8),
    degree decimal(5,2),
    CHECK(degree >= 0 AND degree <= 100)
);
INSERT INTO account (username, password, id) VALUES ('admin', 'admin', 0);