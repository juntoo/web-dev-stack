CREATE TABLE USER_INFO(
 USER_NO INT PRIMARY KEY AUTO_INCREMENT,
 ID VARCHAR(50) UNIQUE NOT NULL,
 PASSWORD VARCHAR(300) NOT NULL,
 NAME VARCHAR(50) NOT NULL,
 PHONE VARCHAR(50),
 EMAIL VARCHAR(100),
 DEPT_NAME VARCHAR(50), -- 국내팀, 해외팀, 예약팀
 POSITION VARCHAR(50)    -- 사원, 대리, 과장
);

CREATE TABLE product(
  PRODUCT_SQU INT AUTO_INCREMENT PRIMARY KEY,
  PRODUCT_NAME VARCHAR(100) NOT NULL,
  PRODUCT_NO INT,
  PRODUCT_DESC TEXT,
  DESTINATION VARCHAR(100),
  DURATION_DAYS INT, -- 여행 일수
  PRICE_ADULT INT, -- 성인 가격
  PRICE_CHILD INT, -- 아동 가격
  PRICE_INFANT INT, -- 유아 가격
  MIN_PARTICIPANTS INT, -- 최소 출발 인원
  MAX_PARTICIPANTS INT, -- 최대 출발 인원
  START_DATE DATE, -- 시작일
  END_DATE DATE, -- 종료일
  INCLUDE_FLIGHT BOOLEAN DEFAULT FALSE, -- 항공료 포함 여부
  INCLUDE_HOTEL BOOLEAN DEFAULT FALSE, -- 숙박료 포함 여부
  INCLUDE_MEAL BOOLEAN DEFAULT FALSE, -- 식사 포함 여부
  STATUS VARCHAR(20) CHECK(STATUS IN ('판매중', '판매중단', '시즌종료')),
  CREATE_DATE DATETIME DEFAULT (CURRENT_TIMESTAMP),
  PROJECT_ID INT
);

CREATE TABLE BOOKING(
 BOOKING_NO INT AUTO_INCREMENT PRIMARY KEY,
 ADULT_COUNT INT,                   -- 성인 인원수
 CHILD_COUNT INT,                   -- 아동 인원수
 INFANT_COUNT INT,                  -- 유아 인원수
 -- TOTAL_AMOUNT INT,			        -- 총 금액 
 PAYMENT_STATUS VARCHAR(20) CHECK(PAYMENT_STATUS IN ('대기', '완료')),
 BOOKING_STATUS VARCHAR(20) CHECK(BOOKING_STATUS IN ('예약', '완료', '취소')),
 CREATE_DATE DATETIME DEFAULT (CURRENT_TIMESTAMP),
 CUSTOMER_NO INT,
 PACKAGE_NO INT
);


CREATE TABLE SCHEDULE(
 SCHEDULE_NO INT AUTO_INCREMENT PRIMARY KEY,
 TITLE VARCHAR(100) NOT NULL,
 START_DATE DATETIME,
 END_DATE DATETIME,
 LOCATION VARCHAR(100),
 SCHEDULE_TYPE VARCHAR(30),          -- 회의, 고객미팅, 현지답사
 USER_NO INT                         -- 담당자 FK user_info
);

CREATE TABLE project (
	project_id     INT AUTO_INCREMENT PRIMARY KEY, -- 프로젝트 고유번호
	project_name   VARCHAR(100) NOT NULL,          -- 프로젝트명 (예: 일본 봄맞이 여행 기획)
	project_type   VARCHAR(50) CHECK(project_type IN ('자유여행', '패키지')),      -- 유형 (패키지, 자유여행 등)
	status         VARCHAR(30) DEFAULT '기획중' CHECK(STATUS IN ('기획중', '진행중', '완료')),                    -- 상태 (기획중, 진행중, 완료 등)
	start_date     DATE,                           -- 프로젝트 시작일
	end_date       DATE,                           -- 종료일
	created_by     INT,                            -- 등록한 직원 user_no
	created_at     DATETIME DEFAULT CURRENT_TIMESTAMP -- 등록일시
);

ALTER TABLE project
ADD project_detail TEXT COMMENT '프로젝트 상세 설명';

select * from user_info;
SELECT 
	p.project_id,
    p.project_name,
    p.start_date,
    p.end_date
FROM project p
JOIN project_member USING(project_id)
JOIN user_info USING(user_no)
WHERE user_no = 1;

SELECT 
			task_id taskId,
		    task_name taskName,
		    start_date startDate,
		    due_date dueDate,
		    priority
		FROM project_task
		WHERE assigned_to = 1;

select * from project_task;

ALTER TABLE project
MODIFY COLUMN status VARCHAR(30) 
DEFAULT '기획중'
CHECK (status IN ('기획중', '진행중', '완료'));

CREATE TABLE project_member (
	project_id   INT NOT NULL,         -- 프로젝트 ID
	user_no  INT NOT NULL,         -- 참여 직원 user_no
	role         VARCHAR(50),          -- 역할 (PM, 가이드 등)
	join_date    DATE                 -- 참여 시작일
);

CREATE TABLE project_task (
	task_id      INT AUTO_INCREMENT PRIMARY KEY,  -- 작업 고유번호
	project_id   INT NOT NULL,                    -- 연결된 프로젝트 ID
	task_name    VARCHAR(100),                    -- 작업 이름 (예: 일정표 작성)
	assigned_to  INT,                             -- 담당자 user_no
	status       VARCHAR(30),                     -- 상태 (대기, 진행, 완료 등)
	start_date   DATE,                            -- 작업 시작일
	due_date     DATE,                            -- 마감일
	priority     VARCHAR(20)                     -- 우선순위 (낮음, 보통, 높음)
);

CREATE TABLE itinerary_plan (
	itinerary_id   INT AUTO_INCREMENT PRIMARY KEY, -- 일정 계획 ID
	project_id     INT NOT NULL,                   -- 프로젝트 ID
	day_number     INT,                            -- 여행 며칠째인지 (1일차, 2일차...)
	location       VARCHAR(100),                   -- 장소
	activity       VARCHAR(255),                   -- 활동 내용
	transportation VARCHAR(100),                   -- 이동 수단
	note           TEXT                           -- 비고/특이사항
);

CREATE TABLE project_expense (
	expense_id   INT AUTO_INCREMENT PRIMARY KEY, -- 지출 ID
	project_id   INT NOT NULL,                   -- 프로젝트 ID
	category     VARCHAR(50),                    -- 항목 (항공, 숙소, 가이드비 등)
	amount       INT,                  			-- 금액
	date         DATE,                           -- 지출일
	paid_to      VARCHAR(100)                   -- 지급 대상자
);

CREATE TABLE project_risk (
	risk_id          INT AUTO_INCREMENT PRIMARY KEY, -- 리스크 ID
	project_id       INT NOT NULL,                   -- 프로젝트 ID
	risk_description TEXT,                           -- 리스크 설명
	impact_level     VARCHAR(20),                    -- 영향도 (낮음/중간/높음)
	mitigation_plan  TEXT,                           -- 대응 방안
	status           VARCHAR(30)                    -- 상태 (예: 진행중/해결)
);

CREATE TABLE project_feedback (
	feedback_id  INT AUTO_INCREMENT PRIMARY KEY,  -- 피드백 ID
	project_id   INT NOT NULL,                    -- 프로젝트 ID
	source       VARCHAR(50),                     -- 출처 (고객, 가이드, 내부)
	score        INT,                             -- 점수 (1~5)
	comment      TEXT,                            -- 의견/리뷰
	created_at   DATETIME DEFAULT CURRENT_TIMESTAMP -- 작성일
);

CREATE TABLE customer (
    customer_no     INT AUTO_INCREMENT PRIMARY KEY, -- 고객 고유번호
    customer_name   VARCHAR(50) NOT NULL,           -- 고객명
    company_number   INT,                           -- 동반자 수
    phone           VARCHAR(20),                    -- 연락처
    email           VARCHAR(100),                   -- 이메일
    address         VARCHAR(200),                   -- 주소
    birth_date      DATE,                           -- 생년월일
    gender          VARCHAR(10),                    -- 성별
    passport_no     VARCHAR(20),                    -- 여권번호
    nationality     VARCHAR(50),                    -- 국적
    grade           VARCHAR(20),                    -- 고객 등급(신규, 실버, 골드, 플래티넘)
    used_amount     INT DEFAULT 0,                  -- 총 사용금액 (고객등급에 사용)
    user_no         INT,                            -- 담당자 번호
    created_at      DATETIME DEFAULT CURRENT_TIMESTAMP,  -- 고객정보 생성일
    updated_at      DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 고객정보 수정일

);

CREATE TABLE booking (
    booking_no      INT AUTO_INCREMENT PRIMARY KEY, -- 예약 고유번호
    customer_no     INT NOT NULL,                   -- 고객 고유번호
    product_no      INT,                            -- 상품 고유번호 
    travel_date     DATE,                           -- 여행 시작일
    return_date     DATE,                           -- 여행 종료일
    adult_count     INT DEFAULT 1,                  -- 성인 인원
    child_count     INT DEFAULT 0,                  -- 아동 인원
    infant_count    INT DEFAULT 0,                  -- 유아 인원 
    total_amount    INT,                            -- 총 금액 
    discount_amount INT,                            -- 할인 금액 (고객등급에 따라)
    payment_amount  INT,                            -- 총 결제 금액(총 금액 - 할인금액)
    booking_status  VARCHAR(30),                    -- 예약 상태 (예약대기, 결제완료, 예약확정, 예약취소)
    payment_method  VARCHAR(30),                    -- 결제 방법(계좌이체, 카드)
    booking_date    DATETIME DEFAULT CURRENT_TIMESTAMP,   -- 예약일
    payment_date    DATETIME,                             -- 결제일
    user_no         INT                             -- 담당자 번호
);

CREATE TABLE claim (
	claim_no           INT AUTO_INCREMENT PRIMARY KEY,  -- 클레임 고유번호
	claim_type         VARCHAR(50),                     -- 클레임 종류(단순문의/피드백)
	customer_no        INT,                             -- 고객 고유번호
	project_id         INT,                             -- 프로젝트 고유번호(피드백인 경우만) 
	product_no         INT,                             -- 상품 고유번호(단순문의인 경우만)
	source             VARCHAR(50),                     -- 출처(고객, 가이드, 내부)
	score              INT,                             -- 평점(피드백인 경우만)
	comment            TEXT,                            -- 문의내용(단순문의인 경우만)
	claim_date         DATETIME DEFAULT CURRENT_TIMESTAMP, -- 클레임 생성일
	claim_status       VARCHAR(20),                        -- 클레임 처리 상태
	checked_date         DATETIME,                         -- 처리 완료일
	user_no            INT                                 -- 담당자 번호
);

ALTER TABLE BOOKING ADD FOREIGN KEY (CUSTOMER_NO) REFERENCES customer(CUSTOMER_NO);
ALTER TABLE BOOKING ADD FOREIGN KEY (PACKAGE_NO) REFERENCES package(PACKAGE_NO);
ALTER TABLE SCHEDULE ADD FOREIGN KEY (USER_NO) REFERENCES user_info(USER_NO);
ALTER TABLE CUSTOMER ADD FOREIGN KEY (USER_NO) REFERENCES user_info(USER_NO);
ALTER TABLE CUSTOMER_INQUIRY ADD FOREIGN KEY (CUSTOMER_NO) REFERENCES customer(CUSTOMER_NO);
ALTER TABLE CUSTOMER_INQUIRY ADD FOREIGN KEY (USER_NO) REFERENCES user_info(USER_NO);
ALTER TABLE project ADD FOREIGN KEY (created_by) REFERENCES user_info(user_no);
ALTER TABLE project_member ADD FOREIGN KEY (project_id) REFERENCES project(project_id);
ALTER TABLE project_member ADD FOREIGN KEY (user_no) REFERENCES user_info(user_no);
ALTER TABLE project_task ADD FOREIGN KEY (project_id) REFERENCES project(project_id);
ALTER TABLE project_task ADD FOREIGN KEY (assigned_to) REFERENCES user_info(user_no);
ALTER TABLE itinerary_plan ADD FOREIGN KEY (project_id) REFERENCES project(project_id);
ALTER TABLE project_expense ADD FOREIGN KEY (project_id) REFERENCES project(project_id);
ALTER TABLE project_risk ADD FOREIGN KEY (project_id) REFERENCES project(project_id);
ALTER TABLE project_feedback ADD FOREIGN KEY (project_id) REFERENCES project(project_id);

-- customer 테이블 외래키
ALTER TABLE customer ADD FOREIGN KEY (user_no) REFERENCES user_info(user_no);

-- booking 테이블 외래키
ALTER TABLE booking ADD FOREIGN KEY (customer_no) REFERENCES customer(customer_no);
ALTER TABLE booking ADD FOREIGN KEY (product_no) REFERENCES product(product_no); 
ALTER TABLE booking ADD FOREIGN KEY (user_no) REFERENCES user_info(user_no);

-- claim 테이블 외래키
ALTER TABLE claim ADD FOREIGN KEY (customer_no) REFERENCES customer(customer_no);
ALTER TABLE claim ADD FOREIGN KEY (user_no) REFERENCES user_info(user_no);
ALTER TABLE claim ADD FOREIGN KEY (project_id) REFERENCES project(project_id);
ALTER TABLE claim ADD FOREIGN KEY (product_no) REFERENCES product(product_no);

SELECT * FROM product;



select * from user_info;

INSERT INTO user_info(id, password, name, phone, email, dept_name, position) values('admin', '1234', '관리자', '01011112222', "example@erp.com", '해외팀', '사장');

SELECT
	p.*,
	u.name
FROM project_task p
JOIN user_info u
ON p.assigned_to = u.user_no
WHERE project_id = 1;