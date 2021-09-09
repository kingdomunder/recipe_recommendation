-- 회원
DROP TABLE chef cascade constraint;

-- 재료
DROP TABLE ingredient cascade constraint;

-- 조리법
DROP TABLE recipe cascade constraint;

DROP SEQUENCE chef_id_seq;
DROP SEQUENCE ingredient_id_seq;
DROP SEQUENCE recipe_id_seq;

CREATE SEQUENCE chef_id_seq;
CREATE TABLE chef (
       chef_id          	NUMBER(10)  PRIMARY KEY,
       chef_name            VARCHAR2(40) NOT NULL,
       password         	VARCHAR2(40) NOT NULL,
       password2         	VARCHAR2(40) NOT NULL
);

CREATE SEQUENCE ingredient_id_seq;
CREATE TABLE ingredient (
	   ingredient_id        NUMBER(10) PRIMARY KEY,
       ingredient1			VARCHAR2(50) default null,
       ingredient2			VARCHAR2(50) default null,
       ingredient3			VARCHAR2(50) default null,
       ingredient4			VARCHAR2(50) default null,
       ingredient5			VARCHAR2(50) default null
);

CREATE SEQUENCE recipe_id_seq;
CREATE TABLE recipe (	
	   recipe_id			NUMBER(10) PRIMARY KEY,
       ingredient_id        NUMBER(10) NOT NULL,
       food_name      		VARCHAR2(30) NOT NULL,
       direction  			VARCHAR2(500) NOT NULL,
       recipe_owner  		NUMBER(10) default 0,
       recipe_like  		NUMBER(10) default 0,
       img_path				VARCHAR2(30) NOT NULL
);


ALTER TABLE recipe ADD FOREIGN KEY (ingredient_id) REFERENCES ingredient (ingredient_id) on delete cascade;
ALTER TABLE recipe ADD FOREIGN KEY (recipe_owner) REFERENCES chef (chef_id) on delete set null;