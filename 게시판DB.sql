create sequence seq_board_idx

create table board
(
   idx     int primary key,  
   name    varchar2(100), 
   subject varchar2(500),     
   content clob,              
   pwd     varchar(50),
   chk_info varchar(200),
   ip      varchar(100),     
   regdate date,              
   readhit int,              
   ref     int,               
   step    int,            
   depth   int             
);

insert into board values(
	                     seq_board_idx.nextVal,
	                     '재성',
	                     '테스트',
	                     '테스트 입니다.',
	                     '1234',
	                     '127.0.0.1',
	                     sysdate,
	                     0,
	                     seq_board_idx.currVal,
	                     0,
	                     0
                     );
      
commit                     

select * from board order by ref desc,step asc

select * from where no between 1 and 10

delete board

drop table board
