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
          System.out.println("\nANSWER: 🐛 A DNA strand is actually made of two long chains of nucleotides (which are represented as A, G, T and C)- the coding strand and the template strand.\n\n• Coding strand: the strand that is the actual instructions\n•Template strand: the strand that is not the actual instructions, but the opposite of the coding strand\n\nFor more information, please see this 2 min video: https://www.youtube.com/watch?v=9qyi6xgOjEk");
          break;
        case 2:
          System.out.println("My deepest apologies, but this section is a work in progress. Please pick another option.");
          break;
        case 3:
          System.out.println("My deepest apologies, but this section is a work in progress. Please pick another option.");
          //question.startCheck();
          break;
        default:
          running = false;
          System.out.println("Oops! You probably picked an option that doesn't exist! Please try again by reloading the screen :D");
      }    
    }

  }
}
