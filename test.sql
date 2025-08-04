SELECT user_no, name, phone, email, dept_name, position
FROM USER_INFO
WHERE USER_NO NOT IN (
    SELECT user_no 
    FROM project_member 
    WHERE project_id = 1  -- 여기에 원하는 프로젝트 ID를 넣으세요
);

select * from project_task;

select * from project_member;

DELETE FROM project_member;

SELECT * FROM project_task
ORDER BY FIELD(priority, '높음', '보통', '낮음') DESC;

select * from user_info;

SELECT user_no, name, dept_name, position FROM user_info JOIN project_member USING(user_no) WHERE project_id = 1;

INSERT INTO USER_INFO (ID, PASSWORD, NAME, PHONE, EMAIL, DEPT_NAME, POSITION) VALUES
('kim01', 'pass1234', '김철수', '010-1111-1111', 'kim01@example.com', '국내팀', '사원'),
('lee02', 'pass2345', '이영희', '010-2222-2222', 'lee02@example.com', '해외팀', '대리'),
('park03', 'pass3456', '박민수', '010-3333-3333', 'park03@example.com', '예약팀', '과장'),
('choi04', 'pass4567', '최수정', '010-4444-4444', 'choi04@example.com', '국내팀', '사원'),
('jung05', 'pass5678', '정지훈', '010-5555-5555', 'jung05@example.com', '해외팀', '대리'),
('kang06', 'pass6789', '강다현', '010-6666-6666', 'kang06@example.com', '예약팀', '과장'),
('yoon07', 'pass7890', '윤지호', '010-7777-7777', 'yoon07@example.com', '국내팀', '대리'),
('hwang08', 'pass8901', '황지민', '010-8888-8888', 'hwang08@example.com', '해외팀', '사원'),
('jang09', 'pass9012', '장예린', '010-9999-9999', 'jang09@example.com', '예약팀', '사원'),
('han10', 'pass0123', '한승우', '010-0000-0000', 'han10@example.com', '국내팀', '과장');