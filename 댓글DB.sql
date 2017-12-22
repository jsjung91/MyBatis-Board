--������
create sequence seq_comment_idx

--���̺�
create table comment_tb
(
    c_idx int primary key,
    idx int references board(idx),--���α۹�ȣ
    c_name varchar2(100),
    c_content varchar2(1000),
    c_ip varchar2(100),
    c_pwd varchar2(50),
    c_regdate date
    )

alter table comment_tb add regdate date
drop table comment_tb

select * from comment_tb