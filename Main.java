import java.util.Scanner; // Import the Scanner class

class Main {
  public static void main(String[] args) {

    // VARIABLES
    boolean running = true;

    // OBJECTS
    InputLogistics question = new InputLogistics();

    // METHODS
    // starting
    System.out.println("\nHello!\nWelcome to the Caterpillar DNA sequence generator! \n\n\t🐛 🐛 🐛 \n\n\n");

    while (running) {
      question.ask();
      switch (question.branchChoice) {
        case 1:
          question.startGen();
          break;
        case 12:
          System.out.println("My deepest apologies, but this section is a work in progress. Please pick another option.");
          break;
        case 2:
          System.out.println("My deepest apologies, but this section is a work in progress. Please pick another option.");
          break;
        default:
          running = false;
          System.out.println("Oops! You probably picked an option that doesn't exist! Please try again by reloading the screen :D");
    }      

  }
}
