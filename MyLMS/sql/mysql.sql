serial primary key
SERIAL PRIMARY KEY

DROP TABLE IF EXISTS book;
CREATE TABLE book (
  BookId  SERIAL PRIMARY KEY,
  BookName varchar(40) NOT NULL,
  Writter varchar(40) NOT NULL,
  BookType varchar(20) NOT NULL,
  Price int2 NOT NULL,
  IsBorrow varchar(20) NOT NULL DEFAULT '否'
) ;

INSERT INTO ycy.book("bookname","writter","booktype","price","isborrow") VALUES ('时间简史', '史蒂芬.霍金', '科技类', 98, '否');
INSERT INTO ycy.book("bookname","writter","booktype","price","isborrow") VALUES ('坏坏的你', '大冰', '文学类', 38, '否');
INSERT INTO ycy.book("bookname","writter","booktype","price","isborrow") VALUES ('权利意志', '尼采', '哲学类', '58', '否');
INSERT INTO ycy.book("bookname","writter","booktype","price","isborrow") VALUES ('Java从入门到精通', '陈嵩青', '技术类', '98', '否');
INSERT INTO ycy.book("bookname","writter","booktype","price","isborrow") VALUES ('DB从删库到跑路', '戴真余', '技术类', '100', '否');
INSERT INTO ycy.book("bookname","writter","booktype","price","isborrow") VALUES ('时间简史', '史蒂芬.霍金', '科技类', 98, '否');
INSERT INTO ycy.book("bookname","writter","booktype","price","isborrow") VALUES ('时间简史', '史蒂芬.霍金', '科技类', 98, '否');




DROP TABLE IF EXISTS borrow;
CREATE TABLE borrow (
  BorrowId SERIAL ,
  BookId int2 NOT NULL,
  BookName varchar(50) NOT NULL,
  BookType varchar(20) NOT NULL,
  userid int2 NOT NULL,
  username varchar(50) NOT NULL,
  BorrowTime date NOT NULL,
  ReturnTime date NOT NULL,
  IsReturn varchar(10) NOT NULL DEFAULT '否',
  PRIMARY KEY (BorrowId, BookId,userid),
  FOREIGN KEY (BookId) REFERENCES ycy.book(BookId),
  FOREIGN KEY (userid) REFERENCES ycy.users(userid)
) ;

INSERT INTO ycy.borrow("bookid","bookname","booktype","userid","username","borrowtime","returntime","isreturn") VALUES ('5','DB从删库到跑路', '技术类', '1', '杨潮湧', '2018-09-12', '2018-09-12', '是');


DROP TABLE IF EXISTS users;
CREATE TABLE users (
  userid  SERIAL PRIMARY KEY,
  username varchar(50) NOT NULL,
  userpsw varchar(20) NOT NULL,
  useremail varchar(20) NOT NULL,
  useraddr varchar(100) NOT NULL,
  userphone varchar(20) NOT NULL
) ;

"username"
INSERT INTO ycy.users ("username","userpsw","useremail","useraddr","userphone") VALUES ('杨潮湧', '1234', '123@163.com', '中国福建', '19859092005');


DROP TABLE IF EXISTS root;
CREATE TABLE root (
  rootID SERIAL,
  rootName varchar(50) NOT NULL,
  rootPWD varchar(20) NOT NULL,
  PRIMARY KEY (rootID)
) ;


INSERT INTO ycy.root VALUES (1,'admin', '1234');
INSERT INTO ycy.root("rootname","rootpwd") VALUES ('ycy', '1234');
INSERT INTO ycy.root("rootname","rootpwd") VALUES ('csq', '1234');
