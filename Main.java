import java.util.Scanner; // Import the Scanner class

class Main {
  public static void main(String[] args) {

    // VARIABLES
    int codonCount = 0;
    

    // OBJECTS
    Scanner scan = new Scanner(System.in);
    Second myObj = new Second();
    myObj.myMethod();
    Third myObj2 = new Third();
    myObj2.myMethod();

    // METHODS
    System.out.println("\nHello!\nWelcome to the Caterpillar DNA sequence generator! \n\t🐛 🐛 🐛 \n\n\n");
    System.out.println(
        "Please enter the number of codons you would like your DNA gene sequence to have.\nYou may have anywhere from 0 codons to 10 codons.");
    codonCount = scan.nextInt();

  }
}
