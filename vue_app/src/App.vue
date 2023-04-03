<template>
  <div id="app">
    <recipe-thumbnail
      v-for="recipe in $store.state.recipes"
      v-bind:key="recipe.recipeName"
      v-bind:recipe="recipe"
    />
    <!-- <recipe-display
      v-for="recipe in $store.state.recipes"
      v-bind:key="recipe.recipeName"
      v-bind:recipe="recipe"
    /> -->
  </div>
</template>

<script>
import RecipeThumbnail from './components/RecipeThumbnail.vue'
// import RecipeDisplay from './components/RecipeDisplay.vue'

export default {
  name: 'App',
  components: {
    RecipeThumbnail
    // RecipeDisplay
    
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
* {
  /* border: #2c3e50 1px solid; */
}
</style>
