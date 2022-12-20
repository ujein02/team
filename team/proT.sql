create table USER_TB(userId varchar2(20) primary key,
userPw varchar2(300) not null,
userName varchar2(50),
point number default 0,
grade varchar2(50),
visited int default 0,
tel varchar2(20) not null,
address varchar2(200),
email varchar2(100) not null,
birth date,
regdate date default sysdate
);