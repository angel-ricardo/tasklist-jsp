CREATE DATABASE tasklist;

USE tasklist;

CREATE TABLE tasks
(
	id INT NOT NULL AUTO_INCREMENT,
	title VARCHAR(255) NOT NULL,
	description TEXT NOT NULL,
	created_at TIMESTAMP default CURRENT_TIME,
	PRIMARY KEY (id)
);
