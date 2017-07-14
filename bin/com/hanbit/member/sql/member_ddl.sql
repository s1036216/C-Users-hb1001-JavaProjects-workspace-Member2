-- id,name,password,ssn,regdate
--테이블틀만듬
CREATE TABLE Member(  
	 id VARCHAR2(10),
	 name VARCHAR2(10),
	 password VARCHAR2(10),
	 ssn VARCHAR2(15),
	 regdate DATE,
	 PRIMARY KEY(id)
);
SELECT * FROM Member; --확인하려고
DROP TABLE Member; --ddl 전체 지움