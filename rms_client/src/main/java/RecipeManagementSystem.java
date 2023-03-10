import services.ConsoleService;
import utility.ErrorLogger;

public class RecipeManagementSystem {

   private static final String API_BASE_URL = "http://localhost:8080/";

   private final ConsoleService consoleService = new ConsoleService(API_BASE_URL);

   public static void main(String[] args) {
      RecipeManagementSystem rms = new RecipeManagementSystem();
      rms.run();
   }
   private void viewRecipes() {

   }
   private void createRecipe() {

   }
   private void createShoppingList() {

   }
   private void run() {
      consoleService.printIntroduction();
      int menuSelection = -1;
      while(menuSelection != 0) {
         consoleService.printMainMenu();
         menuSelection = consoleService.promptForMenuSelection("Please choose an option from inside the brackets: ");
         if(menuSelection == 1) {
            viewRecipes();
         } else if(menuSelection == 2) {
            createRecipe();
         } else if(menuSelection == 3) {
            createShoppingList();
         } else if(menuSelection == 0) {
            System.exit(0);
         } else {
            consoleService.printError("Invalid Selection");
         }
         consoleService.pause();
      }
   }
}
