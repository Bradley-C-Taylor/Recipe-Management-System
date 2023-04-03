import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        recipes: [
            {
                recipeName: "Chicken Al Pastor",
                ingredients: [
                    { amount: "4", name: "dried guajillo chiles" },
                    { amount: "2 tablespoons", name: "achiote paste" },
                    { amount: "6 cloves", name: "garlic" },
                    { amount: "7 ounces", name: "chipotle peppers in adobo" },
                    { amount: "1 1/3 cups", name: "diced onion" },
                    { amount: "2/3 cup", name: "orange juice" },
                    { amount: "3 tablespoons", name: "apple cide vinegar" },
                    { amount: "3 tablespoons", name: "olive oil" },
                    { amount: "1 tablespoon", name: "ground cumin" },
                    { amount: "1 tablespoon", name: "light brown sugar" },
                    { amount: "1 teaspoon", name: "kosher salt" },
                    { amount: "3 pounds", name: "boneless chicken thighs" },
                    { amount: "8", name: "wooden skewers" },
                    { amount: "1", name: "pineapple - peeled, cored, and sliced" },
                    { amount: "20", name: "corn tortillas" }
                ],
                directions: [
                    { process: "Heat a skillet over medium-high heat. Add dried chiles; cook, turning occasionally, until toasted and blistered in spots, 3 to 5 minutes. Add 1 cup water to just cover the chiles, and bring to a simmer over medium-high. Cover and cook, undisturbed, until softened, about 5 minutes. Drain well." },
                    { process: "Combine chiles, achiote, garlic, chipotles, 2/3 cup onion, orange juice, vinegar, oil, cumin, brown sugar, and salt in a blender; process until smooth, about 30 seconds. Reserve 1/2 cup marinade, cover, and refrigerate until ready to use." },
                    { process: "Place remaining marinade in a shallow dish or large resealable plastic bag, add chicken; toss to evenly coat. Cover chicken with plastic wrap, and refrigerate at least 8 hours or up to 24 hours." },
                    { process: "Place wooden skewers in a shallow dish; cover with water by 1 inch. Let stand at room temperature while chicken marinates." },
                    { process: "Preheat the oven to 400 degrees F (200 degrees C). Position oven rack 8 inches away from heating element. Line a small roasting pan or 13- x 9-inch baking dish with aluminum foil." },
                    { process: "Thread 1 pineapple slice onto 2 skewers, being sure to pierce through the center core, (skewers will be about 1 inch apart), leaving a 1 1/2-inch space from end of skewer. Thread 5 to 6 pieces of marinated chicken, stacking on top of pineapple; thread 1 pineapple slice. Repeat process, ending with pineapple slice, until all chicken pieces and pineapple slices are used, making 4 stacks total. Brush with any remaining marinade from chicken." },
                    { process: "Place stacked skewers in the prepared pan, resting skewer ends on edge of pan so that the chicken doesn't touch the bottom of the pan." },
                    { process: "Bake in the preheated oven for 30 minutes. Flip skewers over, brush with reserved 1/2 cup marinade. Bake until chicken is no longer pink in the center and the juices run clear, about 30 minutes longer. An instant-read thermometer inserted into the center should read 160 degrees F (71 degrees C). Increase oven temperature to broil; broil until browned and crispy, 3 to 5 minutes. Flip, and broil until browned and crispy, 3 to 5 minutes." },
                    { process: "Meanwhile, heat a large skillet over high heat. Working two at a time, add tortillas; cook, turning once, until heated and browning in some spots, 1 to 2 minutes per side. Repeat with remaining tortillas." },
                    { process: "Remove chicken and pineapple from skewers, place on cutting board, roughly chop." },
                    { process: "Divide chicken and pineapple between heated tortillas; top with remaining onion and cilantro." }
                ],
                picture: "chicken-al-pastor.png"
            }
        ]
    },
    getters: {
    },
    mutations: {
    },
    actions: {
    },
    modules: {
    }
})
