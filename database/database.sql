CREATE TABLE students (id BIGSERIAL PRIMARY KEY,name VARCHAR(100) NOT NULL,email VARCHAR(150) UNIQUE NOT NULL,
age INT NOT NULL CHECK (age > 0)
);

INSERT INTO students (name, email, age) VALUES
('Ahmad', 'ahmad@example.com', 22),
('Sara', 'sara@example.com', 21),
('Omar', 'omar@example.com', 23);