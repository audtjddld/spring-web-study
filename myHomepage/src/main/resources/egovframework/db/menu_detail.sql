SET SCHEMA PUBLIC
CREATE TABLE MENU_DETAIL (MENU_IDX NUMERIC(10), MENU_NAME VARCHAR(100), URL VARCHAR(255), ORDER_NUM NUMERIC(10))

INSERT INTO MENU_DETAIL VALUES (0, '메인' , '/index.do' , 1)
INSERT INTO MENU_DETAIL VALUES (0, '로그인','/login.do' , 4)

INSERT INTO MENU_DETAIL VALUES (1, '메인' , '/index.do' , 1)
INSERT INTO MENU_DETAIL VALUES (1, 'ajax','/test.do' , 2)
INSERT INTO MENU_DETAIL VALUES (1, '회원 목록' ,'/user/list.do', 3)

INSERT INTO MENU_DETAIL VALUES (2, '메인' , '/index.do' , 1)
INSERT INTO MENU_DETAIL VALUES (2, '관리자 메뉴','/manager/index.do' , 2)

ALTER TABLE MENU_DETAIL ADD CONSTRAINT SYS_FK_95 FOREIGN KEY(MENU_IDX) REFERENCES MENU(MENU_IDX)