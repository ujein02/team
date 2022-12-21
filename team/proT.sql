create table USER_TB(userId varchar2(20) primary key,
userPw varchar2(300) not null,
userName varchar2(50),
email varchar2(100) not null,
tel varchar2(20) not null,
addr1 varchar2(200),
addr2 varchar2(200),
postcode varchar2(10),
regdate date default sysdate,
pt int default 100,
visited int default 0
);