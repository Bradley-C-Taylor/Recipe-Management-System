import model.AuthenticatedUser;
import model.UserCredentials;
import services.AuthenticationService;
import services.ConsoleService;
import utility.ErrorLogger;

public class RecipeManagementSystem {

   private static final String API_BASE_URL = "http://localhost:8080/";

   private final ConsoleService consoleService = new ConsoleService(API_BASE_URL);
   private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);

   private AuthenticatedUser currentUser;

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

   private void loginMenu() {
      int menuSelection = -1;
      while (menuSelection != 0 && currentUser == null) {
         consoleService.printLoginMenu();
         menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
         if (menuSelection == 1) {
            handleRegister();
         } else if (menuSelection == 2) {
            handleLogin();
         } else if (menuSelection != 0) {
            System.out.println("Invalid Selection");
            consoleService.pause();
         } else if (menuSelection == 0) {
            System.exit(0);
         }
      }
   }

   private void mainMenu() {
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

   private void handleRegister() {
      System.out.println("Please register a new user account");
      UserCredentials credentials = consoleService.promptForCredentials();
      if (authenticationService.register(credentials)) {
         System.out.println("Registration successful. You can now login.");
      } else {
         consoleService.printError("Registration Unsuccessful");
      }
   }

   private void handleLogin() {
      UserCredentials credentials = consoleService.promptForCredentials();
      currentUser = authenticationService.login(credentials);
      if (currentUser == null) {
         consoleService.printError("Login Unsuccessful");
      }
   }
   private void run() {
      consoleService.printIntroduction();
      loginMenu();
      if (currentUser != null) {
         mainMenu();
      }
   }
}
