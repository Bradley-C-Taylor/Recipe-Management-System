<template>
  <div class="thumbnail-container">
    <recipe-thumbnail
      v-for="recipe in $store.state.recipes"
      :key="recipe.recipeName"
      :recipe="recipe"
    />
  </div>
</template>

<script>
// @ is an alias to /src
import RecipeThumbnail from '@/components/RecipeThumbnail.vue'

export default {
  name: 'AllRecipeView',
  components: {
    RecipeThumbnail
  }
}
</script>

<style scoped>
div.thumbnail-container {
  padding: 0 2rem;
  display: flex;
  justify-content:left;
  gap: 2rem;
}
</style>
