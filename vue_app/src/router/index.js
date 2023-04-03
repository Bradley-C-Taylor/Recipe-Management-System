import Vue from 'vue'
import VueRouter from 'vue-router'
import AllRecipeView from '../views/AllRecipeView.vue'
import SingleRecipe from '../views/SingleRecipe.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'all-recipes',
    component: AllRecipeView
  },
  {
    path: '/recipe',
    name: 'single-recipe',
    component: SingleRecipe
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    // component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
