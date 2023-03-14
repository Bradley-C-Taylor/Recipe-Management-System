DROP TABLE IF EXISTS recipe, ingredient, amount_format, recipe_ingredient;

START TRANSACTION;
--ROLLBACK;
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

COMMIT TRANSACTION;