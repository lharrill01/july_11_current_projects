drop table user_account;

commit;

create table USER_ACCOUNT (
	email VARCHAR(50),
	password VARCHAR(50),
    roleid int
);
insert into USER_ACCOUNT (email, password,roleid) values ('sluckwell0@phpbb.com', 'cdlspwd', 1);
insert into USER_ACCOUNT (email, password,roleid) values ('swindsor1@yolasite.com', 'whoamips',1);
insert into USER_ACCOUNT (email, password,roleid) values ('echaloner2@berkeley.edu', 'hadoophdfs',1);
insert into USER_ACCOUNT (email, password,roleid) values ('cstovin3@pinterest.com', 'hdfsdfs',1);
insert into USER_ACCOUNT (email, password,roleid) values ('lkubas4@wikispaces.com', 'chowngrep',1);
insert into USER_ACCOUNT (email, password, roleid) values ('test01@test.com', 'test123',1);
insert into USER_ACCOUNT (email, password, roleid) values ('jdoe01@test.com', 'jd123',2);


drop table reimbursement_pool;

create table reimbursement_pool(id number(6), email varchar(20), rstuff varchar(20), rAmount number(8,2), adchoice boolean);

select * from reimbursement_pool;
select * from USER_ACCOUNT;

commit;

