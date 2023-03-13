package services;

import model.UserCredentials;
import utility.ConsoleColors;
import utility.ErrorLogger;

import java.util.Scanner;

public class ConsoleService {

   private final Scanner scanner = new Scanner(System.in);

   private final String baseUrl;
   private final String HYPHONS = "--------------------------------------------------";

   public ConsoleService(String baseUrl) {
      this.baseUrl = baseUrl;
   }

   public int promptForMenuSelection(String prompt) {
      int selection;
      System.out.print(prompt);
      try {
         selection = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
         ErrorLogger.log(e.getMessage());
         selection = -1;
      }
      return selection;
   }

   public UserCredentials promptForCredentials() {
      String username = promptForString("Username: ");
      String password = promptForString("Password: ");
      return new UserCredentials(username, password);
   }

   public String promptForString(String prompt) {
      System.out.print(prompt);
      return scanner.nextLine();
   }

   public void printIntroduction() {
      System.out.println(HYPHONS);
      System.out.println("|     WELCOME TO THE RECIPE MANAGEMENT SYSTEM    |");
      System.out.println(HYPHONS);
   }

   public void printLoginMenu() {
      System.out.println();
      System.out.println("1: Register");
      System.out.println("2: Login");
      System.out.println("0: Exit");
      System.out.println();
   }

   public void printMainMenu() {
      System.out.println();
      System.out.println("-----MAIN MENU-----");
      System.out.println("[1] View recipes");
      System.out.println("[2] Add a new recipe");
      System.out.println("[3] Create new shopping list");
      System.out.println("[0] Exit");
      System.out.println();
   }

   public void pause() {
      System.out.println("Press Enter to continue...");
      scanner.nextLine();
   }

   public void printError(String message) {
      System.out.print(ConsoleColors.RED_BOLD_BRIGHT);
      System.out.print("ERROR: " + message);
      System.out.println(ConsoleColors.RESET);
   }

}
