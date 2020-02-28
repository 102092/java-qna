INSERT INTO USER (id, user_id, password, name, email) VALUES (1, 'master', '1234', '관리자', 'master@gmail.com');
INSERT INTO USER (id, user_id, password, name, email) VALUES (2, 'guest', '1234', '손님', 'guest@gmail.com');

INSERT INTO QUESTION (id, created_time, contents, title, writer_id) VALUES (1, CURRENT_TIMESTAMP, '테스트 질문입니다', 'guest의 테스트 질문', 2);
INSERT INTO QUESTION (id, created_time, contents, title, writer_id) VALUES (2, CURRENT_TIMESTAMP, '마스터의 테스트 질문', 'master 테스트 질문2', 1);

INSERT INTO ANSWER (id, created_time, contents, question_id, writer_id) VALUES (1, CURRENT_TIMESTAMP, '테스트 댓글 입니다1', 1, 1);
INSERT INTO ANSWER (id, created_time, contents, question_id, writer_id) VALUES (2, CURRENT_TIMESTAMP, '테스트 댓글 입니다2', 1, 2);

INSERT INTO ANSWER (id, created_time, contents, question_id, writer_id) VALUES (3, CURRENT_TIMESTAMP, '테스트 댓글 입니다3', 2, 1);
INSERT INTO ANSWER (id, created_time, contents, question_id, writer_id) VALUES (4, CURRENT_TIMESTAMP, '테스트 댓글 입니다4', 2, 2);

