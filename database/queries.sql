SELECT ri.ingredientAmount, af.formatType, i.ingredientName
FROM recipe_ingredient ri
JOIN recipe r ON ri.recipeId = r.recipeId
JOIN ingredient i ON ri.ingredientId = i.ingredientId
JOIN amount_format af ON ri.formatId = af.formatId
WHERE r.recipeName = 'Rice';