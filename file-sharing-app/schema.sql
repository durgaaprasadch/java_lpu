-- Create Database
CREATE DATABASE IF NOT EXISTS filesharing_db;
USE filesharing_db;

-- Users Table
CREATE TABLE IF NOT EXISTS users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL DEFAULT 'USER'
);

-- Files Table
CREATE TABLE IF NOT EXISTS files (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    filename VARCHAR(255) NOT NULL,
    file_type VARCHAR(50) NOT NULL,
    size BIGINT NOT NULL,
    file_path VARCHAR(500) NOT NULL,
    uploaded_by BIGINT NOT NULL,
    upload_time DATETIME NOT NULL,
    FOREIGN KEY (uploaded_by) REFERENCES users(id) ON DELETE CASCADE
);

-- Share Tokens Table
CREATE TABLE IF NOT EXISTS share_tokens (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    token VARCHAR(255) NOT NULL UNIQUE,
    file_id BIGINT NOT NULL,
    expiry_time DATETIME NOT NULL,
    created_time DATETIME NOT NULL,
    FOREIGN KEY (file_id) REFERENCES files(id) ON DELETE CASCADE
);

-- Indexes for better query performance
CREATE INDEX idx_email ON users(email);
CREATE INDEX idx_uploaded_by ON files(uploaded_by);
CREATE INDEX idx_token ON share_tokens(token);
CREATE INDEX idx_file_id ON share_tokens(file_id);
