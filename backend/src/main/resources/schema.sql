CREATE DATABASE IF NOT EXISTS arl_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE USER IF NOT EXISTS 'arl_user'@'localhost' IDENTIFIED BY 'Arl@12345!';
GRANT ALL PRIVILEGES ON arl_db.* TO 'arl_user'@'localhost';
FLUSH PRIVILEGES;

USE arl_db;

CREATE TABLE IF NOT EXISTS books (
    id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    category VARCHAR(100) NOT NULL,
    description TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT pk_books PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Indexes for search performance
CREATE INDEX idx_books_title ON books (title(100));
CREATE INDEX idx_books_author ON books (author(100));
CREATE INDEX idx_books_category ON books (category);