DROP TABLE IF EXISTS rms_user, recipe, ingredient, amount_format, recipe_ingredient;

START TRANSACTION;
--ROLLBACK;

CREATE TABLE rms_user (
	userId SERIAL,
	username varchar(50) UNIQUE NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(20),
	CONSTRAINT PK_tenmo_user PRIMARY KEY (userId),
	CONSTRAINT UQ_username UNIQUE (username)
);

CREATE TABLE recipe
(
	recipeId SERIAL,
	recipeName VARCHAR(128) UNIQUE,
	directions VARCHAR(500) NOT NULL,
	
	CONSTRAINT pk_recipeId PRIMARY KEY (recipeId),
	CONSTRAINT chk_name_no_spaces CHECK(recipeName NOT LIKE '% %')
);

CREATE TABLE ingredient
(
	ingredientId SERIAL,
	ingredientName VARCHAR(64) UNIQUE,
	
	CONSTRAINT pk_ingredientId PRIMARY KEY (ingredientId)
);

CREATE TABLE amount_format
(
	formatId SERIAL,
	formatType VARCHAR(16) NOT NULL,
	formatAbbreviation VARCHAR(4),
	
	CONSTRAINT pk_formatId PRIMARY KEY (formatId)
);

CREATE TABLE recipe_ingredient
(
	recipeId INT NOT NULL,
	ingredientId INT NOT NULL,
	ingredientAmount NUMERIC(12,4) NOT NULL,
	formatId INT NOT NULL,
	
	CONSTRAINT pk_recipe_ingredient_id PRIMARY KEY (recipeId, ingredientId),
	CONSTRAINT fk_recipeId FOREIGN KEY (recipeId) REFERENCES recipe(recipeId),
	CONSTRAINT fk_ingredientId FOREIGN KEY (ingredientId) REFERENCES ingredient(ingredientId),
	CONSTRAINT fk_formatId FOREIGN KEY (formatId) REFERENCES amount_format(formatId)
);

--PB&J
INSERT INTO recipe (recipeName, directions)
VALUES ('PBandJ', 'Spread an even layer of peanut butter on one piece of bread and jelly on another. Combine pieces of bread and enjoy');

INSERT INTO ingredient(ingredientName) VALUES ('Slice of bread');
INSERT INTO ingredient(ingredientName) VALUES ('Peanut Butter');
INSERT INTO ingredient(ingredientName) VALUES ('Jelly');

INSERT INTO amount_format (formatType) VALUES ('piece');
INSERT INTO amount_format (formatType, formatAbbreviation) VALUES ('tablespoon', 'tbsp');

INSERT INTO recipe_ingredient(recipeId, ingredientId, ingredientAmount, formatId)
VALUES (1, 1, 2, 1);
INSERT INTO recipe_ingredient(recipeId, ingredientId, ingredientAmount, formatId)
VALUES (1, 2, 2, 2);
INSERT INTO recipe_ingredient(recipeId, ingredientId, ingredientAmount, formatId)
VALUES (1, 3, 2, 2);

--RICE
INSERT INTO recipe (recipeName, directions)
VALUES ('Rice', 'Measure out equal parts rice and water. Cook on high until water begins to boil. Cover and reduce to simmer until water is gone');

INSERT INTO ingredient(ingredientName) VALUES ('Rice');
INSERT INTO ingredient(ingredientName) VALUES ('Water');

INSERT INTO amount_format (formatType) VALUES ('cup');

INSERT INTO recipe_ingredient(recipeId, ingredientId, ingredientAmount, formatId)
VALUES (2, 4, 1, 3);
INSERT INTO recipe_ingredient(recipeId, ingredientId, ingredientAmount, formatId)
VALUES (2, 5, 1, 3);

COMMIT TRANSACTION;