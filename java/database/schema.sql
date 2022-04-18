BEGIN TRANSACTION;

DROP TABLE IF EXISTS family;
DROP TABLE IF EXISTS users_books;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	books_completed int,
	pages_read int,
	money_earned float,
	account_type varchar (50),
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE accounts (
	account_id serial,
	account_name varchar(50) NOT NULL UNIQUE,
	account_type varchar(50) NOT NULL,
	user_id int NOT NULL,
	CONSTRAINT PK_account PRIMARY KEY (account_id),
	CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE family (
	family_id serial,
	family_name varchar(50) NOT NULL UNIQUE,
	books_completed int,
	pages_read int,
	money_earned float,
	CONSTRAINT PK_family PRIMARY KEY (family_id)
);

CREATE TABLE users_famiLy (
	family_id int NOT NULL,
	user_id int NOT NULL,
	CONSTRAINT FK_family FOREIGN KEY (family_id) REFERENCES family(family_id),
	CONSTRAINT FK_users FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE books (
	book_id serial,
	author_name varchar(50) NOT NULL UNIQUE,
	title varchar NOT NULL,
	genre varchar NOT NULL,
	isbn_id int NOT NULL,
	CONSTRAINT PK_books PRIMARY KEY (book_id)
);

CREATE TABLE users_books (
	book_id int NOT NULL,
	user_id int NOT NULL,
	CONSTRAINT FK_books FOREIGN KEY (book_id) REFERENCES books(book_id),
	CONSTRAINT FK_users FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE profile (
	favorite_books varchar(50)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION;
