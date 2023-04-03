<template>
  <div class="recipe">
      <h2 class="recipe-name">{{recipe.recipeName}}</h2>
      <ul class="ingredient-list">
          <li v-for="ingredient in recipe.ingredients" v-bind:key="ingredient.name">
              {{ingredient.amount}} {{ingredient.name}}
          </li>
      </ul>
        <ol class="direction-list">
          <li v-for="direction in recipe.directions" v-bind:key="direction.process">
              <p class="direction">{{direction.process}}</p>
          </li>
        </ol>
  </div>
</template>

<script>
export default {
    name:"recipe-display",
    props: ["recipe"]
}
</script>

<style scoped>
div.recipe {
    display: flex;
    flex-direction: column;
    align-items: center;
}
li{
    text-align: start;
}
ol.direction-list {
    width: 50%;
}
</style>