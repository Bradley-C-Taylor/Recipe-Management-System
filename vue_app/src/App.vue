<template>
  <div id="app">
    <nav>
      <ul class="navigation">
        <li><router-link to="/">All Recipes</router-link></li>
        <li><router-link to="/recipe">Single Recipe</router-link></li>
      </ul>
    </nav>
    <!-- <nav>
      <router-link to="/">All Recipes</router-link> |
      <router-link to="/recipe">Single Recipe</router-link>
    </nav> -->
    <router-view/>
  </div>
</template>

<style>
:root {
  --primary-fore-color: #fbf2d5;
  --orangey: #fdc57b;
  --primary-back-color: #7fa99b;
  --darky: #394a51;

}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  background-color: var(--primary-back-color);
  color: var(--primary-fore-color);
}

nav {
  padding: 1.5rem;
  background-color: var(--orangey);
}
ul.navigation {
  display: flex;
  justify-content: left;
  gap: 2rem;
  list-style-type: none;
}
li {
  padding: 8px;
  background-color: var(--primary-back-color);
}

nav a {
  font-weight: bold;
  color: var(--darky);
}

nav a.router-link-exact-active {
  color: var(--greeny);
}
</style>
