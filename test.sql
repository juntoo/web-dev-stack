SELECT user_no, name, phone, email, dept_name, position
FROM USER_INFO
WHERE USER_NO NOT IN (
    SELECT user_no 
    FROM project_member 
    WHERE project_id = 1  -- 여기에 원하는 프로젝트 ID를 넣으세요
);

select * from user_info;
select * from project;
UPDATE user_info SET role = 'ROLE_ADMIN' WHERE id = 'admin';

drop table product_planning;

select * from product_planning;

CREATE TABLE product_planning (
	product_id   INT AUTO_INCREMENT PRIMARY KEY, -- 여행 상품 ID //product_no (상품 번호 수정필요)
	project_id   INT NOT NULL,                   -- 연결된 프로젝트 ID
	title        VARCHAR(100),                   -- 여행 상품명
	destination  VARCHAR(100),                   -- 목적지
	start_date   DATE,
	end_date     DATE,
	price        INT                  -- 여행 가격
);

ALTER TABLE USER_INFO
ADD COLUMN ROLE VARCHAR(50) DEFAULT 'ROLE_USER' NOT NULL;

select * from project;

select * from project_task;

select * from project_member;

DELETE FROM project_member;

SELECT count(*) FROM project_member
WHERE project_id = 1 AND user_no = 70;


SELECT * FROM project_task
ORDER BY FIELD(priority, '높음', '보통', '낮음') DESC;

select * from user_info;

UPDATE user_info
SET role = 'ROLE_ADMIN'
WHERE name = '이승민';

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

INSERT INTO USER_INFO (ID, PASSWORD, NAME, PHONE, EMAIL, DEPT_NAME, POSITION) VALUES
('lee01', 'password123', '이민호', '010-1111-1111', 'lee01@example.com', '국내팀', '사원'),
('lee03', 'password123', '박이현', '010-3333-3333', 'lee03@example.com', '예약팀', '과장'),
('lee04', 'password123', '이정민', '010-4444-4444', 'lee04@example.com', '국내팀', '사원'),
('lee05', 'password123', '최이준', '010-5555-5555', 'lee05@example.com', '해외팀', '대리'),
('lee06', 'password123', '이서현', '010-6666-6666', 'lee06@example.com', '예약팀', '과장'),
('lee07', 'password123', '한이슬', '010-7777-7777', 'lee07@example.com', '국내팀', '사원'),
('lee08', 'password123', '이수민', '010-8888-8888', 'lee08@example.com', '해외팀', '대리'),
('lee09', 'password123', '김이재', '010-9999-9999', 'lee09@example.com', '예약팀', '과장'),
('lee10', 'password123', '이지현', '010-1010-1010', 'lee10@example.com', '국내팀', '사원'),
('lee11', 'password123', '이유진', '010-1112-1314', 'lee11@example.com', '해외팀', '대리'),
('lee12', 'password123', '박이담', '010-1212-1212', 'lee12@example.com', '예약팀', '과장'),
('lee13', 'password123', '송이랑', '010-1313-1414', 'lee13@example.com', '국내팀', '사원'),
('lee14', 'password123', '이한결', '010-1414-1515', 'lee14@example.com', '해외팀', '대리'),
('lee15', 'password123', '최이현', '010-1515-1616', 'lee15@example.com', '예약팀', '과장'),
('lee16', 'password123', '이하늘', '010-1616-1717', 'lee16@example.com', '국내팀', '사원'),
('lee17', 'password123', '김이찬', '010-1717-1818', 'lee17@example.com', '해외팀', '대리'),
('lee18', 'password123', '이상민', '010-1818-1919', 'lee18@example.com', '예약팀', '과장'),
('lee19', 'password123', '박이진', '010-1919-2020', 'lee19@example.com', '국내팀', '사원'),
('lee20', 'password123', '이지우', '010-2020-2121', 'lee20@example.com', '해외팀', '대리');user_info