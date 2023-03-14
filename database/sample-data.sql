SELECT * FROM recipe;
SELECT * FROM ingredient;
SELECT * FROM amount_format;

--PB&J
INSERT INTO recipe (recipeName, directions)
VALUES ('PB and J', 'Spread an even layer of peanut butter on one piece of bread and jelly on another. Combine pieces of bread and enjoy');

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
VALUES (2, 4, 1.0, 2);
INSERT INTO recipe_ingredient(recipeId, ingredientId, ingredientAmount, formatId)
VALUES (2, 5, 1.0, 2);

SELECT ri.ingredientAmount, af.formatType, i.ingredientName
FROM recipe_ingredient ri
JOIN recipe r ON ri.recipeId = r.recipeId
JOIN ingredient i ON ri.ingredientId = i.ingredientId
JOIN amount_format af ON ri.formatId = af.formatId
WHERE r.recipeId = 1;

