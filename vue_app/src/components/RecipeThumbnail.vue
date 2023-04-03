<template>
  <div class="recipe-thumbnail">
      <p>{{recipe.recipeName}}</p>
      <img v-bind:src="getImgUrl(recipe.picture)">
  </div>
</template>

<script>
export default {
    name: "recipe-thumbnail",
    props: ["recipe"],
    computed: {},
    methods: {
        getImgUrl(imgName) {
            return require('../assets/' + imgName);
        }
    }
}
</script>

<style scoped>
div.recipe-thumbnail {
    display: flex;
    flex-direction: column;
    width: 200px;
    background-color: rgb(168, 168, 168);
    border-radius: 10px;
}
p {
    margin: 5px;
    color: rgb(26, 26, 70);
    font-weight: 600;
}
img {
    border-radius: 10px;
}
</style>