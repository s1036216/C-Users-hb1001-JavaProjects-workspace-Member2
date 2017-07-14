-- id,name,password,ssn,regdate
SELECT * FROM Member; --확인
SELECT * FROM Member WHERE name='홍길동';
SELECT COUNT(*) AS count FROM Member; --모든 카운트를 가져오는 문법 AS "" 이름만 변수바꾸는거
INSERT INTO Member(id,name,password,ssn,regdate) 
VALUES('hong','홍길동','1','841213-123456',SYSDATE);
INSERT INTO Member(id,name,password,ssn,regdate) 
VALUES('cho','조봉기','1','841113-123456',SYSDATE);
INSERT INTO Member(id,name,password,ssn,regdate) 
VALUES('byon','변용주','1','861111-111111',SYSDATE);
INSERT INTO Member(id,name,password,ssn,regdate) 
VALUES('kim','김하윤','1','930103-211111',SYSDATE);
INSERT INTO Member(id,name,password,ssn,regdate) 
VALUES('park','박정권','1','741013-111111',SYSDATE);
INSERT INTO Member(id,name,password,ssn,regdate) 
VALUES('lee','이순신','1','861111-111111',SYSDATE);
INSERT INTO Member(id,name,password,ssn,regdate) 
VALUES('cho4','조봉암','1','891013-111111',SYSDATE);
INSERT INTO Member(id,name,password,ssn,regdate)
VALUES('hong1','홍길동','1','881111-111111',SYSDATE);
INSERT INTO Member(id,name,password,ssn,regdate) 
VALUES('song','송혜교','1','801023-211111',SYSDATE);
INSERT INTO Member(id,name,password,ssn,regdate) 
VALUES('lee1','이순신','1','581013-111111',SYSDATE);  --입력


SELECT * FROM Member WHERE id='hong';