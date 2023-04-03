<template>
  <div class="recipe-thumbnail">
      <h2>{{recipe.recipeName}}</h2>
      <img v-bind:src="getImage">
      <img src="../assets/chicken-al-pastor.png" alt="">
  </div>
</template>

<script>
export default {
    name: "recipe-thumbnail",
    props: ["recipe"],
    computed: {
        getImage() {
            return '../assets/' + this.recipe.picture;
        }
    }
}
</script>

<style>
div.recipe-thumbnail {
    display: flex;
    flex-direction: column;
}
</style>