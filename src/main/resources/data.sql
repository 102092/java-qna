INSERT INTO USER (ID, USER_ID, PASSWORD, NAME, EMAIL) VALUES (1, 'gram', '1234' , '이그램' , 'gram@gmailcom');
INSERT INTO USER (ID, USER_ID, PASSWORD, NAME, EMAIL) VALUES (2, 'durin', '1234' , '이두린' , 'durin@gmailcom');

INSERT INTO QUESTION (ID, WRITER_ID, TITLE, CONTENTS, CREATE_DATE) VALUES (1, 1, '제목1', '내용1', CURRENT_TIMESTAMP);
INSERT INTO QUESTION (ID, WRITER_ID, TITLE, CONTENTS, CREATE_DATE) VALUES (2, 2, '제목2', '내용2', CURRENT_TIMESTAMP);