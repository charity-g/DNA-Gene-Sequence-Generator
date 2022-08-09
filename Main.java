import java.util.Scanner; // Import the Scanner class

class Main {
  public static void main(String[] args) {

    // VARIABLES
    int codonCount = 0;
    boolean running = true;

    // OBJECTS
    Scanner scan = new Scanner(System.in);
    Generator generate = new Generator();

    // METHODS
    // starting?
    System.out.println("\nHello!\nWelcome to the Caterpillar DNA sequence generator! \n\n\t🐛 🐛 🐛 \n\n\n");

    while (running) {
      System.out.println(
          "Please enter the number of codons you would like your DNA gene sequence to have.\nYou may have anywhere from 0 codons to 10 codons.");
      codonCount = scan.nextInt();
      if (codonCount <= 10) {
        generate.genSeq(codonCount);
        System.out.println("The generated sequence is: " + generate.getSeq());
        generate.clearSeq();
      }

    }

  }
}
