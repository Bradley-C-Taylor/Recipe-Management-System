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