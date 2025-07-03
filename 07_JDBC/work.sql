CREATE TABLE member(
	id VARCHAR(100) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE bank(
	name VARCHAR(100),
    balance INT
);
INSERT INTO bank VALUES('지은', 100000);
INSERT INTO bank VALUES('지연', 0);

UPDATE bank SET balance = 100000 WHERE name = '지은';

SELECT * FROM bank;

CREATE TABLE person(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    age INT,
    addr VARCHAR(200)
);

SELECT * FROM person;

SELECT * FROM person WHERE name = '이승민' AND age = 29 AND addr = '경기';

UPDATE person
SET name = '이승민2', age = 10, addr = '서울'
WHERE id = 1;

DELETE FROM person WHERE id = 1;



CREATE TABLE book(
	book_no INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(50) NOT NULL,
    access_age INT DEFAULT 0
);

CREATE TABLE member(
	id VARCHAR(100) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    pwd VARCHAR(200) NOT NULL,
    age INT NOT NULL
);

CREATE TABLE rent(
	rent_no INT PRIMARY KEY AUTO_INCREMENT,
    id VARCHAR(100),
    book_no INT,
    rent_date DATE DEFAULT (CURRENT_DATE())
);

ALTER TABLE rent ADD
FOREIGN KEY (book_no) REFERENCES book(book_no);
ALTER TABLE rent ADD
FOREIGN KEY (id) REFERENCES member(id);

SELECT * FROM member;

DROP TABLE member;