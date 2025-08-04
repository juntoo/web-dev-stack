SELECT * FROM film_text
LIMIT 0, 10;

SELECT count(film_id)/10 FROM film_text;
SELECT count(*) FROM film_text;

CREATE TABLE board (
    no INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    content TEXT,
    url VARCHAR(100),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);
drop table board;
select * from board;

CREATE TABLE user(
	id VARCHAR(50) PRIMARY KEY,
   pwd VARCHAR(100),
   name VARCHAR(100),
   role VARCHAR(20) DEFAULT 'ROLE_USER'
);
DROP TABLE user;
select * from user;