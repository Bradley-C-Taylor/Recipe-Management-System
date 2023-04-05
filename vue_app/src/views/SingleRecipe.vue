<template>
  <div class="about">
    <recipe-display/>
      <!-- v-for="recipe in $store.state.recipes"
      :key="recipe.recipeName"
      :recipe="recipe"
    /> -->
  </div>
</template>

<script>
import RecipeDisplay from '@/components/RecipeDisplay.vue'
export default {
  components: { RecipeDisplay },

}
</script>

<style>

</style>
