import Vue from 'vue'
import VueRouter from 'vue-router'
import AllRecipeView from '../views/AllRecipeView.vue'
import SingleRecipe from '../views/SingleRecipe.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/all-recipes',
    name: 'all-recipes',
    component: AllRecipeView
  },
  {
    path: '/recipe/:id',
    name: 'single-recipe',
    component: SingleRecipe
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    // component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  // {
  //   path: '*',
  //   name: 'NotFound',
  //   component: NotFound
  // }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
