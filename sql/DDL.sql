-- 회원
DROP TABLE chef cascade constraint;
-- 재료
DROP TABLE ingredient cascade constraint;
-- 조리법
DROP TABLE recipe cascade constraint;

DROP SEQUENCE recipe_id_seq;
DROP SEQUENCE chef_id_seq;
DROP SEQUENCE ingredient_id_seq;

CREATE SEQUENCE chef_id_seq;
CREATE TABLE chef (
       chef_id          	NUMBER(10)  PRIMARY KEY,
       chef_name            VARCHAR2(50) NOT NULL,
       password         	VARCHAR2(40) NOT NULL
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
       recipe_id          	NUMBER(10) PRIMARY KEY,
       ingredient_id		NUMBER(10) NOT NULL,
       food_name      		VARCHAR2(30) NOT NULL,
       direction  			VARCHAR2(300) NOT NULL,
       recipe_owner  		NUMBER(10) default null,
       recipe_like  		NUMBER(10) default 0
);

ALTER TABLE Recipe ADD FOREIGN KEY (ingredient_id) REFERENCES Ingredient (ingredient_id) on delete cascade;
ALTER TABLE Recipe ADD FOREIGN KEY (recipe_owner) REFERENCES Chef (chef_id) on delete set null;


