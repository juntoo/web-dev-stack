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

select * from board;