-- ȸ��
CREATE TABLE MEMBER(
	MEMBER_NUM NUMBER,
	ID VARCHAR(20) PRIMARY KEY,
	PW VARCHAR(20),
	EMAIL VARCHAR(50),
	NAME VARCHAR(30),
	ADDR VARCHAR(200),
	PIN NUMBER,
	YEAR NUMBER,
	MONTH NUMBER,
	DAY NUMBER,
	HOBBY VARCHAR(100),
	INTRO VARCHAR(1000)
);




-- �Խ���
create table BOARD(
	BOARD_NUM INT,
	BOARD_NAME VARCHAR(20),
	BOARD_SUBJECT VARCHAR(50),
	BOARD_CONTENT VARCHAR(2000),
	BOARD_FILE VARCHAR(50),
	BOARD_RE_REF INT,
	BOARD_RE_LEV INT,
	BOARD_RE_SEQ INT,
	BOARD_READCOUNT INT,
	BOARD_DATE DATE,
	PRIMARY KEY(BOARD_NUM)
	
);


ALTER TABLE BOARD ADD CONSTRAINT FK_BOARD_NAME FOREIGN KEY(BOARD_NAME) REFERENCES MEMBER(ID) ON DELETE CASCADE;

ALTER TABLE BOARD DROP CONSTRAINTS FK_BOARD_NAME;