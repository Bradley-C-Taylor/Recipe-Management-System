<template>
  <div id="app">
    <nav>
      <h1>Recipe Manager</h1>
      <ul class="navigation">
        <li><router-link :to="{name: 'all-recipes'}">All Recipes</router-link></li>
        <li><router-link :to="{name: 'single-recipe', params:{id: 1}}">Single Recipe</router-link></li>
      </ul>
    </nav>
    <router-view/>
  </div>
</template>

<style>
:root {
  --primary-fore-color: #fbf2d5;
  --orangey: #fdc57b;
  --primary-back-color: #7fa99b;
  --darky: #394a51;


  --light-blue: #77C9D4;
  --marine: #57BC90;
  --forest: #015249;
  --grey: #A5A5AF;

}

html {
  height:100%;
  background: linear-gradient(-20deg ,var(--light-blue), var(--marine));
  background-repeat: no-repeat;
  background-attachment: fixed;
}
body {
  height: 100%;
  
  margin:0;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: var(--grey);
}

nav {
  display: flex;
  justify-content: space-between;
  background-color: var(--marine);
  padding: 1rem;
  margin: 0 0 .75rem;
  border-bottom: 2px solid var(--forest);
}
h1 {
  color: var(--forest)
}
ul.navigation {
  display: flex;
  justify-content: left;
  gap: 2rem;
  list-style-type: none;
}
li {
  padding: 10px 30px;
  border: 2px solid var(--grey);
  border-radius: 8px;
  background-color: var(--forest);
}

nav a {
  font-weight: bold;
  color: var(--grey);
}
nav a.router-link-exact-active {
  color: var(--grey);
}
</style>
